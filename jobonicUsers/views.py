from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework.renderers import JSONRenderer
from rest_framework.parsers import JSONParser

from jobonicUsers.models import User, LoginSession, UserProfile, Education, WorkExperience, OtherQualification
from jobonicUsers.serializers import UserSerializer, LoginSessionSerializer, UserProfileSerializer, EducationSerializer, \
    WorkExperienceSerializer, OtherQualificationSerializer

from blocks import auth, moments
from blocks.formatter import pack


@csrf_exempt
def user_list(request):
    """
    List all users
    """

    if request.method == "GET":
        users = User.objects.all()
        serializer = UserSerializer(users, many=True)
        return JsonResponse(pack(serializer.data), safe=False)

    elif request.method == 'POST':
        data = JSONParser().parse(request)
        data['salt'] = auth.generate_str(32)
        data['password'] = auth.hash_password(data['salt'], data['password'])
        data['created'] = moments.now()
        serializer = UserSerializer(data=data)

        if serializer.is_valid():
            serializer.save()
            return JsonResponse(pack(serializer.data), status=201)
        return JsonResponse(pack(serializer.errors, False, "Unable to save the User"), status=200)


@csrf_exempt
def user_details(request, pk):
    """
    Retrieve, Update and Delete
    """
    try:
        user = User.objects.get(pk=pk)
    except User.DoesNotExist:
        return JsonResponse(pack({}, False, "User does not exist"))

    if request.method == "GET":
        serializer = UserSerializer(user)
        return JsonResponse(pack(serializer.data), status=201)

    elif request.method == 'PUT':
        data = JSONParser().parse(request)
        serializer = UserSerializer(user, data=data)

        if serializer.is_valid():
            serializer.save()
            return JsonResponse(pack(serializer.data, True, "Update successful"), status=201)
        return JsonResponse(pack(serializer.errors, False, "Unable to update user"), status=400)

    elif request.method == 'DELETE':
        user.delete()
        return JsonResponse(pack({}, True, "Delete Successful"))


@csrf_exempt
def new_linkedin_user(request):
    if request.method == 'POST':
        # Linked In Code
        data = JSONParser().parse(request)
        user_data = {
            "first_name": data['firstName'],
            "last_name": data['lastName'],
            "user_name": data['id'],
            "linked_in_uid": data['id'],
            "email_address": data['emailAddress'],
            "password": data['id'],
        }

        user_data['salt'] = auth.generate_str(32)
        user_data['password'] = auth.hash_password(user_data['salt'], user_data['password'])
        serializer = UserSerializer(data=user_data)

        if serializer.is_valid():
            serializer.save()
            # save the user profile basic info - country, headline, pictureurl, linked_in url
            user_profile = {
                'user_title': data['headline'],
                'social_linkedin': data['publicProfileUrl'],
                'profile_picture': data['pictureUrl'],
                'country': data['location']['name'],
                'user_id': serializer.data['id']
            }
            new_user_serializer = UserProfileSerializer(data=user_profile)
            if new_user_serializer.is_valid():
                new_user_serializer.save()
                return JsonResponse(pack(serializer.data, True, "User Updated Successfully"), status=201)
            else:
                return JsonResponse(pack(new_user_serializer.errors, False, "Unable to save User"))
        else:
            return JsonResponse(pack(serializer.errors, False, "Error in data receieved"), status=400)


@csrf_exempt
def login_with_linkedin(request):
    """
    Login user with Linked In
    :param request:
    :return:
    """
    if request.method == "POST":
        data = JSONParser().parse(request)

        email_address = data['emailAddress']
        password = data['id']

        try:
            user = User.objects.get(email_address=email_address)
            stored_pass = user.password
            stored_salt = user.salt
            unhash = auth.unhash_password(stored_salt, password, stored_pass)
            if unhash:
                new_session = LoginSession(user_id=user, created=moments.now(), expire=moments.now() + 3600)
                sess = LoginSessionSerializer(new_session)
                data = sess.data
                data['user_type'] = user.user_type
                return JsonResponse(pack(data), safe=False)
            else:
                return JsonResponse(pack({}, False, "Invalid Credentials"), status=404)


        except User.DoesNotExist:
            return JsonResponse(pack({}, False, "Account does not exist"))


@csrf_exempt
def user_login(request):
    if request.method == 'POST':
        data = JSONParser().parse(request)
        try:
            user = User.objects.get(email_address=data['email_address'])
        except User.DoesNotExist:
            return JsonResponse(pack({}, False, "Invalid Credentials"), status=200)

        stored_pass = user.password
        stored_salt = user.salt

        unhash = auth.unhash_password(stored_salt, data['password'], stored_pass)
        if unhash:
            new_session = LoginSession(user_id=user, created=moments.now(), expire=moments.now() + 3600)
            sess = LoginSessionSerializer(new_session)
            data = sess.data
            data['user_type'] = user.user_type
            return JsonResponse(pack(data), safe=False)
        else:
            return JsonResponse(pack({}, False, "Invalid Credentials"), status=200)


@csrf_exempt
def add_new_profile(request):
    if request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = UserProfileSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(pack(serializer.data), status=200)
        return JsonResponse(pack(serializer.errors, False, 'Unable to save the profile'), status=200)


@csrf_exempt
def user_profile(request, pk):
    try:
        user = UserProfile.objects.get(user_id=pk)
    except UserProfile.DoesNotExist:
        return JsonResponse(pack({}, False, "User Profile does not exist"))

    if request.method == 'GET':
        user_serializers = UserProfileSerializer(user)
        return JsonResponse(pack(user_serializers.data))

    elif request.method == 'PUT':
        data = JSONParser().parse(request)
        user_serializer = UserProfileSerializer(user, data=data)
        if user_serializer.is_valid():
            user_serializer.save()
            return JsonResponse(pack(user_serializer.data), status=201)
        return JsonResponse(pack(user_serializer.errors, False, "Unable to edit user"), status=200)

@csrf_exempt
def user_education(request, pk):
    try:
        education = Education.objects.filter(user_id=pk)
    except Education.DoesNotExist:
        return JsonResponse(pack({}, False, "User has no Education Set"))

    if request.method == 'GET':
        education_serializer = EducationSerializer(education, many=True)
        return JsonResponse(pack(education_serializer.data), status=200)

    elif request.method == 'POST':
        data = JSONParser().parse(request)
        data['user_id'] = pk





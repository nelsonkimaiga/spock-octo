from rest_framework import serializers
from jobonicUsers.models import User, UserProfile, LoginSession, Education, WorkExperience, OtherQualification


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = (
            'id', 'first_name', 'middle_name', 'last_name', 'email_address', 'user_name', 'salt', 'password',
            'date_created',
            'active', 'update_history', 'linked_in_uid', 'user_type')


class LoginSessionSerializer(serializers.ModelSerializer):
    class Meta:
        model = LoginSession
        fields = ('id', 'user_id', 'session_key', 'created', 'expire')


class UserProfileSerializer(serializers.ModelSerializer):
    class Meta:
        model = UserProfile
        fields = (
            'id', 'user_id', 'user_title', 'phone', 'social_facebook', 'social_twitter', 'social_linkedin',
            'social_instagram', 'website',
            'address', 'marital_status', 'date_of_birth', 'gender', 'languages', 'country', 'personal_statement',
            'profile_picture', 'date_created', 'update_history')


class EducationSerializer(serializers.ModelSerializer):
    class Meta:
        model = Education
        fields = ('id', 'user_id', 'course_name', 'school', 'certification', 'start_date', 'end_date', 'current_level',
                  'description', 'update_history')


class WorkExperienceSerializer(serializers.ModelSerializer):
    class Meta:
        model = WorkExperience
        fields = ('id', 'user_id', 'job_title', 'company', 'start_date', 'end_date', 'current_job', 'description',
                  'update_history')


class OtherQualificationSerializer(serializers.ModelSerializer):
    class Meta:
        model = OtherQualification
        fields = ('id', 'user_id', 'qualification_title', 'place_acquired', 'start_date', 'end_date', 'description',
                  'update_history')

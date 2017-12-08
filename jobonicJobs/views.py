from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework.renderers import JSONRenderer
from rest_framework.parsers import JSONParser

from jobonicJobs.models import *
from jobonicJobs.serializers import *

from blocks import auth, moments
from blocks.formatter import pack



def job_list(request):
    jobs = Job.objects.all()
    job_serializer = JobSerializer(jobs, many=True)
    # return JsonResponse(pack(job_serializer.data), safe=False)
    return JsonResponse(job_serializer.data, safe=False)
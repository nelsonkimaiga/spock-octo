from rest_framework import serializers

from jobonicJobs.models import Job

class JobSerializer (serializers.ModelSerializer):
    class Meta:
        model = Job
        fields = ('id', 'title', 'url', 'location', 'job_type', 'salary', 'posted', 'company_logo', 'company_link', 'company_name', 'job_function', 'description', 'open')
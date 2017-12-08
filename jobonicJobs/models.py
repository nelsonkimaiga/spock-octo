import uuid

from django.db import models


# Create your models here.

class Job(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    title = models.CharField(max_length=250, null=False, blank=False)
    url = models.URLField(max_length=250, null=False, blank=False)
    location = models.URLField(max_length=250, null=False, blank=False)
    job_type = models.URLField(max_length=250, null=False, blank=False)
    salary = models.URLField(max_length=250, null=False, blank=False)
    posted = models.URLField(max_length=250, null=False, blank=False)
    company_logo = models.URLField(max_length=250, null=False, blank=False)
    company_link = models.URLField(max_length=250, null=False, blank=False)
    company_name = models.URLField(max_length=250, null=False, blank=False)
    job_function = models.URLField(max_length=250, null=False, blank=False)
    description = models.URLField(max_length=250, null=False, blank=False)
    open = models.BooleanField(default=True)

    class Meta:
        ordering = ('title',)

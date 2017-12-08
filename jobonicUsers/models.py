import uuid

from django.db import models
from django.utils.timezone import now


# Create your models here.

class User(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    first_name = models.CharField(max_length=200, blank=False, unique=False)
    middle_name = models.CharField(max_length=200, blank=True)
    last_name = models.CharField(max_length=200, blank=False, unique=False)
    user_name = models.CharField(max_length=200, unique=False, blank=True, null=True, default='')
    email_address = models.CharField(max_length=200, blank=False, default='', unique=True)
    salt = models.CharField(max_length=200, unique=False, blank=False)
    password = models.CharField(max_length=200, unique=False, blank=True, null=True, default='')
    date_created = models.DateTimeField(default=now)
    active = models.BooleanField(default=True)
    user_type = models.CharField(max_length=50, blank=False, null=False, default='jobseeker')
    update_history = models.TextField(null=True, blank=True, default='')
    # global_login_key = models.CharField(max_length=500, null=True, blank=True, default='')
    linked_in_uid = models.CharField(max_length=100, null=True, blank=True, default='')

    class Meta:
        ordering = ('date_created',)


class LoginSession(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    user_id = models.ForeignKey('User', on_delete=models.CASCADE)
    session_key = models.CharField(max_length=200, default=uuid.uuid4, editable=False)
    created = models.IntegerField(default=0)
    expire = models.IntegerField(default=0)

    class Meta:
        ordering = ('created',)


class UserProfile(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    user_id = models.ForeignKey('User', on_delete=models.CASCADE)
    user_title = models.CharField(max_length=250, null=True)
    phone = models.CharField(max_length=20, null=True, blank=True, unique=True)
    social_facebook = models.URLField(max_length=150, null=True, blank=True, default='')
    social_twitter = models.URLField(max_length=150, null=True, blank=True, default='')
    social_linkedin = models.URLField(max_length=150, null=True, blank=True, default='')
    social_instagram = models.URLField(max_length=150, null=True, blank=True, default='')
    website = models.URLField(max_length=100, null=True, blank=True, default='')
    address = models.CharField(max_length=150, null=True, blank=True, unique=False, default='')
    marital_status = models.CharField(max_length=50, null=True, blank=True, default='')
    date_of_birth = models.DateTimeField(null=True)
    gender = models.CharField(max_length=20, null=True, blank=True, default='Other')
    languages = models.CharField(max_length=250, null=True, blank=True, default='English')
    country = models.CharField(default='Kenya', max_length=50, blank=True, null=True)
    personal_statement = models.TextField(null=True, blank=True, default='')
    profile_picture = models.CharField(max_length=250, blank=True, null=True, default='')
    date_created = models.DateTimeField(default=now)
    update_history = models.TextField(null=True, blank=True, default='')

    class Meta:
        ordering = ('user_title',)


class Education(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    user_id = models.ForeignKey('User', on_delete=models.CASCADE)
    course_name = models.CharField(max_length=250, blank=False, null=False, default='Course Title')
    school = models.CharField(max_length=200, blank=False, null=False)
    certification = models.CharField(max_length=100, default='Certificate')
    start_date = models.DateTimeField()
    end_date = models.DateTimeField()
    current_level = models.BooleanField(default=True)
    description = models.TextField(null=True, blank=True, default='')
    update_history = models.TextField(null=True, blank=True, default='')

    class Meta:
        ordering = ('user_id',)


class WorkExperience(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    user_id = models.ForeignKey('User', on_delete=models.CASCADE)
    job_title = models.CharField(max_length=250, null=False, blank=False)
    company = models.CharField(max_length=250, null=False, blank=False)
    start_date = models.DateTimeField()
    end_date = models.DateTimeField()
    current_job = models.BooleanField(default=True)
    description = models.TextField(null=True, blank=True, default='')
    update_history = models.TextField(null=True, blank=True, default='')

    class Meta:
        ordering = ('user_id',)


class OtherQualification(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    user_id = models.ForeignKey('User', on_delete=models.CASCADE)
    qualification_title = models.CharField(max_length=250, null=False, blank=False)
    place_acquired = models.CharField(max_length=250, null=False, blank=False)
    start_date = models.DateTimeField()
    end_date = models.DateTimeField()
    description = models.TextField(null=True, blank=True)
    update_history = models.TextField(null=True, blank=True, default='')

    class Meta:
        ordering = ('user_id',)

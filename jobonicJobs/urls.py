from django.conf.urls import url
from jobonicJobs import views

urlpatterns = [
    url(r'^list/$', views.job_list),
]

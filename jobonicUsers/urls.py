from django.conf.urls import url
from jobonicUsers import views

urlpatterns = [
    url(r'^users/$', views.user_list),
    url(r'^users/login/$', views.user_login),
    url(r'^users/new-linkedin-user/$', views.new_linkedin_user),
    url(r'^users/login-with-linkedin/$', views.login_with_linkedin),
    url(r'^users/new-profile/$', views.add_new_profile),
    url(r'^users/profile/education/(?P<pk>[0-9a-z-]+)/$', views.user_education),
    url(r'^users/profile/(?P<pk>[0-9a-z-]+)/$', views.user_profile),
    url(r'^users/(?P<pk>[0-9a-z-]+)/$', views.user_details),
]

# API Documentations
URL : https://jobonic.herokuapp.com/
SUPPORTED Requests
- GET
- POST
- PUT
- DELETE

When sending POST, DELETE or PUT requests, always remember to finish your URL endpoint with a /

All responses from the server come in the following JSON format
```json
{
    "data" : {data object},
    "success" : boolean,
    "message" : string
}
```
It is advisable to check the ```success``` value first. If it is *false*, the generic error message will be in ```message``` and the specific errors in the ```data``` object. If ```success``` is true, then the request was successful and the data is in the ```data``` object.

# Registering a User
## With email and Password
Send a POST request to /users/ with the following JSON payload
```json
{
    "first_name" : "First",
    "last_name" : "Last",
    "email_address" : "email@example.com",
    "password" : "Password"
}
```
Successful Response : 
```json
{
    "data": {
        "id": "f3d1cf3a-9d0f-4e71-9490-a20ad72a9564",
        "first_name": "First",
        "middle_name": "",
        "last_name": "Last",
        "email_address": "email@example.com",
        "user_name": "",
        "salt": "CnASzRKeCIytqcylgLFCvnBVAawFisjA",
        "password": "$pbkdf2-sha256$200000$.B9DyLkXwtj7f6/1HmOMEaLUmjPmHAMgBOB8rzXmHAM$LTk.6fnCkdQJj1r/NO83xKdX5FJD1iXTPHYqCw9fhKE",
        "date_created": "2017-11-26T05:53:00.991545Z",
        "active": true,
        "update_history": "",
        "linked_in_uid": "",
        "user_type": "jobseeker"
    },
    "success": true,
    "message": "OK"
}
```
Duplicate Account Creation
```
json
{
    "data": {
        "email_address": [
            "user with this email address already exists."
        ]
    },
    "success": false,
    "message": "Unable to save the User"
}
```

Wrong payload given, eg ```first_name``` missing from the request and the email is already existing in the database
```json
{
    "data": {
        "first_name": [
            "This field is required."
        ],
        "email_address": [
            "user with this email address already exists."
        ]
    },
    "success": false,
    "message": "Unable to save the User"
}
```

## With LinkedIn Account
Once you get the Linkedin Payload send it as a JSON object to */users/new-linkedin-user/* as a *POST* request

The JSON payload sent (from LinkedIn)
```json
{
	"_key": "~",
	"emailAddress": "samsonrapando@gmail.com",
	"firstName": "Samson",
	"headline": "Intern Software Developer at USAID Health IT Project at University of Nairobi",
	"id": "wp7uunLW0B",
	"lastName": "Rapando",
	"location": {
		"country": {
			"code": "ke"
		},
		"name": "Kenya"
	},
	"pictureUrl": "https://media.licdn.com/mpr/mprx/0_1J2xFl_b9WcySruWzjZAiPEbPVn7ah8eJJNAGXgbt7UawrAWMJZOE5dQvUy7wl_eKfZxdl66xxomHXnq0Ed_f5woVxofHXveJEdyXkYFAY0_G-mqvRx-krK9sor0TXGMKdSP_sf9Azo",
	"publicProfileUrl": "https://www.linkedin.com/in/samson-rapando-5a273486"
}
```

Successful response
```json
{
    "data": {
        "id": "7e93db29-0b09-47e5-acfa-3ddc95fa9a1b",
        "first_name": "Samson",
        "middle_name": "",
        "last_name": "Rapando",
        "email_address": "samsonrapando@gmail.com",
        "user_name": "wp7uunLW0B",
        "salt": "UReOmdHSXJFVJSWnQpjeulKDSJULHgDi",
        "password": "$pbkdf2-sha256$200000$WktpDWEMYSylNCbEuDcmZOxdC0FIyTknZGxtDYEwRug$87.OZ.9PT.hULo10VkeYrPBNMSWS3WL2/atZ1Ejx3Qg",
        "date_created": "2017-11-26T06:00:16.168257Z",
        "active": true,
        "update_history": "",
        "linked_in_uid": "wp7uunLW0B",
        "user_type": "jobseeker"
    },
    "success": true,
    "message": "User Updated Successfully"
}
```
Notice it is the same as the successful user creation message, only that it contains the user name, which is the LinkedIn id

Unsuccessful responses are the same as the ones for creating a user with email address and password

## Login with email and password
Send a *POST* request to */users/login* with a JSON payload
```json
{
    "email_address" : "email@example.com",
    "password" : "Password"
}
```
Successful response with right credentials returns a JSON response with the session key data
```json
{
    "data": {
        "id": "c6ee8858-8e0f-42ed-b9ce-54028f455c7c",
        "user_id": "f3d1cf3a-9d0f-4e71-9490-a20ad72a9564",
        "session_key": "8763c5ac-c4f6-4db2-ad77-99d07e650324",
        "created": 1511676200,
        "expire": 1511679800,
        "user_type": "jobseeker"
    },
    "success": true,
    "message": "OK"
}
```

Response for invalid login. It might be for a non-existing email or a wrong email and password combination
```json
{
    "data": {},
    "success": false,
    "message": "Invalid Credentials"
}
```

## Login with LinkedIn
To login with LinkedIn, send the JSON payload from LinkedIn to */users/login-with-linkedin/*
```json
{
	"_key": "~",
	"emailAddress": "samsonrapando@gmail.com",
	"firstName": "Samson",
	"headline": "Intern Software Developer at USAID Health IT Project at University of Nairobi",
	"id": "wp7uunLW0B",
	"lastName": "Rapando",
	"location": {
		"country": {
			"code": "ke"
		},
		"name": "Kenya"
	},
	"pictureUrl": "https://media.licdn.com/mpr/mprx/0_1J2xFl_b9WcySruWzjZAiPEbPVn7ah8eJJNAGXgbt7UawrAWMJZOE5dQvUy7wl_eKfZxdl66xxomHXnq0Ed_f5woVxofHXveJEdyXkYFAY0_G-mqvRx-krK9sor0TXGMKdSP_sf9Azo",
	"publicProfileUrl": "https://www.linkedin.com/in/samson-rapando-5a273486"
}
```

The responses are the same as those for logging in with *email_address* and *password*

---
---

## Updating a User Profile.

This is the structure of the ```UserProfile``` model
```py
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
    date_of_birth = models.DateTimeField(default=now)
    gender = models.CharField(max_length=20, null=True, blank=True, default='Other')
    languages = models.CharField(max_length=250, null=True, blank=True, default='English')
    country = models.CharField(default='Kenya', max_length=50, blank=True, null=True)
    personal_statement = models.TextField(null=True, blank=True, default='')
    profile_picture = models.CharField(max_length=250, blank=True, null=True, default='')
    date_created = models.DateTimeField(default=now)
    update_history = models.TextField(null=True, blank=True, default='')
```
When a user signs up with LinkedIn, the following fields are filled for their profile
```
user_title
social_linkedin
country
profile_picture
```
When creating a user with their own details (first name, last name etc) this model is not filled and has to be filled later.

## Fetch a List of users
Send a GET request to */users/*
Sample response
```json
{
    "data": [
        {
            "id": "6c4108d5-65ef-4cb5-a822-407d245ae780",
            "first_name": "Samson",
            "middle_name": "",
            "last_name": "Rapando",
            "email_address": "samsonrapando_@gmail.com",
            "user_name": "wp7uunLW0B",
            "salt": "KfqUWhtZhzqobSTYJhQhJRShqgynVGia",
            "password": "$pbkdf2-sha256$200000$VQoh5ByDsNZa6z0HAKD0nnMuRYixdo7Rute6V0oppbQ$5EOK3Gzv1kORvEPsuEy43ws4h5M0kY19brypHHmY/s0",
            "date_created": "2017-11-26T05:41:43.455057Z",
            "active": true,
            "update_history": "",
            "linked_in_uid": "wp7uunLW0B",
            "user_type": "jobseeker"
        },
        {
            "id": "4abca1c5-812c-44ca-a83f-79553e394cd9",
            "first_name": "xy",
            "middle_name": "",
            "last_name": "yx",
            "email_address": "xy@gmail.com",
            "user_name": "",
            "salt": "uOOOkehrKNPVjtLqcbsCJBsVdONCtZOv",
            "password": "$pbkdf2-sha256$200000$QMjZ21vrPUcIAWAM4Rxj7J0zBqB0LoVQam3tvVfKufc$YjizdYkIKw0G/0nrS1US9Y0vO4WSb.h4QtZQ61MEEIk",
            "date_created": "2017-11-26T05:42:35.810747Z",
            "active": true,
            "update_history": "",
            "linked_in_uid": "",
            "user_type": "jobseeker"
        }
    ], 
    "success": true,
    "message": "OK"
}

```

## Fetch a single User
Send a GET Request to */users/id*
Sample request : */users/ae6ffb83-7f1b-4c7a-9078-7ff37761ba3e*
Response:
```json
{
    "data": {
        "id": "ae6ffb83-7f1b-4c7a-9078-7ff37761ba3e",
        "first_name": "Samson",
        "middle_name": "",
        "last_name": "Rapando",
        "email_address": "samsonrapandop__@gmail.com",
        "user_name": "wp7uunLW0B",
        "salt": "QmLbRBCgzsSurwPjlloWcjgRsqHYSGVP",
        "password": "$pbkdf2-sha256$200000$EAIgxPg/hxBCKOV8b.197/3fuxcCwFhrjZGSMgZAqDU$rgKb9YyV/8ktM0noXW0SvblC8ZmnkeXOye7Z./adOmM",
        "date_created": "2017-11-26T06:15:40.332618Z",
        "active": true,
        "update_history": "",
        "linked_in_uid": "wp7uunLW0B",
        "user_type": "jobseeker"
    },
    "success": true,
    "message": "OK"
}
```

## Deleting a user
Send a DELETE request to */users/id/*
Sample response
```json
{
    "data": {},
    "success": true,
    "message": "Delete Successful"
}
```

Unsuccessful response
```json
{
    "data": {},
    "success": false,
    "message": "User does not exist"
}
```

## Update a user
Send a PUT request to */users/id/* with a JSON payload with the details you want to update eg
*/users/4abca1c5-812c-44ca-a83f-79553e394cd9/. Make sure to send the whole user details in a json object because it replaces the fields given

Sample payload
```json
{
"id": "20d86a3e-2b7e-4707-b8e3-e925ec525333",
        "first_name": "Samson",
        "middle_name": "Chitechi",
        "last_name": "Rapando",
        "email_address": "samsonrapando@gmail.com",
        "user_name": "wp7uunLW0B",
        "salt": "OUXlLnislToqJSnIKjmTSbqmrHctlRxn",
        "password": "$pbkdf2-sha256$200000$pTRmjDGm1BojRIix1jpHCIFwznmvVYrRmpMy5hzjPGc$XpHaUZQkw/cJhyrbVjFSbskF8M0qVMZV40T/4Q./XMo",
        "date_created": "2017-11-26T11:24:08.988282Z",
        "active": true,
        "update_history": "",
        "linked_in_uid": "wp7uunLW0B",
        "user_type": "jobseeker"
}
```

Sample response
```json
{
    "data": {
        "id": "20d86a3e-2b7e-4707-b8e3-e925ec525333",
        "first_name": "Samson",
        "middle_name": "Chitechi",
        "last_name": "Rapando",
        "email_address": "samsonrapando@gmail.com",
        "user_name": "wp7uunLW0B",
        "salt": "OUXlLnislToqJSnIKjmTSbqmrHctlRxn",
        "password": "$pbkdf2-sha256$200000$pTRmjDGm1BojRIix1jpHCIFwznmvVYrRmpMy5hzjPGc$XpHaUZQkw/cJhyrbVjFSbskF8M0qVMZV40T/4Q./XMo",
        "date_created": "2017-11-26T11:24:08.988282Z",
        "active": true,
        "update_history": "",
        "linked_in_uid": "wp7uunLW0B",
        "user_type": "jobseeker"
    },
    "success": true,
    "message": "Update successful"
}
```


---
---

## Fetching a User Profile
Send a GET request to */users/profile/profile-id*
Example

A get request to */users/profile/20d86a3e-2b7e-4707-b8e3-e925ec525333/*

Response:
```json
{
    "data": {
        "id": "3873b917-903c-4663-b528-abacbac576d2",
        "user_id": "20d86a3e-2b7e-4707-b8e3-e925ec525333",
        "user_title": "Intern Software Developer at USAID Health IT Project at University of Nairobi",
        "phone": null,
        "social_facebook": "",
        "social_twitter": "",
        "social_linkedin": "https://www.linkedin.com/in/samson-rapando-5a273486",
        "social_instagram": "",
        "website": "",
        "address": "",
        "marital_status": "",
        "date_of_birth": "2017-11-26T11:24:09.146699Z",
        "gender": "Other",
        "languages": "English",
        "country": "Kenya",
        "personal_statement": "",
        "profile_picture": "https://media.licdn.com/mpr/mprx/0_1J2xFl_b9WcySruWzjZAiPEbPVn7ah8eJJNAGXgbt7UawrAWMJZOE5dQvUy7wl_eKfZxdl66xxomHXnq0Ed_f5woVxofHXveJEdyXkYFAY0_G-mqvRx-krK9sor0TXGMKdSP_sf9Azo",
        "date_created": "2017-11-26T11:24:09.146699Z",
        "update_history": ""
    },
    "success": true,
    "message": "OK"
}
```

## Updating a User Profile
Send a PUT request to the same URL as above. Remember to include all the fields in the response above as payload. This is because a ```PUT``` request replaces all fields in the model.

Sample payload:
```json
{
	"id": "3873b917-903c-4663-b528-abacbac576d2",
        "user_id": "20d86a3e-2b7e-4707-b8e3-e925ec525333",
        "user_title": "Intern Software Developer at USAID Health IT Project at University of Nairobi",
        "phone": "+254720735121",
        "social_facebook": "https://facebook.com/samy.raps",
        "social_twitter": "https://twitter.com/samy_raps",
        "social_linkedin": "https://www.linkedin.com/in/samson-rapando-5a273486",
        "social_instagram": "https://instagram.com/samy_raps",
        "website": "https://jobonics.com",
        "address": "1355-00518 Nairobi Kenya",
        "marital_status": "Single",
        "date_of_birth": "2017-11-26T11:24:09.146699Z",
        "gender": "Other",
        "languages": "English",
        "country": "Kenya",
        "personal_statement": "",
        "profile_picture": "https://media.licdn.com/mpr/mprx/0_1J2xFl_b9WcySruWzjZAiPEbPVn7ah8eJJNAGXgbt7UawrAWMJZOE5dQvUy7wl_eKfZxdl66xxomHXnq0Ed_f5woVxofHXveJEdyXkYFAY0_G-mqvRx-krK9sor0TXGMKdSP_sf9Azo",
        "date_created": "2017-11-26T11:24:09.146699Z",
        "update_history": ""
}

```
A successful request returns 
```json
{
    "data": {
        "id": "3873b917-903c-4663-b528-abacbac576d2",
        "user_id": "20d86a3e-2b7e-4707-b8e3-e925ec525333",
        "user_title": "Intern Software Developer at USAID Health IT Project at University of Nairobi",
        "phone": "+254720735121",
        "social_facebook": "https://facebook.com/samy.raps",
        "social_twitter": "https://twitter.com/samy_raps",
        "social_linkedin": "https://www.linkedin.com/in/samson-rapando-5a273486",
        "social_instagram": "https://instagram.com/samy_raps",
        "website": "https://jobonics.com",
        "address": "1355-00518 Nairobi Kenya",
        "marital_status": "Single",
        "date_of_birth": "2017-11-26T11:24:09.146699Z",
        "gender": "Other",
        "languages": "English",
        "country": "Kenya",
        "personal_statement": "",
        "profile_picture": "https://media.licdn.com/mpr/mprx/0_1J2xFl_b9WcySruWzjZAiPEbPVn7ah8eJJNAGXgbt7UawrAWMJZOE5dQvUy7wl_eKfZxdl66xxomHXnq0Ed_f5woVxofHXveJEdyXkYFAY0_G-mqvRx-krK9sor0TXGMKdSP_sf9Azo",
        "date_created": "2017-11-26T11:24:09.146699Z",
        "update_history": ""
    },
    "success": true,
    "message": "OK"
}
```

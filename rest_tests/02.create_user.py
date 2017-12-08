import requests

from conn import url, headers

if __name__ == "__main__":
    data = {
        "first_name" : "xy",
        "last_name" : "yx",
        "password" : "xyyx",
        "email_address" : "xy@gmail.com"
    }
    req = requests.post(url = url + 'users/', headers=headers, json=data)
    res = req.json()
    if res['success']:
        print (res['message'])
    else:
        for k,v in res['data'].items() : print (v[0], end=",")
    
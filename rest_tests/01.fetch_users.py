import requests

from conn import url, headers

if __name__ == "__main__":
    req = requests.get(url = url + 'users/', headers=headers)
    res = req.json()
    print (res)
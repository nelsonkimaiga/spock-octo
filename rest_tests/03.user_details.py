import requests

from conn import url, headers

if __name__ == "__main__":
   
    req = requests.get(url = url + 'users/uid', headers=headers)
    print (req)
    # res = req.json()
    # if res['success']:
    #     print (res['message'])
    # else:
    #     for k,v in res['data'].items() : print (v[0], end=",")
    
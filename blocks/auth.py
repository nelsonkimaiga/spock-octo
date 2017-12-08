import string
import random

from passlib.hash import pbkdf2_sha256

def generate_str(len=10):
    letters = string.ascii_letters
    return ''.join(random.choice(letters) for i in range(len))

def hash_password(salt, password):
    hashed_pass = salt + password
    return pbkdf2_sha256.encrypt(hashed_pass, rounds=200000, salt_size=32)

def unhash_password(salt, password, hashed_pass):
    try:
        str = salt + password
        return pbkdf2_sha256.verify(str, hashed_pass)
    except:
        return False
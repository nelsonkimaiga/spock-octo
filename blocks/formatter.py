def pack(data, success=True, message='OK'):
    return {
        "data": data,
        "success": success,
        "message": message
    }

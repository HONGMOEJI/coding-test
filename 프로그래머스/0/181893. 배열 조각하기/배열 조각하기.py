def solution(arr, query):
    answer = []
    for idx, value in enumerate(query):
        if idx % 2 == 0:
            arr = arr[:value+1]
        else:
            arr = arr[value:]
    return arr
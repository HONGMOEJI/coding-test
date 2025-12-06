def solution(arr):
    result = []
    
    for x in arr:
        if not result:
            result.append(x)
        else:
            if result[-1] != x:
                result.append(x)
                
    return result
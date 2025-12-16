def solution(a, b):
    answer = 0
    
    apb = int(str(a) + str(b))
    bpa = int(str(b) + str(a))

    if apb < bpa:
        return int(bpa)
    else:
        return int(apb)
    
    return answer
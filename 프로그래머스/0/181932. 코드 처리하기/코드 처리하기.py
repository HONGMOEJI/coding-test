def solution(code):
    answer = ''

    mode = False # default

    for idx, char in enumerate(code):
        if char == '1':
            mode = not mode
        else:
            # mode가 false(0)이라면 -> 짝수 idx의 코드만 추가
            if not mode:
                if idx % 2 == 0:
                    answer += char
            # mode가 true(1)이라면 -> 홀수 idx의 코드만 추가
            elif mode:
                if idx % 2 != 0:
                    answer += char
    
    if answer == '':
        answer = 'EMPTY'
        
    return answer
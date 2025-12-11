# pre-solving
# 값의 가장 큰 자릿수는 항상 5.. 그리고?
from collections import deque
def solution(l, r):
    result = []
    q = deque([5]) # 시작 숫자
    
    while q:
        num = q.popleft()
        
        if num > r:
            continue
        
        if l <= num <= r:
            result.append(num)
            
        # 그 다음 수
        q.append(num * 10)
        q.append(num * 10 + 5)
        
    if not result: # result가 비어있으면 [-1] return
        return [-1]
    
    return result
    
import numpy as np

def solution(numbers):
    answer = []
    
    nparr = np.array(numbers)
    nparr = nparr*2
    
    answer = nparr.tolist()
    
    return answer
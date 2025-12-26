def solution(a, d, included):
    return sum(a + i*d for i, v in enumerate(included) if v)
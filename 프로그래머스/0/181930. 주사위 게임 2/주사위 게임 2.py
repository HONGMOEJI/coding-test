def solution(a, b, c):
    s = a + b + c
    s2 = a*a + b*b + c*c
    s3 = a**3 + b**3 + c**3
    return s if len({a,b,c})==3 else s*s2 if len({a,b,c})==2 else s*s2*s3
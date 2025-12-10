import math

def solution(a, b):
    b //= math.gcd(a, b)

    # 분모에서 2와 5를 나눠 없애기
    for p in [2, 5]:
        while b % p == 0:
            b //= p

    # 남은 수가 1이면 유한소수
    return 1 if b == 1 else 2
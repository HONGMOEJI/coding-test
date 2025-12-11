from collections import Counter

def solution(a, b, c, d):
    dice_nums = [a, b, c, d]
    dice_nums_set = set(dice_nums)
    cnt = Counter(dice_nums)
    score = 0

    if len(dice_nums_set) == 1: # 모두 같은 눈이라면?
        score = dice_nums[0] * 1111
    elif len(dice_nums_set) == 2: # 3개 1개 or 2개 2개
        if 3 in cnt.values():
            p = [k for k, v in cnt.items() if v == 3][0] # cnt items 중 value가 3인 key 값
            q = [k for k, v in cnt.items() if v == 1][0]
            score = (10 * p + q) ** 2
        elif 2 in cnt.values():
            p, q = cnt.keys()
            score = (p + q) * abs(p - q)
    elif len(dice_nums_set) == 3: # 2개 1개 1개
        p = [k for k, v in cnt.items() if v == 2][0]
        q, r = [k for k, v in cnt.items() if v == 1]
        score = q * r
    else: # 모두 다름
            score = min(dice_nums)

    return score
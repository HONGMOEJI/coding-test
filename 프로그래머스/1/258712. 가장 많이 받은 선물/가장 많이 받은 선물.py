def solution(friends, gifts):
    answer = 0

    n = len(friends)
    
    name2idx = {name: i for i, name in enumerate(friends)}
    
    gift_cnt = [[0]*n for _ in range(n)]
    
    # 기록 반영
    for gift in gifts:
        a, b = gift.split(" ")
        gift_cnt[name2idx[a]][name2idx[b]] += 1
        
    # 선물 지수
    gift_score = [0]*n
    for i in range(n):
        gift_score[i] = sum(gift_cnt[i]) - sum(gift_cnt[j][i] for j in range(n))
        
    # 다음 달 받아야하는 선물 수
    next_gift = [0]*n
    
    # 비교
    for i in range(n):
        for j in range(i+1, n):
            if gift_cnt[i][j] > gift_cnt[j][i]:
                next_gift[i] += 1
            elif gift_cnt[i][j] < gift_cnt[j][i]:
                next_gift[j] += 1
            else:
                if gift_score[i] > gift_score[j]:
                    next_gift[i] += 1
                elif gift_score[i] < gift_score[j]:
                    next_gift[j] += 1
                # 같으면 별 일 없음
                
    return max(next_gift)
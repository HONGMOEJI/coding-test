def solution(n, w, num):
    idx = num - 1
    cnt = 1 # 자기 자신 포함

    while True:
        r = idx // w # 0단 ~ 단수
        pos = idx % w # 현재 idx의 position

        # 현재 열 계산
        if r % 2 == 0: # 짝 from left to right
            c = pos
        else: # 홀 from right to left
            c = w - 1 - pos

        # 위 행 번호
        nr = r + 1 # new row

        # 위 행이 없으면 종료
        if nr * w >= n:
            break

        # 위 행에서 같은 열(c)에 해당하는 위치
        if nr % 2 == 0: # 짝수층
            npos = c
        else: # 홀수층
            npos = w - 1 - c

        next_idx = nr * w + npos

        # 이 인덱스에 상자가 없을 수 있음
        if next_idx >= n:
            break

        # 실제로 위에 상자가 있으면 거기로 이동
        idx = next_idx
        cnt += 1

    return cnt
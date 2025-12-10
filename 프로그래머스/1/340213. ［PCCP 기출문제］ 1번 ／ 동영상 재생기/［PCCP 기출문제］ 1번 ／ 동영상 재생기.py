def solution(video_len, pos, op_start, op_end, commands):
    # parse
    def parse(t):
        m, s = map(int, t.split(':'))
        return m, s

    video_len_min, video_len_sec = parse(video_len)
    pos_min, pos_sec = parse(pos)
    op_start_min, op_start_sec = parse(op_start)
    op_end_min, op_end_sec = parse(op_end)

    # 시간 범위 체크 함수
    def in_range(m, s, sm, ss, em, es):
        if (m < sm) or (m == sm and s < ss):
            return False
        if (m > em) or (m == em and s > es):
            return False
        return True

    for command in commands:
        # 오프닝 스킵
        if in_range(pos_min, pos_sec, op_start_min, op_start_sec, op_end_min, op_end_sec):
            pos_min, pos_sec = op_end_min, op_end_sec

        if command == "next":
            pos_sec += 10
            if pos_sec >= 60:
                pos_sec -= 60
                pos_min += 1

            # 영상 길이 초과
            if (pos_min > video_len_min) or (pos_min == video_len_min and pos_sec > video_len_sec):
                pos_min, pos_sec = video_len_min, video_len_sec

        else:  # prev
            pos_sec -= 10
            if pos_sec < 0:
                pos_sec += 60
                pos_min -= 1

            # 0 아래로 내려가는 것 방지
            if pos_min < 0:
                pos_min, pos_sec = 0, 0

        # 이동 후 오프닝 재검사
        if in_range(pos_min, pos_sec, op_start_min, op_start_sec, op_end_min, op_end_sec):
            pos_min, pos_sec = op_end_min, op_end_sec

    return f"{pos_min:02}:{pos_sec:02}"
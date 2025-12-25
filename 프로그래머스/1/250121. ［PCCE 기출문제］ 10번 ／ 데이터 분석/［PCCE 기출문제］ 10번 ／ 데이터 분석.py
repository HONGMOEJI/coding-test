def solution(data, ext, val_ext, sort_by):
    '''
    data : data ["code", "date", "maximum", "remain"]
    ext : 정보 추출 기준
    val_ext: 기준값
    sort_by: 기준 문자열

    data에서 ext 값이 val_ext보다 작은 데이터만 뽑고, sort_by에 해당하는 값을 기준으로 오름차순 정렬
    '''
    pre_answer = []
    if ext == "code":
        for ob in data:
            if ob[0] < val_ext:
                pre_answer.append(ob)

    elif ext == "date":
        for ob in data:
            if ob[1] < val_ext:
                pre_answer.append(ob)

    elif ext == "maximum":
        for ob in data:
            if ob[2] < val_ext:
                pre_answer.append(ob)
    elif ext == "remain":
        for ob in data:
            if ob[3] < val_ext:
                pre_answer.append(ob)

    if sort_by == "code":
        # 0번 인덱스 기준으로 정렬해야함
        answer = sorted(pre_answer, key=lambda x: x[0])

    if sort_by == "date":
        answer = sorted(pre_answer, key=lambda x: x[1])

    if sort_by == "maximum":
        answer = sorted(pre_answer, key=lambda x: x[2])

    if sort_by == "remain":
        answer = sorted(pre_answer, key=lambda x: x[3])


    return answer
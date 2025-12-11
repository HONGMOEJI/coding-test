def solution(arr):
    answer = [[]]

    # row-len 늘린다? True, col-len 늘린다? False
    flag = True

    row_len = len(arr)
    col_len = len(arr[0])

    add_len = abs(row_len - col_len)

    if row_len < col_len:
        flag = True
    else:
        flag = False

    if flag:
        for i in range(add_len):
            arr.append([0 for x in range(col_len)])
    else:
        for row in arr:
            for i in range(add_len):
                row.append(0)
    return arr
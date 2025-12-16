def solution(keyinput, board):
    a = board[0]
    b = board[1]
    minx = -(a//2)
    miny = -(b//2)
    maxx = a//2
    maxy = b//2
    
    result = [0, 0]
    for move in keyinput:
        if move == 'left':
            if result[0] > minx:
                result[0] -= 1
        elif move == 'right':
            if result[0] < maxx:
                result[0] += 1
        elif move == 'down':
            if result[1] > miny:
                result[1] -= 1
        else:
            if result[1] < maxy:
                result[1] += 1
    return result
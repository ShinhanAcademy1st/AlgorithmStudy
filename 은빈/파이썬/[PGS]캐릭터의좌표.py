def solution(keyinput, board):
    answer = [0, 0]
    x = (board[0] - 1) // 2
    y = (board[1] - 1) // 2
    
    for d in keyinput:
        if d == "up":
            if answer[1] < y:
                answer[1] += 1
        elif d == "down":
            if answer[1] > -y:
                answer[1] -= 1
        elif d == "left":
            if answer[0] > -x:
                answer[0] -= 1
        elif d == "right":
            if answer[0] < x:
                answer[0] += 1
    
    return answer
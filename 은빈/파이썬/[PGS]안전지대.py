def solution(board):
    n = len(board)
    
    for row in range(n):
        for col in range(n):
            if board[row][col] == 1:
                for i in range(max(0, row - 1), min(n, row + 2)):
                    for j in range(max(0, col - 1), min(n, col + 2)):
                        if board[i][j] != 1:
                            board[i][j] = -1
    
    answer = 0
    for row in board:
        answer += row.count(0)
    return answer
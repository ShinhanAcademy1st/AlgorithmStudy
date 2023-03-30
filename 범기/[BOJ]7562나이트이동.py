import collections
import sys

T = int(sys.stdin.readline())
for _ in range(T):
    dx = [2, 2, -2, -2, -1, 1, -1, 1]
    dy = [-1, 1, -1, 1, -2, -2, 2, 2]

    n = int(sys.stdin.readline())
    startx, starty = map(int, sys.stdin.readline().split())
    endx, endy = map(int, sys.stdin.readline().split())
    board = [[-1] * n for _ in range(n)]

    queue = collections.deque()
    queue.append([startx, starty])
    board[startx][starty] = 0

    while queue:
        if board[endx][endy] != -1:
            break

        now = queue.popleft()
        x = now[0]
        y = now[1]
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == -1:
                board[nx][ny] = board[x][y] + 1
                queue.append([nx, ny])

    print(board[endx][endy])

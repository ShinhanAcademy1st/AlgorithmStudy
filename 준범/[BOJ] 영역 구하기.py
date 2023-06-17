# 
# 1. k개의 직사각형의 범위를 이용해서 색칠
# 2. bfs or dfs 사용해서 색칠되지 않은(분리된 공간)의 범위 확인
# 
# 복잡도
# n, m, k => 100이하
# 1. k개의 직사각형 색칠 => 1개의 직사각형 최대범위 100 x 100 => 10,000
# => k개 의 직사각형 => 100 x 10,000 => 1,000,000
# 2. bfs of dfs => 모눈종이의 범위 100 x 100 => 10,000(실제 복잡도는 탐색하며 조금 더 증가할 수 있음)
# 
# ===> 1 + 2 => 1,000,000 + 10,000 => 1,010,000 => 1초 내 계산 가능
# 

import sys

def inRange(x, y):
    if x < 0 or x >= m or y < 0 or y >= n:
        return False
    return True

def findArea(x, y):
    queue = []
    queue.append([x, y])
    colored[x][y] = True
    area = 0
    while (queue):
        curX = queue[0][0]
        curY = queue[0][1]
        queue.pop(0)
        area += 1
        for i in range(4):
            nextX = curX + dx[i]
            nextY = curY + dy[i]
            if inRange(nextX, nextY) and not colored[nextX][nextY]:
                queue.append([nextX, nextY])
                colored[nextX][nextY] = True
    
    answers.append(area)


m, n, k = map(int, sys.stdin.readline().split())
colored = [[False] * n for _ in range(m)]
infos = [[] for _ in range(k)]
answers = []
dx = [-1, 1, 0, 0] # 상, 하, 좌, 우
dy = [0, 0, -1, 1] # 상, 하, 좌, 우

# 기본 입력
for i in range(k):
    infos[i] = list(map(int, sys.stdin.readline().split()))

# 모눈종이 초기화
for info in infos:
    x1 = info[1]
    y1 = info[0]
    x2 = info[3]
    y2 = info[2]
    for i in range(x1, x2):
        for j in range(y1, y2):
            colored[i][j] = True

# 정답 찾기
for i in range(m):
    for j in range(n):
        if not colored[i][j]:
            findArea(i, j)

answers.sort()
print(len(answers))
for num in answers:
    print(num, end=' ')
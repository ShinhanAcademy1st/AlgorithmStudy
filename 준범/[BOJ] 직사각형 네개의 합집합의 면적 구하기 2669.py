# 100 x 100 크기의 평면에 직사각형이 놓인 자리의 넓이를 구하는 문제
# ***** 입력 *****
# 4개의 직사각형 꼭짓점 정보(x1, y1, x2, y2)
  
# ***** 출력 *****
# 4개의 직사각형이 놓인 자리의 넓이
  
# 1. 4개의 직사각형이 놓인 자리를 색칠한다.((x2 - x1) * (y2 - y1))넓이만큼 board를 true로 변경
# 2. 색칠된 자리를 각 칸별로 카운트 한다.(true인 칸의 개수)
# 3. 카운트된 결과 출력
 
import sys
board = [[0 for i in range(100)] for j in range(100)]
squares = [[] for i in range(4)]

def color(points):
    x1, y1, x2, y2 = points[0], points[1], points[2], points[3]
    for i in range(x1, x2):
        for j in range(y1, y2):
            board[i][j] = 1

for i in range(4):
    squares[i] = list(map(int, sys.stdin.readline().split()))

for i in range(4):
    color(squares[i])

result = 0
for i in range(100):
    for j in range(100):
        if (board[i][j] == 1):
            result += 1

print(result)
import collections
import sys

N,M,T = map(int,sys.stdin.readline().split())

castle = []
visited = [[0]*M for _ in range(N)]

dx = [0,0,-1,1]
dy = [-1,1,0,0]

for _ in range(N):
    castle.append(list(map(int,sys.stdin.readline().split())))

def BFS_queen():
    queue = collections.deque()
    queue.append([0,0])
    visited[0][0] = 0

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >=0 and nx < N and ny >=0 and ny < M and visited[nx][ny] == 0 and castle[nx][ny]!=1:
                queue.append([nx,ny])
                visited[nx][ny] = visited[x][y]+1

BFS_queen()
visited[0][0]=0
# print(castle)
# print(visited)
distanceZeroToSword=0
coordX = 0
coordY = 0
# 검 까지의 거리
for i in range(N):
    for j in range(M):
        if castle[i][j]==2:
            coordX = i
            coordY = j
            distanceZeroToSword = visited[i][j]

swordToQueen = M-coordY+N-coordX-2
# print("검과 공주사이 거리 : ",swordToQueen)
# print("검을 안거치고 가는 거리 : ",visited[N-1][M-1])
# print("검까지의 거리", distanceZeroToSword)

#공주가 벽에 막혔을 때
if visited[N-1][M-1]==0:
    #검에 도달할때
    if distanceZeroToSword != 0:
        answer = distanceZeroToSword + swordToQueen
    #검에 도달못할때
    else:
        answer = 10001

#공주가 벽에 안막혔을 떄
else:
    # 검에 도달할때
    if distanceZeroToSword != 0:
        answer = min(distanceZeroToSword + swordToQueen, visited[N-1][M-1] )
    # 검에 도달못할때
    else:
        answer = visited[N-1][M-1]


if answer <= T:
    print(answer)
else:
    print("Fail")


#실패한 tc
'''
3 4 100
0 0 0 2
1 1 1 1
0 0 0 0
'''
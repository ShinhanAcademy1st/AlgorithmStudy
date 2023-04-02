import sys

INF = 1001

N,M = map(int,sys.stdin.readline().split())

inputArr=[]
distance = [[INF]*(N+1) for _ in range(N+1)]

for _ in range(M):
    s,e,w = map(int, sys.stdin.readline().split())
    distance[s][e] = w
    distance[e][s] = w

for i in range(N+1):
    distance[i][i]=0



for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            if distance[i][j] > distance[i][k]+distance[k][j]:
                distance[i][j] = distance[i][k]+distance[k][j]

print(distance)
print(distance[1][N])



'''
6 8
4 5 3
2 4 0
4 1 4
2 1 1
5 6 1
3 6 2
3 2 6
3 4 4
'''
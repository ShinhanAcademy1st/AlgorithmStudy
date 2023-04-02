import sys

N,M = map(int, sys.stdin.readline().split())

arr = []

for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

for i in range(1,M):
    arr[0][i]+=arr[0][i-1]

for i in range(1,N):
    arr[i][0]+=arr[i-1][0]

for i in range(1,N):
    for j in range(1,M):
        arr[i][j] += max(arr[i][j-1],arr[i-1][j])

print(arr[N-1][M-1])
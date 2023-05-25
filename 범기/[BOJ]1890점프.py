import sys

n = int(input())

array = []
dp = [[0]*n for _ in range(n)]

di = [0,1]
dj = [1,0]

for _ in range(n):
    array.append(list(map(int,sys.stdin.readline().split())))

dp[0][0]=1

for i in range(n):
    for j in range(n):
        power=array[i][j]
        di = [power,0]
        dj = [0,power]

        if dp[i][j]==0 or (i == n-1 and j == n-1):
            continue

        for k in range(2):
            ni =i + di[k]
            nj =j + dj[k]
            if 0<=ni<n and 0<=nj<n:
                dp[ni][nj]+=dp[i][j]


print(dp[n-1][n-1])
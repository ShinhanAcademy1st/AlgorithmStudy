import collections
import sys

n,m = map(int, sys.stdin.readline().split())
maxCount=0
graph=[[] for _ in range(n+1)]

for _ in range(m):
    s,e = map(int,sys.stdin.readline().split())
    graph[e].append(s)


def bfs(start):
    visited=[False]*(n+1)
    visited[start]=True
    queue=collections.deque()
    queue.append(start)
    count=1

    while queue:
        now = queue.popleft()
        for i in graph[now]:
            if not visited[i]:
                count+=1
                visited[i]=True
                queue.append(i)

    return count

answer=[]
for i in range(1,n+1):
    cnt=bfs(i)
    if cnt>maxCount:
        answer=[i]
        maxCount=cnt
    elif cnt==maxCount:
        answer.append(i)

print(*answer)
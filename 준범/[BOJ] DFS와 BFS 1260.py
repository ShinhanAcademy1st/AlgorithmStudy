# 1. 각 정점별 방문 리스트 저장
# 2. 각 리스트 오름차순 정렬
# 3. 저장된 정보를 기반으로 dfs, bfs 수행

# 각 정점에서 방문할 수 있는 정점이 여러 개 일 수 있고, 여러 개 인 경우 정점 번호가 더 작은 것을 먼저 방문하기 때문에, 
# 각 정점이 방문할 수 있는 정점들을 먼저 정렬해 놓은뒤 사용하면 편하다.
# 이 방문 정점 리스트는 각 dfs, bfs에서 두번 사용 되기 때문에 처음에 초기화를 한번 잘 해놓으면 편하다.

import sys

def dfs(node):
    print(node, end=' ')
    visited[node] = True
    for nextNode in nextNodes[node]:
        if not visited[nextNode]:
            dfs(nextNode)

n, m, v = map(int, sys.stdin.readline().split())
visited = [False] * (n + 1)
nextNodes = [[] for i in range(n + 1)]
for _ in range(m):
    n1, n2 = map(int, sys.stdin.readline().split())
    nextNodes[n1].append(n2)
    nextNodes[n2].append(n1)

for i in range(1, n + 1):
    nextNodes[i].sort()
dfs(v)
print()
visited = [False] * (n + 1)
queue = [v]
visited[v] = True
while queue:
    head = queue.pop(0)
    print(head, end=' ')
    for nextNode in nextNodes[head]:
        if not visited[nextNode]:
            visited[nextNode] = True
            queue.append(nextNode)
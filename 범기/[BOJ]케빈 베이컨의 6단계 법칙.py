import collections
import sys

def bfs(startNode):

    #노드별 최단거리 계산
    distance = [-1]*(node+1)
    distance[0]=0
    distance[startNode]=0

    queue= collections.deque()
    queue.append(startNode)

    while queue:
        now = queue.popleft()
        for next_node in graph[now]:
            if distance[next_node] == -1:
                queue.append(next_node)
                distance[next_node]=distance[now]+1

    #print(distance)
    #케빈 수 검사
    return sum(distance)

node, edge = map(int,sys.stdin.readline().split())

graph = [[] for _ in range(node+1)]
kevinNum = [0]*(node+1)

#양방향 그래프 초기화
for _ in range(edge):
    s,e = map(int,sys.stdin.readline().split())
    graph[s].append(e)
    graph[e].append(s)

#케빈넘버 입력
for i in range(1,node+1):
    kevinNum[i]=bfs(i)

min=min(kevinNum[1:]) #가장 작은 케빈넘버 검사
for i in range(1,node+1): 
    if kevinNum[i] == min: #케빈넘버가 가장 작은 노드 출력
        print(i) 
        break
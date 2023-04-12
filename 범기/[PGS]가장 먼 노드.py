import collections


def solution(n, edge):
    answer = 0

    graph = [[] for _ in range(n + 1)]
    distance = [-1] * (n + 1)

    for s, e in edge:
        #양방향 그래프 초기화
        graph[s].append(e)
        graph[e].append(s)

    #print(graph)

    queue = collections.deque()
    queue.append(1)
    distance[1] = 0

    while queue:
        now_node = queue.popleft()
        for next_node in graph[now_node]:
            if distance[next_node] == -1:
                distance[next_node] = distance[now_node] + 1
                queue.append(next_node)

    maxDistance = max(distance) #가장 긴 거리 초기화
    for i in range(n+1):
        if distance[i] == maxDistance:
            #print(i)
            answer+=1

    return answer
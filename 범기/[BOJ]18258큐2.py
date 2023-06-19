import collections
import sys

n = int(input())

queue = collections.deque()

for _ in range(n):
    input = list(map(str,sys.stdin.readline().split()))
    if input[0] == "push":
        queue.append(int(input[1]))
    elif input[0] == "pop":
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.popleft())
    elif input[0] == "size":
        print(len(queue))
    elif input[0] == "empty":
        if len(queue)>0:
            print(0)
        else:
            print(1)
    elif input[0] == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif input[0] == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)
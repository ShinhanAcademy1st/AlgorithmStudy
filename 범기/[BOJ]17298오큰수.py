import collections
import sys

n = int(sys.stdin.readline())
nums = list(map(int,sys.stdin.readline().split()))
answer = [0]*n
stack = collections.deque()


for i in range(n-1,-1,-1):
    while len(stack) !=0 and stack[-1] <= nums[i]:
        stack.pop()

    if len(stack) == 0:
        answer[i]=-1
    else:
        answer[i] = stack[-1]

    stack.append(nums[i])

print(*answer)
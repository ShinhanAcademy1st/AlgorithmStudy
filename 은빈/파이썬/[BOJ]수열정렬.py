# 백준 1015
n = int(input())
a = list(map(int, input().split()))
answer = [-1 for _ in range(len(a))]
order = 0

while(min(answer) == -1):
    idx = a.index(min(a))
    answer[idx] = order
    order += 1
    a[idx] = 5000
    
print(*answer)
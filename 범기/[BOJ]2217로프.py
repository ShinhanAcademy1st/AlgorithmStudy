n = int(input())

arr = []
answer = 0

for _ in range(n):
    arr.append(int(input()))

arr.sort()

for i in range(len(arr)):

    # print(arr[i]*(n-i))
    if answer<arr[i]*(n-i):
        answer = arr[i]*(n-i)

print(answer)
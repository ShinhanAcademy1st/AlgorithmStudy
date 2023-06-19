import sys

n,m = map(int,sys.stdin.readline().split())
a = list(map(int,sys.stdin.readline().split()))
b = list(map(int,sys.stdin.readline().split()))

# answer = []

i=0
j=0

while i < n and j < m:
    if a[i] < b[j]:
        print(a[i],end=" ")
        i+=1
    else:
        print(b[j], end=" ")
        j+=1


print(*a[i:],*b[j:])
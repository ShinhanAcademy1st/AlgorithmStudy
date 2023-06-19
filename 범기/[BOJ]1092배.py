import sys

n = int(sys.stdin.readline())
cradles = list(map(int,sys.stdin.readline().split()))
m = int(sys.stdin.readline())
boxes = list(map(int,sys.stdin.readline().split()))
tmp=[0]*n

cradles.sort()
boxes.sort()

crainIndex = 0
boxIndex = 0
possible = True

while boxIndex<m:
    if boxes[boxIndex]<=cradles[crainIndex]:
        tmp[crainIndex]+=1
        boxIndex+=1
    else:
        crainIndex+=1
        if crainIndex>=n:
            possible=False
            break

if possible:
    change = True
    while change:
        change = False
        for i in range(n - 1):
            if tmp[i] > tmp[i + 1]:
                tmp[i] -= 1
                tmp[i + 1] += 1
                change = True
    print(max(tmp))
else:
    print("-1")

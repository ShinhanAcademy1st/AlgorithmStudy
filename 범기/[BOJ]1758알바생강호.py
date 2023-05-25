import sys

n = int(sys.stdin.readline())

answer = 0
tips=[]

for i in range(n):
    tips.append(int(sys.stdin.readline()))

tips.sort(reverse=True)

for i in range(n):
    tip = tips[i] - i
    if tip>=0:
        answer+=tip

print(answer)
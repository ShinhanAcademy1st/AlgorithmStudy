n = int(input())

answer=0

for i in range(5,n+1,5):
    #print(i)
    if i % 125 == 0:
        answer+=3
    elif i % 25 == 0:
        answer+=2
    elif i % 5 ==0:
        answer +=1

print(answer)
n = int(input())

def fact(total, num):
    return total * num

total = 1
for i in range(1, n+1):
    total = fact(total, i)
    
total = str(total)[::-1]
cnt = 0
for s in total:
    if s == '0':
        cnt += 1
    else:
        break
        
print(cnt)
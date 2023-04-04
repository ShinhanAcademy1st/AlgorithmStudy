n = int(input())

x, y = divmod(n, 10)

m, n = x, y
cnt = 0

while True:
    cnt += 1
    s = m + n
    m, n = n, s % 10
    
    if (m == x and n == y):
        break
        
print(cnt)
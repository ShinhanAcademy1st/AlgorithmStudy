import sys
MAX_PRICE = 2**31

n = int(sys.stdin.readline())

count=0
min_price = MAX_PRICE
answer=0

prices = []
for _ in range(n):
    prices.append(int(sys.stdin.readline()))

prices.sort(reverse=True)

for price in prices:
    answer+=price

    count+=1
    if price<min_price:
        min_price=price

    if count == 3:
        answer-=min_price
        min_price=MAX_PRICE
        count=0

print(answer)
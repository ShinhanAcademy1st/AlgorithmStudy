import sys

money = int(input())
stockPrices = list(map(int, sys.stdin.readline().split()))

stock_j = 0         #BNF
money_j = money
stock_s = 0         #timing
money_s = money

ContinuousAscent=-1
ContinuousDescent=0
tmp=0
for stockPrice in stockPrices:
    stock_j+=money_j//stockPrice
    money_j%=stockPrice

    if stockPrice>tmp:
        ContinuousAscent+=1
        ContinuousDescent = 0
    if stockPrice<tmp:
        ContinuousAscent = 0
        ContinuousDescent += 1

    if ContinuousAscent>2:
        money_s += stock_s*stockPrice
        stock_s = 0

    if ContinuousDescent>2:
        stock_s += money_s // stockPrice
        money_s %= stockPrice

    tmp=stockPrice

#print(stock_j*stockPrices[-1]+money_j,stock_s*stockPrices[-1]+money_s)
if stock_j*stockPrices[-1]+money_j > stock_s*stockPrices[-1]+money_s:
    print("BNP")
elif stock_j*stockPrices[-1]+money_j == stock_s*stockPrices[-1]+money_s:
    print("SAMESAME")
else:
    print("TIMING")
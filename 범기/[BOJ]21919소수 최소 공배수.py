import sys

n = int(sys.stdin.readline())
array = list(map(int,sys.stdin.readline().split()))
primeNo = set()

def isPrime(num):
    for i in range(2,int(num**0.5)+1):
        if num%i==0:
            return False

    return True

for i in array:
    if isPrime(i):
        primeNo.add(i)

if len(primeNo) == 0:
    print(-1)
else:
    answer = 1
    for i in primeNo:
        answer*=i
    print(answer)

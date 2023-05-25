n = int(input())-1

def isPelin(number):
    strN = str(number)
    l = len(strN)
    for i in range(l//2):
        if strN[i] != strN[l-i-1]:
            return False
    return True

def isPrime(number):
    if number == 1:
        return False

    for i in range(2,int(number**0.5)+1):
        if number%i==0:
            return False
    return True

while True:
    n+=1
    if not isPelin(n):
        continue
    if isPrime(n):
        break

print(n)
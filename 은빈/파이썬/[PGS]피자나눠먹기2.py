def getGcd(num1, num2):
    r = num1 % num2
    if(r == 0):
        return num2
    return getGcd(num2, r)

def solution(n):
    gcd = getGcd(max(n, 6), min(n, 6))
    answer = n * 6 / gcd

    answer /= 6

    return answer
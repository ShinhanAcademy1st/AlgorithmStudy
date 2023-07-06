# 입력으로 주어진 수의 시계수의 순서를 구하는 문제
# ***** 입력 *****
#  4자리의 숫자
 
#  ***** 출력 *****
#  입력으로 주어진 4자리의 숫자의 시계수의 순서
 
#  1. 입력으로 주어진 수의 시계수를 구한다.
#  2. 1111부터 1.에서 구한 시계수에 도달할때까지 1씩 증가하면서 반복
#    2-1. 숫자에 0이 포함된지 확인(입력이 1 ~ 9 사이의 숫자 4개가 주어지기 때문)
#    2-2. 각 수의 시계수를 구한다.
#    2-3. 해당수의 시계수가, 해당 수보다 작으면 포함x
#    2-4. 해당 수의 시계수가 입력으로 주어진 수의 시계수와 같으면 반복 종료
 
#  시계수 구하는 방법 : 4자리의 숫자를 회전하며 제일 작은 수를 찾는다.
#  1. 천의 자리 수를 구한다. (숫자 / 1000)
#  2. 숫자를 1000으로 나눈 나머지로 변경(숫자 = 숫자 % 1000)
#  3. 숫자를 10 곱해준다.
#  4. 숫자에 최초 천의자리를 더한다.

import sys

def containZero(num):
    while num > 0:
        if num % 10 == 0:
            return True
        num //= 10
    return False

def getClockNum(num):
    clockNum = num
    for _ in range(3):
        digit = num // 1000
        num = num % 1000 * 10 + digit
        if num < clockNum:
            clockNum = num
    
    return clockNum

inputNum = int(sys.stdin.readline().replace(' ', ''))
initialClockNum = getClockNum(inputNum)
order = 0
num = 1110
while True:
    num += 1
    if containZero(num):
        continue
    clockNum = getClockNum(num)
    if clockNum < num:
        continue
    order += 1
    if clockNum == initialClockNum:
        break

print(order)
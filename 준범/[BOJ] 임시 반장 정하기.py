#  N명의 학생중, 1~5년까지의 학교생활에서 가장 다양한 학생과 같은 반을 했던
#  학생의 번호를 구하는 문제
 
#  ***** 입력 *****
#  N : 학생의 수
#  students[N][5] : 각 학생의 학년별 반의 정보
 
#  ***** 출력 *****
#  가장 많은 학생과 같은 반을 했던 학생의 번호
 
 
#  1. 3중 for문을 돌며 같은 반을 했던 학생 파악
#  2. 2차원 boolean 배열을 사용하여 같은 반을 했던 학생 표시
#  3. 가장 많은 학생과 겹쳤던 학생의 번호 출력

import sys;

n = int(sys.stdin.readline())
students = [[] for _ in range(n)]
commons = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n) :
    students[i] = list(map(int, sys.stdin.readline().split()))

for i in range(n - 1):
    for j in range(5):
        for k in range(i + 1, n):
            if students[i][j] == students[k][j]:
                commons[i][k] = 1
                commons[k][i] = 1
               
maxStudent = 1
maxNum = 0
for i in range(n):
    common = 0
    for j in range(n):
        if commons[i][j] == 1:
            common += 1
    if common > maxNum:
        maxNum = common
        maxStudent = i + 1

print(maxStudent)
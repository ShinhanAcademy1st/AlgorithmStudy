import itertools
import sys


def bingoGame(board, input):
    for i in range(5):
        for j in range(5):
            if board[i][j] == input:
                board[i][j] = -1
                return


def checkBingo(board):
    numOfBingo = 0  # 빙고의 수

    tmp = 0  # tmp(체크된 칸의 갯수) = 5일대 원빙고
    for i in range(5):
        if board[i][i] == -1:
            tmp += 1
    if tmp == 5:
        numOfBingo += 1

    tmp = 0
    for i in range(5):
        if board[i][4 - i] == -1:
            tmp += 1
    if tmp == 5:
        numOfBingo += 1

    for i in range(5):
        tmp = 0
        for j in range(5):
            if board[i][j] == -1:
                tmp += 1

        if tmp == 5:
            numOfBingo += 1

    for i in range(5):
        tmp = 0
        for j in range(5):
            if board[j][i] == -1:
                tmp += 1

        if tmp == 5:
            numOfBingo += 1

    return numOfBingo


board = [[] for _ in range(5)]
sequence = []

for i in range(5):
    board[i] = list(map(int, sys.stdin.readline().split()))

for i in range(5):
    sequence.append(list(map(int, sys.stdin.readline().split())))
sequence = list(itertools.chain(*sequence))

answer = 0

for i in range(25):
    answer += 1
    bingoGame(board, sequence[i])
    # print(i,"###\n",board,checkBingo(board))
    if checkBingo(board) >= 3:
        print(answer)
        break

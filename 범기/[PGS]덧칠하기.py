def solution(n, m, section):
    answer = 0

    walls = [True] * n
    for s in section:
        walls[s - 1] = False

    for i in range(n):
        if walls[i] == False:
            answer += 1
            for j in range(i, i + m):
                if j >= n:
                    break
                walls[j] = True

    return answer
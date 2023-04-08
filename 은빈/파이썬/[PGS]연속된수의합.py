def solution(num, total):
    cond = 1 if num % 2 == 0 else 0
    mid = total // num
    n = num // 2
    
    answer = [i for i in range(mid - n + cond, mid + n + 1)]
    return answer
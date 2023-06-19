def solution(arr):
    answer = []
    stack = []
    
    for num in arr:
        if num not in stack:
            if len(stack) != 0:
                answer.append(stack.pop())
            stack.clear()
            stack.append(num)
        
    if len(stack) != 0:
        answer.append(stack.pop())
    
    return answer
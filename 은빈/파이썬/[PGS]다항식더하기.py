def solution(polynomial):
    answer = ''
    x = 0
    n = 0
    
    poly = polynomial.split()
    
    for p in poly:
        if "x" in p:
            if len(p) == 1:
                x += 1
            else:
                x += int(p[:-1])
        elif '+' not in p:
            n += int(p)
            
    if x != 0:
        if x != 1:
            answer += str(x)
        answer += "x"
    if n != 0:
        if answer != "":
            answer += " + "
        answer += str(n)
            
    
    return answer
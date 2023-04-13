def solution(lines):
    line = set()
    
    for i in range(2):
        s1 = lines[i][0]
        e1 = lines[i][1]
        
        for j in range(i+1, 3):
            s2 = lines[j][0]
            e2 = lines[j][1]
            
            if s1 <= s2 and e1 > s2:
                if e1 < e2:
                    for dot in range(s2, e1):
                        line.add((dot, dot+1))
                        print(1, dot, dot+1)
                else:
                    for dot in range(s2, e2):
                        line.add((dot, dot+1))
                        print(2, dot, dot+1)
            elif s1 < e2 and s1 >= s2:
                if e1 < e2:
                    for dot in range(s1, e1):
                        line.add((dot, dot+1))
                        print(3, dot, dot+1)
                else:
                    for dot in range(s1, e2):
                        line.add((dot, dot+1))
                        print(4, dot, dot+1)
                        
    answer = len(line)
    
    return answer


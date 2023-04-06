from collections import Counter

def solution(array):
    answer = -1
    cnt = [-1]
    
    counter = Counter(array)
    numSet = set(array)
    
    for num in numSet:
        myCnt = counter[num]
        
        if cnt[0] == myCnt:
            answer = num
            cnt.append(myCnt)
        elif cnt[0] < myCnt:
            answer = num
            cnt = [myCnt]
    
    if(len(cnt) > 1):
        answer = -1
    
    return answer
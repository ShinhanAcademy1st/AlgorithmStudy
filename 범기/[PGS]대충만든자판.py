def typeCheck(keymap, target):
    min = 101

    for i in range(len(keymap)):
        count = 1
        for key in keymap[i]:
            if target == key and count < min:
                min = count
            count += 1

    if min < 101:
        return min
    else:
        return False


def solution(keymap, targets):
    answer = [-1] * len(targets)

    for i in range(len(targets)):
        tmp = 0
        for alphabet in targets[i]:
            if typeCheck(keymap, alphabet):
                tmp += typeCheck(keymap, alphabet)
            else:
                tmp = -1
                break

        answer[i] = tmp

    return answer
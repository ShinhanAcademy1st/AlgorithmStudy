import collections


def solution(cards1, cards2, goal):
    queue1 = collections.deque()
    queue2 = collections.deque()

    for card in cards1:
        queue1.append(card)
    queue1.append("-1")


    for card in cards2:
        queue2.append(card)
    queue2.append("-1")

    for word in goal:
        if word == queue1[0]:
            queue1.popleft()
        elif word == queue2[0]:
            queue2.popleft()
        else:
            return "No"

    return "Yes"

#print(solution(["i", "drink", "water"], ["want", "to"], ["i", "want", "to", "drink", "water"]))
#print(solution(["i", "water", "drink"],	["want", "to"],	["i", "want", "to", "drink", "water"]))
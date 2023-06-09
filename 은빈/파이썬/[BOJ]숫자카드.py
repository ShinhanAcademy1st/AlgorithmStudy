n = int(input())
cards = {x for x in input().split()}

m = int(input())
nums = [1 if x in cards else 0 for x in input().split()]

print(*nums)   
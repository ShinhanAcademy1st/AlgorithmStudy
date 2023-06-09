import sys

n = int(input())

array = list(map(str,sys.stdin.readline().rstrip()))
#print(array)

current = array[0]
change = 1

for color in array:
  if color != current:
    change+=1
    current=color

#print(change)

print(change//2+1)
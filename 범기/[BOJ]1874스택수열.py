n = int(input())

stack = []
result = []
count = 0
check = True
for _ in range(n):
    num = int(input())
    if count < num:
        while count != num:
            count += 1
            stack.append(count)
            result.append('+')

    if num == stack[-1]:
        stack.pop()
        result.append('-')
    else:
        check = False

if check:
    for i in result:
        print(i)
else:
    print('NO')
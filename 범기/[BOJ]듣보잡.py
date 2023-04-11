import sys

N, M = map(int,sys.stdin.readline().split())

unListened=set()
unSean=set()

for _ in range(N):
    unListened.add(sys.stdin.readline())

for _ in range(M):
    unSean.add(sys.stdin.readline())

unSeanAndUnListened=sorted(list(unListened&unSean))

print(len(unSeanAndUnListened))
for item in unSeanAndUnListened:
    print(item[:-1])
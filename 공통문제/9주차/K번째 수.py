import sys
ssr = sys.stdin.readline

n,k = map(int, ssr().split(' '))
lst = list(map(int, ssr().split(' ')))

lst.sort()
print(lst[k-1])

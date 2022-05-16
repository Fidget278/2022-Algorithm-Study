import sys
ssr = sys.stdin.readline

def swap(l,i,j):
  l[i-1],l[j-1] = l[j-1],l[i-1]
  return l

n = int(ssr())
lst = [1]

for i in range(2, n+1):
  lst.append(i)
  swap(lst, i, i-1)
  j = i-1

  while j != 1:
    swap(lst, j, j//2)
    j //= 2

print(*lst, sep=' ')

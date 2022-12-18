# 링크 : https://www.acmicpc.net/problem/1620
# 시간 : 364ms, 공간 : 57452KB

import sys
import re
ssr = sys.stdin.readline

n,m = map(int, ssr().split(' '))
numbers = {}
pokemons = {}
num = '\d'

for i in range(n):
  pokemon = ssr().strip()
  pokemons[i+1] = pokemon
  numbers[pokemon] = i+1

for _ in range(m):
  quiz = ssr().strip()
  if re.match(num, quiz):
    print(pokemons[int(quiz)])
  else:
    print(numbers[quiz])

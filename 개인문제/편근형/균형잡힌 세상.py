# 링크 : https://www.acmicpc.net/problem/4949
# 시간 : 112ms
# 길이 : 528B

import sys
ssr = sys.stdin.readline

while True:
  s = ssr().rstrip()
  s.lstrip()
  # . 입력시 종료
  if s == ".":
    break
  stack = []
  answer = "yes"
  for i in s:
    if i == "[" or i =="(":
      stack.append(i)
    elif i == "]":
      if len(stack) != 0 and stack[-1] == "[":
        stack.pop()
      else: 
        stack.append("]")
        break
    elif i == ")":
      if len(stack) != 0 and stack[-1] == "(":
        stack.pop()
      else:
        stack.append(")")
        break
  if len(stack) != 0: answer="no"
  print(answer)

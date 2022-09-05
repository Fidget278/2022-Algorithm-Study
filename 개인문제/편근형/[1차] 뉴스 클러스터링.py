# https://school.programmers.co.kr/learn/courses/30/lessons/17677

from collections import Counter
def solution(str1, str2):
    s1 = [str1[i:i+2].lower() for i in range(len(str1) - 1) if str1[i:i+2].isalpha()]
    s2 = [str2[i:i+2].lower() for i in range(len(str2) - 1) if str2[i:i+2].isalpha()]
    c1, c2 = Counter(s1), Counter(s2)
    
    p = (c1 | c2).values()
    c = (c1 & c2).values()
    C,P = sum(c), sum(p)
    div = C/P if P != 0 else 1
    
    return int(div * 65536)

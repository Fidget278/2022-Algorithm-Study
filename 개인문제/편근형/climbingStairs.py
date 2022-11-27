# 링크 : https://app.codesignal.com/interview-practice/question/oJXTWuwEZiC6FTw3A/solutions

def solution(n):
    dp = [0 for i in range(n+1)]
    if n <=2:
        return n
    for i in range(3, n+1):
        dp[i] = dp[i-1] + dp[i-2]
    return dp[n]

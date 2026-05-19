def solution(s):
    answer = ''
    s = sorted(s, reverse=True)
    for i in range(len(s)):
        answer += s[i]
        
    return answer
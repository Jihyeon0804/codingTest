def solution(s, n):
    low = "abcdefghijklmnopqrstuvwxyz"
    up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    answer = ''
    for char in s:
        if char in low:
            ind = low.find(char)+n
            answer += low[ind%26]
        elif char in up:
            ind = up.find(char)+n
            answer += up[ind%26]
        else:
            answer += " "
    return answer
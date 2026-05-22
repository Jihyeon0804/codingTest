import math

def solution(k, d):
    answer = 0
    
    for i in range(d // k + 1):
        x = i * k
        y = math.sqrt(d ** 2 - x ** 2)
        answer += int(y) // k + 1
    
    return answer
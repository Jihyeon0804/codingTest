from math import sqrt
def solution(n):
    arr = [1] * (n+1)
    for i in range(2, int(sqrt(n))+1):
        if arr[i]:
            j = 2
            while i*j <= n:
                arr[i*j] = 0
                j += 1
    answer = arr.count(1) - 2
    return answer
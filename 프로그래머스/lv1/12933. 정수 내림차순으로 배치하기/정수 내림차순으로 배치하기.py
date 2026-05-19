def solution(n):
    n = list(str(n))
    n.sort(reverse = True)
    answer = ''
    for i in range(len(n)):
        answer += ''.join(n[i])
    return int(answer)
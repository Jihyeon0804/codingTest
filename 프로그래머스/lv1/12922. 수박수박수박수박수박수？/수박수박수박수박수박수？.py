def solution(n):
    if n%2 ==0:
        answer = ''.join('수박'*int(n/2))
    else:
        answer = ''.join('수박'*int(n/2))
        answer+='수'
    return answer
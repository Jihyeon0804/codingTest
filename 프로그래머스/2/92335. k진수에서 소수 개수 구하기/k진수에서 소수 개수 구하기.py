import math

def solution(n, k):
    answer = 0

    # N진수 변환
    base_n = ''
    while n > 0:
        n, mod = divmod(n, k)
        base_n += str(mod)

    base_n = base_n[::-1]

  # 소수 개수 구하기
    lst = base_n.split('0')
    for i in lst:
        if i != '' and i != '1':
            for j in range(2, int(math.isqrt(int(i))) + 1):
                if int(i) % j == 0:
                    break
            else:
                answer += 1
    return answer
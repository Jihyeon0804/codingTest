from collections import Counter

def solution(weights):
    answer = 0

    dic = Counter(weights)

    # 동일 몸무게 짝꿍
    for value in dic.values():
        if value >= 2:
            answer += (value * (value - 1)) // 2

    # 1:2, 2:3, 3:4 짝꿍
    ratios = [1/2, 2/3, 3/4]

    for weight in dic:
        for ratio in ratios:
            target = weight * ratio
            
            if target.is_integer() and target in dic:
                answer += dic[weight] * dic[target]
    return answer
def solution(word):
    answer = 0
    vowel = "AEIOU"

    weights = [0] * 5
    weights[4] = 1

    for i in range(3, -1, -1):
        weights[i] = weights[i + 1] * 5 + 1

    for i in range(len(word)):
        idx = vowel.index(word[i])
        answer += (idx * weights[i]) + 1
    return answer
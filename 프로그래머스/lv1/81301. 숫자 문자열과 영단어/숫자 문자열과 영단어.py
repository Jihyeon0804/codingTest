def solution(s):
    lst = ['zero','one', 'two', 'three', 'four','five','six','seven','eight','nine']
    answer = ''
    for idx, num in enumerate(lst):
        if num in s:
            s = s.replace(num, str(idx))
        answer = s

    return int(answer)
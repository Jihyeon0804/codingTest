def solution(x):
    s = list(str(x))
    s = list(map(int, s))
    if x%sum(s)==0:
        return True
    else:
        return False
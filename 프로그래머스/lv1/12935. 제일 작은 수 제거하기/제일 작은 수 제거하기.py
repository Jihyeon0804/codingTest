def solution(arr):
    if len(arr) == 1:
        return [-1]
    del arr[arr.index(min(arr))]
    return arr
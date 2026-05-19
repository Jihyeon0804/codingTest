def solution(lottos, win_nums):
    rank = [6,6,5,4,3,2,1]
    lottos.sort()
    win_nums.sort()
    cnt = [0] *2
    for i in range(len(lottos)):
        for j in range(len(win_nums)):
            if lottos.count(0) == 6:
                cnt[0] = 1
                cnt[1] = lottos.count(0)
            elif lottos[i] == win_nums[j]:
                cnt[0] +=1
                cnt[1] = cnt[0] + lottos.count(0)
    cnt = [rank[cnt[0]], rank[cnt[1]]]
    cnt.sort()
    return cnt
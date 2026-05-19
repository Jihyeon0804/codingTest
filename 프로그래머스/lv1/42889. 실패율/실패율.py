def solution(N, stages):
    answer = {}
    user = len(stages)

    for stage in range(1, N+1):
        if user != 0:
            count = stages.count(stage)
            answer[stage] = count/user
            user -= count
        else:
            answer[stage] = 0
    
    return sorted(answer, key=lambda x:answer[x], reverse=True)
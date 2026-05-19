def solution(citations):
    if len(citations) == citations.count(0):
        return (0)
    
    else:
        citations.sort()
        for i in range(len(citations)):
            if(citations[i]>=len(citations)-i):
                return (len(citations)-i)
import heapq
def solution(operations):
    heap = []

    for i in operations:
        if i.split(' ')[0] == 'I':
            heapq.heappush(heap, int(i.split(' ')[1]))
        else:
            if len(heap) == 0:
                pass
            elif i.split(' ')[1]  == '-1':
                heapq.heappop(heap)
            else:
                heap = heapq.nlargest(len(heap), heap)[1:]
                heapq.heapify(heap)
    if len(heap) == 0:
        return [0,0]
    else:
        return [max(heap), min(heap)]
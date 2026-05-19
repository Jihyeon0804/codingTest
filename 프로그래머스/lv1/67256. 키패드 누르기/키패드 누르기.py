def solution(numbers, hand):
    answer = ''
    dic = {1:[0,0], 2:[0,1], 3:[0,2],
          4:[1,0], 5:[1,1], 6:[1,2],
          7:[2,0], 8:[2,1], 9:[2,2],
          '*':[3,0], 0:[3,1], '#':[3,2]}
    start_l = dic['*']
    start_r = dic['#']

    for i in numbers:
        start = dic[i]
        if i in [1,4,7]:
            answer += 'L'
            start_l = start
            
        elif i in [3,6,9]:
            answer += 'R'
            start_r = start
        
        else:
            dist_l = 0
            dist_r = 0
            
            for j, k, s in zip(start_l, start_r, start):
                dist_l += abs(j-s)
                dist_r += abs(k-s)
            
            if dist_l < dist_r:
                answer += 'L'
                start_l = start
            
            elif dist_l > dist_r:
                answer += 'R'
                start_r = start
            
            else:
                if hand == 'left':
                    answer += 'L'
                    start_l = start
                    
                else:
                    answer += 'R'
                    start_r = start
    return answer
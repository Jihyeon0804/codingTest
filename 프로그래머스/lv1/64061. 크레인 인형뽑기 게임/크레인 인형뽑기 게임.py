def solution(board, moves):
    crane = []
    answer = 0
    for move in moves:
        for i in range(len(board)):
            if board[i][move-1] != 0:
                crane.append(board[i][move-1])
                board[i][move-1]= 0
                if len(crane) > 1:
                    if crane[-1] == crane[-2]:
                        crane.pop(-1)
                        crane.pop(-1)
                        answer += 2
                break
    return answer
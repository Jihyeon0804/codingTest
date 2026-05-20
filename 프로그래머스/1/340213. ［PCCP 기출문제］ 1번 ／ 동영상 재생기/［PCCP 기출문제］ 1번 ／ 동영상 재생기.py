def minutesToSeconds(pos):
    m, s = map(int, pos.split(':'))
    return m * 60 + s

def solution(video_len, pos, op_start, op_end, commands):
    
    sec = minutesToSeconds(pos)
    start_sec = minutesToSeconds(op_start)
    end_sec = minutesToSeconds(op_end)
    video_sec = minutesToSeconds(video_len)

    for c in commands:
    
        # 오프닝 구간
        if start_sec <= sec <= end_sec:
            sec = end_sec

        # prev
        if c == "prev":
            sec -= 10
            if sec < 0:
                sec = 0

        # next
        else:
            sec += 10
            if sec > video_sec:
                sec = video_sec
    
        if start_sec <= sec <= end_sec:
            sec = end_sec

    return f"{sec//60:02d}:{sec%60:02d}"
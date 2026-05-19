import re
def solution(new_id):
    answer = re.sub('[^a-z\d\-\_\.]', '', new_id.lower())
    answer = re.sub('\.\.+', '.', answer)
    answer = answer.strip('.')
    if answer == '':
        answer ='a'
    if len(answer) >= 16:
        answer = answer[0:15].strip('.')  
    while len(answer) < 3:
        answer += answer[-1:]
    return answer
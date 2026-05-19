def solution(id_list, report, k):
    cnt = {}
    lst = {}
    answer = [0] * len(id_list)
    report = set(report)
    for i in report:
        user_id, warn_id = i.split(' ')
        if warn_id not in cnt:
            cnt[warn_id] = 1
        else:
            cnt[warn_id] += 1
        if user_id not in lst:
            lst[user_id] = [warn_id]
        else:
            if warn_id not in lst[user_id]:
                lst[user_id] += [warn_id]
    for id_, n  in cnt.items():
        if n >= k:
            for user, user2 in lst.items():
                if id_ in user2:
                    answer[id_list.index(user)] += 1
    return answer
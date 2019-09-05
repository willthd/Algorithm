def solution(N, stages):
    dict_ = {}
    for i in range(N):
        stage = i + 1
        challenging = 0
        challenged = 0
        for e in stages:
            if e > stage:
                challenged += 1
            elif e == stage:
                challenged += 1
                challenging += 1
        ratio = 0
        if challenged != 0:
            ratio = challenging / challenged
        dict_[i] = ratio
    result =  sorted(dict_, key=lambda x: dict_[x], reverse=True)
    answer = list(map(lambda x: x+1, result))
    return answer
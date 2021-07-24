# codilty 4-2, maxCounters
def solution(N, A):
    result = [0] * N
    cnt = 0
    max_ = 0
    
    for e in A:
        if e == N+1:
            cnt = max_
        else:
            result[e-1] = max(cnt, result[e-1])
            result[e-1] += 1
            max_ = max(max_, result[e-1])
    
    return [cnt if e <= cnt else e for e in result]
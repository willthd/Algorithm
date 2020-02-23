A = [2,1,5,1,2,2,2]
K=3
M=5

def check(A, max_sum, K):
    cnt = 0
    tmp_sum = 0
    for e in A:
        if tmp_sum + e > max_sum:
            cnt += 1
            tmp_sum = e
        else:
            tmp_sum += e

    # cnt가 나눗 횟
    if cnt + 1 <= K:
        return True

    return False


def solution(K, _, A):
    M = max(A)
    sum_ = sum(A)
    N = len(A)

    if N == 1:
        return sum_

    beg = M
    end = sum_
    result = sum_

    while beg <= end:
        mid = (beg + end) // 2
        valid = check(A, mid, K)
        if valid:
            end = mid - 1
            result = mid
        else:
            beg = mid + 1

    return result

print(solution(K, M, A))
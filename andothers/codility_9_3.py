def solution(A):
    if len(A) == 1:
        return A[0]
    local_max = A[0]
    global_max = A[0]
    print(A)
    for e in A[1:]:
        local_max = max(e, e + local_max)
        global_max = max(global_max, local_max)
        print(local_max, global_max)
    print()
    return global_max

A = [3,2,-6,4,0]
print(solution(A))
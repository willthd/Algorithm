def solution(A):
    if len(A) <= 1:
        return 0

    min_ = A[0]
    diff = A[1] - A[0]
    result = 0
    
    for i in range(1, len(A)):
        min_ = min(min_, A[i])
        diff = A[i] - min_
        result = max(result, diff)
        
    return result

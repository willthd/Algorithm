def solution(A):
    from collections import Counter
    cnt = Counter(A)

    for i in range(1, len(A)+1):
        if i not in cnt:
            return i

    return len(A)+1

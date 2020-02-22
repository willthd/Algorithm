from collections import Counter

def solution(A):
    positive_A = list(filter(lambda x: x > 0, A))
    counter = Counter(positive_A)
    sorted_cnt = sorted(list(counter.keys()))
    for i, e in enumerate(sorted_cnt):
        if (i+1) != e:
            return (i+1)
    return (len(sorted_cnt)+1)

# N = 10
# S = 15
# arr_ = [5, 1, 3, 5, 10, 7, 4, 9, 2, 8]
from sys import stdin
N, S = map(int, stdin.readline().split())
arr_ = list(map(int, stdin.readline().split()))

def sumOfSub(arr_, S):
    st = 0
    end = 0
    sum_ = 0
    result = 100101

    for st in range(N):
        while sum_ < S and end < N:
            sum_ += arr_[end]
            end += 1

        if sum_ >= S:
            print("***")
            print(st, end)
            result = min(result, end - st)

        sum_ -= arr_[st]

    if result == 100101:
        return 0
    return result

print(sumOfSub(arr_, S))
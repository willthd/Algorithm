from sys import stdin as std

n = int(std.readline())
r = int(std.readline())
a = [0] * r

# f2, 순열에서 사용
check = [False] * n

# # f3, 변형된 순열에서 사용
# # 어떤 종류의 숫자를 넣을 것인지
# num = []
# for i in range(n):
#     num.append(int(std.readline()))
# # 몇 개의 종류의 숫자가 있는지
# m = int(std.readline())
# # 각 숫자가 몇 개씩 있는지
# count = []
# for i in range(m):
#     count.append(int(std.readline()))

# 중복 순열, n파이r, (1~5 중에서 3개 뽑아서 중복 o, 순서 o)
def f1(dep):
    if (dep == r):
        for i in range(r):
            print(a[i], end='')
        print()
        return
    for i in range(n):
        a[dep] = i + 1
        f1(dep + 1)


# 순열, nPr, (1~5 중에서 3개 뽑아서 중복 x, 순서 o)
def f2(dep):
    if (dep == r):
        for i in range(r):
            print(a[i], end='')
        print()
        return
    for i in range(n):
        if (check[i]):
            continue
        check[i] = True
        a[dep] = i + 1
        f2(dep + 1)
        check[i] = False


# # 변형된 중복순열 (일부 중복 o, 순서 o)
# # 기본적으로 순열은 서로 다른 수들을 순서 있게 나열 하는 것이지만, n개의 수 중에서 일부가 겹치는 경우 있다
# # 이 때 수를 나열하는 방법. 즉 일부 중복 가능, 순서 있는 나열. 여기선 총 숫자의 개수가 n개이고, 종류는 4개, cnt[]는 4가지
# # 종류가 n개중 몇 개씩 있는지
# # 1,1,2,2,3,5,5,5, 8 중 5개 뽑아서 순열
# def f3(dep):
#     if (dep == r):
#         for i in range(r):
#             print(a[i], end='')
#         print()
#         return
#     for i in range(m):
#         if (count[i] == 0):
#             continue
#         count[i] -= 1
#         a[dep] = num[i]
#         f3(dep + 1)
#         count[i] += 1


# 조합, nCr, (1~5 중에서 3개 뽑아서 중복 x, 순서 x)
def f4(dep, st):
    if (dep == r):
        for i in range(r):
            print(a[i], end='')
        print()
        return
    for i in range(st, n):
        a[dep] = i + 1
        f4(dep + 1, i + 1)

# 조합은 사실 for문 두 개로 간단히 끝나기도 한다
for i in range(n):
    for j in range(i+1, n):
        print(i, j)


# 중복 조합, nHr, (1~5 중에서 3개 뽑아서 중복 o, 순서 x)
def f5(dep, st):
    if (dep == r):
        for i in range(r):
            print(a[i], end='')
        print()
        return
    for i in range(st, n):
        a[dep] = i + 1
        f5(dep + 1, i)

# 중복 조합 역시 for문 두 개로 간단히 끝난다
for i in range(n):
    for j in range(i, n):
        print(i, j)

# f1(0)
# f2(0)
f3(0)
# f4(0, 0)
# f5(0, 0)
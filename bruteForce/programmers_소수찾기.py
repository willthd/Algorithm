
def f1(dep, n, a, r, result, check, numbers):
    if (dep == r):
        str_ = ''
        for i in range(r):
            str_ += a[i]
        int_ = int(str_)
        result.append(int_)
        return
    for i in range(n):
        if check[i]:
            continue
        check[i] = True
        a[dep] = numbers[i]
        f1(dep + 1, n, a, r, result, check, numbers)
        check[i] = False

def check_sosu(num):
    flag = True
    if num == 0 or num == 1:
        flag = False
    for i in range(2, int(num**(1/2)+1)):
        if (num % i == 0):
            flag = False;
    return flag

def solution(numbers):
    answer = 0
    n = len(numbers)
    result = []
    check = [False] * n
    for i in range(1, n+1):
        a = [0] * i
        f1(0, n, a, i, result, check, numbers)
    result = list(set(result))
    print(result)
    for num in result:
        if (check_sosu(num)):
            print(num)
            answer += 1
    return answer

# numbers = "17"
print(solution("039"))

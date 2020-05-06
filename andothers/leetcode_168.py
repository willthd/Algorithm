# leetcode, 168, Excel Sheet Column Title
# 나누기와 관련한 문제는 아래와 같은 방식으로 푼다. 자주 틀림.
def convertToTitle(n):
    str_ = ''
    while n != 0:
        n -= 1
        temp = chr(ord("A") + (n % 26))
        str_ = temp + str_
        n //= 26
    return str_

from sys import stdin as std

n,k = map(int,std.readline().split())

d = [0 for i in range(k+1)]
d[0] = 1

for i in range(n):
    coin = int(std.readline())
    for money in range(coin,k+1):
        d[money] += d[money-coin]

print(d[k])
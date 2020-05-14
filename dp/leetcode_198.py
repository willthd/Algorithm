# leetcode, dp, 198, house robber
def rob(nums):
    dp = [None for i in range(len(nums) + 1)]
    dp[0] = 0
    dp[1] = nums[0]
    for i in range(1, len(nums)):
        dp[i + 1] = max(dp[i], dp[i - 1] + nums[i])
    return max(dp)

print(rob([2,7,9,3,1]))
# Two pointer
# 크기 상관 없이 임의의 자연수로 이루어진 배열이 있을 때, 합이 target과 동일한 연속 수열의 개수를 구하라
class Solution:
    def threeSumClosest(nums, target) -> int:
        end = 0
        sum_ = 0
        result = 0

        for start in range(len(nums)):
            while sum_ < target and end < len(nums):
                sum_ += nums[end]
                end += 1
            if sum_ == target:
                result += 1
            sum_ -= nums[start]

        return result


nums = [1, 23, 2, 3, 5, 7]
target = 5
sol = Solution
print(sol.threeSumClosest(nums, target))

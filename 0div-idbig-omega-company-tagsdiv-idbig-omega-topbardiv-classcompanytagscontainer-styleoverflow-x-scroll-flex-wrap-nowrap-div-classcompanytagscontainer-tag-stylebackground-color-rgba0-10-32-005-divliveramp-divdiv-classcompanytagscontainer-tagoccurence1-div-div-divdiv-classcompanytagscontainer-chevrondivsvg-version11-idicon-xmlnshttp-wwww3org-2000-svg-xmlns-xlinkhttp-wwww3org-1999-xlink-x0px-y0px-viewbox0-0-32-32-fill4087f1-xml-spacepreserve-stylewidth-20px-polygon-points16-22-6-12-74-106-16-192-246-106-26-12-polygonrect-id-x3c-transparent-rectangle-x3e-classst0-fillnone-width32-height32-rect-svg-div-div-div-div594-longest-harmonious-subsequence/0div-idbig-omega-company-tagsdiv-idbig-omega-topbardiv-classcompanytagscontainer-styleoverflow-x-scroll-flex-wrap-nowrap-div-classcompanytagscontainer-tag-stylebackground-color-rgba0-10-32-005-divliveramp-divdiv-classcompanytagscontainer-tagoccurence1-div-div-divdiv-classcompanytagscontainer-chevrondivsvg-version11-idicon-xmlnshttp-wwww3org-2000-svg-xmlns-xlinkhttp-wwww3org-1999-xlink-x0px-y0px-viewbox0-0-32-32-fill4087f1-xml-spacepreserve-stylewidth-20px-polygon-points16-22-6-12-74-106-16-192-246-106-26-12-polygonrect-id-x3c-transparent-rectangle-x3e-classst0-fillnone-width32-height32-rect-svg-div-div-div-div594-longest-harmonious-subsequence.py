class Solution:
    def findLHS(self, nums: List[int]) -> int:
        from collections import Counter
    
        num_freq = Counter(nums)
        max_length = 0

        for num in num_freq:
            if num + 1 in num_freq:
                length = num_freq[num] + num_freq[num + 1]
                max_length = max(max_length, length)

        return max_length
class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        m = max(nums)
        n = min(nums)
        target=[]
        for i in range(n, m):
            if i not in nums:
                target.append(i)
        return target
        
        
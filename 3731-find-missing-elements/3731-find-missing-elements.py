class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        nums_set=set(nums)
        m = max(nums)
        n = min(nums)
        target=[]
        for i in range(n, m):
            if i not in nums_set:
                target.append(i)
        return target
        
        
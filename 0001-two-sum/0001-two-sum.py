class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        lst=[]
        n=len(nums)
        for i in range(n-1):
            for j in range(i+1, n):
                if nums[i] + nums[j]== target:
                    lst.append(i)
                    lst.append(j)
                    return lst
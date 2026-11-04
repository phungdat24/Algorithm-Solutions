class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}                      # giá trị -> chỉ số
        for i, x in enumerate(nums):
            need = target - x
            if need in seen:
                return [seen[need], i]
            seen[x] = i
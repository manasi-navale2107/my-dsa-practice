class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None
        Do not return anything, modify nums in-place instead.
        """

        low = 0
        current = 0
        high = len(nums) - 1

        while current <= high:

           
            if nums[current] == 0:
                nums[current], nums[low] = nums[low], nums[current]
                low += 1
                current += 1

           
            elif nums[current] == 2:
                nums[current], nums[high] = nums[high], nums[current]
                high -= 1


            else:
                current += 1
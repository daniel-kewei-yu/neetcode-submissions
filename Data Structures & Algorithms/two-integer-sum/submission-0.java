class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (target == sum && i != j) {
                    return new int[]{Math.min(i, j), Math.max(i, j)};
                }
            }
        }
        return new int[]{};
    }
}

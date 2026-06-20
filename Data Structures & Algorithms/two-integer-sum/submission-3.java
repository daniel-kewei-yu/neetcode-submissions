class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Create a HashMap to store the value and index
        Map<Integer, Integer> map = new HashMap<>();

       for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            //Check if the map has the complement
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            //If it does not have the complement, add the current value and its index to the map
            map.put(nums[i], i);
        }
        //If no solution, return empty array
        return new int[] {};
    }
}
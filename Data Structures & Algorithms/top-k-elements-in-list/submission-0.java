class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map the integer and the frequency
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Create an array of lists to store elements by frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : counts.keySet()) {
            int frequency = counts.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        // Gather the top K frequent elements from right to left
        int[] result = new int[k];
        int index = 0;

        // Iterate backwards from the maximum possible frequency down to 0
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    // Stop immediately if we have collected K elements
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (counter.containsKey(nums[i])) return true;
            counter.put(nums[i], 1);
        }

        return false;
    }
}
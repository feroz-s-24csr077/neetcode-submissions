

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Arrays.sort(nums);

        int[] value = new int[nums.length];
        int[] freq = new int[nums.length];
        int count = 0;

        // Store unique values and their frequencies
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            value[count] = nums[i];
            freq[count] = j - i;
            count++;
            i = j;
        }

        int[] ans = new int[k];

        // Find top k frequencies
        for (int x = 0; x < k; x++) {
            int max = 0;
            for (int y = 1; y < count; y++) {
                if (freq[y] > freq[max]) {
                    max = y;
                }
            }
            ans[x] = value[max];
            freq[max] = -1; // Mark as used
        }

        return ans;
    }
}
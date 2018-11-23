package LeetCode.Q349;

import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (Integer num : nums2) {
            if (set.contains(num)){
                list.add(num);
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
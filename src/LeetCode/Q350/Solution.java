package LeetCode.Q350;

import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (Integer num : nums1) {
            if (!treeMap.containsKey(num)){
                treeMap.put(num,1);
            }else {
                treeMap.put(num,treeMap.get(num) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (Integer num : nums2) {
            if (treeMap.containsKey(num)){
                list.add(num);
                treeMap.put(num, treeMap.get(num) - 1);
                if (treeMap.get(num) == 0)
                    treeMap.remove(num);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
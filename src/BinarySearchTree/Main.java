package BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        /*Random random = new Random();

        int n = 1000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMin());
        }

        System.out.println(nums);
        System.out.println(nums.size());

        for (int i = 1 ; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error");
        }
        System.out.println("OK No problem");*/

        int[] nums = {5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        bst.remove(3);
        System.out.println(bst);

        //层序遍历
        //bst.levelOrder();


        /*//前序遍历
        bst.preOrder();
        System.out.println();

        //非递归前序遍历
        bst.preOrderNR();
        System.out.println();

        //中序遍历
        bst.inOrder();
        System.out.println();
        //后序遍历
        bst.postOrder();
        System.out.println();*/

        //System.out.println(bst.toString());
    }
}

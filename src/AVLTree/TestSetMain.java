package AVLTree;

import java.util.ArrayList;

public class TestSetMain {
    private static double testSet(Set<String> set){
        long startTime = System.nanoTime();

        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",word1);
        System.out.println("总次数:"+word1.size());

        for (String word : word1) {
            set.add(word);
        }
        System.out.println("不同的词数"+set.getSize());

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        BSTSet<String> bstSet = new BSTSet<String>();
        double time1 = testSet(bstSet);
        System.out.println("bstSet:"+time1);

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<String>();
        double time2 = testSet(linkedListSet);
        System.out.println("linkedListSet:"+time2);

        System.out.println();

        AVLSet<String> avlSet = new AVLSet<String>();
        double time3 = testSet(avlSet);
        System.out.println("avlSet:"+time3);
    }
}

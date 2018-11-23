package Map;

import Set.Set;

import java.util.ArrayList;

public class Main {

    private static double testSet(Map<String,Integer> map){
        long startTime = System.nanoTime();

        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",word1);
        System.out.println("总词数:"+word1.size());

        for (String word : word1) {
            if (map.contains(word))
                map.add(word,map.get(word) + 1);
            else
                map.add(word,1);
        }
        System.out.println("不同的词数"+map.getSize());
        System.out.println("不同的words:"+map.getSize());
        System.out.println("pride出现次数:"+map.get("pride"));

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<String, Integer>();
        double time1 = Main.testSet(linkedListMap);
        System.out.println("linkedListMap:" + time1);
        BSTMap<String,Integer> bstMap = new BSTMap<String, Integer>();
        double time2 = Main.testSet(bstMap);
        System.out.println("BSTMap:" + time2);
    }
}

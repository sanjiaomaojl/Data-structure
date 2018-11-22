package Set;

import java.util.ArrayList;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<E>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        //基于二分搜索树的Set
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",word1);
        System.out.println("总次数:"+word1.size());

        BSTSet<String> set1 = new BSTSet<String>();
        for (String word : word1) {
            set1.add(word);
        }
        System.out.println("不同的词数"+set1.getSize());
    }
}

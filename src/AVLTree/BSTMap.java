package AVLTree;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    private Node getNode(Node node, K key){
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }
        else if (key.compareTo(node.key) > 0){
            return getNode(node.right, key);
        }
        else {
            return node;
        }
    }

    @Override
    public void add(K key, V value){
        root = add(root,key,value);
    }
    //以node为根的二分搜索树添加元素e，递归算法
    //返回出入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){

        if (node == null){
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(node.left,key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right,key, value);
        else { //key.compareTo(node.key) = 0
            node.value = value;
        }

        return node;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    //删除以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    // 从二分搜索树中删除键为key的节点
    public V remove(K key) {
        Node node = getNode(root,key);
        if (node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    // 删除掉以node为根的二分搜索树中K为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, K key){
        if(node == null)
            return null;

        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }
        else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else {//e.compareTo(node.e) == 0
            // 待删除节点左子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况

            // 找到 比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        if (node == null)
            return null;
        return node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root,key);
        if (node != null)
            node.value = value;
        else
            throw new IllegalArgumentException(key + " doesn't exist!");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList();

        FileOperation.readFile("pride-and-prejudice.txt",words);
        System.out.println("总词数:"+words.size());
        BSTMap<String,Integer> bstMap = new BSTMap<String,Integer>();
        for (String word : words) {
            if (!bstMap.contains(word)){
                bstMap.add(word,1);
            }else {
                bstMap.add(word,bstMap.get(word)+1);
            }
        }
        System.out.println("不同的words:"+bstMap.getSize());
        System.out.println("pride出现次数:"+bstMap.get("pride"));
    }
}

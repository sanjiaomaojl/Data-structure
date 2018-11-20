package HashTable;

import java.util.TreeMap;

public class HashTable<K,V> {
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    private static final int upperTol = 10;
    private static final int lowTol = 2;
    private int capacityIndex = 0;

    private TreeMap<K,V>[] hashTable;
    //长度 ，合适的素数
    private int M;
    private int size;

    public HashTable(){
        this.M = capacity[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) / M;
    }
    //添加元素
    public void add(K key, V value){
        TreeMap<K,V> map = hashTable[hash(key)];
        if (map.containsKey(key))
            map.put(key,value);
        else {
            map.put(key,value);
            size++;

            if (size >= upperTol * M && capacityIndex+1 < capacity.length){
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }

        }
    }
    //删除元素
    public V remove(K key){
        TreeMap<K,V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)){
            ret = map.get(key);
            size--;

            if (size < lowTol*M && capacityIndex-1 > 0)
                capacityIndex--;
                resize(M / 2);
        }
        return ret;
    }
    //改
    public void set(K key,V value){
        TreeMap<K,V> map = hashTable[hash(key)];
        if (!map.containsKey(key)){
            throw new IllegalArgumentException(key+"doesn't exist");
        }
        map.put(key, value);
    }
    //存在吗？
    public boolean contains(K key){
        return hashTable[hash(key)].containsKey(key);
    }
    //某一个键对应的值
    public V get(K key){
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM){
        TreeMap<K,V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> map = hashTable[i];
            for (K key : map.keySet())
                newHashTable[hash(key)].put(key,map.get(key));
        }
        this.hashTable = newHashTable;
    }
}

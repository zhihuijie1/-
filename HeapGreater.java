package P1_Heap;
// 加强堆


import java.util.*;

// 前置知识
class ExtendedKnowledge {

    // 1：统计每个数字出现的次数
    private int statistics(int[] array,int key) {
        // hashmap中key是唯一的，value是可以有重复的
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        // 记录数组中每个数字出现的次数  Key-Value 模型，
        for (int i = 0; i < array.length; i++) {
            if(hashMap.containsKey(array[i])) {
                hashMap.put(array[i],hashMap.get(array[i]) + 1);
            }else {
                hashMap.put(array[i], 1);
            }
        }

        return hashMap.get(key);
    }
}
    // 2：手写一个哈希桶
class HashBuck<K,V> {
    class node<K,V> {
        K key;
        V val;
        node next;
        public node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    int usedSize = 0;
    node[] array;

    public HashBuck() {
        array = new node[8];
    }
    //                                                     没有    ->头插->usedsize++->判断是否扩容->进行扩容重新分配
    // put: 1: key->hashcode->index  2: 遍历array[index]桶，有key对象->修改其val,
    public void put(K key, V val) {
        int index = key.hashCode() % array.length;
        node<K,V> cur = array[index];
        while(cur != null) {
            if(cur.key.equals(key)) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        // 没找到 or 该位置数组无链表
        // 头插
        node<K,V> nod = new node(key,val);
        nod.next = array[index];
        array[index] = nod;
        usedSize++;
        // 判断是否负载因子
        if(usedSize * 1.0 / array.length > 0.75) {
            // 数组扩容，重新分配
            node<K,V>[] newArray = new node[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                cur = array[i];
                while(cur != null) {
                    int newIndex = cur.key.hashCode() % newArray.length;
                    // 头插
                    // 先保存一下下一位置
                    node<K,V> curNext = cur.next;
                    cur.next = newArray[newIndex];
                    newArray[newIndex] = cur;
                    cur = curNext;
                }
            }
            array = newArray;
        }
    }
    public V get(K key) {
        int index = key.hashCode() % array.length;
        node<K,V> cur = array[index];
        while(cur != null) {
            if(cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}
// for test
class person {
    int ID;
    String name;
    public person(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass() ) {
            return false;
        }
        person person = (person)obj;
        return ID == ((P1_Heap.person) obj).ID;
    }

    @Override
    public int hashCode() {
        // 根据ID来给出hashcode
        return Objects.hash(ID);
    }
    //                                        2：只重写equals不重写hashcode：会导致大量的相同对象分散在散列表的不同位置
    // 重写hashcode的时候也要重写equals方法：原因：1：只重写hashccode不重写equals:会导致大量的相同对象在同一个哈希桶中堆积。
}

class Test {
    public static void main(String[] args) {
        HashBuck<person,Integer> hashBuck2 = new HashBuck<>();
        hashBuck2.put(new person(1),1);
        hashBuck2.put(new person(1),2);
        hashBuck2.put(new person(3),3);
        hashBuck2.put(new person(5),4);
        hashBuck2.put(new person(8),5);
        hashBuck2.put(new person(10),6);
        hashBuck2.put(new person(16),7);
    }
}
public class HeapGreater<T> {

    private ArrayList<T> heap;
    private HashMap<T,Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> comp;

    private HeapGreater (Comparator<? super T> c) {
        comp = c;
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
    }

    public boolean isEmpty() {
        if(heapSize == 0) {
            return true;
        }else {
            return false;
        }
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj); // O（logN）
    }

    public T peek() {
        if(this.isEmpty()) {
            // 抛异常
        }
        return this.heap.get(0);
    }

    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj,heapSize);
        heapSize++;
        heapInsert(heapSize);
    }

    public T pop() {
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        // 删除数组中指定位置的元素
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    public void remove(T obj) {

    }

    public void resign(T obj) {

    }

    public List<T> getAllElements() {

    }

    private void heapInsert(int index) {
        while(comp.compare(heap.get(index) , heap.get((index - 1)/2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;


    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i,o2);
        heap.set(j,o1);
        indexMap.put(o1,j);
        indexMap.put(o2,i);
    }
}














package leetCode.done;

import java.util.HashMap;
import java.util.Map;

public class Question146 {
    class DLList{
        int key;
        int val;
        DLList pre;
        DLList next;

        public DLList() {
        }

        public DLList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    private int size;
    private Map<Integer,DLList> map=new HashMap<>();
    private DLList head,tail;

    public Question146(int capacity) {
        this.size=0;
        this.capacity=capacity;
        head=new DLList();
        tail=new DLList();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        DLList dlList = map.get(key);
        if (dlList==null){
            return -1;
        }
        moveToHead(dlList);
        return dlList.val;
    }

    public void put(int key, int value) {
        DLList dlList = map.get(key);
        if (dlList==null){
            DLList newNode=new DLList(key,value);
            map.put(key,newNode);
            addToHead(newNode);
            size++;
            if (size>capacity){
                DLList removeNode=removeTail();
                map.remove(removeNode.key);
                size--;
            }
        }else {
            //直接更新对应的节点
            dlList.val=value;
            moveToHead(dlList);
        }
    }

    private DLList removeTail() {
        DLList tailNode=tail.pre;
        removeNode(tailNode);
        return  tailNode;
    }

    private void moveToHead(DLList dlList) {
        removeNode(dlList);
        addToHead(dlList);
    }

    private void addToHead(DLList dlList) {
        //有着严格顺序
        dlList.next=head.next;
        dlList.pre=head;
        head.next.pre=dlList;
        head.next=dlList;
    }

    private void removeNode(DLList dlList) {
        dlList.pre.next=dlList.next;
        dlList.next.pre=dlList.pre;
    }

    public static void main(String[] args) {
        Question146 lRUCache=new Question146(2);
        lRUCache.put(1, 0); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}

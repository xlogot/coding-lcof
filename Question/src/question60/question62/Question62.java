package question60.question62;

import java.util.Iterator;
import java.util.LinkedList;

public class Question62 {
    static int lastRemaining(int numbers,int m){
        if (numbers<=1) return 0;
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i < numbers; i++) {
            list.add(i);
        }
        int count=0;
        Iterator<Integer> iterator ;
        while (list.size()!=1){
            iterator=list.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                count++;
                if (count >= m) {
                    System.out.println("删除: "+ next);
                    iterator.remove();
                    count=0;
                }
            }
        }
        return list.element();
    }
    //递归实现
    static int lastRemaining2(int numbers,int m){
        if (numbers==1) return 0;
        int temp=lastRemaining2(numbers-1,m);
        return (temp+m)%numbers;
    }
    //循环实现
    static int lastRemaining3(int numbers,int m){
        int result=0;
        for (int i = 2; i <= numbers; i++) {
            result=(result+m)%i;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = lastRemaining(5, 2);
        int i2 = lastRemaining2(5, 2);
        int i3 = lastRemaining3(5, 2);
        System.out.println(i+"======"+i2);
        System.out.println(i3);
    }
}

//class CircleChain {
//    int value;
//    CircleChain next;
//    int size;
//
//    public CircleChain() {
//    }
//
//    public CircleChain(int value) {
//        this.value = value;
//        size++;
//    }
//    void add(CircleChain head,int value){
//        while (head.next!=null){
//            head=head.next;
//        }
//        head.next=new CircleChain(value);
//        size++;
//    }
//    void  delete(int index){
//        CircleChain pre=this;
//        CircleChain rem=this;
//        int offset=1;
//        while (rem!=null&&index!=0){
//            if (offset==0) pre=pre.next;
//            else offset-=1;
//            rem=rem.next;
//            index--;
//        }
//        CircleChain next = rem.next;
//        if (next!=null) pre.next=next;
//        else rem=null;
//        size--;
//    }
//}

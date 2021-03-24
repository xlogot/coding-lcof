package question20.question24;

import question3.question06.ListNode;

import java.util.HashMap;

public class Question24_1 {
    static ListNode  reverseLink(ListNode head){
        if (head==null) return null;
        ListNode p1=null;
        ListNode p2=head;
        ListNode p3=head.next;
        while (p3!=null){
            p2.next=p1;
            p1=p2;
            p2=p3;
            p3=p3.next;
        }
        p2.next=p1;
        return p2;
    }

    public static void main(String[] args) {
        ListNode test=new ListNode();
        test.key=1;
//        test.next=test;
//        test.insertItem(2);
//        test.insertItem(3);
//        test.insertItem(4);
//        test.insertItem(5);
//        test.insertItem(6);
        test=reverseLink(test);
    }
}

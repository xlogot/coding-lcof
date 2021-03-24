package question20.question24;

import question3.question06.ListNode;


/*
* 反转链表
* 题目:定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。链表是单向链表.
 * */
public class Question24 {
    static ListNode reversedLink(ListNode head){
        if (head==null) return null;
        ListNode mid,nex,pre;
        pre=head;
        //一个节点
        if (head.next==null) return head;
        else{
            mid=head.next;
            //两个节点
            if (mid.next ==null) {
                mid.next=head;
                head.next=null;
                return mid;
            }
            nex=mid.next;
        }
        head.next=null;
        while (nex!=null){
            mid.next=pre;
            pre=mid;
            mid=nex;
            nex=nex.next;
        }
        mid.next=pre;
        return mid;
    }

    static ListNode reversedLink2(ListNode head){
        ListNode reversedHead=null;
        ListNode node=head;
        ListNode pre=null;
        while (node!=null){
            ListNode next=node.next;
            if (next==null) reversedHead=node;
            node.next=pre;
            pre=node;
            node=next;
        }
        return  reversedHead;
    }

    //自己实现
    static ListNode reversedLink3(ListNode head){
        if (head==null) return null;
        ListNode reversedHead=null;
        ListNode mid=head;
        ListNode pre=null;
        while (mid!=null){
            ListNode nex=mid.next;
            if (nex==null) reversedHead=mid;
            mid.next=pre;
            pre=mid;
            mid=nex;
        }
        return reversedHead;
    }

    public static void main(String[] args) {
        ListNode test=new ListNode();
        test.key=1;
        test.insertItem(2);
        test.insertItem(3);
        test.insertItem(4);
        test.insertItem(5);
        test.insertItem(6);
        test= reversedLink3(test);
    }
}

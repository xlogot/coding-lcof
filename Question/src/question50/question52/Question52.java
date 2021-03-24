package question50.question52;

import com.sun.source.tree.IfTree;
import question3.question06.ListNode;

public class Question52 {
    static ListNode findFirstCommonNode(ListNode head1,ListNode head2){
        if (head1==null||head2==null) return null;
        int length1=getListLength(head1);
        int length2=getListLength(head2);
        int offset=(length1>length2) ? length1-length2:length2-length1;
        ListNode longHead=head1;
        ListNode shortHead=head2;
        if (length1<length2){
            longHead=head2;
            shortHead=head1;
        }
        for (int i = 0; i < offset; i++) {
            longHead=longHead.next;
        }
        while (longHead!=null&&shortHead!=null&&(longHead.key!=shortHead.key)){
            longHead=longHead.next;
            shortHead=shortHead.next;
        }
        return longHead;
    }

    private static int getListLength(ListNode head1) {
        int length=0;
        while (head1!=null){
            length++;
            head1=head1.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode t1=new ListNode(1);
        ListNode t2=new ListNode(2);
        t1.next=t2;
        ListNode t3=new ListNode(3);
        t2.next=t3;
//        ListNode t6=new ListNode(6);
//        t3.next=t6;
//        ListNode t7=new ListNode(7);
//        t6.next=t7;

        ListNode t4=new ListNode(4);
        ListNode t5=new ListNode(5);
        t4.next=t5;/*t5.next=t6;*/
        ListNode firstCommonNode = findFirstCommonNode(t1, t4);
        System.out.println(firstCommonNode.key);
    }
}

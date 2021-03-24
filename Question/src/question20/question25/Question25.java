package question20.question25;

import org.w3c.dom.ls.LSException;
import question3.question06.ListNode;

import java.util.EnumSet;

public class Question25 {
    static ListNode merge(ListNode head1,ListNode head2){
        if (head1==null&&head2==null) return null;
        if (head1==null&&head2!=null) return head2;
        if (head2==null&&head1!=null) return head1;
        ListNode res=new ListNode();
        if (head1.key<head2.key){
            res.key=head1.key;
            res.next= merge(head1.next,head2);
        }else{
            res.key=head2.key;
            res.next= merge(head1,head2.next);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode t1=new ListNode();
        t1.key=1;
        t1.insertItem(3);
        t1.insertItem(5);
        t1.insertItem(7);
        t1.insertItem(9);
        ListNode t2=new ListNode();
        t2.key=2;
        t2.insertItem(4);
        t2.insertItem(6);
        t2.insertItem(8);
        t2.insertItem(10);
        ListNode merge = merge(null, null);
        ListNode.showItem(merge);
    }
}

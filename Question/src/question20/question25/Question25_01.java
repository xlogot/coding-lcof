package question20.question25;

import question3.question06.ListNode;

public class Question25_01 {
    /*
    这里注意可能需要创建新的指针, 因为使用head1, head2可能会造成混乱
     */
    static ListNode merge(ListNode head1,ListNode head2){
        if (head1==null&&head2==null) return null;
        if (head1!=null&&head2==null) return head1;
        if (head2!=null&&head1==null) return head2;
        ListNode resHead=null;
        if (head1.key<head2.key){
            resHead=new ListNode(head1.key);
            head1=head1.next;
        }else {
            resHead=new ListNode(head2.key);
            head2=head2.next;
        }
        ListNode result=resHead;
        while (head1!=null&&head2!=null){
            if (head1.key<head2.key){
                resHead.next=head1;
                head1=head1.next;
            }else {
                resHead.next=head2;
                head2=head2.next;
            }
        }
        if (head1!=null){
            resHead.next=head1;
        }else {
            resHead.next=head2;
        }
        return result;
    }
    static ListNode merge1(ListNode head1,ListNode head2){
        if (head1==null&&head2==null) return null;
        if (head1!=null&&head2==null) return head1;
        if (head2!=null&&head1==null) return head2;
        ListNode reh=new ListNode();
        if (head1.key<head2.key){
            reh.key=head1.key;
            reh.next=merge1(head1.next,head2);

        }else {
            reh.key=head2.key;
            reh.next=merge1(head1,head2.next);

        }
        return reh;
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
        ListNode merge = merge1(t1, t2);
    }
}

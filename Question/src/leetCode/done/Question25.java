package leetCode.done;

import leetCode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question25 {
    /**
     * 使用堆栈进行解决
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        int offset=k;
        Deque<Integer> stack=new ArrayDeque<>();
        ListNode lag=head;
        ListNode res=head;
        while (head!=null){
            if (offset>1){
                offset--;
                stack.push(head.val);
                head=head.next;
            }else {
                while (offset<=k){
                    lag.val=stack.pop();
                    lag= lag.next;
                    offset++;
                }
            }
        }
        if (offset>0){
            return res;
        }else {
            while (offset<k){
                lag.val=stack.pop();
                lag= lag.next;
                offset++;
            }
            return res;
        }
    }

    /**
     * 使用常数空间解决
     * 利用206题的反转链表进行解决.
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode pre=dummy;
        ListNode start=dummy.next;
        while (head!=null){
            for (int i=1;i<k&&head!=null;i++) head=head.next;
            if (head==null){
                break;
            }
            start=pre.next;
            ListNode next=head.next;
            head.next=null;
            pre.next= reverse(start);
            start.next=next;
            pre=start;
            head=next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode current=head;
        ListNode pre=null,next=null;
        while (current!=null){
            next=current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode t=new ListNode(1);
        int[] a={2,3,4,5};
        t.getNode(a, 0, t);
        Question25 q=new Question25();
        ListNode listNode = q.reverseKGroup(t, 2);
    }
}

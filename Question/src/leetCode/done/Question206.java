package leetCode.done;

import leetCode.common.ListNode;

import java.util.Stack;

public class Question206 {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        while (head!=null){
            stack.push(head );
            head=head.next;
        }
        ListNode res=stack.pop();
        ListNode t1=res;
        while (!stack.isEmpty()){
            t1.next=stack.pop();
            t1=t1.next;
        }
        t1.next=null;
        return res;
    }

    public static void main(String[] args) {
        ListNode l3=new ListNode(3);
        ListNode l2=new ListNode(2,l3 );
        ListNode l1=new ListNode(1,l2);
        Question206 t1=new Question206();
        ListNode listNode = t1.reverseList(l1);
    }
}

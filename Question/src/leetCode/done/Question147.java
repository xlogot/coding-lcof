package leetCode.done;

import leetCode.common.ListNode;

public class Question147 {
    public ListNode insertionSortList(ListNode head) {
        if (head==null) return null;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode lastSorted,pre;
        lastSorted=head;
        ListNode curr=head.next;
        while (curr!=null){
            if (curr.val>lastSorted.val){
                lastSorted=curr;
                curr=curr.next;
            }else {
                pre=dummy;
                while (pre.next.val<curr.val){
                    pre=pre.next;
                }
                lastSorted.next=curr.next;
                curr.next=pre.next;
                pre.next=curr;
                curr=lastSorted.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n=new ListNode(1);
//        int[]a ={2,3,4,5};
//        int[]a ={5,3,1,8,7,2,4};
//        n.getNode(a,0,n);
        Question147 q=new Question147();
        ListNode listNode = q.insertionSortList(n);

    }
}

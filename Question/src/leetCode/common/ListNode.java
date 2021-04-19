package leetCode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode getNode(int[] ints,int index,ListNode head){
        if (index>=ints.length) return null;

        while (head.next!=null){
            head=head.next;
        }
        head.next=new ListNode(ints[index]);
        return getNode(ints,index+1,head.next);
    }
}


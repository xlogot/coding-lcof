package question20.question22;


import question3.question06.ListNode;

public class Question22 {
    static ListNode findKthToTail(ListNode head,int k){
        if (head==null||k<=0) return null;
        ListNode oneStep=head;
        ListNode KStep=head;
        k=k-1;
        while (oneStep.next!=null){
            oneStep=oneStep.next;
            if (k!=0){
                k--;
            }else{
                KStep= KStep.next;
            }
        }
        if (k!=0) return null;
        return KStep;
    }

    //书上的解法
    static ListNode findKthToTail1(ListNode head,int k){
        if (head==null||k<=0) return null;
        ListNode oneStep=head;
        ListNode KStep=null;
        for (int i = 0; i < k - 1; i++) {
            if (oneStep.next!=null) oneStep=oneStep.next;
            else  return null;
        }
        KStep=head;
        while (oneStep.next!=null){
            oneStep=oneStep.next;
            KStep=KStep.next;
        }
        return KStep;
    }

    public static void main(String[] args) {
        ListNode test=new ListNode();
        test.key=1;
        test.insertItem(2);
        test.insertItem(3);
        test.insertItem(4);
        test.insertItem(5);
        test.insertItem(6);
        ListNode kthToTail = findKthToTail(test, 0);
    }
}

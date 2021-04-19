package leetCode.done;

import leetCode.common.ListNode;

public class Question148 {
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head==null) return null;
        if (head==tail) return head;
        ListNode l1=head;
        ListNode l2=head;
        int offset=1;
        while (l1.next!=null){
            if (offset>0){
                offset--;
            }else {
                offset=1;
                l2=l2.next;
            }
            l1=l1.next;
        }
        ListNode l3=l2.next;
        l2.next=null;
        ListNode list1=sortList(head,l2);
        ListNode list2=sortList(l3,l1);
        return mergeList(list1,list2);
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1==null||list2==null) return list1==null  ? list2:list1;
        ListNode next;
        ListNode dummy=new ListNode();
        if (list1.val<list2.val){
            dummy.next=list1;
        }else dummy.next=list2;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                //要找到最后一个比它大的元素, 不然会出问题.
                //还要注意等值的节点, 防止被吞.
                while (list1.next!=null&&list1.next.val<=list2.val){
                    list1=list1.next;
                }
                next= list1.next;
                list1.next=list2;
                list1=next;
            }else {
                while (list2.next!=null&&list2.next.val<=list1.val){
                    list2= list2.next;
                }
                next= list2.next;
                list2.next=list1;
                list2=next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n=new ListNode(6);
        int[]a ={2};
//        int[]a ={5,3,1,7,2,4};
        n.getNode(a,0,n);
        Question148 t=new Question148();
        ListNode listNode = t.sortList(n);

    }

}

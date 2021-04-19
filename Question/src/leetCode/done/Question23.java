package leetCode.done;


import leetCode.common.ListNode;

import java.util.PriorityQueue;

public class Question23 {
    class  Status implements Comparable<Status>{

        int value;
        ListNode node;

        public Status(ListNode node) {
            this.value = node.val;
            this.node = node;
        }

        //返回正数则停止循环, 不会将这个是对象放在首部.
        //因此, 可以假设,这个值为最小值, 当o变量(也就是队列的首部, 当前的最小值)时, 返回小于0的数, 因此会进行交换.
        @Override
        public int compareTo(Status o) {
            return this.value-o.value;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        ListNode preHead=new ListNode();

        ListNode head= preHead;

        PriorityQueue<Status> queue=new PriorityQueue<>();

        for(ListNode l:lists){
            if (l!=null){
                queue.offer(new Status(l));
            }
        }

        while(!queue.isEmpty()){
            Status poll = queue.poll();
            head.next=poll.node;
            if(poll.node.next!=null){
                queue.offer(new Status(poll.node.next));
            }
            head=head.next;
        }
        return preHead.next;
    }

    public ListNode mergeKLists1(ListNode[] lists){
        if (lists==null) return null;
        return  mergeList(lists,0,lists.length-1);
    }

    private ListNode mergeList(ListNode[] list, int left,int right) {
        if (left==right){
            return list[left];
        }
        if(left>right){
            return  null;
        }
        int mid=(right+left)/2;
        return mergeTwoLists(mergeList(list,left,mid),mergeList(list,mid+1,right));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null||l2==null){
            return l1!=null ? l1:l2;
        }
        ListNode preHead=new ListNode();
        ListNode head=preHead;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
                head=head.next;
            }else {
                head.next=l2;
                l2=l2.next;
                head=head.next;
            }
        }
        head.next=(l1!=null ? l1:l2);
        return  preHead.next;
    }


}

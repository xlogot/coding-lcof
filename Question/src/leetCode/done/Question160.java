package leetCode.done;

import com.sun.org.apache.xml.internal.utils.Hashtree2Node;
import com.sun.xml.internal.messaging.saaj.soap.ver1_2.Header1_2Impl;
import leetCode.common.ListNode;

public class Question160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=getLength(headA);
        int l2=getLength(headB);
        int offset=l1-l2;
        if (offset>0){
            while (headA!=null&&headB!=null&&headA!= headB){
                headA=headA.next;
                if (offset>0){
                    offset--;
                }else {
                    headB=headB.next;
                }
            }
        }else {
            while (headA!=null&&headB!=null&&headA!= headB){
                headB=headB.next;
                if (offset<0){
                    offset++;
                }else {
                    headB=headB.next;
                }
            }
        }
        return headA;
    }

    private int getLength(ListNode head) {
        int res=0;
        while (head!=null){
            head=head.next;
            res++;
        }
        return res;
    }
}

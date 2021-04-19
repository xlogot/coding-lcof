package leetCode.done;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import leetCode.common.ListNode;

public class Question141 {
    public boolean hasCycle(ListNode head) {
        byte offset=1;
        ListNode temp=head;
        ListNode lag=null;
        while (temp!=null&&lag!=temp){
            if (offset>0){
                offset--;
                lag=head;
            }else {
                lag=lag.next;
            }
            temp=temp.next;
        }
        if (temp==null){
            return false;
        }
        return true;
    }
}

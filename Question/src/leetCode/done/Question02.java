package leetCode.done;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import leetCode.common.ListNode;

public class Question02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int t=0;
        ListNode res=new ListNode();
        ListNode res1=res;
        if(l1==null||l2==null){
            return l1==null ? l2:l1;
        }
        while (l1!=null&&l2!=null){
            int v1=l1.val;
            int v2=l2.val;
            res.next=new ListNode((v1+v2+t)%10);
            t=(v1+v2+t)/10;
            res=res.next;
            l1=l1.next;
            l2=l2.next;
        }
        if (l1!=null){
            while (l1!=null){
                res.next=new ListNode((l1.val+t)%10);
                t=(l1.val+t)/10;
                res=res.next;
                l1=l1.next;
            }
        }else {
            while (l2!=null){
                res.next=new ListNode((l2.val+t)%10);
                t=(l2.val+t)/10;
                res=res.next;
                l2=l2.next;
            }
        }
        if (t!=0){
            res.next=new ListNode(t);
        }
        return res1.next;
    }

    public static void main(String[] args) {

    }
}

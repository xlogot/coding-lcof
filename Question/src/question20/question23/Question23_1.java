package question20.question23;

import question3.question06.ListNode;


public class Question23_1 {
    static ListNode findEntry(ListNode head){
        if (head==null) return null;
        int offset=1;
        int latency=1;
        ListNode temp=head;
        ListNode temp2=head;
        ListNode step2Pointer=head;
        while (head!=null){
            head=head.next;
            if (latency==0){
                step2Pointer=step2Pointer.next;
                if (offset>1&&head==step2Pointer) break;
                latency=1;
            }else {
                latency--;
            }
            offset++;
        }
        while(temp!=null){
            if (offset!=0){
                temp=temp.next;
                offset--;
            }else {
                temp2=temp2.next;
                temp=temp.next;
            }
            if (temp2==temp) break;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode test=new ListNode();
        test.key=1;
//        test.next=test;
        test.insertItem(2);
        test.insertItem(3);
        test.insertItem(4);
        test.insertItem(5);
        test.insertItem(6);
                ListNode t6=test;
        for (int i = 0; i <5; i++) {
            t6=t6.next;
        }
//                ListNode t2=test;
//        for (int i = 0; i <3; i++) {
//            t2=t2.next;
//        }
//        t6.next=test;
        ListNode entry = findEntry(test);


    }
}

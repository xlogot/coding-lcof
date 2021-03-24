package question20.question23;

import question3.question06.ListNode;


public class Question23 {
    static ListNode MeetingNode(ListNode head){
        if (head==null) return null;
        ListNode APointer=head;
        ListNode BPointer=head;
        do {
            if (APointer.next != null) {
                APointer = APointer.next;
            } else {
                return null;
            }
            if (APointer.next != null) {
                APointer = APointer.next;
            } else {
                return null;
            }
            if (BPointer.next != null) BPointer = BPointer.next;
            else {
                return null;
            }
        }while (APointer!=BPointer);
//        while (APointer.hashCode()!=BPointer.hashCode()) {
//            if (APointer.next != null) {
//                APointer = APointer.next;
//            } else {
//                return null;
//            }
//            if (APointer.next != null) {
//                APointer = APointer.next;
//            } else {
//                return null;
//            }
//            if (BPointer.next != null) BPointer = BPointer.next;
//            else {
//                return null;
//            }
//        }
        return BPointer;
    }
    static ListNode entryOfLoop(ListNode head){
        ListNode meetingNode=MeetingNode(head);
        if (meetingNode==null) return null;
        int numOfNodes=1;
        ListNode pointer=meetingNode.next;
        while (pointer!=meetingNode){
            pointer=pointer.next;
            numOfNodes++;
        }
        ListNode entry=head;
        for (int i = 0; i < numOfNodes; i++) {
            entry=entry.next;
        }
        ListNode pointerFindEntry=head;
        while (pointerFindEntry!=entry){
            pointerFindEntry=pointerFindEntry.next;
            entry=entry.next;
        }
        return entry;
    }

    public static void main(String[] args) {
        ListNode test=new ListNode();
        test.key=1;
//        test.next=test;
        test.insertItem(2);
        test.insertItem(3);
        test.insertItem(4);
        test.insertItem(5);
//        test.insertItem(6);
//        ListNode t1=test;
//        for (int i = 0; i < 5; i++) {
//            t1=t1.next;
//        }
//        ListNode t2=test;
//        for (int i = 0; i < 2; i++) {
//            t2=t2.next;
//        }
//        t1.next=t2;

        ListNode listNode = entryOfLoop(test);
    }
}

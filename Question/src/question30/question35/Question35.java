package question30.question35;

public class Question35 {
    static void cloneNodes(ComplexListNode head){
        ComplexListNode t1=head;
        while (t1!=null){
            ComplexListNode temp=new ComplexListNode();
            temp.next=t1.next;
            temp.value=t1.value;
            t1.next=temp;
            t1=temp.next;
        }
    }
    static void connectSiblingNodes(ComplexListNode head){
        ComplexListNode t1=head;
        while (t1!=null){
            if (t1.sibling!=null){
                t1.next.sibling=t1.sibling.next;
            }
            t1=t1.next.next;
        }
    }

    static ComplexListNode reconnectNodes(ComplexListNode head){
        int index=1;
        ComplexListNode returnNodeStart=head.next;
        ComplexListNode returnNodeEnd=returnNodeStart;
        ComplexListNode t1=head;
        ComplexListNode t1End=t1;
        head=returnNodeStart.next;
        while (head!=null){
            if (index++%2==0){
                returnNodeEnd.next=head;
                returnNodeEnd=returnNodeEnd.next;
            }else {
                t1End.next=head;
                t1End=t1End.next;
            }

            head=head.next;
        }
        t1End.next=null;
        return returnNodeStart;
    }
    static ComplexListNode clone(ComplexListNode head){
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    public static void main(String[] args) {
        ComplexListNode head=new ComplexListNode(1);
//        ComplexListNode head2=new ComplexListNode(2);
//        ComplexListNode head3=new ComplexListNode(3);
//        ComplexListNode head4=new ComplexListNode(4);
//        ComplexListNode head5=new ComplexListNode(5);
//
//        //测试1
////        head.sibling=head;
//
//        //测试2
////        head.next=head2;
////        head2.next=head3;
////        head3.next=head4;
////        head4.next=head5;
////        head.sibling=head3;
////        head2.sibling=head5;
////        head4.sibling=head2;

//        测试3
//        head.sibling=head2;
//        head.next=head2;
//        head2.sibling=head;

        //test4 only one single node

        ComplexListNode clone = clone(head);
    }
}

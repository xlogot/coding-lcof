package question10.question18;

public class Question18_02 {
    static LinkNode deleteDuplication(LinkNode head){
        if (head==null) return null;
        LinkNode res=head;
        LinkNode preNode=null;
        LinkNode next=head.next;
        boolean isDul=false;
        while (next!=null){
            if (head.value!=next.value){
                if (isDul) {
                    if (preNode==null) res=next;
                    else preNode.next=next;
                    isDul=false;
                }else {
                    preNode=head;
                }
            }else{
                isDul=true;
                if (next.next==null) {
                    res=null;
                    break;
                }
            }
            head=next;
            next=next.next;
        }
        if (isDul){
            preNode.next=null;
        }
        return res;
    }

    static LinkNode deleteDuplication1(LinkNode head){
        if (head==null) return null;

        LinkNode preNode=null;
        LinkNode node=head;
        while (node!=null){
            LinkNode next=node.next;
            boolean needDelete=false;
            if (next!=null&&next.value==node.value) needDelete=true;
            if (!needDelete){
                preNode=node;
                node=node.next;
            }else{
                //存在重复节点,进入循环,检索重复节点.
                while (next!=null&&next.value==node.value){
                    node=node.next;
                    next=node.next;
                }
                if (preNode==null) head=next;//重复节点在首部
                else preNode.next=next;
                node=next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        LinkNode head=new LinkNode(2);
        head.AddNode(head,2);
        head.AddNode(head,3);
        head.AddNode(head,3);
        head.AddNode(head,3);
        head.AddNode(head,5);
        head.AddNode(head,5);
//        head.AddNode(head,6);
        head = deleteDuplication1(head);
    }
}

package question10.question18;

/*
删除链表的节点.
 在0(1)时间内删除链表节点。给定单向链表的头指针和一个节点指针，定义一个函数在0(1)时间内删除该节点.
 */
public class Question18_01 {
    public static int deleteNode(LinkNode head, LinkNode nodeToBeDeleted){
        if (head==null||nodeToBeDeleted==null) return RetrunNumber.ERROR;
        if (head.next==null) {
            head=null;
            return RetrunNumber.ONLY_ONE_NODE;
        }
        //节点是尾部节点
        if (nodeToBeDeleted.next==null){
            while (head.next.value!=nodeToBeDeleted.value){
                head=head.next;
            }
            head.next=null;
            return RetrunNumber.NODE_IN_TAIL;
        }
        //把要删除节点i的下一个节点j的内容复制到节点i, 接下来再把节点i的指针替换成节点j的指针,删除节点j
        LinkNode next=nodeToBeDeleted.next;
        nodeToBeDeleted.value=next.value;
        nodeToBeDeleted.next=next.next;
        next.next=null;
        return RetrunNumber.NORMAL_DELETE;
    }
    public static  void test(LinkNode node){
        node=new LinkNode(22);
    }

    public static void main(String[] args) {
        LinkNode head=new LinkNode(1);
//        head.AddNode(head,2);
//        head.AddNode(head,3);
//        LinkNode deleted=head.next.next;
//        deleteNode(head,deleted);
        test(head);
    }
}

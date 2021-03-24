package question3.question06;

public class ListNode{
    public int key;
    public ListNode next;
    public ListNode(){}
    public ListNode(int item){
        this.key=item;
    }
    public void insertItem(int item){
        insert(item,this);
    }

    private void insert(int item,ListNode listNode){
        if (listNode.next==null) {
            listNode.next=new ListNode(item);
            return;
        }else insert(item,listNode.next);
    }

    public static   void  showItem(ListNode head){
        while (head!=null){
            System.out.printf("%d ", head.key);
            head=head.next;
        }
        System.out.println();
    }
}

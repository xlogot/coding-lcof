package leetCode;


import leetCode.common.Node;

public class Question138 {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node dummy=new Node(-1);
        dummy.next=head;
        while (head!=null){
            Node t1=new Node(head.val);
            Node next=head.next;
            t1.next=next;
            head.next=t1;
            head=next;
        }
        head=dummy.next;
        while (head!=null){
            if (head.random!=null)
            head.next.random=head.random.next;
            head=head.next.next;
        }
        Node res=dummy.next.next;
        Node res1=dummy.next.next;
        head=res1.next;
        Node head2=dummy.next;
        int index=1;
        while (head!=null){
            if ((index&1)==1){
                res1.next=head.next;
                res1=res1.next;
                head2.next=head;
                head2=head2.next;
            }
            head=head.next;
            index++;
        }
        head2.next=null;
        return res;
    }

    public static void main(String[] args) {
        Node t1=new Node(7);
        Node t2=new Node(13);
        Node t3=new Node(11);
        Node t4=new Node(10);
        Node t5=new Node(1);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        t2.random=t1;
        t3.random=t4;
        t4.random=t2;
        t5.random=t1;
        Question138 q=new Question138();
        q.copyRandomList(t1);
    }
}

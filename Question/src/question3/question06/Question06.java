package question3.question06;
/*
输入一个链表的头节点，从尾到头反过来打印出每个节点的值。链表的定义见ListNode类
 */
import java.util.Stack;

public class Question06 {
    public static void printReversedLink(ListNode head){
        //判断判断是否为空节点。
        if (head==null)return;
        Stack<ListNode> stack=new Stack<>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().key);
        }
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode();
        listNode.key=1;
        listNode.insertItem(2);
        listNode.insertItem(3);
        listNode.insertItem(4);
        listNode.insertItem(5);
        listNode.insertItem(6);
        printReversedLink(listNode);
    }

}


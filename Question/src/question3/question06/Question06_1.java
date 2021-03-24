package question3.question06;

import java.util.Stack;

public class Question06_1 {
    static void printLinkReversely(ListNode list){
        if(list==null) return;
        Stack<ListNode> stack=new Stack<>();
        while (list!=null){
            stack.add(list);
            list=list.next;
        }
        while(!stack.empty()){
            System.out.println(stack.pop().key);
        }
    }

    static void  recursivePrintList(ListNode list){
        if (list==null)return;
        else recursivePrintList(list.next);
        System.out.println(list.key);
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.insertItem(2);
        l1.insertItem(3);
        l1.insertItem(4);
        l1.insertItem(5);
        recursivePrintList(l1);
    }
}

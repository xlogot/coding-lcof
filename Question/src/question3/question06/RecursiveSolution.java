package question3.question06;
/*
如果使用栈结构来实现输出的话，可以通过递归来实现这种输出。
 */
public class RecursiveSolution {
    static void printLinkRecursively(ListNode l1){
        if (l1==null) return;
        if (l1.next==null){
            System.out.println(l1.key);
            return;
        }
        printLinkRecursively(l1.next);
        System.out.println(l1.key);

//        if (l1.next!=null){
//            printLinkRecursively(l1.next);
//        }
//        System.out.println(l1.key);
    }
    public static void main(String[] args) {
        ListNode listNode=new ListNode();
        listNode.key=1;
        listNode.insertItem(2);
        listNode.insertItem(3);
        listNode.insertItem(4);
        listNode.insertItem(5);
        listNode.insertItem(6);
        printLinkRecursively(listNode);
    }
}

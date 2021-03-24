package question30.question35;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Question35_01 {
    //用hashMap实现的解法
    static ComplexListNode replicate(ComplexListNode root ){
        if (root==null) return null;
        ComplexListNode temp=root;
        ComplexListNode result=null;
        ComplexListNode temp1=null;
        HashMap<ComplexListNode,ComplexListNode> set=new HashMap<>();
        if (temp != null) {
            temp1 = new ComplexListNode(temp.value);
            if (temp.sibling != null) {
                ComplexListNode node = new ComplexListNode(temp.sibling.value);
                set.put(temp.sibling,node);
                temp1.sibling = node;
            }
            temp = temp.next;
            result = temp1;
        }
        //为了防止有空指针, 不能让temp1为空, 不然不能定位到复制链表的尾部
        while (temp!=null){

            if (set.containsKey(temp)){
                temp1.next=set.get(temp);
            }else {
                temp1.next = new ComplexListNode(temp.value);
            }
            if (temp.sibling != null) {
                if (!set.containsKey(temp.sibling)){
                    ComplexListNode node = new ComplexListNode(temp.sibling.value);
                    set.put(temp.sibling, node);
                    temp1.next.sibling = node;
                }else {
                    ComplexListNode node = set.get(temp.sibling);
                    temp1.next.sibling=node;
                }
            }
            temp1=temp1.next;
            temp=temp.next;
        }
        return result;
    }
    //分离链表的方法实现的.
    static ComplexListNode replicate1(ComplexListNode root ){
        ComplexListNode replicatePointer=root;
        ComplexListNode index=root;
        //加长链表
        while (index!=null){
            index=index.next;
            ComplexListNode node=new ComplexListNode(replicatePointer.value);
            replicatePointer.next=node;
            node.next=index;
            replicatePointer=index;
        }
        //将新节点的sibling赋值
        ComplexListNode index1=root;
        while (index1!=null){
            if (index1.sibling!=null){
                index1.next.sibling=index1.sibling.next;
                index1=index1.next;
            }
            //防止单节点的问题
            if (index1==null) break;
            index1=index1.next;
        }
        //分离链表
        int old=1;
        ComplexListNode returnNodeStart=root.next;
        ComplexListNode returnNodeEnd=returnNodeStart;
        ComplexListNode t1End=root;
        root=returnNodeStart.next;
        while (root!=null){
            if (old++%2==0){
                returnNodeEnd.next=root;
                returnNodeEnd=returnNodeEnd.next;
            }else {
                t1End.next=root;
                t1End=t1End.next;
            }

            root=root.next;
        }
        t1End.next=null;
        return returnNodeStart;
    }

    public static void main(String[] args) {
        ComplexListNode head=new ComplexListNode(1);
        ComplexListNode head2=new ComplexListNode(2);
        ComplexListNode head3=new ComplexListNode(3);
        ComplexListNode head4=new ComplexListNode(4);
        ComplexListNode head5=new ComplexListNode(5);

        //测试1
//        head.sibling=head;

        //测试2
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        head.sibling=head3;
        head2.sibling=head5;
        head4.sibling=head2;
        //        测试3
//        head.sibling=head2;
//        head.next=head2;
//        head2.sibling=head;
        ComplexListNode root = replicate1(head);
    }
}

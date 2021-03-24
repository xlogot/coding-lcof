package question20.question22;

import question10.question18.LinkNode;

import java.sql.SQLOutput;

public class Question22_1 {
    static boolean result=false;
    static int lastKthNode(LinkNode head,int k){
        if (head==null||k<=0) return -1;
        int t=lastKthNodeCore(head,k);
        if (result) return t;
        else return -1;
    }

    private static int lastKthNodeCore(LinkNode head, int k) {
        if (head==null) return 0;
        int depth=lastKthNodeCore(head.next,k);
        if (result){
            return depth;
        }
        depth+=1;
        if (depth==k){
            result=true;
            return head.value;
        }else {
            return depth;
        }
    }

    static int lastKthNode1(LinkNode head,int k){
        LinkNode rarePointer=head;
        int kOffset=k;
        while (head!=null){
            head=head.next;
            if (kOffset>0){
                kOffset--;
            }else {
                rarePointer=rarePointer.next;
            }
        }
        if (kOffset>0){
            return -1;
        }
        return rarePointer.value;
    }

    public static void main(String[] args) {
        LinkNode head=new LinkNode(1);
        head.AddNode(head,2);
        head.AddNode(head,3);
//        head.AddNode(head,4);
//        head.AddNode(head,5);
//        head.AddNode(head,6);
        int i = lastKthNode1(head, 1);
        System.out.println(i);
    }
}

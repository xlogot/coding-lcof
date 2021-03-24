package question30.question37;

import question3.question07.Question07;
import question3.question07.Traversal;
import question3.question07.TreeNode;

public class Question37 {

    public static String serialize(TreeNode head){
        if (head==null) return null;
        StringBuilder stringBuilder=new StringBuilder();
        serialize(head,stringBuilder);
        return stringBuilder.toString();
    }

    public static void serialize(TreeNode head,StringBuilder stringBuilder){
        if (head==null){
            stringBuilder.append("$");
            return;
        }
        stringBuilder.append(head.key);
        serialize(head.left,stringBuilder);
        serialize(head.right,stringBuilder);
    }

    public static TreeNode deserialize(String inputStream){
        if (inputStream==null) return null;
        Index index=new Index();
        index.index=0;
        return deserializeCore(inputStream,index);
    }

    private static TreeNode deserializeCore(String inputStream,Index index) {
        TreeNode head;
        if (index.index>=inputStream.length()) return null;
        if (inputStream.charAt(index.index)=='$')  return null;
        head=new TreeNode(Integer.parseInt(String.valueOf(inputStream.charAt(index.index))));
        index.index++;
        head.left=deserializeCore(inputStream,index);
        index.index++;
        head.right=deserializeCore(inputStream,index);
        return head;
    }

    public static void main(String[] args) {
//        int[] pre={1,2,4,3,5,6};
//        int[] mid={4,2,1,5,3,6};
        int[] pre={1,2,3};
        int[] mid={3,2,1};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        String serialize = serialize(t2);
        TreeNode deserialize = deserialize(serialize);
        Traversal.traversal(deserialize);
    }
}
class Index{
    int index;
}

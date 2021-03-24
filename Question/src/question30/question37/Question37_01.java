package question30.question37;

import question3.question07.Question07;
import question3.question07.TreeNode;
import question30.question32.Question32_02;

public class Question37_01 {
    static String serialize(TreeNode root){
        if (root==null) return "$";
        return serialize1(root);
    }
    static String serialize1(TreeNode root){
        if (root==null) return "$,";
        StringBuilder sb=new StringBuilder();
        sb.append(root.key+",");
        String c1 = serialize1(root.left);
        sb.append(c1);
        String c2 = serialize1(root.right);
        sb.append(c2);
        return sb.toString();
    }
    static TreeNode deserialize(String s){
        if (s==null||s.equals("")||s.equals("$")) return null;
        Index index=new Index();
        index.index=0;
        return deserialize(s,index);

    }

    private static TreeNode deserialize(String s, Index index) {
        if (index.index>=s.length()-1) return null;
        String number = getNumber(s, index);
        TreeNode root;
        if (number!=null&&!number.equals("$")){
            int i = Integer.parseInt(number);
            root=new TreeNode(i);
        }else {
            return null;
        }
        root.left=deserialize(s,index);
        root.right=deserialize(s,index);
        return root;
    }

    private static String getNumber(String s,Index index) {
        int sI=index.index;
        while (index.index<s.length()&&s.charAt(index.index)!=','){
            index.index++;
        }
        int length=index.index-sI;
        char[] chars=new char[length];
        if (index.index<s.length()){
            s.getChars(sI, index.index, chars, 0);
            String s1 = String.valueOf(chars);
            index.index++;
            return s1;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
            int[] pre = {1, 2, 4, 3, 5, 6};
            int[] mid = {4, 2, 1, 5, 3, 6};
//        int[] pre={1,2,3};
//        int[] mid={3,2,1};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        String serialize = serialize(t2);
        String substring = serialize.substring(0, serialize.length() - 1);
        TreeNode deserialize = deserialize(substring);
        Question32_02.print(deserialize);
    }
    static class Index{
        int index;
    }
}

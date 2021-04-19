package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question394 {
    public String decodeString(String s) {
        Deque<Integer> numsStack=new ArrayDeque<>();
        Deque<String> strStack=new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int nums=0;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (chars[i]>='0'&&chars[i]<='9'){
                nums=nums*10+(chars[i]-'0');
            }else if ((chars[i]>='a'&&chars[i]<='z')||(chars[i]>='A'&&chars[i]<='Z')){
                sb.append(chars[i]);
            }else if (chars[i]=='['){
                numsStack.push(nums);
                nums=0;
                strStack.push(sb.toString());
                sb.delete(0,sb.length());
            }else{
                Integer pop = numsStack.pop();
                StringBuilder temp=new StringBuilder();
                temp.append(strStack.pop());
                for (int j=0;j<pop;j++){
                    temp.append(sb);
                }
                sb=temp;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "3[a2[c]]";
//        String s = "2[abc]3[cd]ef";
        String s = "3[a]2[bc]";
        Question394 t=new Question394();
        String s1 = t.decodeString(s);
        System.out.println(s1);
    }
}

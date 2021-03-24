package question50;

import java.util.concurrent.FutureTask;

public class Question50_1 {
    static char firstNotRepeatingChar(char[] chars){
        int[] map=new int[26];
        for (int i = 0; i < chars.length; i++) {
            int i1 = chars[i] - 'a';
            map[i1]++;
        }
        char result='-';
        for (int i : map) {
            if (map[i]==1){
                result= (char) ('a'+i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1="abaccdeff";
        char c = firstNotRepeatingChar(s1.toCharArray());
        System.out.println(c);
    }
}

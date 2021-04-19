package question50;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Question50_01_01 {
    static char  firstNumber(String s){
        if (s==null||s.equals("")) return '\u0000';
        HashMap<Character,Integer> map=new HashMap<>();
        char c='\u0000';
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c1=chars[i];
            if (map.containsKey(c1)){
                Integer integer = map.get(c1);
                map.replace(c1,integer+1);
            }else {
                map.put(c1,1);
            }
        }
        for (int i=0;i<chars.length;i++){
            char c1=chars[i];
            Integer count = map.get(c1);
            if (count==1){
                c=c1;
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String a="a/wwdfas,dfwefasdfsdaf'/";
//        String a="aaabccedff";
        System.out.println(firstNumber(a));
    }
}

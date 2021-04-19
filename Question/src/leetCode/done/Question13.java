package leetCode.done;

import java.util.HashMap;

public class Question13 {
    public long romanToInt(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        char[] chars = s.toCharArray();
        int curr=0;
        long count=0;
        for (int i=chars.length-1;i>=0;i--){
            Integer integer = hashMap.get(chars[i]);
            if (curr <= integer){
                curr=integer;
                count=count+integer;
            }else{
                count=count-integer;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String a="MCMXCIV";
//        String a="LVIII";
        String a="IV";
        Question13 t=new Question13();
        long l = t.romanToInt(a);
        System.out.println(l);
    }
}

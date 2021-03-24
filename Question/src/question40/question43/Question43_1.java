package question40.question43;

import java.util.EnumSet;

public class Question43_1 {
    static int findNums(int n){
        if (n<=0) return -1;
        Integer integer=n;
        String s = integer.toString();
        return numsOf1(s.toCharArray());
    }

    private static int numsOf1(char[] s) {
        int first=s[0]-'0';
        int length=s.length;
        if (length==1&&first==0){
            return 0;
        }
        if (length==1&&first>0){
            return 1;
        }

        int firstBitNums=0;
        if (first>1){
            firstBitNums=powerBase10(length-1);
        }else if (first==1){
            String s1 = String.valueOf(s).substring(1);
            firstBitNums=Integer.parseInt(s1)+1;
        }

        int secondBitNums=0;
        secondBitNums=first*(length-1)*powerBase10(length-2);

        int lastNums=0;
        String substring = String.valueOf(s).substring(1);
        lastNums = numsOf1(substring.toCharArray());

        return firstBitNums+secondBitNums+lastNums;
    }

    private static int powerBase10(int i) {
        int result=1;
        for (int j = 0; j < i; j++) {
            result*=10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findNums(21345));
    }
}

package question3.question05;

import java.time.chrono.AbstractChronology;

public class Question05_1 {
    static String replaceBlank(String string){
        if (string==null)  return null;
        int numberOfBlank= getNumberOfBlank(string);
        int n=numberOfBlank*2+string.length();

        int builderIndex=n-1;
        StringBuilder b1=new StringBuilder();
        b1.setLength(n);

        char[] stringChars = string.toCharArray();
        for (int i=stringChars.length-1;i>=0&&builderIndex>=0;i--){
            if (stringChars[i]==' '){
                builderIndex-=3;
                b1.insert(builderIndex,"%20");
            }else {
                b1.insert(builderIndex,stringChars[i]);
                builderIndex--;
            }
        }
        return b1.toString();
    }

    private static int getNumberOfBlank(String string) {
        char[] chars = string.toCharArray();
        int number=0;
        for (char aChar : chars) {
            if (aChar==' ') number++;
        }
        return number;
    }

    public static void main(String[] args) {
        String s1="you are my love";
        String s2 = replaceBlank(s1);
        System.out.println(s2);
    }
}

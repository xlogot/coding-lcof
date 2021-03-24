package question40.question48;

import javax.print.DocFlavor;
import java.nio.channels.Pipe;

public class Question48 {
    static int longestSubstringWithoutDuplication(String string){
        if (string==null) return -1;
        if (string.length()==1) return 1;
        int maxLength=0;
        int currentLength=0;
        int[] position=new int[126-32+1];
        for (int i =0;i<position.length;i++) {
            position[i]=-1;
        }
        for (int i = 0; i < string.length(); i++) {
            int preIndex=position[string.charAt(i)-' '];
            if (preIndex<0||i-preIndex>currentLength){
                currentLength++;
            }else{
                if (currentLength>maxLength) maxLength=currentLength;
                currentLength=i-preIndex;
            }
            position[string.charAt(i)-' '] =i;
        }
        if (currentLength>maxLength) maxLength=currentLength;
        return maxLength;
    }

    public static void main(String[] args) {
        String s1="  ";
//        String s1="arabcacfr";
        int i = longestSubstringWithoutDuplication(s1);
        System.out.println(i);
    }
}

package question50.question58;


public class Question58 {
    public static void reverse(char[] chars,int head,int tail){
        char temp;
        while (head<tail){
            temp=chars[head];
            chars[head++]=chars[tail];
            chars[tail--]= temp;
        }
    }
    static void reverseString(String str){
        if (str==""||str==null) return;
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length-1);
        int startIndex=0;
        int wordLength=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==' '){
                if (wordLength!=0)
                    reverse(chars,startIndex,wordLength+startIndex-1);
                wordLength=0;
                startIndex=i+1;
            }else wordLength++;
        }
        System.out.println(String.valueOf(chars));
    }

    public static void main(String[] args) {
        String a="i  am  a student";
        reverseString(a);
    }
}

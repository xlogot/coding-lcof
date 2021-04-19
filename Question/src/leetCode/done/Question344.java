package leetCode.done;

public class Question344 {
    public void reverseString(char[] s) {
        if (s==null||s.length==0) return;
        int index1=0;
        int index2=s.length-1;
        char temp;
        while (index1<index2){
            temp=s[index1];
            s[index1]=s[index2];
            s[index2]=temp;
            index1++;
            index2--;
        }
    }

    public static void main(String[] args) {
//        String s="hello";
        String s="h";
        Question344 t=new Question344();
        char[] chars = s.toCharArray();
        t.reverseString(chars);
        for (char c:chars){
            System.out.print(c);
        }
        System.out.println();
    }
}

package question50.question58;

public class Question58_2 {
    static char[] leftRotateString(String str,int index){
        if (str==""||str==null) return null;
        char[] chars = str.toCharArray();
        Question58.reverse(chars,0,index);
        Question58.reverse(chars,index+1,chars.length-1);
        Question58.reverse(chars,0,chars.length-1);
        return chars;
    }

    public static void main(String[] args) {
        String a="abcdefg";
        char[] chars = leftRotateString(a, 2);
        String s = String.valueOf(chars);
        System.out.println(s);
    }
}


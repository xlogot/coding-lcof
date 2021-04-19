package leetCode.done;

public class Question09 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s=String.valueOf(x);
        int index=0;
        int index1=s.length()-1;
        while (index<=index1){
            if(s.charAt(index++)!=s.charAt(index1--)){
                return  false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        int x=90;
        Question09 t1=new Question09();
        boolean palindrome = t1.isPalindrome(x);
        System.out.println(palindrome);
    }
}

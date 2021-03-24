package question60.question67;

public class Question67 {
    static boolean result=true;
    static long stringToInteger(String str){
        if (str==null||str=="") {
            result=false;
            return -1;
        }
        char[] chars = str.toCharArray();
        long number=0;
        boolean IsNegative=false;
        if (chars[0]=='-'){
            IsNegative=true;
        }
        for (int i=IsNegative ? 1:0;i<chars.length;i++){
            if (chars[i]>='0'&&chars[i]<='9'){
                number=number*10+(chars[i]-'0');
            }else {
                result=false;
                return -1;
            }
        }
        return IsNegative ? 0-number:number;
    }

    public static void main(String[] args) {
        String a="1234";
        long i = stringToInteger(a);
        System.out.println(i);
        System.out.println(result);
    }
}

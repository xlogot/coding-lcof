package question40.question43;

public class Question43 {
    static int numberOf1Between1AndN(int n){
        if (n<=0) return 0;
        Integer number=n;
        String strN = number.toString();
        char[] chars = strN.toCharArray();
        return numberOf1(chars);
    }

    private static int numberOf1(char[] strN) {
        int first=strN[0]-'0';
        int length=strN.length;
        if (length==1&&first==0){
            return 0;
        }
        if (length==1&&first>0){
            return 1;
        }
        int nunFirstDigit=0;
        if (first>1){
            //记住这个
            nunFirstDigit=powerBase10(length-1);
        }else if (first==1){
            String s = String.valueOf(strN);
            String substring = s.substring(1);
            //记住这个公式
            nunFirstDigit=Integer.parseInt(substring)+1;
        }

        //记住这个,分成几段,然后,每段能有几次.
        int numOtherDigits = first * (length - 1) * powerBase10(length - 2);

        String s = String.valueOf(strN);
        String substring = s.substring(1);
        //递归进行求解,剩下的数
        int numRecursive=numberOf1(substring.toCharArray());

        return nunFirstDigit+numOtherDigits+numRecursive;
    }

    private static int powerBase10(int i) {
        //长度为2时, i为0,因此result直接返回1
        int result=1;
        for (int j = 0; j < i; j++) {
            result*=10;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = numberOf1Between1AndN(1111111);
        System.out.println(i);
    }
}

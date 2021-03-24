package question40.question46;

public class Question46 {
    static int getTranslateCount(int number){
        if (number<0) return -1;
        return getTranslateCount(String.valueOf(number));
    }
    static int getTranslateCount(String number){
        int length = number.length();
        int[] counts = new int[number.length()];
        int count=0;
        for (int i=length-1;i>=0;i--){
            count=0;
            if (i<length-1){
                count=counts[i+1];
            }else {
                count=1;
            }
            if (i<length-1){
                int currentDigit=number.charAt(i)-'0';
                int nextDigit=number.charAt(i+1)-'0';
                int numberWithTwoDigits=currentDigit*10+nextDigit;
                if (numberWithTwoDigits>=10&&numberWithTwoDigits<=25){
                    if (i<length-2){
                        count+=counts[i+2];
                    }else {
                        count+=1;
                    }
                }
            }
            counts[i]=count;
        }
        count=counts[0];
        return count;
    }

    public static void main(String[] args) {
        int translateCount = getTranslateCount(26);
        System.out.println(translateCount);
    }
}

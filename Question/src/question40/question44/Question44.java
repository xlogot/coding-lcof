package question40.question44;

import java.net.Inet4Address;
import java.util.concurrent.*;

public class Question44 {
    static int digitAtIndex(int index){
        if (index<0) return -1;
        int digits=1;
        while (true){
            int numbers= countOfIntegers(digits);
            if (index<numbers*digits)
                return digitAtIndex(index,digits);
            index-=(numbers*digits);
            digits++;
        }
    }

    private static int digitAtIndex(int index, int digits) {
        int numbers = index / digits;
        int bit=index-(numbers*digits);
        int startNum= startNumber(digits);

        String s = String.valueOf(startNum + numbers);
        Integer integer = Integer.parseInt(s.substring(bit,bit+1));
        return integer;
    }

    private static int startNumber(int digits) {
        if (digits==1) return 0;
        return (int)Math.pow(10,digits-1);
    }

    private static int countOfIntegers(int digits) {
        if (digits==1) return 10;
        int pow = (int)Math.pow(10, digits - 1);
        int result=9*pow;
        return result;
    }

    public static void main(String[] args) {
        int i = digitAtIndex(1000);
        System.out.println(i);
    }
}

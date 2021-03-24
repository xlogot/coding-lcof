package question40.question44;

public class Question44_01 {
    static int digitAtIndex(int n){
        if (n<0) return -1;
        if (n<10){
            return n;
        }
        int bits=1;
        long total = totalDigits(bits);
        while(n>total){
            n=(int)(n-total);
            bits++;
            total=totalDigits(bits);
        }
        if (n==10){
            return 1;
        }
        int indexBit=n%bits;
        int num=n/bits;
        int initialNumber=getNum(bits);
        num=initialNumber+num;
        return getIndex(num,indexBit);

    }

    private static int getIndex(int num, int indexBit) {
        String s = String.valueOf(num);
        char c = s.charAt(indexBit);
        return Integer.parseInt(String.valueOf(c));
    }

    private static int getNum(int bits) {
        int i=1;
        for (int j=1;j<bits;j++){
            i=i*10;
        }
        return i;
    }

    private static long totalDigits(int bits) {
        if (bits==1) return 10;
        long i=9;
        for (int j=1;j<bits;j++){
            i=i*10;
        }
        return i*bits;
    }

    public static void main(String[] args) {
        int i = digitAtIndex(1000000000);
        System.out.println(i);
    }
}

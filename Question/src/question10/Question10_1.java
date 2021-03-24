package question10;

import org.w3c.dom.ls.LSOutput;

public class Question10_1 {
    public static long fibonacci1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    public static long fibonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n < 0) return -1;

        int temp0 = 0;
        int temp1 = 1;
        int j=0;
        for (int i = 2; i <= n; i++) {
            j = temp0 + temp1;
            temp0 = temp1;
            temp1 = j;
        }
        return j;
    }

    public static void main(String[] args) {
        long l = fibonacci1(10);
        long a = fibonacci2(10);
        System.out.println(l);
        System.out.println(a);
        System.out.println(a == l);
    }
}

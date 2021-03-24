package question40.question49;


public class Question49_solution1 {
    static boolean isUgly(int number){
        while (number%2==0) number/=2;
        while (number%3==0) number/=3;
        while (number%5==0) number/=5;
        return number == 1;
    }
    static int getUglyNumber(int index){
        int index0=1;
        int number=0;
        while (index0<index){
            ++number;
            if (isUgly(number)){
                ++index0;
            }
        }
        return number;
    }
}

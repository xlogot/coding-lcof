package question10.question16;

public class Question16_1 {
    static double power(double base,int exponent){
        if (exponent==0) return 1;
        boolean minus=false;
        if (exponent<0){
            exponent=0-exponent;
            minus=true;
        }
        double result=1;
        for (int i=1;i<=exponent;i++){
            result=result*base;
        }
        if (minus){
            return 1/result;
        }else {
            return result;
        }
    }
}

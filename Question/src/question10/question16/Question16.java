package question10.question16;

public class Question16 {
    static PowerWithExpo powerCore;

    public static void setPowerCore(PowerWithExpo p) {
        powerCore = p;
    }

    static double power(double base, int exponent) throws Exception {
        if (base==0&&exponent<0){
            throw new Exception("invalid input");
        }
        int absExpo=0;
        if (exponent<0 ) absExpo=-exponent;
        double result= powerCore.power(base,absExpo);
        if (exponent<0) result=1/result;
        return result;
    }

    public static void main(String[] args) throws Exception {
        setPowerCore(new IterPower());
        System.out.println(power(-2, -2));
    }
}

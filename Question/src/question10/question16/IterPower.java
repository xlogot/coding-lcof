package question10.question16;

public class IterPower implements PowerWithExpo {
    @Override
    public double power(double base,int absExpo) {
        double result=1;
        for (int i = 0; i < absExpo; i++) {
            result*=base;
        }
        return result;
    }
}

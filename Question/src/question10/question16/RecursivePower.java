package question10.question16;

import java.util.Arrays;

public class RecursivePower implements PowerWithExpo {
    //可以使用额外的空间存储计算过程.
    @Override
    public double power(double base, int absExpo) {
        if (absExpo==0) return 1;
        if (absExpo==1) return base;

        double result=power(base,absExpo>>1);
        result*=result;
        if ((absExpo&0x1)==1) result=result*base;
        return result;
    }


    //自己实现的
    //    @Override
//    public double power(double base, int absExpo) {
//        double result=1;
//        if (absExpo==0){
//            return 1;
//        }
//        if (absExpo==1){
//            return  base;
//        }
//        if (absExpo%2==0){
//            result= power(base,absExpo/2)*power(base, absExpo/2);
//        }else{
//            result= power(base,(absExpo-1)/2)*power(base, (absExpo-1)/2)*base;
//        }
//        return result;
//    }
}

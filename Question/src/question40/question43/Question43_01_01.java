//package question40.question43;
//
//public class Question43_01_01 {
//    static int countNumber(int n){
//        int i;
//        int temp=0;//先求有几位数
//        for (i=10;n%i>0;i*=10){
//            temp++;
//        }
//        int count=0;
////        for (int j=temp;j>0;j--){
////            int mod = (int) Math.pow(10, j);
////            int num=n%mod;
////            for (int k=num;k>=0;k--){
////
////            }
////        }
//        int mod = (int) Math.pow(10, temp);//10的次方
//        int num=n%mod;//求最高位有几位数
//        for (int k=num;k>=0;k--){
//            if (k==1){
//                count=count(k*mod,k*mod+mod)+mod+count;
//            }else if (k==num){
//                count+=count(k*mod,n);
//            }else {
//                count+=count(k*mod,k*mod+mod);
//            }
//        }
//        return count;
//    }
//
//    private static int count(int start, int end) {
//        int zero_9=1;
//        int ten_19=10;
//        int leftNumber=end-start;
//
//    }
//}

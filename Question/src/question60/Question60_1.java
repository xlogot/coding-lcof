package question60;

public class Question60_1 {
    static final int maxValue=6;
    static void printProbability(int number){
        if (number<1)return;
        int maxSum=number*maxValue;
        int[] probabilities=new int[maxSum-number+1];
        probability(number,probabilities);
        for (int i = number; i <= maxSum; i++) {
            System.out.println(probabilities[i - number]);
        }
    }

    private static void probability(int number, int[] probabilities) {
        for (int i = 1; i <= maxValue; i++) {
            //有两个堆, 一对只有一个, 另外一堆有n-1个,对只有一个的堆计算6次.
            probability(number,number,/*number*maxValue-*/i,probabilities);
        }
    }

    private static void probability(int original, int current, int sum, int[] probabilities) {
        if (current==1){
            probabilities[sum-original]++;
        }else {
            for (int i = 1; i <= maxValue; i++) {
                //计算每6个的值.
                //这里会有大量的重复计算
                probability(original,current-1,sum+i,probabilities);
            }
        }
    }

    public static void main(String[] args) {
        printProbability(2);
    }
}


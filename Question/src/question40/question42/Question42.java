package question40.question42;

public class Question42 {
    static int findGreatesSumofSubArray(int[] array,int length) throws Exception {
        if (array==null||length<=0) throw new Exception("error");
        int curSum=0;
        int greatestSum=0;
        for (int i = 0; i < length; i++) {
            if (curSum<=0){
                curSum=array[i];
            }else {
                curSum+=array[i];
            }
            if (curSum>greatestSum){
                greatestSum=curSum;
            }
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int[] array={1,-2,3,10,-4,7,2,-5};
        int maxSum = 0;
        try {
            maxSum = findGreatesSumofSubArray(array, array.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(maxSum);

        System.out.println(((1 << 5) - 1));
    }
}

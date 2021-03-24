package question40.question42;


public class Question42_01 {
    static void maxSum(int[] array) {
        if (array == null || array.length <= 0) return;
        int maxNum = array[array.length - 1];
        int[] maxNums = new int[array.length];
        maxNums[array.length - 1] = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            int temp;
            temp = maxNums[i + 1] + array[i];

            if (temp < 0) {
                if (array[i] > 0) {
                    maxNums[i] = array[i];
                    temp = array[i];
                    continue;
                }
            }
            if (maxNum <= temp) {
                maxNum = temp;
            }
            maxNums[i] = temp;
        }
        System.out.println(maxNum);
    }

    public static void main(String[] args) {
//        int[] a={1,-2,3,10,-4,7,2,-5};
        int[] a = {3, 10, -4, 7, 2};
        maxSum(a);
    }
}

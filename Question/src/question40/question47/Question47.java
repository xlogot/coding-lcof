package question40.question47;

import java.util.concurrent.*;

public class Question47 {
    static int getMaxValue_solution1(int[] values,int rows,int cols){
        if (values==null||rows<0||cols<0) return -1;
        int[][] resultMatrix=new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int up=0;
                int left=0;
                if (j>0){
                    up=resultMatrix[i][j-1];
                }
                if (i>0){
                    left=resultMatrix[i-1][j];
                }
                resultMatrix[i][j]=Math.max(up,left)+values[j*cols+i];
            }
        }
        int maxValue=resultMatrix[cols-1][rows-1];
        return maxValue;
    }
    static int getMaxValue_solution2(int[] values,int rows,int cols){
        if (values==null||rows<0||cols<0) return -1;
        int[] resultMatrix=new int[rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int up=0;
                int left=0;
                if (j>0){
                    up=resultMatrix[j-1];
                }
                if (i>0){
                    left=resultMatrix[j];
                }
                resultMatrix[j]=Math.max(up,left)+values[j*cols+i];
            }
        }
        int maxValue=resultMatrix[rows-1];
        return maxValue;
    }

    public static void main(String[] args) {
        int[] a1={1,12,3,8,10,2,9,6,5,7,4,11,3,7,16,5};
//        int[] a1={1,10,3,12,2,9,5,7,4,3,7,16};
        ExecutorService es=new ThreadPoolExecutor(5,5,0, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>()){
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
            }

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
            }

            @Override
            protected void terminated() {
                super.terminated();
            }
        };
//        int[] a1={1,10,3,8};
        int maxValue_solution1 = getMaxValue_solution2(a1, 4, 4);
        int maxValue_solution2 = getMaxValue_solution1(a1, 4, 4);
        System.out.println(maxValue_solution1);
    }
}

package question10.question13;

public class P1 {
    public int checkSum(int threshold,int rows,int cols){
        if (threshold<0||rows<=0||cols<=0) return 0;
        boolean[] visited=new boolean[rows*cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i]=false;
        }
        int result=checkSumCore(threshold,rows,cols,0,0,visited);
        return result;
    }

    private int checkSumCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int sum=0;
        if (checkNode(threshold,rows,cols,row,col,visited)){
            sum=1+
                    checkSumCore(threshold, rows, cols, row-1, col, visited)+
                    checkSumCore(threshold, rows, cols, row+1, col, visited)+
                    checkSumCore(threshold, rows, cols, row, col-1, visited)+
                    checkSumCore(threshold, rows, cols, row, col+1, visited);

        }
        return sum;
    }

    private boolean checkNode(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row>=0&&row<rows&&col>=0&&col<cols
            &&countSum(row)+countSum(col)<=threshold&&
                !visited[row * cols + col])
            return true;
        else return false;
    }

    private int countSum(int number) {
        int sum=0;
        while (number>0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }
}

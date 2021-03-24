package question10.question13;

public class Question13 {
    //threshold为位数和
    public int movingCount(int m, int n,int k){
        if (m<0||n<=0||k<=0) return 0;
        boolean[] visited=new boolean[n*k];
        for (int i = 0; i < k * n; i++) {
            visited[i]=false;
        }
        int count=movingCountCore(m,n,k,0,0,visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count=0;
        if (check(threshold,rows,cols,row,col,visited)){
            visited[row*cols+col]=true;
            count=1+
                    movingCountCore(threshold, rows, cols, row-1, col, visited)+
                    movingCountCore(threshold, rows, cols, row+1, col, visited)+
                    movingCountCore(threshold, rows, cols, row, col-1, visited)+
                    movingCountCore(threshold, rows, cols, row, col+1, visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row>=0&&row<rows&&col>=0&&col<cols
            &&getDigitSum(row)+getDigitSum(col)<=threshold
                &&!visited[row*cols+col]
        )   return true;
        else  return false;
    }

    private int getDigitSum(int number) {
        int sum=0;
        while (number>0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }
}

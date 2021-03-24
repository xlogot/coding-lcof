package question40.question47;

public class Question47_01 {
    static int maxNumber(int[][] grid){
        int cols=grid.length;
        int rows=grid[0].length;
        int[] counts=new int[cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                int up=0;
                int left=0;
                if (i>0){
                    up=counts[j];
                }
                if (j>0){
                    left=counts[j-1];
                }
                counts[j]=Math.max(up,left)+grid[j][i];
            }
        }
        return counts[cols-1];
    }

    public static void main(String[] args) {
//        int[][] a ={{1,2,5},{3,2,1}};
        int[][] a ={{1,10,5,3},{12,2,7,7},{3,9,4,16},{8,6,11,5}};
        int i = maxNumber(a);
        System.out.println(i);
    }
}

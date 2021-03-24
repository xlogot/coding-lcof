package question3.question04;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Question04_1 {
    static boolean isExist(int[][] matrix,int number){
        if (matrix==null) return false;
        boolean result=false;
        for (int i=0;i<matrix.length;i++){
            result=result||isExist(matrix,number,i,0);
            if (result){
                return result;
            }
        }
        return result;
    }

    private static boolean isExist(int[][] matrix, int number, int yIndex,int xIndex) {
        if (xIndex>=matrix[0].length) return false;
        if (matrix[yIndex][xIndex]==number){
            return true;
        }else if (matrix[yIndex][xIndex]>number){
            return false;
        }else {
            return isExist(matrix, number, yIndex, ++xIndex);
        }
    }

    static boolean find(int[][] matrix,int number){
        if (matrix==null) return false;
        int xIndex=matrix[0].length-1;
        int yIndex=0;
        while (yIndex<matrix.length&&xIndex>=0){
            if (matrix[yIndex][xIndex]>number){
                xIndex--;
            }else if (matrix[yIndex][xIndex]<number){
              yIndex++;
            }else return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean b = find(a, 10);
        System.out.println(b);
    }
}

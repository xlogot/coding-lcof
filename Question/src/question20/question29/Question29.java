package question20.question29;

public class Question29 {
    public static void printMatrixClockWisely(int[][] numbers,int columns,int rows){
        if (numbers==null||columns<=0||rows<=0) return;
        int start=0;
        while (columns>start*2&&rows>start*2){
            printMatrixInCircle(numbers,columns,rows,start++);
        }
    }

    private static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        int endY=rows-1-start;
        int endX=columns-1-start;

        for (int i = start; i <=endX; i++) {
            System.out.printf("%d ,",numbers[start][i]);
        }

        if (
//                endY>start
                endY-start>=1
        ){
            for (int i=start+1;i<=endY;i++){
                System.out.printf("%d ,",numbers[i][endX]);
            }
        }
        if (
//                endX>start&&endY>start
                endX-start>=1&&endY-start>=1
        ){
            for (int i=endX-1;i >=start;i--){
                System.out.printf("%d ,",numbers[endY][i]);
            }
        }
        if (
//                endY>(start+1)&&endX>start
                endY-start>=2&&endX-start>=1
        ){
            for (int i=endY-1;i>start;i--){
                System.out.printf("%d ,",numbers[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] numbers={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrixClockWisely(numbers,4,4);
    }
}

package question3.question04;

public class Question {
    /*
二维数组中的查找。
每一行每一列都是按照从左到右从上到下递增的顺序排序的。输入一个整数判断，该数是否包含在数组中？
     */
    public static boolean find(int[][] matrix,int rows,int columns,int number){
        //输入条件判断
        if (matrix==null) return false;
        if (!(rows>0&&columns>0)) return false;

        int r=0,c=columns-1;
        while (c>=0&&r<columns){
            if (number>matrix[r][c]) r++;
            else if (number<matrix[r][c]) c--;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] a={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        var b =find(a,4,4,7);
//        System.out.println(b);
        String a="1";
        String b="1";
        if (a.equals(b)) System.out.println(true);
        else System.out.println(false);

    }
}

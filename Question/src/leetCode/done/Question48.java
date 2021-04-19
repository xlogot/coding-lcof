package leetCode;

public class Question48 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int j = 0; j < (matrix[0].length / 2); j++) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j];
                matrix[i][matrix.length - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Question48 t=new Question48();
        int[][] a={{1,2,3},{4,5,6},{7,8,9}};
        t.rotate(a);
    }
}

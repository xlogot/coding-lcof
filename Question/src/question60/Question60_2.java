package question60;

import javax.swing.*;
import java.nio.file.FileAlreadyExistsException;

public class Question60_2 {
    static final int maxVlue=6;
    static int[][] printProbability(int number){
        if (number<1) return null;
        int[][] probabilities=new int[2][maxVlue*number+1];
        int flag=0;

        for (int i = 0; i < maxVlue; i++) {
            probabilities[flag][i]=1;
        }

        for (int k=2;k<=number;++k){
            for (int i = 0; i < k; i++) {
                probabilities[1-flag][i]=0;
            }
            for (int i = k; i <= maxVlue * k; i++) {
                probabilities[1-flag][i]=0;
                for (int j = 1; j<=i &&j <= maxVlue; j++) {
                    probabilities[1-flag][i]+=probabilities[flag][i-j];
                }
            }
            flag=1-flag;
        }
        return probabilities;
    }

    public static void main(String[] args) {
        int[][] ints = printProbability(3);

    }
}

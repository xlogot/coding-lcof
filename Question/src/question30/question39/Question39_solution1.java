package question30.question39;

import com.sun.jdi.InvalidLineNumberException;

import java.util.Random;

public class Question39_solution1 {
    static int moreThanHalfNum(int[] numbers,int length){
        if (numbers==null||length<=0 )  return 0;
        Random random=new Random();
        int start=0;
        int end=length-1;
        int randomNumberIndex = partition(numbers, start,end);
        while (randomNumberIndex!=length/2){
            if (randomNumberIndex>length/2) {
                end=randomNumberIndex-1;
                randomNumberIndex=partition(numbers,start,end);
            }else{
                start=randomNumberIndex+1;
                randomNumberIndex=partition(numbers,start,end);
            }
        }
        return numbers[randomNumberIndex];
    }

    public static int partition(int[] numbers, int startIndex,int endIndex) {
        int offset=endIndex-startIndex;
        int i = new Random().nextInt(offset);
        exchange(numbers,endIndex,i+startIndex);
        int number = numbers[endIndex];
        int numbersSmallIndex=startIndex-1;
        for (int j = startIndex; j < endIndex ; j++) {
            if (numbers[j]< number){
                numbersSmallIndex++;
                exchange(numbers,j,numbersSmallIndex);
            }
        }
        exchange(numbers,numbersSmallIndex+1,endIndex);
        return numbersSmallIndex+1;
    }

    private static void exchange(int[] numbers,int index1 ,int index2) {
        int number = numbers[index1];
        numbers[index1]=numbers[index2];
        numbers[index2]=number;
    }

    public static void main(String[] args) {
        int[] arrays={1,2,3,2,2,2,5,4,2};
        int index = moreThanHalfNum(arrays, arrays.length);
        System.out.println(index);
    }
}

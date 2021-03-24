package question10.question11;

public class Question11_1 {
    static int getMinimumInRotatedArrays(int[] arrays){
        if (arrays==null) return -1;
        int index1=0;
        int index2=arrays.length-1;
        int min=-1;
        while (index1 < index2){
            if (index1+1==index2) {
                min=arrays[index2];
                break;
            }
            int midIndex=(index1+index2)/2;
            if (arrays[midIndex]==arrays[index1]&&arrays[index1]==arrays[index2]){
                return traversalArray(arrays);
            }
            if (arrays[midIndex]>=arrays[index1]){
                index1=midIndex;
            }else{
                index2=midIndex;
            }
        }
        return min;
    }

    private static int traversalArray(int[] arrays) {
        int  min=arrays[0];
        for (int i=0;i<arrays.length;i++){
            if (arrays[i]<min) min=arrays[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a={4,5,6,0,1,2,3};
        int min = getMinimumInRotatedArrays(a);
        System.out.println(min);
    }
}

package question30.question39;

public class Question39_02 {
    static int   findNumber(int[] arrays){
        int time=1;
        int number=arrays[0];
        for (int i=1;i<arrays.length;i++){
            if (number==arrays[i]){
                time++;
            }else {
                if (time>0){
                    time--;
                }else {
                    time=0;
                    number=arrays[i];
                }
            }
        }
        return  number;
    }

    public static void main(String[] args) {
//        int[] arrays={1,2,3,2,2,2,5,4,2};
        int[] arrays={1,1,1,1,3,4,5};
        int index = findNumber(arrays);
        System.out.println(index);
    }
}

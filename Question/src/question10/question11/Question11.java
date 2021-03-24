package question10.question11;

/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组{3,4,5, 1,2}为{1,2,3, 4, 5}的一个旋转，该数组的最小值为 1。
 */
public class Question11 {
    public static int min(int[] array,int length){
        if (array==null) return -1;
        int index1=0;
        int index2=length-1;
        int mid=index1;
        while (array[index1]>=array[index2]){
            if (index2-index1==1) {
                mid=index2;
                break;
            }
            mid=(index1+index2)/2;//最根本就是决定下一步时,哪个index将会被赋值为mid
            if (array[index1]==array[index2]&&array[mid]==array[index1]) {
                //在这种情况下, 这种类似二分查找的方法会失效, 因此, 只能遍历数组, 查找最小值
                return minInOrder(array,index1,index2);
            }
            if (array[mid]>=array[index2]) index1=mid;
            else if (array[mid]<=array[index2]) index2=mid;

        }
        return mid;
    }

    private static int minInOrder(int[] array, int index1, int index2) {
        //遍历数组
        int result=array[index1];
        int resIndex=index1;
        for (int i = index1+1; i <= index2; i++) {
            if (result>array[i]) {
                result=array[i];
                resIndex=i;
            }
        }
        return resIndex;
    }

    public static void main(String[] args) {
        int[] a={0,1};
        int m=min(a,a.length);
        System.out.println(m);
    }
}

/*
在数组中找出重复的数字。剑指offerP39
1、把输入的数字进行排序，然后从排序的数字中找出重复的数字。
2、使用一个简单的哈希表来解决问题，但是他需要O(n)的空间复杂度。
3、时间O(n)空间O(1)，但会修改数组
 */
package question3;

public class Question03 {
    class result{
        boolean a;
        int d;
    }

    public  boolean duplicate(int[] numbers,int length,result duplication){
        if (numbers==null||length <=0) return false;//判断数组为空

        for (int i = 0; i < length; i++) {
            if (numbers[i]<0||numbers[i]>length-1) return false;//判断数组是否超出最大值
        }

        int temp;
        for (int i = 0; i < length; i++) {
            while (numbers[i]!=i){
                if (numbers[i]==numbers[numbers[i]]) {
                    duplication.d=numbers[i];
                    return true;
                }
                else{
                    //交换数组中的元素。
                    temp= numbers[i];
                    numbers[i]=numbers[temp];
                    numbers[temp]=temp;
                }
            }
        }
        return  false;
    }

    //使用冒泡排序，查找重复数字。
    public boolean duplicate1(int[] numbers,int length,result dupliaction){
        if (numbers==null||length <=0) return false;//判断数组为空

        for (int i = 0; i < length; i++) {
            if (numbers[i]<0||numbers[i]>length-1) return false;//判断数组是否超出最大值或者是否有负数
        }

        int temp;
        for (int i = length-1; i > 0; i--) {
            boolean flag=false;
            for (int j = 0; j < i; j++) {
                if (numbers[j]>numbers[j+1]){
                    temp=numbers[j+1];
                    numbers[j+1]=numbers[j];
                    numbers[j]=temp;
                    flag=true;
                }
            }
            if (flag==false) break;
        }

        int j;
        for (j=0 ; j <= length - 1; j++) {
            if (j==length-1) return false;
            if (numbers[j]==numbers[j+1]) break;
        }
        dupliaction.d=j;
        return true;
    }



    public static void main(String[] args) {
        int[] nums={1,2};
//        Integer dup= -1;
        Question03 q1=new Question03();
        result d=q1.new result();
        q1.duplicate1(nums,nums.length,d);
        System.out.println(d.d);
    }
}

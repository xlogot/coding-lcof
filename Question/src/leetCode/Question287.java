package leetCode;

import leetCode.common.Input;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Question287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        int cur=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (cur==nums[i]){
                count++;
            }else {
                cur=nums[i];
                count=1;
            }
            if (count>=2) break;
        }
        return cur;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Question287 t=new Question287();
        while (true){
            int[] nums = Input.getNums();
            int duplicate = t.findDuplicate(nums);
            System.out.println(duplicate);
        }
    }
}

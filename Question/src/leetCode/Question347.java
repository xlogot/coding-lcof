package leetCode;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class Question347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Temp> max=new PriorityQueue<>((o1, o2) -> o2.count-o1.count);
        Arrays.sort(nums);
        int count=0;
        int pre=nums[0];
        for (int i=0;i<nums.length;i++){
            if (pre==nums[i]){
                count++;
            }else {
                max.offer(new Temp(pre,count));
                pre=nums[i];
                count=1;
            }
        }
        max.add(new Temp(pre,count));
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=max.poll().num;
            System.out.println(res[i]);
        }
        return res;
    }
    class Temp{
        int num;
        int count;

        public Temp() {
        }

        public Temp(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Question347 t=new Question347();
        while (true) {
            int k = sc.nextInt();
            String s = sc.next();
            String[] split = s.split(",");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                nums[i]=Integer.parseInt(split[i]);
            }
            t.topKFrequent(nums,k);
        }
    }
}

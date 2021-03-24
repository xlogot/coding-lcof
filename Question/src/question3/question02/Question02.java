package question3.question02;

import java.time.Instant;

public class Question02 {
     private enum  Holder {
         INSTANCE1;
        private Question02 instance;
        //构造函数
        Holder(){
            this.instance=new Question02();
        }
        private Question02 getInstance(){
            return instance;
        }
    }
    private Question02 getInstance(){
         //会使用构造函数.
         return Holder.INSTANCE1.getInstance();
    }
}

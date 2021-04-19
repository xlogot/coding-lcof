package leetCode.done;

import sun.applet.Main;
import sun.awt.SunHints;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question1115 {
    static class FooBar {
        private int n;
        Lock lock =new ReentrantLock();
        Condition condition=lock.newCondition();
        volatile int flag=0;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {
                    lock.lock();
                    while (flag!=0) condition.await();
                    printFoo.run();
                    flag=1;
                }finally {
                    condition.signalAll();
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {
                    lock.lock();
                    while (flag!=1) condition.await();
                    printBar.run();
                    flag=0;
                }finally {
                    condition.signalAll();
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        FooBar fb=new FooBar(2);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fb.foo(()-> System.out.println("foo"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fb.bar(()-> System.out.println("bar"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

package leetCode.done;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question1114 {
    static class Foo {

        private Lock lock=new ReentrantLock();
        Condition con1=lock.newCondition();
        volatile  int flag=0;
        public Foo() {}
        public void first(Runnable printFirst) throws InterruptedException {

            try {
                lock.lock();
                while (flag!=0) con1.wait();
                printFirst.run();
                flag=1;
            }finally {
                con1.signalAll();
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            try {
                lock.lock();
                while (flag!=1) con1.await();
                printSecond.run();
                flag=2;
            }finally {
                con1.signalAll();
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            try {
                lock.lock();
                while (flag!=2)con1.await();
                printThird.run();
            }finally {
                con1.signalAll();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Foo f=new Foo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f.first(() -> {
                        System.out.println("first");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f.second(() -> {
                        System.out.println("second");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f.third(() -> {
                        System.out.println("third");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

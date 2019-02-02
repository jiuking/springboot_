package com.hjc.demo.springboot.init;

import com.github.rholder.retry.Retryer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Administrator
 * @date : 2019/1/7 0007 10:31
 * @description :
 */
public class HelloThreadTest {
    public static void main(String[] args)
    {
        HelloThread r = new HelloThread();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }

}

class HelloThread implements Runnable
{
    int i = 0;
    // int i;
    // 若i是成员变量，则HelloThread的对象r只包含这一个i，两个Thread对象因为由r构造，所以共享了同一个i
    // 打印结果是0到49的数字
    @Override
    public void run()
    {
        // 每一个线程都会拥有自己的一份局部变量的拷贝
        // 线程之间互不影响
        // 所以会打印100个数字，0到49每个数字都是两遍
        while (true)
        {
            System.out.println(Thread.currentThread().getName()+" Hello number: " + i++);

            try
            {
                Thread.sleep((long) Math.random() * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (50 == i)
            {
                break;
            }
        }

    }
}

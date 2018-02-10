package com.wsd.eurekaserver.util;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by EdsionGeng on 2018/2/8.
 */
public class MapTest {

    private ScheduledExecutorService scheduleExec;
    public long start;

    MapTest() {
        this.scheduleExec = Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public void timerOne() {
        scheduleExec.schedule(new Runnable() {
            public void run() {
                System.out.println("timerOne,the time:" + (System.currentTimeMillis() - start));
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000, TimeUnit.MILLISECONDS);
    }

    public void timeTwo() {
        scheduleExec.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("TimeTwo,the time" + (System.currentTimeMillis() - start));
            }
        }, 2000, TimeUnit.MILLISECONDS);

    }

    public static void main(String[] args) {
//    MapTest mapTest=new MapTest();
//    mapTest.timerOne();
//    mapTest.timeTwo();
//

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int sum = 0;
//                for (int i = 0; i < 10000; i++) {
//
//                    sum += i;
//
//                }
//                System.out.println(sum);
//            }
//        });
//        thread.start();
        Stack stack = new Stack();

        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.search(5));
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        Iterator iterator=list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }

}

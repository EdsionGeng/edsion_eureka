package com.wsd.eurekaserver.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by EdsionGeng on 2018/2/9.
 */
public class FailFastTest {
    private static List<Integer> list = new ArrayList<>();
    private static List<Integer> list1 = new CopyOnWriteArrayList<>();

    private static class threadOne extends Thread {
        public void run() {
            Iterator<Integer> iterator = list1.iterator();
            while (iterator.hasNext()) {
                int i = iterator.next();
                System.out.println("Thread遍历" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class threadTwo extends Thread {
        public void run() {
            int i = 0;
            while (i < 6) {
                System.out.println("ThreadTwo run" + i);
                if (i == 3) {
                    list1.remove(i);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        new threadOne().start();
        new threadTwo().start();
    }
}

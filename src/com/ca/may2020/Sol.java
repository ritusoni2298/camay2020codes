package com.ca.may2020;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Sol
{
    public int RequestLimit = 100;
    public Long TimeLimit =1000l;

    public class HitCounter{
        public Queue<Long> queue;
        public HitCounter(){
            queue = new LinkedList<>();
        }
        public boolean hitvalue(long timestamp){
            while(!queue.isEmpty() && queue.peek() -timestamp >= TimeLimit)
            {
                queue.poll();
            }
            if(queue.size()<100){
                queue.add(timestamp);
                return true;
            }
            return false;
        }

    }

    public HashMap<String,HitCounter> map =new HashMap<>();
    public boolean isAllow(String id){
        long currentTime = System.currentTimeMillis();
        if(!map.containsKey(id)){
            HitCounter h = new HitCounter();
            h.hitvalue(currentTime);
            return true;
        }else{
            HitCounter h = map.get(id);
            return h.hitvalue(currentTime);
        }
    }

}

class CreditCounter extends Sol{
    private int credits;

    int maxRequests =500;
    public CreditCounter() {
        this.credits = maxRequests;
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateCredit(maxRequests);
            }
        }).start();
    }

    public boolean allow() {
        synchronized (this) {
            if (credits == 0) {
                return false;
            }
            credits--;
            return true;
        }
    }

    private void updateCredit(int cnt) {
        synchronized (this) {
            credits = Math.min(credits + cnt, maxRequests);
            notifyAll();
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spleefleague.core.queue;

import com.spleefleague.core.Core;

/**
 * @author NickM13
 */
public class QueueRunnable implements Runnable {

    private boolean stop = false;
    private long queueDelayMillis = 3000;
    
    public synchronized void close() {
        this.stop = true;
    }
    
    public synchronized boolean running() {
        return !this.stop;
    }
    
    @Override
    public void run() {
        for (PlayerQueue pq : Core.getInstance().getQueueManager().getQueues()) {
            pq.checkQueue();
        }
    }

}

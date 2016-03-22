package lab2.data_store;

import lab2.item.Process;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by User on 01.03.2016.
 */
public class CPUQueue {

    private Queue<Process> processQueue;

    public CPUQueue() {
        processQueue = new LinkedList<>();
    }


    public synchronized void add(Process process) {

        System.out.println(process + " was added to queue");

        processQueue.offer(process);

    }

    public synchronized Process get() {

        return processQueue.poll();
    }

    public synchronized int size() {

        return processQueue.size();

    }

    @Override
    public String toString() {
        return String.valueOf(processQueue);
    }

}

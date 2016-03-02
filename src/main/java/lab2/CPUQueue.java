package lab2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by User on 01.03.2016.
 */
public class CPUQueue {

    Queue<ProcessThread> processQueue;

    public CPUQueue() {
        processQueue = new LinkedList<>();
    }


    public synchronized void add(ProcessThread process) {

        processQueue.add(process);

    }

    public synchronized ProcessThread get() {

        return processQueue.poll();
    }

    public synchronized int size() {

        return processQueue.size();

    }


}

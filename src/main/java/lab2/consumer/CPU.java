package lab2.consumer;

import lab2.data_store.CPUQueue;
import lab2.item.Process;

/**
 * Created by User on 01.03.2016.
 */
public class CPU extends Thread {

    public static final long PROCESSOR_DELAY_COEF = 5000;


    private Process cpuProcess; // current process
    private boolean isBusy = false;
    private static int ID = 0;
    private int cpuID;

    private final CPUQueue queue;


    public CPU(CPUQueue queue) {

        cpuID = ++ID;

        this.queue = queue;

    }


    public boolean isBusy() {
        return isBusy;
    }


    // if CPU is working , we can not change new process

    /**
     * @param process -- current process
     * @throws RuntimeException
     */
    public void loadCpuProcess(Process process) {

        if (isBusy) {
            throw new RuntimeException(this + " is working");
        }
    
    
        // setup process
        cpuProcess = process;
        
        synchronized (this) {

            System.out.println(this + " notified");
            notify();
        

        }


    }


    @Override
    public void run() {

//        System.out.println("i'm here");
        while (!isInterrupted()) {


            if (cpuProcess != null) {

                executeProcess(cpuProcess);

                cpuProcess = null;


//                try {
//                    currentThread().sleep(PROCESSOR_DELAY_COEF);
//                } catch (InterruptedException e) {
//                    System.err.println(this + " interrupted");
//                    e.printStackTrace();
//                }


            } else if (queue.size() != 0) {

                executeProcess(queue.get());

            }

            synchronized (this) {

                try {

                    System.out.println(this + " is waiting for");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }


    }


    private void executeProcess(Process process) {


        isBusy = true;

        System.out.println(this + " has started " + process);

        process.executeProcess();

        System.out.println(this + " has finished " + process);

        isBusy = false;


    }


    @Override
    public String toString() {
        return "CPU-" + cpuID;
    }


    // testing unit
    public static void main(String... args) {


    }


}

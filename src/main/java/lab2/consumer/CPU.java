package lab2.consumer;

import lab2.CPUQueue;
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

    private CPUQueue queue;


    public CPU() {
        cpuID = ++ID;

    }


    public boolean isBusy() {
        return isBusy;
    }


    // if CPU is working , we can not change new process

    /**
     * @throws RuntimeException
     */
    public void loadCpuProcess(Process process) {

        if (isBusy == true) {
            throw new RuntimeException(this + " is working");
        }

        // setup process
        cpuProcess = process;


    }


    @Override
    public void run() {

//        System.out.println("i'm here");
        while (!isInterrupted()) {

            if (cpuProcess != null) {


                isBusy = true;

                System.out.println(this + " has started " + cpuProcess);

                cpuProcess.executeProcess();

                System.out.println(this + " has finished " + cpuProcess);

                isBusy = false;

                cpuProcess = null;


//                try {
//                    currentThread().sleep(PROCESSOR_DELAY_COEF);
//                } catch (InterruptedException e) {
//                    System.err.println(this + " interrupted");
//                    e.printStackTrace();
//                }


            }

        }


    }


    @Override
    public String toString() {
        return "CPU-" + cpuID;
    }


    // testing unit
    public static void main(String... args) {

        CPU cpu = new CPU();

        Process process = new Process(1000);

        cpu.start();

        cpu.loadCpuProcess(process);


    }


}

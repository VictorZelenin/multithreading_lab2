package lab2.producer;

import lab2.data_store.CPUQueue;
import lab2.consumer.CPU;
import lab2.item.Process;

/**
 * Created by User on 08.03.2016.
 */
public class CPUProcess extends Thread {

    private int numberOfThreads;
    private long maxProcessingTime, maxWaitingTime;

    private CPU CPU1, CPU2;

    private final CPUQueue queue;

//    private Process currentProcess;


    public CPUProcess(int numberOfThreads, long maxProcessingTime, long maxWaitingTime) throws InterruptedException {

        this.numberOfThreads = numberOfThreads;
        this.maxWaitingTime = maxWaitingTime;
        this.maxProcessingTime = maxProcessingTime;

        queue = new CPUQueue();

        CPU1 = new CPU(queue);
        CPU2 = new CPU(queue);

        CPU1.start();
        CPU2.start();


    }

    private void generateProcesses(int numbersOfThreads, long maxProcessingTime, long maxWaitingTime) throws InterruptedException {


        for (int i = 0; i < numbersOfThreads; i++) {


            Process process = new Process((long) (Math.random() * maxProcessingTime));

            System.out.println("Process-" + process.getId() + " has been generated");


            // work out generated process
            if (!CPU1.isBusy()) {
                CPU1.loadCpuProcess(process);
            } else if (!CPU2.isBusy()) {
                CPU2.loadCpuProcess(process);
            } else {
                queue.add(process);
            }

            System.out.println("Queue size: " + queue.size());
//            currentProcess = thread;


            sleep((long) (Math.random() * maxWaitingTime));


        }


    }

    @Override
    public void run() {

        try {
            generateProcesses(numberOfThreads, maxProcessingTime, maxWaitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public Process getProcess() {
//        return currentProcess;
//    }


    // testing unit
    public static void main(String[] args) throws InterruptedException {


        CPUProcess cpuProcess = new CPUProcess(10, 100, 1000);


        cpuProcess.start();


    }


}

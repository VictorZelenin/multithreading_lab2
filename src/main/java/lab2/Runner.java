package lab2;

import lab2.consumer.CPU;
import lab2.item.Process;
import lab2.producer.CPUProcess;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by User on 19.03.2016.
 */
public class Runner {

    private CPU cpu1;
    private CPU cpu2;


    private CPUProcess processes;

    private ArrayBlockingQueue<Process> queue;

    public Runner(int capacity) {

        cpu1 = new CPU();
        cpu2 = new CPU();

        queue = new ArrayBlockingQueue<>(capacity);

        try {
            processes = new CPUProcess(4, 1000, 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


//    private void workOutProcess(Process process) {
//
//        if (previousProcess != null && process.equals(previousProcess)) {
//            return;
//        }
//
//
//
////
////        if (process != null) {
////            System.out.println(process);
////            if (!cpu1.isBusy()) {
////                cpu1.setCpuProcess(process);
////            } else if (!cpu2.isBusy()) {
////
////                cpu2.setCpuProcess(process);
////            } else {
////
////                queue.add(process);
////            }
////            previousProcess = process;
////
////        }
//
//
//
//    }


    private void start() throws InterruptedException {
        cpu1.start();
        cpu2.start();

        processes.start();


        while (true) {


//            workOutProcess(processes.getProcess());


//            Process process = processes.getProcess();
//            System.out.println(process + " " + i);
//            if (process != null) {
//                System.out.println("IMPORTANT: " + process);
//            }
//            processes.deleteProcess();
//            System.out.println(process + " " + i);
//
//            Thread.currentThread().sleep(100);
//
//            i++;

        }

    }

    public static void main(String[] args) throws InterruptedException {

    }

}

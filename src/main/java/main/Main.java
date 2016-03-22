package main;


import lab2.consumer.CPU;
import lab2.item.Process;
import lab2.producer.CPUProcess;

/**
 * Created by User on 01.03.2016.
 */
public class Main {


    public static void main(String[] args) throws Exception {

        CPUProcess processes = new CPUProcess(4, 100, 1000);

        processes.start();

//        while (true) {
//            Process process = processes.getProcess();
//            processes.deleteProcess();
//            if (process != null){
//                System.out.println(process);
//            }
//
//        }

    }

}

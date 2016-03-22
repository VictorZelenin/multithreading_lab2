package main;


import lab2.consumer.CPU;
import lab2.item.Process;
import lab2.producer.CPUProcess;

/**
 * Created by User on 01.03.2016.
 */
public class Main {

    private static final int NUMBER_OF_PROCESSES = 10;
    private static final long MAX_PROCESSING_TIME = 1000;
    private static final int MAX_WAITING_TIME = 1000;


    public static void main(String[] args)  {

        CPUProcess processes = null;

        try {
            processes = new CPUProcess(NUMBER_OF_PROCESSES, MAX_PROCESSING_TIME, MAX_WAITING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert processes != null;
        processes.start();



    }

}

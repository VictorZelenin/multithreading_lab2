package lab2;

/**
 * Created by User on 02.03.2016.
 */
public class Runner {

    private CPUProcess threadOfProcesses;
    private CPUQueue processQueue;

    private static int NUMBER_OF_THREADS = 3;
    private static long MAX_TIME_OF_WAITING = 5000;
    private static long MAX_TIME_OF_EXECUTING = 5000;


    public Runner() throws InterruptedException {
        threadOfProcesses = new CPUProcess(NUMBER_OF_THREADS, MAX_TIME_OF_EXECUTING, MAX_TIME_OF_WAITING);

        CPU cpu1 = new CPU(threadOfProcesses);
        CPU cpu2 = new CPU(threadOfProcesses);
        threadOfProcesses.start();

        Thread.currentThread().sleep(100);
        cpu1.start();
        cpu2.start();

    }

}

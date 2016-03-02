package lab2;

/**
 * Created by User on 02.03.2016.
 */
public class CPUProcess extends Thread {

    private long maxWaitingTime;
    private long maxExecutingTime;
    private int numberOfThreads;
    private ProcessThread currentThread;


    public CPUProcess(int numberOfThreads, long maxExecutingTime, long maxWaitingTime) {
        this.numberOfThreads = numberOfThreads;
        this.maxExecutingTime = maxExecutingTime;
        this.maxWaitingTime = maxWaitingTime;
    }

    @Override
    public void run() {
        generateProcesses();
    }

    private void generateProcesses() {

        for (int i = 0; i < numberOfThreads; i++) {
            long executingTime = (long) (Math.random() * maxExecutingTime);
            long waitingTime = (long) (Math.random() * maxWaitingTime);

            synchronized (this) {
                ProcessThread thread = new ProcessThread(executingTime);
                currentThread = thread;

                try {
                    currentThread().sleep(waitingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public ProcessThread getCurrentThread() {
        return currentThread;
    }


}

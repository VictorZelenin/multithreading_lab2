package lab2;

/**
 * Created by User on 01.03.2016.
 */
public class CPU extends Thread {


    private CPUProcess cpuProcess;
    private boolean isBusy = false;
    private static int id = 0;

    public CPU(CPUProcess cpuProcess) {
        this.cpuProcess = cpuProcess;
    }

    public boolean isBusy() {
        return isBusy;
    }


    @Override
    public void run() {
        System.out.println(cpuProcess.getCurrentThread());
    }


}

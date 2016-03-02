package lab2;

/**
 * Created by User on 02.03.2016.
 */
public class ProcessThread {

    private static int id = 0;
    private long time; // time of executing process

    public ProcessThread(long time) {
        this.time = time;
        id++;
    }


    public void run() {

        try {
            Thread.currentThread().sleep(time); // executing current process
        } catch (InterruptedException e) {
            System.err.println("Log: " + Thread.currentThread().getName() + "is interrupt !");
            e.printStackTrace();
        }

    }




    public int getId() {
        return id;
    }

    @Override
    public String toString() {

        return "ProcessThread-" + id;

    }
}

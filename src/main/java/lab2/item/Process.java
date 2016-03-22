package lab2.item;

/**
 * Created by User on 02.03.2016.
 */
public class Process {

    private int id;
    private static int nextId = 0;
    private long time;

    public Process(long time) {

        id = ++nextId;
        this.time = time;

    }


    public int getId() {
        return id;
    }


    // simulate working
    public void executeProcess() {
        try {
//            System.out.println(this + " started");
            Thread.sleep(time);  // processing time
//            System.out.println(this + " finished");
        } catch (InterruptedException e) {
            System.err.println("Process-" + id + " was interrupted, check your's logs");
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {

        return "Process-" + id;

    }
}

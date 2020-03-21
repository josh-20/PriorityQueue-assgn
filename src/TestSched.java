import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestSched {
    public static void readTasks(String filename, ArrayList<Task> task1, ArrayList<Task> task2, ArrayList<Task> task3) throws FileNotFoundException {
        // Create lists where base type is different
        File file1 = new File(filename);
        Scanner file = new Scanner(file1);
        System.out.println(filename);
        int ID = 1;
        int start = 0;
        int deadline = 0;
        int duration= 0;
        while (file.hasNext()) {
            for (int i = 0; i < 3; ++i) {
                if (i == 0) {
                    start = Integer.parseInt(file.next());
                }
                if (i == 1) {
                    deadline = Integer.parseInt(file.next());
                }
                if (i == 2) duration = Integer.parseInt(file.next());

            }
            Task1 tk = new Task1(ID, start, deadline, duration);
            Task2 tk2 = new Task2(ID, start, deadline, duration);
            Task3 tk3 = new Task3(ID, start, deadline, duration);
            task1.add(tk);
            task2.add(tk2);
            task3.add(tk3);
            ID++;
        }
    }
    public static void main(String args[]) throws FileNotFoundException {
        Scheduler s = new Scheduler();
        String [] files = {"taskset1.txt","taskset2.txt","taskset3.txt","taskset4.txt","taskset5.txt" };
        for (String f : files) {
            ArrayList<Task> t1 = new ArrayList();    // elements are Task1
            ArrayList<Task> t2 = new ArrayList();    // elements are Task2
            ArrayList<Task> t3 = new ArrayList();    // elements are Task3
            readTasks(f, t1, t2, t3);
            s.makeSchedule("Deadline Priority " + f, t1);
            s.makeSchedule("StarTime Priority " + f, t2);
            s.makeSchedule("Wild and Crazy priority " + f, t3);
        }
    }
}


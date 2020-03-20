import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Scheduler {
    public void makeSchedule(String fileName, ArrayList<Task> list) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScan = new Scanner(file);
        while(fileScan.hasNextLine()){
            System.out.println(fileScan.nextLine());
        }
    }
}

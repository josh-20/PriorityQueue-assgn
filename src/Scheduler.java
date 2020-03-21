import java.util.*;
public class Scheduler {
    public void makeSchedule  (String Priority, ArrayList<Task> list) {
        Task temp;
        LeftistHeap<Task> lh = new LeftistHeap<>();
        System.out.println(Priority);
        for (int i = 0; i < list.size(); i++){
            lh.insert(list.get(i));
        }
        int time = 1;
        int timeLate = 0;
        int late = 0;
        while(!lh.isEmpty()){
            temp = lh.deleteMin();
            int diff;
            diff = time - temp.deadline;
            if(time < temp.start) {
                time++;
                lh.insert(temp);
                continue;
            }
            temp.duration = temp.duration - 1;
            if (temp.duration != 0) {
                System.out.println("Time: " + time + " " + temp);
               lh.insert(temp);
            }
            else if (temp.duration == 0 && time <= temp.deadline) {
                System.out.println("Time: " + time + " " + temp + " **");
            }else {
                System.out.println("Time: " + time + " " + temp + " " + "Late " + diff);
                timeLate += diff;
                late++;

            }
            time++;

        }
        System.out.println("Tasks Late " + late + " " + "Time Late " + timeLate);
        System.out.println("\n\n\n");
    }

}

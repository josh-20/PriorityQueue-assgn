public class Task2 extends Task {
    public Task2(int ID, int start, int deadline, int duration) {super(ID,start,deadline,duration);}

    @Override
    public int compareTo(Task t2) {
        //System.out.println("Using Task1 compareTo");
        return deadline-t2.deadline;
    }
}

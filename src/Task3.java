public class Task3 extends Task {
    public Task3(int ID, int start, int deadline, int duration) {super(ID,start,deadline,duration);}
// wild and crazy priority
    @Override
    public int compareTo(Task t3) {
        //System.out.println("Using Task1 compareTo");
        return duration-t3.duration;
    }
}

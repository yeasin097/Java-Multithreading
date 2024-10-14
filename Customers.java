import java.util.Random;
public class Customers {
    public int incoming_time;
    public int outgoing_time;
    public int service_time;
    public int max_waiting_time;
    public String customerID;
    public boolean service_taken = false;
    public int service_start_time;
    Random random = new Random();

    public Customers(int incoming_time) {
        this.incoming_time = incoming_time;
        this.service_time =  random.nextInt(5)+6;
        this.max_waiting_time = random.nextInt(10)+5;

    }
    
    public int get_waiting() {
        if(service_taken) {
            return (outgoing_time - incoming_time - service_time);
        }
        else {
            return  -1;
        }
    }

    public void get_times() {
        System.out.println(customerID + " deatils");
        if(service_taken) {
            System.out.println("Customer "+ customerID + "deatils");
            System.out.println("Came at "+ incoming_time);
            System.out.println("Max wait "+ max_waiting_time);
            System.out.println("Service started "+ service_start_time);
            System.out.println("Service finished "+ (service_start_time+service_time)+"\n");

        }
        else {
            System.out.println("Did not take service");
            System.out.println("Came at "+ incoming_time);
            System.out.println("Max wait "+ max_waiting_time);
            System.out.println("Leave at "+ (incoming_time+max_waiting_time)+"\n");
        }
    }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;
import java.util.Random;

public class QueueOfBank {
    private  Queue<Customers> cutomerQueue;
    private int customer_no;

    public QueueOfBank(int customer_no) {
        this.customer_no = customer_no;
        this.cutomerQueue = new ConcurrentLinkedQueue<>();
        initializeQueue(); 
    }

    private  void initializeQueue() {
        Customers[] customers = new Customers[customer_no];
        Random random = new Random();

        for(int i=0; i<customer_no; i++) {
            int random_int = random.nextInt(100)+1;
            customers[i] = new Customers(random_int);
        }

        Arrays.sort(customers, Comparator.comparingInt(c -> c.incoming_time));

        for(int i=0; i<customer_no; i++) {
            customers[i].customerID = "customer " + (i+1);
            cutomerQueue.offer(customers[i]);
        }
    }

    public Queue<Customers> getCustomerQueue() {
        return cutomerQueue;
    }
}

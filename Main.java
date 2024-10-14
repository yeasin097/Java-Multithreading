import java.util.List;
import java.util.Queue;


public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int customer_no = 50;
        int server_count = 5;

        QueueOfBank bankQueue = new QueueOfBank(customer_no);
        Queue<Customers> customerQueue = bankQueue.getCustomerQueue();

        Server[] servers = new Server[server_count];
        Thread[] threads = new Thread[server_count];



        for(int i=0; i<server_count; i++) {
            servers[i] = new Server(customerQueue, i+1);
            threads[i] = new Thread(servers[i]);
            threads[i].start();
        }

        for (int i = 0; i < server_count; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Server server : servers) {
            List<Customers> processedCustomers = server.getProcessedCustomers();
            for (Customers customer : processedCustomers) {
                customer.get_times(); 
            }
        }
        long endTime = System.nanoTime();

        System.out.println("This code is run by "+ (endTime - startTime)/1000000 + "ms");
    }
}

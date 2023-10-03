package queue;
import java.util.*;

public class PrintQueueSimulation {
    public static void main(String[] args) {
        Queue<PrintJob> highPriorityQueue = new LinkedList<>();
        Queue<PrintJob> mediumPriorityQueue = new LinkedList<>();
        Queue<PrintJob> lowPriorityQueue = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            int priority = new Random().nextInt(3);
            PrintJob printJob = new PrintJob("Document " + i, priority);
            switch (priority) {
                case 0:
                    highPriorityQueue.add(printJob);
                    break;
                case 1:
                    mediumPriorityQueue.add(printJob);
                    break;
                case 2:
                    lowPriorityQueue.add(printJob);
                    break;
            }
        }
        while (!highPriorityQueue.isEmpty() || !mediumPriorityQueue.isEmpty() || !lowPriorityQueue.isEmpty()) {
            if (!highPriorityQueue.isEmpty()) {
                PrintJob printJob = highPriorityQueue.poll();
                System.out.println("Printing high priority job: " + printJob.getName());
            } else if (!mediumPriorityQueue.isEmpty()) {
                PrintJob printJob = mediumPriorityQueue.poll();
                System.out.println("Printing medium priority job: " + printJob.getName());
            } else {
                PrintJob printJob = lowPriorityQueue.poll();
                System.out.println("Printing low priority job: " + printJob.getName());
            }
        }
    }
}



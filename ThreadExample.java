
public class ThreadExample {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Worker thread is running");
        });

        thread.start();

        System.out.println("Main thread is running");
    }
}

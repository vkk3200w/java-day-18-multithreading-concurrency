
public class RunnableExample {

    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println(
                "Task executed by: " +
                Thread.currentThread().getName()
            );
        };

        Thread thread = new Thread(task);

        thread.start();
    }
}


import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args)
            throws Exception {

        CompletableFuture<String> task1 =
                CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> task2 =
                CompletableFuture.supplyAsync(() -> "Java");

        CompletableFuture<String> result =
                task1.thenCombine(
                        task2,
                        (first, second) -> first + " " + second
                );

        System.out.println(result.get());
    }
}

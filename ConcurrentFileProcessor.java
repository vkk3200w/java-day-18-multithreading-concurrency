
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentFileProcessor {

    public static void main(String[] args) throws Exception {

        Path directory = Path.of("input");

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        ConcurrentHashMap<String, Integer> results =
                new ConcurrentHashMap<>();

        try {

            List<Callable<Void>> tasks = Files.list(directory)
                    .filter(path -> path.toString().endsWith(".txt"))
                    .map(path -> (Callable<Void>) () -> {

                        String content = Files.readString(path);

                        int wordCount = content.trim().isEmpty()
                                ? 0
                                : content.trim().split("\\s+").length;

                        results.put(
                                path.getFileName().toString(),
                                wordCount
                        );

                        System.out.println(
                                path.getFileName() +
                                " | Words: " + wordCount +
                                " | Thread: " +
                                Thread.currentThread().getName()
                        );

                        return null;
                    })
                    .toList();

            executor.invokeAll(tasks);

            int totalWords = results.values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            System.out.println("-----------------------");
            System.out.println("Files processed: " + results.size());
            System.out.println("Total words: " + totalWords);

        } finally {
            executor.shutdown();
        }
    }
}


import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionsExample {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> employees =
                new ConcurrentHashMap<>();

        employees.put(1, "Kishore");
        employees.put(2, "Arun");
        employees.put(3, "Rahul");

        employees.forEach((id, name) -> {
            System.out.println(id + " : " + name);
        });
    }
}

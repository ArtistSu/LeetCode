import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class test {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(ThreadLocalRandom.current().nextLong(1,7));
    }
}


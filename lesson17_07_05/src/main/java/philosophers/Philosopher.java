package philosophers;

import lombok.SneakyThrows;

@SuppressWarnings("WeakerAccess")
public class Philosopher {
    private static int counter = 1;
    private String name;
    private final Fork left;
    private final Fork right;

    public Philosopher(Fork left, Fork right) {
        this.name = String.format("Philosopher#%d", counter++);
        this.left = left;
        this.right = right;
    }

    @SneakyThrows
    public void eat() {
        while (true) {
            System.out.printf("%s: trying to take left fork - %s\n", name, left.getName());
            left.take();
            System.out.printf("%s: left fork taken\n", name);
            Thread.sleep(100);
            if (right.isTaken()) {
                System.out.printf("%s: release left fork\n", name);
                left.release();
                Thread.sleep(100);
                continue;
            }
            System.out.printf("%s: trying to take right fork - %s\n", name, right.getName());
            right.take();
            System.out.printf("%s: right fork taken\n", name);
            System.out.printf("%s: eating...\n", name);
            left.release();
            right.release();
            break;
        }
    }
}

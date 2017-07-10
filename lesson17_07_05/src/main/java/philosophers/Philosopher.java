package philosophers;

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

    public void eat() {
        System.out.printf("%s: trying to take left fork - %s\n", name, left.getName());
        synchronized (left) {
            System.out.printf("%s: left fork taken\n", name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: trying to take right fork - %s\n", name, right.getName());
            synchronized (right) {
                System.out.printf("%s: right fork taken\n", name);
                System.out.printf("%s: eating...\n", name);
            }
        }
    }
}

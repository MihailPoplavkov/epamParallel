package philosophers;

public class Main {
    public static void main(String[] args) {
        Fork[] forks = {
                new Fork(),
                new Fork(),
                new Fork(),
                new Fork(),
                new Fork()
        };
        Philosopher[] philosophers = {
                new Philosopher(forks[0], forks[1]),
                new Philosopher(forks[1], forks[2]),
                new Philosopher(forks[2], forks[3]),
                new Philosopher(forks[3], forks[4]),
                new Philosopher(forks[4], forks[0])
        };

        for (Philosopher ph : philosophers) {
            new Thread(ph::eat).start();
        }
    }
}

package philosophers;

import lombok.Getter;
import lombok.SneakyThrows;

@SuppressWarnings("WeakerAccess")
@Getter
public class Fork {
    private static int counter = 1;
    private String name;
    private boolean isTaken;

    public Fork() {
        name = String.format("Fork#%d", counter++);
    }

    @SneakyThrows
    synchronized void take() {
        while (isTaken) {
            wait();
        }
        isTaken = true;
    }

    synchronized void release() {
        isTaken = false;
        notifyAll();
    }
}

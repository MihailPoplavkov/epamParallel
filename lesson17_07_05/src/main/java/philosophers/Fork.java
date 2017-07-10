package philosophers;

import lombok.Getter;

@SuppressWarnings("WeakerAccess")
@Getter
public class Fork {
    private static int counter = 1;
    private String name;

    public Fork() {
        name = String.format("Fork#%d", counter++);
    }
}

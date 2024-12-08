package menu.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;
import menu.view.OutputViewer;

public class RecoveryUtils {

    private static final OutputViewer viewer = new OutputViewer();

    private RecoveryUtils() {
    }

    public static <T> void executeWithRetry(Supplier<T> inputSupplier, Consumer<T> processFunction) {
        while (true) {
            try {
                T input = inputSupplier.get();
                processFunction.accept(input);
                return;
            } catch (IllegalArgumentException e) {
                viewer.printError(e);
            }
        }
    }

}
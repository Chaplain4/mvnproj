package threads;

import static util.ThreadUtils.*;

public class ExtraTester {
    public static void main(String[] args) throws InterruptedException {
        logBegin();
        ExtraThread extraThread = new ExtraThread("Generator", 10);

//        sleep(5);
//        extraThread.disable();
        extraThread.join(2000);
        logFinish();
    }
}

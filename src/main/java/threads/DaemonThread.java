package threads;

import util.ThreadUtils;
import util.XMLCurrencyParser;

import static util.ThreadUtils.*;

//обычно это служба, сервис, служебный поток
public class DaemonThread extends Thread {

    public DaemonThread(String name) {
        this.setDaemon(true);
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        logBegin();
        for (; true;) {
            ThreadUtils.sleep(5);
            log(XMLCurrencyParser.getCurrency("840"));
        }
    }
}

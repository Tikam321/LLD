package structuralPattern;

import java.util.ArrayList;
import java.util.List;

interface Internet {
    void connectTo(String server);
}

class RealInternet implements Internet {

    @Override
    public void connectTo(String server) {
        System.out.println("Connecting to the " + server);
    }
}

class ProxyInternet implements Internet {
    private RealInternet realInternet;
    List<String> bannedSites = List.of("abc.com", "xyz.com");
    public ProxyInternet(RealInternet realInternet) {
        this.realInternet = realInternet;
    }
    @Override
    public void connectTo(String server) {
        if (bannedSites.contains(server)) {
            System.out.println("Access Denied for " + server);
        } else {
            realInternet.connectTo(server);
        }
    }
}

public class ProxyPatternDemo {
    public static void main(String[] args) {
        RealInternet realInternet = new RealInternet();
        ProxyInternet proxyInternet = new ProxyInternet(realInternet);

        // called the real object method
        proxyInternet.connectTo("udemy.com");

        // request is reverted from proxy object
        proxyInternet.connectTo("abc.com");
    }
}
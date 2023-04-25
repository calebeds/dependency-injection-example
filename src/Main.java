
interface Service {
    void write(String message);
}

class ServiceA implements Service {

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}

class Client {
    private Service myService;
    // injects via the constructor
    public Client(Service service) {
        this.myService = service;
    }

    public void doSomething() {
        this.myService.write("This is a message");
    }

    public void setService(Service service) {
        this.myService = service;
    }

    public static void main(String[] args) {
        Service service = new ServiceA(); //The injector
        Client client = new Client(service);//inject via the constructor
        client.doSomething();

        client.setService(service); // injects via the set method
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
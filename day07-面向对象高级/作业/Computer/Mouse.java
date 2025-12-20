package Computer;

public class Mouse implements USB {
    @Override
    public void connect() {
        System.out.println("Mouse connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Mouse disconnected");
    }

    public void click() {
        System.out.println("Mouse clicked");
    }
}

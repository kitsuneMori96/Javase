package Computer;

public class KeyBoard implements USB{
    @Override
    public void connect() {
        System.out.println("键盘连接成功");
    }

    @Override
    public void disconnect() {
        System.out.println("键盘断开连接");
    }

    public void input(){
        System.out.println("键盘输入了hello world");
    }

}

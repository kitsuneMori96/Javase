package Computer;

public class Computer {

    public void use(USB usb){
        if(usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }
        if(usb instanceof KeyBoard){
            KeyBoard keyboard = (KeyBoard) usb;
            keyboard.input();
        }
    }

    static void main(String[] args) {
        USB mouse = new Mouse();
        USB keyboard = new KeyBoard();
        Computer computer = new Computer();
        mouse.connect();
        computer.use(mouse);
        mouse.disconnect();
        System.out.println("---------------");
        keyboard.connect();
        computer.use(keyboard);
        keyboard.disconnect();

    }
}

package java.view;

public class ConsoleView implements ConsoleViewImpl {

    @Override
    public void write(String message){
        System.out.println(message);
    }
}

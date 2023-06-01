package src.java.view;

public class ConsoleView implements java.view.ConsoleViewImpl {

    @Override
    public void write(String message){
        System.out.println(message);
    }
}

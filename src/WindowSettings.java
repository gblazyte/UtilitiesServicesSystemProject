import javax.swing.*;

public class WindowSettings {
    private static WindowSettings instance;
    WindowSettings(){
    }
    public static WindowSettings getInstance(){
        if (instance == null){
            instance = new WindowSettings();
        }
        return instance;
    }
    public JFrame configureWindow(String title, int width, int height){
        JFrame window = new JFrame(title);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setLocation(200,50);
        return window;
    }
}

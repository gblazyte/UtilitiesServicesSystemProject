import javax.swing.*;

public class WindowCreator extends WindowSettings{
    WindowCreator(){
        super();
    }
    public JFrame createWindow(String title, int width, int height){
        return configureWindow(title,width,height);
    }
}

import javax.swing.*;
import java.awt.*;

public class MainUI {

    protected JFrame page;
    MainUI(String title, int width, int height){
        WindowCreator windowCreator = new WindowCreator();
        page = windowCreator.createWindow(title, width, height);

        WindowManager windowManager = new WindowManager();
        windowManager.showWindow(page);

        page.getContentPane().setBackground(Color.lightGray);
    }
}

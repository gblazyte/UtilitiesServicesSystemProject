import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateService implements ActionListener {

    private UpdateServiceUI updateServiceUI;

    UpdateService(String manager){
        this.updateServiceUI = new UpdateServiceUI(manager);
        updateServiceUI.getUpdateServiceBtn().addActionListener(this);
        updateServiceUI.getBackBtn().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton updateServiceBtn = updateServiceUI.getUpdateServiceBtn();

        if (e.getSource() == updateServiceBtn){
            updateServiceUI.updateServiceDetailsInDatabase();
        } else {
            updateServiceUI.page.dispose();
            ViewService viewService = new ViewService();
        }
    }
}

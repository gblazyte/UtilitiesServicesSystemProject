import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewService implements ActionListener {

    private final ViewServiceUI viewServiceUI;
    ViewService(){
        this.viewServiceUI = new ViewServiceUI();
        viewServiceUI.getUpdateBtn().addActionListener(this);
        viewServiceUI.getSearchBtn().addActionListener(this);
        viewServiceUI.getBackBtn().addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton searchBtn = viewServiceUI.getSearchBtn();
        JButton updateBtn = viewServiceUI.getUpdateBtn();
        JButton backBtn = viewServiceUI.getBackBtn();

        if (e.getSource() == searchBtn){
            viewServiceUI.loadServicesForSelectedManager();

        } else if(e.getSource()== updateBtn){
            viewServiceUI.page.dispose();
            viewServiceUI.updateService();

        } else if (e.getSource()== backBtn) {
            viewServiceUI.page.dispose();
            Login login = new Login();
        }
    }
}

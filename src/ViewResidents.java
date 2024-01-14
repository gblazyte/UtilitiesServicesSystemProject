import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

public class ViewResidents implements ActionListener{
    ViewResidentsUI viewResidentsUI = new ViewResidentsUI();
    ViewResidents(){
        viewResidentsUI.getSearchBtn().addActionListener(this);
        viewResidentsUI.getUpdateBtn().addActionListener(this);
        viewResidentsUI.getBackBtn().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton searchBtn = viewResidentsUI.getSearchBtn();
        JButton updateBtn = viewResidentsUI.getUpdateBtn();
        JButton backBtn = viewResidentsUI.getBackBtn();

        if (e.getSource() == searchBtn){
            viewResidentsUI.searchResidents();

        } else if (e.getSource()== updateBtn){
            viewResidentsUI.page.dispose();
            viewResidentsUI.updateResidents();

        } else if (e.getSource()== backBtn) {
            viewResidentsUI.page.dispose();
            HomePage homePage = new HomePage();
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage implements ActionListener {
    private final HomePageUI homePageUI;
    HomePage(){
        this.homePageUI = new HomePageUI();
        homePageUI.getAddManagerBtn().addActionListener(this);
        homePageUI.getAddServiceBtn().addActionListener(this);
        homePageUI.getRemoveResidentsBtn().addActionListener(this);
        homePageUI.getAddResidentBtn().addActionListener(this);
        homePageUI.getViewResidentsBtn().addActionListener(this);
        homePageUI.getUpdateResidentsBtn().addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton addManagerBtn = homePageUI.getAddManagerBtn();
        JButton addResidentBtn = homePageUI.getAddResidentBtn();
        JButton addServiceBtn = homePageUI.getAddServiceBtn();
        JButton viewResidentsBtn = homePageUI.getViewResidentsBtn();
        JButton updateResidentsBtn = homePageUI.getUpdateResidentsBtn();
        JButton removeResidentsBtn = homePageUI.getRemoveResidentsBtn();

        if (e.getSource() == addManagerBtn){
            homePageUI.handleAddManagerAction();
        } else if(e.getSource()==addResidentBtn){
            homePageUI.handleAddResidentAction();
        } else if (e.getSource()==addServiceBtn) {
            homePageUI.handleAddServiceAction();
        } else if (e.getSource() == viewResidentsBtn || e.getSource()==updateResidentsBtn) {
            homePageUI.handleViewResidentsAction();
        } else if (e.getSource()==removeResidentsBtn) {
            homePageUI.handleRemoveResidentsAction();
        }
    }
}

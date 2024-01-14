import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResidentService implements ActionListener {
    private final ResidentServiceUI residentServiceUI;

    ResidentService(String res){
        this.residentServiceUI = new ResidentServiceUI(res);
        residentServiceUI.getSearchBtn().addActionListener(this);
        residentServiceUI.getBackBtn().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton searchBtn = residentServiceUI.getSearchBtn();
        JButton backBtn = residentServiceUI.getBackBtn();

        if (e.getSource() == searchBtn){
            residentServiceUI.loadServicesByGroup();

        } else if (e.getSource()== backBtn) {
            residentServiceUI.page.dispose();
            Login login = new Login();
        }
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddResident implements ActionListener {
    AddResidentUI addResidentUI = new AddResidentUI();
    AddResidentDatabase addResidentDatabase = new AddResidentDatabase();

    AddResident(){

        addResidentUI.getAddResidentBtn().addActionListener(this);
        addResidentUI.getBackBtn().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton addResidentBtn = addResidentUI.getAddResidentBtn();

        if (e.getSource() == addResidentBtn){
            String name = addResidentUI.getName();
            String lastName = addResidentUI.getLastName();
            String resGroup = addResidentUI.getResGroup();

            addResidentDatabase.addResident(name,lastName,resGroup);

            addResidentUI.page.dispose();
            HomePage homePage = new HomePage();


        } else {
            addResidentUI.page.dispose();
            HomePage homePage = new HomePage();
        }

    }
}

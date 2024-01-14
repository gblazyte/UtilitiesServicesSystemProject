import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddService implements ActionListener {

    AddServiceUI addServiceUI = new AddServiceUI();
    AddServiceDatabase addServiceDatabase = new AddServiceDatabase();

    AddService(){
        addServiceUI.getAddServiceBtnBtn().addActionListener(this);
        addServiceUI.getBackBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton addServiceBtn = addServiceUI.getAddServiceBtnBtn();

        if(e.getSource() == addServiceBtn){
            String service = addServiceUI.getService();
            String price = addServiceUI.getPrice();
            String manager = addServiceUI.getManager();
            String resGroup = addServiceUI.getResGroup();

            addServiceDatabase.addService(service,price,manager,resGroup);

            addServiceUI.page.dispose();
            HomePage homePage = new HomePage();

        } else {
            addServiceUI.page.dispose();
            HomePage homePage = new HomePage();
        }

    }
}

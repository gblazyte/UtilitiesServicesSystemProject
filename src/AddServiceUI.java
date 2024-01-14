import javax.swing.*;
import java.awt.*;

public class AddServiceUI extends MainUI{
    JLabel headingSer = new JLabel("Add service details");
    JLabel servicesLabel = new JLabel("Services: ");
    private String services[] = {"Heat","Water","Gas", "Electricity", "Recycling"};
    JComboBox servicesBox = new JComboBox(services);

    JLabel priceLabel = new JLabel("Price: ");
    JTextField priceField = new JTextField();

    JLabel managerLabel = new JLabel("Manager: ");
    JTextField managerField = new JTextField();

    JLabel resGroupLabel = new JLabel("Resident Group: ");
    private String groups[] = {"860","200","440", "633"};
    JComboBox resGroupBox = new JComboBox(groups);

    JButton addServiceBtn = new JButton("Add Service");
    JButton backBtn = new JButton("Back");

    public JButton getBackBtn() {
        return backBtn;
    }

    public JButton getAddServiceBtnBtn() { return addServiceBtn; };

    public String getService() {
        return (String) servicesBox.getSelectedItem();
    }

    public String getPrice() {
        return priceField.getText();
    }

    public String getManager() {
        return managerField.getText();
    }

    public String getResGroup() {
        return (String) resGroupBox.getSelectedItem();
    }

    AddServiceUI() {
        super("Add a service", 1100,650);
        initializeUI();
    }

    private void initializeUI(){
        headingSer.setBounds(350,30,500,50);
        headingSer.setFont(new Font("Arial",Font.BOLD, 25));
        page.getContentPane().add(headingSer);

        servicesLabel.setBounds(40,100,100,30);
        page.getContentPane().add(servicesLabel);
        servicesBox.setBounds(150,100,150,30);
        page.getContentPane().add(servicesBox);

        priceLabel.setBounds(40,150,100,30);
        page.getContentPane().add(priceLabel);
        priceField.setBounds(150,150,150,30);
        page.getContentPane().add(priceField);

        managerLabel.setBounds(40,200,150,30);
        page.getContentPane().add(managerLabel);
        managerField.setBounds(150,200,150,30);
        page.getContentPane().add(managerField);

        resGroupLabel.setBounds(40,250,100,30);
        page.getContentPane().add(resGroupLabel);
        resGroupBox.setBounds(150,250,150,30);
        page.getContentPane().add(resGroupBox);

        addServiceBtn.setBounds(250,500,120,40);
        page.getContentPane().add(addServiceBtn);

        backBtn.setBounds(450,500,120,40);
        page.getContentPane().add(backBtn);
    }


}

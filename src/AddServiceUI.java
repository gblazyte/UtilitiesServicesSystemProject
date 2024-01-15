import javax.swing.*;
import java.awt.*;

public class AddServiceUI extends MainUI{
    private final JLabel headingSer = new JLabel("Add service details");
    private final JLabel servicesLabel = new JLabel("Services: ");
    private final String[] services = {"Heat","Water","Gas", "Electricity", "Recycling"};
    private final JComboBox servicesBox = new JComboBox(services);

    private final JLabel priceLabel = new JLabel("Price: ");
    private final JTextField priceField = new JTextField();

    private final JLabel managerLabel = new JLabel("Manager: ");
    private final JTextField managerField = new JTextField();

    private final JLabel resGroupLabel = new JLabel("Resident Group: ");
    private final String[] groups = {"860","200","440", "633"};
    private final JComboBox resGroupBox = new JComboBox(groups);

    private final JButton addServiceBtn = new JButton("Add Service");
    private final JButton backBtn = new JButton("Back");

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

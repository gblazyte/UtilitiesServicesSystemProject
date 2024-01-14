import javax.swing.*;
import java.awt.*;


public class AddResidentUI extends MainUI {

    private final JLabel headingRes = new JLabel("Add resident details");
    private final JLabel resNameLabel = new JLabel("Resident Name: ");
    private final JTextField nameTextField = new JTextField();

    private final JLabel lastNameLabel = new JLabel("Resident Last Name: ");
    private final JTextField lastNameTextField = new JTextField();

    private final JLabel resGroupLabel = new JLabel("Resident Group: ");
    private final String[] groups = {"860","200","440", "633"};
    private final JComboBox resGroupBox = new JComboBox(groups);

    private final JButton addResidentBtn = new JButton("Add Resident");

    public JButton getAddResidentBtn() {
        return addResidentBtn;
    }

    private final JButton backBtn = new JButton("Back");

    public JButton getBackBtn() {
        return backBtn;
    }

    public String getName() {
        return nameTextField.getText();
    }

    public String getLastName() {
        return lastNameTextField.getText();
    }

    public String getResGroup() {
        return (String) resGroupBox.getSelectedItem();
    }

    AddResidentUI() {
        super("Add a resident", 1100,650);
        initializeUI();

    }

    private void initializeUI(){
        headingRes.setBounds(350,30,500,50);
        headingRes.setFont(new Font("Arial",Font.BOLD, 25));
        page.getContentPane().add(headingRes);

        resNameLabel.setBounds(40,100,100,30);
        page.getContentPane().add(resNameLabel);
        nameTextField.setBounds(150,100,150,30);
        page.getContentPane().add(nameTextField);

        lastNameLabel.setBounds(40,150,150,30);
        page.getContentPane().add(lastNameLabel);
        lastNameTextField.setBounds(170,150,150,30);
        page.getContentPane().add(lastNameTextField);

        resGroupLabel.setBounds(40,200,100,30);
        page.getContentPane().add(resGroupLabel);
        resGroupBox.setBounds(150,200,150,30);
        page.getContentPane().add(resGroupBox);

        addResidentBtn.setBounds(250,500,120,40);
        page.getContentPane().add(addResidentBtn);

        backBtn.setBounds(450,500,120,40);
        page.getContentPane().add(backBtn);
    }


}

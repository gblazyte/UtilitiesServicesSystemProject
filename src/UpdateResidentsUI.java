import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class UpdateResidentsUI extends MainUI{
    private final JLabel headingRes = new JLabel("Update resident details");
    private final JLabel updateNameLabel = new JLabel("Update Resident Name: ");
    private final JTextField updateNameTextField = new JTextField();
    private final JLabel lastNameLabel = new JLabel("Resident Last Name: ");
    private final JLabel lastNameTextLabel = new JLabel();
    private final JLabel resGroupLabel = new JLabel("Resident Group: ");
    private final String[] groups = {"860","200","440", "633"};
    private final JComboBox resGroupBox = new JComboBox(groups);
    private final JButton updateResidentBtn = new JButton("Update Resident");
    private final JButton backBtn = new JButton("Back");
    public String lastName;
    public JButton getBackBtn() {
        return backBtn;
    }
    public JButton getUpdateResidentBtn() {
        return updateResidentBtn;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    UpdateResidentsUI(String lastName){
        super("Update residents", 1100,650);
        setLastName(lastName);
        initializeUI();
    }

    private void initializeUI(){
        headingRes.setBounds(350,30,500,50);
        headingRes.setFont(new Font("Arial",Font.BOLD, 25));
        page.getContentPane().add(headingRes);

        updateNameLabel.setBounds(40,100,150,30);
        page.getContentPane().add(updateNameLabel);
        updateNameTextField.setBounds(190,100,150,30);
        page.getContentPane().add(updateNameTextField);

        lastNameLabel.setBounds(40,150,150,30);
        page.getContentPane().add(lastNameLabel);
        lastNameTextLabel.setBounds(170,150,150,30);
        page.getContentPane().add(lastNameTextLabel);

        resGroupLabel.setBounds(40,200,100,30);
        page.getContentPane().add(resGroupLabel);
        resGroupBox.setBounds(150,200,150,30);
        page.getContentPane().add(resGroupBox);

        populateSelectedLastName();

        updateResidentBtn.setBounds(250,500,140,40);
        page.getContentPane().add(updateResidentBtn);

        backBtn.setBounds(450,500,120,40);
        page.getContentPane().add(backBtn);
    }

    private void populateSelectedLastName() {
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            String query = "select * from residents where lastName = '" + lastName + "'";
            ResultSet resultSet = statement.getStatement().executeQuery(query);
            while (resultSet.next()) {
                updateNameTextField.setText(resultSet.getString("name"));
                lastNameTextLabel.setText(resultSet.getString("lastName"));
                String resGroup = resultSet.getString("resGroup");
                resGroupBox.setSelectedItem(resGroup);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateResidents(){
        String name = updateNameTextField.getText();
        String resGroup = resGroupBox.getSelectedItem().toString();

        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            String query = "update residents set name = '"+name+"', resGroup = '"+resGroup+"' where lastName = '"+lastName+"'";
            statement.getStatement().executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details updated!");
            page.dispose();
            HomePage homePage = new HomePage();

        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

}

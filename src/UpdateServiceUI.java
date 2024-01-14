import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class UpdateServiceUI extends MainUI{

    JLabel headingSer = new JLabel("Update service price");
    JLabel serviceLabel = new JLabel("Service: ");
    JLabel serviceTextLabel = new JLabel();
    JLabel updatePriceLabel = new JLabel("Update service price: ");
    JTextField updatePriceTextField = new JTextField();
    JLabel managerLabel = new JLabel("Manager: ");
    JLabel managerTextLabel = new JLabel();
    JLabel resGroupLabel = new JLabel("Resident Group: ");
    JLabel groupTextField = new JLabel();
    JButton updateServiceBtn = new JButton("Update Service");
    JButton backBtn = new JButton("Back");
    private String manager;
    public void setManager(String managerName) {
        this.manager = managerName;
    }
    public JButton getBackBtn() {
        return backBtn;
    }
    public JButton getUpdateServiceBtn() {
        return updateServiceBtn;
    }

    UpdateServiceUI(String manager) {
        super("Update service", 1100,650);
        setManager(manager);
        initializeUI();
    }

    private void initializeUI(){
        headingSer.setBounds(350,30,500,50);
        headingSer.setFont(new Font("Arial",Font.BOLD, 25));
        page.getContentPane().add(headingSer);

        serviceLabel.setBounds(40,100,100,30);
        page.getContentPane().add(serviceLabel);
        serviceTextLabel.setBounds(150,100,150,30);
        page.getContentPane().add(serviceTextLabel);

        updatePriceLabel.setBounds(40,150,150,30);
        page.getContentPane().add(updatePriceLabel);
        updatePriceTextField.setBounds(170,150,150,30);
        page.getContentPane().add(updatePriceTextField);

        managerLabel.setBounds(40,200,100,30);
        page.getContentPane().add(managerLabel);
        managerTextLabel.setBounds(150,200,150,30);
        page.getContentPane().add(managerTextLabel);

        resGroupLabel.setBounds(40,250,100,30);
        page.getContentPane().add(resGroupLabel);
        groupTextField.setBounds(150,250,150,30);
        page.getContentPane().add(groupTextField);

        populateServiceDetailsByManager();

        updateServiceBtn.setBounds(250,500,140,40);
        page.getContentPane().add(updateServiceBtn);

        backBtn.setBounds(450,500,120,40);
        page.getContentPane().add(backBtn);
    }

    public void populateServiceDetailsByManager(){
        try{
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            String query = "select * from services where manager = '"+manager+"'";
            ResultSet resultSet = statement.getStatement().executeQuery(query);
            while (resultSet.next()){
                serviceTextLabel.setText(resultSet.getString("service"));
                updatePriceTextField.setText(resultSet.getString("price"));
                managerTextLabel.setText(resultSet.getString("manager"));
                groupTextField.setText(resultSet.getString("resGroup"));

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateServiceDetailsInDatabase(){
        String service = serviceTextLabel.getText();
        String price = updatePriceTextField.getText();
        String resGroup = groupTextField.getText();

        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            String query = "update services set service = '"+service+"', price = '"+price+"', resGroup = '"+resGroup+"' where manager = '"+manager+"'";
            statement.getStatement().executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details updated!");
            page.dispose();
            ViewService viewService = new ViewService();

        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

}

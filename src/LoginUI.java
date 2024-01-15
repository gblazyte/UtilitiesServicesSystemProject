import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class LoginUI extends MainUI{
    private final JLabel usernameLabel = new JLabel("Username");
    private final JTextField usernameTextField = new JTextField();
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField passwordTextField = new JTextField();
    private final JButton loginButton = new JButton("Login");
    public JButton getLoginBtn() {
        return loginButton;
    }

    LoginUI() {
        super("login",1100,650);
        initializeUI();
    }

    private void initializeUI(){
        usernameLabel.setBounds(40,20,100,30);
        page.getContentPane().add(usernameLabel);

        usernameTextField.setBounds(150,20,150,30);
        page.getContentPane().add(usernameTextField);

        passwordLabel.setBounds(40,60,100,30);
        page.getContentPane().add(passwordLabel);

        passwordTextField.setBounds(150,60,150,30);
        page.getContentPane().add(passwordTextField);

        loginButton.setBounds(150,100,150,30);
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.WHITE);
        page.getContentPane().add(loginButton);
    }

    public void performLoginAuthentication(){
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());

            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            ResultSet resultSet = statement.getStatement().executeQuery(query);
            if (resultSet.next()){
                String userType = resultSet.getString("username");
                page.dispose();
                if ("admin".equals(userType)){
                    HomePage homeWindow = new HomePage();
                } else if ("manager".equals(userType)) {
                    ViewService viewService = new ViewService();
                } else {
                    ResidentService residentService = new ResidentService(passwordTextField.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong username or password");
                page.dispose();
            }

        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
}

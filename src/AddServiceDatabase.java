import javax.swing.*;

public class AddServiceDatabase {

        public void addService(String service, String price, String manager, String resGroup){
            try {
                DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
                DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
                String query = "insert into services values('" + service +"','"+price+"','"+ manager +"','"+resGroup+"')";
                statement.getStatement().executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added!");
                HomePage homePage = new HomePage();

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }


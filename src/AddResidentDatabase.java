import javax.swing.*;

public class AddResidentDatabase {
    public void addResident(String name, String lastName, String resGroup){
        try {
            //A connection to the MySQL database is established
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            //A SQL INSERT query is constructed
            String queryRes = "insert into residents values('" + name+"','"+lastName+"','"+resGroup+"')";
            //The constructed query is executed using the statement object obtained from the database connection
            statement.getStatement().executeUpdate(queryRes);
            String queryLogin = "insert into login values('" + name+"','"+lastName+"')";
            statement.getStatement().executeUpdate(queryLogin);
            JOptionPane.showMessageDialog(null, "Details added!");
            conn.closeConnection();
            statement.closeStatement();


        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
}

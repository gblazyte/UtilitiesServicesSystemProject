import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveResidentsUI extends MainUI{

    JLabel lastNameLabel = new JLabel("Resident Last Name: ");
    JLabel nameLabel = new JLabel("Resident Name: ");
    JLabel groupLabel = new JLabel("Resident Group: ");
    JLabel resNameLabel = new JLabel();
    JLabel resGroupLabel = new JLabel();
    Choice lastNameChoice = new Choice();
    JButton removeResidentBtn = new JButton("Remove Resident");
    JButton backBtn = new JButton("Back");
    public JButton getRemoveResidentBtn() {
        return removeResidentBtn;
    }
    public JButton getBackBtn() {
        return backBtn;
    }


    RemoveResidentsUI() {
        super("Remove residents", 1100,650);
        initializeUI();
    }

    private void initializeUI(){
        lastNameLabel.setBounds(40,100,150,30);
        page.getContentPane().add(lastNameLabel);
        lastNameChoice.setBounds(220,100,150,30);
        page.getContentPane().add(lastNameChoice);

        nameLabel.setBounds(40,150,150,30);
        page.getContentPane().add(nameLabel);

        groupLabel.setBounds(40,200,150,30);
        page.getContentPane().add(groupLabel);

        selectResidents();

        resNameLabel.setBounds(220,150,150,30);
        page.getContentPane().add(resNameLabel);
        resGroupLabel.setBounds(220,200,150,30);
        page.getContentPane().add(resGroupLabel);

        retrieveResident();

        removeResidentBtn.setBounds(250,500,140,40);
        page.getContentPane().add(removeResidentBtn);

        backBtn.setBounds(450,500,120,40);
        page.getContentPane().add(backBtn);
    }


    private void selectResidents(){
        try{
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            String query = "select * from residents";
            ResultSet resultSet = statement.getStatement().executeQuery(query);
            while (resultSet.next()){
                lastNameChoice.add(resultSet.getString("lastName"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void retrieveResident(){
        try{
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            String query = "select * from residents where lastName ='"+lastNameChoice.getSelectedItem()+"'";
            ResultSet resultSet = statement.getStatement().executeQuery(query);
            while (resultSet.next()){
                resNameLabel.setText(resultSet.getString("name"));
                resGroupLabel.setText(resultSet.getString("resGroup"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        lastNameChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedLastName = lastNameChoice.getSelectedItem();
                try{
                    DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
                    DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
                    String query = "select * from residents where lastName ='"+selectedLastName+"'";
                    ResultSet resultSet = statement.getStatement().executeQuery(query);
                    while (resultSet.next()){
                        resNameLabel.setText(resultSet.getString("name"));
                        resGroupLabel.setText(resultSet.getString("resGroup"));
                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

    }

    public void removeResident(){
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            String query = "delete from residents where lastName ='"+lastNameChoice.getSelectedItem()+"'";
            statement.getStatement().executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Resident removed successfully!");
            page.dispose();
            HomePage homePage = new HomePage();
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

}

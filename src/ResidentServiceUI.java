import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ResidentServiceUI extends MainUI{

    JTable table = new JTable();
    JLabel searchLabel = new JLabel("Search a service by group: ");
    Choice groupName = new Choice();
    JButton searchBtn = new JButton("Search");
    JButton backBtn = new JButton("Back");
    private String resident;
    public void setResident(String resName) {
        this.resident = resName;
    }
    public JButton getSearchBtn() {
        return searchBtn;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    ResidentServiceUI(String res) {
        super("View services", 1100,650);
        setResident(res);
        initializeUI();
    }

    private void initializeUI(){
        searchLabel.setBounds(40,20,200,30);
        page.getContentPane().add(searchLabel);

        groupName.setBounds(250,20,150,30);
        page.getContentPane().add(groupName);

        populateGroupListForResident();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,1100,650);
        page.getContentPane().add(scrollPane);

        loadResidentDataByLastName();

        searchBtn.setBounds(450,20,100,30);
        page.getContentPane().add(searchBtn);

        backBtn.setBounds(600,20,100,30);
        page.getContentPane().add(backBtn);
    }

    private void populateGroupListForResident(){
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            //based on resident's last name populate drop down list
            ResultSet resultSet = statement.getStatement().executeQuery("select distinct resGroup from residents where lastName='"+resident+"'");
            while (resultSet.next()){
                groupName.add(resultSet.getString("resGroup"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void loadResidentDataByLastName(){
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            //based on resident's last name populate the table
            ResultSet resultSet = statement.getStatement().executeQuery("select resGroup from residents where lastName='"+resident+"'");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            while (resultSet.next()){
                groupName.add(resultSet.getString("resGroup"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadServicesByGroup(){
        String query = "select * from services where resGroup = '" + groupName.getSelectedItem() +"'";
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            ResultSet resultSet = statement.getStatement().executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

}

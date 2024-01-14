import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewResidentsUI extends MainUI{

    private JTable table = new JTable();
    private JLabel searchLabel = new JLabel("Search a resident by Last Name: ");

    private Choice resLastName = new Choice();


    private JButton searchBtn = new JButton("Search");


    private JButton updateBtn = new JButton("Update");


    private JButton backBtn = new JButton("Back");

    public JButton getSearchBtn() {
        return searchBtn;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public JTable getTable() {
        return table;
    }
    public Choice getLastName() {
        return resLastName;
    }


    ViewResidentsUI() {
        super("View residents", 1100,650);
        initializeUI();

    }

    private void initializeUI(){
        searchLabel.setBounds(40,20,200,30);
        page.getContentPane().add(searchLabel);

        resLastName.setBounds(250,20,150,30);
        page.getContentPane().add(resLastName);

        getLastNamesFromDatabase();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,1100,650);
        page.getContentPane().add(scrollPane);

        populateLastNamesTable();

        searchBtn.setBounds(450,20,100,30);
        page.getContentPane().add(searchBtn);

        updateBtn.setBounds(600,20,100,30);
        page.getContentPane().add(updateBtn);

        backBtn.setBounds(750,20,100,30);
        page.getContentPane().add(backBtn);
    }

    private void getLastNamesFromDatabase(){
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            ResultSet resultSet = statement.getStatement().executeQuery("select * from residents");
            while (resultSet.next()){
                resLastName.add(resultSet.getString("lastName"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void populateLastNamesTable(){
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            ResultSet resultSet = statement.getStatement().executeQuery("select * from residents");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            while (resultSet.next()){
                resLastName.add(resultSet.getString("lastName"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void searchResidents(){
        String query = "select * from residents where lastName = '" + resLastName.getSelectedItem() +"'";
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            ResultSet resultSet = statement.getStatement().executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public void updateResidents(){
        UpdateResidents updateResidents = new UpdateResidents(resLastName.getSelectedItem());
    }

}

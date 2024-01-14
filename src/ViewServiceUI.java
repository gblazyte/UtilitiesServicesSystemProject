import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewServiceUI extends MainUI{
    private final JTable table = new JTable();
    private final JLabel searchLabel = new JLabel("Search a service by Manager: ");
    private final Choice managerName = new Choice();
    private final JButton searchBtn = new JButton("Search");
    private final JButton updateBtn = new JButton("Update");
    private final JButton backBtn = new JButton("Back");
    public JButton getSearchBtn() {
        return searchBtn;
    }
    public JButton getUpdateBtn() {
        return updateBtn;
    }
    public JButton getBackBtn() {
        return backBtn;
    }

    ViewServiceUI() {
        super("View services", 1100,650);
        initializeUI();
    }

    private void initializeUI(){
        searchLabel.setBounds(40,20,200,30);
        page.getContentPane().add(searchLabel);

        managerName.setBounds(250,20,150,30);
        page.getContentPane().add(managerName);

        populateManagerListFromDatabase();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,1100,650);
        page.getContentPane().add(scrollPane);

        loadServicesDataAndManagers();

        searchBtn.setBounds(450,20,100,30);
        page.getContentPane().add(searchBtn);

        updateBtn.setBounds(600,20,100,30);
        page.getContentPane().add(updateBtn);

        backBtn.setBounds(750,20,100,30);
        page.getContentPane().add(backBtn);
    }


    public void populateManagerListFromDatabase(){
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            ResultSet resultSet = statement.getStatement().executeQuery("select * from services");
            while (resultSet.next()){
                managerName.add(resultSet.getString("manager"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadServicesDataAndManagers(){
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            ResultSet resultSet = statement.getStatement().executeQuery("select * from services");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            while (resultSet.next()){
                managerName.add(resultSet.getString("manager"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadServicesForSelectedManager(){
        String query = "select * from services where manager = '" + managerName.getSelectedItem() +"'";
        try {
            DatabaseConn conn = new DatabaseConn("jdbc:mysql://localhost:3306/utilitiesservicessystem", "root", "GE%KX7uv9WF");
            DatabaseStatement statement = new DatabaseStatement(conn.getConnection());
            ResultSet resultSet = statement.getStatement().executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public void updateService(){
        UpdateService updateService = new UpdateService(managerName.getSelectedItem());
    }


}

import javax.swing.*;
import java.awt.*;

public class HomePageUI extends MainUI{

    JLabel headingHome= new JLabel("Utility services system");
    JButton addManager = new JButton("Add Manager");
    public JButton getAddManagerBtn() {
        return addManager;
    }
    JButton addResident = new JButton("Add Resident");
    public JButton getAddResidentBtn() {
        return addResident;
    }
    JButton addService = new JButton("Add Service");
    public JButton getAddServiceBtn() {
        return addService;
    }

    JButton viewResidents = new JButton("View residents");
    public JButton getViewResidentsBtn() {
        return viewResidents;
    }
    JButton updateResidents = new JButton("Update resident");
    public JButton getUpdateResidentsBtn() {
        return updateResidents;
    }
    JButton removeResidents = new JButton("Remove resident");
    public JButton getRemoveResidentsBtn() {
        return removeResidents;
    }

    HomePageUI() {
        super("Home Page", 1100,650);
        initializeUI();
    }

    private void initializeUI(){
        headingHome.setFont(new Font("Arial",Font.BOLD, 25));
        headingHome.setBounds(380,100,1200,60);
        headingHome.setForeground(Color.darkGray);
        page.getContentPane().add(headingHome);


        addManager.setBounds(400,200,120,40);
        page.getContentPane().add(addManager);

        addService.setBounds(400,270,120,40);
        page.getContentPane().add(addService);

        removeResidents.setBounds(390,340,140,40);
        page.getContentPane().add(removeResidents);

        addResident.setBounds(550,200,120,40);
        page.getContentPane().add(addResident);

        viewResidents.setBounds(550,270,120,40);
        page.getContentPane().add(viewResidents);

        updateResidents.setBounds(550,340,140,40);
        page.getContentPane().add(updateResidents);
    }


    public void handleAddManagerAction() {
        page.dispose();
        AddService addService = new AddService();
    }

    public void handleAddResidentAction() {
        page.dispose();
        AddResident addResident = new AddResident();
    }

    public void handleAddServiceAction() {
        page.dispose();
        AddService addService = new AddService();
    }

    public void handleViewResidentsAction() {
        page.dispose();
        ViewResidents viewResidents = new ViewResidents();
    }

    public void handleRemoveResidentsAction() {
        page.dispose();
        RemoveResidents removeResidents = new RemoveResidents();
    }


}



import javax.swing.*;

public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int numberOfTries;
    SERVICES serviceType;
    STORAGE_OPTIONS storageOptionType;
    ITEMS itemType;
    int serviceHours, storageOptionDays, itemBoxes;

    public Login(){
        this.username = "admin";
        this.password = "123";
        this.numberOfTries = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    public SERVICES getServiceType() {
        return serviceType;
    }

    public void setServiceType(SERVICES serviceType) {
        this.serviceType = serviceType;
    }

    public STORAGE_OPTIONS getStorageOptionType() {
        return storageOptionType;
    }

    public void setStorageOptionType(STORAGE_OPTIONS storageOptionType) {
        this.storageOptionType = storageOptionType;
    }

    public ITEMS getItemType() {
        return itemType;
    }

    public void setItemType(ITEMS itemType) {
        this.itemType = itemType;
    }

    public int getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(int serviceHours) {
        this.serviceHours = serviceHours;
    }

    public int getStorageOptionDays() {
        return storageOptionDays;
    }

    public void setStorageOptionDays(int storageOptionDays) {
        this.storageOptionDays = storageOptionDays;
    }

    public int getItemBoxes() {
        return itemBoxes;
    }

    public void setItemBoxes(int itemBoxes) {
        this.itemBoxes = itemBoxes;
    }

    public boolean login(){
        String username="",password="";
        this.numberOfTries = 0;
        boolean isAuthenticated;
        do{
            if(numberOfTries>=3) return false;
            username = JOptionPane.showInputDialog("Enter username: ");
            password = JOptionPane.showInputDialog("Enter password: ");
            numberOfTries++;
        }while(username == null || password==null || !username.equals(this.username) || !password.equals(this.password));
        if(username.equals(this.username) && password.equals(this.password)){
            isAuthenticated = true;
        }
        else{
            isAuthenticated = false;
        }
        return isAuthenticated;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFirstName() {
        while(this.firstName==null || this.firstName.isEmpty() || !this.firstName.matches("[a-zA-Z\\s]+"))
        {
            this.firstName = JOptionPane.showInputDialog("Enter first name: ");
        }
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setLastName() {
        while(this.lastName==null || this.lastName.isEmpty() || !this.lastName.matches("[a-zA-Z\\s]+"))
        {
            this.lastName = JOptionPane.showInputDialog("Enter last name: ");
        }
    }

    public static String checkValidInput(String option, String value){
        try{
            switch (option){
                case "ServiceType":
                    SERVICES.valueOf(value.toLowerCase());
                    break;
                case "OptionType":
                    STORAGE_OPTIONS.valueOf(value.toLowerCase());
                    break;
                case "ItemType":
                    ITEMS.valueOf(value.toLowerCase());
                    break;
                case "qty":
                    Integer.parseInt(value);
                    break;
            }
            return value;
        }
        catch (Exception e){
            return null;
        }
    }

    public void setChoices(){
        String valueCheck, inputValue;
        do {
            inputValue = JOptionPane.showInputDialog("Enter service type. Package_A | Package_B: ");
            valueCheck = checkValidInput("ServiceType",inputValue);
            if(valueCheck!=null) serviceType = SERVICES.valueOf(valueCheck.toLowerCase());
        }while(valueCheck == null);
        do {
            inputValue = JOptionPane.showInputDialog("Enter total service hours: ");
            valueCheck = checkValidInput("qty",inputValue);
            if(valueCheck!=null) serviceHours = Integer.parseInt(valueCheck);
        }while(valueCheck==null);
        do {
            inputValue = JOptionPane.showInputDialog("Enter storage option type. Small | Large: ");
            valueCheck = checkValidInput("OptionType",inputValue);
            if(valueCheck!=null) storageOptionType = STORAGE_OPTIONS.valueOf(valueCheck.toLowerCase());
        }while(valueCheck==null);
        do {
            inputValue = JOptionPane.showInputDialog("Enter total storage option days: ");
            valueCheck = checkValidInput("qty",inputValue);
            if(valueCheck!=null) storageOptionDays = Integer.parseInt(valueCheck);
        }while(valueCheck==null);
        do {
            inputValue = JOptionPane.showInputDialog("Enter item type. Small | Large: ");
            valueCheck = checkValidInput("ItemType",inputValue);
            if(valueCheck!=null) itemType = ITEMS.valueOf(valueCheck.toLowerCase());
        }while(valueCheck==null);
        do {
            inputValue = JOptionPane.showInputDialog("Enter total item boxes: ");
            valueCheck = checkValidInput("qty",inputValue);
            if(valueCheck!=null) itemBoxes = Integer.parseInt(valueCheck);
        }while(valueCheck==null);

    }

    public static void main(String[] args){
        Login loginUser = new Login();
        if(loginUser.login()){
            loginUser.setFirstName();
            loginUser.setLastName();
            loginUser.setChoices();
            SERVICES serviceType = loginUser.getServiceType();
            STORAGE_OPTIONS storageOptionType = loginUser.getStorageOptionType();
            ITEMS itemType = loginUser.getItemType();
            int serviceHours = loginUser.getServiceHours();
            int storageOptionDays = loginUser.getStorageOptionDays();
            int itemBoxes = loginUser.getItemBoxes();
            BusinessServices businessServices = new BusinessServices(serviceType.name(), storageOptionType.name(), itemType.name(), serviceHours, storageOptionDays, itemBoxes);
            businessServices.calculateTotalCost();
            JOptionPane.showMessageDialog(null, "Welcome, " + loginUser.getFirstName() + " " +
                            loginUser.getLastName() +"!");
            JOptionPane.showMessageDialog(null,
                    "Total cost of package type " + businessServices.getService() + ": $" + businessServices.getServiceCost() +
                            "\nTotal cost of storage type " + businessServices.getStorageOption() + ": $" + businessServices.getStorageCost() +
                            "\nTotal cost of box item type " + businessServices.getItem() + ": $" + businessServices.getItemCost() +
                            "\nGross total: $" + businessServices.getTotalCost()

            );
        }
        else{
            JOptionPane.showMessageDialog(null, "You have exceeded your try’s, goodbye.");
        }


    }

}

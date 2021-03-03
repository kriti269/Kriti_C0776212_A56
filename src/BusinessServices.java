enum SERVICES{
    package_a(100), package_b(150);
    private int rate;
    SERVICES(int rate){
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}

enum STORAGE_OPTIONS{
    small(8), large(20.11f);
    private float rate;
    STORAGE_OPTIONS(float rate){
        this.rate = rate;
    }

    public float getRate() {
        return rate;
    }
}

enum ITEMS{
    small(2.5f), large(4.5f);
    private float rate;
    ITEMS(float rate){
        this.rate = rate;
    }

    public float getRate() {
        return rate;
    }
}

public class BusinessServices {
    private String service, storageOption, item;
    private float serviceCost, storageCost, itemCost, totalCost;
    private int serviceHours, storageDays, itemBoxes;

    public BusinessServices(){
        this.service = "";
        this.storageOption = "";
        this.item = "";
        this.serviceHours = 0;
        this.storageDays = 0;
        this.itemBoxes = 0;
    }

    public BusinessServices(String service, String storageOption, String item, int serviceHours, int storageDays, int itemBoxes){
        this.service = service;
        this.storageOption = storageOption;
        this.item = item;
        this.serviceHours = serviceHours;
        this.storageDays = storageDays;
        this.itemBoxes = itemBoxes;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStorageOption() {
        return storageOption;
    }

    public void setStorageOption(String storageOption) {
        this.storageOption = storageOption;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public float getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(float storageCost) {
        this.storageCost = storageCost;
    }

    public float getItemCost() {
        return itemCost;
    }

    public void setItemCost(float itemCost) {
        this.itemCost = itemCost;
    }

    public int getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(int serviceHours) {
        this.serviceHours = serviceHours;
    }

    public int getStorageDays() {
        return storageDays;
    }

    public void setStorageDays(int storageDays) {
        this.storageDays = storageDays;
    }

    public int getItemBoxes() {
        return itemBoxes;
    }

    public void setItemBoxes(int itemBoxes) {
        this.itemBoxes = itemBoxes;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public void calculateServicesCost(){
        setServiceCost(getServiceHours() * SERVICES.valueOf(getService()).getRate());
    }

    public void calculateStorageOptionsCost(){
        setStorageCost(getStorageDays() * STORAGE_OPTIONS.valueOf(getStorageOption()).getRate());
    }

    public void calculateItemsCost(){
        setItemCost(getItemBoxes() * ITEMS.valueOf(getItem()).getRate());
    }

    public void calculateTotalCost(){
        calculateItemsCost();
        calculateServicesCost();
        calculateStorageOptionsCost();
        setTotalCost(getItemCost() + getServiceCost() + getStorageCost());
    }


}

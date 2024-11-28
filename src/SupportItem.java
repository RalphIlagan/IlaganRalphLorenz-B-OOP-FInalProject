public abstract class SupportItem {
    private String name;
    private String supportType;
    private String description;
    private String contactNumber;
    private String status;

    public SupportItem(String name, String supportType, String description, String contactNumber, String status) {
        this.name = name;
        this.supportType = supportType;
        this.description = description;
        this.contactNumber = contactNumber;
        this.status = status;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSupportType() {
        return supportType;
    }

    public String getDescription() {
        return description;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    protected void setStatus(String status) {
        this.status = status;
    }

    // Abstract method for fulfilling requests or offers
    public abstract void fulfill(String name, String contactNumber);

    @Override
    public String toString() {
        return name + " (" + supportType + ") - " + status;
    }
}

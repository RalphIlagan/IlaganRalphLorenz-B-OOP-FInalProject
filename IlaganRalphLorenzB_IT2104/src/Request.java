public class Request extends SupportItem {
    private String fulfilledBy;
    private String fulfillerContact;

    public Request(String name, String supportType, String description, String contactNumber) {
        super(name, supportType, description, contactNumber, "Pending");
        this.fulfilledBy = "";  // Initially, no one fulfills the request
        this.fulfillerContact = "";  // Initially, no contact number is set
    }

    @Override
    public void fulfill(String name, String contactNumber) {
        setStatus("Supplied");
        this.fulfilledBy = name;
        this.fulfillerContact = contactNumber;
    }

    // Getters for fulfilledBy and fulfillerContact
    public String getFulfilledBy() {
        return fulfilledBy;
    }

    public String getFulfillerContact() {
        return fulfillerContact;
    }
}

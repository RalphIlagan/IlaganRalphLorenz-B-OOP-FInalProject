import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CommunitySupportSystem {
    private List<Request> requests;
    private List<Offer> offers;
    private String requestFile = "requests.txt";
    private String offerFile = "offers.txt";

    public CommunitySupportSystem() {
        this.requests = new ArrayList<>();
        this.offers = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        loadRequests();
        loadOffers();
    }

    private void loadRequests() {
        try (BufferedReader reader = new BufferedReader(new FileReader(requestFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    requests.add(new Request(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading requests: " + e.getMessage());
        }
    }

    private void loadOffers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(offerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    offers.add(new Offer(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading offers: " + e.getMessage());
        }
    }

    private void saveRequests() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(requestFile))) {
            for (Request req : requests) {
                writer.write(req.getName() + "," + req.getSupportType() + "," + req.getDescription() + "," + req.getContactNumber() + "," + req.getStatus() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving requests: " + e.getMessage());
        }
    }

    private void saveOffers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(offerFile))) {
            for (Offer off : offers) {
                writer.write(off.getName() + "," + off.getSupportType() + "," + off.getDescription() + "," + off.getContactNumber() + "," + off.getStatus() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving offers: " + e.getMessage());
        }
    }

    public DefaultTableModel getRequestsTableModel() {
        String[] columns = { "Name", "Support Type", "Description", "Contact Number", "Status", "Fulfilled By", "Fulfiller Contact" };
        String[][] data = new String[requests.size()][7];
    
        for (int i = 0; i < requests.size(); i++) {
            Request req = requests.get(i);
            data[i] = new String[] { 
                req.getName(), 
                req.getSupportType(), 
                req.getDescription(), 
                req.getContactNumber(), 
                req.getStatus(), 
                req.getFulfilledBy(), 
                req.getFulfillerContact() 
            };
        }
    
        return new DefaultTableModel(data, columns);
    }
    

    public DefaultTableModel getOffersTableModel() {
        String[] columns = { "Name", "Support Type", "Description", "Contact Number", "Status", "Claimed By", "Contact Number" };
        String[][] data = new String[offers.size()][7];
    
        for (int i = 0; i < offers.size(); i++) {
            Offer offer = offers.get(i);
            data[i] = new String[] { 
                offer.getName(), 
                offer.getSupportType(), 
                offer.getDescription(), 
                offer.getContactNumber(), 
                offer.getStatus(), 
                offer.getFulfilledBy(), 
                offer.getFulfillerContact() 
            };
        }
    
        return new DefaultTableModel(data, columns);
    }
    

    public void addRequest(String name, String supportType, String description, String contactNumber) {
        requests.add(new Request(name, supportType, description, contactNumber));
        saveRequests();
    }

    public void addOffer(String name, String supportType, String description, String contactNumber) {
        offers.add(new Offer(name, supportType, description, contactNumber));
        saveOffers();
    }

    public void fulfillRequest(int rowIndex, String name, String contactNumber) {
        if (rowIndex >= 0 && rowIndex < requests.size()) {
            Request req = requests.get(rowIndex);
            if (req.getStatus().equals("Pending")) {
                req.fulfill(name, contactNumber);
                saveRequests();  // Save the updated request
            }
        }
    }
    
    public void fulfillOffer(int rowIndex, String name, String contactNumber) {
        if (rowIndex >= 0 && rowIndex < offers.size()) {
            Offer offer = offers.get(rowIndex);
            if (offer.getStatus().equals("Available")) {
                offer.fulfill(name, contactNumber);
                saveOffers();  // Save the updated offer
            }
        }
    }
    
    
    public void resetAll() {
        requests.clear();
        offers.clear();
        saveRequests();
        saveOffers();
    }
}

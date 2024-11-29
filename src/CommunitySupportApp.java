import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CommunitySupportApp {
    private CommunitySupportSystem system;
    private JTable table;
    private JScrollPane scrollPane;

    private JTextField nameField, supportTypeField, descriptionField, contactNumberField;
    private JButton addRequestButton, addOfferButton, viewRequestsButton, viewOffersButton, fulfillRequestButton,
            fulfillOfferButton, resetButton, exitButton;

    public CommunitySupportApp() {
        system = new CommunitySupportSystem();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("CommUnity");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("CommUnity", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        addRequestButton = new JButton("Add Request");
        addOfferButton = new JButton("Add Offer");
        viewRequestsButton = new JButton("View Requests");
        viewOffersButton = new JButton("View Offers");
        fulfillRequestButton = new JButton("Fulfill Request");
        fulfillOfferButton = new JButton("Fulfill Offer");
        resetButton = new JButton("Reset All Data");
        exitButton = new JButton("Exit");

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Dimension buttonSize = new Dimension(200, 40);

        addRequestButton.setFont(buttonFont);
        addOfferButton.setFont(buttonFont);
        viewRequestsButton.setFont(buttonFont);
        viewOffersButton.setFont(buttonFont);
        fulfillRequestButton.setFont(buttonFont);
        fulfillOfferButton.setFont(buttonFont);
        resetButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        addRequestButton.setPreferredSize(buttonSize);
        addOfferButton.setPreferredSize(buttonSize);
        viewRequestsButton.setPreferredSize(buttonSize);
        viewOffersButton.setPreferredSize(buttonSize);
        fulfillRequestButton.setPreferredSize(buttonSize);
        fulfillOfferButton.setPreferredSize(buttonSize);
        resetButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);

        panel.add(addRequestButton);
        panel.add(addOfferButton);
        panel.add(viewRequestsButton);
        panel.add(viewOffersButton);
        panel.add(fulfillRequestButton);
        panel.add(fulfillOfferButton);
        panel.add(resetButton);
        panel.add(exitButton);

        frame.add(panel, BorderLayout.SOUTH);

        addRequestButton.addActionListener(e -> addRequest());
        addOfferButton.addActionListener(e -> addOffer());
        viewRequestsButton.addActionListener(e -> viewRequests());
        viewOffersButton.addActionListener(e -> viewOffers());
        fulfillRequestButton.addActionListener(e -> fulfillRequest());
        fulfillOfferButton.addActionListener(e -> fulfillOffer());
        resetButton.addActionListener(e -> resetData());
        exitButton.addActionListener(e -> exitApplication());

        frame.setVisible(true);
    }

    private void addRequest() {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Request addition canceled or incomplete. All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // If user clicked cancel or left it empty, return
        }
    
        String supportType = JOptionPane.showInputDialog("Enter Support Type:");
        if (supportType == null || supportType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Request addition canceled or incomplete. All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // If user clicked cancel or left it empty, return
        }
    
        String description = JOptionPane.showInputDialog("Enter Description:");
        if (description == null || description.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Request addition canceled or incomplete. All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // If user clicked cancel or left it empty, return
        }
    
        String contactNumber = JOptionPane.showInputDialog("Enter your Contact Number:");
        if (contactNumber == null || contactNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Request addition canceled or incomplete. All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // If user clicked cancel or left it empty, return
        }
    
        // If all fields are filled, add the request
        system.addRequest(name, supportType, description, contactNumber);
    }
    
    
    
    private void addOffer() {
        String name = JOptionPane.showInputDialog("Enter your Name:");
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Offer addition canceled or incomplete. All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // If user clicked cancel or left it empty, return
        }
    
        String supportType = JOptionPane.showInputDialog("Enter Support Type:");
        if (supportType == null || supportType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Offer addition canceled or incomplete. All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // If user clicked cancel or left it empty, return
        }
    
        String description = JOptionPane.showInputDialog("Enter Description:");
        if (description == null || description.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Offer addition canceled or incomplete. All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // If user clicked cancel or left it empty, return
        }
    
        String contactNumber = JOptionPane.showInputDialog("Enter Contact Number:");
        if (contactNumber == null || contactNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Offer addition canceled or incomplete. All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // If user clicked cancel or left it empty, return
        }
    
        // If all fields are filled, add the offer
        system.addOffer(name, supportType, description, contactNumber);
    }
    
    
    

    private void viewRequests() {
        DefaultTableModel model = system.getRequestsTableModel();
        table.setModel(model);
    }

    private void viewOffers() {
        DefaultTableModel model = system.getOffersTableModel();
        table.setModel(model);
    }

    private void fulfillRequest() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String name = JOptionPane.showInputDialog("Enter your name:");
            String contactNumber = JOptionPane.showInputDialog("Enter your Contact Number:");
    
            // Check if name or contactNumber is null or empty
            if (name == null || name.isEmpty() || contactNumber == null || contactNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name and Contact Number are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                system.fulfillRequest(selectedRow, name, contactNumber);
                viewRequests();  // Refresh the table view to reflect the fulfilled request
            }
        }
    }
    
    
    private void fulfillOffer() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String name = JOptionPane.showInputDialog("Enter your name:");
            String contactNumber = JOptionPane.showInputDialog("Enter your Contact Number:");
    
            // Check if name or contactNumber is null or empty
            if (name == null || name.isEmpty() || contactNumber == null || contactNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name and Contact Number are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                system.fulfillOffer(selectedRow, name, contactNumber);
                viewOffers();  // Refresh the table view to reflect the fulfilled offer
            }
        }
    }
    
    private void resetData() {
        system.resetAll();
        viewRequests();
        viewOffers();
    }

    private void exitApplication() {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CommunitySupportApp());
    }
}

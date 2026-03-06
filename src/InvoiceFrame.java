import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InvoiceFrame extends JFrame
{
    private Address address = new Address("name", "street", "city", "state", "zip");
    private Product product = new Product("name", 0);
    private LineItem lineItem = new LineItem(0, product);
    private ArrayList<LineItem> lineItems = new ArrayList<>();
    private Invoice invoice = new Invoice("invoice", address, lineItems);

    JPanel mainPnl, invoicePnl, ctrlPnl;
    JLabel titleLbl;
    JTextArea invoiceTA;
    JButton quitBtn, addInvoiceBtn, doneBtn;

    int response;

    public InvoiceFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);

        createInvoicePanel();
        createControlPanel();

        setTitle("Invoice Maker");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void createInvoicePanel()
    {
        invoicePnl = new JPanel(new BorderLayout());
        titleLbl = new JLabel("INVOICE");
        titleLbl.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        invoiceTA = new JTextArea(15, 25);
        invoiceTA.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        invoiceTA.setEditable(false);

        invoicePnl.add(titleLbl, BorderLayout.NORTH);
        invoicePnl.add(invoiceTA, BorderLayout.CENTER);

        mainPnl.add(invoicePnl, BorderLayout.CENTER);
    }

    public void createControlPanel()
    {
        ctrlPnl = new JPanel();
        quitBtn = new JButton("Quit");
        addInvoiceBtn = new JButton("Add Line Items");

        quitBtn.addActionListener((ActionEvent e) -> {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        });

        addInvoiceBtn.addActionListener((ActionEvent e) -> {
            String endLine = "================================================";
            String custName = JOptionPane.showInputDialog("What is the customer's name?");
            address.setCustName(custName);
            String street = JOptionPane.showInputDialog("What is the street address?");
            address.setStreet(street);
            String city = JOptionPane.showInputDialog("What is the city?");
            address.setCity(city);
            String state = JOptionPane.showInputDialog("What is the state?");
            address.setState(state);
            String zip = JOptionPane.showInputDialog("What is the zip code?");
            address.setZip(zip);

            invoice.setCustAddress(new Address(
                    address.getCustName(),
                    address.getStreet(),
                    address.getCity(),
                    address.getState(),
                    address.getZip()
            ));
            do
            {
                String name = JOptionPane.showInputDialog("What is the product name?");
                String price = JOptionPane.showInputDialog("What is the price of the product?");
                String quantity = JOptionPane.showInputDialog("What is the quantity?");

                double unitPrice = Double.parseDouble(price);
                int pQuantity = Integer.parseInt(quantity);

                Product p = new Product(name, unitPrice);
                LineItem l = new LineItem(pQuantity, p);

                lineItem.calculateTotal();

                invoice.getLineItems().add(l);

                response = JOptionPane.showConfirmDialog(null, "Have you added all line items?", "Confirm Commit to Invoice", JOptionPane.YES_NO_OPTION);
            }
            while (response == JOptionPane.NO_OPTION);

            //print address
            invoiceTA.append(address.getCustName() + "\n");
            invoiceTA.append(address.getStreet() + "\n");
            invoiceTA.append(address.getCity() + ", " + address.getState() + ", " + address.getZip() + "\n\n");
            //print invoice
            invoiceTA.append(endLine + "\n");
            String categories = String.format("%-20s%-9s%-9s%9s\n", "Item", "Qty", "Price", "Total");
            invoiceTA.append(categories);
            for (LineItem item : invoice.getLineItems())
            {
                String productName = item.getProduct().getName();
                double productPrice = item.getProduct().getUnitPrice();
                int productQuantity = item.getQuantity();
                double itemTotal = item.getLineItemTotal();
                String line = String.format("%-20s%-9d$%-12.2f$%4.2f\n", productName, productQuantity, productPrice, itemTotal);
                invoiceTA.append(line);
            }
            invoice.calculateAmountDue();
            double totalAmount = invoice.getAmountDue();
            invoiceTA.append(endLine + "\n");
            invoiceTA.append("AMOUNT DUE: $" + totalAmount);
        });

        ctrlPnl.add(addInvoiceBtn);
        ctrlPnl.add(quitBtn);
        mainPnl.add(ctrlPnl, BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new InvoiceFrame());
    }
}

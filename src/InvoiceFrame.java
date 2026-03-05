import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvoiceFrame extends JFrame
{
    private Invoice invoice;
    private Product product;
    private LineItem lineItem;
    private Address address;

    JPanel mainPnl, inputPnl, invoicePnl, ctrlPnl;
    JLabel titleLbl, custNameLbl, streetLbl, cityLbl, stateLbl, zipLbl;
    JTextField custNameTF, streetTF, cityTF, stateTF, zipTF;
    JTextArea lineItemsTA, custAddressTA;
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
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void createInvoicePanel()
    {
        invoicePnl = new JPanel(new BorderLayout());
        titleLbl = new JLabel("INVOICE");
        titleLbl.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        lineItemsTA = new JTextArea(15, 25);
        lineItemsTA.setEditable(false);
        lineItemsTA.setText("Test line");
        custAddressTA = new JTextArea(5, 15);
        custAddressTA.setEditable(false);
        custAddressTA.setText("Test address");

        invoicePnl.add(titleLbl, BorderLayout.NORTH);
        invoicePnl.add(custAddressTA, BorderLayout.CENTER);
        invoicePnl.add(lineItemsTA, BorderLayout.SOUTH);

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
            String endLine = "=========================================";
            String custName = JOptionPane.showInputDialog("What is the customer's name?");
            String street = JOptionPane.showInputDialog("What is the street address?");
            String city = JOptionPane.showInputDialog("What is the city?");
            String state = JOptionPane.showInputDialog("What is the state?");
            String zip = JOptionPane.showInputDialog("What is the zip code?");
            invoice.setCustAddress(new Address(
                    custName,
                    street,
                    city,
                    state,
                    zip
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
            custAddressTA.append(address.getCustName() + "\n");
            custAddressTA.append(address.getStreet() + "\n");
            custAddressTA.append(address.getCity() + ", " + address.getState() + ", " + address.getZip());
            //print invoice
            lineItemsTA.append(endLine + "\n");
            lineItemsTA.append("Item" + "\t\t\t" + "Qty" + "\t" + "Price" + "\t" + "Total" + "\n");
            for (LineItem item : invoice.getLineItems())
            {
                String productName = item.getProduct().getName();
                double productPrice = item.getProduct().getUnitPrice();
                int productQuantity = item.getQuantity();
                double itemTotal = item.getLineItemTotal();
                lineItemsTA.append(productName + "\t\t\t" + productQuantity + "\t$" + productPrice + "\t$" + itemTotal + "\n");
            }
            invoice.calculateAmountDue();
            double totalAmount = invoice.getAmountDue();
            lineItemsTA.append(endLine + "\n");
            lineItemsTA.append("AMOUNT DUE: $" + totalAmount);
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


import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class LibraryUI extends JFrame {
    private JTextField titleField, authorField, quantityField;
    private JTextArea displayArea;

    public LibraryUI() {
        setTitle("Library Management System");
        setSize(400, 400);
        setLayout(null);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(20, 20, 100, 25);
        add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(120, 20, 200, 25);
        add(titleField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(20, 60, 100, 25);
        add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(120, 60, 200, 25);
        add(authorField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(20, 100, 100, 25);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(120, 100, 200, 25);
        add(quantityField);

        JButton addButton = new JButton("Add Book");
        addButton.setBounds(120, 140, 100, 25);
        add(addButton);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 180, 340, 150);
        add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                Book book = new Book(0, title, author, quantity);
                BookDAO.addBook(book);
                displayBooks();
            }
        });

        displayBooks();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void displayBooks() {
        List<Book> list = BookDAO.getAllBooks();
        displayArea.setText("");
        for (Book b : list) {
            displayArea.append("ID: " + b.getId() + ", Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", Qty: " + b.getQuantity() + "\n");
        }
    }

    public static void main(String[] args) {
        new LibraryUI();
    }
}
String title = titleField.getText().trim();
String author = authorField.getText().trim();
String quantityText = quantityField.getText().trim();

//Validation
if (title.isEmpty() || author.isEmpty() || quantityText.isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields are required!");
    return;
}

int quantity;
try {
    quantity = Integer.parseInt(quantityText);
    if (quantity < 0) {
        JOptionPane.showMessageDialog(null, "Quantity must be positive!");
        return;
    }
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Quantity must be a number!");
    return;
}


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Scanner {
    private final JFrame frame;
    private final JPanel scannerPanel;
    private final JButton scanButton;
    private final DefaultListModel<String> listModel;
    private final JList<String> itemList;
    private final JLabel subtotalLabel;


    public Scanner() {
        frame = new JFrame("Scanner");
        frame.getContentPane().setLayout(new BorderLayout(5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scannerPanel = new JPanel();
        scanButton = new JButton("Scan");
        scannerPanel.add(scanButton);
        frame.getContentPane().add(scannerPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(itemList);
        scrollPane.setPreferredSize(new Dimension(200, 150));
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        subtotalLabel = new JLabel("Subtotal: $0.00");
        frame.getContentPane().add(subtotalLabel, BorderLayout.SOUTH);

        frame.setSize(250, 300);
        frame.setLocation(350, 50);
        frame.setVisible(true);
    }


    public int generateUPC() {
        List<Integer> upcList = new ArrayList<>();
        try {
            java.util.Scanner fileScanner = new java.util.Scanner(new File("products.txt"));
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 1) {
                    int code = Integer.parseInt(parts[0]);
                    upcList.add(code);
                }
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (upcList.isEmpty()) {
            return 0;
        }
        Random random = new Random();
        int upc = upcList.get(random.nextInt(upcList.size()));
        System.out.println(upc);
        return upc;
    }


    public void addScannedItem(String item) {
        listModel.addElement(item);
    }


    public void updateSubtotal(double subtotal) {
        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
    }


    public JButton getScanButton() {
        return scanButton;
    }


    public JFrame getFrame() {
        return frame;
    }
    public JPanel getScannerPanel() {
        return scannerPanel;
    }
}

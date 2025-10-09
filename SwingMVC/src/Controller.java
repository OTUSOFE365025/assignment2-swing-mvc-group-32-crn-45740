import javax.swing.JOptionPane;

public class Controller {
    private Model model;
    private View view;

    private Scanner scanner;
    private CashRegister cashRegister;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        initView();
    }

    public void initView() {
        view.getFirstnameTextfield().setText(model.getFirstname());
        view.getLastnameTextfield().setText(model.getLastname());
    }

    public void initController() {
        view.getFirstnameSaveButton().addActionListener(e -> saveFirstname());
        view.getLastnameSaveButton().addActionListener(e -> saveLastname());
        view.getHello().addActionListener(e -> sayHello());
        view.getBye().addActionListener(e -> sayBye());


        if (scanner != null && cashRegister != null) {
            scanner.getScanButton().addActionListener(e -> handleScan());
        }
    }

    private void saveFirstname() {
        model.setFirstname(view.getFirstnameTextfield().getText());
        JOptionPane.showMessageDialog(null, "Firstname saved : " + model.getFirstname(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveLastname() {
        model.setLastname(view.getLastnameTextfield().getText());
        JOptionPane.showMessageDialog(null, "Lastname saved : " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void sayHello() {
        JOptionPane.showMessageDialog(null, "Hello " + model.getFirstname() + " " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void sayBye() {
        System.exit(0);
    }


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public void setCashRegister(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }


    private void handleScan() {
        int upc = scanner.generateUPC();
        CashRegister.Product p = cashRegister.addItem(upc);
        if (p != null) {
            scanner.addScannedItem(p.getName() + " - $" + String.format("%.2f", p.getPrice()));
            scanner.updateSubtotal(cashRegister.getSubtotal());
        } else {
            System.err.println("Unknown UPC: " + upc);
        }
    }




}


public class MySwingMVCApp {

    public static void main(String[] args) {

        Model model = new Model("John", "Doe");
        View view = new View("Cash Register");
        Controller controller = new Controller(model, view);


        Scanner scanner = new Scanner();
        CashRegister cashRegister = new CashRegister();


        controller.setScanner(scanner);
        controller.setCashRegister(cashRegister);

        controller.initController();
    }

}

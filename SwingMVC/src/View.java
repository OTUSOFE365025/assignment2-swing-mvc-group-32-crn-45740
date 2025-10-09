import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class View {
    private final JFrame frame;
    private final JTextField firstnameTextfield;
    private final JTextField lastnameTextfield;
    private final JButton firstnameSaveButton;
    private final JButton lastnameSaveButton;
    private final JButton helloButton;
    private final JButton byeButton;


    public View(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        fieldsPanel.add(new JLabel("First Name:"));
        firstnameTextfield = new JTextField(15);
        fieldsPanel.add(firstnameTextfield);
        fieldsPanel.add(new JLabel("Last Name:"));
        lastnameTextfield = new JTextField(15);
        fieldsPanel.add(lastnameTextfield);

        JPanel buttonsPanel = new JPanel();
        firstnameSaveButton = new JButton("Save First Name");
        lastnameSaveButton = new JButton("Save Last Name");
        helloButton = new JButton("Hello");
        byeButton = new JButton("Bye");
        buttonsPanel.add(firstnameSaveButton);
        buttonsPanel.add(lastnameSaveButton);
        buttonsPanel.add(helloButton);
        buttonsPanel.add(byeButton);

        frame.getContentPane().setLayout(new BorderLayout(5, 5));
        frame.getContentPane().add(fieldsPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        frame.pack();
        // place the window at a reasonable location
        frame.setLocation(200, 50);
        frame.setVisible(true);
    }

    public JTextField getFirstnameTextfield() { return firstnameTextfield; }
    public JTextField getLastnameTextfield() { return lastnameTextfield; }
    public JButton getFirstnameSaveButton() { return firstnameSaveButton; }
    public JButton getLastnameSaveButton() { return lastnameSaveButton; }
    public JButton getHello() { return helloButton; }
    public JButton getBye() { return byeButton; }
}

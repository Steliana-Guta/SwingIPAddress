import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainWindowPanel extends JPanel implements ActionListener {
    private JLabel resultLabel;
    private JTextField searchBox;
    private JButton searchButton;

    public MainWindowPanel() {
        super();

        setLayout(null);

        setupLabelHostName();
        setupTextFieldHostName();
        setupButton();

    }

    private void setupLabelHostName() {
        JLabel label = new JLabel("Hostname");
        label.setBounds(100,100,200,35);

        add(label);

    }

    private void setupTextFieldHostName () {
        searchBox = new JTextField();
        searchBox.setBounds(220, 100, 200, 35);

        add(searchBox);
    }

    private void setupButton() {
        searchButton = new JButton();
        searchButton.setBounds(100, 150, 200,35);

        searchBox.addActionListener(this);

        add(searchButton);
    }

    private void setupLabelResult () {
        resultLabel = new JLabel("Type a hostname and clisk Search Button");
        resultLabel.setBounds(100,250, 300,35);

        add(resultLabel);

    }

    private void doSearch() {
        InetAddress host = null;
        resultLabel.setText("Looking up this computer's address...");

        try {
            host = InetAddress.getLocalHost();

            resultLabel.setText(
                    String.format("Address: %\n Hostname: %s",
                            host.getHostAddress(),
                            host.getHostName())
            );


        }
        catch (UnknownHostException e) {
            System.out.println("Unable to resolve name and address");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton) {
            doSearch();
        }
    }
}

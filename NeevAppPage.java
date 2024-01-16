import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NeevAppPage extends JFrame {

    public NeevAppPage() {
        setTitle("Neev App");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating buttons for headers
        JButton homeButton = createButton("HOME");
        JButton feedButton = createButton("FEED");
        JButton contactButton = createButton("CONTACT");
        JButton exploreButton = createButton("EXPLORE");
        JButton searchButton = createButton("SEARCH");
        JButton userProfileButton = createButton("USER PROFILE");

        // Creating buttons for shortcuts
        JButton assessmentsButton = createButton("ASSESSMENTS");
        JButton startLearningButton = createButton("START LEARNING");
        JButton questionOfTheDayButton = createButton("QUESTION OF THE DAY");
        JButton studyMaterialsButton = createButton("STUDY MATERIALS");
        JButton connectButton = createButton("CONNECT");
        JButton newUpdatesButton = createButton("NEW UPDATES");

        // Adding buttons to the layout
        JPanel headerPanel = new JPanel(new FlowLayout());
        headerPanel.add(homeButton);
        headerPanel.add(feedButton);
        headerPanel.add(contactButton);
        headerPanel.add(exploreButton);
        headerPanel.add(searchButton);
        headerPanel.add(userProfileButton);

        JPanel shortcutsPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        shortcutsPanel.add(assessmentsButton);
        shortcutsPanel.add(startLearningButton);
        shortcutsPanel.add(questionOfTheDayButton);
        shortcutsPanel.add(studyMaterialsButton);
        shortcutsPanel.add(connectButton);
        shortcutsPanel.add(newUpdatesButton);

        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(shortcutsPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(120, 40));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Clicked: " + buttonText);
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NeevAppPage().setVisible(true);
            }
        });
    }
}

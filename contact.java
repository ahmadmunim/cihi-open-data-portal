import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class contact extends JFrame{
    public contact() {
        setTitle("Contact");
        ImageIcon frameLogo = new ImageIcon(getClass().getResource("mapleLeaf.png"));
        setIconImage(frameLogo.getImage());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // North panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));

        JPanel logoPanel = new JPanel(new BorderLayout());
        Icon logoIcon = new ImageIcon(getClass().getResource("logo.png"));
        JLabel imageLabel = new JLabel(logoIcon);
        logoPanel.add(imageLabel);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Canadian Institute for Health Information");
        title.setForeground(Color.decode("#00a19a"));
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel subText = new JLabel("Better data. Better decisions. Healthier Canadians.        ");
        subText.setForeground(Color.BLACK);
        subText.setFont(new Font("Arial", Font.PLAIN, 14));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        subText.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);
        titlePanel.add(subText);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        JTextField searchBar = new JTextField("Search Datasets", 15);
        searchBar.setMaximumSize(new Dimension(300,30));

        ImageIcon searchIcon = new ImageIcon(getClass().getResource("search.png"));
        Image searchImage = searchIcon.getImage();
        searchImage = searchImage.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(searchImage);
        JButton searchButton = new JButton(scaledSearchIcon);
        searchButton.setBorderPainted(false);
        searchButton.setBorder(null);
        searchPanel.add(searchBar, BorderLayout.CENTER);
        searchPanel.add(searchButton);

        JPanel loginRegisterPanel = new JPanel();
        loginRegisterPanel.setLayout(new BoxLayout(loginRegisterPanel, BoxLayout.Y_AXIS)); // Set layout
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        loginButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        registerButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new login().setVisible(true);
                dispose();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new register().setVisible(true);
                dispose();
            }
        });
        loginRegisterPanel.add(loginButton);
        loginRegisterPanel.add(registerButton);

        logoPanel.setMaximumSize(new Dimension(65,78));
        northPanel.add(logoPanel, BorderLayout.WEST);
        northPanel.add(titlePanel, BorderLayout.WEST);
        northPanel.add(searchPanel, BorderLayout.CENTER);
        loginRegisterPanel.setPreferredSize(new Dimension(120,78));
        northPanel.add(loginRegisterPanel, BorderLayout.EAST);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setMaximumSize(new Dimension(800, 50));
        buttonPanel.setBackground(Color.decode("#00a19a"));

        JButton homeBtn = new JButton("Home");
        homeBtn.setFont(new Font("Arial", Font.PLAIN, 33));
        homeBtn.setBackground(Color.decode("#00a19a"));
        homeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new home().setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(homeBtn);

        JButton uploadBtn = new JButton("Upload");
        uploadBtn.setFont(new Font("Arial", Font.PLAIN, 33));
        uploadBtn.setBackground(Color.decode("#00a19a"));
        uploadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new upload().setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(uploadBtn);

        JButton aboutBtn = new JButton("About");
        aboutBtn.setFont(new Font("Arial", Font.PLAIN, 33));
        aboutBtn.setBackground(Color.decode("#00a19a"));
        aboutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new about().setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(aboutBtn);

        JButton dataBtn = new JButton("Datasets");
        dataBtn.setFont(new Font("Arial", Font.PLAIN, 33));
        dataBtn.setBackground(Color.decode("#00a19a"));
        dataBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new datasets().setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(dataBtn);

        JButton newsBtn = new JButton("News");
        newsBtn.setFont(new Font("Arial", Font.PLAIN, 33));
        newsBtn.setBackground(Color.decode("#00a19a"));
        newsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new news().setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(newsBtn);

        JButton contactBtn = new JButton("Contact");
        contactBtn.setFont(new Font("Arial", Font.PLAIN, 33));
        contactBtn.setBackground(Color.decode("#00a19a"));
        contactBtn.setEnabled(false);
        buttonPanel.add(contactBtn);

        centerPanel.add(buttonPanel);

        // Panel for login
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.Y_AXIS));
        contactPanel.setBackground(Color.LIGHT_GRAY);
        JLabel txtContact = new JLabel("Contact Us");
        txtContact.setFont(new Font("Arial", Font.BOLD, 30));
        txtContact.setAlignmentX(Component.CENTER_ALIGNMENT);
        contactPanel.add(txtContact);

        JPanel name = new JPanel();
        name.setLayout(new BoxLayout(name, BoxLayout.X_AXIS));

        JTextField first = new JTextField("First Name");
        first.setMaximumSize(new Dimension(200,30));
        name.add(first);

        JTextField last = new JTextField("Last Name");
        last.setMaximumSize(new Dimension(200,30));
        name.add(last);

        contactPanel.add(name);

        JTextField email = new JTextField("Email");
        email.setMaximumSize(new Dimension(300,30));
        contactPanel.add(email);

        JTextArea message = new JTextArea("Type message here");
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JScrollPane scrollMsg = new JScrollPane(message);
        scrollMsg.setMaximumSize(new Dimension(400,400));
        contactPanel.add(scrollMsg);

        JLabel error = new JLabel(" ");
        error.setFont(new Font("Arial", Font.BOLD, 15));
        error.setForeground(Color.RED);
        contactPanel.add(error);

        JButton sendBtn = new JButton("Send Email");
        contactPanel.add(sendBtn);
        sendBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        centerPanel.add(buttonPanel);
        contactPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        centerPanel.add(contactPanel);

        // Adding panels to the frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            contact frame = new contact();
            frame.setVisible(true);
        });
    }
    
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class register extends JFrame {
    public register() {
        setTitle("Register");
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
        searchBar.setMaximumSize(new Dimension(300, 30));

        ImageIcon searchIcon = new ImageIcon(getClass().getResource("search.png"));
        Image searchImage = searchIcon.getImage();
        searchImage = searchImage.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
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
        registerButton.setEnabled(false);
        loginButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        registerButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new login().setVisible(true);
                dispose();
            }
        });
        loginRegisterPanel.add(loginButton);
        loginRegisterPanel.add(registerButton);

        logoPanel.setMaximumSize(new Dimension(65, 78));
        northPanel.add(logoPanel, BorderLayout.WEST);
        northPanel.add(titlePanel, BorderLayout.WEST);
        northPanel.add(searchPanel, BorderLayout.CENTER);
        loginRegisterPanel.setPreferredSize(new Dimension(120, 78));
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
        contactBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new contact().setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(contactBtn);

        // Panel for Register
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
        registerPanel.setBackground(Color.LIGHT_GRAY);

        JLabel txtLogin = new JLabel("Register");
        txtLogin.setFont(new Font("Arial", Font.BOLD, 30));
        txtLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerPanel.add(txtLogin);

        JPanel name = new JPanel();
        name.setLayout(new BoxLayout(name, BoxLayout.X_AXIS));

        JTextField first = new JTextField("First Name");
        first.setMaximumSize(new Dimension(200, 30));
        name.add(first);

        JTextField last = new JTextField("Last Name");
        last.setMaximumSize(new Dimension(200, 30));
        name.add(last);

        registerPanel.add(name);

        JTextField email = new JTextField("Email");
        email.setMaximumSize(new Dimension(300, 30));
        registerPanel.add(email);

        JTextField pass = new JTextField("Password");
        pass.setMaximumSize(new Dimension(300, 30));
        registerPanel.add(pass);

        JTextField passReEnter = new JTextField("Re-Enter Password");
        passReEnter.setMaximumSize(new Dimension(300, 30));
        registerPanel.add(passReEnter);

        JLabel error = new JLabel(" ");
        error.setFont(new Font("Arial", Font.BOLD, 15));
        error.setForeground(Color.RED);
        registerPanel.add(error);

        JPanel registerBtnPanel = new JPanel();
        registerBtnPanel.setLayout(new BoxLayout(registerBtnPanel, BoxLayout.X_AXIS));

        JButton registerBtn = new JButton("Register");
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = first.getText();
                String lastName = last.getText();
                String userEmail = email.getText();
                String userPassword = pass.getText();

                if (registerUser(firstName, lastName, userEmail, userPassword)) {
                    JOptionPane.showMessageDialog(null, "Registration Successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration Failed");
                }
            }
        });
        registerBtnPanel.add(registerBtn);

        registerPanel.add(registerBtnPanel);

        centerPanel.add(buttonPanel);
        registerPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        centerPanel.add(registerPanel);

        // Adding panels to the frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

    }
    private boolean registerUser(String firstName, String lastName, String email, String password) {
    String url = "jdbc:postgresql:cihiplatform.db"; // Replace with your database path
    String sql = "INSERT INTO users(first_name, last_name, email, password) VALUES(?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, email);
        pstmt.setString(4, password);
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            register frame = new register();
            frame.setVisible(true);
        });
    }
}
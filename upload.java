import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class upload extends JFrame implements Scene<upload> {

    public static ActionListener makeActionListener(Window w) {
        return e -> {
            new upload().setVisible(true);
            w.dispose();
        };
    }

    private JTextField dataName;
    private JTextField dateOfPub;
    private JTextArea dataDesc;
    private JTextField inputTag;
    private JTextArea tags;
    private File selectedDatasetFile;
    private File selectedHeaderImage;
    public upload() {
        setTitle("Upload Data");
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
        uploadBtn.setEnabled(false);
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

        centerPanel.add(buttonPanel);

        // Panel for Upload
        
        JPanel uploadPanel = new JPanel();
        uploadPanel.setLayout(new BoxLayout(uploadPanel, BoxLayout.Y_AXIS));
        uploadPanel.setBackground(Color.LIGHT_GRAY);

        JPanel subtitlePanel = new JPanel();
        subtitlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel txtUpload = new JLabel("Upload Data");
        txtUpload.setFont(new Font("Arial", Font.BOLD, 30));
        txtUpload.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitlePanel.add(txtUpload);

        uploadPanel.add(subtitlePanel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setBackground(Color.LIGHT_GRAY);

            JPanel descPanel = new JPanel();
            descPanel.setLayout(new BoxLayout(descPanel, BoxLayout.Y_AXIS));
            descPanel.setPreferredSize(new Dimension(250,250));
            descPanel.setBackground(Color.LIGHT_GRAY);
        
            JTextField dataName = new JTextField("Dataset Name *");
            dataName.setMaximumSize(new Dimension(300,30));
            descPanel.add(dataName);

            JTextField dateOFPub = new JTextField("Date of Publication *");
            dateOFPub.setMaximumSize(new Dimension(300,30));
            descPanel.add(dateOFPub);

            JTextArea dataDesc = new JTextArea("Description of Dataset *");
            dataDesc.setLineWrap(true);
            dataDesc.setWrapStyleWord(true);
            JScrollPane scrollDesc = new JScrollPane(dataDesc);
            descPanel.add(scrollDesc);

            JPanel tagPanel = new JPanel();
            tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.Y_AXIS));
            tagPanel.setPreferredSize(new Dimension(250,250));
            tagPanel.setBackground(Color.LIGHT_GRAY);

            JTextField inputTag = new JTextField("Related Topics *");
            inputTag.setMaximumSize(new Dimension(300,30));
            tagPanel.add(inputTag);

            JPanel addRemove = new JPanel();
            addRemove.setLayout(new BoxLayout(addRemove, BoxLayout.X_AXIS));
            JButton add = new JButton("Add");
            addRemove.setBackground(Color.LIGHT_GRAY);
            addRemove.add(add);

            JButton remove = new JButton("Remove");
            addRemove.add(remove);

            tagPanel.add(addRemove);

            JTextArea tags = new JTextArea("Your dataset must contain tags so it can be searched");
            tags.setFocusable(false);
            tags.setLineWrap(true);
            tags.setWrapStyleWord(true);
            JScrollPane scrollTags = new JScrollPane(tags);
            tagPanel.add(scrollTags);

            JPanel filePanel = new JPanel();
            filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.Y_AXIS));
            filePanel.setPreferredSize(new Dimension(250,250));
            filePanel.setBackground(Color.LIGHT_GRAY);

            JButton uploadFileBtn = new JButton("Select File... *");
            uploadFileBtn.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Dataset Files", "csv", "json", "xlsx"));
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedDatasetFile = fileChooser.getSelectedFile();
                    // You can update the UI to show the selected file name
                }
            });
            uploadFileBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            filePanel.add(uploadFileBtn);

            JLabel fileTypesData = new JLabel("File types allowed: .csv, .json, .xlsx");
            fileTypesData.setAlignmentX(Component.CENTER_ALIGNMENT);
            filePanel.add(fileTypesData);

            JButton uploadHeaderBtn = new JButton("Select Header Image...");
            uploadHeaderBtn.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "pdf"));
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedHeaderImage = fileChooser.getSelectedFile();
                    // You can update the UI to show the selected file name
                }
            });
            uploadHeaderBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            filePanel.add(uploadHeaderBtn);

            JLabel fileTypesHeader = new JLabel("File types allowed: .png, .pdf, .jpg, .jpeg");
            fileTypesHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
            filePanel.add(fileTypesHeader);

        inputPanel.add(descPanel);
        inputPanel.add(tagPanel);
        inputPanel.add(filePanel);



        uploadPanel.add(inputPanel);

        JButton uploadDataset = new JButton("Upload Dataset");
        uploadDataset.addActionListener(e -> uploadDataset());
        uploadPanel.add(uploadDataset);
        uploadDataset.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel required = new JLabel("* Indicates a required field...");
        uploadPanel.add(required);
        required.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        centerPanel.add(uploadPanel);

        // Adding panels to the frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
    }

    private void uploadDataset() {
        String datasetName = dataName.getText();
        String publicationDate = dateOfPub.getText();
        String description = dataDesc.getText();
        String tags = inputTag.getText();

     String url = "jdbc:sqlite:your_database.db"; // Replace with your database path
    String sql = "INSERT INTO datasets(name, publication_date, description, tags, file_path, image_path) VALUES(?,?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, datasetName);
        pstmt.setString(2, publicationDate);
        pstmt.setString(3, description);
        pstmt.setString(4, tags);
        pstmt.setString(5, selectedDatasetFile.getAbsolutePath());
        pstmt.setString(6, selectedHeaderImage.getAbsolutePath());
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Dataset uploaded successfully");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(this, "Error uploading dataset");
    }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            upload frame = new upload();
            frame.setVisible(true);
        });
    }
}
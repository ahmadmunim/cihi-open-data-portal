import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class datasets extends JFrame{
    public datasets() {
        setTitle("Datasets");
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
        dataBtn.setEnabled(false);
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
        
        JPanel datasetPanel = new JPanel();
        datasetPanel.setLayout(new BoxLayout(datasetPanel, BoxLayout.X_AXIS));
        datasetPanel.setBackground(Color.LIGHT_GRAY);

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));

        JPanel subtitlePanel = new JPanel();
        subtitlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel txtDataset = new JLabel("Datasets");
        txtDataset.setFont(new Font("Arial", Font.BOLD, 30));
        txtDataset.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitlePanel.add(txtDataset);
        filterPanel.add(subtitlePanel);

        JLabel viewSubheader = new JLabel("Veiw By");
        viewSubheader.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewSubheader.setFont(new Font("Arial", Font.BOLD, 20));
        filterPanel.add(viewSubheader);

        JPanel filterButtonPanel = new JPanel();
        filterButtonPanel.setLayout(new BoxLayout(filterButtonPanel, BoxLayout.Y_AXIS));
        filterButtonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JButton diseases = new JButton("Diseases");
        filterButtonPanel.add(diseases);

        JButton demographic = new JButton("Demogroaphics");
        filterButtonPanel.add(demographic);

        JButton date = new JButton("Date");
        filterButtonPanel.add(date);

        JButton location = new JButton("Location");
        filterButtonPanel.add(location);

        //edit font size to change gap from bottom of page
        JLabel filler = new JLabel(" ");
        filler.setFont(new Font("Arial", Font.BOLD, 190));
        filler.setOpaque(false);
        filterButtonPanel.add(filler);

        filterPanel.add(filterButtonPanel);


        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));

        JPanel subtitlePanel2 = new JPanel();
        subtitlePanel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel txtLatest = new JLabel("Latest Data");
        txtLatest.setFont(new Font("Arial", Font.BOLD, 30));
        subtitlePanel2.add(txtLatest);
        txtLatest.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataPanel.add(subtitlePanel2);

        JPanel latestDatasetPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        //latestDatasetPanel.setLayout(new BoxLayout(latestDatasetPanel, BoxLayout.X_AXIS));

        JPanel data1 = new JPanel();
        data1.setLayout(new BoxLayout(data1, BoxLayout.Y_AXIS));
        data1.setBackground(Color.decode("#00a19a"));

        JLabel dataTitle1 = new JLabel("Sample Data");
        dataTitle1.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataTitle1.setForeground(Color.WHITE);
        dataTitle1.setFont(new Font("Arial", Font.BOLD, 20));
        data1.add(dataTitle1);

        JLabel dataDate1 = new JLabel("Sample Date");
        dataDate1.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataDate1.setForeground(Color.WHITE);
        dataDate1.setFont(new Font("Arial", Font.ITALIC, 12));
        data1.add(dataDate1);
        JTextArea dataDesc1 = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quam metus, vehicula non justo vel, pretium congue metus. Maecenas scelerisque diam in placerat elementum. Sed dignissim nulla viverra interdum bibendum. Duis eget neque nec libero ultricies vulputate vel id metus. Nam aliquam posuere lorem, non pulvinar nisl lacinia vitae. Proin in bibendum dui.");
        dataDesc1.setForeground(Color.WHITE);
        dataDesc1.setLineWrap(true);
        dataDesc1.setWrapStyleWord(true);
        dataDesc1.setFocusable(false);
        dataDesc1.setOpaque(false);
        dataDesc1.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataDesc1.setMaximumSize(new Dimension(250,250));
        data1.add(dataDesc1);
        latestDatasetPanel.add(data1);

        JPanel data2 = new JPanel();
        data2.setLayout(new BoxLayout(data2, BoxLayout.Y_AXIS));
        data2.setBackground(Color.decode("#00a19a"));

        JLabel dataTitle2 = new JLabel("Sample Data");
        dataTitle2.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataTitle2.setForeground(Color.WHITE);
        dataTitle2.setFont(new Font("Arial", Font.BOLD, 20));
        data2.add(dataTitle2);

        JLabel dataDate2 = new JLabel("Sample Date");
        dataDate2.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataDate2.setForeground(Color.WHITE);
        dataDate2.setFont(new Font("Arial", Font.ITALIC, 12));
        data2.add(dataDate2);
        JTextArea dataDesc2 = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quam metus, vehicula non justo vel, pretium congue metus. Maecenas scelerisque diam in placerat elementum. Sed dignissim nulla viverra interdum bibendum. Duis eget neque nec libero ultricies vulputate vel id metus. Nam aliquam posuere lorem, non pulvinar nisl lacinia vitae. Proin in bibendum dui.");
        dataDesc2.setForeground(Color.WHITE);
        dataDesc2.setLineWrap(true);
        dataDesc2.setWrapStyleWord(true);
        dataDesc2.setFocusable(false);
        dataDesc2.setOpaque(false);
        dataDesc2.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataDesc2.setMaximumSize(new Dimension(250,250));
        data2.add(dataDesc2);
        latestDatasetPanel.add(data2);

        JPanel data3 = new JPanel();
        data3.setLayout(new BoxLayout(data3, BoxLayout.Y_AXIS));
        data3.setBackground(Color.decode("#00a19a"));

        JLabel dataTitle3 = new JLabel("Sample Data");
        dataTitle3.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataTitle3.setForeground(Color.WHITE);
        dataTitle3.setFont(new Font("Arial", Font.BOLD, 20));
        data3.add(dataTitle3);

        JLabel dataDate3 = new JLabel("Sample Date");
        dataDate3.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataDate3.setForeground(Color.WHITE);
        dataDate3.setFont(new Font("Arial", Font.ITALIC, 12));
        data3.add(dataDate3);
        JTextArea dataDesc3 = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quam metus, vehicula non justo vel, pretium congue metus. Maecenas scelerisque diam in placerat elementum. Sed dignissim nulla viverra interdum bibendum. Duis eget neque nec libero ultricies vulputate vel id metus. Nam aliquam posuere lorem, non pulvinar nisl lacinia vitae. Proin in bibendum dui.");
        dataDesc3.setForeground(Color.WHITE);
        dataDesc3.setLineWrap(true);
        dataDesc3.setWrapStyleWord(true);
        dataDesc3.setFocusable(false);
        dataDesc3.setOpaque(false);
        dataDesc3.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataDesc3.setMaximumSize(new Dimension(250,250));
        data3.add(dataDesc3);
        latestDatasetPanel.add(data3);

        dataPanel.add(latestDatasetPanel);

        JPanel selectionPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        //selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.X_AXIS));
        selectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton viewData1 = new JButton("View Data");
        selectionPanel.add(viewData1);

        JButton viewData2 = new JButton("View Data");
        selectionPanel.add(viewData2);

        JButton viewData3 = new JButton("View Data");
        selectionPanel.add(viewData3);

        dataPanel.add(selectionPanel);
        
        datasetPanel.add(filterPanel);
        datasetPanel.add(dataPanel);

        centerPanel.add(datasetPanel);

        // Adding panels to the frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            datasets frame = new datasets();
            frame.setVisible(true);
        });
    }
    
}

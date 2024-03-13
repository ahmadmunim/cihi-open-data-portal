import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class about extends JFrame{
    public about() {
        setTitle("About");
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
        aboutBtn.setEnabled(false);
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

        // Panel for About
        
        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
        aboutPanel.setBackground(Color.decode("#00a19a"));

        JPanel subtitlePanel = new JPanel();
        subtitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel txtAbout = new JLabel("About CIHI");
        txtAbout.setFont(new Font("Arial", Font.BOLD, 30));
        txtAbout.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitlePanel.add(txtAbout);

        aboutPanel.add(subtitlePanel);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBackground(Color.decode("#00a19a"));

            JPanel imgPanel = new JPanel();
            imgPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            imgPanel.setPreferredSize(new Dimension(200,200));
            imgPanel.setBackground(Color.decode("#00a19a"));
        
            ImageIcon aboutImg = new ImageIcon(getClass().getResource("aboutimg.png"));
            JLabel img = new JLabel(aboutImg);
            imgPanel.add(img);

            JPanel aboutInfo = new JPanel();
            aboutInfo.setLayout(new BoxLayout(aboutInfo, BoxLayout.Y_AXIS));
            aboutInfo.setPreferredSize(new Dimension(350,350));
            aboutInfo.setBackground(Color.white);

            JLabel subHeader = new JLabel("Our Strategic Plan");
            subHeader.setFont(new Font("Arial", Font.BOLD, 15));
            subHeader.setAlignmentX(CENTER_ALIGNMENT);
            aboutInfo.add(subHeader);

            JTextArea infoText = new JTextArea("After holding extensive consultations with stakeholders across the country to better understand their needs, both now and in the future, CIHI completed its Strategic Plan, 2022 to 2027 (PDF). Over the next 5 years, CIHI will focus its efforts on delivering comparable and actionable information to accelerate improvements in health care system performance.\n" + //
                                "\n" + //
                                " We will focus on a number of health information priorities, including\n" + //
                                "-Children and youth\n" + //
                                "-Community and primary care \n" + //
                                "-Equity \n" + //
                                "-First Nations, Inuit and Métis Peoples\n" + //
                                "-Health systems and public health links \n" + //
                                "-Health workforce \n" + //
                                "-Mental health and substance use \n" + //
                                "-Seniors and aging\n" + //
                                "-Virtual care ");
            infoText.setFocusable(false);
            infoText.setLineWrap(true);
            infoText.setWrapStyleWord(true);
            aboutInfo.add(infoText);

            JPanel overallReportPanel = new JPanel();
            overallReportPanel.setLayout(new BoxLayout(overallReportPanel, BoxLayout.Y_AXIS));
            overallReportPanel.setBackground(Color.decode("#00a19a"));

            JPanel reportPanel = new JPanel();
            reportPanel.setLayout(new BoxLayout(reportPanel, BoxLayout.Y_AXIS));
            reportPanel.setPreferredSize(new Dimension(200,100));
            reportPanel.setBackground(Color.white);

            JLabel subHeader2 = new JLabel("Our Annual Report");
            subHeader2.setFont(new Font("Arial", Font.BOLD, 15));
            subHeader2.setAlignmentX(CENTER_ALIGNMENT);
            reportPanel.add(subHeader2);

            JTextArea infoText2 = new JTextArea("The annual report provides an overview of CIHI, our corporate achievements this past fiscal year, priorities for the upcoming year and a summary of the audited financial statements.");
            infoText2.setFocusable(false);
            infoText2.setLineWrap(true);
            infoText2.setWrapStyleWord(true);
            reportPanel.add(infoText2);

            overallReportPanel.add(reportPanel);

            JLabel gap = new JLabel(" ");
            overallReportPanel.add(gap);
            overallReportPanel.add(gap);

            JButton annualReport = new JButton("Read our annual report\n(PDF)");
            annualReport.setAlignmentX(Component.CENTER_ALIGNMENT);
            overallReportPanel.add(annualReport);

            overallReportPanel.add(gap);

            JButton strategicPlan = new JButton("Read our strategic plan\n(PDF)");
            strategicPlan.setAlignmentX(Component.CENTER_ALIGNMENT);
            overallReportPanel.add(strategicPlan);

        infoPanel.add(imgPanel);
        infoPanel.add(aboutInfo);
        infoPanel.add(overallReportPanel);



        aboutPanel.add(infoPanel);

        centerPanel.add(aboutPanel);

        // Adding panels to the frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            about frame = new about();
            frame.setVisible(true);
        });
    }
    
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class news extends JFrame{
    public news() {
        setTitle("News");
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
        newsBtn.setEnabled(false);
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

        // Panel for News
        
        JPanel newsPanel = new JPanel();
        newsPanel.setLayout(new BoxLayout(newsPanel, BoxLayout.X_AXIS));
        newsPanel.setBackground(Color.LIGHT_GRAY);

        JPanel aboutUsPanel = new JPanel();
        aboutUsPanel.setLayout(new BoxLayout(aboutUsPanel, BoxLayout.Y_AXIS));

        JPanel subtitlePanel = new JPanel();
        subtitlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel txtNews = new JLabel("News");
        txtNews.setFont(new Font("Arial", Font.BOLD, 30));
        txtNews.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitlePanel.add(txtNews);
        aboutUsPanel.add(subtitlePanel);

        JLabel aboutUsSubheader = new JLabel("About Us");
        aboutUsSubheader.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutUsSubheader.setFont(new Font("Arial", Font.BOLD, 20));
        aboutUsPanel.add(aboutUsSubheader);

        JPanel aboutButtonPanel = new JPanel();
        aboutButtonPanel.setLayout(new BoxLayout(aboutButtonPanel, BoxLayout.Y_AXIS));
        aboutButtonPanel.setAlignmentY(Component.LEFT_ALIGNMENT);

        JButton events = new JButton("Our Events");
        aboutButtonPanel.add(events);

        JButton recentlyAdded = new JButton("Recent");
        aboutButtonPanel.add(recentlyAdded);

        JButton podcast = new JButton("Podcast");
        aboutButtonPanel.add(podcast);

        JButton education = new JButton("Education");
        aboutButtonPanel.add(education);

        JButton healthNews = new JButton("Health");
        aboutButtonPanel.add(healthNews);

        //edit font size to change gap from bottom of page
        JLabel filler = new JLabel(" ");
        filler.setFont(new Font("Arial", Font.BOLD, 190));
        filler.setOpaque(false);
        aboutButtonPanel.add(filler);

        aboutUsPanel.add(aboutButtonPanel);


        JPanel newsTabsPanel = new JPanel();
        newsTabsPanel.setLayout(new BoxLayout(newsTabsPanel, BoxLayout.Y_AXIS));

        JPanel subtitlePanel2 = new JPanel();
        subtitlePanel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel txtLatest = new JLabel("");
        txtLatest.setFont(new Font("Arial", Font.BOLD, 30));
        subtitlePanel2.add(txtLatest);
        txtLatest.setAlignmentX(Component.CENTER_ALIGNMENT);
        newsTabsPanel.add(subtitlePanel2);

        JPanel newsTabs = new JPanel(new GridLayout(1, 3, 10, 20));

        JPanel upcomingEvents = new JPanel();
        upcomingEvents.setLayout(new BoxLayout(upcomingEvents, BoxLayout.Y_AXIS));
        upcomingEvents.setBackground(Color.decode("#00a19a"));

        JLabel upcomingEventsTxt = new JLabel("Upcoming Events");
        upcomingEventsTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
        upcomingEventsTxt.setForeground(Color.WHITE);
        upcomingEventsTxt.setFont(new Font("Arial", Font.BOLD, 25));
        upcomingEvents.add(upcomingEventsTxt);

        JLabel eHealth = new JLabel("e-Health 2024");
        eHealth.setAlignmentX(Component.CENTER_ALIGNMENT);
        eHealth.setForeground(Color.BLUE);
        eHealth.setFont(new Font("Arial", Font.ITALIC, 20));
        upcomingEvents.add(eHealth);
        JTextArea eHealthDesc = new JTextArea("e-Health Conference and Tradeshow will be held in Vancouver.\n" + //
                        "\n" + //
                        "As a co-host, CIHI will be presenting and exhibiting at the event. Check back here for further details.\n\nLoc: Vancouver, BC\nMay 26th, 2024 - May 28th, 2024");
        eHealthDesc.setForeground(Color.WHITE);
        eHealthDesc.setLineWrap(true);
        eHealthDesc.setWrapStyleWord(true);
        eHealthDesc.setFocusable(false);
        eHealthDesc.setOpaque(false);
        eHealthDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
        eHealthDesc.setMaximumSize(new Dimension(200,250));
        upcomingEvents.add(eHealthDesc);
        newsTabs.add(upcomingEvents);

        JPanel recentlyAddedData = new JPanel();
        recentlyAddedData.setLayout(new BoxLayout(recentlyAddedData, BoxLayout.Y_AXIS));
        recentlyAddedData.setBackground(Color.decode("#00a19a"));

        JLabel recentlyAddedTxt = new JLabel("Recently Added Data");
        recentlyAddedTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
        recentlyAddedTxt.setForeground(Color.WHITE);
        recentlyAddedTxt.setFont(new Font("Arial", Font.BOLD, 20));
        recentlyAddedData.add(recentlyAddedTxt);

        JLabel recentSubhead1 = new JLabel("Senior's Perescription Drug Use");
        recentSubhead1.setAlignmentX(Component.CENTER_ALIGNMENT);
        recentSubhead1.setForeground(Color.BLUE);
        recentSubhead1.setFont(new Font("Arial", Font.ITALIC, 14));
        recentlyAddedData.add(recentSubhead1);
        JTextArea recentDesc1 = new JTextArea("- A collection of perscription drugs for seniors based on drug, doseage, reason, duration, and province ");
        recentDesc1.setForeground(Color.WHITE);
        recentDesc1.setLineWrap(true);
        recentDesc1.setWrapStyleWord(true);
        recentDesc1.setFocusable(false);
        recentDesc1.setOpaque(false);
        recentDesc1.setAlignmentX(Component.CENTER_ALIGNMENT);
        recentDesc1.setMaximumSize(new Dimension(200,250));
        recentlyAddedData.add(recentDesc1);

        JLabel recentSubhead2 = new JLabel("February 2024 Hospital Stays");
        recentSubhead2.setAlignmentX(Component.CENTER_ALIGNMENT);
        recentSubhead2.setForeground(Color.BLUE);
        recentSubhead2.setFont(new Font("Arial", Font.ITALIC, 14));
        recentlyAddedData.add(recentSubhead2);
        JTextArea recentDesc2 = new JTextArea("- Dataset of all hospital instances including duration, reason, and more");
        recentDesc2.setForeground(Color.WHITE);
        recentDesc2.setLineWrap(true);
        recentDesc2.setWrapStyleWord(true);
        recentDesc2.setFocusable(false);
        recentDesc2.setOpaque(false);
        recentDesc2.setAlignmentX(Component.CENTER_ALIGNMENT);
        recentDesc2.setMaximumSize(new Dimension(200,250));
        recentlyAddedData.add(recentDesc2);

        JLabel recentSubhead3 = new JLabel("2023 COVID-19 Cases");
        recentSubhead3.setAlignmentX(Component.CENTER_ALIGNMENT);
        recentSubhead3.setForeground(Color.BLUE);
        recentSubhead3.setFont(new Font("Arial", Font.ITALIC, 14));
        recentlyAddedData.add(recentSubhead3);
        JTextArea recentDesc3 = new JTextArea("- All reported cases of COVID-19 in Canada, by province");
        recentDesc3.setForeground(Color.WHITE);
        recentDesc3.setLineWrap(true);
        recentDesc3.setWrapStyleWord(true);
        recentDesc3.setFocusable(false);
        recentDesc3.setOpaque(false);
        recentDesc3.setAlignmentX(Component.CENTER_ALIGNMENT);
        recentDesc3.setMaximumSize(new Dimension(200,250));
        recentlyAddedData.add(recentDesc3);
        newsTabs.add(recentlyAddedData);

        JPanel canadaNews = new JPanel();
        canadaNews.setLayout(new BoxLayout(canadaNews, BoxLayout.Y_AXIS));
        canadaNews.setBackground(Color.decode("#00a19a"));

        JLabel canadaNewsTxt = new JLabel("Canada Health News");
        canadaNewsTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
        canadaNewsTxt.setForeground(Color.WHITE);
        canadaNewsTxt.setFont(new Font("Arial", Font.BOLD, 20));
        canadaNews.add(canadaNewsTxt);

        JLabel news1 = new JLabel("Health Canada 'reviewing' US...");
        news1.setAlignmentX(Component.CENTER_ALIGNMENT);
        news1.setForeground(Color.BLUE);
        news1.setFont(new Font("Arial", Font.ITALIC, 14));
        canadaNews.add(news1);
        JTextArea newsDesc1 = new JTextArea("- Less than a week after a U.S. lab said it detected benzene in several popular...");
        newsDesc1.setForeground(Color.WHITE);
        newsDesc1.setLineWrap(true);
        newsDesc1.setWrapStyleWord(true);
        newsDesc1.setFocusable(false);
        newsDesc1.setOpaque(false);
        newsDesc1.setAlignmentX(Component.CENTER_ALIGNMENT);
        newsDesc1.setMaximumSize(new Dimension(200,250));
        canadaNews.add(newsDesc1);

        JLabel news2 = new JLabel("Massive new survey finds wid...");
        news2.setAlignmentX(Component.CENTER_ALIGNMENT);
        news2.setForeground(Color.BLUE);
        news2.setFont(new Font("Arial", Font.ITALIC, 14));
        canadaNews.add(news2);
        JTextArea newsDesc2 = new JTextArea("- A Toronto-based research team met with and surveyed some 10000 Canadians...");
        newsDesc2.setForeground(Color.WHITE);
        newsDesc2.setLineWrap(true);
        newsDesc2.setWrapStyleWord(true);
        newsDesc2.setFocusable(false);
        newsDesc2.setOpaque(false);
        newsDesc2.setAlignmentX(Component.CENTER_ALIGNMENT);
        newsDesc2.setMaximumSize(new Dimension(200,250));
        canadaNews.add(newsDesc2);

        JLabel news3 = new JLabel("Government of Canada signs a...");
        news3.setAlignmentX(Component.CENTER_ALIGNMENT);
        news3.setForeground(Color.BLUE);
        news3.setFont(new Font("Arial", Font.ITALIC, 14));
        canadaNews.add(news3);
        JTextArea newsDesc3 = new JTextArea("- Today, the Honourable Mark Holland, Canada's Minister of Health and the Honourable Tracy-Anne McPhee,...");
        newsDesc3.setForeground(Color.WHITE);
        newsDesc3.setLineWrap(true);
        newsDesc3.setWrapStyleWord(true);
        newsDesc3.setFocusable(false);
        newsDesc3.setOpaque(false);
        newsDesc3.setAlignmentX(Component.CENTER_ALIGNMENT);
        newsDesc3.setMaximumSize(new Dimension(200,250));
        canadaNews.add(newsDesc3);
        newsTabs.add(canadaNews);

        newsTabsPanel.add(newsTabs);

        JPanel selectionPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        //selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.X_AXIS));
        selectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton view1 = new JButton("View More ->");
        selectionPanel.add(view1);

        JButton view2 = new JButton("View More ->");
        selectionPanel.add(view2);

        JButton view3 = new JButton("View More ->");
        selectionPanel.add(view3);

        newsTabsPanel.add(selectionPanel);
        
        newsPanel.add(aboutUsPanel);
        newsPanel.add(newsTabsPanel);

        centerPanel.add(newsPanel);

        // Adding panels to the frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            news frame = new news();
            frame.setVisible(true);
        });
    }
}

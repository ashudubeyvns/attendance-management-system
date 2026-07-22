package attendancemgt;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeScreen {
    JFrame frame;
    JPanel cardPanel;
    CardLayout cardLayout;

    private static final Color PRIMARY = new Color(44, 62, 80);
    private static final Color ACCENT = new Color(52, 152, 219);
    private static final Color BG_LIGHT = new Color(236, 240, 241);
    private static final Color WHITE = Color.WHITE;
    private static final Color DROPDOWN_BG = new Color(52, 152, 219);

    // Singleton pattern so we have exactly one home screen instance
    private static HomeScreen instance;

    public static HomeScreen getInstance() {
        return instance;
    }

    public static void open() {
        SwingUtilities.invokeLater(() -> {
            if (instance == null || instance.frame == null || !instance.frame.isVisible()) {
                instance = new HomeScreen();
            } else {
                instance.frame.toFront();
                instance.showCard("home");
            }
        });
    }

    public HomeScreen() {
        instance = this;
        frame = new JFrame("Attendance Management System");
        frame.getContentPane().setBackground(BG_LIGHT);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(BG_LIGHT);

        // Home dashboard panel
        JPanel homePanel = createHomePanel();
        cardPanel.add(homePanel, "home");

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);

        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }

    public void addCard(JPanel panel, String name) {
        cardPanel.add(panel, name);
        cardLayout.show(cardPanel, name);
    }

    public void showHome() {
        showCard("home");
    }

    private JPanel createHomePanel() {
        JPanel main = new JPanel(null);
        main.setBackground(BG_LIGHT);

        // Header with Image
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, getResponsiveWidth(1200), 200);
        headerPanel.setBackground(WHITE);
        ImageIcon icon = new ImageIcon(getClass().getResource("/attendancemgt/resources/images.png"));
        Image scaled = icon.getImage().getScaledInstance(getResponsiveWidth(1200), 200, Image.SCALE_SMOOTH);
        headerPanel.add(new JLabel(new ImageIcon(scaled)));
        main.add(headerPanel);

        // Navigation Bar
        JPanel navPanel = new JPanel(null);
        navPanel.setBounds(0, 200, getResponsiveWidth(1200), 50);
        navPanel.setBackground(PRIMARY);
        main.add(navPanel);

        JLabel appTitle = new JLabel("Attendance Management System", SwingConstants.CENTER);
        appTitle.setBounds(20, 0, 400, 50);
        appTitle.setForeground(WHITE);
        appTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        navPanel.add(appTitle);

        String[] userMenu = {"My Account", "Change Password", "Logout"};
        JComboBox<String> userDD = new JComboBox<>(userMenu);
        userDD.setBounds(getResponsiveWidth(1200) - 170, 5, 150, 40);
        userDD.setBackground(DROPDOWN_BG);
        userDD.setForeground(WHITE);
        userDD.setFont(new Font("Segoe UI", Font.BOLD, 13));
        navPanel.add(userDD);
        userDD.addActionListener(e -> {
            String sel = (String) userDD.getSelectedItem();
            if ("Change Password".equals(sel)) {
                JPanel cpPanel = Change_Password.getPanel(this);
                if (cpPanel != null) addCard(cpPanel, "changepassword");
            } else if ("Logout".equals(sel)) {
                frame.dispose();
                instance = null;
                try { new login_frame(); } catch (IOException ex) {
                    Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Dashboard Title
        JLabel dashTitle = new JLabel("DASHBOARD - QUICK ACTIONS", SwingConstants.CENTER);
        dashTitle.setBounds(0, 255, getResponsiveWidth(1200), 35);
        dashTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        dashTitle.setForeground(PRIMARY);
        main.add(dashTitle);

        // Stats Cards (responsive layout)
        int cardW = getResponsiveWidth(160, 1200);
        int cardH = 90;
        int gap = getResponsiveWidth(15, 1200);
        int startX = getResponsiveWidth(25, 1200);
        int yCards = 295;

        String[][] statCards = {
            {"6", "Total Courses"},
            {"130+", "Total Subjects"},
            {"2,450", "Active Students"},
            {"85", "Faculty Members"},
            {"2024-28", "Academic Year"}
        };

        for (int i = 0; i < statCards.length; i++) {
            JPanel card = new JPanel(null);
            card.setBounds(startX + i * (cardW + gap), yCards, cardW, cardH);
            card.setBackground(WHITE);
            card.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));

            JLabel valLbl = new JLabel(statCards[i][0], SwingConstants.CENTER);
            valLbl.setBounds(0, 12, cardW, 35);
            valLbl.setFont(new Font("Segoe UI", Font.BOLD, 26));
            valLbl.setForeground(ACCENT);
            card.add(valLbl);

            JLabel titleLbl = new JLabel(statCards[i][1], SwingConstants.CENTER);
            titleLbl.setBounds(0, 50, cardW, 25);
            titleLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
            titleLbl.setForeground(PRIMARY);
            card.add(titleLbl);
            main.add(card);
        }

        // Course Selection Section
        int yCourses = yCards + cardH + 25;

        JLabel sectionTitle = new JLabel("SELECT COURSE & MODULE", SwingConstants.CENTER);
        sectionTitle.setBounds(0, yCourses, getResponsiveWidth(1200), 30);
        sectionTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        sectionTitle.setForeground(PRIMARY);
        main.add(sectionTitle);

        int ySelector = yCourses + 40;
        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(getResponsiveWidth(180, 1200), ySelector, 80, 35);
        lblCourse.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCourse.setForeground(PRIMARY);
        main.add(lblCourse);

        JComboBox<String> courseDD = new JComboBox<>(SubjectData.COURSE_NAMES);
        courseDD.setBounds(getResponsiveWidth(260, 1200), ySelector, 200, 35);
        courseDD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        courseDD.setBackground(WHITE);
        main.add(courseDD);

        JLabel lblSem = new JLabel("Semester:");
        lblSem.setBounds(getResponsiveWidth(490, 1200), ySelector, 80, 35);
        lblSem.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblSem.setForeground(PRIMARY);
        main.add(lblSem);

        JComboBox<Integer> semDD = new JComboBox<>();
        semDD.setBounds(getResponsiveWidth(570, 1200), ySelector, 80, 35);
        semDD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        semDD.setBackground(WHITE);
        main.add(semDD);
        for (int s = 1; s <= 6; s++) semDD.addItem(s);

        courseDD.addActionListener(e -> {
            String course = (String) courseDD.getSelectedItem();
            int courseIdx = -1;
            for (int i = 0; i < SubjectData.COURSE_NAMES.length; i++) {
                if (SubjectData.COURSE_NAMES[i].equals(course)) { courseIdx = i; break; }
            }
            semDD.removeAllItems();
            int maxSem = (courseIdx >= 0) ? SubjectData.COURSE_SEMESTERS[courseIdx] : 6;
            for (int s = 1; s <= maxSem; s++) semDD.addItem(s);
        });

        // Module Access Cards
        int yButtons = ySelector + 55;

        String[][] modules = {
            {"Mark Attendance", "Mark attendance for lectures & practicals", "Attendance"},
            {"View Attendance", "View daily & consolidated reports", "View"},
            {"Assignments", "Upload marks, records & details", "Assignment"},
            {"Sessionals", "Manage sessional marks", "Sessional"},
            {"Change Password", "Update your password securely", "Password"},
        };

        JPanel modulePanel = new JPanel(null);
        modulePanel.setBounds(getResponsiveWidth(50, 1200), yButtons, getResponsiveWidth(1100, 1200), 280);
        modulePanel.setBackground(BG_LIGHT);
        main.add(modulePanel);

        int mCardW = getResponsiveWidth(470, 1200);
        int mCardH = 80;
        int mGap = 20;

        for (int i = 0; i < modules.length; i++) {
            int col = i % 2;
            int row = i / 2;
            int mx = col * (mCardW + mGap);
            int my = row * (mCardH + 15);

            JPanel mc = new JPanel(null);
            mc.setBounds(mx, my, mCardW, mCardH);
            mc.setBackground(WHITE);
            mc.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1));
            modulePanel.add(mc);

            JLabel tl = new JLabel(modules[i][0]);
            tl.setBounds(20, 12, 250, 22);
            tl.setFont(new Font("Segoe UI", Font.BOLD, 14));
            tl.setForeground(PRIMARY);
            mc.add(tl);

            JLabel dl = new JLabel(modules[i][1]);
            dl.setBounds(20, 36, 300, 20);
            dl.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            dl.setForeground(new Color(120, 120, 120));
            mc.add(dl);

            JButton goBtn = new JButton("Open");
            goBtn.setBounds(mCardW - 100, 20, 80, 40);
            goBtn.setBackground(ACCENT);
            goBtn.setForeground(WHITE);
            goBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
            goBtn.setFocusPainted(false);
            goBtn.setBorderPainted(false);
            goBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            goBtn.setOpaque(true);
            String modType = modules[i][2];
            goBtn.addActionListener(e -> {
                String course = (String) courseDD.getSelectedItem();
                int sem = (Integer) semDD.getSelectedItem();
                try {
                    switch (modType) {
                        case "Attendance":
                            JPanel p1 = MarkAttendance.getPanel(HomeScreen.this, course, sem);
                            if (p1 != null) addCard(p1, "markattendance");
                            break;
                        case "Assignment":
                            JPanel p2 = AssignmentModule.getPanel(HomeScreen.this, course, sem);
                            if (p2 != null) addCard(p2, "assignment");
                            break;
                        case "Sessional":
                            JPanel p3 = SessionalsModule.getPanel(HomeScreen.this, course, sem);
                            if (p3 != null) addCard(p3, "sessional");
                            break;
                        case "Password":
                            JPanel p5 = Change_Password.getPanel(HomeScreen.this);
                            if (p5 != null) addCard(p5, "changepassword");
                            break;
                        case "View":
                            JOptionPane.showMessageDialog(frame,
                                "<html><b>Attendance Report</b><br>Coming soon for " + course + " Sem " + sem + "</html>",
                                "Info", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            mc.add(goBtn);
        }

        // Footer
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        footerPanel.setBounds(0, yButtons + 285, getResponsiveWidth(1200), 40);
        footerPanel.setBackground(PRIMARY);
        main.add(footerPanel);

        String[] footerItems = {"Attendance Management System v2.0", "Designed for Educational ERP By Ashutosh Dubney"};
        for (String fi : footerItems) {
            JLabel fl = new JLabel(fi);
            fl.setForeground(new Color(180, 190, 200));
            fl.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            footerPanel.add(fl);
        }

        int totalHeight = yButtons + 370;
        int totalWidth = getResponsiveWidth(1200);
        main.setPreferredSize(new Dimension(totalWidth, totalHeight));
        return main;
    }

    private int getResponsiveWidth(int base) {
        return getResponsiveWidth(base, 1200);
    }

    private int getResponsiveWidth(int base, int maxDesignWidth) {
        // Simple scaling based on screen size
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        double scale = Math.min(1.0, (double) screenWidth / maxDesignWidth);
        return (int) (base * scale);
    }

    public static void main(String[] args) {
        open();
    }
}

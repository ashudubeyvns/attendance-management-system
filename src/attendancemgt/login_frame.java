package attendancemgt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class login_frame {

    JFrame frame;
    private HashMap<String, String> credentials;

    // Modern color palette
    private static final Color PRIMARY = new Color(44, 62, 80);
    private static final Color ACCENT = new Color(52, 152, 219);
    private static final Color BG_LIGHT = new Color(236, 240, 241);
    private static final Color WHITE = Color.WHITE;
    private static final Color FIELD_BG = new Color(255, 255, 255);

    public login_frame() throws IOException {
        credentials = new HashMap<>();
        credentials.put("24SCSE1180456", "Gu@12345");
        credentials.put("24SCSE1180381", "Gu@12345");
        credentials.put("24SCSE2030222", "Gu@12345");
        credentials.put("123", "012");
        credentials.put("ZIYA", "FATIMA");

        frame = new JFrame("LOGIN - Attendance Management");
        frame.getContentPane().setBackground(BG_LIGHT);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 840, 220);
        panel.setBackground(WHITE);
        frame.add(panel);
        ImageIcon icon = new ImageIcon(getClass().getResource("/attendancemgt/resources/images.png"));
        panel.add(new JLabel(icon));

        // Styled Username Label
        JLabel lbl_username = new JLabel("Username");
        lbl_username.setBounds(300, 270, 250, 25);
        lbl_username.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl_username.setForeground(PRIMARY);
        frame.add(lbl_username);

        JTextField txt_username = new JTextField();
        txt_username.setBounds(300, 298, 250, 35);
        txt_username.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txt_username.setBackground(FIELD_BG);
        txt_username.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            new EmptyBorder(5, 10, 5, 10)));
        frame.add(txt_username);

        // Styled Password Label
        JLabel lbl_password = new JLabel("Password");
        lbl_password.setBounds(300, 345, 250, 25);
        lbl_password.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl_password.setForeground(PRIMARY);
        frame.add(lbl_password);

        JPasswordField value = new JPasswordField();
        value.setBounds(300, 373, 250, 35);
        value.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        value.setBackground(FIELD_BG);
        value.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            new EmptyBorder(5, 10, 5, 10)));
        frame.add(value);

        // Styled Sign In Button
        JButton b = new JButton("Sign In");
        b.setBounds(345, 430, 160, 40);
        b.setBackground(ACCENT);
        b.setForeground(WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setOpaque(true);
        frame.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = txt_username.getText();
                String enteredPassword = new String(value.getPassword());
                if (credentials.containsKey(enteredUsername) && credentials.get(enteredUsername).equals(enteredPassword)) {
                    frame.dispose();
                    new HomeScreen();
                } else {
                    JOptionPane.showMessageDialog(frame, 
                        "<html><b style='color:#e74c3c'>Invalid username or password!</b><br>Please try again.</html>",
                        "Login Failed", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // "Don't have an account?" clickable link
        JLabel lblNoAccount = new JLabel("<html><u style='color:#2980b9;'>Don't have an account? Request credentials from Admin</u></html>");
        lblNoAccount.setBounds(230, 480, 390, 25);
        lblNoAccount.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblNoAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNoAccount.setForeground(new Color(41, 128, 185));
        frame.add(lblNoAccount);

        lblNoAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openEmailRequestDialog();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 570);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void openEmailRequestDialog() {
        JDialog dialog = new JDialog(frame, "Request Credentials", true);
        dialog.getContentPane().setBackground(BG_LIGHT);
        dialog.setLayout(null);
        dialog.setSize(450, 380);
        dialog.setLocationRelativeTo(frame);

        JLabel title = new JLabel("Request Login Credentials", SwingConstants.CENTER);
        title.setBounds(20, 15, 410, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        title.setForeground(PRIMARY);
        dialog.add(title);

        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(40, 60, 120, 25);
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblName.setForeground(PRIMARY);
        dialog.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(160, 60, 240, 30);
        txtName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtName.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
        dialog.add(txtName);

        JLabel lblEmail = new JLabel("Your Email:");
        lblEmail.setBounds(40, 105, 120, 25);
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblEmail.setForeground(PRIMARY);
        dialog.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(160, 105, 240, 30);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtEmail.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
        dialog.add(txtEmail);

        JLabel lblRoll = new JLabel("Roll/ID No:");
        lblRoll.setBounds(40, 150, 120, 25);
        lblRoll.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblRoll.setForeground(PRIMARY);
        dialog.add(lblRoll);

        JTextField txtRoll = new JTextField();
        txtRoll.setBounds(160, 150, 240, 30);
        txtRoll.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtRoll.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
        dialog.add(txtRoll);

        JLabel lblCourse = new JLabel("Course/Program:");
        lblCourse.setBounds(40, 195, 120, 25);
        lblCourse.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblCourse.setForeground(PRIMARY);
        dialog.add(lblCourse);

        String[] courses = {"BCA", "MCA", "B.Tech CSE", "B.Tech IT", "B.Sc CS", "M.Sc CS", "Faculty", "Staff", "Other"};
        JComboBox<String> cmbCourse = new JComboBox<>(courses);
        cmbCourse.setBounds(160, 195, 240, 30);
        cmbCourse.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        dialog.add(cmbCourse);

        JLabel lblMsg = new JLabel("Message (optional):");
        lblMsg.setBounds(40, 240, 140, 25);
        lblMsg.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblMsg.setForeground(PRIMARY);
        dialog.add(lblMsg);

        JTextArea txtMsg = new JTextArea();
        txtMsg.setBounds(40, 268, 360, 50);
        txtMsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtMsg.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
        txtMsg.setLineWrap(true);
        txtMsg.setWrapStyleWord(true);
        dialog.add(txtMsg);

        JButton btnSend = new JButton("Send Request via Email");
        btnSend.setBounds(110, 325, 220, 35);
        btnSend.setBackground(ACCENT);
        btnSend.setForeground(WHITE);
        btnSend.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnSend.setFocusPainted(false);
        btnSend.setBorderPainted(false);
        btnSend.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSend.setOpaque(true);
        dialog.add(btnSend);

        btnSend.addActionListener(ev -> {
            String name = txtName.getText().trim();
            String email = txtEmail.getText().trim();
            String roll = txtRoll.getText().trim();
            String program = (String) cmbCourse.getSelectedItem();
            String msg = txtMsg.getText().trim();

            if (name.isEmpty() || email.isEmpty() || roll.isEmpty()) {
                JOptionPane.showMessageDialog(dialog,
                    "<html><b style='color:#e74c3c'>Please fill in Name, Email, and Roll/ID No.</b></html>",
                    "Required Fields", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(dialog,
                    "<html><b style='color:#e74c3c'>Please enter a valid email address.</b></html>",
                    "Invalid Email", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                String subject = "Attendance System - New Credentials Request from " + name;
                String body = "Hello Admin,%0D%0A%0D%0A"
                    + "I would like to request login credentials for the Attendance Management System.%0D%0A%0D%0A"
                    + "--- Request Details ---%0D%0A"
                    + "Full Name: " + name + "%0D%0A"
                    + "Email: " + email + "%0D%0A"
                    + "Roll/ID No: " + roll + "%0D%0A"
                    + "Course/Program: " + program + "%0D%0A";
                if (!msg.isEmpty()) {
                    body += "Message: " + java.net.URLEncoder.encode(msg, "UTF-8") + "%0D%0A";
                }
                body += "%0D%0A---%0D%0AThis request was sent from the Attendance Management System.";

                String mailto = "mailto:admin@attendance-system.com"
                    + "?subject=" + subject.replace(" ", "%20")
                    + "&body=" + body;
                Desktop.getDesktop().mail(new java.net.URI(mailto));

                JOptionPane.showMessageDialog(dialog,
                    "<html><b style='color:#27ae60'>Request submitted successfully!</b><br>"
                    + "Your default email client has been opened with a pre-composed message.<br>"
                    + "<b>Admin Email:</b> admin@attendance-system.com<br>"
                    + "The admin will review your request and send your credentials to <b>" + email + "</b>.</html>",
                    "Request Sent", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog,
                    "<html><b style='color:#e74c3c'>Could not open email client.</b><br>"
                    + "Please manually email: <b>admin@attendance-system.com</b><br>"
                    + "with your Name, Roll No, and Program details.</html>",
                    "Email Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }
}

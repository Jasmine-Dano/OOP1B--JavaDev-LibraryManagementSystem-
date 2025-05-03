import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Arrays;
import javax.swing.GroupLayout;
import javax.swing.JPanel;


public class Login extends javax.swing.JFrame {

     public Login() {
        initComponents();
          RoundedPanel roundedPanel = new RoundedPanel();
    roundedPanel.setBackground(new Color(24, 43, 92)); // Set the same background color
    roundedPanel.setBounds(jPanel2.getBounds()); // Copy size and position of jPanel2
    GroupLayout newLayout = new GroupLayout(roundedPanel); // Create a new layout
    roundedPanel.setLayout(newLayout); // Apply new layout

    // Move all components from jPanel2 to roundedPanel
    while (jPanel2.getComponentCount() > 0) {
        roundedPanel.add(jPanel2.getComponent(0));
    }

    // Replace jPanel2 in its parent container
    Login.remove(jPanel2);
    Login.add(roundedPanel);
    jPanel2 = roundedPanel; // Update reference
        
        try {
            Connection();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //Connection Method
    Connection con;
    //SQL Statement
    Statement st;
    //Prepared Statement
    PreparedStatement pst;
    
    // Required for connections
    //DbName, Driver, Url, Username, Password
    private static final String DbName = "library";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/library";
    private static final String DbUsername = "root";
    private static final String DbPassword = "";
  
    // Create a method for connection
    public final void Connection() throws SQLException {
        try {
            con = DriverManager.getConnection(DbUrl, DbUsername, DbPassword);
            st = con.createStatement();
            if (con != null) {
                System.out.println("Connection successful");
            }
            Class.forName(DbDriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class RoundedPanel extends JPanel {
    private int arcWidth = 50;  // Width of the arc for rounded corners
    private int arcHeight = 50; // Height of the arc for rounded corners

    public RoundedPanel() {
        super();
        setOpaque(false); // Make the panel transparent for rounded edges
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
    }

    // Optional: Allow customization of corner arc dimensions
    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
        repaint();
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
        repaint();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtLogUsername = new javax.swing.JTextField();
        LoginBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Register = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLogPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setMaximumSize(new java.awt.Dimension(800, 500));
        Login.setMinimumSize(new java.awt.Dimension(800, 500));
        Login.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(24, 43, 92));
        jPanel2.setForeground(new java.awt.Color(24, 43, 92));

        txtLogUsername.addFocusListener(new java.awt.event.FocusAdapter(){
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtLogUsername.getText().equals("Username")){
                    txtLogUsername.setText("");
                    txtLogUsername.setForeground(new java.awt.Color(0, 0, 0));
                }

            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtLogUsername.getText().isEmpty()){
                    txtLogUsername.setText("Username");
                    txtLogUsername.setForeground(new java.awt.Color(187, 187, 187));
                }
            }
        });
        txtLogUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogUsernameActionPerformed(evt);
            }
        });
        txtLogUsername.setPreferredSize(new java.awt.Dimension(35, 20));
        txtLogUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogUsernameActionPerformed(evt);
            }
        });

        LoginBtn.setBackground(new java.awt.Color(217, 215, 251));
        LoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Do you have an account?");

        Register.setBackground(new java.awt.Color(255, 255, 255));
        Register.setForeground(new java.awt.Color(0, 204, 0));
        Register.setText("Register");
        Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sign In");

        txtLogPassword.setPreferredSize(new java.awt.Dimension(35, 20));
        txtLogPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(LoginBtn)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(162, 162, 162))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel5)
                .addGap(57, 57, 57)
                .addComponent(txtLogUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(txtLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(LoginBtn)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Register))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo1.png"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(200, 100));
        jLabel6.setMinimumSize(new java.awt.Dimension(200, 100));
        jLabel6.setPreferredSize(new java.awt.Dimension(619, 619));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Connecting readers with books through  seamless lending reservation "); // NOI18N
        jLabel7.setIconTextGap(1);

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
        
        
      

    
    
    private void txtLogUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogUsernameActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
                                                                                                                                                                                                                
                     try {
    // 1. Get user inputs
    String username = txtLogUsername.getText().trim();
    char[] passwordChars = txtLogPassword.getPassword();
    String password = new String(passwordChars);
    Arrays.fill(passwordChars, ' '); // Clear password from memory

    // 2. Validate inputs
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter both username and password");
        return;
    }

    // 3. Connect to database
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
         PreparedStatement stmt = con.prepareStatement(
             "SELECT Role FROM accountdetails WHERE BINARY Username=? AND BINARY Password=?")) {
        
        // 4. Set parameters
        stmt.setString(1, username);
        stmt.setString(2, password);

        // 5. Execute query
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String role = rs.getString("Role");
                
                // 6. Show welcome message
                JOptionPane.showMessageDialog(this, "Welcome " + username + "!");
                
                // 7. Open appropriate dashboard
                this.dispose(); // Close login window first
                
                if ("Librarian".equalsIgnoreCase(role)) {
                    Dashboard dashboard = new Dashboard(username);
                    dashboard.setVisible(true);
                } else if ("Borrower".equalsIgnoreCase(role)) {
                    Userdashboardss userDash = new Userdashboardss(username);
                    userDash.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        }
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, 
        "Database error: " + ex.getMessage() + 
        "\nPlease check your connection and try again.");
    ex.printStackTrace();
} catch (Exception ex) {
    JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage());
    ex.printStackTrace();
}
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterMouseClicked
        // TODO add your handling code here:
        Registration registration = new Registration();
        registration.setVisible(true);
        registration.pack();
        registration.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_RegisterMouseClicked

    private void txtLogPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogPasswordActionPerformed

    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel Register;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtLogPassword;
    private javax.swing.JTextField txtLogUsername;
    // End of variables declaration//GEN-END:variables
}




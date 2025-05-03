import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;




public class Registration extends javax.swing.JFrame {

    public Registration() {
        initComponents();
     
         try {
            Connection(); // Call
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }    
}
    //Connection Method
    Connection con;
    //SQL Statement
    Statement st;
   
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

        Registration = new javax.swing.JPanel();
        bluePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLogUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        registerbtn = new javax.swing.JButton();
        txtLogPassword = new javax.swing.JPasswordField();
        Signin = new javax.swing.JLabel();
        txtfirstName = new javax.swing.JTextField();
        txtlastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Registration.setBackground(new java.awt.Color(255, 255, 255));
        Registration.setForeground(new java.awt.Color(255, 255, 255));
        Registration.setMaximumSize(new java.awt.Dimension(1280, 720));
        Registration.setMinimumSize(new java.awt.Dimension(1280, 720));
        Registration.setPreferredSize(new java.awt.Dimension(1280, 720));

        bluePanel.setBackground(new java.awt.Color(24, 43, 92));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Get Started");

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
        txtLogUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLogUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogUsernameActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Already have an account?");

        registerbtn.setBackground(new java.awt.Color(204, 204, 204));
        registerbtn.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        registerbtn.setText("Register");
        registerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbtnActionPerformed(evt);
            }
        });

        txtLogPassword = new javax.swing.JPasswordField();

        // Code adding the component to the parent container - not shown here
        txtLogPassword.addFocusListener(new java.awt.event.FocusAdapter(){
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtLogPassword.getText().equals("Password")){
                    txtLogPassword.setText("");
                    txtLogPassword.setForeground(new java.awt.Color(0, 0, 0));
                }

            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtLogPassword.getText().isEmpty()){
                    txtLogPassword.setText("Password");
                    txtLogPassword.setForeground(new java.awt.Color(187, 187, 187));
                }
            }
        });
        txtLogPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLogPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogPasswordActionPerformed(evt);
            }
        });

        Signin.setForeground(new java.awt.Color(0, 153, 0));
        Signin.setText("Sign in");
        Signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SigninMouseClicked(evt);
            }
        });

        txtLogUsername.addFocusListener(new java.awt.event.FocusAdapter(){
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtLogUsername.getText().equals("First Name")){
                    txtLogUsername.setText("");
                    txtLogUsername.setForeground(new java.awt.Color(0, 0, 0));
                }

            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtLogUsername.getText().isEmpty()){
                    txtLogUsername.setText("First Name");
                    txtLogUsername.setForeground(new java.awt.Color(187, 187, 187));
                }
            }
        });
        txtLogUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogUsernameActionPerformed(evt);
            }
        });
        txtfirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtfirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfirstNameActionPerformed(evt);
            }
        });

        txtLogUsername.addFocusListener(new java.awt.event.FocusAdapter(){
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtLogUsername.getText().equals("Last Name")){
                    txtLogUsername.setText("");
                    txtLogUsername.setForeground(new java.awt.Color(0, 0, 0));
                }

            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtLogUsername.getText().isEmpty()){
                    txtLogUsername.setText("Last Name");
                    txtLogUsername.setForeground(new java.awt.Color(187, 187, 187));
                }
            }
        });
        txtLogUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogUsernameActionPerformed(evt);
            }
        });
        txtlastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtlastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlastNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bluePanelLayout = new javax.swing.GroupLayout(bluePanel);
        bluePanel.setLayout(bluePanelLayout);
        bluePanelLayout.setHorizontalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bluePanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bluePanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Signin)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bluePanelLayout.createSequentialGroup()
                        .addGroup(bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLogUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 66, Short.MAX_VALUE))))
            .addGroup(bluePanelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bluePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        bluePanelLayout.setVerticalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bluePanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Signin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(txtfirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLogUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(registerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo1.png"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(200, 100));
        jLabel5.setMinimumSize(new java.awt.Dimension(200, 100));
        jLabel5.setPreferredSize(new java.awt.Dimension(619, 619));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Connecting readers with books through  seamless lending reservation "); // NOI18N
        jLabel6.setIconTextGap(1);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout RegistrationLayout = new javax.swing.GroupLayout(Registration);
        Registration.setLayout(RegistrationLayout);
        RegistrationLayout.setHorizontalGroup(
            RegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrationLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(RegistrationLayout.createSequentialGroup()
                .addGroup(RegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrationLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrationLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        RegistrationLayout.setVerticalGroup(
            RegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrationLayout.createSequentialGroup()
                .addGroup(RegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrationLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrationLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Registration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Registration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtlastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlastNameActionPerformed

    private void SigninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigninMouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_SigninMouseClicked

    private void txtLogPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogPasswordActionPerformed

    private void registerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbtnActionPerformed

        String firstName, lastName, username, password;

        try {
            // Input Validation
            if (txtfirstName.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Required First Name");
                return;
            }
            if (txtlastName.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Required Last Name");
                return;
            }
            if (txtLogUsername.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Required Username");
                return;
            }
            if (txtLogPassword.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Required Password");
                return;
            }

            // Get data from fields
            firstName = txtfirstName.getText().trim();
            lastName = txtlastName.getText().trim();
            username = txtLogUsername.getText().trim();
            password = txtLogPassword.getText().trim();

            // SQL insert query
            String queryRegister = "INSERT INTO accountdetails (`First Name`, `Last Name`, `Username`, `Password`) VALUES (?, ?, ?, ?)";

            // Database connection (assuming you have a `con` object already)
            try (PreparedStatement pst = con.prepareStatement(queryRegister)) {
                pst.setString(1, firstName);
                pst.setString(2, lastName);
                pst.setString(3, username);
                pst.setString(4, password);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data added successfully!");

                // Clear input fields
                txtfirstName.setText("");
                txtlastName.setText("");
                txtLogUsername.setText("");
                txtLogPassword.setText("");

            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage());
        }

    }//GEN-LAST:event_registerbtnActionPerformed

    private void txtLogUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogUsernameActionPerformed

    private void txtfirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfirstNameActionPerformed

    public void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
            new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Registration;
    private javax.swing.JLabel Signin;
    private javax.swing.JPanel bluePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton registerbtn;
    private javax.swing.JPasswordField txtLogPassword;
    private javax.swing.JTextField txtLogUsername;
    private javax.swing.JTextField txtfirstName;
    private javax.swing.JTextField txtlastName;
    // End of variables declaration//GEN-END:variables

  
}

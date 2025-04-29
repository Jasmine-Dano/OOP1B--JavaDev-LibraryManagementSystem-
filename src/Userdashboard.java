import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;




public class Userdashboard extends javax.swing.JFrame {

    
    public Userdashboard(String txtLogPassword) {
        initComponents();
        loadData2();
        try {
            Connection(); // Call
        } catch (SQLException ex) {
            Logger.getLogger(Userdashboard.class.getName()).log(Level.SEVERE, null, ex);
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
            con = (Connection) DriverManager.getConnection(DbUrl, DbUsername, DbPassword);
            st = con.createStatement();
            if (con != null) {
                System.out.println("Connection successful");
            }
            Class.forName(DbDriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
public void loadData2() {
    DefaultTableModel model = (DefaultTableModel) Table2.getModel();
    model.setRowCount(0); // Clear existing rows

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM managebooks")) {

        while (rs.next()) {
            int id = rs.getInt("ID");
            String title = rs.getString("Book Title");
            String author = rs.getString("Author");
            String date = rs.getString("Date Publish");
            String type = rs.getString("Collection Type");

            model.addRow(new Object[]{id, title, author, date, type});
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        roundcapsule = new javax.swing.JPanel();
        Dashboardd = new javax.swing.JLabel();
        Settings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Searchdata2 = new javax.swing.JTextField();
        searchBtn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BookTitle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        DatePublish = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Author = new javax.swing.JTextField();
        collectiontypeComboBox2 = new javax.swing.JComboBox<>();
        CollectionType = new javax.swing.JTextField();
        BorrowBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        roundcapsule.setBackground(new java.awt.Color(255, 255, 255));
        roundcapsule.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roundcapsule.setAutoscrolls(true);

        Dashboardd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard (3).png"))); // NOI18N
        Dashboardd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboarddMouseClicked(evt);
            }
        });

        Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        Settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SettingsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundcapsuleLayout = new javax.swing.GroupLayout(roundcapsule);
        roundcapsule.setLayout(roundcapsuleLayout);
        roundcapsuleLayout.setHorizontalGroup(
            roundcapsuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundcapsuleLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundcapsuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Settings)
                    .addComponent(Dashboardd))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        roundcapsuleLayout.setVerticalGroup(
            roundcapsuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundcapsuleLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Dashboardd)
                .addGap(40, 40, 40)
                .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 43, 92));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel1.setText("Book Bridge");

        Searchdata2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Searchdata2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Searchdata2ActionPerformed(evt);
            }
        });

        searchBtn1.setBackground(new java.awt.Color(24, 43, 92));
        searchBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBtn1.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn1.setText("Find");
        searchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 43, 92));
        jLabel2.setText("Dashboard");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 43, 92));
        jLabel3.setText("All Books");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 43, 92));
        jLabel4.setText("Open Request");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Book Title:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Date Publish:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Author:");

        collectiontypeComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        collectiontypeComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiction", "Non-Fiction" }));

        collectiontypeComboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) collectiontypeComboBox2.getSelectedItem();
                CollectionType.setText(selected);
            }
        });

        BorrowBtn.setBackground(new java.awt.Color(24, 43, 92));
        BorrowBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BorrowBtn.setForeground(new java.awt.Color(255, 255, 255));
        BorrowBtn.setText("Borrow");
        BorrowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowBtnActionPerformed(evt);
            }
        });

        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Book Title", "Author", "Date Publish", "Collection"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table2);
        if (Table2.getColumnModel().getColumnCount() > 0) {
            Table2.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(roundcapsule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel12))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(152, 152, 152)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(collectiontypeComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(CollectionType, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(64, 64, 64)
                                        .addComponent(DatePublish, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(92, 92, 92)
                                .addComponent(BorrowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Searchdata2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(searchBtn1)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Searchdata2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn1)
                            .addComponent(jLabel2))))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(DatePublish, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(collectiontypeComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CollectionType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(roundcapsule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(BorrowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(378, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Searchdata2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Searchdata2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Searchdata2ActionPerformed

    private void searchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn1ActionPerformed
        // TODO add your handling code here:
     String ID;

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/library"; // Fixed 'MySQL' to 'mysql'
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    ID = Searchdata2.getText().trim();

    if (ID.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "ID is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        con.close();
        return;
    }
    
    int userID;
    try {
        userID = Integer.parseInt(ID); // Validate numeric ID
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID format!", "Format Error", JOptionPane.ERROR_MESSAGE);
        con.close();
        return;
    }

    // Use PreparedStatement to safely query the database
    String sql = "SELECT * FROM managebooks WHERE id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, userID);
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        // Populate fields
        BookTitle.setText(rs.getString("Book Title"));
        Author.setText(rs.getString("Author"));
        DatePublish.setText(rs.getString("Date Publish"));
        CollectionType.setText(rs.getString("Collection Type"));
        
    } else {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID", "Not Found", JOptionPane.ERROR_MESSAGE);
    }
    // Close resources
    rs.close();
    pst.close();
    con.close();

} catch (HeadlessException | ClassNotFoundException | SQLException e) {
    System.out.println("Error: " + e.getMessage());
}

    }//GEN-LAST:event_searchBtn1ActionPerformed

    private void BorrowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowBtnActionPerformed
        // TODO add your handling code here:                                         
    int selectedRow = Table2.getSelectedRow(); // Replace with your JTable variable name

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to borrow.");
        return;
    }

    try {
        // Get selected book data from the table
        String title = Table2.getValueAt(selectedRow, 1).toString();       // Title
        String Username = null;
        String username = Username; // You'll need to pass/store the logged-in username
        String status = "Pending"; // or "Requested"
        String condition = Table2.getValueAt(selectedRow, 6).toString();   // Condition

        // Connect to DB
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

        // Insert borrow request into your table
        String sql = "INSERT INTO borrowrequests (title, username, status, book_condition) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, title);
        pst.setString(2, username);
        pst.setString(3, status);
        pst.setString(4, condition);

        int rows = pst.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Borrow request submitted!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to submit request.");
        }

        pst.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_BorrowBtnActionPerformed

    private void SettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingsMouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to log out?",
        "Confirm Logout",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    // If user clicks "Yes"
    if (response == JOptionPane.YES_OPTION) {
        Registration registration = new Registration();
        registration.setVisible(true);
        registration.pack();
        registration.setLocationRelativeTo(null);
        this.dispose(); // Close current window
    }
    }//GEN-LAST:event_SettingsMouseClicked

    private void DashboarddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboarddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboarddMouseClicked

    
    /*
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            String password = "yourPasswordHere"; // Replace with actual password logic or test string
            new Userdashboard(password).setVisible(true);
        }
    });
}
*/
    
    
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String password = "";
                new Userdashboard(password).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Author;
    private javax.swing.JTextField BookTitle;
    private javax.swing.JButton BorrowBtn;
    private javax.swing.JTextField CollectionType;
    private javax.swing.JLabel Dashboardd;
    private javax.swing.JTextField DatePublish;
    private javax.swing.JTextField Searchdata2;
    private javax.swing.JLabel Settings;
    private javax.swing.JTable Table2;
    private javax.swing.JComboBox<String> collectiontypeComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel roundcapsule;
    private javax.swing.JButton searchBtn1;
    // End of variables declaration//GEN-END:variables
}

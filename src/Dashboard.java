import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Dashboard extends javax.swing.JFrame {

    public Dashboard(JTextField txtLogUsername) {
        initComponents();
        displayTotalBooks();
        displayBorrowedBooks();
        displayDamagedBooks();
        loadData();
     
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

  
    
    // Change constructor to accept just the username string
public Dashboard(String username) {
    initComponents(); // Initialize GUI components
    
    // Set window title
    setTitle("Librarian Dashboard - " + username);
    
    
    // Load user-specific data
    loadLibrarianData(username);
    
    // Center window
    setLocationRelativeTo(null);
}

private void loadLibrarianData(String username) {
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        String sql = "SELECT * FROM accountdetails WHERE username = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            // Populate librarian-specific data
            String Username = rs.getString("Username");
 
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
    }
}



// TOTAL BOOKS
 public void displayTotalBooks() {
        int total = getTotalBooks();
        totalbooks.setText("Total Books: \n" + total);
    }
 public int getTotalBooks() {
        int total = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

            String query = "SELECT COUNT(*) FROM managebooks";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                total = rs.getInt(1);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        return total;
    }
 
 
 // BORROWED BOOKS
 public void displayBorrowedBooks() {
        int total = getBorrowedBooks();
        borrowedbooks.setText("Borrowed Books: \n" + total);
    }
 public int getBorrowedBooks() {
        int total = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

            String query = "SELECT COUNT(*) FROM trackborrowedbooks WHERE Status = 'Borrowed'";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                total = rs.getInt(1);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        return total;
    }
 
// DAMAGED BOOKS
 public void displayDamagedBooks() {
        int total = getDamagedBooks();
        damagedbooks.setText("Damaged Books: \n" + total);
    }
 public int getDamagedBooks() {
        int total = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

            String query = "SELECT COUNT(*) FROM trackborrowedbooks WHERE `Condition` = 'Damaged'";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                total = rs.getInt(1);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        return total;
    }
 

 
 
 
 
 
private void loadData() {
    // Clear existing table data
    DefaultTableModel model = (DefaultTableModel) pendingrequest3.getModel();
    model.setRowCount(0);

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT `Book Title`, `Borrower Name`, `Email`, `Status` FROM pendingrequest")) {
        
        // Populate table with database records
        while (rs.next()) {
            String bookTitle = rs.getString("Book Title");
            String borrowerName = rs.getString("Borrower Name");
            String email = rs.getString("Email");
            String status = rs.getString("Status");
            
            model.addRow(new Object[]{bookTitle, borrowerName, email, status});
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, 
            "Error loading pending requests: " + ex.getMessage(), 
            "Database Error", 
            JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}


    

    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Managebooks1 = new javax.swing.JButton();
        Bookissuerequest = new javax.swing.JButton();
        Manageusersss = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        totalbooks = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        borrowedbooks = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        damagedbooks = new javax.swing.JLabel();
        pendingrequest = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingrequest2 = new javax.swing.JScrollPane();
        pendingrequest3 = new javax.swing.JTable();

        jPanel6.setBackground(new java.awt.Color(24, 43, 92));

        jPanel7.setBackground(new java.awt.Color(24, 43, 92));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel8.setBackground(new java.awt.Color(24, 43, 92));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 43, 92));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel1.setText("Book Bridge");

        Dashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard (3).png"))); // NOI18N
        Dashboard.setText("Dashboard");
        Dashboard.setBorderPainted(false);
        Dashboard.setContentAreaFilled(false);
        Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardActionPerformed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        Logout.setText("Log Out");
        Logout.setBorderPainted(false);
        Logout.setContentAreaFilled(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 43, 92));
        jLabel2.setText("Dashboard");

        jButton7.setBackground(new java.awt.Color(24, 43, 92));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Search");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Conditions");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Recent Request");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/image.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setPreferredSize(new java.awt.Dimension(37, 47));

        Managebooks1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Managebooks1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/briefcase (2).png"))); // NOI18N
        Managebooks1.setText("Manage Books");
        Managebooks1.setBorderPainted(false);
        Managebooks1.setContentAreaFilled(false);
        Managebooks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Managebooks1ActionPerformed(evt);
            }
        });

        Bookissuerequest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Bookissuerequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookissue.png"))); // NOI18N
        Bookissuerequest.setText("Book Issue Request");
        Bookissuerequest.setBorderPainted(false);
        Bookissuerequest.setContentAreaFilled(false);
        Bookissuerequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookissuerequestActionPerformed(evt);
            }
        });

        Manageusersss.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Manageusersss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage users.png"))); // NOI18N
        Manageusersss.setText("Manage Users");
        Manageusersss.setBorderPainted(false);
        Manageusersss.setContentAreaFilled(false);
        Manageusersss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageusersssActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(65, 103, 202));

        totalbooks.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalbooks.setText("Total Books");
        totalbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalbooksMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(totalbooks)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(totalbooks)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(229, 222, 15));

        borrowedbooks.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        borrowedbooks.setText("Borrowed Books");
        borrowedbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowedbooksMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(borrowedbooks)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(borrowedbooks)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 120, 10));

        damagedbooks.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        damagedbooks.setText("Damaged Books");
        damagedbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                damagedbooksMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(damagedbooks)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(damagedbooks)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pendingrequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book Title", "Borrower Name", "Email", "Request"
            }
        ));

        pendingrequest3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book Title", "Borrower Name", "Email", "Request"
            }
        ));
        pendingrequest2.setViewportView(pendingrequest3);

        jScrollPane1.setViewportView(pendingrequest2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Dashboard)
                            .addComponent(jLabel1)
                            .addComponent(Managebooks1))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Manageusersss)
                            .addComponent(Bookissuerequest)
                            .addComponent(Logout))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jButton7))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(437, Short.MAX_VALUE)
                    .addComponent(pendingrequest, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(294, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(Dashboard)
                        .addGap(20, 20, 20)
                        .addComponent(Managebooks1)
                        .addGap(20, 20, 20)
                        .addComponent(Bookissuerequest)
                        .addGap(20, 20, 20)
                        .addComponent(Manageusersss)
                        .addGap(20, 20, 20)
                        .addComponent(Logout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(400, Short.MAX_VALUE)
                    .addComponent(pendingrequest, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(320, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        JTextField txtLogUsername = null;
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard(txtLogUsername);
        dashboard.setVisible(true);
        dashboard.pack();
        dashboard.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_DashboardActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        Registration registration = new Registration();
       registration.setVisible(true);
       registration.pack();
       registration.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void Managebooks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Managebooks1ActionPerformed
        // TODO add your handling code here:
        Managebooks managebooks = new Managebooks();
        managebooks.setVisible(true);
        managebooks.pack();
        managebooks.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Managebooks1ActionPerformed

    private void BookissuerequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookissuerequestActionPerformed
        // TODO add your handling code here:
        Bookissuerequest bookissuerequest = new Bookissuerequest();
        bookissuerequest.setVisible(true);
        bookissuerequest.pack();
        bookissuerequest.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BookissuerequestActionPerformed

    private void ManageusersssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageusersssActionPerformed
        // TODO add your handling code here:
    Manageusersss manageusersss = new Manageusersss();
        manageusersss.setVisible(true);
        manageusersss.pack();
        manageusersss.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ManageusersssActionPerformed

    private void totalbooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalbooksMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_totalbooksMouseClicked

    private void borrowedbooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowedbooksMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_borrowedbooksMouseClicked

    private void damagedbooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_damagedbooksMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_damagedbooksMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JTextField txtLogUsername = null;
                new Dashboard(txtLogUsername).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bookissuerequest;
    private javax.swing.JButton Dashboard;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Managebooks1;
    private javax.swing.JButton Manageusersss;
    private javax.swing.JTextField Search;
    private javax.swing.JLabel borrowedbooks;
    private javax.swing.JLabel damagedbooks;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pendingrequest;
    private javax.swing.JScrollPane pendingrequest2;
    private javax.swing.JTable pendingrequest3;
    private javax.swing.JLabel totalbooks;
    // End of variables declaration//GEN-END:variables
}

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




public class Userdashboardss extends javax.swing.JFrame {

    
    public Userdashboardss(String txtLogPassword) {
        initComponents();
        loadData2();
        loadData();
        
        try {
            Connection(); // Call
        } catch (SQLException ex) {
            Logger.getLogger(Userdashboardss.class.getName()).log(Level.SEVERE, null, ex);
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

private void loadData() {
    // Clear existing table data
    DefaultTableModel model = (DefaultTableModel) pendingrequest5.getModel();
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

        collectiontypeComboBox2 = new javax.swing.JComboBox<>();
        DeleteRequest1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Searchdata2 = new javax.swing.JTextField();
        searchBtn1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        BookTitle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        DatePublish = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Author = new javax.swing.JTextField();
        CollectionType = new javax.swing.JTextField();
        BorrowBtn = new javax.swing.JButton();
        BorrowerName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Settings = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pendingrequest4 = new javax.swing.JScrollPane();
        pendingrequest5 = new javax.swing.JTable();
        DeleteRequest2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();

        collectiontypeComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        collectiontypeComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiction", "Non-Fiction" }));

        DeleteRequest1.setBackground(new java.awt.Color(24, 43, 92));
        DeleteRequest1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteRequest1.setForeground(new java.awt.Color(255, 255, 255));
        DeleteRequest1.setText("Delete Request");
        DeleteRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRequest1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 43, 92));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel1.setText("Book Bridge");

        Searchdata2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Searchdata2.setForeground(new java.awt.Color(187, 187, 187)); // Light gray
        Searchdata2.setText("Search Book Title or Author...");

        Searchdata2.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Searchdata2.getText().equals("Search Book Title or Author...")) {
                    Searchdata2.setText("");
                    Searchdata2.setForeground(new java.awt.Color(0, 0, 0)); // Black text when typing
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Searchdata2.getText().isEmpty()) {
                    Searchdata2.setText("Search Book Title or Author...");
                    Searchdata2.setForeground(new java.awt.Color(187, 187, 187)); // Light gray again
                }
            }
        });
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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Book Title:");

        BookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookTitleActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Collection Type:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Author:");

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

        BorrowerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowerNameActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Complete Name:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Date Publish:");

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Email:");

        Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        Settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SettingsMouseClicked(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        pendingrequest5.setModel(new javax.swing.table.DefaultTableModel(
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
        pendingrequest4.setViewportView(pendingrequest5);

        jScrollPane2.setViewportView(pendingrequest4);

        DeleteRequest2.setBackground(new java.awt.Color(24, 43, 92));
        DeleteRequest2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteRequest2.setForeground(new java.awt.Color(255, 255, 255));
        DeleteRequest2.setText("Cancel Request");
        DeleteRequest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRequest2ActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

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

        jScrollPane4.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(175, 175, 175)
                .addComponent(Searchdata2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(searchBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Settings)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BorrowBtn)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BorrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel4))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DatePublish, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CollectionType, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteRequest2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Searchdata2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(BorrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(DatePublish, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(CollectionType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(BorrowBtn)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Searchdata2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Searchdata2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Searchdata2ActionPerformed

    private void searchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn1ActionPerformed
        // TODO add your handling code here:
    String searchValue = Searchdata2.getText().trim(); // Get the search value from the text field

if (searchValue.isEmpty()) {
    JOptionPane.showMessageDialog(new JFrame(), "Search value is required", "Input Error", JOptionPane.ERROR_MESSAGE);
    return;
}

Connection con = null;
PreparedStatement pst = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";

    con = DriverManager.getConnection(url, user, pass);

    // Use PreparedStatement to safely query the database
    String sql = "SELECT * FROM managebooks WHERE id = ? OR `Book Title` LIKE ? OR Author LIKE ? OR `Date Publish` LIKE ? OR `Collection Type` LIKE ?";
    pst = con.prepareStatement(sql);

    // Set parameters for all fields
    try {
        pst.setInt(1, Integer.parseInt(searchValue)); // Try to treat input as an ID
    } catch (NumberFormatException e) {
        pst.setNull(1, java.sql.Types.INTEGER); // If input is not numeric, set ID parameter to null
    }
    pst.setString(2, "%" + searchValue + "%"); // Search by Book Title
    pst.setString(3, "%" + searchValue + "%"); // Search by Author
    pst.setString(4, "%" + searchValue + "%"); // Search by Date Publish
    pst.setString(5, "%" + searchValue + "%"); // Search by Collection Type

    rs = pst.executeQuery();

    if (rs.next()) {
        // Populate fields with book details
        BookTitle.setText(rs.getString("Book Title"));
        Author.setText(rs.getString("Author"));
        DatePublish.setText(rs.getString("Date Publish"));
        CollectionType.setText(rs.getString("Collection Type"));
    } else {
        JOptionPane.showMessageDialog(new JFrame(), "No book found with the provided search value", "Not Found", JOptionPane.ERROR_MESSAGE);
    }
} catch (SQLException | ClassNotFoundException e) {
    JOptionPane.showMessageDialog(new JFrame(), "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} finally {
    // Close resources
    try {
        if (rs != null) rs.close();
        if (pst != null) pst.close();
        if (con != null) con.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(new JFrame(), "Error closing resources: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    }//GEN-LAST:event_searchBtn1ActionPerformed

    private void BorrowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowBtnActionPerformed
                                                                                 
   try {
    // 1. Get the input values
    String bookTitle = BookTitle.getText().trim();
    String borrowerName = BorrowerName.getText().trim();
    String email = Email.getText().trim(); // Added email field
    
    // 2. Validate inputs
    if (bookTitle.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Book title is required", 
            "Input Required", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (borrowerName.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Borrower's complete name is required", 
            "Input Required", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (email.isEmpty() || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        JOptionPane.showMessageDialog(this, 
            "Valid email address is required", 
            "Input Required", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // 3. Establish database connection
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
         PreparedStatement pst = con.prepareStatement(
             "INSERT INTO pendingrequest (`Book Title`, `Borrower Name`, `Email`, `Status`) VALUES (?, ?, ?, ?)")) {
        
        // 4. Set parameters (now includes email)
        pst.setString(1, bookTitle);
        pst.setString(2, borrowerName);
        pst.setString(3, email); // Added email parameter
        pst.setString(4, "Pending");
        
        // 5. Execute the insert
        int rowsAffected = pst.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, 
                "Borrow request submitted successfully!\n\n" +
                "Book: " + bookTitle + "\n" +
                "Borrower: " + borrowerName + "\n" +
                "Email: " + email, // Added email to success message
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // Clear the input fields
            BookTitle.setText("");
            BorrowerName.setText("");
            Email.setText(""); // Clear email field
         
        } else {
            JOptionPane.showMessageDialog(this, 
                "Failed to submit borrow request", 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, 
        "Database error: " + ex.getMessage(), 
        "System Error", 
        JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace();
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

    private void BookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookTitleActionPerformed

    private void BorrowerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BorrowerNameActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void DeleteRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequest1ActionPerformed
        // TODO add your handling code here:
        // 1. Get selected row from the table
        int selectedRow = pendingrequest5.getSelectedRow();

        // 2. Check if a row is actually selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                this,
                "Please select a request to delete",
                "No Selection",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 3. Get the request details from selected row
        String bookTitle = pendingrequest5.getValueAt(selectedRow, 0).toString();
        String borrowerName = pendingrequest5.getValueAt(selectedRow, 1).toString();
        String borrowerEmail = pendingrequest5.getValueAt(selectedRow, 2).toString();

        // 4. Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this request?\n\n" +
            "Book: " + bookTitle + "\n" +
            "Borrower: " + borrowerName + "\n" +
            "Email: " + borrowerEmail,
            "Confirm Deletion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return; // User cancelled the deletion
        }

        // 5. Delete from database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            PreparedStatement pst = con.prepareStatement(
                "DELETE FROM pendingrequest WHERE `Book Title` = ? AND `Borrower Name` = ? AND `Email` = ?")) {

            pst.setString(1, bookTitle);
            pst.setString(2, borrowerName);
            pst.setString(3, borrowerEmail);

            int rowsDeleted = pst.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Request deleted successfully!\n\n" +
                    "Book: " + bookTitle + "\n" +
                    "Borrower: " + borrowerName,
                    "Deletion Complete",
                    JOptionPane.INFORMATION_MESSAGE
                );

            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "No matching request found to delete",
                    "Deletion Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Database error while deleting:\n" + ex.getMessage(),
                "Deletion Error",
                JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
        }
    }//GEN-LAST:event_DeleteRequest1ActionPerformed

    private void DeleteRequest2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequest2ActionPerformed
        // TODO add your handling code here:
        // 1. Get selected row from the table
        int selectedRow = pendingrequest5.getSelectedRow();

        // 2. Check if a row is actually selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                this,
                "Please select a request to cancel",
                "No Selection",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 3. Get the request details from selected row
        String bookTitle = pendingrequest5.getValueAt(selectedRow, 0).toString();
        String borrowerName = pendingrequest5.getValueAt(selectedRow, 1).toString();
        String borrowerEmail = pendingrequest5.getValueAt(selectedRow, 2).toString();

        // 4. Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to cancel this request?\n\n" +
            "Book: " + bookTitle + "\n" +
            "Borrower: " + borrowerName + "\n" +
            "Email: " + borrowerEmail,
            "Confirm Cancellation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return; // User cancelled the deletion
        }

        // 5. Delete from database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            PreparedStatement pst = con.prepareStatement(
                "DELETE FROM pendingrequest WHERE `Book Title` = ? AND `Borrower Name` = ? AND `Email` = ?")) {

            pst.setString(1, bookTitle);
            pst.setString(2, borrowerName);
            pst.setString(3, borrowerEmail);

            int rowsDeleted = pst.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Request cancelled successfully!\n\n" +
                    "Book: " + bookTitle + "\n" +
                    "Borrower: " + borrowerName,
                    "Cancellation Complete",
                    JOptionPane.INFORMATION_MESSAGE
                );

            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "No matching request found to cancel",
                    "Cancellation Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Database error while canceling:\n" + ex.getMessage(),
                "Cancellation Error",
                JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
        }
    }//GEN-LAST:event_DeleteRequest2ActionPerformed

    
    
    
    
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String password = "";
                new Userdashboardss(password).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Author;
    private javax.swing.JTextField BookTitle;
    private javax.swing.JButton BorrowBtn;
    private javax.swing.JTextField BorrowerName;
    private javax.swing.JTextField CollectionType;
    private javax.swing.JTextField DatePublish;
    private javax.swing.JButton DeleteRequest1;
    private javax.swing.JButton DeleteRequest2;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Searchdata2;
    private javax.swing.JLabel Settings;
    private javax.swing.JTable Table2;
    private javax.swing.JComboBox<String> collectiontypeComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane pendingrequest4;
    private javax.swing.JTable pendingrequest5;
    private javax.swing.JButton searchBtn1;
    // End of variables declaration//GEN-END:variables
}

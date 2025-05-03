import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.PreparedStatement;

public class Bookissuerequest extends javax.swing.JFrame {

    public Bookissuerequest() {
        initComponents();
        loadData();
        
        
        try {
            Connection(); // Call
        } catch (SQLException ex) {
            Logger.getLogger(Bookissuerequest.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    
     //Connection Method
    Connection con;
    //SQL Statement
    java.sql.Statement st;
   
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
    
      
  private void loadData() {
    // Clear existing table data
    DefaultTableModel model = (DefaultTableModel) pendingrequest4.getModel();
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

        jLabel1 = new javax.swing.JLabel();
        BorrowBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JButton();
        Managebooks = new javax.swing.JButton();
        Bookissuerequest = new javax.swing.JButton();
        Manageusersss = new javax.swing.JButton();
        Settings = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        UpdateRequest = new javax.swing.JButton();
        DeleteRequest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingrequest2 = new javax.swing.JScrollPane();
        pendingrequest4 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 43, 92));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel1.setText("Book bridge");

        BorrowBtn.setBackground(new java.awt.Color(24, 43, 92));
        BorrowBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BorrowBtn.setForeground(new java.awt.Color(255, 255, 255));
        BorrowBtn.setText("Borrow");
        BorrowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowBtnActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel6.setBackground(new java.awt.Color(24, 43, 92));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 43, 92));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel2.setText("Book Bridge");

        Dashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard (3).png"))); // NOI18N
        Dashboard.setText("Dashboard");
        Dashboard.setBorderPainted(false);
        Dashboard.setContentAreaFilled(false);
        Dashboard.setPreferredSize(new java.awt.Dimension(180, 30));
        Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardActionPerformed(evt);
            }
        });

        Managebooks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Managebooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/briefcase (2).png"))); // NOI18N
        Managebooks.setText("Manage Books");
        Managebooks.setBorderPainted(false);
        Managebooks.setContentAreaFilled(false);
        Managebooks.setMaximumSize(new java.awt.Dimension(126, 32));
        Managebooks.setMinimumSize(new java.awt.Dimension(126, 32));
        Managebooks.setPreferredSize(new java.awt.Dimension(180, 30));
        Managebooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagebooksActionPerformed(evt);
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

        Settings.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        Settings.setText("Settings");
        Settings.setBorderPainted(false);
        Settings.setContentAreaFilled(false);
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 43, 92));
        jLabel3.setText("Book Issue Request");

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(24, 43, 92));
        jButton7.setText("Pending Request");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        UpdateRequest.setBackground(new java.awt.Color(24, 43, 92));
        UpdateRequest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UpdateRequest.setForeground(new java.awt.Color(255, 255, 255));
        UpdateRequest.setText("Update Request");
        UpdateRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateRequestActionPerformed(evt);
            }
        });

        DeleteRequest.setBackground(new java.awt.Color(24, 43, 92));
        DeleteRequest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteRequest.setForeground(new java.awt.Color(255, 255, 255));
        DeleteRequest.setText("Delete Request");
        DeleteRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRequestActionPerformed(evt);
            }
        });

        pendingrequest4.setModel(new javax.swing.table.DefaultTableModel(
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
        pendingrequest2.setViewportView(pendingrequest4);

        jScrollPane1.setViewportView(pendingrequest2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Bookissuerequest))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Managebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Settings)
                            .addComponent(Manageusersss))))
                .addGap(30, 30, 30)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UpdateRequest)
                        .addGap(56, 56, 56)
                        .addComponent(DeleteRequest)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton7))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(102, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(Managebooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(Bookissuerequest)
                        .addGap(20, 20, 20)
                        .addComponent(Manageusersss)
                        .addGap(20, 20, 20)
                        .addComponent(Settings)
                        .addContainerGap(392, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(jButton7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 214, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(UpdateRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DeleteRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(134, 134, 134))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BorrowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowBtnActionPerformed

       
    }//GEN-LAST:event_BorrowBtnActionPerformed

    private void UpdateRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateRequestActionPerformed

     // First show confirmation message
int confirm = JOptionPane.showConfirmDialog(
    this,
    "This button only changes the Status column.\nDo you want to continue?",
    "Update Confirmation",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.WARNING_MESSAGE
);

if (confirm != JOptionPane.YES_OPTION) {
    return; // User cancelled the operation
}

// Get selected row
int selectedRow = pendingrequest4.getSelectedRow();

// Validate selection
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(
        this,
        "Please select a request to update",
        "No Selection",
        JOptionPane.WARNING_MESSAGE
    );
    return;
}

// Get current values from the selected row
String bookTitle = pendingrequest4.getValueAt(selectedRow, 0).toString();
String borrowerName = pendingrequest4.getValueAt(selectedRow, 1).toString();
String borrowerEmail = pendingrequest4.getValueAt(selectedRow, 2).toString(); // Get email from the table

// Show status options
String[] options = {"Approved", "Rejected", "Pending"};
String newStatus = (String) JOptionPane.showInputDialog(
    this,
    "Update status for:\nBook: " + bookTitle + "\nBorrower: " + borrowerName + "\nEmail: " + borrowerEmail,
    "Update Status",
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[2] // Default to current status
);

// Validate status selection
if (newStatus == null || newStatus.isEmpty()) {
    return; // User cancelled
}

// Update database
try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
     PreparedStatement pst = con.prepareStatement(
         "UPDATE pendingrequest SET Status = ? WHERE `Book Title` = ? AND `Borrower Name` = ? AND `Email` = ?")) {  // Fixed SQL syntax
    
    pst.setString(1, newStatus);
    pst.setString(2, bookTitle);
    pst.setString(3, borrowerName);
    pst.setString(4, borrowerEmail);  // Use the email from the selected row
    
    int rowsUpdated = pst.executeUpdate();
    
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(
            this,
            "Status updated successfully to: " + newStatus + "\n\n" +
            "Book: " + bookTitle + "\n" +
            "Borrower: " + borrowerName + "\n" +
            "Email: " + borrowerEmail,
            "Update Complete",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        // Refresh the table
        loadData();
    } else {
        JOptionPane.showMessageDialog(
            this,
            "Failed to update status. No matching record found.",
            "Update Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
    
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(
        this,
        "Database error: " + ex.getMessage() + "\n\nPlease check:\n" +
        "1. Database connection\n" +
        "2. Table structure\n" +
        "3. Field values",
        "Update Error",
        JOptionPane.ERROR_MESSAGE
    );
    ex.printStackTrace();
}
    }//GEN-LAST:event_UpdateRequestActionPerformed

    private void ManageusersssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageusersssActionPerformed
        // TODO add your handling code here:
        Manageusersss manageusersss = new Manageusersss();
        manageusersss.setVisible(true);
        manageusersss.pack();
        manageusersss.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ManageusersssActionPerformed

    private void BookissuerequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookissuerequestActionPerformed
        // TODO add your handling code here:
        Bookissuerequest bookissuerequest = new Bookissuerequest();
        bookissuerequest.setVisible(true);
        bookissuerequest.pack();
        bookissuerequest.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BookissuerequestActionPerformed

    private void ManagebooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagebooksActionPerformed
        // TODO add your handling code here:
        Managebooks managebooks = new Managebooks();
        managebooks.setVisible(true);
        managebooks.pack();
        managebooks.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ManagebooksActionPerformed

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        JTextField txtLogUsername = null;
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard(txtLogUsername);
        dashboard.setVisible(true);
        dashboard.pack();
        dashboard.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_DashboardActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
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
    }//GEN-LAST:event_SettingsActionPerformed

    private void DeleteRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRequestActionPerformed
        // TODO add your handling code here:                                             
    // 1. Get selected row from the table
    int selectedRow = pendingrequest4.getSelectedRow();
    
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
    String bookTitle = pendingrequest4.getValueAt(selectedRow, 0).toString();
    String borrowerName = pendingrequest4.getValueAt(selectedRow, 1).toString();
    String borrowerEmail = pendingrequest4.getValueAt(selectedRow, 2).toString();
    
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
            
            // 6. Refresh the table to show changes
            loadData();
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
    }//GEN-LAST:event_DeleteRequestActionPerformed

    
    public static void main(String args[]) {
       
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bookissuerequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bookissuerequest;
    private javax.swing.JButton BorrowBtn;
    private javax.swing.JButton Dashboard;
    private javax.swing.JButton DeleteRequest;
    private javax.swing.JButton Managebooks;
    private javax.swing.JButton Manageusersss;
    private javax.swing.JButton Settings;
    private javax.swing.JButton UpdateRequest;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane pendingrequest2;
    private javax.swing.JTable pendingrequest4;
    // End of variables declaration//GEN-END:variables
}

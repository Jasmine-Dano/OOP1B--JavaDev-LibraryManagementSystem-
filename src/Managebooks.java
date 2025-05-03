import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Managebooks extends javax.swing.JFrame {

    
    public Managebooks() {
        initComponents();
        displayTotalBooks();
        loadData2();
         
        try {
            Connection(); // Call
        } catch (SQLException ex) {
            Logger.getLogger(Manageusersss.class.getName()).log(Level.SEVERE, null, ex);
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
   
 
public void displayTotalBooks() {
        int total = getTotalBooks();
        lblTotalBooks.setText("" + total);
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
 

public void filterBooksByType(String bookType) {
    DefaultTableModel model = (DefaultTableModel) Table2.getModel();
    model.setRowCount(0); // Clear previous data

    String sql;
    boolean isAll = bookType.equalsIgnoreCase("All");

    // Construct SQL query based on whether the selected book type is 'All' or specific
    if (isAll) {
        sql = "SELECT * FROM managebooks";  // No filter
    } else {
        sql = "SELECT * FROM managebooks WHERE `Collection Type` = ?";  // Filter by collection type
    }

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Set the parameter if the selected type is not 'All'
        if (!isAll) {
            stmt.setString(1, bookType);
        }

        // Execute the query
        ResultSet rs = stmt.executeQuery();

        // Iterate over the result set and add rows to the table
        while (rs.next()) {
            int id = rs.getInt("ID");  // Get ID from the database
            String booktitle = rs.getString("Book Title");  // Get Book Title
            String author = rs.getString("Author");  // Get Author
            String publishDate = rs.getString("Date Publish");  // Get Date Publish
            String collectionType = rs.getString("Collection Type");  // Get Collection Type

            // Add row with correct column order
            model.addRow(new Object[]{id, booktitle, author, publishDate, collectionType});
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
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

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        publishdate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        collectiontype = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        author = new javax.swing.JTextField();
        save1 = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        title1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JButton();
        Managebooks = new javax.swing.JButton();
        Bookissuerequest = new javax.swing.JButton();
        Manageusersss = new javax.swing.JButton();
        Settings = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Total = new javax.swing.JButton();
        Borrowed = new javax.swing.JButton();
        searchData1 = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        BookTitle = new javax.swing.JTextField();
        save2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CollectionType = new javax.swing.JTextField();
        DatePublish = new javax.swing.JTextField();
        Author = new javax.swing.JTextField();
        delete2 = new javax.swing.JButton();
        update2 = new javax.swing.JButton();
        clear2 = new javax.swing.JButton();
        bookTypeComboBox = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        collectiontypeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblTotalBooks = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(24, 43, 92));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel7.setText("Book Bridge");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(24, 43, 92));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel8.setText("Book Bridge");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Title:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Date Publish:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Collection Type:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Author:");

        save1.setBackground(new java.awt.Color(24, 43, 92));
        save1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        save1.setForeground(new java.awt.Color(255, 255, 255));
        save1.setText("Save");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });

        delete1.setBackground(new java.awt.Color(24, 43, 92));
        delete1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete1.setForeground(new java.awt.Color(255, 255, 255));
        delete1.setText("Delete");

        update1.setBackground(new java.awt.Color(24, 43, 92));
        update1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update1.setForeground(new java.awt.Color(255, 255, 255));
        update1.setText("Update");

        clear1.setBackground(new java.awt.Color(24, 43, 92));
        clear1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clear1.setForeground(new java.awt.Color(255, 255, 255));
        clear1.setText("Clear");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Title:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Title:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel5.setBackground(new java.awt.Color(24, 43, 92));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        Managebooks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Managebooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/briefcase (2).png"))); // NOI18N
        Managebooks.setText("Manage Books");
        Managebooks.setBorderPainted(false);
        Managebooks.setContentAreaFilled(false);
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 43, 92));
        jLabel2.setText("Manage Books");

        Total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 153, 0));
        Total.setText("Total Books");
        Total.setContentAreaFilled(false);
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        Borrowed.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Borrowed.setForeground(new java.awt.Color(24, 43, 92));
        Borrowed.setText("Track Borrowed Books");
        Borrowed.setContentAreaFilled(false);
        Borrowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowedActionPerformed(evt);
            }
        });

        searchData1.setForeground(new java.awt.Color(187, 187, 187)); // Light gray
        searchData1.setText("Search ID...");

        searchData1.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchData1.getText().equals("Search ID...")) {
                    searchData1.setText("");
                    searchData1.setForeground(new java.awt.Color(0, 0, 0)); // Black text when typing
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchData1.getText().isEmpty()) {
                    searchData1.setText("Search ID...");
                    searchData1.setForeground(new java.awt.Color(187, 187, 187)); // Light gray again
                }
            }
        });
        searchData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchData1ActionPerformed(evt);
            }
        });

        search2.setBackground(new java.awt.Color(24, 43, 92));
        search2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        search2.setForeground(new java.awt.Color(255, 255, 255));
        search2.setText("Search");
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });

        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Book Title", "Author", "Date Publish", "Collection Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table2);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Book Title:");

        save2.setBackground(new java.awt.Color(24, 43, 92));
        save2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        save2.setForeground(new java.awt.Color(255, 255, 255));
        save2.setText("Save");
        save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Date Publish:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Author:");

        collectiontypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCollectionType = collectiontypeComboBox.getSelectedItem().toString();
                CollectionType.setText(selectedCollectionType);
            }
        });
        CollectionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CollectionTypeActionPerformed(evt);
            }
        });

        delete2.setBackground(new java.awt.Color(24, 43, 92));
        delete2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete2.setForeground(new java.awt.Color(255, 255, 255));
        delete2.setText("Delete");
        delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2ActionPerformed(evt);
            }
        });

        update2.setBackground(new java.awt.Color(24, 43, 92));
        update2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update2.setForeground(new java.awt.Color(255, 255, 255));
        update2.setText("Update");
        update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update2ActionPerformed(evt);
            }
        });

        clear2.setBackground(new java.awt.Color(24, 43, 92));
        clear2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clear2.setForeground(new java.awt.Color(255, 255, 255));
        clear2.setText("Clear");
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });

        bookTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) bookTypeComboBox.getSelectedItem();
                filterBooksByType(selectedType);
            }
        });
        bookTypeComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookTypeComboBox.setForeground(new java.awt.Color(0, 0, 102));
        bookTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiction", "Non-Fiction" }));
        bookTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTypeComboBoxActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(0, 0, 102));
        btnRefresh.setText("Refresh");
        btnRefresh.setBorderPainted(false);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        collectiontypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        collectiontypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiction", "Non-Fiction" }));
        collectiontypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectiontypeComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Add Books");

        lblTotalBooks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotalBooks.setForeground(new java.awt.Color(51, 153, 0));
        lblTotalBooks.setText("label");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dashboard)
                    .addComponent(jLabel1)
                    .addComponent(Managebooks)
                    .addComponent(Manageusersss)
                    .addComponent(Bookissuerequest)
                    .addComponent(Settings))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabel14)
                                .addGap(116, 116, 116))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(collectiontypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DatePublish, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CollectionType, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchData1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search2)
                                .addGap(56, 56, 56))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalBooks)
                                .addGap(34, 34, 34)
                                .addComponent(btnRefresh)
                                .addGap(18, 18, 18)
                                .addComponent(bookTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(Borrowed)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(save2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(update2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clear2)
                                        .addGap(287, 287, 287))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel10)))
                        .addGap(0, 68, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(Dashboard)
                        .addGap(20, 20, 20)
                        .addComponent(Managebooks)
                        .addGap(20, 20, 20)
                        .addComponent(Bookissuerequest)
                        .addGap(20, 20, 20)
                        .addComponent(Manageusersss)
                        .addGap(20, 20, 20)
                        .addComponent(Settings))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(searchData1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Total)
                            .addComponent(btnRefresh)
                            .addComponent(bookTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Borrowed)
                            .addComponent(lblTotalBooks))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(DatePublish, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(collectiontypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CollectionType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        Manageusersss manageusers = new Manageusersss();
        manageusers.setVisible(true);
        manageusers.pack();
        manageusers.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ManageusersssActionPerformed

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

    private void BorrowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowedActionPerformed
        // TODO add your handling code here:
        Trackborrowedbooks trackborrowedbooks = new Trackborrowedbooks();
        trackborrowedbooks.setVisible(true);
        trackborrowedbooks.pack();
        trackborrowedbooks.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BorrowedActionPerformed

    private void searchData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchData1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchData1ActionPerformed

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

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
        getTotalBooks();
    }//GEN-LAST:event_TotalActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_save1ActionPerformed

    private void save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2ActionPerformed
        // TODO add your handling code here:
        String tl, au, dp, ct;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    // Input validation
    if ("".equals(BookTitle.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Title is required", "Dialog", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(Author.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Author is required", "Dialog", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(DatePublish.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Date Publish is required", "Dialog", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(CollectionType.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Collection Type is required", "Dialog", JOptionPane.ERROR_MESSAGE);
    } else {
        tl = BookTitle.getText();
        au = Author.getText();
        dp = DatePublish.getText();
        ct = CollectionType.getText();
       

        // Corrected: 5 placeholders
        String query = "INSERT INTO managebooks(`Book Title`, `Author`, `Date Publish`, `Collection Type`) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, tl);
        pst.setString(2, au);
        pst.setString(3, dp);
        pst.setString(4, ct);
       
        pst.executeUpdate();

        // Clear input fields
        BookTitle.setText("");
        Author.setText("");
        DatePublish.setText("");
        CollectionType.setText("");
        

        JOptionPane.showMessageDialog(new JFrame(), "Successfully Registered");

        // Optional: refresh table data
        loadData();

        con.close();
    }
} catch (HeadlessException | ClassNotFoundException | SQLException e) {
    System.out.println("Error: " + e.getMessage());
}


    }//GEN-LAST:event_save2ActionPerformed

    private void delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2ActionPerformed
        // TODO add your handling code here:
    try {
    // Load MySQL JDBC Driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Database connection
    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    String ID = searchData1.getText().trim();

    if (ID.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "ID is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int userID;
    try {
        userID = Integer.parseInt(ID);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(new JFrame(), "ID must be a number", "Format Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the record exists
    String checkQuery = "SELECT * FROM managebooks WHERE id = ?";
    PreparedStatement checkStmt = con.prepareStatement(checkQuery);
    checkStmt.setInt(1, userID);
    ResultSet rs = checkStmt.executeQuery();

    if (!rs.next()) {
        JOptionPane.showMessageDialog(new JFrame(), "No book found with this ID", "Not Found", JOptionPane.ERROR_MESSAGE);
        rs.close();
        checkStmt.close();
        con.close();
        return;
    }

    rs.close();
    checkStmt.close();

    // Delete the record
    String sqlDelete = "DELETE FROM managebooks WHERE id = ?";
    PreparedStatement deleteStmt = con.prepareStatement(sqlDelete);
    deleteStmt.setInt(1, userID);

    int rowsDeleted = deleteStmt.executeUpdate();
    deleteStmt.close();
    con.close();

    if (rowsDeleted > 0) {
        JOptionPane.showMessageDialog(new JFrame(), "Book deleted successfully!");
        loadData(); // Refresh data
    } else {
        JOptionPane.showMessageDialog(new JFrame(), "Failed to delete book", "Error", JOptionPane.ERROR_MESSAGE);
    }

} catch (ClassNotFoundException e) {
    JOptionPane.showMessageDialog(new JFrame(), "MySQL JDBC Driver not found", "Driver Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(new JFrame(), "Database error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_delete2ActionPerformed

    private void update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update2ActionPerformed
        // TODO add your handling code here:
        String tl, au, dp, ct;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/library"; 
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    String IDStr = searchData1.getText().trim();

    if (IDStr.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "ID is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int userID;
    try {
        userID = Integer.parseInt(IDStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID format!", "Format Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if book with ID exists
    String checkQuery = "SELECT * FROM managebooks WHERE id = ?";
    PreparedStatement checkStmt = con.prepareStatement(checkQuery);
    checkStmt.setInt(1, userID);
    ResultSet rs = checkStmt.executeQuery();

    if (!rs.next()) {
        JOptionPane.showMessageDialog(new JFrame(), "No book found with this ID", "Not Found", JOptionPane.ERROR_MESSAGE);
        rs.close();
        checkStmt.close();
        con.close();
        return;
    }

    // Collect and validate new data
    tl = BookTitle.getText().trim();
    au = Author.getText().trim();
    dp = DatePublish.getText().trim();
    ct = CollectionType.getText().trim();


    if (tl.isEmpty() || au.isEmpty() || dp.isEmpty() || ct.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
        rs.close();
        checkStmt.close();
        con.close();
        return;
    }

    // ✅ Corrected query with proper number of placeholders
    String sqlUpdate = "UPDATE managebooks SET `Book Title` = ?, `Author` = ?, `Date Publish` = ?, `Collection Type` = ? WHERE id = ?";
    PreparedStatement pst = con.prepareStatement(sqlUpdate);
    pst.setString(1, tl);
    pst.setString(2, au);
    pst.setString(3, dp);
    pst.setString(4, ct);
    pst.setInt(5, userID);

    int rowsUpdated = pst.executeUpdate();

    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(new JFrame(), "Book updated successfully!");
        loadData(); // Refresh the table
    } else {
        JOptionPane.showMessageDialog(new JFrame(), "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Close resources
    rs.close();
    checkStmt.close();
    pst.close();
    con.close();

} catch (ClassNotFoundException e) {
    JOptionPane.showMessageDialog(new JFrame(), "MySQL JDBC Driver not found", "Driver Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(new JFrame(), "Database error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_update2ActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        // TODO add your handling code here:
        BookTitle.setText("");
        Author.setText("");
        DatePublish.setText("");
        CollectionType.setText("");
    }//GEN-LAST:event_clear2ActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
    String ID;

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/library"; // Fixed 'MySQL' to 'mysql'
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    ID = searchData1.getText().trim();

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

    }//GEN-LAST:event_search2ActionPerformed

    private void bookTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTypeComboBoxActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_bookTypeComboBoxActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        displayTotalBooks();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void collectiontypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collectiontypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collectiontypeComboBoxActionPerformed

    private void CollectionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CollectionTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CollectionTypeActionPerformed

    public void loadData() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database Connection Details
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "";

        // Establish Connection
        con = DriverManager.getConnection(url, user, pass);
        st = con.createStatement();

        // Execute Query
        String sql = "SELECT * FROM managebooks";
        rs = st.executeQuery(sql);

        // Get metadata to create table model
        java.sql.ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Create table model with dynamic column names
        DefaultTableModel model = new DefaultTableModel() {
            // Make cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Add column names
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnLabel(i));
        }

        // Add rows
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            model.addRow(rowData);
        }

        // Set model to JTable (make sure Table2 is initialized)
        Table2.setModel(model);

    } catch (ClassNotFoundException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close resources safely
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage(), "Cleanup Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Managebooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Author;
    private javax.swing.JTextField BookTitle;
    private javax.swing.JButton Bookissuerequest;
    private javax.swing.JButton Borrowed;
    private javax.swing.JTextField CollectionType;
    private javax.swing.JButton Dashboard;
    private javax.swing.JTextField DatePublish;
    private javax.swing.JButton Managebooks;
    private javax.swing.JButton Manageusersss;
    private javax.swing.JButton Settings;
    private javax.swing.JTable Table2;
    private javax.swing.JButton Total;
    private javax.swing.JTextField author;
    private javax.swing.JComboBox<String> bookTypeComboBox;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton clear1;
    private javax.swing.JButton clear2;
    private javax.swing.JTextField collectiontype;
    private javax.swing.JComboBox<String> collectiontypeComboBox;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalBooks;
    private javax.swing.JTextField publishdate;
    private javax.swing.JButton save1;
    private javax.swing.JButton save2;
    private javax.swing.JButton search2;
    private javax.swing.JTextField searchData1;
    private javax.swing.JTextField title;
    private javax.swing.JTextField title1;
    private javax.swing.JButton update1;
    private javax.swing.JButton update2;
    // End of variables declaration//GEN-END:variables
}

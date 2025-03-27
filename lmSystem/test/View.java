import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class View extends javax.swing.JFrame {

    public View() {
        initComponents();
         try {
            Connection(); // Call
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
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
    private static final String DbUrl = "jdbc:mysql://localhost:3306/"+DbName;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dashboard = new javax.swing.JLabel();
        managebooks = new javax.swing.JLabel();
        bookissuerequest = new javax.swing.JLabel();
        manageusers = new javax.swing.JLabel();
        reports = new javax.swing.JLabel();
        settings = new javax.swing.JLabel();
        Manageusers = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JButton();
        ManageBooks = new javax.swing.JButton();
        BookIssueRequest = new javax.swing.JButton();
        ManageUsers = new javax.swing.JButton();
        Reports = new javax.swing.JButton();
        Settings = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        contactnumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        searchData = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        jLabel2.setText("jLj");

        jLabel3.setPreferredSize(new java.awt.Dimension(32, 21));

        jLabel11.setText("Name");

        jLabel12.setText("Email Address");

        jLabel13.setText("Contact Number");

        jLabel14.setText("Type");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        dashboard.setText("jLabel4");
        dashboard.setPreferredSize(new java.awt.Dimension(25, 25));

        managebooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/briefcase (2).png"))); // NOI18N

        bookissuerequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookissue.png"))); // NOI18N
        bookissuerequest.setPreferredSize(new java.awt.Dimension(25, 25));

        manageusers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage users.png"))); // NOI18N

        reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reports.png"))); // NOI18N

        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Manageusers.setBackground(new java.awt.Color(255, 255, 255));
        Manageusers.setMaximumSize(new java.awt.Dimension(800, 500));
        Manageusers.setMinimumSize(new java.awt.Dimension(800, 500));
        Manageusers.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setBackground(new java.awt.Color(24, 43, 92));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 43, 92));
        jLabel1.setText("Manage Users");

        Dashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dashboard.setText("Dashboard");
        Dashboard.setContentAreaFilled(false);
        Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardActionPerformed(evt);
            }
        });

        ManageBooks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ManageBooks.setText("Manage Books");
        ManageBooks.setContentAreaFilled(false);
        ManageBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageBooksActionPerformed(evt);
            }
        });

        BookIssueRequest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BookIssueRequest.setText("Book Issue Request");
        BookIssueRequest.setContentAreaFilled(false);
        BookIssueRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookIssueRequestActionPerformed(evt);
            }
        });

        ManageUsers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ManageUsers.setText("Manage Users");
        ManageUsers.setContentAreaFilled(false);
        ManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageUsersActionPerformed(evt);
            }
        });

        Reports.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Reports.setText("Reports");
        Reports.setContentAreaFilled(false);

        Settings.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Settings.setText("Settings");
        Settings.setContentAreaFilled(false);
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(24, 43, 92));
        jLabel7.setText("Book Bridge");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Add User");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Name:");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Contact Number:");

        contactnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactnumberActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email:");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Type:");

        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(24, 43, 92));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        save.setBackground(new java.awt.Color(24, 43, 92));
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(24, 43, 92));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(24, 43, 92));
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(24, 43, 92));
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(24, 43, 92));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Search By Name");

        searchBtn.setBackground(new java.awt.Color(24, 43, 92));
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Find");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Contact Number", "Email", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ManageusersLayout = new javax.swing.GroupLayout(Manageusers);
        Manageusers.setLayout(ManageusersLayout);
        ManageusersLayout.setHorizontalGroup(
            ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageusersLayout.createSequentialGroup()
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ManageusersLayout.createSequentialGroup()
                            .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ManageusersLayout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Dashboard)
                                        .addComponent(jLabel7)))
                                .addGroup(ManageusersLayout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(ManageBooks))
                                .addGroup(ManageusersLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ManageusersLayout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(jLabel8)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BookIssueRequest))))
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(147, 147, 147))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(786, 786, 786)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchBtn))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addComponent(save)
                                        .addGap(71, 71, 71)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(contactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        ManageusersLayout.setVerticalGroup(
            ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ManageusersLayout.createSequentialGroup()
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39)
                        .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ManageBooks))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel15)
                            .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(BookIssueRequest)
                        .addGap(18, 18, 18)
                        .addComponent(ManageUsers)
                        .addGap(18, 18, 18)
                        .addComponent(Reports)
                        .addGap(18, 18, 18)
                        .addComponent(Settings)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel8)
                        .addGap(128, 128, 128))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save)
                            .addComponent(delete)
                            .addComponent(clearBtn)
                            .addComponent(updateBtn))
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Manageusers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Manageusers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardActionPerformed

    private void ManageBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageBooksActionPerformed

    private void BookIssueRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookIssueRequestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookIssueRequestActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SettingsActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void contactnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactnumberActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void ManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageUsersActionPerformed

    public void loadData(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url = "jdbc:MySQL://localhost:3306/library";
        String user = "root";
        String pass = "";
            
        Connection cons = DriverManager.getConnection(url, user, pass);
        Statement sts = cons.createStatement();

        DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Contact Number", "Email", "Type"}, 0);

        Table.setModel(model);
        String sql = "SELECT * FROM manageusers";
        
        ResultSet rs = st.executeQuery(sql);
        String n,e,t;
        int c;
        
        while(rs.next()){
            n = rs.getString("name");
            c = rs.getInt("contactnumber");
            e = rs.getString("email");
            t = rs.getString("type");
            model.addRow(new Object[]{n, c, e, t});
        }
    }catch(HeadlessException | ClassNotFoundException | SQLException e){
                System.out.println("Error "+ e.getMessage());
                }     
    } 

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       
        String n,em,ctc,t;
        if ("".equals(name.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Username");
        }   
        if ("".equals(email.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Password");
        }
        if ("".equals(contactnumber.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Username");
        } 
        if ("".equals(type.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Username");
        } 
        else{
            n = name.getText();
            em = email.getText();
            ctc = contactnumber.getText();
            t = type.getText();
        
            String queryRegister = "INSERT into manageusers(name, contactnumber, email, type)VALUES (?,?,?,?)"; 
            
            try (PreparedStatement pst = con.prepareStatement(queryRegister)){
            
            pst.setString(1, n);
            pst.setString(2, ctc);
            pst.setString(3, em);
            pst.setString(4, t);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(new JFrame(), "Data added successfully");
              name.setText("");
              contactnumber.setText("");
              email.setText("");
              type.setText("");

            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_saveActionPerformed

    
    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
         // TODO add your handling code here:
         String Name;
         String notFound = "";
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url = "jdbc:MySQL://localhost:3306/library";
        String user = "root";
        String pass = "";
        
        Connection cons = DriverManager.getConnection(url, user, pass);
        Statement sts = cons.createStatement();
        
        Name = searchData.getText();
        if("".equals(name.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Name is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        }else {
            String sql = "SELECT * FROM manageusers WHERE name= +Name";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                name.setText("name");
                contactnumber.setText("contactnumber");
                email.setText("email");
                type.setText("type");
                notFound = "";
            }
            if(notFound.isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(), "Invalid Name", "Dialog", JOptionPane.ERROR_MESSAGE);

            }
        }
         }catch(HeadlessException | ClassNotFoundException | SQLException e){
                System.out.println("Error "+ e.getMessage());
                }  
    }//GEN-LAST:event_searchBtnActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        String Name;
         String notFound = "";
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url = "jdbc:MySQL://localhost:3306/library";
        String user = "root";
        String pass = "";
        
        Connection cons = DriverManager.getConnection(url, user, pass);
        Statement sts = cons.createStatement();
        
        Name = searchData.getText();
        if("".equals(name.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Name is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        }else {
            String sql = "SELECT * FROM manageusers WHERE name= +Name";
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                notFound = "";
            String sql2 = "DELETE * FROM manageusers WHERE name= +Name";
            st.executeUpdate(sql2);   
            loadData();
            con.close();
            }
            if(notFound.isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(), "Invalid Name", "Dialog", JOptionPane.ERROR_MESSAGE);

            }
        }
         }catch(HeadlessException | ClassNotFoundException | SQLException e){
                System.out.println("Error "+ e.getMessage());
                }  
    }//GEN-LAST:event_deleteActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        name.setText("name");
        contactnumber.setText("contactnumber");
        email.setText("email");
        type.setText("type");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        String nn, cn, em, ty, query;
        String Name;
         String notFound = "";
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url = "jdbc:MySQL://localhost:3306/library";
        String user = "root";
        String pass = "";
        
        Connection cons = DriverManager.getConnection(url, user, pass);
        Statement sts = con.createStatement();
        
        Name = searchData.getText();
        if("".equals(name.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Name is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        }else {
            String sql = "SELECT * FROM manageusers WHERE name= +Name";
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                notFound = "";
                nn = name.getText();
                cn = contactnumber.getText();
                em = email.getText();
                ty = type.getText();
            String sql2 = "UPDATE manageusers SET "
                    + "name='"+nn+"', contactnumber='"+cn+"', email='"+em+"',type='"+ty+"', WHERE name="+Name;
            st.executeUpdate(sql2);   
            loadData();
            con.close();
            }
            if(notFound.isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(), "Invalid Name", "Dialog", JOptionPane.ERROR_MESSAGE);

            }
        }
         }catch(HeadlessException | ClassNotFoundException | SQLException e){
                System.out.println("Error "+ e.getMessage());
                }  
    }//GEN-LAST:event_updateBtnActionPerformed

   
              
            
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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                View x = new View();
                x.loadData();
                x.setLocationRelativeTo(null);
                x.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookIssueRequest;
    private javax.swing.JButton Dashboard;
    private javax.swing.JButton ManageBooks;
    private javax.swing.JButton ManageUsers;
    private javax.swing.JPanel Manageusers;
    private javax.swing.JButton Reports;
    private javax.swing.JButton Settings;
    private javax.swing.JTable Table;
    private javax.swing.JLabel bookissuerequest;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField contactnumber;
    private javax.swing.JLabel dashboard;
    private javax.swing.JButton delete;
    private javax.swing.JTextField email;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel managebooks;
    private javax.swing.JLabel manageusers;
    private javax.swing.JTextField name;
    private javax.swing.JLabel reports;
    private javax.swing.JButton save;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchData;
    private javax.swing.JLabel settings;
    private javax.swing.JTextField type;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

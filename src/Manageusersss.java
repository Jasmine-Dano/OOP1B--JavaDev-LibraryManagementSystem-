import com.mysql.cj.jdbc.result.ResultSetMetaData;
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
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Manageusersss extends javax.swing.JFrame {

    public Manageusersss() {
        initComponents();
        loadDatas();
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

    
 
    public void loadDatas() {
    DefaultTableModel model = (DefaultTableModel) Table.getModel();
    model.setRowCount(0); // clear existing rows

    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";

    try (Connection con = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = con.prepareStatement("SELECT `First Name`, `Last Name`, `Username`, `Password`, `Role` FROM accountdetails");
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            String firstName = rs.getString("First Name");
            String lastName = rs.getString("Last Name");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            String role = rs.getString("Role");

            model.addRow(new Object[]{firstName, lastName, username, password, role});
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
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
        Managebooks = new javax.swing.JButton();
        Bookissuerequest = new javax.swing.JButton();
        Manageusersss = new javax.swing.JButton();
        Reports = new javax.swing.JButton();
        Settings = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtfirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtlastName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Role = new javax.swing.JTextField();
        txtLogPassword = new javax.swing.JTextField();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        RoleComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtLogUsername = new javax.swing.JTextField();

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
        Manageusers.setPreferredSize(new java.awt.Dimension(1073, 512));

        jLabel1.setBackground(new java.awt.Color(24, 43, 92));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 43, 92));
        jLabel1.setText("Manage Users");

        Manageusersss.addActionListener(e -> {
            new Manageusersss().setVisible(true); // This opens your Manage Users JFrame
            this.dispose(); // Optional: closes current frame
        });
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

        Manageusersss.addActionListener(e -> {
            new Manageusersss().setVisible(true); // This opens your Manage Users JFrame
            this.dispose(); // Optional: closes current frame
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

        Manageusersss.addActionListener(e -> {
            new Manageusersss().setVisible(true); // This opens your Manage Users JFrame
            this.dispose(); // Optional: closes current frame
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

        Manageusersss.addActionListener(e -> {
            new Manageusersss().setVisible(true); // This opens your Manage Users JFrame
            this.dispose(); // Optional: closes current frame
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

        Manageusersss.addActionListener(e -> {
            new Manageusersss().setVisible(true); // This opens your Manage Users JFrame
            this.dispose(); // Optional: closes current frame
        });
        Reports.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reports.png"))); // NOI18N
        Reports.setText("Reports");
        Reports.setBorderPainted(false);
        Reports.setContentAreaFilled(false);
        Reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsActionPerformed(evt);
            }
        });

        Manageusersss.addActionListener(e -> {
            new Manageusersss().setVisible(true); // This opens your Manage Users JFrame
            this.dispose(); // Optional: closes current frame
        });
        Settings.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        Settings.setText("Log Out");
        Settings.setBorderPainted(false);
        Settings.setContentAreaFilled(false);
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(24, 43, 92));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel7.setText("Book Bridge");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 43, 92));
        jLabel4.setText("Add User");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("First Name:");

        txtfirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfirstNameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Last Name:");

        txtlastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlastNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Password:");

        RoleComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRole = RoleComboBox.getSelectedItem().toString();
                Role.setText(selectedRole);
            }
        });
        Role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleActionPerformed(evt);
            }
        });

        txtLogPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogPasswordActionPerformed(evt);
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
        save.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(24, 43, 92));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(24, 43, 92));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(24, 43, 92));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(24, 43, 92));
        jLabel15.setText("Search By ID:");

        searchData.setForeground(new java.awt.Color(187, 187, 187)); // Light gray
        searchData.setText("Search Name...");

        searchData.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchData.getText().equals("Search Name...")) {
                    searchData.setText("");
                    searchData.setForeground(new java.awt.Color(0, 0, 0)); // Black text when typing
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchData.getText().isEmpty()) {
                    searchData.setText("Search Name...");
                    searchData.setForeground(new java.awt.Color(187, 187, 187)); // Light gray again
                }
            }
        });
        searchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDataActionPerformed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(24, 43, 92));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Find");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        Table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "First Name", "Last Name", "Username", "Password", "Role"}
        ));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Username", "Password", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table);

        RoleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Borrower", "Librarian" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Username:");

        txtLogUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageusersLayout = new javax.swing.GroupLayout(Manageusers);
        Manageusers.setLayout(ManageusersLayout);
        ManageusersLayout.setHorizontalGroup(
            ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageusersLayout.createSequentialGroup()
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Bookissuerequest, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16))
                                .addComponent(Managebooks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                                    .addComponent(Manageusersss, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)))))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel8))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(ManageusersLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(63, 63, 63))
                                        .addGroup(ManageusersLayout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)))
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addComponent(RoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)))
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtlastName, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(txtfirstName))
                                    .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(113, 113, 113)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchBtn))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addComponent(save)
                                .addGap(18, 18, 18)
                                .addComponent(delete)
                                .addGap(18, 18, 18)
                                .addComponent(updateBtn)
                                .addGap(18, 18, 18)
                                .addComponent(clearBtn))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLogUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(122, Short.MAX_VALUE))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2755, 2755, 2755)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(147, 147, 147))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(786, 786, 786)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ManageusersLayout.createSequentialGroup()
                    .addGap(703, 703, 703)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(5082, Short.MAX_VALUE)))
        );
        ManageusersLayout.setVerticalGroup(
            ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageusersLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(jLabel15))
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Managebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Bookissuerequest, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Manageusersss, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(jLabel8))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtfirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
            .addGroup(ManageusersLayout.createSequentialGroup()
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7)))
                .addGap(71, 71, 71)
                .addComponent(txtLogUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(381, 381, 381)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ManageusersLayout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(jLabel10)
                    .addContainerGap(566, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Manageusers, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Manageusers, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
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

    private void ManagebooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagebooksActionPerformed
        // TODO add your handling code here:
        Managebooks managebooks = new Managebooks();
        managebooks.setVisible(true);
        managebooks.pack();
        managebooks.setLocationRelativeTo(null);
        this.dispose(); 
    }//GEN-LAST:event_ManagebooksActionPerformed

    private void BookissuerequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookissuerequestActionPerformed
        // TODO add your handling code here:
        Bookissuerequest bookissuerequest = new Bookissuerequest();
        bookissuerequest.setVisible(true);
        bookissuerequest.pack();
        bookissuerequest.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BookissuerequestActionPerformed

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

    private void txtfirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfirstNameActionPerformed

    private void txtlastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlastNameActionPerformed

    private void RoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleActionPerformed

    private void txtLogPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogPasswordActionPerformed

    private void ManageusersssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageusersssActionPerformed
          // TODO add your handling code here:
          Manageusersss manageusersss = new Manageusersss();
          manageusersss.setVisible(true);
          manageusersss.pack();
          manageusersss.setLocationRelativeTo(null);
          this.dispose();
    }//GEN-LAST:event_ManageusersssActionPerformed

    public void loadData(){

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
        String sql = "SELECT * FROM accountdetails";
        rs = st.executeQuery(sql);

        // Create Table Model
        DefaultTableModel model = new DefaultTableModel();
        
        // Get Column Names Dynamically
        ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));
        }

        // Fetch Data
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            model.addRow(rowData);
        }

        // Set Model AFTER fetching data
        Table.setModel(model);

    } catch (HeadlessException | ClassNotFoundException | SQLException e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        // Close resources properly
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
    } 

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       
        String nn, cn, em, emm, ty;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/library"; // ✅ Correct casing
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    // ✅ Trimmed inputs
    nn = txtfirstName.getText().trim();
    cn = txtlastName.getText().trim();
    em = txtLogUsername.getText().trim();
    emm = txtLogPassword.getText().trim();
    ty = Role.getText().trim();

    // ✅ Input validation
    if (nn.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "First Name is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (cn.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Last Name is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (em.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Username is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (emm.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (ty.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Role is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // ✅ Insert query using PreparedStatement to prevent SQL injection
    String query = "INSERT INTO accountdetails(`First Name`, `Last Name`, `Username`, `Password`, `Role`) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement pst = con.prepareStatement(query);
    pst.setString(1, nn);
    pst.setString(2, cn);
    pst.setString(3, em);
    pst.setString(4, emm);
    pst.setString(5, ty);

    int rowsInserted = pst.executeUpdate();

    if (rowsInserted > 0) {
        JOptionPane.showMessageDialog(new JFrame(), "Successfully Registered");
        // ✅ Clear fields after successful insertion
        txtfirstName.setText("");
        txtlastName.setText("");
        txtLogUsername.setText("");
        txtLogPassword.setText("");
        Role.setText("");
        loadData(); // Refresh table or UI
    } else {
        JOptionPane.showMessageDialog(new JFrame(), "Registration failed", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // ✅ Close resources
    pst.close();
    con.close();

} catch (HeadlessException | ClassNotFoundException | SQLException e) {
    System.out.println("Error: " + e.getMessage());
}

    }//GEN-LAST:event_saveActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
         // TODO add your handling code here:
    String keyword;
int notFound = 0;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    keyword = searchData.getText().trim(); // User input

    if (keyword.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Enter First Name or Last Name", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Updated query to search either First Name or Last Name
    String sql = "SELECT * FROM accountdetails WHERE `First Name` LIKE ? OR `Last Name` LIKE ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, "%" + keyword + "%");
    pst.setString(2, "%" + keyword + "%");

    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        txtfirstName.setText(rs.getString("First Name"));
        txtlastName.setText(rs.getString("Last Name"));
        txtLogUsername.setText(rs.getString("Username"));
        txtLogPassword.setText(rs.getString("Password"));
        Role.setText(rs.getString("Role"));
        notFound = 1;
    }

    if (notFound == 0) {
        JOptionPane.showMessageDialog(new JFrame(), "No user found with that name", "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }

    rs.close();
    pst.close();
    con.close();

} catch (HeadlessException | ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
}

    }//GEN-LAST:event_searchBtnActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:                              
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "";

        Connection con = DriverManager.getConnection(url, user, pass);

        String keyword = searchData.getText().trim(); // First or Last name

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Please enter First or Last Name", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirm before deleting
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete user(s) with this name?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        // Search for matching users first
        String checkQuery = "SELECT * FROM accountdetails WHERE `First Name` = ? OR `Last Name` = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkQuery);
        checkStmt.setString(1, keyword);
        checkStmt.setString(2, keyword);

        ResultSet rs = checkStmt.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(new JFrame(), "No user found with that name", "Error", JOptionPane.ERROR_MESSAGE);
            rs.close();
            checkStmt.close();
            con.close();
            return;
        }

        rs.close();
        checkStmt.close();

        // Delete matching user(s)
        String sqlDelete = "DELETE FROM accountdetails WHERE `First Name` = ? OR `Last Name` = ?";
        PreparedStatement deleteStmt = con.prepareStatement(sqlDelete);
        deleteStmt.setString(1, keyword);
        deleteStmt.setString(2, keyword);

        int rowsDeleted = deleteStmt.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(new JFrame(), "User(s) deleted successfully!");
            loadData(); // Refresh table
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Delete failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

        deleteStmt.close();
        con.close();

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error: " + e.getMessage());
        JOptionPane.showMessageDialog(new JFrame(), "Database Error:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_deleteActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        txtfirstName.setText("");
        txtlastName.setText("");
        txtLogUsername.setText("");
        txtLogPassword.setText("");
        Role.setText("");
        
    }//GEN-LAST:event_clearBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
       
        String nn, cn, em, emm, ty;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    // Get and trim user inputs
    nn = txtfirstName.getText().trim();  // First Name
    cn = txtlastName.getText().trim();   // Last Name
    em = txtLogUsername.getText().trim(); // Username
    emm = txtLogPassword.getText().trim(); // Password
    ty = Role.getText().trim();          // Role

    // Validate input
    if (nn.isEmpty() && cn.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter First Name or Last Name to update", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (em.isEmpty() || emm.isEmpty() || ty.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Search and update using First Name OR Last Name
    String sql = "UPDATE accountdetails SET `Username` = ?, `Password` = ?, `Role` = ? WHERE `First Name` = ? OR `Last Name` = ?";
    PreparedStatement pst = con.prepareStatement(sql);

    pst.setString(1, em);
    pst.setString(2, emm);
    pst.setString(3, ty);
    pst.setString(4, nn);
    pst.setString(5, cn);

    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(this, "User updated successfully!");
        loadData(); // Refresh table
    } else {
        JOptionPane.showMessageDialog(this, "Update failed. No matching name found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    pst.close();
    con.close();

} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_updateBtnActionPerformed

    private void searchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDataActionPerformed

    private void ReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsActionPerformed
        // TODO add your handling code here:    
        Reports reports = new Reports();
        reports.setVisible(true);
        reports.pack();
        reports.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ReportsActionPerformed

    private void txtLogUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogUsernameActionPerformed

   
              
            
    public  void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manageusersss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manageusersss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manageusersss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manageusersss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Manageusersss x = new Manageusersss();
                x.loadData();
                x.setLocationRelativeTo(null);
                x.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bookissuerequest;
    private javax.swing.JButton Dashboard;
    private javax.swing.JButton Managebooks;
    private javax.swing.JPanel Manageusers;
    private javax.swing.JButton Manageusersss;
    private javax.swing.JButton Reports;
    private javax.swing.JTextField Role;
    private javax.swing.JComboBox<String> RoleComboBox;
    private javax.swing.JButton Settings;
    private javax.swing.JTable Table;
    private javax.swing.JLabel bookissuerequest;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel dashboard;
    private javax.swing.JButton delete;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel managebooks;
    private javax.swing.JLabel manageusers;
    private javax.swing.JLabel reports;
    private javax.swing.JButton save;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchData;
    private javax.swing.JLabel settings;
    private javax.swing.JTextField txtLogPassword;
    private javax.swing.JTextField txtLogUsername;
    private javax.swing.JTextField txtfirstName;
    private javax.swing.JTextField txtlastName;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

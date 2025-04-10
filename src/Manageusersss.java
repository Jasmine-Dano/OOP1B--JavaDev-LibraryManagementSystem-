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


public class Manageusersss extends javax.swing.JFrame {

    public Manageusersss() {
        initComponents();
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
        jScrollPane4 = new javax.swing.JScrollPane();
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
        Manageusers.setPreferredSize(new java.awt.Dimension(1073, 512));

        jLabel1.setBackground(new java.awt.Color(24, 43, 92));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 43, 92));
        jLabel1.setText("Manage Users");

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(24, 43, 92));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N
        jLabel7.setText("Book Bridge");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 43, 92));
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

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Contact Number", "Email", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table);

        javax.swing.GroupLayout ManageusersLayout = new javax.swing.GroupLayout(Manageusers);
        Manageusers.setLayout(ManageusersLayout);
        ManageusersLayout.setHorizontalGroup(
            ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageusersLayout.createSequentialGroup()
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                                .addComponent(Managebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Manageusersss, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel8))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Bookissuerequest, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2755, 2755, 2755)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(147, 147, 147))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(786, 786, 786)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ManageusersLayout.createSequentialGroup()
                                    .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ManageusersLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(45, 45, 45)
                                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(63, 63, 63)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ManageusersLayout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(ManageusersLayout.createSequentialGroup()
                                                    .addComponent(contactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(ManageusersLayout.createSequentialGroup()
                                                    .addComponent(save)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(53, 53, 53)))))
                                    .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ManageusersLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(52, 52, 52)
                                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ManageusersLayout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(246, Short.MAX_VALUE))))
        );
        ManageusersLayout.setVerticalGroup(
            ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageusersLayout.createSequentialGroup()
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn)
                            .addComponent(jLabel1)))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7)))
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Managebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Bookissuerequest, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Manageusersss, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel8)
                        .addGap(128, 128, 128))
                    .addGroup(ManageusersLayout.createSequentialGroup()
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13)
                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageusersLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(updateBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(ManageusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addGap(288, 288, 288)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ManageusersLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ManageusersLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jScrollPane4)))
                        .addContainerGap())))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Manageusers, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Manageusers, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard();
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
        Settings settings = new Settings();
        settings.setVisible(true);
        settings.pack();
        settings.setLocationRelativeTo(null);
        this.dispose();
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

    private void ManageusersssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageusersssActionPerformed
          // TODO add your handling code here:
          Manageusersss manageusers = new Manageusersss();
          manageusers.setVisible(true);
          manageusers.pack();
          manageusers.setLocationRelativeTo(null);
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
        String sql = "SELECT * FROM manageuserss";
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
        String nn, cn, em, ty, query;
        
        //Connect to database
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url = "jdbc:MySQL://localhost:3306/library";
        String user = "root";
        String pass = "";
        
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
        
        if("".equals(name.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Name is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        } else if("".equals(contactnumber.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Contact Number is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        } else if("".equals(email.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Email is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        } else if("".equals(type.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Type is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        } else {
            nn = name.getText();
            cn = contactnumber.getText();
            em = email.getText();
            ty = type.getText();
            query = "INSERT INTO manageuserss(name, contactnumber, email, type) "
                    + "VALUES ('"+nn+"','"+cn+"','"+em+"','"+ty+"')";

            st.executeUpdate(query);
            name.setText("");
            contactnumber.setText("");
            email.setText("");
            type.setText("");
            JOptionPane.showMessageDialog(new JFrame(), "Successfully Registered");
            loadData();
            con.close();
}
        }catch(HeadlessException | ClassNotFoundException | SQLException e){
                System.out.println("Error "+ e.getMessage());
                }     
    }//GEN-LAST:event_saveActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
         // TODO add your handling code here:
         String ID;
         int notFound = 0;
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url = "jdbc:MySQL://localhost:3306/library";
        String user = "root";
        String pass = "";
        
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
        
        ID = searchData.getText();
        if("".equals(ID)){
            JOptionPane.showMessageDialog(new JFrame(), "ID is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        }else {
            String sql = "SELECT * FROM manageuserss WHERE id = "+ID;
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                name.setText(rs.getString("name"));
                contactnumber.setText(rs.getString("contactnumber"));
                email.setText(rs.getString("email"));
                type.setText(rs.getString("type"));
                notFound = 1;
            }
            if(notFound == 0){
                JOptionPane.showMessageDialog(new JFrame(), "Invalid ID", "Dialog", JOptionPane.ERROR_MESSAGE);

            }
        }
         }catch(HeadlessException | ClassNotFoundException | SQLException e){
                System.out.println("Error "+ e.getMessage());
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

    String ID = searchData.getText().trim(); // Trim whitespace

    if (ID.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "ID is required", "Dialog", JOptionPane.ERROR_MESSAGE);
        return; // Stop execution if ID is empty
    }

    int userID;
    try {
        userID = Integer.parseInt(ID); // Convert ID to integer
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID format!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if user exists
    String checkQuery = "SELECT * FROM manageuserss WHERE id = ?";
    PreparedStatement checkStmt = con.prepareStatement(checkQuery);
    checkStmt.setInt(1, userID);
    ResultSet rs = checkStmt.executeQuery();

    boolean found = false;
    if (rs.next()) {
        found = true;
    }

    if (!found) {
        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID", "Dialog", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // DELETE user
    String sqlDelete = "DELETE FROM manageuserss WHERE id = ?";
    PreparedStatement deleteStmt = con.prepareStatement(sqlDelete);
    deleteStmt.setInt(1, userID);

    int rowsDeleted = deleteStmt.executeUpdate();
    if (rowsDeleted > 0) {
        JOptionPane.showMessageDialog(new JFrame(), "User deleted successfully!");
        loadData(); // Refresh table after delete
    } else {
        JOptionPane.showMessageDialog(new JFrame(), "Delete failed!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Close connections
    rs.close();
    checkStmt.close();
    deleteStmt.close();
    con.close();

} catch (ClassNotFoundException | SQLException e) {
    System.out.println("Error: " + e.getMessage());
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
        String nn, cn, em, ty;
    int notFound = 1; // Assume ID is not found initially

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/library"; // Fixed "MySQL" case issue
        String user = "root";
        String pass = "";

        Connection con = DriverManager.getConnection(url, user, pass);

        String IDStr = searchData.getText().trim(); // Trim whitespace

        if (IDStr.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "ID is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int userID;
        try {
            userID = Integer.parseInt(IDStr); // Convert to integer
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Invalid ID format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if user exists
        String checkQuery = "SELECT * FROM manageuserss WHERE id = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkQuery);
        checkStmt.setInt(1, userID);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            notFound = 0; // User found, proceed with update

            nn = name.getText().trim();
            cn = contactnumber.getText().trim();
            em = email.getText().trim();
            ty = type.getText().trim();

            // Ensure all fields are filled
            if (nn.isEmpty() || cn.isEmpty() || em.isEmpty() || ty.isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // UPDATE query using PreparedStatement
            String sqlUpdate = "UPDATE manageuserss SET name=?, contactnumber=?, email=?, type=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sqlUpdate);
            pst.setString(1, nn);
            pst.setString(2, cn);
            pst.setString(3, em);
            pst.setString(4, ty);
            pst.setInt(5, userID);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(new JFrame(), "User updated successfully!");
                loadData(); // Refresh table
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            pst.close();
        }

        if (notFound == 1) {
            JOptionPane.showMessageDialog(new JFrame(), "Invalid ID", "Dialog", JOptionPane.ERROR_MESSAGE);
        }

        // Close connections
        rs.close();
        checkStmt.close();
        con.close();

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error: " + e.getMessage());
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
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

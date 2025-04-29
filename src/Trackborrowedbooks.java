import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import javax.swing.*;
import java.util.Vector;



public class Trackborrowedbooks extends javax.swing.JFrame {

    
    public Trackborrowedbooks() {
    initComponents();
    displayTotalBooks();

    try {
        Connection(); // Assuming this is a method that connects to DB
    } catch (SQLException ex) {
        Logger.getLogger(Trackborrowedbooks.class.getName()).log(Level.SEVERE, null, ex);
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
   
// Display total books
    public void displayTotalBooks() {
        int total = getTotalBooks();
        lblTotalBooks.setText(" " + total);
    }
    
    // Get total book count
    public int getTotalBooks() {
        int total = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

            String query = "SELECT COUNT(*) FROM trackborrowedbooks";
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
  
    
    // Filter books based on selected type
    public void filterBooksByType() {
        String selectedType = (String) bookTypeComboBox.getSelectedItem();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

            String query;
            PreparedStatement pst;

            if (selectedType.equalsIgnoreCase("All")) {
                query = "SELECT * FROM trackborrowedbooks";
                pst = con.prepareStatement(query);
            } else {
                query = "SELECT * FROM trackborrowedbooks WHERE `Condition` = ?";
                pst = con.prepareStatement(query);
                String condition = selectedType.equals("Undamaged Books") ? "Undamaged" : "Damaged";
                pst.setString(1, condition);
            }

            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) Table2.getModel();
            model.setRowCount(0); // Clear previous data

            while (rs.next()) {
                int id = rs.getInt("ID");
                String bookTitle = rs.getString("Book Title");
                String borrowerName = rs.getString("Borrower Name");
                String email = rs.getString("Email");
                String dueDate = rs.getString("Due Date");
                String status = rs.getString("Status");
                String condition = rs.getString("Condition");

                model.addRow(new Object[]{id, bookTitle, borrowerName, email, dueDate, status, condition});
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    
    
public class BookTypeSelector extends JFrame {

    private JComboBox<String> bookTypeComboBox;
    private JLabel lblTotalBooks;
    private JTable Table2;

    public BookTypeSelector() {
        // Frame setup
        setTitle("Book Type Selector");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Vector of book types
        Vector<String> bookTypes = new Vector<>();
        bookTypes.add("All");
        bookTypes.add("Undamaged Books");
        bookTypes.add("Damaged Books");

        // Combo box
        bookTypeComboBox = new JComboBox<>(bookTypes);
        add(bookTypeComboBox);

        lblTotalBooks = new JLabel("Total Books: ");
        add(lblTotalBooks);

        // Table setup
        Table2 = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Book Title", "Borrower Name", "Email", "Due Date", "Status", "Condition"}, 0
        ));
        add(new JScrollPane(Table2));

        // Action listener for selection
        bookTypeComboBox.addActionListener(this::bookTypeComboBoxActionPerformed);

        // Initial display
        displayTotalBooks();
        filterBooksByType();
    }

    

    // When combo box is changed
    private void bookTypeComboBoxActionPerformed(ActionEvent evt) {
        String selectedType = (String) bookTypeComboBox.getSelectedItem();
        System.out.println("Selected Book Type: " + selectedType);
        saveBookTypeToDatabase(selectedType);
        displayTotalBooks();
        filterBooksByType();
    }

    // Save selected book type to database
    private void saveBookTypeToDatabase(String bookType) {
        String url = "jdbc:mysql://localhost:3306/library2";
        String user = "root";
        String pass = "";

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String query = "INSERT INTO book_types (type) VALUES (?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, bookType);
            pst.executeUpdate();
            System.out.println("Book type saved to database.");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

   public void main(String[] args) {
    SwingUtilities.invokeLater(() -> new BookTypeSelector().setVisible(true));
}
}











public class StatusComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Status Selector");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // ComboBox with status options
        String[] statuses = {"Borrowed", "Overdue", "Returned"};
        JComboBox<String> statusComboBox = new JComboBox<>(statuses);
        statusComboBox.setBounds(30, 20, 100, 25);

        // TextField to display the selected status
        JTextField statusTextField = new JTextField();
        statusTextField.setBounds(150, 20, 100, 25);

        // Action listener to update the text field when selection changes
        statusComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedStatus = (String) statusComboBox.getSelectedItem();
                statusTextField.setText(selectedStatus);
            }
        });

        // Add components to frame
        frame.add(statusComboBox);
        frame.add(statusTextField);

        frame.setVisible(true);
    }
}
 
 
public class ConditionComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Condition Selector");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // ComboBox with condition options
        String[] conditions = {"Undamaged", "Damaged"};
        JComboBox<String> ConditionComboBox = new JComboBox<>(conditions);
        ConditionComboBox.setBounds(30, 20, 100, 25);

        // TextField to display the selected condition
        JTextField conditionTextField = new JTextField();
        conditionTextField.setBounds(150, 20, 100, 25);

        // Action listener to update the text field when selection changes
        ConditionComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCondition = (String) ConditionComboBox.getSelectedItem();
                conditionTextField.setText(" " + selectedCondition);
            }
        });

        // Add components to frame
        frame.add(ConditionComboBox);
        frame.add(conditionTextField);

        frame.setVisible(true);
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
        Dashboardss = new javax.swing.JButton();
        Settings = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Total = new javax.swing.JButton();
        searchData1 = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        BookTitle = new javax.swing.JTextField();
        save2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        DueDate = new javax.swing.JTextField();
        BorrowerName = new javax.swing.JTextField();
        delete2 = new javax.swing.JButton();
        update2 = new javax.swing.JButton();
        clear2 = new javax.swing.JButton();
        bookTypeComboBox = new javax.swing.JComboBox<>();
        lblTotalBooks = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        Condition = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Status = new javax.swing.JTextField();
        StatusComboBox = new javax.swing.JComboBox<>();
        ConditionComboBox = new javax.swing.JComboBox<>();
        Managebooks1 = new javax.swing.JButton();
        Bookissuerequest = new javax.swing.JButton();
        Manageusersss = new javax.swing.JButton();
        Reports = new javax.swing.JButton();

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
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

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
        jLabel1.setText("Book bridge");

        Dashboardss.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dashboardss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard (3).png"))); // NOI18N
        Dashboardss.setText("Dashboard");
        Dashboardss.setBorderPainted(false);
        Dashboardss.setContentAreaFilled(false);
        Dashboardss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardssActionPerformed(evt);
            }
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 43, 92));
        jLabel2.setText("Manage Books");

        Total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Total.setForeground(new java.awt.Color(24, 43, 92));
        Total.setText("Total Books");
        Total.setContentAreaFilled(false);
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Book Title", "Borrower Name", "Borrowed Date", "Due Date", "Email", "Status", "Condition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table2);
        if (Table2.getColumnModel().getColumnCount() > 0) {
            Table2.getColumnModel().getColumn(2).setResizable(false);
            Table2.getColumnModel().getColumn(7).setResizable(false);
        }

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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Email:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Borrower Name:");

        DueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DueDateActionPerformed(evt);
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

        bookTypeComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookTypeComboBox.setForeground(new java.awt.Color(0, 0, 102));
        bookTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Undamaged Books", "Damaged Books", " ", " " }));
        bookTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTypeComboBoxActionPerformed(evt);
            }
        });

        lblTotalBooks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotalBooks.setForeground(new java.awt.Color(51, 153, 0));
        lblTotalBooks.setText("label");

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

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Author:");

        Condition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConditionActionPerformed(evt);
            }
        });

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusActionPerformed(evt);
            }
        });

        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Borrowed", "Overdue", "Returned" }));
        StatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusComboBoxActionPerformed(evt);
            }
        });

        ConditionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Undamaged", "Damaged" }));
        ConditionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConditionComboBoxActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Dashboardss, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Managebooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bookissuerequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Manageusersss, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchData1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(search2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(439, 439, 439)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel13)
                                                    .addComponent(StatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ConditionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(100, 100, 100)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Condition, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel12)
                                                            .addComponent(jLabel16))
                                                        .addGap(89, 89, 89)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(BorrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(485, 485, 485))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotalBooks)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRefresh)
                                        .addGap(6, 6, 6)
                                        .addComponent(bookTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(364, 364, 364)
                                .addComponent(save2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clear2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(38, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search2)
                            .addComponent(searchData1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total)
                    .addComponent(lblTotalBooks)
                    .addComponent(bookTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BorrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Condition, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConditionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(Dashboardss, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Managebooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bookissuerequest, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Manageusersss, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void searchData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchData1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchData1ActionPerformed

    private void DashboardssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardssActionPerformed
        JTextField txtLogUsername = null;
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard(txtLogUsername);
        dashboard.setVisible(true);
        dashboard.pack();
        dashboard.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_DashboardssActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
        getTotalBooks();
        Managebooks managebooks = new Managebooks();
        managebooks.setVisible(true);
        managebooks.pack();
        managebooks.setLocationRelativeTo(null);
        this.dispose(); 
        
    }//GEN-LAST:event_TotalActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_save1ActionPerformed

    private void save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2ActionPerformed
        // TODO add your handling code here:
        
        String title, borrower, email, dueDate, status, condition;

try {
    // Load JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Establish connection
    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";
    Connection con = DriverManager.getConnection(url, user, pass);

    // Input validation
    if (BookTitle.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Book title is required", "Input Error", JOptionPane.ERROR_MESSAGE);
    } else if (BorrowerName.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Borrower name is required", "Input Error", JOptionPane.ERROR_MESSAGE);
    } else if (Email.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Email is required", "Input Error", JOptionPane.ERROR_MESSAGE);
    } else if (DueDate.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Due date is required", "Input Error", JOptionPane.ERROR_MESSAGE);
    } else if (Status.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Status is required", "Input Error", JOptionPane.ERROR_MESSAGE);
    } else if (Condition.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Condition is required", "Input Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Collect data
        title = BookTitle.getText().trim();
        borrower = BorrowerName.getText().trim();
        email = Email.getText().trim();
        dueDate = DueDate.getText().trim();
        status = Status.getText().trim();
        condition = Condition.getText().trim();

        // Prepare SQL query
        String query = "INSERT INTO trackborrowedbooks (`Book Title`, `Borrower Name`, `Email`, `Due Date`, `Status`, `Condition`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, title);
        pst.setString(2, borrower);
        pst.setString(3, email);
        pst.setString(4, dueDate);
        pst.setString(5, status);
        pst.setString(6, condition);

        // Execute insert
        pst.executeUpdate();

        // Clear fields
        BookTitle.setText("");
        BorrowerName.setText("");
        Email.setText("");
        DueDate.setText("");
        Status.setText("");
        Condition.setText("");

        // Notify user
        JOptionPane.showMessageDialog(this, "Book successfully registered!");

        // Optional: Reload data table
        loadData();

        pst.close();
        con.close();
    }

} catch (HeadlessException | ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}

    }//GEN-LAST:event_save2ActionPerformed
    
    private void delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2ActionPerformed
        // TODO add your handling code here:
        try {
    // Load MySQL JDBC Driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    String ID = searchData1.getText().trim();

    if (ID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter an ID", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int userID;
    try {
        userID = Integer.parseInt(ID);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID must be a numeric value", "Format Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the record exists
    String checkQuery = "SELECT * FROM trackborrowedbooks WHERE id = ?";
    PreparedStatement checkStmt = con.prepareStatement(checkQuery);
    checkStmt.setInt(1, userID);
    ResultSet rs = checkStmt.executeQuery();

    if (!rs.next()) {
        JOptionPane.showMessageDialog(this, "No book found with the given ID", "Not Found", JOptionPane.ERROR_MESSAGE);
        rs.close();
        checkStmt.close();
        con.close();
        return;
    }

    rs.close();
    checkStmt.close();

    // Delete the record
    String deleteQuery = "DELETE FROM trackborrowedbooks WHERE id = ?";
    PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
    deleteStmt.setInt(1, userID);

    int rowsDeleted = deleteStmt.executeUpdate();
    deleteStmt.close();
    con.close();

    if (rowsDeleted > 0) {
        JOptionPane.showMessageDialog(this, "Book deleted successfully!");
        loadData(); // Refresh table after deletion
    } else {
        JOptionPane.showMessageDialog(this, "Failed to delete book", "Delete Error", JOptionPane.ERROR_MESSAGE);
    }

} catch (ClassNotFoundException e) {
    JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found", "Driver Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
    }//GEN-LAST:event_delete2ActionPerformed

    private void update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update2ActionPerformed
        // TODO add your handling code here:
       String title, borrower, email, dueDate, status, condition;

try {
    // Load MySQL JDBC Driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Database connection
    String url = "jdbc:mysql://localhost:3306/library"; // ✅ Make sure this matches your actual DB name!
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    // Get the ID to update
    String IDStr = searchData1.getText().trim();

    if (IDStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int userID;
    try {
        userID = Integer.parseInt(IDStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid ID format!", "Format Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the record exists
    String checkQuery = "SELECT * FROM trackborrowedbooks WHERE id = ?";
    PreparedStatement checkStmt = con.prepareStatement(checkQuery);
    checkStmt.setInt(1, userID);
    ResultSet rs = checkStmt.executeQuery();

    if (!rs.next()) {
        JOptionPane.showMessageDialog(this, "No record found with this ID", "Not Found", JOptionPane.ERROR_MESSAGE);
        rs.close();
        checkStmt.close();
        con.close();
        return;
    }
    rs.close();
    checkStmt.close();

    // Collect updated values
    title = BookTitle.getText().trim();
    borrower = BorrowerName.getText().trim();
    email = Email.getText().trim();
    dueDate = DueDate.getText().trim();
    status = Status.getText().trim();
    condition = Condition.getText().trim();

    if (title.isEmpty() || borrower.isEmpty() || email.isEmpty() || dueDate.isEmpty() || status.isEmpty() || condition.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
        con.close();
        return;
    }

    // Update the record
    String sqlUpdate = "UPDATE trackborrowedbooks SET `Book Title` = ?, `Borrower Name` = ?, `Email` = ?, `Due Date` = ?, `Status` = ?, `Condition` = ? WHERE id = ?";
    PreparedStatement pst = con.prepareStatement(sqlUpdate);
    pst.setString(1, title);
    pst.setString(2, borrower);
    pst.setString(3, email);
    pst.setString(4, dueDate);
    pst.setString(5, status);
    pst.setString(6, condition);
    pst.setInt(7, userID);

    int rowsUpdated = pst.executeUpdate();
    pst.close();
    con.close();

    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(this, "Record updated successfully!");
        loadData(); // Refresh the table
    } else {
        JOptionPane.showMessageDialog(this, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
    }

} catch (ClassNotFoundException e) {
    JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found", "Driver Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}

    }//GEN-LAST:event_update2ActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        // TODO add your handling code here:
        BookTitle.setText("");
        BorrowerName.setText("");
        Email.setText("");
        DueDate.setText("");
        Status.setText("");
        Condition.setText("");
    }//GEN-LAST:event_clear2ActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
    String ID;

try {
    // Load MySQL JDBC Driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // ✅ Correct database name - assuming 'library2' is the DB, not 'Trackborrowedbooks'
    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String pass = "";

    // Establish connection
    Connection con = DriverManager.getConnection(url, user, pass);

    // Get ID from input
    ID = searchData1.getText().trim();

    if (ID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID is required", "Input Error", JOptionPane.ERROR_MESSAGE);
        con.close();
        return;
    }

    int userID;
    try {
        userID = Integer.parseInt(ID); // Validate ID as integer
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID must be a valid number!", "Format Error", JOptionPane.ERROR_MESSAGE);
        con.close();
        return;
    }

    // Prepare SQL statement
    String sql = "SELECT * FROM trackborrowedbooks WHERE id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, userID);
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        // ✅ Populate the form fields with data from DB
        BookTitle.setText(rs.getString("Book Title"));
        BorrowerName.setText(rs.getString("Borrower Name"));
        Email.setText(rs.getString("Email"));
        DueDate.setText(rs.getString("Due Date"));
        Status.setText(rs.getString("Status"));
        Condition.setText(rs.getString("Condition"));
    } else {
        JOptionPane.showMessageDialog(this, "No record found with this ID", "Not Found", JOptionPane.ERROR_MESSAGE);
    }

    // Cleanup
    rs.close();
    pst.close();
    con.close();

} catch (ClassNotFoundException e) {
    JOptionPane.showMessageDialog(this, "JDBC Driver not found", "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
    }//GEN-LAST:event_search2ActionPerformed

    private void bookTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTypeComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedType = bookTypeComboBox.getSelectedItem().toString();
        System.out.println("Selected Book Type: " + selectedType);
        filterBooksByType();
    }//GEN-LAST:event_bookTypeComboBoxActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        displayTotalBooks();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void ConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConditionActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusActionPerformed

    private void StatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedStatus = (String) StatusComboBox.getSelectedItem();
        Status.setText(" " + selectedStatus);
    }//GEN-LAST:event_StatusComboBoxActionPerformed

    private void ConditionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConditionComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedStatus = (String) ConditionComboBox.getSelectedItem();
        Condition.setText(" " + selectedStatus);
    }//GEN-LAST:event_ConditionComboBoxActionPerformed

    private void DueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DueDateActionPerformed
        // TODO add your handling code here:                                 
    try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dueDateText = DueDate.getText().trim();
        LocalDate dueDate = LocalDate.parse(dueDateText, formatter);
        LocalDate today = LocalDate.now();

        if (!today.isBefore(dueDate)) {
            JOptionPane.showMessageDialog(this,
                "Reminder: This item is due today or overdue!",
                "Due Date Alert",
                JOptionPane.WARNING_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(this,
                "This item is not due yet.",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Invalid date format. Please use yyyy-MM-dd.",
            "Date Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    }//GEN-LAST:event_DueDateActionPerformed

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
        Reports reports = new Reports();
        reports.setVisible(true);
        reports.pack();
        reports.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ManageusersssActionPerformed

    private void ReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsActionPerformed
        // TODO add your handling code here:
        Reports reports = new Reports();
        reports.setVisible(true);
        reports.pack();
        reports.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ReportsActionPerformed

    private void Managebooks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Managebooks1ActionPerformed
        // TODO add your handling code here:
        Managebooks managebooks = new Managebooks();
        managebooks.setVisible(true);
        managebooks.pack();
        managebooks.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Managebooks1ActionPerformed

   public void loadData() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // ✅ Correct database name and credentials
        String url = "jdbc:mysql://localhost:3306/library"; 
        String user = "root";
        String pass = "";

        // Establish connection
        con = DriverManager.getConnection(url, user, pass);
        st = con.createStatement();

        // Query the table
        String sql = "SELECT * FROM trackborrowedbooks";
        rs = st.executeQuery(sql);

        // Get column metadata
        java.sql.ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Non-editable table model
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Add column names to model
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnLabel(i));
        }

        // Populate rows
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            model.addRow(rowData);
        }

        // Set model to your JTable
        Table2.setModel(model);

    } catch (ClassNotFoundException | SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
        // Close resources safely
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage(), "Cleanup Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trackborrowedbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trackborrowedbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trackborrowedbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trackborrowedbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trackborrowedbooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookTitle;
    private javax.swing.JButton Bookissuerequest;
    private javax.swing.JTextField BorrowerName;
    private javax.swing.JTextField Condition;
    private javax.swing.JComboBox<String> ConditionComboBox;
    private javax.swing.JButton Dashboardss;
    private javax.swing.JTextField DueDate;
    private javax.swing.JTextField Email;
    private javax.swing.JButton Managebooks1;
    private javax.swing.JButton Manageusersss;
    private javax.swing.JButton Reports;
    private javax.swing.JButton Settings;
    private javax.swing.JTextField Status;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JTable Table2;
    private javax.swing.JButton Total;
    private javax.swing.JTextField author;
    private javax.swing.JComboBox<String> bookTypeComboBox;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton clear1;
    private javax.swing.JButton clear2;
    private javax.swing.JTextField collectiontype;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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

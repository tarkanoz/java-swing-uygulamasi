import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class demo extends javax.swing.JFrame {
    DefaultTableModel model;

    /**
     * Creates new form demo
     */
    public demo() {
        initComponents();
        populeteTable();
        
    }
    
    public void populeteTable(){
    
       model = (DefaultTableModel)tblCities.getModel();
       model.setRowCount(0);
        try {
            ArrayList<City> cities = getCities();
            for(City city : cities){
               Object[] row ={city.getId(),city.getName(),city.getCountryCode(),city.getDistrict(),city.getPopulation()};
               model.addRow(row);
            }
        } catch (SQLException ex) {
            
        }
    
    }
    
    public ArrayList<City> getCities() throws SQLException{
    
      Connection connection = null;
      DbHelper dbHelper = new DbHelper();
      Statement statement = null;
      ResultSet resultSet;
      ArrayList<City> cities = null;
              
      try {
      
        connection = dbHelper.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from City");
        cities = new ArrayList<City>();
        while(resultSet.next()){
           cities.add(new City(
                   resultSet.getInt("ID"),
                   resultSet.getString("Name"),
                   resultSet.getString("CountryCode"),
                   resultSet.getString("District"),
                   resultSet.getInt("Population")
           ));
        }
      }
      catch(SQLException exception){
         dbHelper.showErrorMessage(exception);
      }
      finally{
          statement.close();
          connection.close();
      }
        return cities;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCities = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCountryCode = new javax.swing.JLabel();
        lblDistrict = new javax.swing.JLabel();
        lblPopulation = new javax.swing.JLabel();
        tbxName = new javax.swing.JTextField();
        tbxCountryCode = new javax.swing.JTextField();
        tbxDistrict = new javax.swing.JTextField();
        tbxPopulation = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCities.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "CountryCode", "District", "Population"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCities);
        if (tblCities.getColumnModel().getColumnCount() > 0) {
            tblCities.getColumnModel().getColumn(0).setResizable(false);
            tblCities.getColumnModel().getColumn(1).setResizable(false);
            tblCities.getColumnModel().getColumn(2).setResizable(false);
            tblCities.getColumnModel().getColumn(3).setResizable(false);
            tblCities.getColumnModel().getColumn(4).setResizable(false);
        }

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSearch.setText("Arama ifadesi :");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Şehir İsmi");

        lblCountryCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCountryCode.setText("Ülke Kodu");

        lblDistrict.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDistrict.setText("Bölge");

        lblPopulation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPopulation.setText("Nüfus");

        tbxName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbxCountryCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbxDistrict.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbxPopulation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Ekle");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblCountryCode))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbxName)
                    .addComponent(tbxCountryCode, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDistrict)
                            .addComponent(lblPopulation))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbxDistrict)
                            .addComponent(tbxPopulation, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblDistrict)
                    .addComponent(tbxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCountryCode)
                            .addComponent(tbxCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPopulation)
                            .addComponent(tbxPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
         String searchKey = txtSearch.getText();
         TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model);
         tblCities.setRowSorter(tableRowSorter);
         tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection connection = null;
      DbHelper dbHelper = new DbHelper();
      PreparedStatement statement = null;
      
      try{
        connection = dbHelper.getConnection();
        String sql = "insert into city(Name,CountryCode,District,Population) values(?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1,tbxName.getText());
        statement.setString(2,tbxCountryCode.getText());
        statement.setString(3,tbxDistrict.getText());
        statement.setInt(4,Integer.valueOf(tbxPopulation.getText()));
        int result = statement.executeUpdate();
        populeteTable();
      }
      catch(SQLException exception){
        dbHelper.showErrorMessage(exception);
      }
      finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                
            }
      }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountryCode;
    private javax.swing.JLabel lblDistrict;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPopulation;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblCities;
    private javax.swing.JTextField tbxCountryCode;
    private javax.swing.JTextField tbxDistrict;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField tbxPopulation;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

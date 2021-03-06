package view;

import dao.HoaDonChiTietDAO;
import dao.HoaDonDAO;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonChiTiet;
import utils.DBUtils;

/**
 *
 * @author Hoang
 */
public class Panel_DoanhThu extends javax.swing.JPanel {

    /**
     * Creates new form panel_san_pham
     */
    public Panel_DoanhThu() {
        initComponents();
    }

    public void setdata(){
        modelDoanhThuThang.addColumn("STT");
        modelDoanhThuThang.addColumn("Mã Sản Phẩm");
        modelDoanhThuThang.addColumn("Tên Sản Phẩm");
        modelDoanhThuThang.addColumn("Hãng Sản Xuất");
        modelDoanhThuThang.addColumn("Số Lượng Bán Được");
        modelDoanhThuThang.addColumn("Doanh Thu Theo Sản Phẩm");
        
        cbo_year.setModel(modelYear);
        cbo_month.setModel(modelMonth);
        tbl_DoanhThuThang.setModel(modelDoanhThuThang);
        
        loadTime();
        txt_total.setEditable(false);
    }
    
    public void loadTime(){
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        modelMonth.removeAllElements();
        for (int i = 1; i <= 12; i++) {
            modelMonth.addElement(String.valueOf(i));
        }
        List<Integer> listYear = hoaDonDAO.getListYear();
        if(listYear.isEmpty()){
            listYear.add(currentYear);
        } 
        
        modelYear.removeAllElements();
        listYear.forEach(year -> {
            modelYear.addElement(String.valueOf(year));
        });
        cbo_month.setSelectedItem(String.valueOf(currentMonth));
        
        loadDoanhThuThang(currentMonth, currentYear);
    }
    
    private void loadDoanhThuThang(int month, int year){
        total = 0;
        modelDoanhThuThang.setRowCount(0);
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement pst = connection.prepareStatement("exec loadDoanhThuThang ?, ?");
            pst.setInt(1, year);
            pst.setInt(2, month);
            ResultSet rs = pst.executeQuery();
            int stt = 1;
            while (rs.next()) {                
                int doanhthuSP = rs.getInt("doanhThuSP");
                total+=doanhthuSP;
                Vector row = new Vector();
                row.add(stt++);
                row.add(rs.getString("maSanPham"));
                row.add(rs.getString("tenSanPham"));
                row.add(rs.getString("tenHangSanXuat"));
                row.add(rs.getInt("soLuong"));
                row.add(Panel_DonHang.format(doanhthuSP));
                modelDoanhThuThang.addRow(row);
            }
            txt_total.setText(Panel_DonHang.format(total));
        } catch (Exception e) {
            System.out.println(e);
        }
//        if(!listHoaDon.isEmpty()){
//            try {
//                tbl_HoaDon.setRowSelectionInterval(listHoaDon.size()-1, listHoaDon.size()-1);
//            } catch (Exception e) {}
//        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DoanhThuThang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbo_year = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbo_month = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();

        tbl_DoanhThuThang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tbl_DoanhThuThang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Hãng Sản Xuất", "Số Lượng Bán Được", "Doanh Thu Theo Sản Phẩm"
            }
        ));
        tbl_DoanhThuThang.setRowHeight(20);
        tbl_DoanhThuThang.getTableHeader().setFont(new Font("Dialog", 0, 14));
        jScrollPane2.setViewportView(tbl_DoanhThuThang);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("DOANH THU THEO THÁNG");

        cbo_year.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        cbo_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2018" }));
        cbo_year.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_yearItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jLabel3.setText("Năm");

        cbo_month.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        cbo_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1" }));
        cbo_month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_monthItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jLabel4.setText("Tháng");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Tổng doanh thu theo tháng: ");

        txt_total.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_total.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(295, 295, 295)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_month, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbo_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_monthItemStateChanged
        // TODO add your handling code here:
        try {
            int month = Integer.valueOf(cbo_month.getSelectedItem().toString());
            int year = Integer.valueOf(cbo_year.getSelectedItem().toString());

            loadDoanhThuThang(month, year);
        } catch (NullPointerException n) {
        } catch (Exception e4) {
            System.out.println(e4);
        }
    }//GEN-LAST:event_cbo_monthItemStateChanged

    private void cbo_yearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_yearItemStateChanged
        // TODO add your handling code here:
        try {
            int month = Integer.valueOf(cbo_month.getSelectedItem().toString());
            int year = Integer.valueOf(cbo_year.getSelectedItem().toString());

            loadDoanhThuThang(month, year);
        } catch (NullPointerException n) {
        } catch (Exception e4) {
            System.out.println(e4);
        }
    }//GEN-LAST:event_cbo_yearItemStateChanged

    
    
    
    DefaultTableModel modelDoanhThuThang = new DefaultTableModel();
    DefaultComboBoxModel<String> modelMonth = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> modelYear = new DefaultComboBoxModel<>();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    
    List<HoaDon> listHoaDon = new ArrayList<>();
    List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
    
    HoaDonDAO hoaDonDAO = new HoaDonDAO();
    HoaDonChiTietDAO hoaDonChiTietDAO = new HoaDonChiTietDAO();
    
    int indexDoanhThuThang = -1;
    int temp_indexDoanhThuThang = -1;
    int total = 0;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_month;
    private javax.swing.JComboBox<String> cbo_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_DoanhThuThang;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}

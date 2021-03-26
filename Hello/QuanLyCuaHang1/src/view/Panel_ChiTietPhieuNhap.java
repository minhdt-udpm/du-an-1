package view;

import dao.PhieuNhapChiTietDAO;
import dao.PhieuNhapDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import model.PhieuNhap;
import model.PhieuNhapChiTiet;

/**
 *
 * @author Hoang
 */
public class Panel_ChiTietPhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form panel_san_pham
     */
    public Panel_ChiTietPhieuNhap() {
        initComponents();
    }

    public void setdata(){
        modelPhieuNhap.addColumn("Mã Phiếu Nhập");
        modelPhieuNhap.addColumn("Nhân Viên");
        modelPhieuNhap.addColumn("Nhà Phân Phối");
        modelPhieuNhap.addColumn("Tổng Tiền");
        modelPhieuNhap.addColumn("Ngày Lập");
        modelPhieuNhap.addColumn("Ghi Chú");
        
        modelPhieuNhapChiTiet.addColumn("STT");
        modelPhieuNhapChiTiet.addColumn("Mã Sản Phẩm");
        modelPhieuNhapChiTiet.addColumn("Tên Sản Phẩm");
        modelPhieuNhapChiTiet.addColumn("Hãng Sản Xuất");
        modelPhieuNhapChiTiet.addColumn("Giá Nhập");
        modelPhieuNhapChiTiet.addColumn("Số Lượng");
        modelPhieuNhapChiTiet.addColumn("Thành Tiền");
        
        cbo_year.setModel(modelYear);
        cbo_month.setModel(modelMonth);
        tbl_PhieuNhap.setModel(modelPhieuNhap);
        tbl_HoaDonChiTiet.setModel(modelPhieuNhapChiTiet);
        
        tbl_PhieuNhap.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            indexPhieuNhap = tbl_PhieuNhap.getSelectedRow();
            if(indexPhieuNhap>=0){
                int maPhieuNhap = listPhieuNhap.get(indexPhieuNhap).getMaPhieuNhap();
                loadPhieuNhapChiTiet(maPhieuNhap);
            } 
        });
        
        loadTime();
        
    }
    
    public void loadTime(){
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        modelMonth.removeAllElements();
        for (int i = 1; i <= 12; i++) {
            modelMonth.addElement(String.valueOf(i));
        }
        List<Integer> listYear = phieuNhapDAO.getListYear();
        if(listYear.isEmpty()){
            listYear.add(currentYear);
        }
        
        modelYear.removeAllElements();
        listYear.forEach(year -> {
            modelYear.addElement(String.valueOf(year));
        });
        cbo_month.setSelectedItem(String.valueOf(currentMonth));
        
        loadPhieuNhap(currentMonth, currentYear);
    }
    
    private void loadPhieuNhap(int month, int year){
        listPhieuNhapChiTiet.clear();
        modelPhieuNhapChiTiet.setRowCount(0);
        listPhieuNhap.clear();
        modelPhieuNhap.setRowCount(0);
        listPhieuNhap = phieuNhapDAO.getList(month, year);
        listPhieuNhap.forEach(hoaDon -> {
            Vector row = new Vector();
            row.add(hoaDon.getMaPhieuNhap());
            row.add(hoaDon.getNhanVien().getTaiKhoan());
            row.add(hoaDon.getNhaPhanPhoi().getTenNhaPhanPhoi());
            row.add(Panel_DonHang.format(hoaDon.getTongTien()));
            row.add(format.format(hoaDon.getNgayNhap()));
            row.add(hoaDon.getGhiChu());
            modelPhieuNhap.addRow(row);
        });
        if(!listPhieuNhap.isEmpty()){
            try {
                tbl_PhieuNhap.setRowSelectionInterval(listPhieuNhap.size()-1, listPhieuNhap.size()-1);
            } catch (Exception e) {}
        }
    }
    
    private void loadPhieuNhapChiTiet(int maPhieuNhap){
        listPhieuNhapChiTiet.clear();
        modelPhieuNhapChiTiet.setRowCount(0);
        
        int stt = 1;
        listPhieuNhapChiTiet = phieuNhapChiTietDAO.getList(maPhieuNhap);
        for (PhieuNhapChiTiet phieuNhapChiTiet : listPhieuNhapChiTiet) {
            int soLuong = phieuNhapChiTiet.getSoLuong();
            int giaNhap = phieuNhapChiTiet.getTongTien()/soLuong;
            Vector row = new Vector();
            row.add(stt++);
            row.add(phieuNhapChiTiet.getSanPham().getMaSanPham());
            row.add(phieuNhapChiTiet.getSanPham().getTenSanPham());
            row.add(phieuNhapChiTiet.getSanPham().getHangSanXuat().getTenHangSanXuat());
            row.add(Panel_DonHang.format(giaNhap));
            row.add(phieuNhapChiTiet.getSoLuong());
            row.add(Panel_DonHang.format(giaNhap*soLuong));
            modelPhieuNhapChiTiet.addRow(row);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_PhieuNhap = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HoaDonChiTiet = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbo_year = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbo_month = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        tbl_PhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Nhập", "Nhân Viên", "Tên Nhà Phân Phối", "Tổng Tiền", "Ngày Lập", "Ghi Chú"
            }
        ));
        jScrollPane1.setViewportView(tbl_PhieuNhap);

        tbl_HoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Hãng Sản Xuất", "Giá Nhập", "Số Lượng", "Thành TIền"
            }
        ));
        jScrollPane2.setViewportView(tbl_HoaDonChiTiet);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH PHIẾU NHẬP");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("DANH SÁCH CHI TIẾT SẢN PHẨM");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 545, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(513, 513, 513))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(291, 291, 291)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_month, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_monthItemStateChanged
        // TODO add your handling code here:
        try {
            int month = Integer.valueOf(cbo_month.getSelectedItem().toString());
            int year = Integer.valueOf(cbo_year.getSelectedItem().toString());

            loadPhieuNhap(month, year);
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

            loadPhieuNhap(month, year);
        } catch (NullPointerException n) {
        } catch (Exception e4) {
            System.out.println(e4);
        }
    }//GEN-LAST:event_cbo_yearItemStateChanged

    
    
    
    DefaultTableModel modelPhieuNhap = new DefaultTableModel();
    DefaultTableModel modelPhieuNhapChiTiet = new DefaultTableModel();
    DefaultComboBoxModel<String> modelMonth = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> modelYear = new DefaultComboBoxModel<>();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    
    List<PhieuNhap> listPhieuNhap = new ArrayList<>();
    List<PhieuNhapChiTiet> listPhieuNhapChiTiet = new ArrayList<>();
    
    PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    PhieuNhapChiTietDAO phieuNhapChiTietDAO = new PhieuNhapChiTietDAO();
    
    int indexPhieuNhap = -1;
    int temp_indexPhieuNhap = -1;
    int indexPhieuNhapChiTiet = -1;
    int temp_indexPhieuNhapChiTiet = -1;

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_month;
    private javax.swing.JComboBox<String> cbo_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_HoaDonChiTiet;
    private javax.swing.JTable tbl_PhieuNhap;
    // End of variables declaration//GEN-END:variables
}
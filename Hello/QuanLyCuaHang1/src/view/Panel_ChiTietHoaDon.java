package view;

import dao.HoaDonChiTietDAO;
import dao.HoaDonDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonChiTiet;

/**
 *
 * @author Hoang
 */
public class Panel_ChiTietHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form panel_san_pham
     */
    public Panel_ChiTietHoaDon() {
        initComponents();
    }

    public void setdata(){
        modelHoaDon.addColumn("Mã Hóa Đơn");
        modelHoaDon.addColumn("Nhân Viên");
        modelHoaDon.addColumn("Khách Hàng");
        modelHoaDon.addColumn("Tổng Tiền");
        modelHoaDon.addColumn("Ngày Lập");
        modelHoaDon.addColumn("Ghi Chú");
        
        modelHoaDonChiTiet.addColumn("STT");
        modelHoaDonChiTiet.addColumn("Mã Sản Phẩm");
        modelHoaDonChiTiet.addColumn("Tên Sản Phẩm");
        modelHoaDonChiTiet.addColumn("Hãng Sản Xuất");
        modelHoaDonChiTiet.addColumn("Giá Bán");
        modelHoaDonChiTiet.addColumn("Số Lượng");
        modelHoaDonChiTiet.addColumn("Thành Tiền");
        
        cbo_year.setModel(modelYear);
        cbo_month.setModel(modelMonth);
        tbl_HoaDon.setModel(modelHoaDon);
        tbl_HoaDonChiTiet.setModel(modelHoaDonChiTiet);
        
        tbl_HoaDon.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            indexHoaDon = tbl_HoaDon.getSelectedRow();
            if(indexHoaDon>=0){
                int maHoaDon = listHoaDon.get(indexHoaDon).getMaHoaDon();
                loadHoaDonChiTiet(maHoaDon);
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
        List<Integer> listYear = hoaDonDAO.getListYear();
        if(listYear.isEmpty()){
            listYear.add(currentYear);
        } 
        
        modelYear.removeAllElements();
        listYear.forEach(year -> {
            modelYear.addElement(String.valueOf(year));
        });
        cbo_month.setSelectedItem(String.valueOf(currentMonth));
        
        loadHoaDon(currentMonth, currentYear);
    }
    
    private void loadHoaDon(int month, int year){
        listHoaDonChiTiet.clear();
        modelHoaDonChiTiet.setRowCount(0);
        listHoaDon.clear();
        modelHoaDon.setRowCount(0);
        listHoaDon = hoaDonDAO.getList(month, year);
        listHoaDon.forEach(hoaDon -> {
            Vector row = new Vector();
            row.add(hoaDon.getMaHoaDon());
            row.add(hoaDon.getNhanVien().getTaiKhoan());
            row.add(hoaDon.getKhachHang().getTenKhachHang());
            row.add(Panel_DonHang.format(hoaDon.getTongTien()));
            row.add(format.format(hoaDon.getNgayLapHoaDon()));
            row.add(hoaDon.getGhiChu());
            modelHoaDon.addRow(row);
        });
        if(!listHoaDon.isEmpty()){
            try {
                tbl_HoaDon.setRowSelectionInterval(listHoaDon.size()-1, listHoaDon.size()-1);
            } catch (Exception e) {}
        }
    }
    
    private void loadHoaDonChiTiet(int maHoaDon){
        listHoaDonChiTiet.clear();
        modelHoaDonChiTiet.setRowCount(0);
        
        int stt = 1;
        listHoaDonChiTiet = hoaDonChiTietDAO.getList(maHoaDon);
        for (HoaDonChiTiet hoaDonChiTiet : listHoaDonChiTiet) {
            int soLuong = hoaDonChiTiet.getSoLuong();
            int giaBan = hoaDonChiTiet.getTongTien()/soLuong;
            Vector row = new Vector();
            row.add(stt++);
            row.add(hoaDonChiTiet.getSanPham().getMaSanPham());
            row.add(hoaDonChiTiet.getSanPham().getTenSanPham());
            row.add(hoaDonChiTiet.getSanPham().getHangSanXuat().getTenHangSanXuat());
            row.add(Panel_DonHang.format(giaBan));
            row.add(hoaDonChiTiet.getSoLuong());
            row.add(Panel_DonHang.format(giaBan*soLuong));
            modelHoaDonChiTiet.addRow(row);
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
        tbl_HoaDon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HoaDonChiTiet = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbo_year = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbo_month = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        tbl_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Nhân Viên", "Tên Khách Hàng", "Tổng Tiền", "Ngày Lập", "Ghi Chú"
            }
        ));
        jScrollPane1.setViewportView(tbl_HoaDon);

        tbl_HoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Hãng Sản Xuất", "Giá Bán", "Số Lượng", "Thành Tiền"
            }
        ));
        jScrollPane2.setViewportView(tbl_HoaDonChiTiet);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH HÓA ĐƠN");

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
                .addGap(315, 315, 315)
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

            loadHoaDon(month, year);
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

            loadHoaDon(month, year);
        } catch (NullPointerException n) {
        } catch (Exception e4) {
            System.out.println(e4);
        }
    }//GEN-LAST:event_cbo_yearItemStateChanged

    
    
    
    DefaultTableModel modelHoaDon = new DefaultTableModel();
    DefaultTableModel modelHoaDonChiTiet = new DefaultTableModel();
    DefaultComboBoxModel<String> modelMonth = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> modelYear = new DefaultComboBoxModel<>();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    
    List<HoaDon> listHoaDon = new ArrayList<>();
    List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
    
    HoaDonDAO hoaDonDAO = new HoaDonDAO();
    HoaDonChiTietDAO hoaDonChiTietDAO = new HoaDonChiTietDAO();
    
    int indexHoaDon = -1;
    int temp_indexHoaDon = -1;
    int indexHoaDonChiTiet = -1;
    int temp_indexHoaDonChiTiet = -1;

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_month;
    private javax.swing.JComboBox<String> cbo_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_HoaDon;
    private javax.swing.JTable tbl_HoaDonChiTiet;
    // End of variables declaration//GEN-END:variables
}
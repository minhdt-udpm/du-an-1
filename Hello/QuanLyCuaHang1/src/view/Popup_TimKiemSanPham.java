
package view;

import dao.SanPhamDAO;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import model.SanPham;

public class Popup_TimKiemSanPham extends javax.swing.JFrame {

    /** Creates new form TimKiemSanPham
     * @param status
     */
    public Popup_TimKiemSanPham(int status) {
        initComponents();
        setLocationRelativeTo(null);
        setdata();
        this.status = status;
    }

    public void setdata(){
        setResizable(false);
        modelSanPham.addColumn("Mã Sp");
        modelSanPham.addColumn("Tên SP");
        modelSanPham.addColumn("Hãng SX");
        modelSanPham.addColumn("Tồn Kho");
        modelSanPham.addColumn("Giá Bán");
        
        tbl_SanPham.setModel(modelSanPham);
        tbl_SanPham.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            indexSanPham = tbl_SanPham.getSelectedRow();
        });
        txt_timKiem.requestFocus();
        
        listSanPham = sanPhamDAO.getList();
        loadModelSanPham();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();
        btn_chonSP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tìm Kiếm theo Mã SP hoặc Tên SP");

        tbl_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Hãng SX", "Tồn Kho", "Giá Bán"
            }
        ));
        tbl_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SanPhamMouseClicked(evt);
            }
        });
        tbl_SanPham.setDefaultEditor(Object.class, null);
        jScrollPane1.setViewportView(tbl_SanPham);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nhập:");

        txt_timKiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyPressed(evt);
            }
        });

        btn_TimKiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/timkiem.png"))); // NOI18N
        btn_TimKiem.setText("Tìm Kiếm");
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });

        btn_chonSP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_chonSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/checked.png"))); // NOI18N
        btn_chonSP.setText("Chọn SP");
        btn_chonSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_TimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(btn_chonSP)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TimKiem)
                    .addComponent(btn_chonSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            timKiem();
        }
    }//GEN-LAST:event_txt_timKiemKeyPressed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        // TODO add your handling code here:
        timKiem();
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void btn_chonSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonSPActionPerformed
        // TODO add your handling code here:
        if(indexSanPham>=0){
            chonSP();
            
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn SP");
        }
    }//GEN-LAST:event_btn_chonSPActionPerformed

    private void tbl_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            chonSP();
        }
    }//GEN-LAST:event_tbl_SanPhamMouseClicked

    private void chonSP() {
        if (status == -1) {
            Panel_DonHang.txt_maSanPham.setText(tbl_SanPham.getValueAt(indexSanPham, 0).toString());
            Panel_DonHang.txt_tenSanPham.setText(tbl_SanPham.getValueAt(indexSanPham, 1).toString());
            Panel_DonHang.txt_loaiSanPham.setText(listSanPham.get(indexSanPham).getLoaiSanPham().getTenLoaiSanPham());
            Panel_DonHang.txt_hangSanXuat.setText(tbl_SanPham.getValueAt(indexSanPham, 2).toString());
            Panel_DonHang.txt_soluong.setText("1");
            Panel_DonHang.txt_soluong.requestFocus();
            Panel_DonHang.txt_soluong.selectAll();
            
        } else if (status == 1){
            Panel_PhieuNhap.txt_maSanPham.setText(tbl_SanPham.getValueAt(indexSanPham, 0).toString());
            Panel_PhieuNhap.txt_tenSanPham.setText(tbl_SanPham.getValueAt(indexSanPham, 1).toString());
            Panel_PhieuNhap.txt_loaiSanPham.setText(listSanPham.get(indexSanPham).getLoaiSanPham().getTenLoaiSanPham());
            Panel_PhieuNhap.txt_hangSanXuat.setText(tbl_SanPham.getValueAt(indexSanPham, 2).toString());
            Panel_PhieuNhap.txt_soluong.setText("1");
            Panel_PhieuNhap.txt_soluong.requestFocus();
            Panel_PhieuNhap.txt_soluong.selectAll();
        }
        
        setVisible(false);
        dispose();
    }
    
    private void timKiem(){
        String text = txt_timKiem.getText().trim();
        if(text.isEmpty()){
            JOptionPane.showMessageDialog(this, "Chưa nhập thông tin SP");
            
        } else {
            listSanPham = sanPhamDAO.timKiem(text);
            loadModelSanPham();
        } 
    }
    
    private void loadModelSanPham() {
        modelSanPham.setRowCount(0);
        listSanPham.forEach(sanPham -> {
            Vector row = new Vector();
            row.add(sanPham.getMaSanPham());
            row.add(sanPham.getTenSanPham());
            row.add(sanPham.getHangSanXuat().getTenHangSanXuat());
            row.add(sanPham.getTonKho());
            row.add(Panel_DonHang.format(sanPham.getGiaBan()));
            modelSanPham.addRow(row);
        });

        try {
            if (modelSanPham.getRowCount() > 0) {
                tbl_SanPham.setRowSelectionInterval(0, 0);
            }
        } catch (Exception e) {}
    }
    
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
            java.util.logging.Logger.getLogger(Popup_TimKiemSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Popup_TimKiemSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Popup_TimKiemSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Popup_TimKiemSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Popup_TimKiemSanPham(0).setVisible(true);
            }
        });
    }

    DefaultTableModel modelSanPham = new DefaultTableModel();
    
    List<SanPham> listSanPham = new ArrayList<>();
    
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    
    int indexSanPham = -1;
    int status = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_chonSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_SanPham;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables

}

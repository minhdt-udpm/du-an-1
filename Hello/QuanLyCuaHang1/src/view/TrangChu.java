
package view;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Quyen;




public class TrangChu extends javax.swing.JFrame {

    /** Creates new form TrangChu */
    public TrangChu() {
        initComponents();
        setLocationRelativeTo(null);
        setData();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_hoa_don = new javax.swing.JPanel();
        tab_main = new javax.swing.JTabbedPane();
        tab_ban_hang = new javax.swing.JTabbedPane();
        panel_DonHang = new view.Panel_DonHang();
        panel_ChiTietHoaDon = new view.Panel_ChiTietHoaDon();
        tab_san_pham = new javax.swing.JTabbedPane();
        panel_SanPham = new view.Panel_SanPham();
        panel_LoaiSP_HangSX = new view.Panel_LoaiSP_HangSX();
        panel_PhieuNhap = new view.Panel_PhieuNhap();
        panel_ChiTietPhieuNhap = new view.Panel_ChiTietPhieuNhap();
        tab_khach_hang = new javax.swing.JTabbedPane();
        panel_KhachHang = new view.Panel_KhachHang();
        tab_nhan_vien = new javax.swing.JTabbedPane();
        panel_NhanVien = new view.Panel_NhanVien();
        panel_ChucVu = new view.Panel_ChucVu();
        panel_ThongTinCaNhan = new view.Panel_ThongTinCaNhan();
        tab_doi_tac = new javax.swing.JTabbedPane();
        panel_NhaPhanPhoi = new view.Panel_NhaPhanPhoi();
        tab_doanh_thu = new javax.swing.JTabbedPane();
        panel_DoanhThu = new view.Panel_DoanhThu();
        tab_dang_xuat = new javax.swing.JTabbedPane();
        tab_about_me = new javax.swing.JTabbedPane();
        p_about_me = new javax.swing.JPanel();
        panel_ThongTinCaNhan1 = new view.Panel_ThongTinCaNhan();

        javax.swing.GroupLayout p_hoa_donLayout = new javax.swing.GroupLayout(p_hoa_don);
        p_hoa_don.setLayout(p_hoa_donLayout);
        p_hoa_donLayout.setHorizontalGroup(
            p_hoa_donLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
        );
        p_hoa_donLayout.setVerticalGroup(
            p_hoa_donLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Qu???n l?? c???a h??ng");

        tab_main.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab_main.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        tab_main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_mainMouseClicked(evt);
            }
        });
        setTitle("Qu???n l?? c???a h??ng __ " + format.format(new java.util.Date()));

        tab_ban_hang.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tab_ban_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_ban_hangMouseClicked(evt);
            }
        });
        tab_ban_hang.addTab("T???o ????n H??ng M???i", panel_DonHang);
        tab_ban_hang.addTab("Chi Ti???t H??a ????n", panel_ChiTietHoaDon);

        tab_main.addTab("B??n H??ng  ", new javax.swing.ImageIcon(getClass().getResource("/view/icon/ban_hang.png")), tab_ban_hang); // NOI18N

        tab_san_pham.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tab_san_pham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_san_phamMouseClicked(evt);
            }
        });
        tab_san_pham.addTab("Th??ng tin s???n ph???m", panel_SanPham);
        tab_san_pham.addTab("Qu???n L?? Lo???i SP - H??ng SX", panel_LoaiSP_HangSX);
        tab_san_pham.addTab("T???o Phi???u Nh???p H??ng", panel_PhieuNhap);
        tab_san_pham.addTab("Chi Ti???t Phi???u Nh???p", panel_ChiTietPhieuNhap);

        tab_main.addTab("S???n Ph???m  ", new javax.swing.ImageIcon(getClass().getResource("/view/icon/san_pham.png")), tab_san_pham); // NOI18N

        tab_khach_hang.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tab_khach_hang.addTab("Th??ng Tin Kh??ch H??ng", panel_KhachHang);

        tab_main.addTab("Kh??ch H??ng  ", new javax.swing.ImageIcon(getClass().getResource("/view/icon/khach_hang.png")), tab_khach_hang); // NOI18N

        tab_nhan_vien.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tab_nhan_vien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_nhan_vienMouseClicked(evt);
            }
        });

        panel_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_NhanVienMouseClicked(evt);
            }
        });
        tab_nhan_vien.addTab("Qu???n L?? Nh??n Vi??n", panel_NhanVien);
        tab_nhan_vien.addTab("Qu???n L?? Ch???c V???", panel_ChucVu);
        tab_nhan_vien.addTab("Th??ng Tin C?? Nh??n", panel_ThongTinCaNhan);

        tab_main.addTab("Nh??n Vi??n  ", new javax.swing.ImageIcon(getClass().getResource("/view/icon/nhan_vien.png")), tab_nhan_vien); // NOI18N

        tab_doi_tac.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tab_doi_tac.addTab("Th??ng Tin ?????i T??c", panel_NhaPhanPhoi);

        tab_main.addTab("Nh?? Ph??n Ph???i ", new javax.swing.ImageIcon(getClass().getResource("/view/icon/doi_tac.png")), tab_doi_tac); // NOI18N

        tab_doanh_thu.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tab_doanh_thu.addTab("Th???ng K??", panel_DoanhThu);

        tab_main.addTab("Doanh Thu  ", new javax.swing.ImageIcon(getClass().getResource("/view/icon/doanh_thu.png")), tab_doanh_thu); // NOI18N

        tab_dang_xuat.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tab_main.addTab("????ng Xu???t  ", new javax.swing.ImageIcon(getClass().getResource("/view/icon/dang_xuat.png")), tab_dang_xuat); // NOI18N

        tab_about_me.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        javax.swing.GroupLayout p_about_meLayout = new javax.swing.GroupLayout(p_about_me);
        p_about_me.setLayout(p_about_meLayout);
        p_about_meLayout.setHorizontalGroup(
            p_about_meLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_about_meLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_ThongTinCaNhan1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
                .addContainerGap())
        );
        p_about_meLayout.setVerticalGroup(
            p_about_meLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_about_meLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_ThongTinCaNhan1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab_about_me.addTab("About Me", p_about_me);

        tab_main.addTab("About Me  ", new javax.swing.ImageIcon(getClass().getResource("/view/icon/about_me.png")), tab_about_me); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tab_main, javax.swing.GroupLayout.PREFERRED_SIZE, 1526, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tab_main)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_mainMouseClicked
        // TODO add your handling code here:
        if(tab_main.getSelectedComponent() == tab_khach_hang){
            panel_KhachHang.loadKhachHang();
        }
        if(tab_main.getSelectedComponent() == tab_san_pham){
            panel_SanPham.loadSanPham();
        }
        if(tab_main.getSelectedComponent() == tab_dang_xuat){
            JLabel confirm = new JLabel("X??c nh???n ????ng xu???t?");
            confirm.setFont(new Font("Dialog", Font.PLAIN, 17));
            int a = JOptionPane.showConfirmDialog(this, confirm, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (a == JOptionPane.YES_OPTION) {
                new DangNhap().setVisible(true);
                setVisible(false);
                dispose();
            }
        }
        if(tab_main.getSelectedComponent() == tab_doanh_thu){
            panel_DoanhThu.loadTime();
        }
    }//GEN-LAST:event_tab_mainMouseClicked

    private void tab_san_phamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_san_phamMouseClicked
        // TODO add your handling code here:
        if(tab_san_pham.getSelectedComponent() == panel_SanPham){
            panel_SanPham.loadSanPham();
        } else if(tab_san_pham.getSelectedComponent() == panel_ChiTietPhieuNhap){
            panel_ChiTietPhieuNhap.loadTime();
        }
    }//GEN-LAST:event_tab_san_phamMouseClicked

    private void tab_nhan_vienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_nhan_vienMouseClicked
        // TODO add your handling code here:
        if(tab_nhan_vien.getSelectedComponent() == panel_NhanVien){
            panel_NhanVien.loadNhanVien();
        } else if (tab_nhan_vien.getSelectedComponent() == panel_ThongTinCaNhan){
            panel_ThongTinCaNhan.loadThongTinCaNhan();
        }
    }//GEN-LAST:event_tab_nhan_vienMouseClicked

    private void tab_ban_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_ban_hangMouseClicked
        // TODO add your handling code here:
        if(tab_ban_hang.getSelectedComponent() == panel_ChiTietHoaDon){
            panel_ChiTietHoaDon.loadTime();
        }
    }//GEN-LAST:event_tab_ban_hangMouseClicked

    private void panel_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_NhanVienMouseClicked
        // TODO add your handling code here:
        System.out.println("123123123");
    }//GEN-LAST:event_panel_NhanVienMouseClicked

    
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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    public void setData(){
        setup_Quyen();
        panel_SanPham.setdata();
        panel_KhachHang.setdata();
        panel_NhanVien.setdata();
        panel_DonHang.setdata();
        panel_NhaPhanPhoi.setdata();
        panel_PhieuNhap.setdata();
        panel_ChiTietHoaDon.setdata();
        panel_ChiTietPhieuNhap.setdata();
        panel_ChucVu.setdata();
        panel_ThongTinCaNhan.setdata();
        panel_LoaiSP_HangSX.setdata();
        panel_DoanhThu.setdata();
    }
    
    private void setup_Quyen(){
        list_blockQuyen.forEach(quyen -> {
            switch (quyen.getMaQuyen()) {
                case "QL_BAN_HANG" :
                    tab_ban_hang.remove(panel_DonHang);
                    tab_ban_hang.remove(panel_ChiTietHoaDon);
                    break;
                case "QL_CHUC_VU" :
                    tab_nhan_vien.remove(panel_ChucVu);
                    break;
                case "QL_DOANH_THU" :
                    tab_doanh_thu.remove(panel_DoanhThu);
                    break;
                case "QL_KHACH_HANG" :
                    tab_khach_hang.remove(panel_KhachHang);
                    break;
                case "QL_NHA_PHAN_PHOI" :
                    tab_doi_tac.remove(panel_NhaPhanPhoi);
                    break;
                case "QL_NHAN_VIEN" :
                    tab_nhan_vien.remove(panel_NhanVien);
                    break;
                case "QL_NHAP_HANG" :
                    tab_san_pham.remove(panel_PhieuNhap);
                    tab_san_pham.remove(panel_ChiTietPhieuNhap);
                    break;
                case "QL_SAN_PHAM" :
                    tab_san_pham.remove(panel_SanPham);
                    tab_san_pham.remove(panel_LoaiSP_HangSX);
                    break;
                default:
                    
                    break;
            }
        });
    }
    
    
    
    
    
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    public static List<Quyen> list_blockQuyen;
    public static String taiKhoan;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel p_about_me;
    private javax.swing.JPanel p_hoa_don;
    private view.Panel_ChiTietHoaDon panel_ChiTietHoaDon;
    private view.Panel_ChiTietPhieuNhap panel_ChiTietPhieuNhap;
    private view.Panel_ChucVu panel_ChucVu;
    private view.Panel_DoanhThu panel_DoanhThu;
    private view.Panel_DonHang panel_DonHang;
    private view.Panel_KhachHang panel_KhachHang;
    private view.Panel_LoaiSP_HangSX panel_LoaiSP_HangSX;
    private view.Panel_NhaPhanPhoi panel_NhaPhanPhoi;
    private view.Panel_NhanVien panel_NhanVien;
    private view.Panel_PhieuNhap panel_PhieuNhap;
    private view.Panel_SanPham panel_SanPham;
    private view.Panel_ThongTinCaNhan panel_ThongTinCaNhan;
    private view.Panel_ThongTinCaNhan panel_ThongTinCaNhan1;
    private javax.swing.JTabbedPane tab_about_me;
    private javax.swing.JTabbedPane tab_ban_hang;
    private javax.swing.JTabbedPane tab_dang_xuat;
    private javax.swing.JTabbedPane tab_doanh_thu;
    private javax.swing.JTabbedPane tab_doi_tac;
    private javax.swing.JTabbedPane tab_khach_hang;
    private javax.swing.JTabbedPane tab_main;
    private javax.swing.JTabbedPane tab_nhan_vien;
    private javax.swing.JTabbedPane tab_san_pham;
    // End of variables declaration//GEN-END:variables

}

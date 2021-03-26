package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PhieuNhap;
import model.PhieuNhapChiTiet;
import model.SanPham;

public class PhieuNhapChiTietDAO extends GenericDAO{

    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    NhaPhanPhoiDAO nhaPhanPhoiDAO = new NhaPhanPhoiDAO();
    
    public List<PhieuNhapChiTiet> getList(int maPhieuNhapChiTiet){
        try {
            PreparedStatement pst = getPreparedStatement("select * from PhieuNhapChiTiet where maPhieuNhap = ?");
            pst.setInt(1, maPhieuNhapChiTiet);
            
            ResultSet rs = pst.executeQuery();
            List<PhieuNhapChiTiet> listPhieuNhapChiTiet = new ArrayList<>();
            
            while (rs.next()) {
                PhieuNhapChiTiet phieuNhapChiTiet = new PhieuNhapChiTiet();
                phieuNhapChiTiet.setMaPhieuNhapChiTiet(rs.getInt("maPhieuNhapChiTiet"));
                phieuNhapChiTiet.setPhieuNhap(getPhieuNhapById(rs.getInt("maPhieuNhap")));
                phieuNhapChiTiet.setSanPham(sanPhamDAO.getSanPhamById(rs.getInt("maSanPham")));
                phieuNhapChiTiet.setSoLuong(rs.getInt("soLuong"));
                phieuNhapChiTiet.setGhiChu(rs.getString("ghiChu"));
                phieuNhapChiTiet.setTongTien(rs.getInt("tongTien"));
                listPhieuNhapChiTiet.add(phieuNhapChiTiet);
            }
            return listPhieuNhapChiTiet;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public PhieuNhap getPhieuNhapById(int maPhieuNhap){
        try {
            PreparedStatement pst = getPreparedStatement("select * from PhieuNhap where maPhieuNhap = ?");
            pst.setInt(1, maPhieuNhap);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                PhieuNhap phieuNhap = new PhieuNhap();
                phieuNhap.setMaPhieuNhap(rs.getInt("maPhieuNhap"));
                phieuNhap.setNhanVien(nhanVienDAO.getNhanVienById(rs.getString("taiKhoan")));
                phieuNhap.setNhaPhanPhoi(nhaPhanPhoiDAO.getNhaPhanPhoiById(rs.getInt("maNhaPhanPhoi")));
                phieuNhap.setTongTien(rs.getLong("tongTien"));
                phieuNhap.setNgayNhap(rs.getDate("ngayNhap"));
                phieuNhap.setTrangThai(rs.getBoolean("trangThai"));
                phieuNhap.setGhiChu(rs.getString("ghiChu"));
                return phieuNhap;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void them(int maPhieuNhap, List<PhieuNhapChiTiet> listPhieuNhapChiTiet){
        try {
            PreparedStatement pst = getPreparedStatement("insert PhieuNhapChiTiet values (?, ?, ?, ?, ?)");
            for (PhieuNhapChiTiet phieuNhapChiTiet : listPhieuNhapChiTiet) {
                SanPham sanPham = phieuNhapChiTiet.getSanPham();
                pst.setInt(1, maPhieuNhap);
                pst.setInt(2, sanPham.getMaSanPham());
                pst.setInt(3, phieuNhapChiTiet.getSoLuong());
                pst.setString(4, phieuNhapChiTiet.getGhiChu());
                pst.setInt(5, phieuNhapChiTiet.getSanPham().getGiaNhap()*phieuNhapChiTiet.getSoLuong());
                pst.executeUpdate();
                
                sanPhamDAO.updateTonKho(sanPham.getMaSanPham(), sanPham.getTonKho()+phieuNhapChiTiet.getSoLuong());
            }
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
	

}

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.SanPham;

public class HoaDonChiTietDAO extends GenericDAO{
    
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    
    public List<HoaDonChiTiet> getList(int maHoaDon){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListHoaDonChiTiet ?");
            pst.setInt(1, maHoaDon);
            
            ResultSet rs = pst.executeQuery();
            List<HoaDonChiTiet> listHoaDon = new ArrayList<>();
            
            while (rs.next()) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setMaHoaDonChiTiet(rs.getInt("maHoaDonChiTiet"));
                hoaDonChiTiet.setHoaDon(getHoaDonById(rs.getInt("maHoaDon")));
                hoaDonChiTiet.setSanPham(sanPhamDAO.getSanPhamById(rs.getInt("maSanPham")));
                hoaDonChiTiet.setSoLuong(rs.getInt("soLuong"));
                hoaDonChiTiet.setGhiChu(rs.getString("ghiChu"));
                hoaDonChiTiet.setTongTien(rs.getInt("tongTien"));
                listHoaDon.add(hoaDonChiTiet);
            }
            return listHoaDon;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }

    public HoaDon getHoaDonById(int maHoaDon){
        try {
            PreparedStatement pst = getPreparedStatement("exec getHoaDonById ?");
            pst.setInt(1, maHoaDon);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getInt("maHoaDon"));
                hoaDon.setNhanVien(nhanVienDAO.getNhanVienById(rs.getString("taiKhoan")));
                hoaDon.setKhachHang(khachHangDAO.getKhachHangById(rs.getInt("maKhachHang")));
                hoaDon.setTongTien(rs.getLong("tongTien"));
                hoaDon.setNgayLapHoaDon(rs.getDate("ngayLapHoaDon"));
                hoaDon.setTrangThai(rs.getBoolean("trangThai"));
                hoaDon.setGhiChu(rs.getString("ghiChu"));
                return hoaDon;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void them(int maHoaDon, List<HoaDonChiTiet> listHoaDonChiTiet){
        try {
            PreparedStatement pst = getPreparedStatement("exec themHoaDonChiTiet ?, ?, ?, ?, ?");
            for (HoaDonChiTiet hoaDonChiTiet : listHoaDonChiTiet) {
                SanPham sanPham = hoaDonChiTiet.getSanPham();
                pst.setInt(1, maHoaDon);
                pst.setInt(2, sanPham.getMaSanPham());
                pst.setInt(3, hoaDonChiTiet.getSoLuong());
                pst.setString(4, hoaDonChiTiet.getGhiChu());
                pst.setInt(5, hoaDonChiTiet.getSanPham().getGiaBan()*hoaDonChiTiet.getSoLuong());
                pst.executeUpdate();
                
                sanPhamDAO.updateTonKho(sanPham.getMaSanPham(), sanPham.getTonKho()-hoaDonChiTiet.getSoLuong());
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

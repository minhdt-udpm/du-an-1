package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

public class SanPhamDAO extends GenericDAO{
    
    HangSanXuatDAO hangSanXuatDAO = new HangSanXuatDAO();
    LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();

    public List<SanPham> getList(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListSanPham");
            ResultSet rs = pst.executeQuery();
            List<SanPham> listSanPham = new ArrayList<>();
            
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(rs.getInt("maSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setLoaiSanPham(loaiSanPhamDAO.getLoaiSanPhamById(rs.getInt("maLoaiSanPham")));
                sanPham.setHangSanXuat(hangSanXuatDAO.getHangSanXuatById(rs.getInt("maHangSanXuat")));
                sanPham.setGiaNhap(rs.getInt("giaNhap"));
                sanPham.setGiaBan(rs.getInt("giaBan"));
                sanPham.setTonKho(rs.getInt("tonKho"));
                sanPham.setTrangThai(rs.getBoolean("trangThai"));
                sanPham.setImagePath(rs.getString("imagePath"));
                sanPham.setGhiChu(rs.getString("ghiChu"));
                listSanPham.add(sanPham);
            }
            return listSanPham;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
	
    public void them(String tenSanPham, int maLoaiSanPham, int maHangSanXuat, int giaNhap, int giaBan, String imagePath, String ghiChu){
        int tonKho = 0;
        boolean trangThai = true;
        
        try {
            PreparedStatement pst = getPreparedStatement("insert SanPham values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, tenSanPham);
            pst.setInt(2, maLoaiSanPham);
            pst.setInt(3, maHangSanXuat);
            pst.setInt(4, giaNhap);
            pst.setInt(5, giaBan);
            pst.setInt(6, tonKho);
            pst.setBoolean(7, trangThai);
            pst.setString(8, imagePath);
            pst.setString(9, ghiChu);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void sua(int maSanPham, String tenSanPham, int maLoaiSanPham, int maHangSanXuat, int giaNhap, int giaBan, String imagePath, String ghiChu){
        try {
            PreparedStatement pst = getPreparedStatement("update SanPham set "
                                                            + "tenSanPham = ?, "
                                                            + "maLoaiSanPham = ?, "
                                                            + "maHangSanXuat = ?, "
                                                            + "giaNhap = ?, "
                                                            + "giaBan = ?, "
                                                            + "imagePath = ?, "
                                                            + "ghiChu = ? "
                                                       + "where maSanPham = ?");
            pst.setString(1, tenSanPham);
            pst.setInt(2, maLoaiSanPham);
            pst.setInt(3, maHangSanXuat);
            pst.setInt(4, giaNhap);
            pst.setInt(5, giaBan);
            pst.setString(6, imagePath);
            pst.setString(7, ghiChu);
            pst.setInt(8, maSanPham);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void xoa(int maSanPham){
        try {
            PreparedStatement pst = getPreparedStatement("update SanPham set trangThai = ? where maSanPham = ?");
            pst.setBoolean(1, false);
            pst.setInt(2, maSanPham);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public List<SanPham> timKiem(String text){
        int maSP = -1;
        if (text.matches("[0-9]+")) {
            maSP = Integer.valueOf(text);
        }
        try {
            List<SanPham> listSanPham = new ArrayList<>();
            PreparedStatement pst = getPreparedStatement("select * from SanPham inner join LoaiSanPham on SanPham.maLoaiSanPham=LoaiSanPham.maLoaiSanPham inner join HangSanXuat on HangSanXuat.maHangSanXuat=SanPham.maHangSanXuat where (maSanPham = ? or tenSanPham like ? or tenLoaiSanPham like ? or tenHangSanXuat like ?) and trangThai = 1");
            pst.setInt(1, maSP);
            pst.setString(2, "%"+text+"%");
            pst.setString(3, "%"+text+"%");
            pst.setString(4, "%"+text+"%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(rs.getInt("maSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setLoaiSanPham(loaiSanPhamDAO.getLoaiSanPhamById(rs.getInt("maLoaiSanPham")));
                sanPham.setHangSanXuat(hangSanXuatDAO.getHangSanXuatById(rs.getInt("maHangSanXuat")));
                sanPham.setGiaNhap(rs.getInt("giaNhap"));
                sanPham.setGiaBan(rs.getInt("giaBan"));
                sanPham.setTonKho(rs.getInt("tonKho"));
                sanPham.setTrangThai(rs.getBoolean("trangThai"));
                sanPham.setImagePath(rs.getString("imagePath"));
                sanPham.setGhiChu(rs.getString("ghiChu"));
                listSanPham.add(sanPham);
            }
            return listSanPham;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public SanPham getSanPhamById(int maSanPham){
        try {
            PreparedStatement pst = getPreparedStatement("select * from SanPham where maSanPham = ?");
            pst.setInt(1, maSanPham);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(rs.getInt("maSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setLoaiSanPham(loaiSanPhamDAO.getLoaiSanPhamById(rs.getInt("maLoaiSanPham")));
                sanPham.setHangSanXuat(hangSanXuatDAO.getHangSanXuatById(rs.getInt("maHangSanXuat")));
                sanPham.setGiaNhap(rs.getInt("giaNhap"));
                sanPham.setGiaBan(rs.getInt("giaBan"));
                sanPham.setTonKho(rs.getInt("tonKho"));
                sanPham.setTrangThai(rs.getBoolean("trangThai"));
                sanPham.setImagePath(rs.getString("imagePath"));
                sanPham.setGhiChu(rs.getString("ghiChu"));
                return sanPham;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void updateTonKho(int maSanPham, int tonKho){
        try {
            PreparedStatement pst = getPreparedStatement("update SanPham set tonKho = ? where maSanPham = ?");
            pst.setInt(1, tonKho);
            pst.setInt(2, maSanPham);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
                
    }
    
}

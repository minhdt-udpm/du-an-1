package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;

public class LoaiSanPhamDAO extends GenericDAO{

    public LoaiSanPham getLoaiSanPhamById(int maLoaiSanPham){
        try {
            PreparedStatement pst = getPreparedStatement("exec getLoaiSanPhamById ?");
            pst.setInt(1, maLoaiSanPham);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                LoaiSanPham loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(rs.getInt("maLoaiSanPham"));
                loaiSanPham.setTenLoaiSanPham(rs.getString("tenLoaiSanPham"));
                loaiSanPham.setGhiChu(rs.getString("ghiChu"));
                return loaiSanPham;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<LoaiSanPham> getListLoaiSanPham(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListLoaiSanPham");
            ResultSet rs = pst.executeQuery();
            List<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
            
            while (rs.next()) {
                LoaiSanPham loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(rs.getInt("maLoaiSanPham"));
                loaiSanPham.setTenLoaiSanPham(rs.getString("tenLoaiSanPham"));
                loaiSanPham.setGhiChu(rs.getString("ghiChu"));
                listLoaiSanPham.add(loaiSanPham);
            }
            return listLoaiSanPham;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public void them(String tenLoaiSanPham, String ghiChu){
        try {
            PreparedStatement pst = getPreparedStatement("insert LoaiSanPham values (?, ?)");
            pst.setString(1, tenLoaiSanPham);
            pst.setString(2, ghiChu);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void sua(int maLoaiSanPham, String tenLoaiSanPham, String ghiChu){
        try {
            PreparedStatement pst = getPreparedStatement("update LoaiSanPham set "
                                                            + "tenLoaiSanPham = ?, "
                                                            + "ghiChu = ? "
                                                       + "where maLoaiSanPham = ?");
            pst.setString(1, tenLoaiSanPham);
            pst.setString(2, ghiChu);
            pst.setInt(3, maLoaiSanPham);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean xoa(int maLoaiSanPham){
        try {
            PreparedStatement pst = getPreparedStatement("delete LoaiSanPham where maLoaiSanPham = ?");
            pst.setInt(1, maLoaiSanPham);
            pst.executeUpdate();
            return true;
            
        } catch (SQLException sql){
            return false;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
}

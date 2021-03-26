package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhaPhanPhoi;

public class NhaPhanPhoiDAO extends GenericDAO{
    
    public NhaPhanPhoi getNhaPhanPhoiById(int maNhaPhanPhoi){
        try {
            PreparedStatement pst = getPreparedStatement("select * from NhaPhanPhoi where maNhaPhanPhoi = ?");
            pst.setInt(1, maNhaPhanPhoi);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                NhaPhanPhoi nhaPhanPhoi = new NhaPhanPhoi();
                nhaPhanPhoi.setMaNhaPhanPhoi(rs.getInt("maNhaPhanPhoi"));
                nhaPhanPhoi.setTenNhaPhanPhoi(rs.getString("tenNhaPhanPhoi"));
                nhaPhanPhoi.setDiaChi(rs.getString("diaChi"));
                nhaPhanPhoi.setSoDienThoai(rs.getString("soDienThoai"));
                nhaPhanPhoi.setEmail(rs.getString("email"));
                nhaPhanPhoi.setTrangThai(rs.getBoolean("trangThai"));
                nhaPhanPhoi.setGhiChu(rs.getString("ghiChu"));
                return nhaPhanPhoi;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<NhaPhanPhoi> getList(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListNhaPhanPhoi");
            ResultSet rs = pst.executeQuery();
            List<NhaPhanPhoi> listNhaPhanPhoi = new ArrayList<>();
            
            while (rs.next()) {
                NhaPhanPhoi nhaPhanPhoi = new NhaPhanPhoi();
                nhaPhanPhoi.setMaNhaPhanPhoi(rs.getInt("maNhaPhanPhoi"));
                nhaPhanPhoi.setTenNhaPhanPhoi(rs.getString("tenNhaPhanPhoi"));
                nhaPhanPhoi.setDiaChi(rs.getString("diaChi"));
                nhaPhanPhoi.setSoDienThoai(rs.getString("soDienThoai"));
                nhaPhanPhoi.setEmail(rs.getString("email"));
                nhaPhanPhoi.setTrangThai(rs.getBoolean("trangThai"));
                nhaPhanPhoi.setGhiChu(rs.getString("ghiChu"));
                listNhaPhanPhoi.add(nhaPhanPhoi);
            }
            return listNhaPhanPhoi;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
	
    public void them(String tenNhaPhanPhoi, String diaChi, String soDienThoai, String email, String ghiChu){
        boolean trangThai = true;
        try {
            PreparedStatement pst = getPreparedStatement("insert NhaPhanPhoi values (?, ?, ?, ?, ?, ?)");
            pst.setString(1, tenNhaPhanPhoi);
            pst.setString(2, diaChi);
            pst.setString(3, soDienThoai);
            pst.setString(4, email);
            pst.setBoolean(5, trangThai);
            pst.setString(6, ghiChu);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void sua(int maNhaPhanPhoi, String tenNhaPhanPhoi, String diaChi, String soDienThoai, String email, String ghiChu){
        try {
            PreparedStatement pst = getPreparedStatement("update NhaPhanPhoi set "
                                                            + "tenNhaPhanPhoi = ?, "
                                                            + "diaChi = ?, "
                                                            + "soDienThoai = ?, "
                                                            + "email = ?, "
                                                            + "ghiChu = ? "
                                                       + "where maNhaPhanPhoi = ?");
            pst.setString(1, tenNhaPhanPhoi);
            pst.setString(2, diaChi);
            pst.setString(3, soDienThoai);
            pst.setString(4, email);
            pst.setString(5, ghiChu);
            pst.setInt(6, maNhaPhanPhoi);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void xoa(int maNhaPhanPhoi){
        try {
            PreparedStatement pst = getPreparedStatement("update NhaPhanPhoi set trangThai = ? where maNhaPhanPhoi = ?");
            pst.setBoolean(1, false);
            pst.setInt(2, maNhaPhanPhoi);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
    public List<NhaPhanPhoi> timKiem(String text){
        try {
            List<NhaPhanPhoi> listNhaPhanPhoi = new ArrayList<>();
            PreparedStatement pst = getPreparedStatement("select * from NhaPhanPhoi where (tenNhaPhanPhoi like ? or soDienThoai like ? or email like ?) and trangThai = 1");
            pst.setString(1, "%"+text+"%");
            pst.setString(2, "%"+text+"%");
            pst.setString(3, "%"+text+"%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                NhaPhanPhoi nhaPhanPhoi = new NhaPhanPhoi();
                nhaPhanPhoi.setMaNhaPhanPhoi(rs.getInt("maNhaPhanPhoi"));
                nhaPhanPhoi.setTenNhaPhanPhoi(rs.getString("tenNhaPhanPhoi"));
                nhaPhanPhoi.setDiaChi(rs.getString("diaChi"));
                nhaPhanPhoi.setSoDienThoai(rs.getString("soDienThoai"));
                nhaPhanPhoi.setEmail(rs.getString("email"));
                nhaPhanPhoi.setGhiChu(rs.getString("ghiChu"));
                listNhaPhanPhoi.add(nhaPhanPhoi);
            }
            return listNhaPhanPhoi;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
}

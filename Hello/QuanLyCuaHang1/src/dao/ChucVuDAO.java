package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChucVu;
import model.Quyen;

public class ChucVuDAO extends GenericDAO{
    
    ChucVu_QuyenDAO chucVu_QuyenDAO = new ChucVu_QuyenDAO();

    public ChucVu getChucVuById(int maChucVu){
        try {
            PreparedStatement pst = getPreparedStatement("exec getChucVuById ?");
            pst.setInt(1, maChucVu);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ChucVu chucVu = new ChucVu();
                chucVu.setMaChucVu(rs.getInt("maChucVu"));
                chucVu.setTenChucVu(rs.getString("tenChucVu"));
                chucVu.setGhiChu(rs.getString("ghiChu"));
                return chucVu;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ChucVu> getListChucVu(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListChucVu");
            ResultSet rs = pst.executeQuery();
            List<ChucVu> listChucVu = new ArrayList<>();
            
            while (rs.next()) {
                ChucVu chucVu = new ChucVu();
                chucVu.setMaChucVu(rs.getInt("maChucVu"));
                chucVu.setTenChucVu(rs.getString("tenChucVu"));
                chucVu.setGhiChu(rs.getString("ghiChu"));
                listChucVu.add(chucVu);
            }
            return listChucVu;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public List<Quyen> getQuyenByMaChucVu(int maChucVu){
        try {
            PreparedStatement pst = getPreparedStatement("exec getQuyenByMaChucVu ?");
            pst.setInt(1, maChucVu);
            ResultSet rs = pst.executeQuery();
            List<Quyen> listQuyen = new ArrayList<>();
            while (rs.next()) {                
                Quyen quyen = new Quyen();
                quyen.setMaQuyen(rs.getString("maQuyen"));
                quyen.setTenQuyen(rs.getString("tenQuyen"));
                quyen.setGhiChu(rs.getString("ghiChu"));
                listQuyen.add(quyen);
            }
            return listQuyen;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public boolean checkExistChucVu(int maChucVu){
        try {
            PreparedStatement pst = getPreparedStatement("exec checkExistChucVu ?");
            pst.setInt(1, maChucVu);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void them(String tenChucVu, String ghiChu, List<String> listMaQuyen){
        try {
            PreparedStatement pst = getPreparedStatement("exec themChucVu ?, ?");
            pst.setString(1, tenChucVu);
            pst.setString(2, ghiChu);
            pst.executeUpdate();
            
            int maChucVu = getLastMaChucVu();
            listMaQuyen.forEach(maQuyen -> {
                chucVu_QuyenDAO.them(maChucVu, maQuyen);
            });
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void sua(int maChucVu, String tenChucVu, String ghiChu, List<String> listMaQuyen){
        try {
            PreparedStatement pst = getPreparedStatement("exec suaChucVu ?, ?, ?");
            pst.setString(1, tenChucVu);
            pst.setString(2, ghiChu);
            pst.setInt(3, maChucVu);
            pst.executeUpdate();
            
            chucVu_QuyenDAO.xoaQuyen(maChucVu);
            listMaQuyen.forEach(maQuyen -> {
                chucVu_QuyenDAO.them(maChucVu, maQuyen);
            });
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void xoa(int maChucVu){
        try {
            PreparedStatement pst = getPreparedStatement("exec xoaChucVu ?");
            pst.setInt(1, maChucVu);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public int getLastMaChucVu(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getLastMaChucVu");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("maChucVu");
            }
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        return -1;
    }
}

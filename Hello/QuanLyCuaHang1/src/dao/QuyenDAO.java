package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Quyen;

public class QuyenDAO extends GenericDAO{
    
     public Quyen getQuyenVuById(String maQuyen){
        try {
            PreparedStatement pst = getPreparedStatement("select * from Quyen where maQuyen = ?");
            pst.setString(1, maQuyen);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Quyen quyen = new Quyen();
                quyen.setMaQuyen(rs.getString("maQuyen"));
                quyen.setTenQuyen(rs.getString("tenQuyen"));
                quyen.setGhiChu(rs.getString("ghiChu"));
                return quyen;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Quyen> getListBlockQuyenByChucVu(int maChucVu){
        List<Quyen> list_blockQuyen = new ArrayList<>();
        try {
            PreparedStatement pst = getPreparedStatement("select maQuyen from ChucVu_Quyen where maQuyen not in (select maQuyen from ChucVu_Quyen where maChucVu = ?)");
            pst.setInt(1, maChucVu);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                list_blockQuyen.add(getQuyenVuById(rs.getString("maQuyen")));
            }
            return list_blockQuyen;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }

    
    
}

package dao;

import java.sql.PreparedStatement;

public class ChucVu_QuyenDAO extends GenericDAO{

    public void them(int maChucVu, String maQuyen){
        try {
            PreparedStatement pst = getPreparedStatement("insert ChucVu_Quyen values (?, ?)");
            pst.setInt(1, maChucVu);
            pst.setString(2, maQuyen);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
    public void xoaQuyen(int maChucVu){
        try {
            PreparedStatement pst = getPreparedStatement("delete ChucVu_Quyen where maChucVu = ?");
            pst.setInt(1, maChucVu);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

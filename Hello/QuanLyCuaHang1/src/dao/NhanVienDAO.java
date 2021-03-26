package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import model.NhanVien;
import view.TrangChu;

public class NhanVienDAO extends GenericDAO{
    
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    QuyenDAO quyenDAO = new QuyenDAO();
    ChucVuDAO chucVuDAO = new ChucVuDAO();
    
    public NhanVien getNhanVienById(String taiKhoan){
        try {
            PreparedStatement pst = getPreparedStatement("exec getNhanVienById ?");
            pst.setString(1, taiKhoan);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setTaiKhoan(rs.getString("taiKhoan"));
                nhanVien.setHoTen(rs.getString("hoTen"));
                nhanVien.setNgaySinh(rs.getDate("ngaySinh"));
                nhanVien.setGioiTinh(rs.getBoolean("gioiTinh"));
                nhanVien.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                nhanVien.setChucVu(chucVuDAO.getChucVuById(rs.getInt("maChucVu")));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setGhiChu(rs.getString("ghiChu"));
                return nhanVien;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean checkDangNhap(String taiKhoan, String matKhau) {
        try {
            PreparedStatement pst = getPreparedStatement("EXEC checkDangNhap ?, ?");
            pst.setString(1, taiKhoan);
            pst.setString(2, hashMD5(matKhau));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {         
                TrangChu.taiKhoan = rs.getString("taiKhoan");
                TrangChu.list_blockQuyen = quyenDAO.getListBlockQuyenByChucVu(rs.getInt("maChucVu"));
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return false;
    }

    public List<NhanVien> getList(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListNhanVien");
            ResultSet rs = pst.executeQuery();
            List<NhanVien> listNhanVien = new ArrayList<>();
            
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setTaiKhoan(rs.getString("taiKhoan"));
                nhanVien.setHoTen(rs.getString("hoTen"));
                nhanVien.setNgaySinh(rs.getDate("ngaySinh"));
                nhanVien.setGioiTinh(rs.getBoolean("gioiTinh"));
                nhanVien.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                nhanVien.setChucVu(chucVuDAO.getChucVuById(rs.getInt("maChucVu")));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setGhiChu(rs.getString("ghiChu"));
                listNhanVien.add(nhanVien);
            }
            return listNhanVien;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
	
    public void them(String hoTen, String ngaySinh, boolean gioiTinh, String ngayVaoLam, int maChucVu, String diaChi, String soDienThoai, String email, String ghiChu){
        String taiKhoan = getTaiKhoan(hoTen);
        String temp = taiKhoan;
        int index = 1;
        while (checkExistTaiKhoan(taiKhoan)) {            
            taiKhoan=temp + ++index;
        }
        String matKhau = "123@2019";
        
        boolean trangThai = true;
        try {
            PreparedStatement pst = getPreparedStatement("exec themNhanVien ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            pst.setString(1, taiKhoan);
            pst.setString(2, hashMD5(matKhau));
            pst.setString(3, hoTen);
            pst.setDate(4, new Date(format.parse(ngaySinh).getTime()));
            pst.setBoolean(5, gioiTinh);
            pst.setDate(6, new Date(format.parse(ngayVaoLam).getTime()));
            pst.setInt(7, maChucVu);
            pst.setString(8, diaChi);
            pst.setString(9, soDienThoai);
            pst.setString(10, email);
            pst.setBoolean(11, trangThai);
            pst.setString(12, ghiChu);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void sua(String taiKhoan, String hoTen, String ngaySinh, boolean gioiTinh, String ngayVaoLam, int maChucVu, String diaChi, String soDienThoai, String email, String ghiChu){
        try {
            PreparedStatement pst = getPreparedStatement("exec suaNhanVien ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            pst.setString(1, hoTen);
            pst.setDate(2, new Date(format.parse(ngaySinh).getTime()));
            pst.setBoolean(3, gioiTinh);
            pst.setDate(4, new Date(format.parse(ngayVaoLam).getTime()));
            pst.setInt(5, maChucVu);
            pst.setString(6, diaChi);
            pst.setString(7, soDienThoai);
            pst.setString(8, email);
            pst.setString(9, ghiChu);
            pst.setString(10, taiKhoan);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void xoa(String taiKhoan){
        try {
            PreparedStatement pst = getPreparedStatement("update NhanVien set trangThai = ?, maChucVu = 5 where taiKhoan = ?");
            pst.setBoolean(1, false);
            pst.setString(2, taiKhoan);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void doiMatKhau(String taiKhoan, String matKhau){
        try {
            PreparedStatement pst = getPreparedStatement("exec doiMatKhau ?, ?");
            pst.setString(1, hashMD5(matKhau));
            pst.setString(2, taiKhoan);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public int countGiamDoc(){
        try {
            PreparedStatement pst = getPreparedStatement("select count(taiKhoan) as countGD from NhanVien where maChucVu = 1");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("countGD");
            } else return 0;
            
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean checkExistTaiKhoan(String taiKhoan){
        try {
            PreparedStatement pst = getPreparedStatement("select taiKhoan from NhanVien where taiKhoan = ?");
            pst.setString(1, taiKhoan);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) return true;
            
        } catch (Exception e) {
            System.out.println("checkExistTaiKhoan: " + e);
        }
        return false;
    }
    
    public String hashMD5(String text){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public String getTaiKhoan(String hoTen) {
        String[] arr = Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(Normalizer.normalize(hoTen, Normalizer.Form.NFD)).replaceAll("").replace('đ','d').replace('Đ','D').toLowerCase().toLowerCase().split(" ");
        String ten = arr[arr.length - 1];
        for (String part : arr) {
            ten += part.substring(0, 1);
        }
        return ten.substring(0, ten.length()-1);
    }
}

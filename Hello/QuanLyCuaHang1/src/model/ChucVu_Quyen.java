package model;

public class ChucVu_Quyen {

    private ChucVu chucVu;
    private Quyen quyen;

    public ChucVu_Quyen() {
    }

    public ChucVu_Quyen(ChucVu chucVu, Quyen quyen) {
        this.chucVu = chucVu;
        this.quyen = quyen;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }

}

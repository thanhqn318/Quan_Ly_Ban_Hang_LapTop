
package poly;

import java.io.Serializable;


public class SanPham implements Serializable{
    private String MaLapTop;
    private String TenLapTop;
    private String CauHinhCT;
    private String Mau;
    private String ThuongHieu;
    private int SoLuong;
    private String BaoHanh;
    private float GiaBan;
    private String HinhAnh;

    public SanPham() {
    }

    public SanPham(String MaLapTop, String TenLapTop, String CauHinhCT, String Mau, String ThuongHieu, int SoLuong, String BaoHanh, float GiaBan, String HinhAnh) {
        this.MaLapTop = MaLapTop;
        this.TenLapTop = TenLapTop;
        this.CauHinhCT = CauHinhCT;
        this.Mau = Mau;
        this.ThuongHieu = ThuongHieu;
        this.SoLuong = SoLuong;
        this.BaoHanh = BaoHanh;
        this.GiaBan = GiaBan;
        this.HinhAnh = HinhAnh;
    }

    public String getMaLapTop() {
        return MaLapTop;
    }

    public void setMaLapTop(String MaLapTop) {
        this.MaLapTop = MaLapTop;
    }

    public String getTenLapTop() {
        return TenLapTop;
    }

    public void setTenLapTop(String TenLapTop) {
        this.TenLapTop = TenLapTop;
    }

    public String getCauHinhCT() {
        return CauHinhCT;
    }

    public void setCauHinhCT(String CauHinhCT) {
        this.CauHinhCT = CauHinhCT;
    }

    public String getMau() {
        return Mau;
    }

    public void setMau(String Mau) {
        this.Mau = Mau;
    }

    public String getThuongHieu() {
        return ThuongHieu;
    }

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getBaoHanh() {
        return BaoHanh;
    }

    public void setBaoHanh(String BaoHanh) {
        this.BaoHanh = BaoHanh;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    @Override
    public String toString() {
        return "SanPham{" + "MaLapTop=" + MaLapTop + ", TenLapTop=" + TenLapTop + ", CauHinhCT=" + CauHinhCT + ", Mau=" + Mau + ", ThuongHieu=" + ThuongHieu + ", SoLuong=" + SoLuong + ", BaoHanh=" + BaoHanh + ", GiaBan=" + GiaBan + ", HinhAnh=" + HinhAnh + '}';
    }

    
}

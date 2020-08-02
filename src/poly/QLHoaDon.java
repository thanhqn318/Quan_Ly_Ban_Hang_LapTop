/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly;

import java.util.Date;

/**
 *
 * @author asus
 */
public class QLHoaDon {
    private String mahd;
    private String tenkh;
    private String tennv;
    private Date ngaylap;

    public QLHoaDon() {
    }

    public QLHoaDon(String mahd, String tenkh, String tennv, Date ngaylap) {
        this.mahd = mahd;
        this.tenkh = tenkh;
        this.tennv = tennv;
        this.ngaylap = ngaylap;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }
    
}

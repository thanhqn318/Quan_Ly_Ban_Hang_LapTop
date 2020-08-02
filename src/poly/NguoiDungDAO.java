package poly;

import UHepler.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NguoiDungDAO {

    public NguoiDung checkLogin(String tenDangNhap, String matKhau) throws Exception {
        String sql = "SELECT * FROM USERS\n"
                + "WHERE UserName = ? AND PassWord = ?";
        try (Connection con = Helper.ketnoi("LapTopStore");
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    NguoiDung nd = new NguoiDung();
                    nd.setTenDangNhap(tenDangNhap);
                    nd.setVaiTro(rs.getString("Role"));
                    return nd;
                }
            }
        }
        return null;
    }
}

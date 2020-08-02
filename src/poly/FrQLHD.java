/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly;

import UHepler.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class FrQLHD extends javax.swing.JPanel {

    /**
     * Creates new form QLKH
     */
    DefaultTableModel model;
    ArrayList<QLHoaDon> list = new ArrayList<>();
    int index;
    Connection connection = Helper.ketnoi("LapTopStore");

    public FrQLHD() throws SQLException, ClassNotFoundException {
        initComponents();
        this.list = new ArrayList<>();
        this.model = (DefaultTableModel) tblqlhd.getModel();
        this.list = getdulieu();
        doDuLieuTuListVaoModel();
        index = 0;
        inDoiTuongRaFrom(index);
    }

    public ResultSet getAll1(String tenbang) {
        try {
            ResultSet rs = null;
            String sql = "SELECT * FROM " + tenbang;
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<QLHoaDon> getdulieu() throws SQLException {
        ResultSet rs1 = getAll1("HoaDon");
        ResultSet rs2 = getAll1("KhachHang");
        ResultSet rs3 = getAll1("NhanVien");
        while (rs1.next()) {
            QLHoaDon x = new QLHoaDon();
            x.setMahd(rs1.getString("MaHoaDon"));
            x.setTenkh(findtenkh(rs1.getString("MaKH")));
            x.setTennv(findtennv(rs1.getString("MaNV")));
            x.setNgaylap(rs1.getDate("NgayLap"));
            list.add(x);
        }
        return list;
    }

    public String findtenkh(String makh) throws SQLException {
        ResultSet rs = getAll1("KhachHang");
        String tenkh = null;
        while (rs.next()) {
            if (rs.getString("MaKH").trim().equals(makh.trim())) {
                tenkh = rs.getString("TenKH");
                break;
            }
        }
        return tenkh;
    }

    public String findtennv(String manv) throws SQLException {
        ResultSet rs = getAll1("NhanVien");
        String tennv = null;
        while (rs.next()) {
            if (rs.getString("MaNV").trim().equals(manv.trim())) {
                tennv = rs.getString("TenNV");
                break;
            }
        }
        return tennv;
    }

    public String findmakh() throws SQLException {
        ResultSet rs = getAll1("KhachHang");
        String makh = null;
        while (rs.next()) {
            if (txttenkh.getText().trim().equals(rs.getString("TenKH").trim())) {
                makh = rs.getString("MaKH");
                break;
            }
        }
        return makh;
    }

    public String findmanv() throws SQLException {
        ResultSet rs = getAll1("NhanVien");
        String manv = null;
        while (rs.next()) {
            if (txttennv.getText().trim().equals(rs.getString("TenNV").trim())) {
                manv = rs.getString("MaNV");
                break;
            }
        }
        return manv;
    }

    public String findmahd() throws SQLException {
        ResultSet rs = getAll1("HoaDon");
        if (rs == null) {
            return null;
        }
        String mahd = null;
        while (rs.next()) {
            if (txtmahd.getText().trim().equals(rs.getString("MaHoaDon").trim())) {
                mahd = rs.getString("MaHoaDon");
                break;
            }
        }
        return mahd;
    }

    public void doDuLieuTuListVaoModel() throws ClassNotFoundException, SQLException {
        model.setRowCount(0);
        for (QLHoaDon qLHoaDon : list) {
            model.addRow(new Object[]{qLHoaDon.getMahd(), qLHoaDon.getTenkh(), qLHoaDon.getTennv(), qLHoaDon.getNgaylap()});
        }
    }

    public void clear() throws ClassNotFoundException, SQLException {
        txtmahd.setText("");
        txtngaylap.setText("");
        txttenkh.setText("");
        txttennv.setText("");
        txtmahd.setEditable(true);
        doDuLieuTuListVaoModel();
    }

    public void inDoiTuongRaFrom(int index) {
        txtmahd.setText((String) model.getValueAt(index, 0));
        txttenkh.setText((String) model.getValueAt(index, 1));
        txttennv.setText((String) model.getValueAt(index, 2));
        txtngaylap.setText(model.getValueAt(index, 3) + "");
        tblqlhd.setRowSelectionInterval(index, index);
        txtmahd.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btndau = new javax.swing.JButton();
        btnprev = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btncuoi = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtfindmahd = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmahd = new javax.swing.JTextField();
        txttenkh = new javax.swing.JTextField();
        txttennv = new javax.swing.JTextField();
        txtngaylap = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnnew = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblqlhd = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1260, 689));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý hóa đơn");

        btndau.setBackground(new java.awt.Color(255, 255, 255));
        btndau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/First_record.png"))); // NOI18N
        btndau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndauActionPerformed(evt);
            }
        });

        btnprev.setBackground(new java.awt.Color(255, 255, 255));
        btnprev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rewind.png"))); // NOI18N
        btnprev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprevActionPerformed(evt);
            }
        });

        btnnext.setBackground(new java.awt.Color(255, 255, 255));
        btnnext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fast-forward.png"))); // NOI18N
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btncuoi.setBackground(new java.awt.Color(255, 255, 255));
        btncuoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Last_recor.png"))); // NOI18N
        btncuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncuoiActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        jButton5.setText("Xuất File");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã HD");

        txtfindmahd.setBackground(new java.awt.Color(204, 204, 204));

        btnfind.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnfind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnfind.setText("Find");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtfindmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnfind)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfindmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tên KH");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tên NV");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Ngày Lập");

        txtmahd.setBackground(new java.awt.Color(204, 204, 204));
        txtmahd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtmahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmahdActionPerformed(evt);
            }
        });

        txttenkh.setBackground(new java.awt.Color(204, 204, 204));
        txttenkh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txttennv.setBackground(new java.awt.Color(204, 204, 204));
        txttennv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtngaylap.setBackground(new java.awt.Color(204, 204, 204));
        txtngaylap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtngaylap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtngaylapActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("Xem hóa đơn chi tiết");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mã HD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtmahd, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addComponent(txttenkh)
                        .addComponent(txttennv)
                        .addComponent(txtngaylap)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txttenkh)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnnew.setBackground(new java.awt.Color(255, 255, 255));
        btnnew.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnnew.setText("Thêm");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });

        btnadd.setBackground(new java.awt.Color(255, 255, 255));
        btnadd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btnadd.setText("Lưu");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(255, 255, 255));
        btnupdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnupdate.setText("Sửa");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(255, 255, 255));
        btndelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btndelete.setText("Xóa");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tblqlhd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Tên KH", "Tên NV", "Ngày lập"
            }
        ));
        tblqlhd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblqlhdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblqlhd);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnnew)
                                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btndau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnprev)
                        .addGap(67, 67, 67)
                        .addComponent(btnnext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncuoi)
                        .addGap(197, 197, 197)
                        .addComponent(jButton5)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnprev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncuoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btndauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndauActionPerformed
        // TODO add your handling code here:
        this.index = 0;
        inDoiTuongRaFrom(this.index);
    }//GEN-LAST:event_btndauActionPerformed

    private void btncuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncuoiActionPerformed
        // TODO add your handling code here:
        this.index = this.list.size() - 1;
        inDoiTuongRaFrom(this.index);
    }//GEN-LAST:event_btncuoiActionPerformed

    private void btnprevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprevActionPerformed
        // TODO add your handling code here:
        if (this.index == 0) {
            this.index = this.list.size() - 1;
            inDoiTuongRaFrom(this.index);
        } else {
            this.index--;
            inDoiTuongRaFrom(this.index);
        }
    }//GEN-LAST:event_btnprevActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
        this.index++;
        if (this.index > this.list.size() - 1) {
            this.index = 0;
            inDoiTuongRaFrom(this.index);
        } else {
            inDoiTuongRaFrom(this.index);
        }
    }//GEN-LAST:event_btnnextActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtmahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmahdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmahdActionPerformed

    private void txtngaylapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtngaylapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtngaylapActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        FrCTHD cthd = new FrCTHD();
        cthd.setVisible(true);
        cthd.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
            // TODO add your handling code here:
            if (txtmahd.getText().equals("") == true || txtngaylap.getText().equals("") == true || txttenkh.getText().equals("") == true || txttennv.getText().equals("") == true) {
                JOptionPane.showMessageDialog(this, "Không được để trống ô nhập");
                return;
            }
            String mahd = findmahd();
            if (mahd != null) {
                JOptionPane.showMessageDialog(this, "Mã hóa đơn đã có trong dữ liệu");
                return;
            }
            String makh = findmakh();
            if (makh == null) {
                JOptionPane.showMessageDialog(this, "Tên KH vừa nhập chưa đúng");
                return;
            }
            String manv = findmanv();
            if (manv == null) {
                JOptionPane.showMessageDialog(this, "Tên NV vừa nhập chưa đúng");
                return;
            }
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            sdf2.setLenient(false);
            Date t = null;
            try {
                t = sdf2.parse(txtngaylap.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ngày nhập chưa đúng định dạng");
                return;
            }
            Connection connection = Helper.ketnoi("LapTopStore");
            String sql = "INSERT INTO HoaDon(MaHoaDon,MaKH,MaNV,NgayLap) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, txtmahd.getText());
            ps.setString(2, findmakh());
            ps.setString(3, findmanv());
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf1.parse(txtngaylap.getText());
            java.util.Date date1 = new java.sql.Date(date.getTime());
            java.sql.Timestamp ts = new java.sql.Timestamp(date.getTime());
            ps.setTimestamp(4, ts);
            ps.execute();
            list.add(new QLHoaDon(txtmahd.getText(), txttenkh.getText(), txttennv.getText(), date1));
            doDuLieuTuListVaoModel();
            index = list.size() - 1;
            tblqlhd.setRowSelectionInterval(index, index);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        try {
            // TODO add your handling code here:
            clear();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnnewActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try {
            // TODO add your handling code here:
            index = tblqlhd.getSelectedRow();
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng click vào dòng muốn xóa trên bảng");
                return;
            }
            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có thật sự muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (hoi == JOptionPane.NO_OPTION) {
                return;
            }
            Connection connection = Helper.ketnoi("LapTopStore");
            String sql = "DELETE HoaDon WHERE MaHoaDon=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, txtmahd.getText());
            ps.execute();
            this.list = getdulieu();
            doDuLieuTuListVaoModel();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            clear();
        } catch (SQLException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tblqlhdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblqlhdMouseClicked
        // TODO add your handling code here:
        index = tblqlhd.getSelectedRow();
        txtmahd.setText((String) model.getValueAt(index, 0));
        txttenkh.setText((String) model.getValueAt(index, 1));
        txttennv.setText((String) model.getValueAt(index, 2));
        txtngaylap.setText(model.getValueAt(index, 3) + "");
        txtmahd.setEditable(false);
    }//GEN-LAST:event_tblqlhdMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
            // TODO add your handling code here:
            index = tblqlhd.getSelectedRow();
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng click vào dòng muốn cập nhật trên bảng");
                return;
            }
            if (txtmahd.getText().equals("") == true || txtngaylap.getText().equals("") == true || txttenkh.getText().equals("") == true || txttennv.getText().equals("") == true) {
                JOptionPane.showMessageDialog(this, "Không được để trống ô nhập");
                return;
            }
            String makh = findmakh();
            if (makh == null) {
                JOptionPane.showMessageDialog(this, "Tên KH vừa nhập chưa đúng");
                return;
            }
            String manv = findmanv();
            if (manv == null) {
                JOptionPane.showMessageDialog(this, "Tên NV vừa nhập chưa đúng");
                return;
            }
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            sdf2.setLenient(false);
            Date t = null;
            try {
                t = sdf2.parse(txtngaylap.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ngày nhập chưa đúng định dạng");
                return;
            }
            Connection connection = Helper.ketnoi("LapTopStore");
            String sql = "UPDATE HoaDon SET MaKH=?,MaNV=?,NgayLap=? where MaHoaDon=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, findmakh());
            ps.setString(2, findmanv());
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf1.parse(txtngaylap.getText());
            java.util.Date date1 = new java.sql.Date(date.getTime());
            java.sql.Timestamp ts = new java.sql.Timestamp(date.getTime());
            ps.setTimestamp(3, ts);
            ps.setString(4, txtmahd.getText());
            ps.execute();
            this.list = getdulieu();
            doDuLieuTuListVaoModel();
            tblqlhd.setRowSelectionInterval(index, index);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } catch (SQLException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        try {
            // TODO add your handling code here:
            if (txtfindmahd.getText().equals("") == true) {
                JOptionPane.showMessageDialog(this, "Hóa đơn không được để trống");
                return;
            }
            ResultSet rs = getAll1("HoaDon");
            String mahd = null;
            index = -1;
            int count = 0;
            while (rs.next()) {
                index++;
                if (txtfindmahd.getText().trim().equals(rs.getString("MaHoaDon").trim())) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(this, "không tìm thấy hóa đơn theo mã");
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Tìm thấy nhân viên theo mã");
                txtmahd.setText((String) model.getValueAt(index, 0));
                txttenkh.setText((String) model.getValueAt(index, 1));
                txttennv.setText((String) model.getValueAt(index, 2));
                txtngaylap.setText(model.getValueAt(index, 3) + "");
                tblqlhd.setRowSelectionInterval(index, index);
                txtmahd.setEditable(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrQLHD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnfindActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncuoi;
    private javax.swing.JButton btndau;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprev;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblqlhd;
    private javax.swing.JTextField txtfindmahd;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtngaylap;
    private javax.swing.JTextField txttenkh;
    private javax.swing.JTextField txttennv;
    // End of variables declaration//GEN-END:variables
}

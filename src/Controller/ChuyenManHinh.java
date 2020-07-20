package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import poly.FrQLHD;
import poly.FrTrangChu;
import poly.FrQLKH;
import poly.FrQLNV;
import poly.FrQLSP;
import poly2.DanhMucBean;

public class ChuyenManHinh {

    private List<DanhMucBean> listDanhMuc = null;
    private JPanel root;
    private String kindSelected = "";

    public ChuyenManHinh(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new FrTrangChu());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        for (DanhMucBean item : listDanhMuc) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.node = node;
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new FrTrangChu();
                    break;
                case "QLKH":
                    node = new FrQLKH();
                    break;
                case "QLSP":
                    node = new FrQLSP();
                    break;
                case "QLNV":
                    node = new FrQLNV();
                    break;
                case "QLHD":
                    node = new FrQLHD();
                    break;
                case "DangXuat":
                    int i = JOptionPane.showConfirmDialog(null, "Bạn có muốn rời đi");
                    if (i == 0) {
                        System.exit(0);
                    }
                    break;
                // more
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBG(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(43, 75, 179));
                jlbItem.setBackground(new Color(43, 75, 179));
            }
        }

    }

    private void setChangeBG(String kind) {
        for (DanhMucBean item : listDanhMuc) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(43, 75, 179));
                item.getJlb().setBackground(new Color(43, 75, 179));
            }
        }
    }

}

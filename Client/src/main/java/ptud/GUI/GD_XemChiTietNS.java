/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ptud.GUI;

import java.rmi.Naming;
import java.rmi.RemoteException;

import DAO_Interface.IDAOCongNhan;
import client.Client;
import ptud.DAO.DAO_CongNhan;
import ptud.DAO.DAO_NhanVien;
import ptud.Entity.CongNhan;
import ptud.Entity.NhanVien;
import ptud.ults.ImageCus;

/**
 *
 * @author TomTom
 */
public class GD_XemChiTietNS extends javax.swing.JPanel {

    /**
     * Creates new form GD_XemChiTietNS
     * @throws RemoteException 
     */
    private void handlerBtnBack() throws RemoteException {
        Layout.instance.showLayout("tabNS");
        GD_QLNS.instance.updateData();
    }

    public void updateData(String id, String type) {
        System.out.println("id: " + id);
        System.out.println("type: " + type);
        if (type.equals("cn")) {
        	IDAOCongNhan daoCongNhan = (IDAOCongNhan) Naming.lookup(Client.URL + "DaoCongNhan");
            CongNhan congNhan = daoCongNhan.timKiemCongNhan(id);
            avtImage.setIcon(ImageCus.getScaledImageIconByte(congNhan.getAvatar(), 260, 400));
            lblCode.setText("Mã công nhân:");
            txtCode.setText(congNhan.getMaCN());
            txtBoPhan.setText(congNhan.getBoPhan().getTenBP());
            txtName.setText(congNhan.getTen());
            txtCccd.setText(congNhan.getCccd());
            txtDienThoai.setText(congNhan.getDienThoai());
            txtGioiTinh.setText(congNhan.isGioiTinh() ? "Nam" : "Nữ");
            txtNgaySinh.setText(congNhan.getNgaySinh().toString());
            txtNgayBatDauLam.setText(congNhan.getNgayBatDauLam().toString());

        } else if (type.equals("nv")) {
        	IDAONhanVien daoNhanVien = (IDAONhanVien) Naming.lookup(Client.URL + "DaoNhanVien");
            NhanVien nhanVien = daoNhanVien.get(id);
            avtImage.setIcon(ImageCus.getScaledImageIconByte(nhanVien.getAvatar(), 260, 400));
            lblCode.setText("Mã nhân viên:");
            txtCode.setText(nhanVien.getMaNV());
            txtBoPhan.setText(nhanVien.getBoPhan().getTenBP());
            txtName.setText(nhanVien.getTen());
            txtCccd.setText(nhanVien.getCccd());
            txtDienThoai.setText(nhanVien.getDienThoai());
            txtGioiTinh.setText(nhanVien.isGioiTinh() ? "Nam" : "Nữ");
            txtNgaySinh.setText(nhanVien.getNgaySinh().toString());
            txtNgaySinh.setText(nhanVien.getNgayBatDauLam().toString());
        }

    }

    public GD_XemChiTietNS() {
        initComponents();
        avtImage.setIcon(ImageCus.getScaledImageIcon("/assets/images/avatarCN/cn1.jpg", 260, 400));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnBack3 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        footer = new javax.swing.JPanel();
        avatar = new javax.swing.JPanel();
        avtImage = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JButton();
        btnThoiViec = new javax.swing.JButton();
        info = new javax.swing.JPanel();
        code = new javax.swing.JPanel();
        lblCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        boPhan = new javax.swing.JPanel();
        lblBoPhan = new javax.swing.JLabel();
        txtBoPhan = new javax.swing.JTextField();
        name = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cccd = new javax.swing.JPanel();
        lblCccd = new javax.swing.JLabel();
        txtCccd = new javax.swing.JTextField();
        dienThoai = new javax.swing.JPanel();
        lblDienThoai = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        gioiTinh = new javax.swing.JPanel();
        lblGioiTinh = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JTextField();
        ngaySinh = new javax.swing.JPanel();
        lblNgaySinh = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        ngayBatDauLam = new javax.swing.JPanel();
        lblNgayBatDauLam = new javax.swing.JLabel();
        txtNgayBatDauLam = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setPreferredSize(new java.awt.Dimension(499, 100));

        jPanel1.setBackground(new java.awt.Color(198, 222, 192));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 40));

        btnBack3.setBackground(new java.awt.Color(238, 250, 235));
        btnBack3.setForeground(new java.awt.Color(0, 0, 0));
        btnBack3.setText("Trở về");
        btnBack3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBack3.setPreferredSize(new java.awt.Dimension(150, 30));
        btnBack3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBack3MouseClicked(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBack3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

        );

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("CHI TIẾT NHÂN SỰ");
        title.setPreferredSize(new java.awt.Dimension(105, 60));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(header, java.awt.BorderLayout.NORTH);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        footer.setBackground(new java.awt.Color(198, 222, 192));
        footer.setPreferredSize(new java.awt.Dimension(1016, 150));

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1016, Short.MAX_VALUE)
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        body.add(footer, java.awt.BorderLayout.SOUTH);

        avatar.setPreferredSize(new java.awt.Dimension(300, 300));

        avtImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/avatarCN/cn2.jpg"))); // NOI18N
        avtImage.setPreferredSize(new java.awt.Dimension(300, 400));

        btnChinhSua.setBackground(new java.awt.Color(198, 222, 192));
        btnChinhSua.setForeground(new java.awt.Color(0, 0, 0));
        btnChinhSua.setText("Chỉnh sửa thông tin");
        btnChinhSua.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnChinhSua.setPreferredSize(new java.awt.Dimension(150, 30));
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnThoiViec.setBackground(new java.awt.Color(255, 102, 102));
        btnThoiViec.setForeground(new java.awt.Color(0, 0, 0));
        btnThoiViec.setText("Thôi việc");
        btnThoiViec.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThoiViec.setPreferredSize(new java.awt.Dimension(150, 30));
        btnThoiViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiViecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout avatarLayout = new javax.swing.GroupLayout(avatar);
        avatar.setLayout(avatarLayout);
        avatarLayout.setHorizontalGroup(
            avatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avatarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(avatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(avtImage, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(btnChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoiViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        avatarLayout.setVerticalGroup(
            avatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avatarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(avtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoiViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        body.add(avatar, java.awt.BorderLayout.WEST);

        info.setLayout(new java.awt.GridLayout(6, 2));

        code.setLayout(new java.awt.BorderLayout());

        lblCode.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCode.setForeground(new java.awt.Color(0, 0, 0));
        lblCode.setText("mã công nhân");
        lblCode.setPreferredSize(new java.awt.Dimension(150, 100));
        code.add(lblCode, java.awt.BorderLayout.WEST);

        txtCode.setEditable(false);
        txtCode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCode.setText("Đỗ Nhật Anh");
        txtCode.setBorder(null);
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });
        code.add(txtCode, java.awt.BorderLayout.CENTER);

        info.add(code);

        boPhan.setLayout(new java.awt.BorderLayout());

        lblBoPhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBoPhan.setForeground(new java.awt.Color(0, 0, 0));
        lblBoPhan.setText("Bộ phận:");
        lblBoPhan.setPreferredSize(new java.awt.Dimension(150, 100));
        boPhan.add(lblBoPhan, java.awt.BorderLayout.WEST);

        txtBoPhan.setEditable(false);
        txtBoPhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBoPhan.setText("Đỗ Nhật Anh");
        txtBoPhan.setBorder(null);
        txtBoPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoPhanActionPerformed(evt);
            }
        });
        boPhan.add(txtBoPhan, java.awt.BorderLayout.CENTER);

        info.add(boPhan);

        name.setLayout(new java.awt.BorderLayout());

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 0, 0));
        lblName.setText("Tên công nhân:");
        lblName.setPreferredSize(new java.awt.Dimension(150, 100));
        name.add(lblName, java.awt.BorderLayout.WEST);

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtName.setText("Đỗ Nhật Anh");
        txtName.setBorder(null);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        name.add(txtName, java.awt.BorderLayout.CENTER);

        info.add(name);

        cccd.setLayout(new java.awt.BorderLayout());

        lblCccd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCccd.setForeground(new java.awt.Color(0, 0, 0));
        lblCccd.setText("CCCD:");
        lblCccd.setPreferredSize(new java.awt.Dimension(150, 100));
        cccd.add(lblCccd, java.awt.BorderLayout.WEST);

        txtCccd.setEditable(false);
        txtCccd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCccd.setText("Đỗ Nhật Anh");
        txtCccd.setBorder(null);
        txtCccd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCccdActionPerformed(evt);
            }
        });
        cccd.add(txtCccd, java.awt.BorderLayout.CENTER);

        info.add(cccd);

        dienThoai.setLayout(new java.awt.BorderLayout());

        lblDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDienThoai.setForeground(new java.awt.Color(0, 0, 0));
        lblDienThoai.setText("Số điện thoại:");
        lblDienThoai.setPreferredSize(new java.awt.Dimension(150, 100));
        dienThoai.add(lblDienThoai, java.awt.BorderLayout.WEST);

        txtDienThoai.setEditable(false);
        txtDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDienThoai.setText("Đỗ Nhật Anh");
        txtDienThoai.setBorder(null);
        txtDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienThoaiActionPerformed(evt);
            }
        });
        dienThoai.add(txtDienThoai, java.awt.BorderLayout.CENTER);

        info.add(dienThoai);

        gioiTinh.setLayout(new java.awt.BorderLayout());

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(0, 0, 0));
        lblGioiTinh.setText("Giới tính:");
        lblGioiTinh.setPreferredSize(new java.awt.Dimension(150, 100));
        gioiTinh.add(lblGioiTinh, java.awt.BorderLayout.WEST);

        txtGioiTinh.setEditable(false);
        txtGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtGioiTinh.setText("Đỗ Nhật Anh");
        txtGioiTinh.setBorder(null);
        txtGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioiTinhActionPerformed(evt);
            }
        });
        gioiTinh.add(txtGioiTinh, java.awt.BorderLayout.CENTER);

        info.add(gioiTinh);

        ngaySinh.setLayout(new java.awt.BorderLayout());

        lblNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNgaySinh.setForeground(new java.awt.Color(0, 0, 0));
        lblNgaySinh.setText("Ngày sinh");
        lblNgaySinh.setPreferredSize(new java.awt.Dimension(150, 100));
        ngaySinh.add(lblNgaySinh, java.awt.BorderLayout.WEST);

        txtNgaySinh.setEditable(false);
        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNgaySinh.setText("Đỗ Nhật Anh");
        txtNgaySinh.setBorder(null);
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });
        ngaySinh.add(txtNgaySinh, java.awt.BorderLayout.CENTER);

        info.add(ngaySinh);

        ngayBatDauLam.setLayout(new java.awt.BorderLayout());

        lblNgayBatDauLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNgayBatDauLam.setForeground(new java.awt.Color(0, 0, 0));
        lblNgayBatDauLam.setText("Ngày vào làm:");
        lblNgayBatDauLam.setPreferredSize(new java.awt.Dimension(150, 100));
        ngayBatDauLam.add(lblNgayBatDauLam, java.awt.BorderLayout.WEST);

        txtNgayBatDauLam.setEditable(false);
        txtNgayBatDauLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNgayBatDauLam.setText("Đỗ Nhật Anh");
        txtNgayBatDauLam.setBorder(null);
        txtNgayBatDauLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayBatDauLamActionPerformed(evt);
            }
        });
        ngayBatDauLam.add(txtNgayBatDauLam, java.awt.BorderLayout.CENTER);

        info.add(ngayBatDauLam);

        body.add(info, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnThoiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiViecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoiViecActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtCccdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCccdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCccdActionPerformed

    private void txtDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDienThoaiActionPerformed

    private void txtGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioiTinhActionPerformed

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void txtNgayBatDauLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBatDauLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBatDauLamActionPerformed

    private void txtBoPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoPhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoPhanActionPerformed


    private void btnBack3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack3MouseClicked
        handlerBtnBack();
    }//GEN-LAST:event_btnBack3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel avatar;
    private javax.swing.JLabel avtImage;
    private javax.swing.JPanel boPhan;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnBack3;
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnThoiViec;
    private javax.swing.JPanel cccd;
    private javax.swing.JPanel code;
    private javax.swing.JPanel dienThoai;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel gioiTinh;
    private javax.swing.JPanel header;
    private javax.swing.JPanel info;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBoPhan;
    private javax.swing.JLabel lblCccd;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblDienThoai;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNgayBatDauLam;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JPanel name;
    private javax.swing.JPanel ngayBatDauLam;
    private javax.swing.JPanel ngaySinh;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBoPhan;
    private javax.swing.JTextField txtCccd;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNgayBatDauLam;
    private javax.swing.JTextField txtNgaySinh;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author usaid
 */
public class Form extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    public Form() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemCustomer = new javax.swing.JMenuItem();
        menuItemSupplier = new javax.swing.JMenuItem();
        menuItemPegawai = new javax.swing.JMenuItem();
        menuItemUser = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();
        menuMaster = new javax.swing.JMenu();
        menuItemBarang = new javax.swing.JMenuItem();
        menuItemSatuan = new javax.swing.JMenuItem();
        menuItemJabatan = new javax.swing.JMenuItem();
        menuItemGroup = new javax.swing.JMenuItem();
        menuItemHakAkses = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenu();
        menuItemTransaksiPembelian = new javax.swing.JMenuItem();
        menuItemTransaksiPenjualan = new javax.swing.JMenuItem();
        menuItemTransaksiReturnPembelian = new javax.swing.JMenuItem();
        menuItemTransaksiReturnPenjualan = new javax.swing.JMenuItem();
        menuItemTransaksiHutang = new javax.swing.JMenuItem();
        menuItemTransaksiPiutang = new javax.swing.JMenuItem();
        menuLaporan = new javax.swing.JMenu();
        menuLaporanPembelian = new javax.swing.JMenuItem();
        menuLaporanPenjualan = new javax.swing.JMenuItem();
        menuLaporanReturnPembelian = new javax.swing.JMenuItem();
        menuLaporanReturnPenjualan = new javax.swing.JMenuItem();
        menuLaporanHutang = new javax.swing.JMenuItem();
        menuLaporanPiutang = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuFile.setText("File");

        menuItemCustomer.setText("Customer");
        menuFile.add(menuItemCustomer);

        menuItemSupplier.setText("Supplier");
        menuFile.add(menuItemSupplier);

        menuItemPegawai.setText("Pegawai");
        menuFile.add(menuItemPegawai);

        menuItemUser.setText("User");
        menuFile.add(menuItemUser);

        menuItemLogout.setText("Logout");
        menuFile.add(menuItemLogout);

        jMenuBar1.add(menuFile);

        menuMaster.setText("Master");

        menuItemBarang.setText("Barang");
        menuMaster.add(menuItemBarang);

        menuItemSatuan.setText("Satuan");
        menuMaster.add(menuItemSatuan);

        menuItemJabatan.setText("Jabatan");
        menuMaster.add(menuItemJabatan);

        menuItemGroup.setText("Group User");
        menuMaster.add(menuItemGroup);

        menuItemHakAkses.setText("Hak Akses Group");
        menuMaster.add(menuItemHakAkses);

        jMenuBar1.add(menuMaster);

        menuTransaksi.setText("Transaksi");

        menuItemTransaksiPembelian.setText("Pembelian");
        menuTransaksi.add(menuItemTransaksiPembelian);

        menuItemTransaksiPenjualan.setText("Penjualan");
        menuTransaksi.add(menuItemTransaksiPenjualan);

        menuItemTransaksiReturnPembelian.setText("Return Pembelian");
        menuTransaksi.add(menuItemTransaksiReturnPembelian);

        menuItemTransaksiReturnPenjualan.setText("Return Penjualan");
        menuTransaksi.add(menuItemTransaksiReturnPenjualan);

        menuItemTransaksiHutang.setText("Hutang");
        menuTransaksi.add(menuItemTransaksiHutang);

        menuItemTransaksiPiutang.setText("Piutang");
        menuTransaksi.add(menuItemTransaksiPiutang);

        jMenuBar1.add(menuTransaksi);

        menuLaporan.setText("Laporan");

        menuLaporanPembelian.setText("Pembelian");
        menuLaporan.add(menuLaporanPembelian);

        menuLaporanPenjualan.setText("Penjualan");
        menuLaporan.add(menuLaporanPenjualan);

        menuLaporanReturnPembelian.setText("Pembelian");
        menuLaporan.add(menuLaporanReturnPembelian);

        menuLaporanReturnPenjualan.setText("Penjualan");
        menuLaporan.add(menuLaporanReturnPenjualan);

        menuLaporanHutang.setText("Hutang");
        menuLaporan.add(menuLaporanHutang);

        menuLaporanPiutang.setText("Piutang");
        menuLaporan.add(menuLaporanPiutang);

        jMenuBar1.add(menuLaporan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Form().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemBarang;
    private javax.swing.JMenuItem menuItemCustomer;
    private javax.swing.JMenuItem menuItemGroup;
    private javax.swing.JMenuItem menuItemHakAkses;
    private javax.swing.JMenuItem menuItemJabatan;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemPegawai;
    private javax.swing.JMenuItem menuItemSatuan;
    private javax.swing.JMenuItem menuItemSupplier;
    private javax.swing.JMenuItem menuItemTransaksiHutang;
    private javax.swing.JMenuItem menuItemTransaksiPembelian;
    private javax.swing.JMenuItem menuItemTransaksiPenjualan;
    private javax.swing.JMenuItem menuItemTransaksiPiutang;
    private javax.swing.JMenuItem menuItemTransaksiReturnPembelian;
    private javax.swing.JMenuItem menuItemTransaksiReturnPenjualan;
    private javax.swing.JMenuItem menuItemUser;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenuItem menuLaporanHutang;
    private javax.swing.JMenuItem menuLaporanPembelian;
    private javax.swing.JMenuItem menuLaporanPenjualan;
    private javax.swing.JMenuItem menuLaporanPiutang;
    private javax.swing.JMenuItem menuLaporanReturnPembelian;
    private javax.swing.JMenuItem menuLaporanReturnPenjualan;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenu menuTransaksi;
    // End of variables declaration//GEN-END:variables
}

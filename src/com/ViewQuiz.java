/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.table.TableHeaderAlignment;
import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import raven.toast.Notifications;

/**
 *
 * @author MUHAMMAD NAZLAN R
 */
public class ViewQuiz extends javax.swing.JFrame {
    String deviceId, username;
    String kuisId, title, kelas;
    private String[] kuisData = new String[5];

    /**
     * Creates new form PageList
     * @param username
     * @param deviceId
     */
    /**
     * Creates new form ViewQuiz
     */
    public ViewQuiz(String username, String deviceId) {
        initComponents();
        init();
        this.deviceId = deviceId;
        this.username = username;
        showList();
    }

private void init(){
    panel.putClientProperty(FlatClientProperties.STYLE,""
        + "background:$Table.background;");
    
     
    jTable1.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
        + "height:30;"
        + "hoverBackground:null;"
        + "pressedBackground:null;"
        + "separatorColor:$TableHeader.background;"
        + "font:bold $defaultFont");
    
    
    jTable1.putClientProperty(FlatClientProperties.STYLE, ""
        + "rowHeight:30;"
        + "showHorizontalLines:true;"
        + "intercellSpacing:0,1;"
        + "cellFocusColor:$TableHeader.hoverBackground;"
        + "selectionBackground:$TableHeader.hoverBackground;"
        + "selectionForeground:$Table.foreground"
        + "");
    
    jTable1.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(jTable1));
    
    jScrollPane1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
        + "trackArc:999;"
        + "trackInsets:3,3,3,3;"
        + "thumbInsets:3,3,3,3;"
        + "background:$Table.background;");
    
    FlatSVGIcon iconBack = new FlatSVGIcon("asset/icon/arrow-left.svg");
    backButton.setIcon(iconBack);
    
    FlatSVGIcon iconHapus = new FlatSVGIcon("asset/icon/trash-2.svg");
    hapusKuisButton.setIcon(iconHapus);
    
    hapusKuisButton.setIconTextGap(8);
    
    FlatSVGIcon iconPrint = new FlatSVGIcon("asset/icon/printer.svg");
    printButton.setIcon(iconPrint);

    printButton.setIconTextGap(8);

    jTextField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari kuis...");
    
    jTable1.getTableHeader().putClientProperty( "FlatLaf.style", "font: bold $large.font" );

}

private void showList(){
            Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://salamp.id/salampid_audio_vista",
                "salampid_admin", "passwordapa?");
            
            Statement statement;
            statement = connection.createStatement();
            ResultSet r;
            r = statement.executeQuery("select k.kuisId, title, class from device as d JOIN access AS a ON a.deviceId=d.deviceId JOIN kuis AS k ON k.kuisId=a.kuisId where a.deviceId='" + deviceId + "'");
            DefaultTableModel tb = new DefaultTableModel();
            tb.addColumn("ID Kuis");
            tb.addColumn("Judul Kuis");
            tb.addColumn("Kelas");
                       
            while (r.next()) {
                tb.addRow(new Object[] {
                    r.getString(1),r.getString(2),r.getString(3),
                });
            }
            jTable1.setModel(tb);
            r.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
}

private void setKuisData(String username, String deviceId, String kuisId, String title, String kelas) {
    kuisData[0] = username;
    kuisData[1] = deviceId;
    kuisData[2] = kuisId;
    kuisData[3] = title;
    kuisData[4] = kelas;
}

private String[] getKuisData() {
    return kuisData;
}

class RoundedPanel extends JPanel {
    private Color backgroundColor;
    private Color borderColor;
    private int cornerRadius = 15;
    private int borderWidth = 0;

    public RoundedPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
    }

    public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
    }

    public RoundedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    public void setBorderColor(Color color) {
        borderColor = color;
    }

    public void setBorderWidth(int width) {
        borderWidth = width;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded panel with borders
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // Paint background

        // Set border color and draw border only if borderWidth > 0
        if (borderWidth > 0) {
            if (borderColor != null) {
                graphics.setColor(borderColor);
            } else {
                graphics.setColor(getForeground());
            }
            graphics.setStroke(new BasicStroke(borderWidth));
            graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // Paint border
        }
    }


}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bukaButton = new javax.swing.JButton();
        hapusKuisButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AudioVista - ViewQuiz");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));

        panel = new RoundedPanel(36);
        panel.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID kuis", "Judul  kuis", "Kelas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(1032, 440));
        jTable1.setMinimumSize(new java.awt.Dimension(1032, 440));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        backButton.setText("Kembali");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+8));
        jLabel2.setText("Daftar kuis");
        jLabel2.setVerifyInputWhenFocusTarget(false);

        bukaButton.setText("Buka");
        bukaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukaButtonActionPerformed(evt);
            }
        });

        hapusKuisButton.setText("Hapus kuis");
        hapusKuisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKuisButtonActionPerformed(evt);
            }
        });

        printButton.setText("Cetak Daftar Kuis");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 432, Short.MAX_VALUE)
                        .addComponent(hapusKuisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bukaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bukaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusKuisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        FlatSVGIcon iconBuka = new FlatSVGIcon("asset/icon/open.svg");
        bukaButton.setIcon(iconBuka);
        bukaButton.setHorizontalTextPosition(JButton.LEADING);
        bukaButton.setVerticalTextPosition(JButton.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // Tombol kembali
        Dashboard dashboard = new Dashboard(username, deviceId);
        dashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
    
    // Fungsi buat nyari data ditabel 
    DefaultTableModel obj = (DefaultTableModel) jTable1.getModel();
    TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
    jTable1.setRowSorter(obj1);
    obj1.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
     
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       // Ngambil data pada baris klik mouse
       int row = jTable1.rowAtPoint(evt.getPoint());
        
       String t_kuisId = jTable1.getValueAt(row, 0).toString();
       String t_title = jTable1.getValueAt(row, 1).toString();
       String t_kelas = jTable1.getValueAt(row, 2).toString();
       
       setKuisData(username, deviceId, t_kuisId, t_title, t_kelas);

    }//GEN-LAST:event_jTable1MouseClicked

    private void bukaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukaButtonActionPerformed
       // Ngambil data yang disimpan sebelumnya
    
    String[] kuisData = getKuisData();
        if (kuisData[2] != null) {
            // Buka halaman berikutnya dengan data yang diperlukan
            EditQuiz obj = new EditQuiz(kuisData[0], kuisData[1], kuisData[2], kuisData[3], kuisData[4]);
            obj.setVisible(true);
            this.setVisible(false);
        } else{
            Notifications.getInstance().show(Notifications.Type.WARNING,"Pilih satu kuis yang ingin dibuka!");
            System.out.println("Data kuis tidak tersedia");
        }
    }//GEN-LAST:event_bukaButtonActionPerformed

    private void hapusKuisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKuisButtonActionPerformed
        
    int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING,"Pilih satu kuis pada tabel yang ingin dihapus!");
            return;
        }

    String kuisId = jTable1.getValueAt(selectedRow, 0).toString();

    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus kuis ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
            "jdbc:mysql://salamp.id/salampid_audio_vista",
            "salampid_admin", "passwordapa?");
        
        String query = "DELETE FROM kuis WHERE kuisId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, kuisId);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
        
        //update
        showList();

        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Kuis berhasil dihapus!");
    } catch (Exception exception) {
        Notifications.getInstance().show(Notifications.Type.ERROR,"Kuis gagal dihapus!");
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + exception.getMessage());
    }
    }//GEN-LAST:event_hapusKuisButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        MessageFormat header = new MessageFormat("Data Kuis");
        MessageFormat footer = new MessageFormat("Halaman {0}");

        try {
            boolean complete = jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            if (complete) {
                JOptionPane.showMessageDialog(this, "Print Successful", "Print", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Print Cancelled", "Print", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(this, "Print Failed: " + pe.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton bukaButton;
    private javax.swing.JButton hapusKuisButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
}
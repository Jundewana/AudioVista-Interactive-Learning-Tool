/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com;

import static com.DatabaseConnection.configDB;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.ui.FlatBorder;
import com.formdev.flatlaf.ui.FlatLineBorder;
import com.formdev.flatlaf.util.UIScale;
import com.table.TableHeaderAlignment;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import javax.management.Notification;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;
import java.sql.PreparedStatement;
import java.text.MessageFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author MUHAMMAD NAZLAN R
 */
public class EditQuiz extends javax.swing.JFrame {
    String deviceId, username;
    String kuisId, title, kelas;
    ArrayList<String> idList = new ArrayList<>();
    int prevLength;
  
    /**
     * Creates new form 
     * @param username
     * @param deviceId
     * @param kuisId
     * @param title
     * @param kelas
     */
    /**
     * Creates new form ViewQuiz
     */
    public EditQuiz(String username, String deviceId, String kuisId, String title, String kelas) {
        initComponents();
        init();
        this.deviceId = deviceId;
        this.username = username;
        this.kuisId = kuisId;
        
        
        labelJudul.setText(title);
        labelJudul1.setText(kelas);

        showQuest();

    }

private void init(){
    GlassPanePopup.install(this);
    Notifications.getInstance().setJFrame(this);
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
        + "selectionForeground:$Table.foreground");
    
    jTable1.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(jTable1));
    
    jScrollPane1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
        + "trackArc:999;"
        + "trackInsets:3,3,3,3;"
        + "thumbInsets:3,3,3,3;"
        + "background:$Table.background;");
    
    FlatSVGIcon iconBack = new FlatSVGIcon("asset/icon/arrow-left.svg");
    backButton.setIcon(iconBack);
    
    FlatSVGIcon iconDelete = new FlatSVGIcon("asset/icon/trash-2.svg");
    hapusButton.setIcon(iconDelete);
    
    hapusButton.setIconTextGap(8);
    
    FlatSVGIcon iconEdit = new FlatSVGIcon("asset/icon/edit.svg");
    editButton.setIcon(iconEdit);
    
    editButton.setIconTextGap(8);
    
    FlatSVGIcon iconUbah = new FlatSVGIcon("asset/icon/edit.svg");
    ubahJudulButton.setIcon(iconUbah);
    
    ubahJudulButton.setIconTextGap(8);
    
    FlatSVGIcon iconPlus = new FlatSVGIcon("asset/icon/plus.svg");
    tambahButton.setIcon(iconPlus);
    
    tambahButton.setIconTextGap(8);
    
    FlatSVGIcon iconPrint = new FlatSVGIcon("asset/icon/printer.svg");
    printButton.setIcon(iconPrint);
    
    printButton.setIconTextGap(8);
    
    FlatSVGIcon iconPie = new FlatSVGIcon("asset/icon/pie-chart.svg");
    diagramButton.setIcon(iconPie);
    
    diagramButton.setIconTextGap(8);
    

    jTextField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari pertanyaan...");
    
    jTable1.getTableHeader().putClientProperty( "FlatLaf.style", "font: bold $large.font" );

}

private void showQuest() {
    
    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
            "jdbc:mysql://salamp.id/salampid_audio_vista",
            "salampid_admin", "passwordapa?");
        System.out.println("Koneksi berhasil");

        // Debug statement untuk meriksa nilai kuisId
        if (kuisId == null) {
            System.out.println("kuisId adalah null. Pastikan kuisId diinisialisasi dengan benar.");
            return;
        } else {
            System.out.println("kuisId: " + kuisId);
        }

        Statement statement = connection.createStatement();
        ResultSet r = statement.executeQuery(
            "SELECT questionsId, quest, ansA, ansB, valid " +
            "FROM questions AS q " +
            "WHERE kuisId = '" + kuisId + "'");

        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("ID");
        tb.addColumn("Pertanyaan");
        tb.addColumn("Jawaban A");
        tb.addColumn("Jawaban B");
        tb.addColumn("Valid");

        boolean hasData = false;
        while (r.next()) {
            hasData = true;
            idList.add(r.getString(1));
            tb.addRow(new Object[] {
                r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5)
            });
        }

        if (!hasData) {
            System.out.println("Tidak ada data ditemukan untuk kuisId: " + kuisId);
            return;
        }

        jTable1.setModel(tb);
        prevLength = tb.getRowCount();
        r.close();
        statement.close();
        connection.close();
    } catch (Exception exception) {
        System.out.println("Terjadi kesalahan: " + exception.getMessage());
    }
}

private void fireTableDataChanged(DefaultTableModel model) {
    model.fireTableDataChanged();
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
        tambahButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        ubahJudulButton = new javax.swing.JButton();
        labelJudul = new javax.swing.JLabel();
        txtJudul1 = new javax.swing.JLabel();
        txtJudul2 = new javax.swing.JLabel();
        labelJudul1 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        diagramButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AudioVista - EditQuiz");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));

        panel = new RoundedPanel(36);
        panel.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Pertanyaan", "Jawaban 1", "Jawaban 2", "Valid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(1032, 440));
        jTable1.setMinimumSize(new java.awt.Dimension(1032, 440));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(75);
        }

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
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

        tambahButton.setText("Tambah ");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit ");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        ubahJudulButton.setText("Ubah judul dan kelas");
        ubahJudulButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahJudulButtonActionPerformed(evt);
            }
        });

        labelJudul.setFont(labelJudul.getFont().deriveFont(labelJudul.getFont().getStyle() | java.awt.Font.BOLD, labelJudul.getFont().getSize()+4));
        labelJudul.setText("Label Judul");

        txtJudul1.setFont(txtJudul1.getFont().deriveFont(txtJudul1.getFont().getStyle() | java.awt.Font.BOLD, txtJudul1.getFont().getSize()+4));
        txtJudul1.setText("Judul : ");

        txtJudul2.setFont(txtJudul2.getFont().deriveFont(txtJudul2.getFont().getStyle() | java.awt.Font.BOLD, txtJudul2.getFont().getSize()+4));
        txtJudul2.setText("Kelas : ");

        labelJudul1.setFont(labelJudul1.getFont().deriveFont(labelJudul1.getFont().getStyle() | java.awt.Font.BOLD, labelJudul1.getFont().getSize()+4));
        labelJudul1.setText("Label Kelas");

        printButton.setText("Cetak data kuis");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        diagramButton.setText("Diagram pie");
        diagramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagramButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(diagramButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(txtJudul1)
                        .addGap(0, 0, 0)
                        .addComponent(labelJudul)
                        .addGap(18, 18, 18)
                        .addComponent(txtJudul2)
                        .addGap(0, 0, 0)
                        .addComponent(labelJudul1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                        .addComponent(ubahJudulButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(24, 24, 24))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtJudul2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelJudul1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(ubahJudulButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagramButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    ViewQuiz viewQuiz = new ViewQuiz(username, deviceId);
    viewQuiz.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
    DefaultTableModel obj = (DefaultTableModel) jTable1.getModel();
    TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
    jTable1.setRowSorter(obj1);
    obj1.setRowFilter(RowFilter.regexFilter(jTextField1.getText())); 
    }//GEN-LAST:event_jTextField1KeyReleased

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed

        PanelTambahKuis pnk = new PanelTambahKuis();
        DefaultOption option = new DefaultOption(){
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
            
            @Override
            public float opacity() {
                return 0.75f;
            }
            
        };
        String actions[]=new String[]{"Batalkan","Simpan"};
        GlassPanePopup.showPopup(new SimplePopupBorder(pnk, "Tambah pertanyaan",actions,(pc, i)->{
            if(i==1){
            // Ambil data dari PanelTambahKuis
            String pertanyaan = pnk.getTxtAreaPertanyaan().getText();
            String jawabanA = pnk.getTxtJawabanA().getText();
            String jawabanB = pnk.getTxtJawabanB().getText();
            String valid = (String) pnk.getComboBoxValid().getSelectedItem();

            // Validasi input
            if (pertanyaan.isEmpty() || jawabanA.isEmpty() || jawabanB.isEmpty() || valid.isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.WARNING,"Semua data harus diisi");
                return;
            }

            // Simpan data ke database
            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://salamp.id/salampid_audio_vista",
                        "salampid_admin", "passwordapa?");
                String query = "INSERT INTO questions (kuisId, quest, ansA, ansB, valid) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, kuisId);
                preparedStatement.setString(2, pertanyaan);
                preparedStatement.setString(3, jawabanA);
                preparedStatement.setString(4, jawabanB);
                preparedStatement.setString(5, valid);
                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();

                // Perbarui tabel di EditQuiz
                showQuest();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Pertanyaan berhasil ditambahkan.");
                pc.closePopup();
                
                } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + exception.getMessage());
                exception.printStackTrace();
            }
            }else{
                pc.closePopup();
            } 
        }),option);
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
       int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        Notifications.getInstance().show(Notifications.Type.WARNING,"Pilih satu kuis yang ingin diedit!");
        return;
    }

    String questionsId = jTable1.getValueAt(selectedRow, 0).toString();
    String pertanyaan = jTable1.getValueAt(selectedRow, 1).toString();
    String jawabanA = jTable1.getValueAt(selectedRow, 2).toString();
    String jawabanB = jTable1.getValueAt(selectedRow, 3).toString();
    String valid = jTable1.getValueAt(selectedRow, 4).toString();

    PanelEditKuis penk = new PanelEditKuis();
    penk.setPertanyaan(pertanyaan);
    penk.setJawabanA(jawabanA);
    penk.setJawabanB(jawabanB);
    penk.setValid(valid);

    DefaultOption option = new DefaultOption() {
        @Override
        public boolean closeWhenClickOutside() {
            return true;
        }

        @Override
        public float opacity() {
            return 0.75f;
        }
    };
    String actions[] = new String[]{"Batalkan", "Simpan"};
    GlassPanePopup.showPopup(new SimplePopupBorder(penk, "Edit pertanyaan", actions, (pc, i) -> {
        if (i == 1) {
            // Ambil data dari PanelEditKuis
            String newPertanyaan = penk.getPertanyaan();
            String newJawabanA = penk.getJawabanA();
            String newJawabanB = penk.getJawabanB();
            String newValid = penk.getValid();

            // Validasi input
            if (newPertanyaan.isEmpty() || newJawabanA.isEmpty() || newJawabanB.isEmpty() || newValid.isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.WARNING,"Semua data harus diisi");
                return;
            }

            // Update data di database
            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://salamp.id/salampid_audio_vista",
                        "salampid_admin", "passwordapa?");
                String query = "UPDATE questions SET quest = ?, ansA = ?, ansB = ?, valid = ? WHERE questionsId = ? AND kuisId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, newPertanyaan);
                preparedStatement.setString(2, newJawabanA);
                preparedStatement.setString(3, newJawabanB);
                preparedStatement.setString(4, newValid);
                preparedStatement.setString(5, questionsId);
                preparedStatement.setString(6, kuisId);
                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();

                // Perbarui tabel di EditQuiz
                showQuest();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Pertanyaan berhasil diupdate.");    
                //JOptionPane.showMessageDialog(null, "Pertanyaan berhasil diupdate.");
                pc.closePopup();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + exception.getMessage());
                exception.printStackTrace();
            }
        } else {
            pc.closePopup();
        }
    }), option);
    }//GEN-LAST:event_editButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
       int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        Notifications.getInstance().show(Notifications.Type.WARNING,"Pilih satu pertanyaan pada tabel yang ingin dihapus");
        return;
    }

    int confirmation = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus pertanyaan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirmation == JOptionPane.YES_OPTION) {
        String questionsId = jTable1.getValueAt(selectedRow, 0).toString();

        // Hapus data dari database
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://salamp.id/salampid_audio_vista",
                    "salampid_admin", "passwordapa?");
            String query = "DELETE FROM questions WHERE questionsId = ? AND kuisId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, questionsId);
            preparedStatement.setString(2, kuisId);
            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            if (rowsAffected > 0) {
                // Hapus baris dari model tabel
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(selectedRow);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Pertanyaan berhasil dihapus.");

                // Periksa tabel kosong abis diapus
                if (model.getRowCount() == 0) {
                    model.setRowCount(0); // Ini mungkin redundant jika sudah memanggil removeRow
                    fireTableDataChanged(model); // Memastiin  perubahan diterapin
                }
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Pertanyaan gagal dihapus.");
            }

        } catch (Exception exception) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Pertanyaan gagal dihapus.");
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + exception.getMessage());
            exception.printStackTrace();
        }
    }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void ubahJudulButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahJudulButtonActionPerformed
        String currentTitle = labelJudul.getText();
        String currentClass = labelJudul1.getText();
        
        PanelUbahJudulKelas pujk = new PanelUbahJudulKelas();
        DefaultOption option = new DefaultOption(){
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
            
            @Override
            public float opacity() {
                return 0.75f;
            }
            
        };
        String actions[] = new String[]{"Batalkan", "Simpan"};
        GlassPanePopup.showPopup(new SimplePopupBorder(pujk, "Ubah Judul dan Kelas", actions, (pc, i) -> {
        if (i == 1) {
            // Simpan perubahan
            String newTitle = pujk.getTxtJudul().getText();
            String newClass = pujk.getTxtKelas().getText();
            if (!newTitle.isEmpty() && !newClass.isEmpty()) {
                try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://salamp.id/salampid_audio_vista",
                        "salampid_admin", "passwordapa?");
                String query = "UPDATE kuis SET title = ?, class = ? WHERE kuisId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, newTitle);
                preparedStatement.setString(2, newClass);
                preparedStatement.setString(3, kuisId);
                preparedStatement.executeUpdate();
                
                preparedStatement.close();
                connection.close();
                
                labelJudul.setText(newTitle);
                labelJudul1.setText(newClass);
                
                showQuest();
                
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Judul dan kelas berhasil diubah");
                } catch (Exception e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Gagal mengubah judul dan kelas");
                }
                pc.closePopup();
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING,"Harap isi judul dan kelas!");
            }
        } else {
            pc.closePopup();
        }
    }), option);
    }//GEN-LAST:event_ubahJudulButtonActionPerformed

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

    private void diagramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagramButtonActionPerformed
           // TODO add your handling code here:
    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
            "jdbc:mysql://salamp.id/salampid_audio_vista",
            "salampid_admin", "passwordapa?");
        
        // Menghitung jumlah jawaban valid "true" dan "false"
        int trueCount = 0;
        int falseCount = 0;

        Statement statement = connection.createStatement();
        ResultSet r = statement.executeQuery("SELECT answers FROM plays WHERE kuisId='" + kuisId + "'");
        
        
        while (r.next()) {
            String[] answer = r.getString("answers").split(",");
            
            for (String value : answer) {
                if (value.equalsIgnoreCase("TRUE")) {
                    System.out.println("Ketemu True");
                    trueCount++;
                } else if (value.equalsIgnoreCase("FALSE")) {
                    System.out.println("Ketemu False");
                    falseCount++;
                }
            }
        }

        // Buat dataset untuk pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("TRUE", trueCount);
        dataset.setValue("FALSE", falseCount);
        
        if (trueCount == 0 && falseCount == 0) {
            Notifications.getInstance().show(Notifications.Type.INFO, "Data tidak ditemukan, belum ada yang memainkan kuis.");
            return; 
        }

        // Buat pie chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Distribution of Responses", // Judul chart
            dataset, // Dataset
            true, // Legenda
            true, // Tooltip
            false // URL
        );

        JFrame frame = new JFrame("Pie Chart");
        frame.setSize(200,200);
        frame.setLocationRelativeTo(this);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(chart);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);

        connection.close();
    } catch (Exception exception) {
        System.out.println(exception);
        JOptionPane.showMessageDialog(null, exception, "Failed", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_diagramButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton diagramButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JLabel labelJudul1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton printButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JLabel txtJudul1;
    private javax.swing.JLabel txtJudul2;
    private javax.swing.JButton ubahJudulButton;
    // End of variables declaration//GEN-END:variables
}
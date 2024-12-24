/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import raven.popup.GlassPanePopup;
import raven.popup.DefaultOption;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MUHAMMAD NAZLAN R
 */
public class Dashboard extends javax.swing.JFrame {
    String deviceId, username;
    /**
     * Creates new form PageData
     * @param username
     * @param deviceId
     */
    /**
     * Creates new form Dashboard
     */
    public Dashboard(String username, String deviceId) {
        initComponents();
        this.deviceId = deviceId;
        this.username = username;
        init();
    }
    
    private void init(){
        
        GlassPanePopup.install(this);
        Notifications.getInstance();
        jTextArea1.putClientProperty(FlatClientProperties.STYLE, ""
            + "font:$semibold.font");
        jToggleButton1.putClientProperty( "JButton.buttonType", "roundRect" );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dBackground1 = new asset.DBackground();
        keluarButton = new javax.swing.JButton();
        lihatButton = new javax.swing.JButton();
        buatButton = new javax.swing.JButton();
        kreditButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AudioVista - Dashboard");
        setSize(new java.awt.Dimension(1280, 720));

        keluarButton.setText("Keluar");
        keluarButton.setIconTextGap(12);
        keluarButton.setMaximumSize(new java.awt.Dimension(100, 100));
        keluarButton.setMinimumSize(new java.awt.Dimension(100, 100));
        keluarButton.setPreferredSize(new java.awt.Dimension(100, 100));
        keluarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarButtonActionPerformed(evt);
            }
        });
        dBackground1.add(keluarButton);
        keluarButton.setBounds(214, 422, 212, 36);
        FlatSVGIcon iconOut = new FlatSVGIcon("asset/icon/log-out.svg");
        keluarButton.setIcon(iconOut);

        lihatButton.setText("Lihat kuis");
        lihatButton.setMaximumSize(new java.awt.Dimension(100, 100));
        lihatButton.setMinimumSize(new java.awt.Dimension(100, 100));
        lihatButton.setPreferredSize(new java.awt.Dimension(100, 100));
        lihatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatButtonActionPerformed(evt);
            }
        });
        dBackground1.add(lihatButton);
        lihatButton.setBounds(214, 262, 100, 100);
        FlatSVGIcon iconView = new FlatSVGIcon("asset/icon/folder.svg");
        lihatButton.setIcon(iconView);
        lihatButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        lihatButton.setHorizontalTextPosition(SwingConstants.CENTER);

        buatButton.setText("Buat kuis");
        buatButton.setMaximumSize(new java.awt.Dimension(100, 100));
        buatButton.setMinimumSize(new java.awt.Dimension(100, 100));
        buatButton.setPreferredSize(new java.awt.Dimension(100, 100));
        buatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buatButtonActionPerformed(evt);
            }
        });
        dBackground1.add(buatButton);
        buatButton.setBounds(326, 262, 100, 100);
        FlatSVGIcon iconCreate = new FlatSVGIcon("asset/icon/plus.svg");
        buatButton.setIcon(iconCreate);
        buatButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        buatButton.setHorizontalTextPosition(SwingConstants.CENTER);

        kreditButton.setText("Kredit");
        kreditButton.setIconTextGap(12);
        kreditButton.setMaximumSize(new java.awt.Dimension(100, 100));
        kreditButton.setMinimumSize(new java.awt.Dimension(100, 100));
        kreditButton.setPreferredSize(new java.awt.Dimension(100, 100));
        kreditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kreditButtonActionPerformed(evt);
            }
        });
        dBackground1.add(kreditButton);
        kreditButton.setBounds(214, 374, 212, 36);
        FlatSVGIcon icon = new FlatSVGIcon("asset/icon/users.svg");
        kreditButton.setIcon(icon);

        jLabel2.setFont(new java.awt.Font("Nunito", 1, 64)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 190, 34));
        jLabel2.setText("AudioVista");
        dBackground1.add(jLabel2);
        jLabel2.setBounds(640, 262, 329, 88);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(null);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("[au·di·o·vis·ta] /ˌɔːdi.oʊˈvistə/ n. adalah alat bantu belajar interaktif untuk siswa tunanetra, menggunakan Raspberry Pi Zero 2W dan web untuk menginput soal oleh guru, membacakan soal melalui speaker, serta merekam jawaban siswa. Alat ini bertujuan untuk meningkatkan interaktivitas pembelajaran dan memfasilitasi evaluasi oleh guru.");
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextArea1.setEnabled(false);
        jTextArea1.setMaximumSize(new java.awt.Dimension(555, 95));
        jTextArea1.setMinimumSize(new java.awt.Dimension(555, 95));
        jTextArea1.setOpaque(false);
        jTextArea1.setPreferredSize(new java.awt.Dimension(555, 95));
        jTextArea1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setBorder(BorderFactory.createEmptyBorder());

        dBackground1.add(jScrollPane1);
        jScrollPane1.setBounds(640, 356, 555, 70);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());

        jToggleButton1.setText("EN");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        dBackground1.add(jToggleButton1);
        jToggleButton1.setBounds(640, 430, 50, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(dBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buatButtonActionPerformed
        PanelBuatKuis pbk = new PanelBuatKuis();
        
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
    GlassPanePopup.showPopup(new SimplePopupBorder(pbk, "Buat Kuis Baru", actions, (pc, i) -> {
        if (i == 1) {
            // Simpan kuis baru
            String newTitle = pbk.getTxtJudul().getText();
            String newClass = pbk.getTxtKelas().getText();
            Connection connection = null;
            if (!newTitle.isEmpty() && !newClass.isEmpty()) {
                try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://salamp.id/salampid_audio_vista",
                "salampid_admin", "passwordapa?");
            
            String sql = "INSERT INTO kuis (title, class) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newTitle);
            preparedStatement.setString(2, newClass);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                long generatedId = generatedKeys.getLong(1);
                String sql2 = "INSERT INTO access (deviceId, kuisId) VALUES (?,?)";
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.setString(1, deviceId);
                preparedStatement2.setLong(2, generatedId);
                int rowsAffected2 = preparedStatement2.executeUpdate();
                System.out.println(rowsAffected2 + " row(s) inserted.");
            }
                    connection.close();

                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Kuis berhasil dibuat");
                    // Alihkan ke halaman ViewQuiz
                    ViewQuiz viewQuiz = new ViewQuiz(username,deviceId);
                    viewQuiz.setVisible(true);
                    this.setVisible(false);
                } catch (Exception e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Gagal membuat kuis");
                }
                pc.closePopup();
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING,"Judul dan kelas tidak boleh kosong!");
            }
        } else {
            pc.closePopup();
        }
    }), option);
    }//GEN-LAST:event_buatButtonActionPerformed

    private void kreditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kreditButtonActionPerformed
        PanelKredit kredit = new PanelKredit();
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
        String actions[]=new String[]{"Tutup"};
        GlassPanePopup.showPopup(new SimplePopupBorder(kredit, "Kredit",actions,(pc, i)->{
            if(i==0){
                 pc.closePopup();
            }
        }),option);
    }//GEN-LAST:event_kreditButtonActionPerformed

    private void lihatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatButtonActionPerformed
        ViewQuiz viewQuiz = new ViewQuiz(username, deviceId);
        viewQuiz.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lihatButtonActionPerformed

    private void keluarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarButtonActionPerformed
        int option = JOptionPane.showInternalConfirmDialog(null,"Anda yakin logout?", "Perhatian", JOptionPane.YES_NO_OPTION);
        if (option == 0){
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_keluarButtonActionPerformed

    private String teksBahasaIndonesia = "[au·di·o·vis·ta] /ˌɔːdi.oʊˈvistə/ n. adalah alat bantu belajar interaktif untuk siswa tunanetra, menggunakan Raspberry Pi Zero 2W dan web untuk menginput soal oleh guru, membacakan soal melalui speaker, serta merekam jawaban siswa. Alat ini bertujuan untuk meningkatkan interaktivitas pembelajaran dan memfasilitasi evaluasi oleh guru.";
    private String teksBahasaInggris = "[au·di·o·vis·ta] /ˌɔːdi.oʊˈvistə/ n. is an interactive learning tool for visually impaired students, using Raspberry Pi Zero 2W and the web to input questions by teachers, read questions through speakers, and record students' answers. This tool aims to enhance learning interactivity and facilitate evaluation by teachers.";
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
                    jToggleButton1.setText("ID");
                    jTextArea1.setText(teksBahasaInggris);
                } else {
                    jToggleButton1.setText("EN");
                    jTextArea1.setText(teksBahasaIndonesia);
                }
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buatButton;
    private asset.DBackground dBackground1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton keluarButton;
    private javax.swing.JButton kreditButton;
    private javax.swing.JButton lihatButton;
    // End of variables declaration//GEN-END:variables
}

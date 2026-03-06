package attendancems_with_prepared22;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TeacherInternalFrame extends javax.swing.JInternalFrame {
    ConnectClass c;

    public TeacherInternalFrame() {
        initComponents();
        c = new ConnectClass();
        setTitle("Select Batch");
        teacherName();
        fillcombo();
    }

    public void teacherName() {
        try {
            String b = LoginFrame.jTextField1.getText();
            String query = "SELECT teacher_name FROM tbl_teacher WHERE user_name = ?";
            PreparedStatement pst = c.xc.prepareStatement(query);
            pst.setString(1, b);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                teacherNameLabel.setText(rs.getString(1));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void fillcombo() {
        try {
            String query = "SELECT batch_code FROM tbl_batch JOIN tbl_teacher ON tbl_batch.teacher_id = tbl_teacher.teacher_id WHERE tbl_teacher.teacher_name = ? AND teacher_status = 'true'";
            PreparedStatement pst = c.xc.prepareStatement(query);
            pst.setString(1, teacherNameLabel.getText());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                jComboBox1.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static JComboBox getComboBox() {
        return jComboBox1;
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        teacherNameLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        BatchSelectionBG = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Candara", 1, 14));
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Teacher Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 170, 100, 30);

        jLabel2.setFont(new java.awt.Font("Candara", 1, 14));
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Batch Code");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(250, 210, 100, 30);

        teacherNameLabel.setFont(new java.awt.Font("Candara", 1, 14));
        teacherNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(teacherNameLabel);
        teacherNameLabel.setBounds(390, 170, 180, 30);

        jComboBox1.setFont(new java.awt.Font("Candara", 0, 14));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(390, 210, 180, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancems_with_prepared22/Project_Images/next.png")));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 280, 150, 40);

        BatchSelectionBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancems_with_prepared22/Project_Images/FrameBG.png")));
        getContentPane().add(BatchSelectionBG);
        BatchSelectionBG.setBounds(0, 0, 790, 520);

        setBounds(0, 0, 800, 550);
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String getValue = (String) jComboBox1.getSelectedItem().toString();
            String query = "SELECT batch_code FROM tbl_batch JOIN tbl_teacher ON tbl_batch.teacher_id = tbl_teacher.teacher_id WHERE tbl_teacher.teacher_name = ? AND batch_status = 'true'";
            PreparedStatement pst = c.xc.prepareStatement(query);
            pst.setString(1, teacherNameLabel.getText());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AttendFrame.jLabel1batchCode.setText(getValue);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        AttendFrame.jButton1.setEnabled(true);
        AttendFrame.jButton2.setEnabled(true);
        this.dispose();
    }

    private javax.swing.JLabel BatchSelectionBG;
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel teacherNameLabel;
}

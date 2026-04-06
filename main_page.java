import javax.swing.*;
import java.util.HashSet;

public class main_page extends javax.swing.JFrame {

    public static int p1 = 0;
    public static int p2 = 0;
    public static int p3 = 0;

    private static HashSet<String> voterIDs = new HashSet<>();

    public main_page() {
        initComponents();
    }

    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton2.setText("RESEND");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel1.setText("ONLINE VOTING SYSTEM");

        jLabel2.setText("ENTER NAME");

        jLabel3.setText("ENTER VOTER ID");

        jRadioButton1.setText("PARTY A");
        jRadioButton1.addActionListener(evt -> {
            if (jRadioButton1.isSelected()) {
                jRadioButton2.setSelected(false);
                jRadioButton3.setSelected(false);
            }
        });

        jRadioButton2.setText("PARTY B");
        jRadioButton2.addActionListener(evt -> {
            if (jRadioButton2.isSelected()) {
                jRadioButton1.setSelected(false);
                jRadioButton3.setSelected(false);
            }
        });

        jRadioButton3.setText("PARTY C");
        jRadioButton3.addActionListener(evt -> {
            if (jRadioButton3.isSelected()) {
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
            }
        });

        jLabel4.setText("CAST YOUR VOTE HERE");

        jButton1.setText("SUBMIT YOUR VOTE");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jButton4.setText("CHECK RESULTS");
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));

        // Layout code remains unchanged
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                                .addComponent(jLabel4)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(16, 16, 16)))))
                    .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton1)
                                .addComponent(jButton1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioButton3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jButton4)))
                    .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Unused for now
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextField1.getText().trim();
        String voterID = jTextField2.getText().trim();

        if (name.isEmpty() || voterID.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter both name and voter ID.");
            return;
        }

        if (voterID.length() != 10 || !voterID.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(rootPane, "Voter ID must be a 10-digit number.");
            return;
        }

        if (voterIDs.contains(voterID)) {
            JOptionPane.showMessageDialog(rootPane, "This Voter ID has already voted.");
            return;
        }

        if (voterIDs.size() >= 10) {
            JOptionPane.showMessageDialog(rootPane, "Voting limit reached. No more votes allowed.");
            return;
        }

        if (jRadioButton1.isSelected()) {
            p1++;
        } else if (jRadioButton2.isSelected()) {
            p2++;
        } else if (jRadioButton3.isSelected()) {
            p3++;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please select a party.");
            return;
        }

        voterIDs.add(voterID);
        JOptionPane.showMessageDialog(rootPane, "Vote submitted successfully!");

        // Clear fields
        jTextField1.setText("");
        jTextField2.setText("");
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        String result = "Party A: " + p1 + "\nParty B: " + p2 + "\nParty C: " + p3 + "\n\n";

        if (p1 > p2 && p1 > p3) {
            result += "🎉 PARTY A is leading!";
        } else if (p2 > p1 && p2 > p3) {
            result += "🎉 PARTY B is leading!";
        } else if (p3 > p1 && p3 > p2) {
            result += "🎉 PARTY C is leading!";
        } else if (p1 == p2 && p2 == p3 && p1 != 0) {
            result += "🤝 It's a three-way tie!";
        } else if (p1 == p2 && p1 > p3) {
            result += "🤝 It's a tie between PARTY A and PARTY B!";
        } else if (p1 == p3 && p1 > p2) {
            result += "🤝 It's a tie between PARTY A and PARTY C!";
        } else if (p2 == p3 && p2 > p1) {
            result += "🤝 It's a tie between PARTY B and PARTY C!";
        } else {
            result += "⚠️ No votes cast yet!";
        }

        JOptionPane.showMessageDialog(rootPane, result);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new main_page().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class main_page_modern extends JFrame {

    private static int p1 = 0, p2 = 0, p3 = 0;
    private static HashSet<String> voterIDs = new HashSet<>();

    // Components
    private JLabel titleLabel;
    private JLabel nameLabel, idLabel, voteLabel, statusLabel;
    private JTextField nameField, idField;
    private JRadioButton partyA, partyB, partyC;
    private ButtonGroup partyGroup;
    private JButton submitBtn, resultsBtn, resetBtn;
    private JPanel formPanel, resultsPanel, mainPanel;
    private JLabel resultsLabel;
    private JProgressBar voteBar1, voteBar2, voteBar3;
    private JLabel totalVotersLabel;

    public main_page_modern() {
        initUI();
    }

    private void initUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // Fallback to default
        }

        setTitle("Online Voting System - Modern UI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 500));
        getContentPane().setBackground(new Color(248, 249, 250));

        // Title
        titleLabel = new JLabel("🗳️ ONLINE VOTING SYSTEM", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 123, 255));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));

        // Form panel
        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 123, 255)), "Voter Information", 2, 2, new Font("Segoe UI", Font.BOLD, 16), new Color(0, 123, 255)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.anchor = GridBagConstraints.WEST;

        nameLabel = new JLabel("👤 Name:");
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);

        nameField = new JTextField(20);
        nameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        idLabel = new JLabel("🆔 Voter ID (10 digits):");
        idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(idLabel, gbc);

        idField = new JTextField(20);
        idField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(idField, gbc);

        voteLabel = new JLabel("Select Party:");
        voteLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        voteLabel.setForeground(new Color(0, 123, 255));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(voteLabel, gbc);

        partyGroup = new ButtonGroup();
        partyA = new JRadioButton("🇦 Party A");
        partyB = new JRadioButton("🇧 Party B");
        partyC = new JRadioButton("🇨 Party C");
        partyA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        partyB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        partyC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        partyGroup.add(partyA);
        partyGroup.add(partyB);
        partyGroup.add(partyC);

        gbc.gridwidth = 1;
        gbc.gridy = 3;
        gbc.gridx = 0;
        formPanel.add(partyA, gbc);
        gbc.gridx = 1;
        formPanel.add(partyB, gbc);
        gbc.gridy = 4;
        gbc.gridx = 0;
        formPanel.add(partyC, gbc);

        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        statusLabel.setForeground(Color.RED);
        gbc.gridx = 1; gbc.gridy = 4;
        formPanel.add(statusLabel, gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);
        submitBtn = new JButton("✅ Submit Vote");
        resultsBtn = new JButton("📊 View Results");
        resetBtn = new JButton("🔄 Reset Form");
        styleButton(submitBtn, new Color(40, 167, 69));
        styleButton(resultsBtn, new Color(0, 123, 255));
        styleButton(resetBtn, Color.GRAY);
        buttonPanel.add(submitBtn);
        buttonPanel.add(resultsBtn);
        buttonPanel.add(resetBtn);

        gbc.gridwidth = 2;
        gbc.gridy = 5;
        formPanel.add(buttonPanel, gbc);

        // Results panel (initially hidden)
        resultsPanel = createResultsPanel();

        // Main content
        mainPanel = new JPanel(new CardLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(formPanel, "form");
        mainPanel.add(resultsPanel, "results");

        // Total voters
        totalVotersLabel = new JLabel("Total Voters: 0 / 10");
        totalVotersLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        totalVotersLabel.setHorizontalAlignment(JLabel.CENTER);
        totalVotersLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Overall layout
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(totalVotersLabel, BorderLayout.SOUTH);

        // Events
        submitBtn.addActionListener(e -> submitVote());
        resultsBtn.addActionListener(e -> showResults());
        resetBtn.addActionListener(e -> resetForm());
        nameField.addFocusListener(new FieldValidator(nameField, nameLabel));
        idField.addFocusListener(new FieldValidator(idField, idLabel));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void styleButton(JButton btn, Color bg) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setRolloverEnabled(true);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(bg.getRed() - 20, bg.getGreen() - 20, bg.getBlue() - 20));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(bg);
            }
        });
    }

    private JPanel createResultsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 123, 255)), "Election Results", 2, 2, new Font("Segoe UI", Font.BOLD, 18), new Color(0, 123, 255)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        resultsLabel = new JLabel("Click Submit Vote to see results!");
        resultsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        resultsLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridwidth = 2;
        panel.add(resultsLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(new JLabel("Party A:"), gbc);
        voteBar1 = new JProgressBar(0, 100);
        voteBar1.setStringPainted(true);
        voteBar1.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 1;
        panel.add(voteBar1, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(new JLabel("Party B:"), gbc);
        voteBar2 = new JProgressBar(0, 100);
        voteBar2.setStringPainted(true);
        voteBar2.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 1;
        panel.add(voteBar2, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(new JLabel("Party C:"), gbc);
        voteBar3 = new JProgressBar(0, 100);
        voteBar3.setStringPainted(true);
        voteBar3.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 1;
        panel.add(voteBar3, gbc);

        return panel;
    }

    private void submitVote() {
        String name = nameField.getText().trim();
        String voterID = idField.getText().trim();

        statusLabel.setText("");
        nameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        idField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if (name.isEmpty()) {
            statusLabel.setText("Please enter name.");
            nameField.setBorder(BorderFactory.createLineBorder(Color.RED));
            nameField.requestFocus();
            return;
        }

        if (voterID.length() != 10 || !voterID.matches("\\d{10}")) {
            statusLabel.setText("Voter ID must be 10 digits.");
            idField.setBorder(BorderFactory.createLineBorder(Color.RED));
            idField.requestFocus();
            return;
        }

        if (voterIDs.contains(voterID)) {
            statusLabel.setText("Voter ID already used!");
            idField.setBorder(BorderFactory.createLineBorder(Color.RED));
            return;
        }

        if (voterIDs.size() >= 10) {
            statusLabel.setText("Max voters reached!");
            return;
        }

        if (partyA.isSelected()) p1++;
        else if (partyB.isSelected()) p2++;
        else if (partyC.isSelected()) p3++;
        else {
            statusLabel.setText("Select a party!");
            return;
        }

        voterIDs.add(voterID);
        statusLabel.setText("✅ Vote submitted!");
        statusLabel.setForeground(new Color(40, 167, 69));
        updateBars();
        resetForm();
    }

    private void showResults() {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "results");
    }

    private void resetForm() {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "form");
        nameField.setText("");
        idField.setText("");
        partyGroup.clearSelection();
        statusLabel.setText("");
        updateVotersLabel();
    }

    private void updateBars() {
        int total = p1 + p2 + p3;
        if (total > 0) {
            voteBar1.setValue((int) (p1 * 100f / total));
            voteBar2.setValue((int) (p2 * 100f / total));
            voteBar3.setValue((int) (p3 * 100f / total));
            voteBar1.setForeground(Color.BLUE);
            voteBar2.setForeground(Color.GREEN);
            voteBar3.setForeground(Color.ORANGE);
        }
        String leader = total > 0 ? getLeader() : "No votes";
        resultsLabel.setText("<html><center>Votes: A=" + p1 + " B=" + p2 + " C=" + p3 + "<br>" + leader + "</center></html>");
        updateVotersLabel();
    }

    private String getLeader() {
        if (p1 > p2 && p1 > p3) return "🏆 Party A leading!";
        if (p2 > p1 && p2 > p3) return "🏆 Party B leading!";
        if (p3 > p1 && p3 > p2) return "🏆 Party C leading!";
        if (p1 == p2 && p2 == p3) return "🤝 Three-way tie!";
        if (p1 == p2) return "🤝 A & B tie";
        if (p1 == p3) return "🤝 A & C tie";
        if (p2 == p3) return "🤝 B & C tie";
        return "Close race!";
    }

    private void updateVotersLabel() {
        totalVotersLabel.setText("Total Voters: " + voterIDs.size() + " / 10");
    }

    // Validator for fields
    class FieldValidator extends FocusAdapter {
        JTextField field;
        JLabel label;
        FieldValidator(JTextField f, JLabel l) {
            field = f; label = l;
        }
        public void focusGained(FocusEvent e) {
            field.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255)));
        }
        public void focusLost(FocusEvent e) {
            field.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new main_page_modern());
    }
}


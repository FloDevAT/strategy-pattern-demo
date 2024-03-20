package at.htlkaindorf.gui;

import at.htlkaindorf.bl.Encryptor;
import at.htlkaindorf.enums.CipherMethod;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.util.List;

public class EncryptorGUI extends JFrame {
    private JPanel pnContent;
    private JComboBox<CipherMethod> cbCipherSelection;
    private JButton btEncrypt;
    private JButton btDecrypt;
    private JTextArea taClearText;
    private JTextArea taCipherText;
    private JTextField tfKey;

    private DefaultComboBoxModel<CipherMethod> comboBoxModel;

    private Encryptor encryptor;

    public EncryptorGUI(String title) {
        setTitle(title);
        setContentPane(this.pnContent);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.encryptor = new Encryptor();

        this.comboBoxModel = new DefaultComboBoxModel<>();
        this.comboBoxModel.addAll(List.of(CipherMethod.values()));
        this.comboBoxModel.setSelectedItem(CipherMethod.values()[0]);

        this.cbCipherSelection.setModel(this.comboBoxModel);

        this.btEncrypt.addActionListener(l -> {
            try {
                onEncrypt();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        this.btDecrypt.addActionListener(l -> {
            try {
                onDecrypt();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private void onDecrypt() throws Exception {
        CipherMethod selectedCipher = (CipherMethod) this.cbCipherSelection.getSelectedItem();

        String cipherText = this.taCipherText.getText();
        String key = this.tfKey.getText();

        this.encryptor.setStrategy(selectedCipher.getStrategy());

        String clearText = this.encryptor.decrypt(cipherText, key);

        this.taClearText.setText(clearText);
    }

    private void onEncrypt() throws Exception {
        CipherMethod selectedCipher = (CipherMethod) this.cbCipherSelection.getSelectedItem();

        String clearText = this.taClearText.getText();
        String key = this.tfKey.getText();

        this.encryptor.setStrategy(selectedCipher.getStrategy());

        String cipher = this.encryptor.encrypt(clearText, key);

        this.taCipherText.setText(cipher);
    }

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        EncryptorGUI encryptorGUI = new EncryptorGUI("Encryptor");
        encryptorGUI.setVisible(true);
    }
}

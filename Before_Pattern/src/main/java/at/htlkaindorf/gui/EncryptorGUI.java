package at.htlkaindorf.gui;

import at.htlkaindorf.ciphers.Base64Cipher;
import at.htlkaindorf.ciphers.ReversingCipher;
import at.htlkaindorf.ciphers.XorCipher;
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

    public EncryptorGUI(String title) {
        setTitle(title);
        setContentPane(this.pnContent);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
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

        String clearText = "";

        if (selectedCipher == CipherMethod.BASE64) {
            clearText = Base64Cipher.decrypt(cipherText);
        } else if (selectedCipher == CipherMethod.XOR) {
            clearText = XorCipher.decrypt(cipherText, key);
        }

        this.taClearText.setText(clearText);
    }

    private void onEncrypt() throws Exception {
        CipherMethod selectedCipher = (CipherMethod) this.cbCipherSelection.getSelectedItem();

        String clearText = this.taClearText.getText();
        String key = this.tfKey.getText();

        String cipher = "";

        if (selectedCipher == CipherMethod.BASE64) {
            cipher = Base64Cipher.encrypt(clearText);
        } else if (selectedCipher == CipherMethod.XOR) {
            cipher = XorCipher.encrypt(clearText, key);
        } else if (selectedCipher == CipherMethod.REVERSE) {
            cipher = ReversingCipher.encrypt(clearText);
        }

        this.taCipherText.setText(cipher);
    }

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        EncryptorGUI encryptorGUI = new EncryptorGUI("Encryptor");
        encryptorGUI.setVisible(true);
    }
}

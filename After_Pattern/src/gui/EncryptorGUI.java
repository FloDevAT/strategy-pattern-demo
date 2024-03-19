package gui;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;
import encryptor.Encryptor;
import enums.CipherMethod;
import strategies.EncryptionStrategy;

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
        this.comboBoxModel = new DefaultComboBoxModel<>();
        this.comboBoxModel.addAll(List.of(CipherMethod.values()));

        this.cbCipherSelection.setModel(this.comboBoxModel);

        this.encryptor = new Encryptor();

        this.btEncrypt.addActionListener(l -> encrypt());
        this.btDecrypt.addActionListener(l -> decrypt());
    }

    public void encrypt() {
        String key = this.tfKey.getText();
        String clearText = this.taClearText.getText();
        EncryptionStrategy strategy = ((CipherMethod) this.comboBoxModel.getSelectedItem()).getStrategy();
        this.encryptor.setStrategy(strategy);
        String output = this.encryptor.encode(clearText, key);
        this.taCipherText.setText(output);
    }

    public void decrypt() {
        String key = this.tfKey.getText();
        String cipherText = this.taCipherText.getText();
        EncryptionStrategy strategy = ((CipherMethod) this.comboBoxModel.getSelectedItem()).getStrategy();
        this.encryptor.setStrategy(strategy);
        String output = this.encryptor.decode(cipherText, key);
        this.taClearText.setText(output);
    }




    public static void main(String[] args) {
        EncryptorGUI encryptorGUI = new EncryptorGUI("Encryptor");
        encryptorGUI.setVisible(true);
    }

}

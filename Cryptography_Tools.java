/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bp1_tugas_galbi;

/**
 *
 * @author galbi
 */
import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Cryptography_Tools extends Frame {

    public static void main(String[] args) {
        Cryptography_Tools test = new Cryptography_Tools();
    }

    private String caesarEncode(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private String caesarDecode(String text, int shift) {
        return caesarEncode(text, 26 - shift);
    }

    public Cryptography_Tools() {
        super("Cryptography Tools");
        setSize(600, 400);

        Choice cipherList = new Choice();
        cipherList.add("Caesar Cipher");
        cipherList.add("");

        Choice choice = new Choice();
        choice.add("Encode");
        choice.add("Decode");

        TextField inputField = new TextField();
        TextField outputField = new TextField();

        inputField.setPreferredSize(new Dimension(400, 140));
        outputField.setPreferredSize(new Dimension(400, 140));

        Panel northPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        northPanel.add(cipherList);
        northPanel.add(choice);
        northPanel.add(inputField, BorderLayout.NORTH);

        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        Button button = new Button("Encode");
        button.setPreferredSize(new Dimension(75, 25));

        choice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedChoice = choice.getSelectedItem();
                if (selectedChoice.equals("Decode")) {
                    button.setLabel("Decode");
                } else if (selectedChoice.equals("Encode")) {
                    button.setLabel("Encode");
                }
            }
        });
        buttonPanel.add(button);

        button.addActionListener(e -> {
            String inputText = inputField.getText();
            String selectedCipher = cipherList.getSelectedItem();
            String selectedChoice = choice.getSelectedItem();
            String outputText = "";

            if (selectedCipher.equals("Caesar Cipher")) {
                if (selectedChoice.equals("Encode")) {
                    outputText = caesarEncode(inputText, 3);
                } else {
                    outputText = caesarDecode(inputText, 3);
                }
            }
            outputField.setText(outputText);
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });

        Panel southPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        southPanel.add(outputField);

        add("North", northPanel);
        add("Center", buttonPanel);
        add("South", southPanel);

        setVisible(true);
    }
}

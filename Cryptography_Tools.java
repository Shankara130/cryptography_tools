/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

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
    
    public Cryptography_Tools() {
        super("Cryptography Tools");
        setSize(600,400);
        
        Choice cipherList = new Choice();
        cipherList.add("Caesar Cipher");
        cipherList.add("Vignere Cipher");
        
        Choice choice = new Choice();
        choice.add("Decode");
        choice.add("Encode");
        
        TextField inputField = new TextField();
        TextField outputField = new TextField();
        
        inputField.setPreferredSize(new Dimension(400, 140));
        outputField.setPreferredSize(new Dimension(400, 140));
                
        Panel northPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        northPanel.add(cipherList);
        northPanel.add(choice);
        northPanel.add(inputField, BorderLayout.NORTH);

        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        Button button = new Button("Decode");
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
        
        Panel southPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        southPanel.add(outputField);
        
        add("North", northPanel);
        add("Center", buttonPanel);
        add("South", southPanel);
        
        show();
    }
}

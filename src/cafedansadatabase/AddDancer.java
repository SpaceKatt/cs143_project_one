/*
 * Copyright (C) 2016 Thomas Kercheval
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cafedansadatabase;

import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * AddDancer.java
 * A class which defines the form by which users may add a dancer
 * to our application.
 * <pre>
    Project: CafeDansa Database
    Platform: jdk 1.8.0_14; NetBeans IDE 8.1; Windows 10
    Course: CS 143
    Created on Apr 5, 2016, 12:32:49 PM
    Revised on Arp 10, 2016, 2:30:21 PM
 </pre>
 * @author Thomas Kercheval
 */
public class AddDancer extends javax.swing.JDialog {

    /** The Dancer object which will be added to the Dancer database. */
    private Dancer newDancer;

    /** Creates new form AddDancer */
    public AddDancer() {
        initComponents();
    }

    /**
     * Constructor which spawns AddDancer GUI and sets modality.
     * @param aThis GUI which spawns AddDancer
     * @param b boolean value which indicates modality
     */
    AddDancer(DansaGUI aThis, boolean b) {
        this.setModal(b);
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/cafedansadatabase/Bottle_Dancers_USA.jpg"));
        this.getRootPane().setDefaultButton(addJButton);
        Integer[] yearOptions = new Integer[100];
        for (int i = 0; i < yearOptions.length; i++) {
            yearOptions[i] = i;
        }
        styleJComboBox.setModel(new DefaultComboBoxModel(
                DansaGUI.STYLES));
        profJComboBox.setModel(new DefaultComboBoxModel(
                DansaGUI.PROFICIENCIES));
        yearsJComboBox.setModel(new DefaultComboBoxModel(yearOptions));
    }

    /**
     * Method: getDancer
     * Returns the new Dancer object.
     * @return Dancer: the new dancer to be added.
     */
    Dancer getDancer() {
        return newDancer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        addJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        displayJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        styleJLabel = new javax.swing.JLabel();
        styleJComboBox = new javax.swing.JComboBox<>();
        profJLabel = new javax.swing.JLabel();
        profJComboBox = new javax.swing.JComboBox<>();
        yearsJLabel = new javax.swing.JLabel();
        yearsJComboBox = new javax.swing.JComboBox<>();
        phoneJLabel = new javax.swing.JLabel();
        phoneJTextField = new javax.swing.JTextField();
        emailJLabel = new javax.swing.JLabel();
        emailJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Dancer Form");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafedansadatabase/The-3-Dancers_3-photo-Chris-Nash-1024x682.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 2, 36)); // NOI18N
        jLabel2.setText("Add New Dancer");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(titlePanel, java.awt.BorderLayout.NORTH);

        controlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.setMinimumSize(new java.awt.Dimension(299, 45));
        controlPanel.setLayout(new java.awt.GridLayout(1, 5, 5, 5));

        addJButton.setBackground(new java.awt.Color(204, 255, 204));
        addJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addJButton.setMnemonic('S');
        addJButton.setText("Save");
        addJButton.setToolTipText("Save new Dancer");
        addJButton.setMinimumSize(new java.awt.Dimension(57, 45));
        addJButton.setPreferredSize(new java.awt.Dimension(57, 35));
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(addJButton);

        exitJButton.setBackground(new java.awt.Color(204, 255, 204));
        exitJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exitJButton.setMnemonic('C');
        exitJButton.setText("Cancel");
        exitJButton.setToolTipText("Cancel adding new Dancer");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(exitJButton);

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);

        displayJPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        displayJPanel.setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameJLabel.setText("Name of Dancer: ");
        displayJPanel.add(nameJLabel);

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJTextField.setToolTipText("Enter First&Last name, middle optional, must be capitalized...");
        displayJPanel.add(nameJTextField);

        styleJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        styleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        styleJLabel.setText("Style:");
        displayJPanel.add(styleJLabel);

        styleJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        styleJComboBox.setToolTipText("Select the style of dance");
        displayJPanel.add(styleJComboBox);

        profJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        profJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        profJLabel.setText("Level of Proficiency:");
        displayJPanel.add(profJLabel);

        profJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        profJComboBox.setToolTipText("Select the level of proficiency");
        displayJPanel.add(profJComboBox);

        yearsJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yearsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        yearsJLabel.setText("Years dancing:");
        displayJPanel.add(yearsJLabel);

        yearsJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearsJComboBox.setToolTipText("Select the number of years of experience");
        displayJPanel.add(yearsJComboBox);

        phoneJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        phoneJLabel.setText("phone:");
        displayJPanel.add(phoneJLabel);

        phoneJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phoneJTextField.setToolTipText("Enter phone number, with area code");
        displayJPanel.add(phoneJTextField);

        emailJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        emailJLabel.setText("email:");
        displayJPanel.add(emailJLabel);

        emailJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailJTextField.setToolTipText("Enter a valid email address");
        displayJPanel.add(emailJTextField);

        getContentPane().add(displayJPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event handler for saving the new dancer from text field input.
     * Validates input before saving and closing the pop-up window.
     * @param evt
     * @return void
     */
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        String name = nameJTextField.getText();
        String prof = (String) profJComboBox.getSelectedItem();
        int years = (int) yearsJComboBox.getSelectedItem();
        String phone = phoneJTextField.getText();
        String style = (String) styleJComboBox.getSelectedItem();
        String email = emailJTextField.getText();
        if (validateFields(name, phone, email)) { // If all fields are valid
            try {                                 // create dancer and close.
                newDancer = new Dancer(name, style, prof, years, phone, email);
                this.setVisible(false);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                                          "Some Fields must be numeric.",
                                          "Incomplete Form",
                                          JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveJButtonActionPerformed

    /**
     * Method to validate the input for a dancer.
     * Uses a Validation class which matches our input to regex patterns.
     * @param name Name of the Dancer to be added.
     * @param phone Phone of the Dancer to be added.
     * @param email Email of the Dancer to be added.
     * @see Validation
     * @return true if fields are valid.
     */
    private boolean validateFields(String name, String phone, String email) {
        if (!Validation.isName(name)) {
            JOptionPane.showMessageDialog(this,
                                          "Must enter a valid name.\n"
                                        + "First and Last, middle optional.\n"
                                        + "\nDid you remember to Capitalize?",
                                          "Incomplete Form",
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!Validation.isPhone(phone)) {
            JOptionPane.showMessageDialog(this,
                                          "Must enter a valid phone number.",
                                          "Incomplete Form",
                                          JOptionPane.ERROR_MESSAGE);
            
            return false;
        } else if (!Validation.isEmail(email)) {
            JOptionPane.showMessageDialog(this,
                                          "Must enter a valid email.",
                                          "Incomplete Form",
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        return true;
    }
    
    /**
     * Event handler for the cancellation of new Dancer creation.
     * @param evt
     * @return void
     */
    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        // End  program
        this.newDancer = null;
        this.setVisible(false);
    }//GEN-LAST:event_cancelJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JLabel emailJLabel;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JButton exitJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel phoneJLabel;
    private javax.swing.JTextField phoneJTextField;
    private javax.swing.JComboBox<String> profJComboBox;
    private javax.swing.JLabel profJLabel;
    private javax.swing.JComboBox<String> styleJComboBox;
    private javax.swing.JLabel styleJLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JComboBox<String> yearsJComboBox;
    private javax.swing.JLabel yearsJLabel;
    // End of variables declaration//GEN-END:variables
}

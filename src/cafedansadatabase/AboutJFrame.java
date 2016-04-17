/*
 * Copyright (C) 2016 thomas.kercheval
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

/**
 * AboutJFrame.java
 A class representing the GUI used in a maintaining a dancers database.
 * <pre>
    Project: Cafe Dansa Database
    Platform: jdk 1.8.0_14; NetBeans IDE 8.1; Windows 10
    Course:
    Hours: 0 Hours and 55 Min
    Created on Apr 11, 2016, 2:42:31 PM
    Revised on Apr 12, 2016, 12:05:24 PM
 </pre>
 *
 * @author:	thomas.kercheval@go.shoreline.edu
 * @version: 	%1% %2%
 */

public class AboutJFrame extends javax.swing.JDialog {

    /**
     * Spawns our JDialog to show information about our project.
     */
    public AboutJFrame() {
        initComponents();
        this.getRootPane().setDefaultButton(closeJButton);
        this.setModal(true);
        setLocationRelativeTo(null);
        this.jTextArea1.setCaretPosition(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJPanel = new javax.swing.JPanel();
        logoJLabel = new javax.swing.JLabel();
        titleJLabel = new javax.swing.JLabel();
        aboutJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        copyrightJLabel = new javax.swing.JLabel();
        closeJButton = new javax.swing.JButton();
        warningJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Large USA Cities About");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        logoJLabel.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        logoJLabel.setForeground(new java.awt.Color(51, 0, 0));
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafedansadatabase/Bottle_Dancers_USA.jpg"))); // NOI18N

        titleJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 24)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(51, 0, 0));
        titleJLabel.setText("Cafe Dansa Database");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(titleJPanel, java.awt.BorderLayout.NORTH);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("## Cafe Dansa Database Project\n\nA simple application for my Java class (CS143).\n\n### Project Objective:\n\nTo create an application for a dance club to keep track of members and\ntheir information.\n\n##### Features:\n\n  - Storing dancers in a database, we allow for users to add, edit, delete,\n    search, and print dancers from the club.\n  - Dancers may be listed in alphabetical order by last name or first name.\n  - Dancers may be listed in descending order of experience in years.\n  - Changes to the database are dynamic in nature, so Dancers that are\n    deleted do not reappear when the application is restarted.\n  - Both the GUI an individual's information may be printed, by the file\n    menu and the print button respectively.\n  - Splash screen is displayed on start-up.\n  - If a duplicate dancer is added to the database the action will be\n    prevented and the user will be notified without crashing the program.\n  - While editing a dancer, if their information is changed to match a\n    different dancer whom exists in the database then the dancer is not\n    edited and the user is notified without the program crashing.\n  - Fields from editing and adding Dancers are validated with regular\n    expressions.\n  - Dancer must have 2-3 (Capitalized) parts of their name to have valid\n    names.\n\n##### Notes:\n\n  - The class which adheres most rigorously to Java style standards is\n    Dancer.java\n  - This code is protected under GPL 3.0\n");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout aboutJPanelLayout = new javax.swing.GroupLayout(aboutJPanel);
        aboutJPanel.setLayout(aboutJPanelLayout);
        aboutJPanelLayout.setHorizontalGroup(
            aboutJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        aboutJPanelLayout.setVerticalGroup(
            aboutJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutJPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        getContentPane().add(aboutJPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        copyrightJLabel.setText("Copyright 2016; Thomas Kercheval");
        jPanel1.add(copyrightJLabel);

        closeJButton.setText("Close");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(closeJButton);

        warningJLabel.setText("If: Steal Code -> Then: Suffer Curse");
        jPanel1.add(warningJLabel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes this modal JDialog.
     * @param evt 
     */
    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutJPanel;
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel copyrightJLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JPanel titleJPanel;
    private javax.swing.JLabel warningJLabel;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces.bar;

import com.thursday.business.identities.CleaningCompUser;
import com.thursday.business.identities.User;
import com.thursday.interfaces.AdminManageStaffJPanel;
import com.thursday.interfaces.ManageAccountPanel;
import com.thursday.interfaces.cleaningcomp.CleaningAdminJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author CHEN JIEYING
 */
public class HRBarJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HRJPanel
     */
    private final User user;
    private JPanel rightPanel;

    public HRBarJPanel(JPanel rightPanel, User u) {
        this.user = u;
        this.rightPanel = rightPanel;
        initComponents();

    }

    private void CleaningAdminJPanel() {
        CleaningAdminJPanel cleaningAdminJPanel = new CleaningAdminJPanel(downPanel, user);
        CardLayout layout = (CardLayout) downPanel.getLayout();
        downPanel.add("CleaningAdminJPanel", cleaningAdminJPanel);
        layout.next(downPanel);
    }

    private void manageStaffJPanel() {
        CardLayout layout = (CardLayout) downPanel.getLayout();
        downPanel.add("AdminManageStaffJPanel", new AdminManageStaffJPanel(downPanel, user, CleaningCompUser.Roles.CLEANER));
        layout.next(downPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        manageReqBtn = new javax.swing.JButton();
        manageStaffBtn = new javax.swing.JButton();
        manageAccountBtn = new javax.swing.JButton();
        downPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jSplitPane1.setBorder(null);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        manageReqBtn.setText("Manage Requests");
        manageReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageReqBtnActionPerformed(evt);
            }
        });

        manageStaffBtn.setText("Manage Staff");
        manageStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStaffBtnActionPerformed(evt);
            }
        });

        manageAccountBtn.setText("Manage Account");
        manageAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(manageReqBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageReqBtn)
                    .addComponent(manageStaffBtn)
                    .addComponent(manageAccountBtn))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        downPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setBackground(new java.awt.Color(153, 255, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click button to continue");
        downPanel.add(jLabel2, "card2");

        jSplitPane1.setRightComponent(downPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageReqBtnActionPerformed
        // TODO add your handling code here:
        CleaningAdminJPanel();
    }//GEN-LAST:event_manageReqBtnActionPerformed

    private void manageStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStaffBtnActionPerformed
        // TODO add your handling code here:
        manageStaffJPanel();
    }//GEN-LAST:event_manageStaffBtnActionPerformed

    private void manageAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountBtnActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.downPanel.getLayout();
        this.downPanel.add("ManageAccountPanel", new ManageAccountPanel(downPanel, user));
        layout.next(downPanel);
    }//GEN-LAST:event_manageAccountBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel downPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageAccountBtn;
    private javax.swing.JButton manageReqBtn;
    private javax.swing.JButton manageStaffBtn;
    // End of variables declaration//GEN-END:variables
}

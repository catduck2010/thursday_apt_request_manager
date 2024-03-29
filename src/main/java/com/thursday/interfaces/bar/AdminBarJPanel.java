/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces.bar;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.User;
import com.thursday.interfaces.AdminManageStaffJPanel;
import com.thursday.interfaces.ManageAccountPanel;
import com.thursday.interfaces.apartment.ManageTaskJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author CHEN JIEYING
 */
public class AdminBarJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminBarJPanel
     */
    private final User user;
    private JPanel rightPanel;

    public AdminBarJPanel(JPanel rightPanel, User u) {
        initComponents();
        this.user = u;
        this.rightPanel = rightPanel;
    }

    private void manTaskPanel() {
        ManageTaskJPanel manageTaskJPanel = new ManageTaskJPanel(downPanel, user);
        CardLayout layout = (CardLayout) downPanel.getLayout();
        downPanel.add("ManageTaskJPanel", manageTaskJPanel);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnManageReq = new javax.swing.JButton();
        btnManageStaff = new javax.swing.JButton();
        btnManageTnmt = new javax.swing.JButton();
        manageAccountBtn = new javax.swing.JButton();
        downPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jSplitPane1.setBorder(null);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        btnManageReq.setText("Manage Requests");
        btnManageReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageReqActionPerformed(evt);
            }
        });

        btnManageStaff.setText("Manage Staff");
        btnManageStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageStaffActionPerformed(evt);
            }
        });

        btnManageTnmt.setText("Manage Tenements");
        btnManageTnmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageTnmtActionPerformed(evt);
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
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageReq, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(manageAccountBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageTnmt, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnManageStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageReq)
                    .addComponent(btnManageTnmt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageAccountBtn)
                    .addComponent(btnManageStaff))
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
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageStaffActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.downPanel.getLayout();
        JPanel panel = new AdminManageStaffJPanel(downPanel, user, ApartmentUser.Roles.REPAIRPERSON);
        this.downPanel.add("AdminManageStaffJPanel", panel);
        layout.next(this.downPanel);
    }//GEN-LAST:event_btnManageStaffActionPerformed

    private void btnManageTnmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageTnmtActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.downPanel.getLayout();
        this.downPanel.add("AdminManageResidentJPanel",new AdminManageStaffJPanel(downPanel, user, ApartmentUser.Roles.RESIDENT));
        layout.next(this.downPanel);
    }//GEN-LAST:event_btnManageTnmtActionPerformed

    private void btnManageReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageReqActionPerformed
        // TODO add your handling code here:
        manTaskPanel();
    }//GEN-LAST:event_btnManageReqActionPerformed

    private void manageAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountBtnActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.downPanel.getLayout();
        this.downPanel.add("ManageAccountPanel", new ManageAccountPanel(downPanel, user));
        layout.next(downPanel);
    }//GEN-LAST:event_manageAccountBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageReq;
    private javax.swing.JButton btnManageStaff;
    private javax.swing.JButton btnManageTnmt;
    private javax.swing.JPanel downPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageAccountBtn;
    // End of variables declaration//GEN-END:variables
}

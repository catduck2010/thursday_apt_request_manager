/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.CompanyDirectory;
import com.thursday.business.Company;
import com.thursday.business.UserDirectory;
import com.thursday.business.identities.User;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHEN JIEYING
 */
public class RootJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RootJPanel
     */
    private JPanel rightPanel;

    public RootJPanel(JPanel rightPanel) {
        initComponents();
        this.rightPanel = rightPanel;
        populateTable();
    }

    private void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) compListTbl.getModel();
        dtm.setRowCount(0);
        try {
            for (Company comp : CompanyDirectory.getAllCompanies()) {
                if (comp.getAdminUser().equals("root")) {
                    continue;
                }

                Object[] row = new Object[3];

                row[0] = comp;
                row[1] = comp.getAdminUser();
                row[2] = comp.getType();

                dtm.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void refreshTable() {
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        compListTbl = new javax.swing.JTable();
        dltBtn = new javax.swing.JButton();
        updatBtn = new javax.swing.JButton();

        jLabel1.setText("Company List");

        addBtn.setText("+Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        compListTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Comp. Name", "Admin Name", "Comp. Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(compListTbl);

        dltBtn.setText("-Delete");
        dltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltBtnActionPerformed(evt);
            }
        });

        updatBtn.setText("Update");
        updatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dltBtn)
                        .addGap(3, 3, 3)
                        .addComponent(updatBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(jLabel1)
                    .addComponent(dltBtn)
                    .addComponent(updatBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        CreateCompJPanel panel = new CreateCompJPanel(rightPanel);
        rightPanel.add("CreateCompJPanel", panel);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_addBtnActionPerformed

    private void updatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = compListTbl.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Company comp = (Company) compListTbl.getValueAt(selectedRow, 0);
            try {
                User input = UserDirectory.getUser(comp.getAdminUser());
                if (input != null) {
                    JPanel panel = new ManageAccountPanel(rightPanel, comp.getCompanyName(), input);
                    rightPanel.add("ManageAccountPanel", panel);
                    CardLayout layout = (CardLayout) rightPanel.getLayout();
                    layout.next(rightPanel);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to load information!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_updatBtnActionPerformed

    private void dltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltBtnActionPerformed
        // TODO add your handling code here:
        int index = compListTbl.getSelectedRow();
        if (index != -1) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure to delete this user?",
                    "Company Management",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                return;
            }
            Company comp = (Company) compListTbl.getValueAt(index, 0);
            try {
                if (CompanyDirectory.deleteCompany(comp)) {
                    JOptionPane.showMessageDialog(this, "Delete succeed!",
                            "Company Management", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete!",
                            "Company Management", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            this.populateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row",
                    "Company Management", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_dltBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable compListTbl;
    private javax.swing.JButton dltBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updatBtn;
    // End of variables declaration//GEN-END:variables
}

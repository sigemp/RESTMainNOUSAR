package com.sigemp.gestion.client.gui.sis_config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sigemp.gestion.client.gui.component.SgImage;
import com.sigemp.gestion.client.gui.component.base.SgJInternalFrame;
import com.sigemp.gestion.client.services.GsyContadoresService;
import com.sigemp.gestion.client.services.GsyContadoresTipoService;
import com.sigemp.gestion.client.services.GsySucService;
import com.sigemp.gestion.client.services.GsyTalonariosService;
import com.sigemp.gestion.client.services.ServiceFactory;
import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.client.gui.sis_config.form.FormVtoVta;
import com.sigemp.gestion.client.services.ventanaPtoVenta.PtoVtaService;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.GsyContadorDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.GsyContadorTipoDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.PtoVtaDto;
import com.sigemp.gestion.shared.entity.GsyContadores;
import com.sigemp.gestion.shared.entity.GsyContadorestipos;
import com.sigemp.gestion.shared.entity.GsySuc;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author cristian
 */
public class VentanaPtoVenta extends SgJInternalFrame {

    private final GsyContadoresService controladorContadores = ServiceFactory.getGsyContador();
    private final GsyContadoresTipoService controladorContadoresTipo = ServiceFactory.getGsyContadoresTipo();
    private final GsyTalonariosService controladorPuntoVenta = ServiceFactory.getGsyTalonarios();
    private final GsySucService controladorSucursal = ServiceFactory.getGsySuc();
    private final PtoVtaService ptovtaService = ServiceFactory.getPtoVtaService();

    /**
     * Creates new form ComAbmTalones
     */
    public VentanaPtoVenta() {
        super();
    }

    @Override
    public void init() {
        initComponents();

        setIcon(SgImage.PTOVTA);
        setPreferredSize(new Dimension(519, 421));

        jb_actualizar.setIcon(SgImage.REGISTROS_ACTUALIZAR.getImage(SgImage.SIZES.S20));
        jb_agregar.setIcon(SgImage.REGISTROS_AGREGAR.getImage(SgImage.SIZES.S20));
        jb_eliminar.setIcon(SgImage.REGISTROS_BORRAR.getImage(SgImage.SIZES.S20));
        jb_template.setIcon(SgImage.PTOVTA.getImage(SgImage.SIZES.S20));

        jTreeTalonarios.addTreeSelectionListener((TreeSelectionEvent e) -> {
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) jTreeTalonarios.getLastSelectedPathComponent();
            setPanelView(null);

            if (dmtn == null || dmtn.getUserObject() == null) {
                return;
            }

            try {
                mostrar(dmtn.getUserObject());
            } catch (Exception ex) {
                me(ex);
                Logger.getLogger(VentanaPtoVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        jTreeTalonarios.setCellRenderer(new MiRenderNew());
        jTreeTalonarios.setRowHeight(22);
        pack();

    }

    @Override
    public void postInit() {
        actualizar(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDeFormulario = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jb_actualizar = new javax.swing.JButton();
        jb_agregar = new javax.swing.JButton();
        jb_eliminar = new javax.swing.JButton();
        jb_template = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeTalonarios = new javax.swing.JTree();
        tf_buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jPanelDeFormulario.setMinimumSize(new java.awt.Dimension(404, 200));
        jPanelDeFormulario.setPreferredSize(new java.awt.Dimension(404, 200));
        jPanelDeFormulario.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setPreferredSize(new java.awt.Dimension(0, 35));

        jb_actualizar.setText("Consultar");
        jb_actualizar.setToolTipText("Actualiza");
        jb_actualizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jb_actualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jb_actualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jb_actualizar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jb_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_actualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_actualizar);

        jb_agregar.setText("Agregar");
        jb_agregar.setToolTipText("Agrega ");
        jb_agregar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jb_agregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jb_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jb_agregar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jb_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_agregar);

        jb_eliminar.setText("Eliminar");
        jb_eliminar.setToolTipText("Elimina");
        jb_eliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jb_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jb_eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jb_eliminar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jb_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_eliminar);

        jb_template.setText("Template");
        jb_template.setToolTipText("Genera Talonario con contadores por medio de un Template");
        jb_template.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jb_template.setFocusable(false);
        jb_template.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jb_template.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jb_template.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jb_template.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_templateActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_template);

        jScrollPane1.setViewportView(jTreeTalonarios);

        tf_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_buscarKeyPressed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(tf_buscar)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDeFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDeFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_actualizarActionPerformed
        actualizar(false);
    }//GEN-LAST:event_jb_actualizarActionPerformed

    private void jb_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarActionPerformed
        try {
            nuevo();
        } catch (SgException ex) {
            me(ex);
            Logger.getLogger(VentanaPtoVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_agregarActionPerformed

    private void jb_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminarActionPerformed
        try {
            borrar();
        } catch (SgException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_eliminarActionPerformed

    private void jb_templateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_templateActionPerformed
        actualizar(false);
    }//GEN-LAST:event_jb_templateActionPerformed

    private void tf_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_buscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            actualizar(false);
        }
    }//GEN-LAST:event_tf_buscarKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDeFormulario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTreeTalonarios;
    private javax.swing.JButton jb_actualizar;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_eliminar;
    private javax.swing.JButton jb_template;
    private javax.swing.JTextField tf_buscar;
    // End of variables declaration//GEN-END:variables

    private void mostrar(Object o) throws Exception {
        if (o instanceof PtoVtaDto) {
            PtoVtaDto gsyTalonarios = (PtoVtaDto) o;
            //cargarContadores(dmtn, gsyTalonarios);
            FormVtoVta form = new FormVtoVta();
            form.setId(gsyTalonarios.getPtoVta());
            setPanelView(form);
            return;
        } else if (o instanceof GsyContadorDto) {
            GsyContadorDto contador = (GsyContadorDto) o;
            return;
        }

    }

 
    private void actualizar(boolean cleanOnly) {

        setPanelView(null);

        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("Puntos de Venta");
        DefaultTreeModel modelo = new DefaultTreeModel(padre);

        if (!cleanOnly) {
            try {
                List<PtoVtaDto> ptovtas = ptovtaService.getPtoVtas(null, tf_buscar.getText().trim());

                for (PtoVtaDto ptovta : ptovtas) {
                    DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(ptovta);
                    modelo.insertNodeInto(hijo, padre, 0);
                    cargarContadores(hijo, ptovta.getContadores());
                }

            } catch (SgException ex) {
                LOG.log(Level.SEVERE, null, ex);
                me(ex);
                Logger.getLogger(VentanaPtoVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        jTreeTalonarios.setModel(modelo);
        jTreeTalonarios.updateUI();
        jTreeTalonarios.expandRow(0);

    }

    private void cargarContadores(DefaultMutableTreeNode dmtn, List<GsyContadorDto> ptovtas) {
        DefaultTreeModel modelo = (DefaultTreeModel) jTreeTalonarios.getModel();
        if (dmtn.getChildCount() < 1) {
            modelo.reload(dmtn);

            for (GsyContadorDto contador : ptovtas) {
                DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(contador);
                modelo.insertNodeInto(hijo, dmtn, 0);
            }
        }
    }

    private void nuevo() throws SgException {
        TreePath tp = jTreeTalonarios.getSelectionModel().getSelectionPath();
        if (tp != null) {
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.getLastPathComponent();
            if (dmtn.getUserObject() instanceof String) {
                nuevoTalonario(dmtn);
                return;
            }
            if (dmtn.getUserObject() instanceof GsyTalonarios) {
                GsyTalonarios tal = (GsyTalonarios) dmtn.getUserObject();
                nuevoContador(dmtn, tal);
                return;
            }
        }
    }

    private void nuevoTalonario(DefaultMutableTreeNode dmtn) throws SgException {

        GsyTalonarios e = controladorPuntoVenta.getDtoNew();
//        FormTalonariosForm pdt = new FormTalonariosForm();
//        pdt.setCurrentRecord(e);
//////        pdt.setNode(dmtn, modelo);
//
//        setPanelView(pdt);
    }

    private void setPanelView(JComponent component) {
        jPanelDeFormulario.removeAll();
        if (component != null) {
            jPanelDeFormulario.add(component);
        }
        jPanelDeFormulario.updateUI();
    }

    private void nuevoContador(DefaultMutableTreeNode dmtn, GsyTalonarios tal) {
        DefaultTreeModel modelo = (DefaultTreeModel) jTreeTalonarios.getModel();
        GsyContadores e = controladorContadores.getDtoNew();
        e.setTalId(tal);

//        FormContadores pdt = new FormContadores();
//        pdt.setCurrentRecord(e);
//        pdt.setNode(dmtn, modelo);
//
//        setPanelView(pdt);
    }

    private void borrar() throws SgException {
        int x = JOptionPane.showConfirmDialog(this, "Esta Seguro de Borrar el item Seleccionado?", "Borrar", JOptionPane.YES_NO_OPTION);
        if (x != JOptionPane.YES_OPTION) {
            return;
        }
        TreePath tp = jTreeTalonarios.getSelectionModel().getSelectionPath();

        if (tp != null) {
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.getLastPathComponent();
            if (dmtn.getUserObject() instanceof GsyTalonarios) {
                deleteGsyTalonario(dmtn);
                return;
            }
            if (dmtn.getUserObject() instanceof GsyContadores) {
                deleteGsyContadores(dmtn);
                return;
            }
            if (dmtn.getUserObject() instanceof GsyContadorestipos) {
                deleteComprobantes(dmtn);
            }
        }
    }

    private void deleteComprobantes(DefaultMutableTreeNode dmtn) {
        if (dmtn.getUserObject() instanceof GsyContadorestipos) {
            DefaultTreeModel modelo = (DefaultTreeModel) jTreeTalonarios.getModel();
            GsyContadorestipos con = (GsyContadorestipos) dmtn.getUserObject();
            controladorContadoresTipo.delete(con);
            modelo.removeNodeFromParent(dmtn);
        }
    }

    private void deleteGsyContadores(DefaultMutableTreeNode dmtn) {
        if (dmtn.getUserObject() instanceof GsyContadores) {
            DefaultTreeModel modelo = (DefaultTreeModel) jTreeTalonarios.getModel();
            GsyContadores con = (GsyContadores) dmtn.getUserObject();
            List<DefaultMutableTreeNode> lista = new ArrayList<>();
            for (int x = 0; x < dmtn.getChildCount(); x++) {
                lista.add((DefaultMutableTreeNode) dmtn.getChildAt(x));
            }
            lista.stream().forEach((node) -> {
                deleteComprobantes(node);
            });
            controladorContadores.delete(con);
            modelo.removeNodeFromParent(dmtn);

        }
    }

    private void deleteGsyTalonario(DefaultMutableTreeNode dmtn) throws SgException {

        DefaultTreeModel modelo = (DefaultTreeModel) jTreeTalonarios.getModel();
        GsyTalonarios con = (GsyTalonarios) dmtn.getUserObject();
        List<DefaultMutableTreeNode> lista = new ArrayList<>();
        for (int x = 0; x < dmtn.getChildCount(); x++) {
            lista.add((DefaultMutableTreeNode) dmtn.getChildAt(x));
        }
        lista.stream().forEach((node) -> {
            deleteComprobantes(node);
        });
        controladorPuntoVenta.deletePtoVta(con.getTalId());
        modelo.removeNodeFromParent(dmtn);

    }

    private static final Logger LOG = Logger.getLogger(VentanaPtoVenta.class.getName());

}

class MiRenderNew extends DefaultTreeCellRenderer {

    private static final Logger LOG = Logger.getLogger(MiRenderNew.class.getName());

//    private final ImageIcon iconoContador = IconFactory.getIcon(IconFactory.ICONO_CONTADOR, IconFactory.Tamano.P16);
//    private final ImageIcon iconoContadoresTip = IconFactory.getIcon(IconFactory.ICONO_TIPO_COMPROBANTE, IconFactory.Tamano.P16);
//    private final ImageIcon iconoTalonario = IconFactory.getIcon(IconFactory.ICONO_TALONARIO, IconFactory.Tamano.P16);
//
    private final ImageIcon iconoContador = SgImage.CONTADOR.getImage(SgImage.SIZES.S20);
    private final ImageIcon iconoContadoresTip = SgImage.CONNECTION_ICON.getImage(SgImage.SIZES.S20);
    private final ImageIcon iconoPtoVta = SgImage.PTOVTA.getImage(SgImage.SIZES.S20);

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component com = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

        JLabel b = (JLabel) com;

        if (node.getUserObject() instanceof PtoVtaDto) {
//            b.setFont(boldFont);
            PtoVtaDto t = (PtoVtaDto) node.getUserObject();
            b.setIcon(iconoPtoVta);
            b.setText(t.getDes() + " P.V.Nro: " + t.getPtoVta());
        }
        if (node.getUserObject() instanceof GsyContadorDto) {
//            b.setFont(boldFont);
            GsyContadorDto t = (GsyContadorDto) node.getUserObject();
            b.setIcon(iconoContador);
            b.setText(t.getDes());
        }
        if (node.getUserObject() instanceof GsyContadorTipoDto) {
//            b.setFont(boldFont);
            GsyContadorTipoDto dto = (GsyContadorTipoDto) node.getUserObject();

            b.setIcon(iconoContadoresTip);
            // Activar el de anajo
            b.setText(dto.toString());
            //b.setText(dto.getComprobante().getDescripcion());
        }
        if (node.getUserObject() instanceof String) {
//            b.setFont(boldFont);
            b.setIcon(openIcon);
            b.setText(node.getUserObject().toString());
        }

        b.setPreferredSize(new Dimension(300, 20));
        return b;
    }
}

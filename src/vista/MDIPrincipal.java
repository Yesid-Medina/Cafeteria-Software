package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class MDIPrincipal extends javax.swing.JFrame {

    public MDIPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null); //Centrar Ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //Codigo para insertar imagen dentro de un escritorio de un JFrame en java

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/FONDO_13.jpg"));
        Image image = icon.getImage();
        escritorioMDI = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        menuBar = new javax.swing.JMenuBar();
        filaMenu = new javax.swing.JMenu();
        menuCategorias = new javax.swing.JMenuItem();
        menuProductos = new javax.swing.JMenuItem();
        filaVentas = new javax.swing.JMenu();
        menuVentas = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        VtnInicial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        escritorioMDI.setBackground(new java.awt.Color(51, 51, 51));
        escritorioMDI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        escritorioMDI.setEnabled(false);

        menuBar.setBackground(new java.awt.Color(51, 153, 255));
        menuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        menuBar.setEnabled(false);
        menuBar.setFocusCycleRoot(true);

        filaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cafeteria (1).png"))); // NOI18N
        filaMenu.setMnemonic('f');
        filaMenu.setToolTipText("Gestión de Categorias y Productos");

        menuCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ICON_9.png"))); // NOI18N
        menuCategorias.setMnemonic('o');
        menuCategorias.setText("Gestión de Categorias");
        menuCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCategoriasActionPerformed(evt);
            }
        });
        filaMenu.add(menuCategorias);

        menuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cafeteria.png"))); // NOI18N
        menuProductos.setMnemonic('s');
        menuProductos.setText("Gestión de Productos");
        menuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductosActionPerformed(evt);
            }
        });
        filaMenu.add(menuProductos);

        menuBar.add(filaMenu);

        filaVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ICON_8.png"))); // NOI18N
        filaVentas.setMnemonic('e');
        filaVentas.setToolTipText("Geastión para las ventas");

        menuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ICON_11.png"))); // NOI18N
        menuVentas.setMnemonic('p');
        menuVentas.setText("Gestión de Ventas");
        menuVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVentasActionPerformed(evt);
            }
        });
        filaVentas.add(menuVentas);

        menuBar.add(filaVentas);

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ICON_7.png"))); // NOI18N
        salir.setMnemonic('h');
        salir.setToolTipText("Salir");

        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida.png"))); // NOI18N
        menuSalir.setMnemonic('c');
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        salir.add(menuSalir);

        VtnInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/candado.png"))); // NOI18N
        VtnInicial.setText("Volver al Inicio");
        VtnInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VtnInicialActionPerformed(evt);
            }
        });
        salir.add(VtnInicial);

        menuBar.add(salir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriasActionPerformed
        try {
            FormularioCategoria ventanaCategoria = new FormularioCategoria();
            escritorioMDI.add(ventanaCategoria);
            ventanaCategoria.show();
        } catch (Exception e) {
            Logger.getLogger(MDIPrincipal.class.getName());
        }
    }//GEN-LAST:event_menuCategoriasActionPerformed

    private void menuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosActionPerformed
        try {
            FormularioProducto ventanaProducto = new FormularioProducto();
            escritorioMDI.add(ventanaProducto);
            ventanaProducto.show();
        } catch (Exception e) {
            Logger.getLogger(MDIPrincipal.class.getName());
        }
    }//GEN-LAST:event_menuProductosActionPerformed

    private void menuVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVentasActionPerformed
        try {
            FormularioVenta ventanaVenta = new FormularioVenta();
            escritorioMDI.add(ventanaVenta);
            ventanaVenta.show();
        } catch (Exception e) {
            Logger.getLogger(MDIPrincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_menuVentasActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void VtnInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VtnInicialActionPerformed
        JFInicial VtnPrincipal = new JFInicial();
        VtnPrincipal.setVisible(true);
        dispose();// Desaparece ventana
    }//GEN-LAST:event_VtnInicialActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem VtnInicial;
    public static javax.swing.JDesktopPane escritorioMDI;
    private javax.swing.JMenu filaMenu;
    private javax.swing.JMenu filaVentas;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCategorias;
    private javax.swing.JMenuItem menuProductos;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenuItem menuVentas;
    private javax.swing.JMenu salir;
    // End of variables declaration//GEN-END:variables

}

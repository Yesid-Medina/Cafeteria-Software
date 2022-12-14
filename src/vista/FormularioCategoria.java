//trim() -> elimina espacios
package vista;

import controlador.ControladorCategoria;
import dao.CategoriaImpDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Omar Medina
 */
public class FormularioCategoria extends javax.swing.JInternalFrame {

    //Creamos los objetos
    ControladorCategoria contCategoria = new ControladorCategoria();
    Categoria categoria = new Categoria();
    ArrayList<Categoria> listaCategoria = new ArrayList();
    CategoriaImpDAO catImpDao = new CategoriaImpDAO();
    DefaultTableModel tmb = null;//"Default table model" permite tener una plantilla de una tabla
    String mensaje = null;

    public FormularioCategoria() throws SQLException {
        initComponents();
        inhabilitar();//Cargar el método
        mostrarCategoriaTabla();
//        eliminarContenidoTabla();
    }

    //Métodos que nos permiten hacer el proceso de validación
    public void inhabilitar() {
        campoCodigo.setEnabled(false);
        campoNombre.setEnabled(false);
        listaEstado.setEnabled(false);
        botonRegistrar.setText("Nuevo");//Modificar propiedad text
        botonRegistrar.setEnabled(true);//Para habilitar campo al modificar
        botonModificar.setEnabled(false);
        botonEliminar.setEnabled(false);
//        limpiar();
    }

    public void habilitar() throws SQLException {
        campoCodigo.setEnabled(false);
        campoCodigo.setText("" + contCategoria.nuevoCodigoCategorias());//Va a devolver el número de registro +1 del código que se va a generar, para gene
        campoNombre.setEnabled(true);
        listaEstado.setEnabled(true);
        botonRegistrar.setText("Registrar");//Modificar propiedad text
    }

    public void habilitarModificar() {
        campoNombre.setEnabled(true);
        listaEstado.setEnabled(true);
        botonRegistrar.setEnabled(false);
        campoCodigo.setEnabled(false);
        botonModificar.setEnabled(true);
        botonEliminar.setEnabled(true);
    }

    public void limpiar() {//Limpiar campos
        campoCodigo.setText("");
        campoNombre.setText("");
        listaEstado.setSelectedIndex(0);
    }

    public void mostrarCategoriaTabla() throws SQLException {
        listaCategoria = (ArrayList<Categoria>) catImpDao.listar();//Asignar el método listar al ArrayList
        String matriz[][] = new String[listaCategoria.size()][3];
        //Coger cada registro de listaCategoria y enviarlo a la matriz o asignarlo
        for (int i = 0; i < listaCategoria.size(); i++) {
            matriz[i][0] = "" + listaCategoria.get(i).getCodigo();//Convertir en String
            matriz[i][1] = listaCategoria.get(i).getNombre();
            matriz[i][2] = listaCategoria.get(i).getEstado();
        }

        tmb = new DefaultTableModel(matriz, new String[]{"Código", "Nombre Categoria", "Estado"});
        tablaCategorias.setModel(tmb);
    }

    //Método que se va encargar de limpiar cada vez que yo registre algo
    public void eliminarContenidoTabla() {
        DefaultTableModel td = (DefaultTableModel) tablaCategorias.getModel();//Tiene caracteristicas de una matriz DefaultTableModel, toda la estructura de la tabla la obtengo a traves del getModel
        int a = tablaCategorias.getRowCount() - 1;//Método getRowCount me permite contar el número de filas, cada vez que me cuente tengo que restarle 1 para saber el tamaño del vector
        for (int i = a; i >= 0; i--) {//Recorro toda la tabla empezando desde cero, comienzo desde abajo hacia arriba eliminando
            tmb.removeRow(td.getRowCount() - 1);//Comienzo ir removiendo hasta que quede en cero
        }
        listaCategoria.clear();//Limpiar el arrayList
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        listaEstado = new javax.swing.JComboBox<>();
        botonRegistrar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        salirCategoria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCategorias = new javax.swing.JTable();
        // Codigo para insertar imagen dentro de un escritorio de un JFrame en java

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/FONDO_6.jpg"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión Categoria");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)), "Gestionar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Estado");

        campoCodigo.setForeground(new java.awt.Color(0, 0, 51));
        campoCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        campoNombre.setForeground(new java.awt.Color(0, 0, 51));
        campoNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        listaEstado.setForeground(new java.awt.Color(0, 0, 0));
        listaEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "Activo", "Inactivo" }));
        listaEstado.setToolTipText("Seleccione estado de categoria");

        botonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        botonModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(255, 51, 51));
        botonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(255, 102, 102));
        botonCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(listaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        salirCategoria.setBackground(new java.awt.Color(255, 51, 51));
        salirCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        salirCategoria.setForeground(new java.awt.Color(255, 255, 255));
        salirCategoria.setText("Salir");
        salirCategoria.setToolTipText("Salir de Gestión Categorias");
        salirCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirCategoriaActionPerformed(evt);
            }
        });

        tablaCategorias.setBackground(new java.awt.Color(255, 255, 255));
        tablaCategorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        tablaCategorias.setForeground(new java.awt.Color(0, 0, 51));
        tablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre Categoria", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCategorias.setToolTipText("Seleccione la Categoria a modificar");
        tablaCategorias.setSelectionBackground(new java.awt.Color(0, 0, 51));
        tablaCategorias.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaCategorias.getTableHeader().setResizingAllowed(false);
        tablaCategorias.getTableHeader().setReorderingAllowed(false);
        tablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCategorias);

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jDesktopPane1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDesktopPane1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salirCategoria)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        try {
            if (botonRegistrar.getText().equals("Nuevo")) { // el metodo equals() sirve para comparar un valor
                habilitar();
            } else {//Crear objeto
                categoria.setCodigo(Integer.parseInt(campoCodigo.getText().trim()));
                categoria.setNombre(campoNombre.getText().trim());
                categoria.setEstado((String) listaEstado.getSelectedItem());

                //Enviando al controlador
                contCategoria.regitrarCategoria(categoria);
                inhabilitar();//inhabilitar campos
                limpiar();//Limpiar campos
                eliminarContenidoTabla();//Limpiar tabla
                mostrarCategoriaTabla();//Mostrar tabla
                JOptionPane.showMessageDialog(this, "Se ha realizado la consulta correctamente en la base de datos..!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la operación");
        }
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        //Entra y modifica los campos establecidos
        if (campoNombre.getText().trim().isEmpty()) {//Si el campo está vació método isEmpty -> sirve para verificar si el campo esta vacido
            JOptionPane.showMessageDialog(this, "Debe diligenciar el campo a modificar", "Información", JOptionPane.INFORMATION_MESSAGE);//Mensaje que le muestro al usuario
        } else {
            try {
                categoria = new Categoria(Integer.parseInt(campoCodigo.getText().trim()), campoNombre.getText().trim(), (String) listaEstado.getSelectedItem());//Vamos a enviarle los valores que el necesita "get" obtener lo que está em el campo
                mensaje = contCategoria.modificarCategoria(categoria);
                limpiar();//Limpiar campos
                eliminarContenidoTabla();//Limpiar tabla
                inhabilitar();//inhabilitar campos
                mostrarCategoriaTabla();//Mostrar tabla
                JOptionPane.showMessageDialog(this, mensaje);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e, "Información", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        //Es identico al modificar 
        if (campoNombre.getText().trim().isEmpty()) {//Si el campo está vació 
            JOptionPane.showMessageDialog(this, "Debe diligenciar el campo a modificar", "Información", JOptionPane.INFORMATION_MESSAGE);//Mensaje que le muestro al usuario
        } else {//Si dilengencio el campo
            try {
                categoria = new Categoria(Integer.parseInt(campoCodigo.getText().trim()), campoNombre.getText().trim(), (String) listaEstado.getSelectedItem());//Vamos a enviarle los valores que el necesita "get" obtener lo que está em el campo
                contCategoria.eliminarCategoria(categoria);
                limpiar();//Limpiar campos
                eliminarContenidoTabla();//Limpiar tabla
                inhabilitar();//inhabilitar campos
                mostrarCategoriaTabla();//Mostrar tabla
                JOptionPane.showMessageDialog(this, "La categoria ha sido eliminado con éxito!!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e, "Información", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        inhabilitar();//inhabilitando
        limpiar();//Limpiar todos los campos
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void salirCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirCategoriaActionPerformed
        this.dispose();// Desaparece ventana
    }//GEN-LAST:event_salirCategoriaActionPerformed

    private void tablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriasMouseClicked
        //Utilizar el evento clik en la tabla
        int filaSelect = tablaCategorias.getSelectedRow();//Cada vez que le di click a la tabla voy a coger lo que he seleccionado y almaceno en filaSelect
//       JOptionPane.showMessageDialog(null, filaSelect);

        if (filaSelect >= 0) {
            limpiar();//Limpiar todos los componentes
            habilitarModificar();
            campoCodigo.setText(tablaCategorias.getValueAt(filaSelect, 0).toString());//Devolver o dar el valor que tiene en la corespondiente fila sleccionada y en la determinada columna
            campoNombre.setText(tablaCategorias.getValueAt(filaSelect, 1).toString());
            listaEstado.setSelectedItem(tablaCategorias.getValueAt(filaSelect, 2));
        }
    }//GEN-LAST:event_tablaCategoriasMouseClicked

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isDigit(validar)) {
            
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(this, "Ingrese solo Texto");
        }else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
                || (int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                || (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
                || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(this, "Ingrese solo Texto");
        }
    }//GEN-LAST:event_campoNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listaEstado;
    private javax.swing.JButton salirCategoria;
    private javax.swing.JTable tablaCategorias;
    // End of variables declaration//GEN-END:variables
}

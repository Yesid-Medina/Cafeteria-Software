package vista;

import controlador.ControladorCategoria;
import controlador.ControladorProducto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Producto;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Omar Medina
 */
public class FormularioProducto extends javax.swing.JInternalFrame {

    Producto producto = new Producto();
    ControladorProducto contProd = new ControladorProducto();//Me va a permitir llamar a los métodos
    ControladorCategoria contCat = new ControladorCategoria();
    ArrayList<Producto> listaProducto = new ArrayList();
    ArrayList<Categoria> listaCategorias = new ArrayList();
    DefaultTableModel tmb = null;
    Categoria categoria = null;
    DefaultComboBoxModel comboModel = new DefaultComboBoxModel();//Crea una plantilla donde le voy asignar las categorias

    /**
     * Creates new form FormularioProducto
     */
    public FormularioProducto() throws SQLException {
        initComponents();
        inhabilitar();
        mostrarTablaProductos();
        cargarListaCategorias();
    }

    public void inhabilitar() {
        campoCodigo.setEnabled(false);
        campoNombre.setEnabled(false);
        listaCategoria.setEnabled(false);
        campoPrecioUnidad.setEnabled(false);
        campoStock.setEnabled(false);
        listaEstado.setEnabled(false);
        botonRegistrar.setText("Nuevo");//Modificar propiedad text
        botonRegistrar.setEnabled(true);//Para habilitar campo al modificar
        botonModificar.setEnabled(false);
        botonEliminar.setEnabled(false);
    }

    public void habilitar() {
        campoCodigo.setEnabled(true);
        campoNombre.setEnabled(true);
        listaCategoria.setEnabled(true);
        campoPrecioUnidad.setEnabled(true);
        campoStock.setEnabled(true);
        listaEstado.setEnabled(true);
        botonRegistrar.setText("Registrar");//Modificar propiedad text
        botonRegistrar.setEnabled(true);
        botonModificar.setEnabled(true);
        botonEliminar.setEnabled(true);
    }

    public void habilitarModificar() {
        campoCodigo.setEnabled(false);
        campoNombre.setEnabled(true);
        listaCategoria.setEnabled(true);
        campoPrecioUnidad.setEnabled(true);
        campoStock.setEnabled(true);
        listaEstado.setEnabled(true);
        botonRegistrar.setEnabled(false);
        botonModificar.setEnabled(true);
        botonEliminar.setEnabled(true);
    }

    public void limpiar() {//Limpiar campos
        campoCodigo.setText("");
        campoNombre.setText("");
        listaCategoria.setSelectedIndex(0);
        campoPrecioUnidad.setText("");
        campoStock.setText("");
        listaEstado.setSelectedIndex(0);
    }

    public void mostrarTablaProductos() throws SQLException {
        listaProducto = (ArrayList<Producto>) contProd.listarProducto();//Cargar ArrayList
        String matriz[][] = new String[listaProducto.size()][5];
        //Coger cada registro de listaProducto y enviarlo a la matriz o asignarlo
        for (int i = 0; i < listaProducto.size(); i++) {
            matriz[i][0] = listaProducto.get(i).getCodigo();
            matriz[i][1] = listaProducto.get(i).getNombre();
            matriz[i][2] = Double.toString(listaProducto.get(i).getPrecio());
            matriz[i][3] = Integer.toString(listaProducto.get(i).getNumeroUnidades());
            matriz[i][4] = listaProducto.get(i).getEstado();
        }
        tmb = new DefaultTableModel(matriz, new String[]{"Código", "Producto", "Precio Unitario", "Stock", "Estado"});
        tablaProductos.setModel(tmb);
    }

    public void cargarListaCategorias() throws SQLException {//Método que permite cargar la lista de la categoria
        listaCategorias = (ArrayList<Categoria>) contCat.listarCategoria();
        for (Categoria categoria : listaCategorias) {//Cargar mis categoria en un combo model
            comboModel.addElement(categoria);
        }
        listaCategoria.setModel(comboModel);
    }

    //Método que se va encargar de limpiar cada vez que yo registre algo
    public void eliminarContenidoTabla() {
        DefaultTableModel td = (DefaultTableModel) tablaProductos.getModel();//Tiene caracteristicas de una matriz DefaultTableModel, toda la estructura de la tabla la obtengo a traves del getModel
        int a = tablaProductos.getRowCount() - 1;//Método getRowCount me permite contar el número de filas, cada vez que me cuente tengo que restarle 1 para saber el tamaño del vector
        for (int i = a; i >= 0; i--) {//Recorro toda la tabla empezando desde cero, comienzo desde abajo hacia arriba eliminando
            tmb.removeRow(td.getRowCount() - 1);//Comienzo ir removiendo hasta que quede en cero
        }
        listaProducto.clear();//Limpiar el arrayList
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoPrecioUnidad = new javax.swing.JTextField();
        campoStock = new javax.swing.JTextField();
        listaCategoria = new javax.swing.JComboBox<>();
        listaEstado = new javax.swing.JComboBox<>();
        botonRegistrar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        salirFormProducto = new javax.swing.JButton();
        // Codigo para insertar imagen dentro de un escritorio de un JFrame en java

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/FONDO_2.jpg"));
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
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)), "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 0, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Categoria");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Precio Unidad");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Stock");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("Estado");

        campoCodigo.setForeground(new java.awt.Color(0, 0, 51));
        campoCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        campoNombre.setForeground(new java.awt.Color(0, 0, 51));
        campoNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        campoPrecioUnidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        campoPrecioUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPrecioUnidadKeyTyped(evt);
            }
        });

        campoStock.setToolTipText("Cantidad del Producto");
        campoStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        campoStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoStockKeyTyped(evt);
            }
        });

        listaCategoria.setForeground(new java.awt.Color(0, 0, 0));
        listaCategoria.setToolTipText("Seleccione Categoria de Producto");

        listaEstado.setForeground(new java.awt.Color(0, 0, 0));
        listaEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "Activo", "Inactivo" }));
        listaEstado.setToolTipText("Seleccione estado de categoria");

        botonRegistrar.setBackground(new java.awt.Color(204, 255, 255));
        botonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(0, 0, 51));
        botonRegistrar.setText("Registrar");
        botonRegistrar.setToolTipText("Registrar Nuevo Producto");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        botonModificar.setBackground(new java.awt.Color(204, 255, 255));
        botonModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonModificar.setForeground(new java.awt.Color(0, 0, 51));
        botonModificar.setText("Modificar");
        botonModificar.setToolTipText("Modificar Producto");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(255, 51, 51));
        botonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("Eliminar");
        botonEliminar.setToolTipText("Eliminar Un Producto");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(255, 102, 102));
        botonCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.setToolTipText("Cancelar Operación");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(listaEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoStock, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(campoPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModificar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(listaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar))
                    .addComponent(jLabel4)
                    .addComponent(listaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaProductos.setBackground(new java.awt.Color(255, 255, 255));
        tablaProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        tablaProductos.setForeground(new java.awt.Color(0, 0, 51));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Precio Unitario", "Stock", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setToolTipText("Selecione el producto que desea modificar ");
        tablaProductos.setSelectionBackground(new java.awt.Color(0, 0, 51));
        tablaProductos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaProductos.getTableHeader().setResizingAllowed(false);
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        salirFormProducto.setBackground(new java.awt.Color(255, 51, 51));
        salirFormProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        salirFormProducto.setForeground(new java.awt.Color(255, 255, 255));
        salirFormProducto.setText("Salir");
        salirFormProducto.setToolTipText("Salir De La Gestión de Productos");
        salirFormProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirFormProductoActionPerformed(evt);
            }
        });

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salirFormProducto))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDesktopPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salirFormProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        try {
            if (botonRegistrar.getText().equals("Nuevo")) {
//                botonRegistrar.setText("Registrar");
                habilitar();
            } else {//Crear objeto
                categoria = (Categoria) listaCategoria.getSelectedItem();//Hacer un Cast porque el objeto que viene es de tipo Object se convierte a tipo Categoria

                producto.setCodigo(campoCodigo.getText().trim());
                producto.setNombre(campoNombre.getText().trim());
                producto.setCategoria(categoria);
                producto.setPrecio(Double.parseDouble(campoPrecioUnidad.getText().trim()));
                producto.setNumeroUnidades(Integer.parseInt(campoStock.getText().trim()));
                producto.setEstado(listaEstado.getSelectedItem().toString());
                //Enviando al controlador
                contProd.registrarProducto(producto);
                inhabilitar();//inhabilitar campos
                eliminarContenidoTabla();//Limpiar tabla
                limpiar();//Limpiar campos
                mostrarTablaProductos();//Mostrar tabla
                JOptionPane.showMessageDialog(this, "Se ha realizado la consulta correctamente en la base de datos..!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la operación");
        }
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if (campoNombre.getText().trim().isEmpty() && campoPrecioUnidad.getText().trim().isEmpty() && campoStock.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe deligenciar los campos a modificar", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                categoria = (Categoria) listaCategoria.getSelectedItem();
                producto = new Producto(campoCodigo.getText().trim(), campoNombre.getText().trim(), categoria, Double.parseDouble(campoPrecioUnidad.getText().trim()), Integer.parseInt(campoStock.getText().trim()), (String) listaEstado.getSelectedItem());
                /*mensaje = */ contProd.modificarProducto(producto);
                limpiar();
                eliminarContenidoTabla();
                inhabilitar();
                mostrarTablaProductos();
                JOptionPane.showMessageDialog(this, "El producto se ha modificado ..!");//mensaje
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error : " + e, "Información", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (campoNombre.getText().trim().isEmpty() && campoPrecioUnidad.getText().trim().isEmpty() && campoStock.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe deligenciar los campos a modificar", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                categoria = (Categoria) listaCategoria.getSelectedItem();
                producto = new Producto(campoCodigo.getText().trim(), campoNombre.getText().trim(), categoria, Double.parseDouble(campoPrecioUnidad.getText().trim()), Integer.parseInt(campoStock.getText().trim()), (String) listaEstado.getSelectedItem());
                contProd.eliminarProducto(producto);
                limpiar();
                eliminarContenidoTabla();
                inhabilitar();
                mostrarTablaProductos();
                JOptionPane.showMessageDialog(this, "El producto se ha eliminado con éxito..!");//mensaje
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error : " + e, "Información", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        inhabilitar();//inhabilitando
        limpiar();//Limpiar todos los campos
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void salirFormProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirFormProductoActionPerformed
        this.dispose(); //Desaparece ventana
    }//GEN-LAST:event_salirFormProductoActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        //Utilizar el evento clik en la tabla
        int filaSelect = tablaProductos.getSelectedRow();//Cada vez que le di click a la tabla voy a coger lo que he seleccionado y almaceno en filaSelect
        try {
            if (filaSelect >= 0) {
                limpiar();
                habilitarModificar();
                producto = contProd.buscarProductoId(tablaProductos.getValueAt(filaSelect, 0).toString());// Va a amostrar la fila seleciionada en el parametro 0 que seria el codigo del producto es decir que voy a buscar el ID del Producto
                campoCodigo.setText(producto.getCodigo());// En el campo codigo voy a mostrar lo que contiene el objeto producto en su atributo getCodigo
                campoNombre.setText(producto.getNombre());
                campoPrecioUnidad.setText("" + producto.getPrecio());
                campoStock.setText("" + producto.getNumeroUnidades());
                listaCategoria.setSelectedItem(producto.getCategoria());
                listaEstado.setSelectedItem(producto.getEstado());
            }
        } catch (SQLException e) {
            Logger.getLogger(FormularioProducto.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Ingrese solo Texto");
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Ingrese solo Texto");
        }
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoPrecioUnidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecioUnidadKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Ingrese solo Números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Ingrese solo Números");
        }
    }//GEN-LAST:event_campoPrecioUnidadKeyTyped

    private void campoStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoStockKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Ingrese solo Números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Ingrese solo Números");
        }
    }//GEN-LAST:event_campoStockKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecioUnidad;
    private javax.swing.JTextField campoStock;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listaCategoria;
    private javax.swing.JComboBox<String> listaEstado;
    private javax.swing.JButton salirFormProducto;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}

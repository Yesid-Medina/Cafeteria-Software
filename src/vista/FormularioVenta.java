package vista;

import controlador.ControladorVenta;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;

public class FormularioVenta extends javax.swing.JInternalFrame {

    public static Cliente cliente = new Cliente();//No necesita instanciarlo para poder llamar a la variable
    public static Producto producto = new Producto();
    Date date = new Date();//Creamos un objeto de tipo Date
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");//Establecemos el formato de la fecha
    DefaultTableModel modelo = new DefaultTableModel();
    String registros[] = new String[5];//Vector donde vamos a guardar los valores de mi producto
    Double total = 0.0;
    Double subTotal = 0.0;
    ControladorVenta contVenta = new ControladorVenta();
    DetalleVenta detalleVenta = new DetalleVenta();
    ArrayList<DetalleVenta> listaDetalleventa = new ArrayList<>();
    String mensaje = null;

    public FormularioVenta() throws SQLException {
        initComponents();
        inhabilitar();
        cargarTabla();
        limpiarComponentesTabla();
        campoNroVenta.setText(contVenta.generarCodigoVenta());
        campoFecha.setText(dateFormat.format(date));//Mostramos la fecha del sistema en el campo
    }

    public void inhabilitar() {
        campoNroVenta.setEnabled(false);
        campoFecha.setEnabled(false);
//    campoMostratProd.setEnabled(false);
//    campoCantidad.setEnabled(false);
    }

    public void cargarTabla() {//Establecemos el modelo de la tabla Detalle de Venta
        this.tablaDetalleVenta.setModel(modelo);
        String titulo[] = {"Código", "Producto", "Precio", "Cantidad", "Total"};

        modelo.setColumnIdentifiers(titulo);//Establecemos el titulo de la tabla
    }

    public void limpiarComponentesTabla() {
        campoMostratProd.setText("");
        campoMostratProd.setEnabled(false);
        campoCantidad.setText("");
        campoCantidad.setEnabled(false);
    }

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
        campoNroVenta = new javax.swing.JTextField();
        campoCliente = new javax.swing.JTextField();
        campoFecha = new javax.swing.JTextField();
        botonBuscarClientes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoMostratProd = new javax.swing.JTextField();
        campoCantidad = new javax.swing.JTextField();
        botonBuscarProductos = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalleVenta = new javax.swing.JTable();
        btnPagarVenta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        campoTotal = new javax.swing.JTextField();
        SalirGestionVentas = new javax.swing.JButton();
        // Codigo para insertar imagen dentro de un escritorio de un JFrame en java

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/FONDO_3.jpg"));
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
        jLabel1.setText("Gestión de Ventas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)), "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 51))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Nro. Venta");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Fecha");

        campoNroVenta.setForeground(new java.awt.Color(0, 0, 51));
        campoNroVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        campoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        campoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoClienteActionPerformed(evt);
            }
        });
        campoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoClienteKeyTyped(evt);
            }
        });

        campoFecha.setForeground(new java.awt.Color(0, 0, 51));
        campoFecha.setToolTipText("Fecha de la Venta");
        campoFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        botonBuscarClientes.setBackground(new java.awt.Color(204, 255, 255));
        botonBuscarClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonBuscarClientes.setForeground(new java.awt.Color(0, 0, 51));
        botonBuscarClientes.setText("...");
        botonBuscarClientes.setToolTipText("Buscar Clientes");
        botonBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(campoNroVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNroVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)), "Buscar producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 51))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Producto");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Cantidad");

        campoMostratProd.setForeground(new java.awt.Color(0, 0, 51));
        campoMostratProd.setToolTipText("Producto seleccionado a comprar");
        campoMostratProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        campoCantidad.setForeground(new java.awt.Color(0, 0, 51));
        campoCantidad.setToolTipText("Cantidad a Comprar");
        campoCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        campoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCantidadKeyTyped(evt);
            }
        });

        botonBuscarProductos.setBackground(new java.awt.Color(204, 255, 255));
        botonBuscarProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonBuscarProductos.setForeground(new java.awt.Color(0, 0, 51));
        botonBuscarProductos.setText("Buscar");
        botonBuscarProductos.setToolTipText("Buscar Producto");
        botonBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductosActionPerformed(evt);
            }
        });

        botonAgregar.setBackground(new java.awt.Color(204, 255, 255));
        botonAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(0, 0, 51));
        botonAgregar.setText("Agregar");
        botonAgregar.setToolTipText("Agregar Cantidad de Productos");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoMostratProd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscarProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAgregar)
                .addGap(80, 80, 80))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoMostratProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarProductos)
                    .addComponent(jLabel5)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(botonAgregar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tablaDetalleVenta.setBackground(new java.awt.Color(255, 255, 255));
        tablaDetalleVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        tablaDetalleVenta.setForeground(new java.awt.Color(0, 0, 51));
        tablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Precio", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDetalleVenta.setToolTipText("Productos a Comprar");
        tablaDetalleVenta.setSelectionBackground(new java.awt.Color(0, 0, 51));
        tablaDetalleVenta.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaDetalleVenta.getTableHeader().setResizingAllowed(false);
        tablaDetalleVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaDetalleVenta);
        if (tablaDetalleVenta.getColumnModel().getColumnCount() > 0) {
            tablaDetalleVenta.getColumnModel().getColumn(0).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(1).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(2).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(3).setResizable(false);
            tablaDetalleVenta.getColumnModel().getColumn(4).setResizable(false);
        }

        btnPagarVenta.setBackground(new java.awt.Color(0, 204, 204));
        btnPagarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPagarVenta.setForeground(new java.awt.Color(0, 0, 0));
        btnPagarVenta.setText("Pagar Venta");
        btnPagarVenta.setToolTipText("Pagar Venta Realizada");
        btnPagarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarVentaActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(204, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("TOTAL");
        jLabel7.setToolTipText("Total Factura");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        jLabel7.setOpaque(true);

        campoTotal.setEditable(false);
        campoTotal.setForeground(new java.awt.Color(0, 0, 51));
        campoTotal.setToolTipText("Precio Total a Pagar");
        campoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        SalirGestionVentas.setBackground(new java.awt.Color(255, 51, 51));
        SalirGestionVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SalirGestionVentas.setForeground(new java.awt.Color(255, 255, 255));
        SalirGestionVentas.setText("Salir");
        SalirGestionVentas.setToolTipText("Salir de Gestión de Ventas");
        SalirGestionVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirGestionVentasActionPerformed(evt);
            }
        });

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnPagarVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SalirGestionVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalirGestionVentas))
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void botonBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClientesActionPerformed
        try {
            FormularioListarClientes ventanaCliente = new FormularioListarClientes();//Creo un  objeto de tipo FormularioListaCliente
            MDIPrincipal.escritorioMDI.add(ventanaCliente);//lo agregado al escritorioMDI que es public
            ventanaCliente.toFront();//Pone al frente de los formularios
            ventanaCliente.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(FormularioProducto.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_botonBuscarClientesActionPerformed

    private void SalirGestionVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirGestionVentasActionPerformed
        this.dispose(); //Desaparece ventana
    }//GEN-LAST:event_SalirGestionVentasActionPerformed

    private void botonBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductosActionPerformed
        try {
            FormularioListarProductos ventanaProductos = new FormularioListarProductos();
            MDIPrincipal.escritorioMDI.add(ventanaProductos);//lo agregado al escritorioMDI que es public
            ventanaProductos.toFront();//Pone al frente de los formularios
            ventanaProductos.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(FormularioProducto.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_botonBuscarProductosActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if ((campoCliente.getText().trim().isEmpty() && campoMostratProd.getText().trim().isEmpty() && campoCantidad.getText().trim().isEmpty())
                || (campoCliente.getText().trim().isEmpty())
                || (campoMostratProd.getText().trim().isEmpty())
                || (campoCantidad.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Debe diligenciar los campos", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            subTotal = producto.getPrecio() * Integer.parseInt(campoCantidad.getText().trim());//Valor para almacenar en el campo total
            //Agregamos los valores de los objetos a la tabla detalleVenta
            registros[0] = producto.getCodigo();
            registros[1] = producto.getNombre();
            registros[2] = "" + producto.getPrecio();
            registros[3] = campoCantidad.getText().trim();//La cantididad la tiene el campo
            registros[4] = String.valueOf(subTotal);

            //Añadimos el registro al modelo
            modelo.addRow(registros);

            //acumulador a + valor:
            total = total + subTotal;
            campoTotal.setText(String.valueOf(total));

            //Añadiendo en mi ArrayList detalleVenta
            detalleVenta = new DetalleVenta(Integer.parseInt(campoNroVenta.getText().trim()), producto.getCodigo().trim(), Integer.parseInt(campoCantidad.getText().trim()));//Agregando al ArrayList detalleVenta valores
            listaDetalleventa.add(detalleVenta);
            limpiarComponentesTabla();
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void btnPagarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarVentaActionPerformed
        try {
            Venta venta = new Venta(Integer.parseInt(campoNroVenta.getText().trim()), cliente.getNroDocumento(), null, Double.parseDouble(campoTotal.getText().trim()), listaDetalleventa, "Pagada");//Objeto venta creado
            mensaje = contVenta.insertarVenta(venta);
            JOptionPane.showMessageDialog(this, mensaje);
//                this.dispose();//Cerrar formulario
        } catch (Exception e) {
            Logger.getLogger(FormularioVenta.class.getName()).log(Level.SEVERE, null, e);
        }
        
        // Validar los campos
//        if ((campoCliente.getText().trim().isEmpty() && campoMostratProd.getText().trim().isEmpty() && campoCantidad.getText().trim().isEmpty())
//                || (campoCliente.getText().trim().isEmpty())
//                || (campoMostratProd.getText().trim().isEmpty())
//                || (campoCantidad.getText().trim().isEmpty())) {
//            JOptionPane.showMessageDialog(this, "Primero seleccione el producto que desea comprar");
//        } else {}
    }//GEN-LAST:event_btnPagarVentaActionPerformed

    private void campoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoClienteActionPerformed

    private void campoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCantidadKeyTyped
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
    }//GEN-LAST:event_campoCantidadKeyTyped

    private void campoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoClienteKeyTyped
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
    }//GEN-LAST:event_campoClienteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SalirGestionVentas;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscarClientes;
    private javax.swing.JButton botonBuscarProductos;
    private javax.swing.JButton btnPagarVenta;
    public static javax.swing.JTextField campoCantidad;
    public static javax.swing.JTextField campoCliente;
    private javax.swing.JTextField campoFecha;
    public static javax.swing.JTextField campoMostratProd;
    private javax.swing.JTextField campoNroVenta;
    private javax.swing.JTextField campoTotal;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDetalleVenta;
    // End of variables declaration//GEN-END:variables
}

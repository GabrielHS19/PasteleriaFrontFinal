package gui;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pastel;
import model.Pedido;
import org.json.JSONArray;
import org.json.JSONObject;
import resource.ConsultaPasteles;
import resource.Request;

/**
 *
 * @author gabhs
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    private Pedido pedido;
    private final Request REQUEST;
    DefaultTableModel modelo = new DefaultTableModel();
    ConsultaPasteles con;

    public principal() {
        initComponents();
        setLocationRelativeTo(null);
        REQUEST = new Request();
        listarTabla();
        listarCombo();
        this.getContentPane().setBackground(Color.lightGray);

    }

    public boolean comprobar() {
        boolean resul;
        if (txt_direccion.getText().equals("")
                || txt_especificaciones.getText().equals("")
                || txt_cantidad.getText().equals("")
                || txt_cliente.getText().equals("")
                || txt_telefono.getText().equals("")
                || txt_fecha.getText().equals("")) {
            resul = true;
        } else {
            resul = false;
        }
        return resul;
    }

    public void listarCombo() {
        con = new ConsultaPasteles();
        con.listar(combo);
    }

    public void limpiar() {
        txt_direccion.setText("");
        txt_especificaciones.setText("");
        txt_cantidad.setText("");
        txt_cliente.setText("");
        txt_telefono.setText("");
        txt_fecha.setText("");
        txt_id.setText("");

    }

    public void limpiarTabla() {
        int numDatos = modelo.getRowCount();
        for (int i = 0; i < numDatos; i++) {
            modelo.removeRow(0);
        }
    }

    public void listarTabla() {
        JSONArray jsonArray;

        try {
            jsonArray = new JSONArray(REQUEST.getAll());
            modelo = ((DefaultTableModel) tblproductos.getModel());
            limpiarTabla();
            limpiar();
            Object[] ob = new Object[9];
            for (int i = 0; i < jsonArray.length(); i++) {
                ob[0] = jsonArray.getJSONObject(i).getLong("id");
                ob[1] = jsonArray.getJSONObject(i).getString("nombre_cliente");
                ob[2] = jsonArray.getJSONObject(i).getString("numero_telefono");
                ob[3] = jsonArray.getJSONObject(i).getString("direccion_entrega");
                ob[4] = jsonArray.getJSONObject(i).getString("tipo_pastel");
                ob[5] = jsonArray.getJSONObject(i).getString("especificacion");
                ob[6] = jsonArray.getJSONObject(i).getInt("cantidad");
                ob[7] = jsonArray.getJSONObject(i).getString("precio_total");
                ob[8] = jsonArray.getJSONObject(i).getString("fecha_entrega");
                modelo.addRow(ob);
            }
        } catch (Exception ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_especificaciones = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btobuscar = new javax.swing.JButton();
        btoeliminar = new javax.swing.JButton();
        btoguardar = new javax.swing.JButton();
        btomodificar = new javax.swing.JButton();
        txt_fecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Pedidos");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Especificaciones:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Direccion:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Telefono:");

        tblproductos.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        tblproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Telefono", "Direccion", "Tipo de pastel", "Especificaciones", "Cantidad", "Costo", "F. Entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblproductos);
        if (tblproductos.getColumnModel().getColumnCount() > 0) {
            tblproductos.getColumnModel().getColumn(0).setMinWidth(10);
            tblproductos.getColumnModel().getColumn(0).setMaxWidth(30);
            tblproductos.getColumnModel().getColumn(1).setMinWidth(10);
            tblproductos.getColumnModel().getColumn(1).setMaxWidth(170);
            tblproductos.getColumnModel().getColumn(2).setMinWidth(10);
            tblproductos.getColumnModel().getColumn(2).setMaxWidth(100);
            tblproductos.getColumnModel().getColumn(3).setMinWidth(10);
            tblproductos.getColumnModel().getColumn(3).setMaxWidth(130);
            tblproductos.getColumnModel().getColumn(4).setMinWidth(10);
            tblproductos.getColumnModel().getColumn(4).setMaxWidth(150);
            tblproductos.getColumnModel().getColumn(5).setMinWidth(10);
            tblproductos.getColumnModel().getColumn(5).setMaxWidth(260);
            tblproductos.getColumnModel().getColumn(6).setMinWidth(50);
            tblproductos.getColumnModel().getColumn(6).setMaxWidth(75);
            tblproductos.getColumnModel().getColumn(7).setMinWidth(10);
            tblproductos.getColumnModel().getColumn(7).setMaxWidth(60);
            tblproductos.getColumnModel().getColumn(8).setMinWidth(10);
            tblproductos.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setText("Cliente:");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setText("Cantidad:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setText("Fecha de entrega:");

        btobuscar.setText("Buscar");
        btobuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btobuscar.setFocusable(false);
        btobuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btobuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btobuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btobuscarActionPerformed(evt);
            }
        });

        btoeliminar.setText("Eliminar");
        btoeliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btoeliminar.setFocusable(false);
        btoeliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btoeliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btoeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoeliminarActionPerformed(evt);
            }
        });

        btoguardar.setText("Guardar");
        btoguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btoguardar.setFocusable(false);
        btoguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btoguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btoguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoguardarActionPerformed(evt);
            }
        });

        btomodificar.setText("Modificar");
        btomodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btomodificar.setFocusable(false);
        btomodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btomodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btomodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btomodificarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setText("Id:");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("Tipo de pastel:");

        jToolBar1.setRollover(true);

        jButton1.setText("Catalogo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("obtener");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(6, 6, 6)
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txt_especificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(98, 98, 98)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btomodificar)
                                                    .addGap(45, 45, 45)
                                                    .addComponent(btobuscar))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btoguardar)
                                                    .addGap(47, 47, 47)
                                                    .addComponent(btoeliminar)))))
                                    .addGap(54, 54, 54)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(75, 75, 75)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_especificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btoguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btoeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btomodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btobuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btoguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoguardarActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (comprobar() == false) {
            try {
                //formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaEntrada = formato.parse(txt_fecha.getText());
                String tel = txt_telefono.getText();
                String can = txt_cantidad.getText();
                boolean isNumeric = tel.matches("[+-]?\\d*(\\.\\d+)?");
                boolean isNumeric2 = can.matches("[+-]?\\d*(\\.\\d+)?");
                Date fechaActual = new Date();

                boolean test = fechaEntrada.before(fechaActual);
                //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                //Date fechaEntrada = formato.parse(txt_fecha.getText());
                if (isNumeric == true && isNumeric2 == true && test == false) {

                    try {
                        con = new ConsultaPasteles();
                        pedido = new Pedido();
                        pedido.setNombre_cliente(txt_cliente.getText());
                        pedido.setNumero_telefono(txt_telefono.getText());
                        pedido.setDireccion_entrega(txt_direccion.getText());
                        String tipo = (String) combo.getSelectedItem();
                        pedido.setTipo_pastel(tipo);
                        pedido.setEspecificacion(txt_especificaciones.getText());
                        pedido.setCantidad(Integer.valueOf(txt_cantidad.getText()));
                        Pastel pastel;
                        pastel = con.Costo(tipo);
                        Long resul;
                        resul = pastel.getCosto() * pedido.getCantidad();
                        pedido.setPrecio_total(String.valueOf(resul));
                        pedido.setFecha_entrega(txt_fecha.getText());
                        JSONObject json = new JSONObject(pedido);
                        REQUEST.save(json.toString());

                    } catch (Exception ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    listarTabla();
                    limpiar();
                } else {

                    JOptionPane.showMessageDialog(null, "Corrobora que el numero de telefono, la cantidad o la fecha de pedido sean correctas");
                }
            } catch (ParseException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        }
    }//GEN-LAST:event_btoguardarActionPerformed

    private void btoeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoeliminarActionPerformed
        String id = txt_id.getText();
        boolean isNumeric = id.matches("[+-]?\\d*(\\.\\d+)?");
        if (!txt_id.getText().equals("")) {
            if (isNumeric == true) {
                try {
                    REQUEST.delete(txt_id.getText());

                } catch (Exception ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor de ingresar un id correcto");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un id");
        }
        listarTabla();
        limpiar();
    }//GEN-LAST:event_btoeliminarActionPerformed

    private void btomodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btomodificarActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (comprobar() == false && !txt_id.getText().equals("")) {
            try {
                //formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaEntrada = formato.parse(txt_fecha.getText());
                String tel = txt_telefono.getText();
                String can = txt_cantidad.getText();
                String id = txt_id.getText();
                boolean isNumeric = tel.matches("[+-]?\\d*(\\.\\d+)?");
                boolean isNumeric2 = can.matches("[+-]?\\d*(\\.\\d+)?");
                boolean isNumeric3 = id.matches("[+-]?\\d*(\\.\\d+)?");
                Date fechaActual = new Date();

                boolean test = fechaEntrada.before(fechaActual);
                //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                //Date fechaEntrada = formato.parse(txt_fecha.getText());
                if (isNumeric == true && isNumeric2 == true && isNumeric3 == true && test == false) {

                    try {
                        con = new ConsultaPasteles();
                        pedido = new Pedido();
                        pedido.setNombre_cliente(txt_cliente.getText());
                        pedido.setNumero_telefono(txt_telefono.getText());
                        pedido.setDireccion_entrega(txt_direccion.getText());
                        String tipo = (String) combo.getSelectedItem();
                        pedido.setTipo_pastel(tipo);
                        pedido.setEspecificacion(txt_especificaciones.getText());
                        pedido.setCantidad(Integer.valueOf(txt_cantidad.getText()));
                        Pastel pastel;
                        pastel = con.Costo(tipo);
                        Long resul;
                        resul = pastel.getCosto() * pedido.getCantidad();
                        pedido.setPrecio_total(String.valueOf(resul));
                        pedido.setFecha_entrega(txt_fecha.getText());
                        JSONObject json = new JSONObject(pedido);
                        REQUEST.update(json.toString(), txt_id.getText());

                    } catch (Exception ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    listarTabla();
                    limpiar();
                } else {

                    JOptionPane.showMessageDialog(null, "Corrobora que el numero de telefono, la cantidad, el id o la fecha de pedido sean correctas");
                }
            } catch (ParseException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        }
    }//GEN-LAST:event_btomodificarActionPerformed
    private void btobuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btobuscarActionPerformed
        String id = txt_id.getText();
        boolean isNumeric = id.matches("[+-]?\\d*(\\.\\d+)?");
        if (!txt_id.getText().equals("")) {
            if (isNumeric == true) {
                try {
                    JSONObject json;
                    try {
                        json = new JSONObject(REQUEST.getById(txt_id.getText()));
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Id : " + json.get("id") + "\n"
                                + "Cliente : " + json.get("nombre_cliente") + "\n"
                                + "Telefono : " + json.get("numero_telefono") + "\n"
                                + "Direccion : " + json.get("direccion_entrega") + "\n"
                                + "Tipo de pastel : " + json.get("tipo_pastel") + "\n"
                                + "Especificaciones : " + json.get("especificacion") + "\n"
                                + "Cantidad : " + json.get("cantidad") + "\n"
                                + "Precio total : " + json.get("precio_total") + "\n"
                                + "Fecha de entrega : " + json.get("fecha_entrega") + "\n"
                        );
                    } catch (Exception ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor de ingresar un id correcto");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un id");
        }
        listarTabla();
        limpiar();


    }//GEN-LAST:event_btobuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Catalogo cata = new Catalogo();
        cata.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String id = txt_id.getText();
        boolean isNumeric = id.matches("[+-]?\\d*(\\.\\d+)?");
        if (!txt_id.getText().equals("")) {
            if (isNumeric == true) {
                try {
                    JSONObject json;
                    try {
                        json = new JSONObject(REQUEST.getById(txt_id.getText()));
                        txt_cliente.setText(String.valueOf(json.get("nombre_cliente")));
                        txt_telefono.setText(String.valueOf(json.get("numero_telefono")));
                        txt_fecha.setText(String.valueOf(json.get("fecha_entrega")));
                        txt_direccion.setText(String.valueOf(json.get("direccion_entrega")));
                        txt_telefono.setText(String.valueOf(json.get("numero_telefono")));
                        txt_cantidad.setText(String.valueOf(json.get("cantidad")));
                        txt_especificaciones.setText(String.valueOf(json.get("especificacion")));

                    } catch (Exception ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor de ingresar un id correcto");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un id");
        }
        //listarTabla();
        //limpiar();


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btobuscar;
    private javax.swing.JButton btoeliminar;
    private javax.swing.JButton btoguardar;
    private javax.swing.JButton btomodificar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblproductos;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_especificaciones;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}

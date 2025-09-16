package gui;

import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import clase.Almacen;
import metodo.metodoAlmacen;

public class v1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNomProducto, txtBuscar, txtCodProducto, txtStock, txtEliminar;
    private JTextArea txtS;
    metodoAlmacen ma = new metodoAlmacen(); 

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                v1 frame = new v1();
                frame.setVisible(true);
            } catch (Exception e) { e.printStackTrace(); }
        });
    }

    public v1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 769, 459);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Campos
        txtNomProducto = new JTextField(); txtNomProducto.setBounds(124,23,96,18); contentPane.add(txtNomProducto);
        txtCodProducto = new JTextField(); txtCodProducto.setBounds(124,45,96,18); contentPane.add(txtCodProducto);
        txtStock = new JTextField(); txtStock.setBounds(124,71,96,20); contentPane.add(txtStock);
        txtBuscar = new JTextField(); txtBuscar.setBounds(124,95,96,18); contentPane.add(txtBuscar);
        txtEliminar = new JTextField(); txtEliminar.setBounds(124,121,96,20); contentPane.add(txtEliminar);

        //Labels
        contentPane.add(new JLabel("Nombre producto:")).setBounds(10,26,116,12);
        contentPane.add(new JLabel("Código producto:")).setBounds(10,48,116,12);
        contentPane.add(new JLabel("Stock inicial:")).setBounds(10,70,84,14);
        contentPane.add(new JLabel("Buscar por código:")).setBounds(10,95,116,15);
        contentPane.add(new JLabel("Eliminar producto:")).setBounds(10,121,116,14);

        //txtArea
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 215, 735, 197);
        contentPane.add(scrollPane);
        txtS = new JTextArea(); scrollPane.setViewportView(txtS);

        //Botón Agregar
        JButton btnAgregar = new JButton("Agregar producto");
        btnAgregar.setBounds(380,22,160,20);
        contentPane.add(btnAgregar);
        btnAgregar.addActionListener(e -> {
            String nombre = txtNomProducto.getText().trim();
            String codStr = txtCodProducto.getText().trim();
            String stockStr = txtStock.getText().trim();

            if(nombre.isEmpty() || codStr.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Debe ingresar nombre y código","Error",JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int codigo = Integer.parseInt(codStr);

                // Verificar si ya existe
                if(ma.Buscar(codigo) != null) {
                    JOptionPane.showMessageDialog(null,"El producto con código "+codigo+" ya existe.","Producto repetido",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Sobrecarga según stock
                int stock = (stockStr.isEmpty()) ? 0 : Integer.parseInt(stockStr);
                if(stock==0) ma.Adicionar(nombre,codigo);
                else ma.Adicionar(codigo,nombre,stock);

                JOptionPane.showMessageDialog(null,"Producto agregado exitosamente","Éxito",JOptionPane.INFORMATION_MESSAGE);
                mostrarProductos(ma);

            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Código y Stock deben ser números válidos","Error",JOptionPane.ERROR_MESSAGE);
            }
            limpiarCampos();
        });

        //Botones Modificar, Buscar y Eliminar
        JButton btnModificar = new JButton("Modificar producto"); btnModificar.setBounds(380,84,160,20); contentPane.add(btnModificar);
        btnModificar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodProducto.getText().trim());
                Almacen a = ma.Buscar(codigo);
                if(a!=null) {
                    String nuevoNombre = txtNomProducto.getText().trim();
                    int nuevoStock = txtStock.getText().trim().isEmpty() ? 0 : Integer.parseInt(txtStock.getText().trim());
                    if(!nuevoNombre.isEmpty()) a.setNomProducto(nuevoNombre);
                    a.setStockActual(nuevoStock);
                    JOptionPane.showMessageDialog(null,"Producto modificado correctamente","Modificado",JOptionPane.INFORMATION_MESSAGE);
                    mostrarProductos(ma);
                } else JOptionPane.showMessageDialog(null,"No existe producto con ese código","Error",JOptionPane.ERROR_MESSAGE);
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Complete los campos correctamente","Error",JOptionPane.ERROR_MESSAGE);
            }
            limpiarCampos();
        });

        JButton btnBuscar = new JButton("Buscar producto"); btnBuscar.setBounds(380,53,160,20); contentPane.add(btnBuscar);
        btnBuscar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtBuscar.getText().trim());
                Almacen a = ma.Buscar(codigo);
                if(a!=null) {
                	JOptionPane.showMessageDialog(btnBuscar, "El producto sí existe." + "\n\nNombre producto: " + a.getNomProducto() + "\nStock: " + a.getStockActual());
                } else {
                    JOptionPane.showMessageDialog(null,"No se encontró ningún producto con ese código","No encontrado",JOptionPane.WARNING_MESSAGE);
                    mostrarProductos(ma);
                }
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Debe ingresar un número válido","Error",JOptionPane.ERROR_MESSAGE);
            }
            limpiarCampos();
        });

        JButton btnEliminar = new JButton("Eliminar producto"); btnEliminar.setBounds(380,115,160,20); contentPane.add(btnEliminar);
        btnEliminar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtEliminar.getText().trim());
                Almacen a = ma.Buscar(codigo);
                if(a!=null) { ma.Eliminar(a); JOptionPane.showMessageDialog(null,"Producto eliminado correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE); mostrarProductos(ma);}
                else JOptionPane.showMessageDialog(null,"No existe producto con ese código","Error",JOptionPane.ERROR_MESSAGE);
            } catch(NumberFormatException ex) { JOptionPane.showMessageDialog(null,"Ingrese un código válido","Error",JOptionPane.ERROR_MESSAGE);}
            limpiarCampos();
        });
        mostrarProductos(ma);
    }

    private void mostrarProductos(metodoAlmacen ma) {
        txtS.setText("");
        txtS.append(String.format("%-10s %-20s %-10s\n","CÓDIGO","NOMBRE","STOCK"));
        txtS.append("----------------------------------------------------\n");
        for(Almacen a: ma.getLista()) {
            txtS.append(String.format("%-10d %-20s %-10d\n",a.getIdProducto(),a.getNomProducto(),a.getStockActual()));
        }
    }
    private void limpiarCampos() {
        txtNomProducto.setText(""); txtCodProducto.setText(""); txtStock.setText("");
        txtBuscar.setText(""); txtEliminar.setText("");
    }

}
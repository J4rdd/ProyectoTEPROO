package metodo;

import java.util.ArrayList;
import clase.Almacen;

public class metodoAlmacen {
    private ArrayList<Almacen> almac;

    public metodoAlmacen() {
        almac = new ArrayList<>();
    }

    //Adicionar (Sobrecarga)
    public void Adicionar(Almacen x) {
        almac.add(x);
    }

    public void Adicionar(String nombre, int codigo) {
        almac.add(new Almacen(nombre, codigo));
    }

    public void Adicionar(int codigo, String nombre, int stock) {
        almac.add(new Almacen(codigo, nombre, stock));
    }

    public void Adicionar(String nombre, int codigo, int stock, int stockMin, double precioCompra, double precioVenta) {
        almac.add(new Almacen(nombre, codigo, stock, stockMin, precioCompra, precioVenta));
    }

    //Buscar
    public Almacen Buscar(int cod) {
        for (Almacen a : almac) {
            if (a.getIdProducto() == cod) return a;
        }
        return null;
    }

    public Almacen Buscar(String nombre) {
        for (Almacen a : almac) {
            if (a.getNomProducto().equalsIgnoreCase(nombre)) return a;
        }
        return null;
    }

    //Eliminar
    public void Eliminar(Almacen x) { almac.remove(x); }

    public boolean EliminarPorCodigo(int cod) {
        Almacen p = Buscar(cod);
        if (p != null) { almac.remove(p); return true; }
        return false;
    }

    //Modificar
    public boolean Modificar(int cod, String nuevoNombre, int nuevoStock, int nuevoStockMin,
                             double nuevoPrecioCompra, double nuevoPrecioVenta) {
        Almacen p = Buscar(cod);
        if (p != null) {
            p.setNomProducto(nuevoNombre);
            p.setStockActual(nuevoStock);
            p.setStockMin(nuevoStockMin);
            p.setPrecioCompra(nuevoPrecioCompra);
            p.setPrecioVenta(nuevoPrecioVenta);
            return true;
        }
        return false;
    }

    //Utilitarios
    public int TotalProductos() { return almac.size(); }

    public Almacen Obtener(int x) { return almac.get(x); }

    public ArrayList<Almacen> getLista() { return almac; }
}

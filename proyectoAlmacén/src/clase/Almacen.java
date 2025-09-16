package clase;

public class Almacen {
    private int idProducto;
    private String nomProducto;
    private int stockActual;
    private int stockMin;
    private double precioCompra;
    private double precioVenta;

    ///Constructores (Sobrecarga)
    
    // Solo nombre y código
    public Almacen(String nombre, int codigo) {
        this.idProducto = codigo;
        this.nomProducto = nombre;
        this.stockActual = 0;
        this.stockMin = 0;
        this.precioCompra = 0.0;
        this.precioVenta = 0.0;
    }

    // Código, nombre y stock
    public Almacen(int codigo, String nombre, int stock) {
        this.idProducto = codigo;
        this.nomProducto = nombre;
        this.stockActual = stock;
        this.stockMin = 0;
        this.precioCompra = 0.0;
        this.precioVenta = 0.0;
    }

    // Todos los atributos
    public Almacen(String nombre, int codigo, int stock, int stockMin, double precioCompra, double precioVenta) {
        this.idProducto = codigo;
        this.nomProducto = nombre;
        this.stockActual = stock;
        this.stockMin = stockMin;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    //Getters y Setters compatibles con el GUI
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNomProducto() { return nomProducto; }
    public void setNomProducto(String nomProducto) { this.nomProducto = nomProducto; }

    public int getStockActual() { return stockActual; }
    public void setStockActual(int stockActual) { this.stockActual = stockActual; }

    public int getStockMin() { return stockMin; }
    public void setStockMin(int stockMin) { this.stockMin = stockMin; }

    public double getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }
}

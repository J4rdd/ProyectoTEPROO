package clase;

public class Almacen {
	String nomProducto;
	int idProducto, stockActual, stockMin;
	double precioCompra, precioVenta;
	public Almacen(String nomProducto, int idProducto, int stockActual, int stockMin,
			double precioCompra, double precioVenta) {
		this.nomProducto = nomProducto;
		this.idProducto = idProducto;
		this.stockActual = stockActual;
		this.stockMin = stockMin;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getStockActual() {
		return stockActual;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
	public int getStockMin() {
		return stockMin;
	}
	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
}

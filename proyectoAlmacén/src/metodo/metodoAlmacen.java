package metodo;
import java.util.ArrayList;

import clase.Almacen;

public class metodoAlmacen { //Agregar métodos (Reportar, adicionar y buscar)
	private ArrayList<Almacen> almac;
	public metodoAlmacen() {
		almac = new ArrayList<Almacen>();
	}
	public void Adicionar(Almacen x) {
		almac.add(x);
	}
	public int TotalProductos() {
		return almac.size();
	}
	public Almacen Obtener(int x) {
		return almac.get(x);
	}
	public Almacen Buscar(int cod) {
		for(int i = 0; i < TotalProductos(); i++) {
			if(Obtener(i).getIdProducto() == cod) return Obtener(i);
		}
		return null;
	}
	public void Eliminar(Almacen x) {
		almac.remove(x);
	}
}

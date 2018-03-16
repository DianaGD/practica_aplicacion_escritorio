package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;
import modelo.Juguete;

public class TableModelJuguetes extends AbstractTableModel{
	
	private String[] columnas = {"marca", "nombre", "descripcion", "precio", "categoria", "edad", "contenido"};
	
	private String[][] datos = null;
	
	public TableModelJuguetes(Juguete[] juguetes) {
		datos = new String[juguetes.length][columnas.length];
		for (int i = 0; i < juguetes.length; i++) {
			Juguete j = juguetes[i];
			datos[i][0]=j.getMarca();
			datos[i][1]=j.getNombre();
			datos[i][2]=j.getDescripcion();
			datos[i][3]=j.getPrecio();
			datos[i][4]=j.getCategoria();
			datos[i][5]=j.getEdad();
			datos[i][6]=j.getContenido();
		}
	}//end TableModelJuguetes
	
	@Override
	public int getColumnCount() {
		return columnas.length;

	}
	
	@Override public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
    }

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		return datos[indiceFila][indiceColumna];
	}

}//end class

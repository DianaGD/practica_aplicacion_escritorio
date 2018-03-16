package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import tableModels.TableModelClientes;
import tableModels.TableModelJuguetes;
import modelo.Cliente;
import modelo.Juguete;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import daos.JuguetesDAO;
import daos.JuguetesDAOImpl;

public class PanelListadoJuguetes extends JPanel{
	private JuguetesDAO daoJuguetes = new JuguetesDAOImpl();
	//preparamos array de conjuntos de juguetes
	private Juguete[] juguetes;

	public PanelListadoJuguetes() {
		this.add(new JLabel("soy el panel de listado de juguetes"));
	}//end PanelListadoJuguetes
	public void refrescarJuguetes(){
		this.juguetes = daoJuguetes.obtenerJuguetes();
		JTable tabla = new JTable(new TableModelJuguetes(juguetes));

		TableColumnModel columnModel = tabla.getColumnModel();
		
		tabla.setPreferredScrollableViewportSize(new Dimension(700,100));
		//tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.removeAll(); //quito todo lo que tuviera antes dentro del panel
		this.add(scrollPane);
	}
}
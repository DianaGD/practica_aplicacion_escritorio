package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;

import tableModels.TableModelClientes;
import tableModels.TableModelJuguetes;
import modelo.Cliente;
import modelo.Juguete;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import daos.JuguetesDAO;
import daos.JuguetesDAOImpl;

public class PanelListadoJuguetes extends JPanel implements ActionListener{
	private JuguetesDAO daoJuguetes = new JuguetesDAOImpl();
	//preparamos array de conjuntos de juguetes
	private Juguete[] juguetes;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");

	public PanelListadoJuguetes() {
		this.add(new JLabel("soy el panel de listado de juguetes"));
	}//end PanelListadoJuguetes
	public void refrescarJuguetes(){
		this.juguetes = daoJuguetes.obtenerJuguetes();
		tabla = new JTable(new TableModelJuguetes(juguetes));
		//en vez de agregar tabla agregar la JScrollBar
		tabla.setPreferredScrollableViewportSize(new Dimension(700,500));
		tabla.setFillsViewportHeight(true);
		
		//para solo poder seleccionar una fila
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.removeAll(); //quito todo lo que tuviera antes dentro del panel
		this.add(botonBorrar);
		this.add(scrollPane);
		//voy a atender al botonBorrar desde la instancia de esta clase
		botonBorrar.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//por si tanto no se selecciona una fila como si pulso el boton repetidas veces
		if(tabla.getSelectedRow()==-1){
			return; //aunque no devuelva nada, se puede llamar a return directamente para
					//decir que finaliza la funcion
		}
		JOptionPane.showMessageDialog(null, "borrar: " + juguetes[tabla.getSelectedRow()].toString());
		daoJuguetes.borrarJuguete(juguetes[tabla.getSelectedRow()].getId());
		refrescarJuguetes();
		SwingUtilities.updateComponentTreeUI(this);		
	}
}
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

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel implements ActionListener{
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	//preparamos array de conjuntos de clientes
	private Cliente[] clientes;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");
	
	public PanelListadoClientes() {
		this.add(new JLabel("soy el panel de listado de clientes"));
	}//end PanelListadoClientes()
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		tabla = new JTable(new TableModelClientes(clientes));
		//en vez de agregar tabla agregar la JScrollBar
		tabla.setPreferredScrollableViewportSize(new Dimension(700,500));
		tabla.setFillsViewportHeight(true);
		
		//para solo poder seleccionar una fila
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.removeAll(); //quito todo lo que tuviera antes dentro del panel
		this.add(botonBorrar);
		this.add(scrollPane);
		//voy a atender al botonBorrar desde la instancia de esta clase
		botonBorrar.addActionListener(this);
	}//end refrescarClientes

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//por si tanto no se selecciona una fila como si pulso el boton repetidas veces
		if(tabla.getSelectedRow()==-1){
			return; //aunque no devuelva nada, se puede llamar a return directamente para
					//decir que finaliza la funcion
		}
		JOptionPane.showMessageDialog(null, "borrar: " + clientes[tabla.getSelectedRow()].toString());
		daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
		refrescarClientes();
		SwingUtilities.updateComponentTreeUI(this);
	}
	
}//end class

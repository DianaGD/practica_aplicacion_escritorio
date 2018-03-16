package daos;

import modelo.Cliente;
import modelo.Juguete;

public interface JuguetesDAO {
	void registrarJuguete(Juguete j);

	void borrarJuguete(int id);

	Juguete[] obtenerJuguetes();
}

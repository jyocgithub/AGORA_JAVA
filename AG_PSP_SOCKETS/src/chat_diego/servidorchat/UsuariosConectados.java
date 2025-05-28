package chat_diego.servidorchat;

import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class UsuariosConectados {
	private TreeMap<String, ObjectOutputStream> _tmUsuarios;

	public UsuariosConectados()

	{
		_tmUsuarios = new TreeMap<>();
	}

	public synchronized void anadirUsuario(String nombre, ObjectOutputStream salida) {
		_tmUsuarios.put(nombre, salida);
	}

	public synchronized boolean existeUsuario(String nombre) {
		return _tmUsuarios.containsKey(nombre);
	}

	public synchronized void eliminarUsuario(String nombre) {
		_tmUsuarios.remove(nombre);
	}

	public synchronized ObjectOutputStream[] getSalidas() {
		ObjectOutputStream[] salidas = new ObjectOutputStream[_tmUsuarios.size()];
		Iterator<String> iterator = _tmUsuarios.keySet().iterator();
		String nombre;
		int i = 0;
		while (iterator.hasNext()) {
			nombre = iterator.next();
			salidas[i] = _tmUsuarios.get(nombre);
			i++;
		}
		return salidas;
	}

	public synchronized TreeSet<String> getTreeSetUsuarios() {
		TreeSet<String> tsUsuarios = new TreeSet<>(_tmUsuarios.keySet());
		return tsUsuarios;
	}
}

package juliaMensajeria;

import java.io.IOException;
import java.util.List;

/**
 * HiloServidorParaCadaCliente
 * 
 * Se crea un hilo por cada cliente conectado al servidor
 * Recibe un InputStream como parámetro en el constructor
 * y se queda contínuamente leyendo líneas de él.
 */
public class HiloServidorParaCadaCliente implements Runnable {

	Cliente			cliente;
	List<Cliente>	clientes;

	/**
	 * Constructor
	 * 
	 */
	HiloServidorParaCadaCliente (Cliente c, List<Cliente> clis) {
		cliente = c;
		clientes = clis;
	}

	/**
	 * run
	 * 
	 */
	@Override
	public void run () {

		String leido;
		escribirEnCliente ("\n------------------------------" + "\nElija una opcion" + "\nLIST - Lista todos sus mensajes "
		        + "\nSEND - Envia un mensaje a otro usuario " + "\nRETR - Recupera un mensaje especifico " + "\nEXIT - Terminar " + "");
		// Leemos todo lo que nos mande el cliente
		while (true) {

			try {
				leido = cliente.lector.readLine ();

				if (leido == null) {
					break;
				}

				switch (leido) {
					case "LIST": {
						escribirEnCliente ("LISTADO DE MENSAJES");
						if (cliente.mensajes.size () == 0) {
							escribirEnCliente ("No tiene mensajes en el buzon");
						}
						else {
							for (int i = 0; i < cliente.mensajes.size (); i++) {
								escribirEnCliente (cliente.mensajes.get (i));
							}
						}
						break;
					}
					case "RETR": {
						escribirEnCliente ("¿Que mensaje desea recuperar?");
						String op = cliente.lector.readLine ();
						int opint = Integer.parseInt (op);
						if (opint > cliente.getMensajes ().size () || opint < 0) {
							escribirEnCliente ("No existe ese mensaje");
						}
						else {
							escribirEnCliente (cliente.mensajes.get (opint));
						}
						break;
					}
					case "SEND": {
						escribirEnCliente ("¿A quien envias mensaje?");
						String destinatario = cliente.lector.readLine ();
						escribirEnCliente ("¿mensaje?");
						String mens = cliente.lector.readLine ();

						for (Cliente cl : clientes) {
							if (cl.getNombre ().equals (destinatario)) {
								cl.getMensajes ().add (mens);
								cl.escritor.println ("Tiene nuevo mensaje!");
								cl.escritor.flush ();
								break;
							}
						}

						break;
					}
					case "EXIT": {
						// Cerramos el canal de entrada. El socket se dará
						// cuenta, y verá que el canal de salida está
						// también cerrado (por el otro extremo) y
						// dará error en el próximo intento de escritura.
						try {
							cliente.lector.close ();
							cliente.escritor.close ();
							clientes.remove (cliente);
						}
						catch (IOException e) {
							e.printStackTrace ();
						}
						break;
					}
					default: {
						escribirEnCliente ("--- Instruccion desconocida.");
					}
				}
			}
			catch (IOException e) {
				break;
			}

		}

		System.out.println (" **Fin de la hebra de entrada**");

	}

	private void escribirEnCliente (String ss) {
		cliente.escritor.println (ss);
		cliente.escritor.flush ();
	}

}


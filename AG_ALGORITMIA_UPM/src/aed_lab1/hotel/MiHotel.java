package aed_lab1.hotel;

import java.util.Comparator;

import es.upm.aedlib.indexedlist.ArrayIndexedList;
import es.upm.aedlib.indexedlist.IndexedList;

/**
 * Implementa el interfaz Hotel, para realisar y cancelar reservas en un hotel,
 * y para realisar preguntas sobre reservas en vigor.
 */
public class MiHotel implements Hotel {

	static class ComparadorHabitaciones implements Comparator<Habitacion> {
		@Override
		public int compare(Habitacion o1, Habitacion o2) {
			return o1.getNombre().compareTo(o2.getNombre());
		}
	}

	static class ComparadorReservas implements Comparator<Reserva> {
		@Override
		public int compare(Reserva o1, Reserva o2) {
			return o1.getDiaEntrada().compareTo(o2.getDiaEntrada());
		}
	}

	public <E> boolean insertar(E e, IndexedList<E> list, Comparator<E> cmp) {
		int inf = 0;
		int sup = list.size() - 1;
		int centro;

		while (inf <= sup) {
			centro = (sup + inf) / 2;

			if (cmp.compare(e, list.get(centro)) == 0) {
				return false;
			} else if (cmp.compare(e, list.get(centro)) < 0) {
				sup = centro - 1;
			} else {
				inf = centro + 1;
			}
		}
		list.add(inf, e);
		return true;
	}

	/**
	 * Usa esta estructura para guardar las habitaciones creados.
	 */
	private IndexedList<Habitacion> habitaciones;

	@Override
	public void anadirHabitacion(Habitacion habitacion) {
		int i = buscaIndiceHab(habitacion.getNombre());
		if (i != -1) {
			throw new IllegalArgumentException();
		} else {
//			insertar(habitacion, habitaciones, new ComparadorGenerico<Habitacion>());
			insertar(habitacion, habitaciones, new ComparadorHabitaciones());
		}

	}

	private int buscaIndiceHab(String nombrebuscado) {
		int inf = 0;
		int sup = this.habitaciones.size() - 1;
		int centro;

		while (inf <= sup) {
			centro = (sup + inf) / 2;
			if (nombrebuscado.compareTo(habitaciones.get(centro).getNombre()) == 0) {
				return centro;
			} else if (nombrebuscado.compareTo(habitaciones.get(centro).getNombre()) < 0) {
				sup = centro - 1;
			} else {
				inf = centro + 1;
			}
		}
		return -1;
	}

	private Habitacion buscaObjetoHab(String nombrebuscado) {
		int inf = 0;
		int sup = this.habitaciones.size() - 1;
		int centro;

		while (inf <= sup) {
			centro = (sup + inf) / 2;
			String nombrecentro = habitaciones.get(centro).getNombre();
			if (nombrebuscado.compareTo(nombrecentro) == 0) {
				return habitaciones.get(centro);
			} else if (nombrebuscado.compareTo(nombrecentro) < 0) {
				sup = centro - 1;
			} else {
				inf = centro + 1;
			}
		}
		return null;
	}

	private String buscaHab(String nombre) {
		int i = buscaIndiceHab(nombre);
		if (i != -1) {
			return nombre;
		} else {
			throw new IllegalArgumentException();
		}
	}

	private boolean conflictos(String diaEntrada1, String diaEntrada2, String diaSalida1, String diaSalida2) {
		boolean vale1 = diaSalida1.compareTo(diaEntrada2) <= 0;
		boolean vale2 = diaSalida2.compareTo(diaEntrada1) <= 0;
		return !(vale1 || vale2);
	}

	@Override
	public boolean reservaHabitacion(Reserva reserva) throws IllegalArgumentException {
		String nombrehabitacion = buscaHab(reserva.getHabitacion());
		Habitacion habitacion = buscaObjetoHab(reserva.getHabitacion());
		return añadirReserva(reserva, habitacion.getReservas());

	}

	private boolean añadirReserva(Reserva r, IndexedList<Reserva> rs) {
		int i = 0;

		boolean existeYaUnaReservaIgual = false;
		for (i = 0; i < rs.size() && existeYaUnaReservaIgual == false; i++) {
			if (conflictos(rs.get(i).getDiaEntrada(), r.getDiaEntrada(), rs.get(i).getDiaSalida(), r.getDiaSalida())) {
				existeYaUnaReservaIgual = true;
			}
		}
		if (!existeYaUnaReservaIgual) {
			insertar(r, rs, new ComparadorReservas());
		}
		return !existeYaUnaReservaIgual;
	}

	@Override
	public boolean cancelarReserva(Reserva reserva) {

		Habitacion habitacion = buscaObjetoHab(reserva.getHabitacion());
		if (habitacion == null) {
			throw new IllegalArgumentException();
		}
		boolean exito = habitacion.getReservas().remove(reserva);

		return exito;
	}

	@Override
	public IndexedList<Habitacion> disponibilidadHabitaciones(String diaEntrada, String diaSalida) {

		IndexedList<Habitacion> habitacionesDisponibles = new ArrayIndexedList<>();
		int pos = 0;
		// miramos una a una cada habitacion
		for (int i = 0; i < habitaciones.size(); i++) {
			Habitacion habitacion = habitaciones.get(i);

			boolean hayreserva = false;
			// miramos una a una cada reserva de la habitacion
			for (int j = 0; j < habitacion.getReservas().size() && hayreserva == false; j++) {
				Reserva reserva = habitacion.getReservas().get(j);
				if (conflictos(reserva.getDiaEntrada(), diaEntrada, reserva.getDiaSalida(), diaSalida)) {
					hayreserva = true;
				}
			}
			if (!hayreserva) {
				habitacionesDisponibles.add(pos++, habitacion);
			}
		}
		return habitacionesDisponibles;
	}

	@Override
	public IndexedList<Reserva> reservasPorCliente(String dniPasaporte) {

		IndexedList<Reserva> habitacionesCliente = new ArrayIndexedList<>();
		int pos = 0;
		// miramos una a una cada habitacion
		for (int i = 0; i < habitaciones.size(); i++) {
			Habitacion habitacion = habitaciones.get(i);

			boolean hayreserva = false;
			// miramos una a una cada reserva de la habitacion
			for (int j = 0; j < habitacion.getReservas().size() && hayreserva == false; j++) {
				Reserva reserva = habitacion.getReservas().get(j);
				if (reserva.getDniPasaporte().equals(dniPasaporte)) {
					habitacionesCliente.add(pos++, reserva);
				}
			}
		}
		return habitacionesCliente;
	}

	@Override
	public IndexedList<Habitacion> habitacionesParaLimpiar(String hoyDia) {
//		 entrada fue antes que hoyDia y su salida es despues or igual a hoyDia.
		int pos = 0;
		IndexedList<Habitacion> habitacionesLimpiar = new ArrayIndexedList<>();
		// miramos una a una cada habitacion
		for (int i = 0; i < habitaciones.size(); i++) {
			Habitacion habitacion = habitaciones.get(i);

			boolean hayquelimpiar = false;
			// miramos una a una cada reserva de la habitacion
			for (int j = 0; j < habitacion.getReservas().size(); j++) {
				Reserva reserva = habitacion.getReservas().get(j);
				if (reserva.getDiaEntrada().compareTo(hoyDia) < 0 && reserva.getDiaSalida().compareTo(hoyDia) >= 0) {
					habitacionesLimpiar.add(pos++, habitacion);
				}
			}
		}

		return habitacionesLimpiar;
	}

	@Override
	public Reserva reservaDeHabitacion(String nombreHabitacion, String dia) {
		Habitacion habitacion = buscaObjetoHab(nombreHabitacion);
		Reserva reserva = null;

		for (int i = 0; i < habitacion.getReservas().size() && reserva == null; i++) {

			if (dia.compareTo(habitacion.getReservas().get(i).getDiaEntrada()) >= 0
					&& dia.compareTo(habitacion.getReservas().get(i).getDiaSalida()) < 0) {
				reserva = habitacion.getReservas().get(i);
			}
		}
		return reserva;
	}

	/**
	 * Crea una instancia del hotel.
	 */
	public MiHotel() {
		// No se debe cambiar este codigo
		this.habitaciones = new ArrayIndexedList<>();
	}

}

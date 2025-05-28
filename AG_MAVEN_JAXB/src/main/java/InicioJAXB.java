import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class InicioJAXB {

	public static void main(String[] args) {
	
		try {
			File mifile = new File("xml/libreria.xml");
			File nuevofile = new File("xml/libreria_modificada.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(Libreria.class);

			// ===========  LEER EL XML
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Libreria milibreria = (Libreria) unmarshaller.unmarshal(mifile);

			// mostrar leido
			System.out.println(milibreria.getLugar());
			System.out.println(milibreria.getNombre());
			for(Libro lib : milibreria.getListaLibro() ) {
				System.out.println(lib.getAutor());
				System.out.println(lib.getNombre());
			}

			// MODIFICAMOS EL OBJETO LEIDO
			milibreria.setNombre("NUEVO NOMBRE");
			Libro nuevolibro = new Libro("Cela", "La Colmena" ,"Salvat" ,"1423-23-2-22");
			milibreria.getListaLibro().add(nuevolibro);

			// ===========  ESCRIBIR NUEVO XML
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(milibreria,nuevofile);

			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}

}

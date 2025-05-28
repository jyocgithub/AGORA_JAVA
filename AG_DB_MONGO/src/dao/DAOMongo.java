package dao;


import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import pojo.Cliente;
import pojo.Vehiculo;

import java.util.ArrayList;
import java.util.List;


public class DAOMongo {
    String nombreDB = "garage";
    String nombreColeccionLibre = "coleccionLibre";
    String nombreColeccionVehiculos = "coleccionVehiculos";
    String nombreColeccionClientes = "coleccionClientes";
    String cadenaconexion = "mongodb://localhost:27017";
    ConnectionString canaldeconexion;
    MongoClient mongoClient;
    MongoDatabase mongoDatabaseGarage;

    // ciudado con el import, es import org.bson.Document;
    MongoCollection<Document> mongoCollectionLibre;
    MongoCollection<Document> mongoCollectionVehiculos;
    MongoCollection<Document> mongoCollectionClientes;

    public DAOMongo() {
        canaldeconexion = new ConnectionString(cadenaconexion);
        mongoClient = MongoClients.create(canaldeconexion);
        mongoDatabaseGarage = mongoClient.getDatabase(nombreDB);
        mongoCollectionLibre = mongoDatabaseGarage.getCollection(nombreColeccionLibre);
        mongoCollectionVehiculos = mongoDatabaseGarage.getCollection(nombreColeccionVehiculos);
        mongoCollectionClientes = mongoDatabaseGarage.getCollection(nombreColeccionClientes);
    }

    public void trabajandoEnGeneral() {
        //INSERTAR
        //insertamos documento que contiene array de documentos:
        Document document = new Document();
        document.append("nombre", "Carlos");
        document.append("edad", 20);

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("1234");
        telefonos.add("5678");

        document.append("telefonos", telefonos);

        ArrayList<Document> array = new ArrayList<Document>();
        array.add(new Document().append("nombre", "Acceso a datos").append("nota", 8));
        array.add(new Document().append("nombre", "Android").append("nota", 4));
        document.append("asignaturas", array);

        mongoCollectionLibre.insertOne(document);


        //trabajamos con DBObject:
        BasicDBObject objJSON = new BasicDBObject();
        objJSON.put("nombre", "Sonia");
        objJSON.put("edad", 22);

        telefonos = new ArrayList<>();
        telefonos.add("9999");
        telefonos.add("5555");

        objJSON.put("telefonos",telefonos);

        //DBList es una lista de DBObject:
        BasicDBList lista = new BasicDBList();
        lista.add(new BasicDBObject().append("nombre", "Android").append("nota", 6));
        lista.add(new BasicDBObject().append("nombre", "Acceso a datos").append("nota", 4));
        objJSON.put("asignaturas", lista);

        Document doc2 =  new Document(objJSON);
        mongoCollectionLibre.insertOne(doc2);


        //CONSULTAS:

        // Visualizar los datos en formato cadena
        System.out.println(" - ----------------------------------------");
        List<Document> consulta = mongoCollectionLibre.find().into(new ArrayList<Document>());
        for (int i = 0; i < consulta.size(); i++) {
            System.out.println(" - " + consulta.get(i).toString());
        }

        //recuperar datos con arrays de objetos:
        consulta = mongoCollectionLibre.find().into(new ArrayList<Document>());
        for(Document doc : consulta) {

            String nombre = doc.getString("nombre");
            System.out.println("Nombre: " + nombre);

            List<String> lista_telefonos = (ArrayList<String>) doc.get("telefonos");
            for(String tel : lista_telefonos)
                System.out.println(tel);

            List<Document> asignaturas = (ArrayList<Document>) doc.get("asignaturas");
            System.out.println("Número de asignaturas: "+asignaturas.size());
            for(Document asignatura : asignaturas) {
                String nomAsig = asignatura.getString("nombre");
                int nota = asignatura.getInteger("nota");
                System.out.println("--- Asignatura: " + nomAsig);
                System.out.println("--- Nota: " + nota);
            }
        }

        //CONSULTAS CON CRITERIOS:

        //búsqueda por campo:
        System.out.println(" - ----------------------------------------");
        consulta = mongoCollectionLibre.find(Filters.eq("nombre", "Luis")).into(new ArrayList<Document>());
        for (int i = 0; i < consulta.size(); i++) {
            System.out.println(" - " + consulta.get(i).toString());
        }

        //USO DEL MÉTODO FIND PASANDO UN DOCUMENT COMO QUERY Y RECUPERANDO CON ITERATOR:
        Document query = new Document().append("nombre", "Sonia");
        FindIterable<Document> fit = mongoCollectionLibre.find(query);
        MongoCursor<Document> it = fit.iterator();

        while(it.hasNext()) {
            System.out.println(it.next().toJson());
        }

        //para usar $gt, $lt, $ne..... HABRÁ QUE CREAR EL DOCUMENTO
        //MEJOR PROBAR EN EL COMPASS LA CONSULTA ANTES
        query = new Document().append("edad", new Document().append("$gt", 21));
        fit = mongoCollectionLibre.find(query);
        it = fit.iterator();

        while(it.hasNext()) {
            System.out.println(it.next().toJson());
        }

        //INVOLUCRAMOS ARRAYS

        //búsqueda por array es idéntico:
        array = new ArrayList<Document>();
        array.add(new Document().append("nombre", "Acceso a datos").append("nota", 10));

        query = new Document().append("asignaturas",array);
        fit = mongoCollectionLibre.find(query);
        it = fit.iterator();

        while(it.hasNext()) {
            System.out.println("***"+it.next().toJson());
        }



        //AND, OR...
        //SE PUEDE HACER PASANDO UN DOCUMENT CON TODOS LOS CAMPOS DEL CRITERIO

        //Y TAMBIÉN CON CLASE FILTERS:

        //edad no estamos comparando con un campo simple, por eso hacemos un Document aparte para él
        query = new Document().append("$gt", 18);
        it = mongoCollectionLibre.find(Filters.and(Filters.eq("nombre", "Carlos"),Filters.eq("edad", query))).iterator();

        while(it.hasNext()) {
            System.out.println("****"+it.next().toJson());
        }

        //buscar documentos cuya propiedad array contenga un valor
        //ejemplo: { "telefonos" : {"$in" : ["1234"]}}

        List<String> l = new ArrayList<>();
        l.add("1234");

        document = new Document().append("$in", l);
        query = new Document("telefonos",document);

        it = mongoCollectionLibre.find(Filters.eq("telefonos", document)).iterator();

        //y también valdría:
        it = mongoCollectionLibre.find(query).iterator();

        while(it.hasNext()) {
            System.out.println("*****"+it.next().toJson());
        }

        //cuando el array es de objetos embebidos:
        //alumnos matriculados de Acceso a datos:
        //{ "asignaturas.nombre" : {"$in" : ["Acceso a datos"]}}

        l = new ArrayList<>();
        l.add("Acceso a datos");

        document = new Document().append("$in", l);

        it = mongoCollectionLibre.find(Filters.eq("asignaturas.nombre", document)).iterator();

        while(it.hasNext()) {
            System.out.println("******"+it.next().toJson());
        }

        //alumnos aprobados en Acceso a datos
        //se puede coger los matriculados en Acceso a datos y de ahí seleccionar los aprobados

        l = new ArrayList<>();
        l.add("Acceso a datos");

        document = new Document().append("$in", l);

        it = mongoCollectionLibre.find(Filters.eq("asignaturas.nombre", document)).iterator();
        while(it.hasNext()) {
            document = it.next();
            ArrayList<Document> asignaturas = (ArrayList<Document>) document.get("asignaturas");
            for(Document asig : asignaturas) {
                if(asig.getString("nombre").equals("Acceso a datos") &&
                        asig.getInteger("nota")>=5)
                    System.out.println("Ha aprobado "+document.getString("nombre"));
            }
        }

        //PARA RECUPERAR SOLO ALGUNOS CAMPOS DE LOS DOCUMENTOS SE INCLUYE PROJECTION:
        l = new ArrayList<>();
        l.add("Acceso a datos");

        document = new Document().append("$in", l);

        it = mongoCollectionLibre.find(Filters.eq("asignaturas.nombre", document)).projection(Projections.include("nombre","asignaturas")).iterator();
        while(it.hasNext()) {
            document = it.next();
            ArrayList<Document>  asignaturas = (ArrayList<Document>) document.get("asignaturas");
            for(Document asig : asignaturas) {
                if(asig.getString("nombre").equals("Acceso a datos") &&
                        asig.getInteger("nota")>=5)
                    System.out.println("Ha aprobado "+document.getString("nombre"));
            }
        }

        //ACTUALIZACIONES
        //EL CRITERIO SE FIJA DE LA MISMA MANERA:

        l = new ArrayList<>();
        l.add("Acceso a datos");

        document = new Document().append("$in", l);
        mongoCollectionLibre.updateMany(Filters.eq("asignaturas.nombre", document), Updates.set("edad", 18));
        //Updates admite más métodos...

        //POR EJEMPLO, PARA AÑADIR ASIGNATURAS A UN ALUMNO SE PODRÍA ACTUALIZAR EL CAMPO ASIGNATURAS...
        //Updates.addToSet("asignaturas", lo que fuera...) añade a un array

        //BORRADOS

        l = new ArrayList<>();
        l.add("Acceso a datos");

        document = new Document().append("$in", l);
        mongoCollectionLibre.deleteMany(Filters.eq("asignaturas.nombre", document));

    }

    public void insertarVehiculoComoObjeto(Vehiculo v) {

        Document documento = new Document();
        documento.put("matricula", "3453WWQ");
        documento.put("largo", 334);
        documento.put("precio", 110);
        mongoCollectionVehiculos.insertOne(documento);
    }

    public void insertarVehiculoComoJson(Vehiculo v) {
        String v_enjson = v.convertirAJson();
        Document documento = Document.parse(v_enjson);
        mongoCollectionVehiculos.insertOne(documento);
    }


    public ArrayList<Vehiculo> consultarVehiculos() {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

        FindIterable<Document> it_vehiculos = mongoCollectionVehiculos.find();
        for (Document cadadocumento : it_vehiculos) {
            String vehiculoenjson = cadadocumento.toJson();
            Vehiculo vehiculo = Vehiculo.recuperarDeJson(vehiculoenjson);
            listaVehiculos.add(vehiculo);
        }
        // todo lo anterior... en una linea
        // coleccionVehiculos.find().forEach((Consumer<Document>) e -> listaVehiculos.add(Vehiculo.recuperarDeJson(e.toJson())));

        return listaVehiculos;
    }

    public ArrayList<Vehiculo> consultarVehiculosConTamanoMaximo(int tamanomaximo) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

        Bson filtro = Filters.lt("largo", tamanomaximo);

        FindIterable<Document> it_vehiculos = mongoCollectionVehiculos.find(filtro);
        for (Document cadadocumento : it_vehiculos) {
            String vehiculoenjson = cadadocumento.toJson();
            Vehiculo vehiculo = Vehiculo.recuperarDeJson(vehiculoenjson);
            listaVehiculos.add(vehiculo);
        }

        return listaVehiculos;
    }

    public ArrayList<Vehiculo> consultarVehiculosConTamanoEntre(int tamanominimo, int tamanomaximo) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

        Bson filtro = Filters.and(Filters.gt("largo", tamanominimo), Filters.lt("largo", tamanomaximo));

        FindIterable<Document> it_vehiculos = mongoCollectionVehiculos.find(filtro);
        for (Document cadadocumento : it_vehiculos) {
            String vehiculoenjson = cadadocumento.toJson();
            Vehiculo vehiculo = Vehiculo.recuperarDeJson(vehiculoenjson);
            listaVehiculos.add(vehiculo);
        }

        return listaVehiculos;
    }

    public void borrarPorMatricula(String matriculabuscada) {
        mongoCollectionVehiculos.deleteMany(Filters.eq("matricula", matriculabuscada));
    }


    public void modificaPrecio(String matriculabuscada, int nuevoprecio) {
        mongoCollectionVehiculos.updateMany(Filters.eq("matricula", matriculabuscada), Updates.set("precio", nuevoprecio));
    }


    public int contarVehiculos() {
        int cuantos = (int) mongoCollectionVehiculos.countDocuments();
        return cuantos;
    }

    public void insertarClienteComoObjeto(Cliente v) {
        String v_enjson = v.convertirAJson();
        Document documento = Document.parse(v_enjson);
        mongoCollectionClientes.insertOne(documento);
    }

    public ArrayList<Cliente> consultarClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        FindIterable<Document> it_clientes = mongoCollectionClientes.find();
        for (Document cadadocumento : it_clientes) {
            String clientejson = cadadocumento.toJson();
            Cliente cliente = Cliente.recuperarDeJson(clientejson);
            listaClientes.add(cliente);
        }
        return listaClientes;
    }

    public void modificarVehiculoSubirPrecio(int cantidad) {

        FindIterable<Document> it_vehicullos = mongoCollectionVehiculos.find();
        for (Document cadadocumento : it_vehicullos) {
            String vehiculoenjson = cadadocumento.toJson();
            Vehiculo vehiculo = Vehiculo.recuperarDeJson(vehiculoenjson);

            mongoCollectionVehiculos.updateOne(cadadocumento, Updates.set("precio", vehiculo.precio + cantidad));
        }
    }
}

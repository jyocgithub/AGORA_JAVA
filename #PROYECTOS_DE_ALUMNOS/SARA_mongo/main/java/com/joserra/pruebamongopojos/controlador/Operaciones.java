/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SARA_mongo.main.java.com.joserra.pruebamongopojos.controlador;

//import com.joserra.pruebamongopojos.modelo.*;
//import com.mongodb.client.MongoClient;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import static com.mongodb.client.model.Filters.eq;
//import static com.mongodb.client.model.Updates.combine;
//import static com.mongodb.client.model.Updates.set;
//import static java.util.Arrays.asList;
//import java.util.Iterator;
//import java.util.List;
//import org.bson.Document;
//import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
//import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
//import org.bson.codecs.configuration.CodecRegistry;
//import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author joserra
 */
public class Operaciones {
    public static void main(String[] args) {
//        /*Configuramos el CodecRegistry para incluir los codecs para traducir desde BSON a los objetos, lo
//        hacemos con un builder().
//        */
//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//
//        /*Ahora usamos el codecregistry para establecer la configuracion del cliente
//        y finalmente inicializamos el cliente*/
//
//        MongoClientSettings settings = MongoClientSettings.builder()
//        .codecRegistry(pojoCodecRegistry)
//        .build();
//        MongoClient mongoClient = MongoClients.create(settings);
//        MongoDatabase db = mongoClient.getDatabase("midbobjetos");
//
//        //Acedemos a una colección especificando el tipo en el segundo parámetro.
//        MongoCollection<Persona> collection = db.getCollection("gente", Persona.class);
//        //Borrado de todos
//        collection.deleteMany(new Document());
//        Persona p = new Persona("Antonio",20,new Direccion("Calle Falsa 123","Springfield","A2"));
//
//        collection.insertOne(p);
//
//        List<Persona> personas = asList(new Persona("Marta",20,new Direccion("Calle Zaragoza 12","Madrid","00045")),
//                new Persona("Ruben",20,new Direccion("Calle Santa Maria 34","Albacete","02333")),
//                new Persona("Sofia",20,new Direccion("Calle Pascal 3","Aranjuez","A9")));
//       collection.insertMany(personas); //Insertamos varias personas
//        mostrarPersonas(collection);
//
//        //Borrado de un registro con un filtro.
//        collection.deleteOne(eq("nombre","Ruben"));
//        System.out.println("Se ha borrado a Ruben y ahora queda:");
//        mostrarPersonas(collection);
//
//        //ACTUALIZANDO UN REGISTRO -- ACTUALIZA EL NOMBRE DE MARTA Y LE AÑADE LA EDAD DE 23
//        collection.updateOne(eq("nombre", "Marta"), combine(set("edad", 23), set("nombre", "Marta Molina")));
//        System.out.println("Después de la actualización queda:");
//        mostrarPersonas(collection);
//
//
//
       
    }

//    private static void mostrarPersonas(MongoCollection<Persona> collection) {
//        //LISTANDO DE DOCUMENTOS REGISTROS
//        Iterator i = collection.find().iterator();
//        while(i.hasNext()){
//
//            System.out.println(i.next());
//
//        }
//    }
}

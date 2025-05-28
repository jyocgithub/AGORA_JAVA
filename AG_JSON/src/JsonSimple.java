
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

import com.google.gson.Gson;

public class JsonSimple {

    public static void main(String[] args) {

        Libro libro = new Libro("a","b", 234);

        Gson gson = new Gson();

        // objeto a json
        String stringjson = gson.toJson(libro);

        // json a objeto
        Libro libro2 = gson.fromJson(stringjson, Libro.class);

    }


}

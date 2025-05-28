package patron_factoria;
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

public class PerroFactory {

    public static IPerro getPerro(String oficio) {
        if (oficio.equals("ancianos"))
            return new Caniche();
        else if (oficio.equals("defensa"))
            return new Doberman();
        else if (oficio.equals("niños"))
            return new Bulldog();
        return null;
    }

}

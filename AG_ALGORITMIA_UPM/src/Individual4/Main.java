package Individual4;

import es.upm.aedlib.positionlist.PositionList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PositionList<Integer> lis    = (PositionList<Integer>) new TesterInd4.Construct_list(new Integer[] { null,new Integer(1),null,new Integer(2),new Integer(3),new Integer(4),new Integer(5),null,new Integer(6),null,null,new Integer(7),new Integer(8),new Integer(9),new Integer(10) });

        Iterator<Integer> it = new NIterator < Integer >( lis , 1 );
        while ( it . hasNext ()) {
            System . out . println ( it . next ()+" ,");
        }

    }
}
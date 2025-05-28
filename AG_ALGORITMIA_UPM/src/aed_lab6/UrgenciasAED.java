package aed_lab6;

import es.upm.aedlib.Pair;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

//I su padre siempre esta en el indice (i − 2)/2 (si existe)
//        I su hijo izquierdo siempre esta en el indice i ∗ 2 + 1 (si existe)
//        I su hijo derecho siempre esta en el indice i ∗ 2 + 2 (si existe)


public class UrgenciasAED implements Urgencias {

    Paciente[] cola = new Paciente[1000];
//    int ultimaPosicionOcupada = -1;
    int contadorPacientes = 0;
    int contadorTiempoEspera = 0;

    @Override
    public Paciente admitirPaciente(String DNI, int prioridad, int hora) throws PacienteExisteException {

        Paciente pacienteNuevo = new Paciente(DNI, prioridad, hora, hora);
        if (PacienteExiste(pacienteNuevo)) {
            throw new PacienteExisteException();
        }

        int posicionPacienteNuevo = posicionUltimoPaciente()+1;
        cola[posicionPacienteNuevo] = pacienteNuevo;

        // hay que cambiar con papi ?

        // miramos  si hay papi
        if (posicionPacienteNuevo != 0) {
            int posicionPadre = posicionDelPadre(posicionPacienteNuevo);
            Paciente padre = cola[posicionPadre];
            while (posicionPacienteNuevo != 0 && pacienteNuevo.compareTo(padre) < 0) {
//            while (posicionPacienteNuevo != 0 && pacienteNuevo.getPrioridad() < padre.getPrioridad()) {
                if (posicionPacienteNuevo != 0) {
                    cola[posicionPacienteNuevo] = padre;
                    cola[posicionPadre] = pacienteNuevo;
                    posicionPacienteNuevo = posicionPadre;
                    posicionPadre = posicionDelPadre(posicionPacienteNuevo);
                    if (posicionPadre >= 0) {
                        padre = cola[posicionPadre];
                    }
                }
            }
        }


        return pacienteNuevo;
    }

    public boolean PacienteExiste(Paciente pacienteNuevo) {
        for (int i = 0; i < cola.length; i++) {
            if (cola[i] != null) {
                if (cola[i].equals(pacienteNuevo)) {
                    return true;
                }
            }
        }
        return false;
    }
    public int posicionUltimoPaciente() {
        if(cola[0]==null){
            return -1;
        }
        int pos=-1;
        for (int i = 1; i < cola.length && pos==-1; i++) {
            if (cola[i] == null) {
                pos = i-1;
            }
        }
        return pos;
    }

    public int posicionDelPadre(int posicionHijo) {
        int res = Math.round(((float) posicionHijo - 2) / 2);
        return res;
    }

    public int buscarPosicion(String DNI) {

        for (int i = 0; i < cola.length; i++) {
            if (cola[i] != null) {
                if (cola[i].getDNI().equals(DNI)) {
                    return i;
                }
            }
        }
        return 0;
    }

    @Override
    public Paciente atenderPaciente(int hora) {
        int posUltimoPaciente = posicionUltimoPaciente();
        if (posUltimoPaciente < 0) {
            return null;
        }
        Paciente pacienteSaliente = cola[0];
        if (pacienteSaliente != null) {
            int tiempoE = hora - pacienteSaliente.getTiempoAdmisionEnPrioridad();
            contadorTiempoEspera = contadorTiempoEspera + tiempoE;
            contadorPacientes++;
            cola[0] = cola[posUltimoPaciente];
            cola[posUltimoPaciente] = null;
            cambiaAbajo(0);
        }
//        ultimaPosicionOcupada--;
        return pacienteSaliente;
    }

    public void cambiaAbajo(int posicionSuperior) {
        Paciente pacienteSuperior = cola[posicionSuperior];
        if (pacienteSuperior != null) {
            int posicionHijoi = posicionSuperior * 2 + 1;
            int posicionHijod = posicionSuperior * 2 + 2;
            Paciente hijoi = cola[posicionHijoi];
            Paciente hijod = cola[posicionHijod];
            if (hijoi != null && hijoi.compareTo(pacienteSuperior) < 0) {
//            if (hijoi != null && hijoi.getPrioridad() > pacienteSuperior.getPrioridad()) {
                cola[posicionHijoi] = pacienteSuperior;
                cola[posicionSuperior] = hijoi;
                cambiaAbajo(posicionHijoi);
            }
            if (hijod != null && hijod.compareTo(pacienteSuperior) < 0 ) {
//            if (hijod != null && hijod.getPrioridad() < pacienteSuperior.getPrioridad()) {
                cola[posicionHijod] = pacienteSuperior;
                cola[posicionSuperior] = hijod;
                cambiaAbajo(posicionHijod);
            }
//            if (hijod == null && hijoi == null) {
//                cola[posicionSuperior] = null;
//            }
        }
    }










    //    public void OrdenarCola
    @Override
    public Paciente cambiarPrioridad(String DNI, int nuevaPrioridad, int hora) throws PacienteNoExisteException {
        Paciente p = getPaciente(DNI);
        int pos = buscarPosicion(DNI);
        if (p == null) {
            throw new PacienteNoExisteException();
        }
        p.setPrioridad(nuevaPrioridad);
        p.setTiempoAdmisionEnPrioridad(hora);
        int posicionPacienteNuevo = pos;
        cola[posicionPacienteNuevo] = p;
        // hay que cambiar con papi ?
        // miramos  si hay papi
        if (posicionPacienteNuevo != 0) {
            int posicionPadre = posicionDelPadre(posicionPacienteNuevo);
            Paciente padre = cola[posicionPadre];
            while (posicionPacienteNuevo != 0 && p.getPrioridad() < padre.getPrioridad()) {
                if (posicionPacienteNuevo != 0) {
                    cola[posicionPacienteNuevo] = padre;
                    cola[posicionPadre] = p;
                    posicionPacienteNuevo = posicionPadre;
                    posicionPadre = posicionDelPadre(posicionPacienteNuevo);
                    if (posicionPadre >= 0) {
                        padre = cola[posicionPadre];
                    }
                }
            }
        }
        return p;
    }

    @Override
    public Paciente salirPaciente(String DNI, int hora) throws PacienteNoExisteException {
        Paciente paciente = getPaciente(DNI);
        if (paciente == null) {
            throw new PacienteNoExisteException();
        }
        int posicionSuperior = buscarPosicion(DNI);  //Buscar paciente por dni
        Paciente pacienteSaliente = cola[posicionSuperior];
        cambiaAbajo(posicionSuperior);
        cola[posicionSuperior] = null;
//        ultimaPosicionOcupada--;
        return pacienteSaliente;
    }


    // Aumenta la prioridad de los pacientes que han esperado mas que
// maxTiempoEspera en su prioridad actual.
//    public Paciente cambiarPrioridad(String DNI, int nuevaPrioridad, int hora) throws PacienteNoExisteException {
    @Override
    public void aumentaPrioridad(int maxTiempoEspera, int hora) { //ESTO DUDAAAAA
        int tiempo = 0;
        for (int i = 0; i < cola.length; i++) {
            Paciente p = cola[i];
            if (p != null && p.getPrioridad() != 0) {

                if (p.getTiempoAdmisionEnPrioridad() == 0) {
                    tiempo = hora - p.getTiempoAdmision();
                } else {
                    tiempo = hora - p.getTiempoAdmisionEnPrioridad();
                }
//                tiempo = p.getTiempoAdmisionEnPrioridad() - p.getTiempoAdmision();

                if (tiempo > maxTiempoEspera) {
                    int NuevaPrio = p.getPrioridad() - 1;
                    p.setPrioridad(NuevaPrio);
                    p.setTiempoAdmisionEnPrioridad(hora);
                }
            }
        }
    }


    @Override
    public Iterable<Paciente> pacientesEsperando() {
        PositionList<Paciente> caminos = new NodePositionList<>();
        for (int i = 0; i <= posicionUltimoPaciente(); i++) {
            Paciente p = cola[i];
            if (p != null) {
                caminos.addLast(p);
            }
        }
//        for (Paciente p: cola){
//            if (p != null) {
//                caminos.addLast(p);
//            }
//        }
        return caminos;

    }


    @Override
    public Paciente getPaciente(String DNI) {
        for (int i = 0; i < cola.length; i++) {
            if (cola[i] != null) {
                if (cola[i].getDNI().equals(DNI)) {
                    return cola[i];
                }
            }
        }
        return null;
    }

    // Devuelve un par con (i) la suma de los tiempos de espera desde la
    // admision hasta ser atendido, para todos los pacientes que han
    // sido atendidos, y (ii) el numero de pacientes atendidos.
    //COMO PARO EN EL QUE QUIERO
    @Override
    public Pair<Integer, Integer> informacionEspera() {
        Paciente paciente;
        Integer tiempo = contadorTiempoEspera; //Suma de los tiempos de espera
        Integer NPacientes = contadorPacientes;
        Pair<Integer, Integer> resultado = new Pair<>(tiempo, NPacientes);

        return resultado;
    }
}

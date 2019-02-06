package registrousuarios;


public class Lista<T> {

    private Nodo<T> Frente;
    private Nodo<T> Fin;
    public T Dr;

    public Lista() {
        Frente = Fin = null;
        Dr = null;
    }

    public boolean InsertaOrdenado(T Dato) {
        if (Dato == null) {
            return false;
        }
        Nodo<T> Nuevo;
        try {
            Nuevo = new Nodo<T>(Dato);
        } catch (Exception e) {
            return false;
        }
        // primer nodo de la lista
        if (Frente == null) {
            Frente = Fin = Nuevo;
            return true;
        }
        String IdNuevo = Dato.toString();
        /*
		// Insertar al inicion de la lista
		if(IdNuevo.compareTo(Frente.Info.toString())<=0){
			Nuevo.setSig(Frente);
			Frente=Nuevo;
			return true;
		}

		// Insertar al final de la lista
		if(IdNuevo.compareTo(Fin.Info.toString())>=0){
			Fin.setSig(Nuevo);
			Fin=Nuevo;
			return true;
		}
         */
        // entre dos nodos
        Nodo<T> Aux = Frente;
        Nodo<T> Ant = null;
        while (Aux != null && Aux.Info.toString().compareTo(IdNuevo) <= 0) {
            Ant = Aux;
            Aux = Aux.getSig();
        }
        // Inicio de la lista
        if (Ant == null) {
            Nuevo.setSig(Frente);
            Frente = Nuevo;
            return true;
        }
        // FInal de la lista
        if (Aux == null) {
            Fin.setSig(Nuevo);
            Fin = Nuevo;
            return true;
        }
        // entre dos nodos
        Ant.setSig(Nuevo);
        Nuevo.setSig(Aux);

        return true;
    }

    public boolean InsertaFrente(T Dato) {
        if (Dato == null) {
            return false;
        }
        Nodo<T> Nuevo = new Nodo<T>(Dato);

        if (Frente == null) {
            Frente = Fin = Nuevo;
        } else {
            Nuevo.setSig(Frente);
            Frente = Nuevo;
        }
        return true;
    }

    public boolean InsertaFin(T Dato) {
        if (Dato == null) {
            return false;
        }
        Nodo<T> Nuevo;
        try {
            Nuevo = new Nodo<T>(Dato);
        } catch (Exception e) {
            return false;
        }

        if (Frente == null) {
            Frente = Fin = Nuevo;
        } else {
            Fin.setSig(Nuevo);
            Fin = Nuevo;
        }
        return true;
    }

    public int Length() {
        Nodo<T> Aux = Frente;
        int Cont = 0;
        while (Aux != null) {
            Cont++;
            Aux = Aux.getSig();
        }
        return Cont;
    }

    public boolean Retira(int Posicion) {
        if (Posicion > Length()) {
            return false;
        }
        Nodo<T> Aux = Frente;
        Nodo<T> Ant = null;
        for (int i = 1; i < Posicion; i++) {
            Ant = Aux;
            Aux = Aux.getSig();
        }
        EliminaNodo(Aux, Ant);
        return true;

    }

    public boolean Retira(T Dato) {
        String IdNodo = Dato.toString();

        Nodo<T> Aux = Frente;
        Nodo<T> Ant = null;
        String IdNodoActual;
        boolean Band = false;
        while (Aux != null) {
            IdNodoActual = Aux.Info.toString();
            if (IdNodo.compareToIgnoreCase(IdNodoActual) == 0) {
                Band = true;
                break;
            }
            Ant = Aux;
            Aux = Aux.getSig();
        }
        if (!Band) {
            return false;
        }
        EliminaNodo(Aux, Ant);

        return true;
    }

    private void EliminaNodo(Nodo<T> Aux, Nodo<T> Ant) {
        Dr = Aux.Info;
        //�nico nodo de la lista
        if (Frente == Fin) {
            Frente = Fin = null;
            return;
        }
        // Primero de la lista
        if (Aux == Frente) {
            Frente = Frente.getSig();
            return;
        }
        // �ltimo de la lista
        if (Aux == Fin) {
            Ant.setSig(null);
            Fin = Ant;
            return;
        }
        // entre dos nodos
        Ant.setSig(Aux.getSig());
    }

    public Nodo<T> getFrente() {
        return Frente;
    }

    public Nodo<T> getFin() {
        return Fin;
    }
}

public class ListaDoblementeEnlazada {
    private Nodo primero;

    public ListaDoblementeEnlazada() {
        primero = null;
    }

    public void agregarAlFinal(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setAnterior(actual);
        }
    }

    public Nodo getPrimero() {
        return primero;
    }

    public ListaDoblementeEnlazada eliminarNoAscendentes() {
        ListaDoblementeEnlazada eliminados = new ListaDoblementeEnlazada();
        primero = eliminarRecursivo(primero, eliminados, primero.getElemento());
        return eliminados;
    }

    private Nodo eliminarRecursivo(Nodo nodo, ListaDoblementeEnlazada eliminados, int maximo) {
        if (nodo == null) return null;
        Nodo sig = nodo.getSiguiente();
        if (nodo.getElemento() >= maximo) {
            nodo.setSiguiente(eliminarRecursivo(sig, eliminados, nodo.getElemento()));
            if (nodo.getSiguiente() != null)
                nodo.getSiguiente().setAnterior(nodo);
            return nodo;
        } else {
            eliminados.insertarAlInicio(nodo.getElemento());
            return eliminarRecursivo(sig, eliminados, maximo);
        }
    }

    public void insertarAlInicio(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        nuevo.setSiguiente(primero);
        if (primero != null)
            primero.setAnterior(nuevo);
        primero = nuevo;
    }

    public void imprimir() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getElemento() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}


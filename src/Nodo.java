public class Nodo {
    private int elemento;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(int elemento) {
        this.elemento = elemento;
        siguiente = null;
        anterior = null;
    }

    public int getElemento() {
        return elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setSiguiente(Nodo n) {
        siguiente = n;
    }

    public void setAnterior(Nodo n) {
        anterior = n;
    }
}

package src;
// ==========================================
//  CLASE PILA
// ==========================================

public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public void push(Pizza pizza) {
        Nodo nuevo = new Nodo(pizza);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }
        Pizza pizzaRemovida = tope.dato;
        tope = tope.siguiente;
        return pizzaRemovida;
    }

    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }
}
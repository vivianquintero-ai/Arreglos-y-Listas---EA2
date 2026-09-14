package src;
// ==========================================
//  CLASE PIZZA
// ==========================================
public class Pizza {
    private String nombre;
    private String[] ingredientes = new String[3];

    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        for (int i = 0; i < 3; i++) {
            this.ingredientes[i] = ingredientes[i];
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        String listaIngredientes = String.join(", ", ingredientes);
        return "Pizza: " + nombre + " [Ingredientes: " + listaIngredientes + "]";
    }
}
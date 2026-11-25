
import java.util.ArrayList;
import java.util.List;

// Interfaz que establece el comportamiento de los productos inventariables
interface Inventariable {
    void mostrarInformacion();
    double calcularValorInventario();
}

// Clase abstracta que contiene los atributos y métodos comunes
abstract class Producto implements Inventariable {
    protected int id;
    protected String nombre;
    protected double precio;
    protected int cantidad;

    // Constructor de la clase principal
    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Método que calcula el valor total de un producto en inventario
    @Override
    public double calcularValorInventario() {
        return precio * cantidad;
    }
}

// Clase derivada para productos electrónicos
class Electronico extends Producto {
    private int garantiaMeses;

    public Electronico(int id, String nombre, double precio,
                      int cantidad, int garantiaMeses) {
        super(id, nombre, precio, cantidad);
        this.garantiaMeses = garantiaMeses;
    }

    // Muestra los datos generales y específicos del electrónico
    @Override
    public void mostrarInformacion() {
        System.out.println("Producto electrónico: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Garantía: " + garantiaMeses + " meses");
        System.out.println("Valor en inventario: $" + calcularValorInventario());
        System.out.println("--------------------------");
    }
}

// Clase derivada para alimentos
class Alimento extends Producto {
    private String fechaCaducidad;

    public Alimento(int id, String nombre, double precio,
                   int cantidad, String fechaCaducidad) {
        super(id, nombre, precio, cantidad);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Alimento: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Caducidad: " + fechaCaducidad);
        System.out.println("Valor en inventario: $" + calcularValorInventario());
        System.out.println("--------------------------");
    }
}

// Clase derivada para ropa
class Ropa extends Producto {
    private String talla;

    public Ropa(int id, String nombre, double precio,
                int cantidad, String talla) {
        super(id, nombre, precio, cantidad);
        this.talla = talla;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Ropa: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Talla: " + talla);
        System.out.println("Valor en inventario: $" + calcularValorInventario());
        System.out.println("--------------------------");
    }
}

// Clase principal del programa
public class SistemaInventario {
    public static void main(String[] args) {

        // Lista que permite almacenar diferentes tipos de productos
        List<Producto> inventario = new ArrayList<>();

        // Creación de objetos de las clases derivadas
        inventario.add(new Electronico(1, "Laptop", 12000, 3, 12));
        inventario.add(new Alimento(2, "Leche", 28, 10, "30/12/2026"));
        inventario.add(new Ropa(3, "Playera", 250, 5, "M"));

        // Polimorfismo: se recorren diferentes productos
        // utilizando una referencia común de tipo Producto
        double totalInventario = 0;

        System.out.println("===== SISTEMA DE INVENTARIO =====");

        for (Producto producto : inventario) {
            producto.mostrarInformacion();
            totalInventario += producto.calcularValorInventario();
        }

        // Se muestra el valor general del inventario
        System.out.println("Valor total del inventario: $"
                + totalInventario);
    }
}

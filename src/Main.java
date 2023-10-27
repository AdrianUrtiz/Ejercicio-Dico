import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Clase abstracta para representar a un empleado
abstract class Empleado {
    private String rfc;
    private String nombre;
    private String apellidoPaterno;
    private String fechaNacimiento;
    private String ultimosEstudios;
    private double ventasMes;
    private double sueldo;

    public Empleado(String rfc, String nombre, String apellidoPaterno, String fechaNacimiento, String ultimosEstudios, double ventasMes, double sueldo) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.ultimosEstudios = ultimosEstudios;
        this.ventasMes = ventasMes;
        this.sueldo = sueldo;
    }

    public abstract String obtenerInformacion();


    public String getRfc() {
        return rfc;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getNombre() {
        return nombre;
    }
    public double getVentasMes() {
        return ventasMes;
    }
    public double getSueldo() {
        return sueldo;
    }
}

// Definir subclases concretas de Empleado
class EmpleadoSucursal1 extends Empleado {
    public EmpleadoSucursal1(String rfc, String nombre, String apellidoPaterno, String fechaNacimiento, String ultimosEstudios, double ventasMes, double sueldo) {
        super(rfc, nombre, apellidoPaterno, fechaNacimiento, ultimosEstudios, ventasMes, sueldo);
    }

    @Override
    public String obtenerInformacion() {
        return "RFC: " + getRfc() + ", Nombre: " + getNombre() + ", Ventas: " + getVentasMes() + ", Sueldo: " + getSueldo();
    }
}

class EmpleadoSucursal2 extends Empleado {
    public EmpleadoSucursal2(String rfc, String nombre, String apellidoPaterno, String fechaNacimiento, String ultimosEstudios, double ventasMes, double sueldo) {
        super(rfc, nombre, apellidoPaterno, fechaNacimiento, ultimosEstudios, ventasMes, sueldo);
    }

    @Override
    public String obtenerInformacion() {
        return "RFC: " + getRfc() + ", Nombre: " + getNombre() + ", Ventas: " + getVentasMes() + ", Sueldo: " + getSueldo();
    }
}

class EmpleadoSucursal3 extends Empleado {
    public EmpleadoSucursal3(String rfc, String nombre, String apellidoPaterno, String fechaNacimiento, String ultimosEstudios, double ventasMes, double sueldo) {
        super(rfc, nombre, apellidoPaterno, fechaNacimiento, ultimosEstudios, ventasMes, sueldo);
    }

    @Override
    public String obtenerInformacion() {
        return "RFC: " + getRfc() + ", Nombre: " + getNombre() + ", Ventas: " + getVentasMes() + ", Sueldo: " + getSueldo();
    }
}

// Clase abstracta para representar una sucursal
abstract class Sucursal {
    protected List<Empleado> empleados = new ArrayList<>();
    protected List<Venta> ventas = new ArrayList<>();

    public void registrarVenta(Empleado empleado, double monto) {
        ventas.add(new Venta(empleado, monto));
    }

    public void darAltaEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void darBajaEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleados;
    }

    public abstract String obtenerListadoEmpleados();
}

// Implementación concretas de las sucursales
class Sucursal1 extends Sucursal {
    @Override
    public String obtenerListadoEmpleados() {
        // Implementación específica de listado por RFC
        empleados.sort((e1, e2) -> e1.getRfc().compareTo(e2.getRfc()));
        StringBuilder listado = new StringBuilder();
        for (Empleado empleado : empleados) {
            listado.append(empleado.obtenerInformacion()).append("\n");
        }
        return listado.toString();
    }
}

class Sucursal2 extends Sucursal {
    @Override
    public String obtenerListadoEmpleados() {
        // Implementación específica de listado general (limitado a 5 empleados)
        StringBuilder listado = new StringBuilder();
        for (Empleado empleado : empleados) {
            listado.append(empleado.obtenerInformacion()).append("\n");
        }
        return listado.toString();
    }
}

class Sucursal3 extends Sucursal {
    @Override
    public String obtenerListadoEmpleados() {
        // Implementación específica de listado por Apellido Paterno
        empleados.sort((e1, e2) -> e1.getApellidoPaterno().compareTo(e2.getApellidoPaterno()));
        StringBuilder listado = new StringBuilder();
        for (Empleado empleado : empleados) {
            listado.append(empleado.obtenerInformacion()).append("\n");
        }
        return listado.toString();
    }
}

// Clase para representar una venta
class Venta {
    private Empleado empleado;
    private double monto;

    public Venta(Empleado empleado, double monto) {
        this.empleado = empleado;
        this.monto = monto;
    }

    // Otros métodos getter y setter
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear una ventana de ejemplo
            JFrame frame = new JFrame("Gestión de Mueblerías DICO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            frame.add(new JScrollPane(textArea));

            // Ejemplo de uso
            Empleado empleado1 = new EmpleadoSucursal1("RFC1", "Juan", "Perez", "01/01/1990", "Licenciatura", 10000, 5000);

            Empleado empleado2 = new EmpleadoSucursal1("RFC2", "Maria", "Lopez", "15/05/1985", "Maestría", 12000, 6000);

            Sucursal sucursal1 = new Sucursal1();
            sucursal1.darAltaEmpleado(empleado1);
            sucursal1.darAltaEmpleado(empleado2);

            textArea.setText("Listado de empleados en Sucursal 1:\n");
            textArea.append(sucursal1.obtenerListadoEmpleados());

            frame.pack();
            frame.setVisible(true);
        });
    }
}
import javax.swing.*;

class EmpleadoSucursal1 extends Empleado {
    public EmpleadoSucursal1(String rfc, String nombre, String apellidoPaterno,
                             String fechaNacimiento, String ultimosEstudios,
                             double ventasMes, double sueldo)
    {
        super(rfc, nombre, apellidoPaterno, fechaNacimiento, ultimosEstudios,
                ventasMes, sueldo);
    }

    @Override
    public String obtenerInformacion() {
        return "RFC: " + getRfc() + ", Nombre: " + getNombre() + ", Ventas: "
                + getVentasMes() + ", Sueldo: " + getSueldo();
    }
}

class EmpleadoSucursal2 extends Empleado {
    public EmpleadoSucursal2(String rfc, String nombre, String apellidoPaterno,
                             String fechaNacimiento, String ultimosEstudios,
                             double ventasMes, double sueldo)
    {
        super(rfc, nombre, apellidoPaterno, fechaNacimiento, ultimosEstudios,
                ventasMes, sueldo);
    }

    @Override
    public String obtenerInformacion() {
        return "RFC: " + getRfc() + ", Nombre: " + getNombre() + ", Ventas: "
                + getVentasMes() + ", Sueldo: " + getSueldo();
    }
}
class EmpleadoSucursal3 extends Empleado {
    public EmpleadoSucursal3(String rfc, String nombre, String apellidoPaterno,
                             String fechaNacimiento, String ultimosEstudios,
                             double ventasMes, double sueldo) {
        super(rfc, nombre, apellidoPaterno, fechaNacimiento, ultimosEstudios,
                ventasMes, sueldo);
    }

    @Override
    public String obtenerInformacion() {
        return "RFC: " + getRfc() + ", Nombre: " + getNombre() + ", Ventas: "
                + getVentasMes() + ", Sueldo: " + getSueldo();
    }
}

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
            Empleado empleado1 = new EmpleadoSucursal1("RFC1", "Juan",
                    "Perez", "01/01/1990", "Licenciatura",
                    10000, 5000);

            Empleado empleado2 = new EmpleadoSucursal1("RFC2", "Maria",
                    "Lopez", "15/05/1985", "Maestría",
                    12000, 6000);

            Empleado empleado3 = new EmpleadoSucursal2("RFC3", "Laura",
                    "Velazquez", "11/10/1995", "Ingenieria",
                    16000, 8000);

            Sucursal sucursal1 = new Sucursal1();
            sucursal1.darAltaEmpleado(empleado1);
            sucursal1.darAltaEmpleado(empleado2);

            Sucursal sucursal2 = new Sucursal2();
            sucursal2.darAltaEmpleado(empleado3);

            textArea.setText("Listado de empleados en Sucursal 1:\n");
            textArea.append(sucursal2.obtenerListadoEmpleados());

            frame.pack();
            frame.setVisible(true);
        });
    }
}
import java.util.ArrayList;
import java.util.List;

public abstract class Sucursal {
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

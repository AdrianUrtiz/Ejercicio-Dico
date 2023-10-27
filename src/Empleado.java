public abstract class Empleado {
    private String rfc;
    private String nombre;
    private String apellidoPaterno;
    private String fechaNacimiento;
    private String ultimosEstudios;
    private double ventasMes;
    private double sueldo;

    public Empleado(String rfc, String nombre, String apellidoPaterno,
                    String fechaNacimiento, String ultimosEstudios,
                    double ventasMes, double sueldo)
    {
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
package registrousuarios;

/**
 *
 * @author Carlos Contreras
 */
public class Usuario {

    private String nombre;
    private int edad;
    private int estatura; // TODO: Hacerlo funcionar con double
    private int criterioOrdenamiento;

    public Usuario(String nombre, int edad, int estatura, int criterioOrdenamiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.criterioOrdenamiento = criterioOrdenamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getEstatura() {
        return estatura;
    }

    // Cambiar el criterio de ordenamiento desde el Main
    public void setCriterioOrdenamiento(int criterioOrdenamiento) {
        this.criterioOrdenamiento = criterioOrdenamiento;
    }

    @Override
    public String toString() {
        if (criterioOrdenamiento == UtilsCriterioOrdenamiento.POR_NOMBRE)
            return Rutinas.PonBlancos(nombre, 50);
        if (criterioOrdenamiento == UtilsCriterioOrdenamiento.POR_EDAD)
            return Rutinas.PonCeros(edad, 5);
        if (criterioOrdenamiento == UtilsCriterioOrdenamiento.POR_ESTATURA) 
            return Rutinas.PonCeros(estatura, 5); // WARNING: A lo mejor el casteo a int me da problemas.
        if (criterioOrdenamiento == UtilsCriterioOrdenamiento.POR_EDAD_ESTATURA_NOMBRE)
            return Rutinas.PonCeros(edad, 5) + Rutinas.PonCeros(estatura, 5) + Rutinas.PonBlancos(nombre, 50);
        // Clean Code. ¿Dejar este ultimo if con un return en blanco al ultimo? O sin if, que este sea el ultimo return.
        return "";
    }
    
    public String mostrarInformacion() {
        return "Nombre: " + nombre + "\t| Edad: " + edad + "\t| Estatura: " + estatura;
    }

}

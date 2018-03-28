import java.util.List;

public class Controlador{
  private Modelo modelo;
  private Vista vista;
  public Controlador(Modelo modelo, Vista vista){
    this.modelo = modelo;
    this.vista = vista;
    System.out.println("controlador creado");
  }

  public void crearEstudiante(String nombre, int id, int edad, String genero){
    modelo.crearEstudiante(nombre, id, edad, genero);
  }

  public Estudiante buscarEstudiante(int id){
    return modelo.buscarEstudiante(id);
  }

  public void actualizarEstudiante(String nombre, int id, int edad, String genero){
    modelo.actualizarEstudiante(nombre, id, edad, genero);
  }

  public void eliminarEstudiante(int id){
    modelo.eliminarEstudiante(id);
  }

  public void mostrarEstudiante(int id){
    Estudiante estudiante = modelo.buscarEstudiante(id);
    vista.mostrarDatosEstudiante(estudiante.getNombre(), id, estudiante.getEdad(), estudiante.getGenero());
  }

  public List<Estudiante> obtenerEstudiantes(){
    return modelo.obtenerEstudiantes();
  }
}

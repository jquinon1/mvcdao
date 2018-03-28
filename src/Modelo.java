import java.util.List;

public class Modelo{
  private DaoEstudiante daoEstudiante;

  public Modelo(){
    daoEstudiante = new MySqlEstudiante();
  }

  public void crearEstudiante(String nombre, int id, int edad, String genero){
    daoEstudiante.crearEstudiante(nombre, id, edad, genero);
  }

  public Estudiante buscarEstudiante(int id){
    return daoEstudiante.buscarEstudiante(id);
  }

  public void actualizarEstudiante(String nombre, int id, int edad, String genero){
    daoEstudiante.actualizarEstudiante(nombre, id, edad, genero);
  }

  public void eliminarEstudiante(int id){
    daoEstudiante.eliminarEstudiante(id);
  }

  public List<Estudiante> obtenerEstudiantes(){
    return daoEstudiante.obtenerEstudiantes();
  }
}

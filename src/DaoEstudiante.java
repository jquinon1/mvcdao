import java.util.List;

public interface DaoEstudiante{
  public List<Estudiante> obtenerEstudiantes();
  public void crearEstudiante(String nombre, int id, int edad, String genero);
  public Estudiante buscarEstudiante(int id);
  public void actualizarEstudiante(String nombre, int id, int edad, String genero);
  public void eliminarEstudiante(int id);
}

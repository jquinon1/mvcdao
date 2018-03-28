import java.util.Scanner;
import java.util.List;

public class Principal{
  public static void main(String[] args){
    Modelo modelo = new Modelo();
    Vista vista = new Vista();
    Controlador controlador = new Controlador(modelo, vista);
    controlador.crearEstudiante("Camilo", 1152345678, 21, "Macho");
    List<Estudiante> estudiantes = controlador.obtenerEstudiantes();
    Estudiante primero = estudiantes.get(0);
    //controlador.mostrarEstudiante(primero.getId());
    controlador.mostrarEstudiante(0);
  }
}

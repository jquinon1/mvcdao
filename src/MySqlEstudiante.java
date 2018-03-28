import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlEstudiante implements DaoEstudiante{
  private List<Estudiante> estudiantes;
  private String _usuario = "root";
  private String _pwd = "root";
  private static String _bd = "miBasecita";
  static String _url = "jdbc:mysql://localhost/" + _bd;
  private Connection conn = null;

  public MySqlEstudiante(){
    estudiantes = new ArrayList<>();
    try {
    	Class.forName("com.mysql.jdbc.Connection");
    	conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
    	if(conn != null) {
    		System.out.println("conexion a base de datos " + _url + " ok");
    	}
    }catch(SQLException ex){
    	System.out.println("Hubo un problema al intentar conectarse a la base de datos" + _url);
    }catch(ClassNotFoundException ex) {
    	System.out.println(ex);
    }
  }

  public void crearEstudiante(String nombre, int id, int edad, String genero){
    Estudiante estudiante = new Estudiante(nombre, id, edad, genero);
    estudiantes.add(estudiante);
  }

  public Estudiante buscarEstudiante(int id){
	ResultSet resultado = getQuery("select * from persona where identificacion = " + id);
	String nombre;
	try {
		while(resultado.next()){
			nombre = resultado.getString("nombre");
			System.out.println("el nombre es: " + nombre);
		}
  }catch(SQLException e) {
			e.printStackTrace();
		}
    return estudiantes.get(0);
    //terminar de implementar para que busque que estudiante es con el id.
  }

  public void actualizarEstudiante(String nombre, int id, int edad, String genero){
    estudiantes.get(0).setNombre(nombre);
    estudiantes.get(0).setEdad(edad);
    estudiantes.get(0).setGenero(genero);
    System.out.println("Se actualizo el estudiante con id " + id);
    //terminar de implementar para actualizar estudiante con el id que es
  }

  public void eliminarEstudiante(int id){
    estudiantes.remove(0);
    System.out.println("Se elimino el estudiante con id " + id);
    //terminar de implementar para eliminar estudiante con el id que es
  }

  public List<Estudiante> obtenerEstudiantes(){
    return estudiantes;
  }

  public ResultSet getQuery(String query) {
	  Statement state = null;
	  ResultSet resultado = null;
	  try {
		  state = (Statement) conn.createStatement();
		  resultado = state.executeQuery(query);
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
	  return resultado;
  }

  public void setQuery(String query) {
	  Statement state = null;
	  try {
		  state = (Statement) conn.createStatement();
		  state.executeQuery(query);
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
  }
}

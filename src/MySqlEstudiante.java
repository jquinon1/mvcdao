import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlEstudiante implements DaoEstudiante{
  private String _usuario = "root";
  private String _pwd = "obupro20";
  private static String _bd = "miBasecita";
  static String _url = "jdbc:mysql://db:3306/"+_bd+"?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useSSL=false";
  private Connection conn = null;

  public MySqlEstudiante(){
    try {
    	Class.forName("com.mysql.jdbc.Connection");
    	conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
    	if(conn != null) {
    		System.out.println("conexion a base de datos " + _url + " ok");
    	}
    }catch(SQLException ex){
      System.err.println(ex.getMessage());
    	System.out.println("Hubo un problema al intentar conectarse a la base de datos" + _url);
    }catch(ClassNotFoundException ex) {
    	System.out.println(ex);
    }
  }

  public void crearEstudiante(String nombre, int id, int edad, String genero){
    setQuery("INSERT INTO estudiantes (id, nombre, identificacion, edad, genero) VALUES (NULL, \"" + nombre + "\", " + id + ", " + edad + ", \"" + genero + "\");");
  }

  public Estudiante buscarEstudiante(int id){
	ResultSet resultado = getQuery("select * from estudiantes where identificacion = " + id);
	String nombre = "", identificacion = "0", edad = "0", genero = "";
	try {
		while(resultado.next()){
			nombre = resultado.getString("nombre");
			identificacion = resultado.getString("identificacion");
			edad = resultado.getString("edad");
			genero = resultado.getString("genero");
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return new Estudiante(nombre, Integer.parseInt(identificacion), Integer.parseInt(edad), genero);
  }

  public void actualizarEstudiante(String nombre, int id, int edad, String genero){
    setQuery("update estudiantes set nombre = \"" + nombre + "\", edad = " + edad + ", genero = \"" + genero + "\" where identificacion = " + id + ";");
    System.out.println("Se actualizo el estudiante con id " + id);
  }

  public void eliminarEstudiante(int id){
	setQuery("delete from estudiantes where identificacion = " + id + ";");
  }

  public List<Estudiante> obtenerEstudiantes(){
	List<Estudiante> estudiantes = new ArrayList<>();
	ResultSet resultado = getQuery("select * from estudiantes");
	String nombre = "", identificacion = "0", edad = "0", genero = "";
	try {
		while(resultado.next()){
			nombre = resultado.getString("nombre");
			identificacion = resultado.getString("identificacion");
			edad = resultado.getString("edad");
			genero = resultado.getString("genero");
			estudiantes.add(new Estudiante(nombre, Integer.parseInt(identificacion), Integer.parseInt(edad), genero));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
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
		  state.executeUpdate(query);
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
  }
}

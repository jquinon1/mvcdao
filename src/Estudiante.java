public class Estudiante{
  private String nombre;
  private int id;
  private int edad;
  private String genero;
  public Estudiante(String nombre, int id, int edad, String genero){
    this.nombre = nombre;
    this.id = id;
    this.edad = edad;
    this.genero = genero;
  }

  public String getNombre(){
    return nombre;
  }

  public int getId(){
    return id;
  }

  public int getEdad(){
    return edad;
  }

  public String getGenero(){
    return genero;
  }
}

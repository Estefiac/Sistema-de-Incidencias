

public class Reporte {
	private int nomina, clasificacion, usuario;
	private String nombre, fecha, descripcion, status;
	
  /*  Function: Reporte
	 *  @return:
	 *  @params: 
	 *  Crea el objeto de Reporte con sus atributos
	*/
	public Reporte(int nomina,String nombre, String fecha, String descripcion, int clasificacion, String status, int usuario) {
		super();
        this.nomina = nomina;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.clasificacion = clasificacion;
        this.status = status;
        this.usuario = usuario;
		
	}

  /*  Function: getNomina
	 *  @return: int
	 *  @params: 
	 *  Retorna la nómina del reporte
	*/
	public int getNomina() {
		return nomina;
	}

  /*  Function: getUsuario
	 *  @return: int
	 *  @params: 
	 *  Retorna el usuario asignado del reporte
	*/
	public int getUsuario() {
		return usuario;
	}

  /*  Function: getClasificacion
	 *  @return: int
	 *  @params: 
	 *  Retorna la clasificación del reporte
	*/
	public int getClasificacion() {
		return clasificacion;
	}

  /*  Function: getNombre
	 *  @return: String
	 *  @params: 
	 *  Retorna el nombre del cliente de un reporte
	*/
	public String getNombre() {
		return nombre;
	}

  /*  Function: getFecha
	 *  @return: String
	 *  @params: 
	 *  Retorna la fecha de registro del reporte
	*/
	public String getFecha() {
		return fecha;
	}

  /*  Function: getDescripcion
	 *  @return: String
	 *  @params: 
	 *  Retorna la descripcion del reporte
	*/
	public String getDescripcion() {
		return descripcion;
	}

  /*  Function: getStatus
	 *  @return: String
	 *  @params: 
	 *  Retorna el estatus del reporte
	*/
	public String getStatus() {
		return status;
	}

  /*  Function: setStatus
	 *  @return: void
	 *  @params: 
	 *  Asigna un valor al estatus del reporte
	*/
	public void setStatus(String status) {
		this.status = status;
	}


}
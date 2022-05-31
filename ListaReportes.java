import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;
import java.util.InputMismatchException;

public class ListaReportes {
	public ArrayList <Reporte> reportesRegistrados = new ArrayList <>();
	public ArrayList <Reporte> reportesAsignados = new ArrayList <>();
	public ArrayList <Reporte> reportesCerrados = new ArrayList <>();

	/* Function: agregar 
	 * @return: boolean 
	 * @params: Reporte r
	 * Añade la instacia de reporte a la lista de reportes registrados
	*/
	public boolean agregar(Reporte r) {
    try{
      long numCarga = (long)(Math.random() * 1000);
      System.out.print("\n\t\t\t\tIniciando registro ");
      Thread.sleep(numCarga);
      System.out.print(" ⭐️ ");
      Thread.sleep(numCarga);
      System.out.print(" ⭐️ ");
      Thread.sleep(numCarga);
      System.out.print(" ⭐️ ");
      Thread.sleep(1500);
      reportesRegistrados.add(r);
      System.out.println("\n\t\t\t\t¡Registro Exitoso!");
      Thread.sleep(numCarga);
      return true;
    }catch(Exception e){
    	return false;
    }
	}
	
  /* Function: listaAsignada 
	 * @return: boolean 
	 * @params: int encargado
	 * Actualiza la lista de reportes del usuario específico
	*/
	public boolean listaAsignada(int encargado) {
		if(reportesRegistrados.isEmpty()) {
			System.out.println(mensajeIncidencia());
			return false;
		}
		else {
	      if(reportesAsignados.isEmpty()) {
	        for(int i = 0; i < reportesRegistrados.size(); i++){
	          if(reportesRegistrados.get(i).getUsuario() == encargado) {
	            reportesAsignados.add(reportesRegistrados.get(i));
	          }
				  }
	      }
	      else {
	        reportesAsignados.clear();
	        for(int i = 0; i< reportesRegistrados.size(); i++){
	          if(reportesRegistrados.get(i).getUsuario() == encargado && (!reportesRegistrados.get(i).getStatus().equals("cerrado"))) {
	            reportesAsignados.add(reportesRegistrados.get(i));
	          }
				  }
	      }
	      return true;
		}
	}
	
  /* Function: verLista 
	 * @return: void 
	 * @params: 
	 * Muestra la lista de reportes asignados del usuario 
	*/
	public void verLista() {
		if(reportesRegistrados.isEmpty()) {
			System.out.println(mensajeIncidencia());
		}
		else {
			for(int i=0; i<reportesRegistrados.size(); i++){
				System.out.println("\n\t\t\t\tNombre: "+reportesRegistrados.get(i).getNombre()+"\n\t\t\t\tEstatus: "+reportesRegistrados.get(i).getStatus()+"\n\t\t\t\tEncargado : Usuario "+reportesRegistrados.get(i).getUsuario()+"\n");
			}
		}
	}
	
  /* Function: verListaAsignada 
	 * @return: void 
	 * @params: 
	 * Muestra la lista de reportes asignados, enseñando el nombre del cliente y estatus 
	*/
	public void verListaAsignada() {
		if(reportesAsignados.isEmpty()) {
			System.out.println("\n\t\tNo hay ninguna incidencia para este usuario");
		}
		else {
			for(int i=0; i < reportesAsignados.size(); i++){
				System.out.println("\n\t\t\t\tNombre: "+reportesAsignados.get(i).getNombre()+"\n\t\t\t\tEstatus: "+reportesAsignados.get(i).getStatus()+"\n");
			}
		}
	}
	
  /* Function: verListaCerrada 
	 * @return: boolean 
	 * @params: 
	 * Muestra la lista de reportes cerrados 
	*/
	public boolean verListaCerrada() {
		if(reportesCerrados.isEmpty()) {
			System.out.println("\n\t\tNo hay ninguna incidencia finalizada");
			return false;
		}
		else {
			for(int i=0; i<reportesCerrados.size(); i++){
				System.out.println("\n\t\t\t\tNombre: "+reportesCerrados.get(i).getNombre()+"\n\t\t\t\tEstatus: "+reportesCerrados.get(i).getStatus()+"\n\t\t\t\tEncargado : "+reportesCerrados.get(i).getUsuario()+"\n");
			}
			return true;
		}
	}
	
  /* Function: estado 
	 * @return: boolean 
	 * @params: String cliente
	 * Retorna el estatus de un reporte a partir del cliente 
	 */
	public boolean estado(String cliente) {
		if(reportesRegistrados.isEmpty()) {
			System.out.println(mensajeIncidencia());
			return true;
		}
		else {
			for(int i=0; i<reportesRegistrados.size(); i++){
				if(reportesRegistrados.get(i).getNombre().equals(cliente)) {
					System.out.println("\n\t\t\t\tEstatus del Reporte: "+reportesRegistrados.get(i).getStatus());
					return true;
				}
			}
		}
		return false;
	}
	
	/* Function: verIncidencia 
	 * @return: boolean  
	 * @params: String cliente
	 * Muestra el reporte registrado a partir del cliente seleccionado
	*/
	public boolean verIncidencia(String cliente) {
    if(reportesAsignados.isEmpty()) {
			System.out.println(mensajeIncidencia());
			return true;
		}
		else {
			for(int i = 0; i < reportesAsignados.size(); i++){
				if(reportesAsignados.get(i).getNombre().equals(cliente)) {
					System.out.println("\n\t\t\t\tNombre del empleado: "+reportesAsignados.get(i).getNombre());
					System.out.println("\n\t\t\t\tNómina del empleado: "+reportesAsignados.get(i).getNomina());
					System.out.println("\n\t\t\t\tFecha de Reporte: "+reportesAsignados.get(i).getFecha());
					switch(reportesAsignados.get(i).getClasificacion()) {
					case 1:
						System.out.println("\n\t\t\t\tClasificación del Reporte: Crítico");
						break;
					case 2:
						System.out.println("\n\t\t\t\tClasificación del Reporte: Alto");
						break;	
					case 3:
						System.out.println("\n\t\t\t\tClasificación del Reporte: Medio");
						break;
					case 4:
						System.out.println("\n\t\t\t\tClasificación del Reporte: Bajo");
						break;
					case 5:
						System.out.println("\n\t\t\t\tClasificación del Reporte: Muy Bajo");
						break;
					}
					System.out.println("\n\t\t\t\tEstatus del Reporte: "+reportesAsignados.get(i).getStatus());
					System.out.println("\n\t\t\t\tDescripcion de la Incidencia: "+reportesAsignados.get(i).getDescripcion());
				reportesAsignados.get(i).setStatus("en proceso");
				return true;
				}
			}
		}
    return false;
	}	

	/* Function: resolverIncidencia 
	 * @return: boolean 
	 * @params: String cliente
	 * Actualiza el estado del reporte, posterior a su procesamiento por parte del usuario
	*/
  public boolean resolverIncidencia(String cliente) {
    Scanner entrada = new Scanner(System.in);
    if(reportesAsignados.isEmpty()) {
      System.out.println(mensajeIncidencia());
      return true;
    }
    else {
      for(int i=0; i<reportesAsignados.size(); i++){
        if(reportesAsignados.get(i).getNombre().equals(cliente)) {
           String estado = "";
          do {
            System.out.println("\n\t\t¿Estatus a asignar? : \n\t\tcerrado o en espera");
            estado = entrada.nextLine();
            if (estado.equals("cerrado")) {
              System.out.println("\n\t\tAcciones Tomadas :");
              String acciones = entrada.next();
                  int tiempo = 0;
              do{
                try {
                  System.out.println("\n\t\tHoras de trabajo :");
                  tiempo = entrada.nextInt();
                } catch(InputMismatchException e){
                  System.out.println("\n\t\tPor favor ingresa un tiempo adecuado");
                  tiempo = 0;
                  entrada.next();
                }
              } while(tiempo == 0);
            }
            else if(estado.equals("en espera")){
              System.out.println("\n\t\tRazón de espera :");
              String razon = entrada.next();
            }
            else {
              System.out.println("\n\t\tPor favor ingresa un estado posible");
              estado = "";
            }
          } while (estado == "");
          reportesAsignados.get(i).setStatus(estado);
          reportesCerrados.add(reportesAsignados.get(i));
          return true;
        }
      };
    
    }	
		return false;
	}

	/* Function: asignar 
	 * @return: int 
	 * @params: int urgencia
	 * Se encarga de pasar el reporte al usuario adecuado, en caso de que la urgencia sea 3
	*/
  public int asignar(int urgencia){
    int j;
    for(j = 1; j < 3; j++){ // Revisa en usuario supervisor y si no, se pasa al técnico y si no, se asigna al mostrador
      listaAsignada(j); // Se actualiza los reportes del usuario
      if(reportesAsignados.isEmpty()){
        return j;
      }
      else {
        for(int i=0; i < reportesAsignados.size(); i++){
          if(reportesAsignados.get(i).getClasificacion() == 3){
            break;          
          } 
        }
      }
    }
    return j;  
  }	

  /* Function: mensajeIncidencia
    * @return: String
    * @params:
    * Regresa el mensaje a imprimir cuando no hay reportes asignados
    */
  public String mensajeIncidencia() {
    return "\n\t\tPor el momento no hay ninguna incidencia registrada";
  }


}
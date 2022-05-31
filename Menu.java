import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	GenerarReporte nuevo = new GenerarReporte();
	ListaReportes lista = new ListaReportes();
	int opcion, tipo;
	String nombre, user[] = { "SUPERVISOR - Laura García [9371947]", 
                            "TÉCNICO - Sebastián Morales [3264019]", 
                            "MOSTRADOR - Jorge Silva [8264916]" };
	
	/*  Function: mostrarMenu
	 *  @return: void
	 *  @params: 
	 *  Muestra las opciones del menú
	 */
	public void mostrarMenu(){
		System.out.println();
		System.out.println("\t\t\t\t\t\tMENÚ PRINCIPAL");
		System.out.println("\t\t––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
		System.out.println();
		System.out.println("\t\t¿Qué te gustaría hacer?");
		System.out.println("\n\t\t1. Generar Reporte de Incidencia \n\n\t\t2. Ver Estado del Reporte \n\n\t\t3. Solventar Reportes \n\n\t\t4. Ver Reportes Generados \n\n\t\t5. Ver Incidencias Finalizadas \n\n\t\t6. Cerrar Programa🔒");
	}
	
	/*  Function: opciones
	 *  @return: void
	 *  @params: 
	 *  Crea un switch para que el usuario elija alguna de las opciones disponibles
	 */
	public void opciones() {
		do{
			mostrarMenu();
			Scanner entrada = new Scanner (System.in);
			try {
				opcion = entrada.nextInt();
				entrada.nextLine();
				switch (opcion) {
					case 1:  
						nuevo.registrar(lista);
						break;
						
					case 2: 
						System.out.println("\n\t\t¿Qué reporte desea consultar? (Ingrese el nombre del cliente)");
						nombre = entrada.nextLine();
						if(lista.estado(nombre) == false) {
							 System.out.println(mensajeReporte());
						}
						break;
						
					case 3:
						System.out.println("\t\tLOG IN");
						System.out.println("\n\t\t1. Supervisor \n\n\t\t2. Técnico \n\n\t\t3. Mostrador");
						sistemaInterno();
						break;
						
					case 4:
						System.out.println("\t\t––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
						System.out.println("\t\t\t\t\tReporte total de Incidencias");
						System.out.println("\t\t––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
						lista.verLista();
						break;
						
					case 5:
						System.out.println("\t\t––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
						System.out.println("\t\t\t\t\tIncidencias Finalizadas o Cerradas");
						System.out.println("\t\t––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
						lista.verListaCerrada();
						break;

					case 6:
						System.out.println("\n\t\t\t\tHasta Pronto ✌️");
						System.out.println();
						System.exit(0);
						break;
						
					default:
						System.out.println(mensajeOpcion());
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("\n\t\tIntroduzca alguna de las opciones por favor 😉 ");
				opcion = 0;
			}
			
		} while (opcion != 6);
	}
	
	/*  Function: sistemaInterno
	 *  @return: void
	 *  @params: 
	 *  Crea un switch para que el supervielr elija la acción a realizar con las insidencias
	 */
	public void sistemaInterno() {
				Scanner entrada = new Scanner (System.in);
				try {
          System.out.println("\t\t––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
					opcion = entrada.nextInt();
					switch (opcion) {
						case 1:  
							System.out.println("\t\t\t\t\t\t" + user[opcion-1]);
              mostrarMenuInterno();
              lista.listaAsignada(opcion);
							menuUsuario();
							break;

						case 2: 
							System.out.println("\t\t\t\t\t\t" + user[opcion-1]);
              mostrarMenuInterno();
              lista.listaAsignada(opcion);
							menuUsuario();
							break;

						case 3:
							System.out.println("\t\t\t\t\t\t" + user[opcion-1]);
              mostrarMenuInterno();
              lista.listaAsignada(opcion);
							menuUsuario();
							break;

            default:
						  System.out.println(mensajeOpcion());
						  break; 
					}
				} catch (InputMismatchException e) {
					System.out.println("\n\t\tIntroduzca alguna de las opciones por favor 😉 ");
					opcion = 0;
				}
			opciones();
		
	}

	/* Function: menuUsuario
   * @return: 
	 * @params:
	 * Permite al usuario ver o resolver/trabajar con alguna incidencia del cliente
	*/
	public void menuUsuario() {
		Scanner entrada = new Scanner (System.in);
		try {
			opcion = entrada.nextInt();
      entrada.nextLine();
			switch (opcion) {
				case 1:  
					lista.verListaAsignada();
					break;

				case 2:
          System.out.println("\n\t\t¿Qué reporte desea consultar? (Ingrese el nombre del cliente)");
          nombre = entrada.nextLine();
          if(lista.verIncidencia(nombre) == false) {
             System.out.println(mensajeReporte());
          }
          System.out.println("\n\t\t-- Enter para continuar --");
          entrada.nextLine();
          break;

				case 3:
					System.out.println("\n\t\t¿Qué reporte desea consultar? (Ingrese el nombre del cliente)");
          nombre = entrada.nextLine();
          if(lista.resolverIncidencia(nombre) == false) {
            System.out.println(mensajeReporte());
          }
          System.out.println("\n\t\t-- Enter para continuar --");
          entrada.nextLine();
          break;

        default:
          System.out.println(mensajeOpcion());
          break;
			}
		} catch (InputMismatchException e) {
			System.out.println("\n\t\tIntroduzca alguna de las opciones por favor 😉 ");
			opcion = 0;
		}
		opciones();
	}

  /* Function: mostrarMenuInterno
    * @return: 
    * @params:
    * Imprime opciones del menu interno del sistema
    */
  public void mostrarMenuInterno(){
    System.out.println("\t\t––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
    System.out.println("\n\t\tBuen día, ¿Qué desea hacer?");
    System.out.println("\n\t\t1. Ver lista asignada \n\n\t\t2. Ver Reporte \n\n\t\t3. Resolver Incidencia");
  }

  /* Function: mensajeOpcion
    * @return: String
    * @params:
    * Regresa el mensaje a imprimir cuando una opción seleccionada no se encuentra disponible
    */
  public String mensajeOpcion() {
    return "\n\t\t\t\tElige una opción posible por favor";
  }

  /* Function: mensajeReporte
    * @return: String
    * @params:
    * Regresa el mensaje a imprimir cuando hay un reporte de un cliente seleccionado, pero este no existe aún
    */
  public String mensajeReporte() {
    return "\n\t\tNo existe ningún reporte bajo ese nombre";
  }


}
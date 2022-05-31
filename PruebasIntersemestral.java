import junit.framework.TestCase;

public class PruebasIntersemestral extends TestCase{
	ListaReportes lista = new ListaReportes();
	GenerarReporte nuevo = new GenerarReporte();
	
   /* Function: test_nuevaIncidencia
	 *  @return: void
	 *  @params: 
	 *  Comprueba que el sistema pueda agregar un nuevo reporte correctamente
	 */
	public void test_nuevaIncidencia() {
		assertTrue(lista.agregar(new Reporte(9362842,"Juliana","23/10/2020","El sistema de la planta 1 está caído",1,"abierto",1)));
	}

   /* Function: test_verEstado
	 *  @return: void
	 *  @params: 
	 *  Comprueba que el sistema pueda retornar el estado de un reporte a partir del nombre del cliente
	 */
	public void test_verEstado() {
		lista.agregar(new Reporte(9242324,"Juan","12/03/2020","No prende mi computadora",4,"abierto",2));
		lista.agregar(new Reporte(8365927,"Maria","24/12/2020","Mi correo no abre",5,"abierto",2));
		lista.agregar(new Reporte(3759374,"Jorge","03/06/2020","No puedo ingresar a la plataforma",3,"abierto",2));
		assertTrue(lista.estado("Juan"));	
	}
	
  /* Function: test_listaVacia
	 *  @return: void
	 *  @params: 
	 *  Comprueba que el sistema indique si una lista de reportes cerrados este vacía 
	 */
	public void test_listaVacia() {
		assertFalse(lista.verListaCerrada());
	}
	
  /* Function: test_listaAsignada
	 *  @return: void
	 *  @params: 
	 *  Comprueba que el sistema asigne correctamente los valores de la lista del usuario especificado dependiendo de los reportes registrados que tenga
	 */
	public void test_listaAsignada() {
		assertFalse(lista.listaAsignada(3));	
	}
  
	
}
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;

public class GenerarReporte {
	public int nomina, clasificacion, usuario;
	public String nombre, descripcion, status, nominaS, fecha;

	/*  Function: registrar
	 *  @return:  void
	 *  @params: listaReportes registro
	 *  Permite al usuario generar una nueva incidencia desde cero
	 */
	public void registrar(ListaReportes registro) {
		Scanner entrada = new Scanner (System.in); 
    int count;
    do {
      try {
        nomina = 0;
        System.out.println("\n\t\t\t\tIntroduce tu nómina (7 dígitos)\n");
        nomina = entrada.nextInt();
      } catch(InputMismatchException e){
          System.out.println("\n\t\t\t\tIngresa una nómina aceptable \n");
          nomina = 0;
          entrada.next();
      }
      nominaS = "" + nomina;
      if(nominaS.length() != 7){
        System.out.println("\n\t\t\t\tDebe tener 7 dígitos \n");
        nomina = 0;
      }

    } while (nomina <= 0);
  
			System.out.println("\n\t\t\t\tIntroduce tu nombre \n");
			nombre = entrada.next();

      String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
      Pattern pattern;
      Matcher matcher;
    do{
			System.out.println("\n\t\t\t\tIntroduce la fecha (dd/mm/aaaa) \n");
			fecha = entrada.next();

       pattern = Pattern.compile(regex);
       matcher = pattern.matcher(fecha);
       if(!matcher.matches()){
         fecha = "";
       }
      
    }while(fecha == "");
			System.out.println("\n\t\t\t\tDescribe tu problema \n");
      Scanner entradaD = new Scanner(System.in);
			descripcion = entradaD.nextLine();
      
			do {
				System.out.println("\n\t\t\t\tIntroduce la urgencia (1-crítico, 2-alto, 3-medio, 4-bajo, 5-muy bajo) \n");
				try {
					clasificacion = entrada.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("\n\t\t\t\tPor favor introduce un número");
					entrada.next();
				}
			}while (validar() != true);
		
		status = "abierto";
    if(clasificacion == 1 || clasificacion == 2){
      usuario = 1;
    }
    else if(clasificacion == 4 || clasificacion == 5){
      usuario = 2;
    } 
    else{
      usuario = registro.asignar(clasificacion);
    }
  
		Reporte incidencia = new Reporte(nomina, nombre, fecha, descripcion, clasificacion, status, usuario);
		registro.agregar(incidencia);

	}
	
	/*  Function: validar
	 *  @return:  boolean
	 *  @params: 
	 *  verifica que los valores ingresados sean válidos
	 */
	public boolean validar() {
		if (clasificacion > 5 || clasificacion < 1) {
			System.out.println("\n\t\tPor favor ingresa una clasificacion aceptable");
			return false;
		}
		else {
			return true;
		}
	}


}

import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
	
	/* Function: main 
	 * @return: void 
	 * @params: 
	 * Se encarga de correr el programa 
	*/
	public static void main(String[] args) {
		Scanner name = new Scanner (System.in);
		String nombre;
		System.out.println("\t\t\t\t\t\tIntroduce tu nombre");
		nombre = name.next();
		System.out.println();
		System.out.println("\t\tHola " + nombre + " 🤗  bienvenid@ a tu sistema de Incidencias");
		System.out.println();
		System.out.println("\t\t⭐️ ⭐ ⭐ ⭐ ⭐ ⭐ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐️ ⭐ ⭐️");
		newMenu();
	}
	
	/*  Function: newMenu
	 *  @return: void
	 *  @params: 
	 *  Se encarga de dirigir al usuario al menú principal
	 */
	public static void newMenu() {
		Menu menu = new Menu();
		try {
			menu.opciones();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
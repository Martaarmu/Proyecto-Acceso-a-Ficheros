package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilities {
	
	private static Scanner keyboard = new Scanner(System.in);
	/**
	 * Metodo para recoger un entero 
	 * @return entero
	 */
	
	public static int getInt() {
        int result = 0;
        boolean valid = false;
        do {
            try {
                result = Integer.parseInt(keyboard.nextLine());
                valid = true;

            } catch (IllegalStateException ex) {
                keyboard = new Scanner(System.in);
                System.out.println("Error in keyboard. Please, try it again: ");
            } catch (NumberFormatException ex) {
                System.out.println("Error reading integer type. Please, try it again: ");
            }catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }
	/**
	 * Metodo para recoger una cadena de caracteres
	 * @return string
	 */
	
	public static String getString() {
        String result = "";
        boolean valid = false;
        do {
            try {
                result = keyboard.nextLine();
                valid = true;

            } catch (Exception ex) {
                System.out.println("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }
	
	/**
	 * Metodo para recoger un dni cumpliendo una expresion
	 * @return string
	 */
	public static String getDNI() {
		String dni = "";
		boolean valid=false;
		System.out.println("DNI");
		 do {
	            try {
	            	dni=getString();
	            	if(dni.matches("[0-9]{8}[A-Z]")) {
	            		valid = true;
	        		}else {
	        			valid = false;
	        			System.out.println("Debe tener 8 digitos y un caracter mayuscula");
	        		}  
	            } catch (Exception ex) {
	                System.out.println("Error unknown. Please, try it again: ");
	            }
	        } while (!valid);
		return dni;
	}
	
}

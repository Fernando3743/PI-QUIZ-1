
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

/**
 *Clase que representa la empresa Rica empanada
 * @autor 
 * @date 
 */

public class Empresa {

    /**
     * Variables de la clase Empresa
     */
    ArrayList<Trabajador> arregloTrabajadores;
    
    
  
    
   /**
    * Constructor de la clase Empresa, donde se le da valor inicial a las variables de la clase
    */
   public Empresa()
   {
       arregloTrabajadores = new ArrayList<>();
   }
   
   /**
    * Método ingresar trabajador, donde se pide el ingreso de todos los daatos de un trabajador y se adicionan al 
    * arreglo de trabajadores de la empresa
    * @param nombre
    * @param cc
    * @param cargo
    * @param salario
    * @param aVinculacion
    * @param mVinculacion
    * @param dVinculacion
    * @return 
    */
   public String ingresarTrabajadores(String nombre, String cc, String cargo, double salario, int aVinculacion, int mVinculacion, int dVinculacion)
   {
       
       arregloTrabajadores.add(new Trabajador(nombre, cc, cargo, salario, aVinculacion, mVinculacion, dVinculacion));
       
       return "Trabajador " + nombre + "( " + cc + " ) ingresado con exito";       
   }
   
   /**
    * Metodo que determina cuales trabajadores llevan n años trabajando en la empresa
    * @param cantAno
    * @return 
    */
   public String listarTrabajadoresnAnos(int cantAno)
   {
       int ano_actual = LocalDate.now().getYear();
       
       return arregloTrabajadores.stream()
                           .filter(e -> (ano_actual - e.getaVinculacion()) == cantAno)
                           .map(e -> e.getNombre() + " - " + e.getaVinculacion())
                           .reduce("Empleados con " + cantAno + " años \n", (acc, s) -> acc + s + "\n");
   }
   
   
   public String listarAntiguedadTrabajadores()
   {
       
       LocalDate fecha_actual = LocalDate.now();
       
       return arregloTrabajadores.stream()
                           .map(e -> {
                               
                           LocalDate fecha_de_vinculacion = LocalDate.of(e.getaVinculacion(), e.getMesVinculacion(), e.getDiaVinculacion());
                           
                           Period periodo = Period.between(fecha_de_vinculacion,fecha_actual);
                           
                           return String.format("El empleado %s, con fecha de vinculacion %s, lleva trabajando para la empresa %s años, %s meses y %s dias", 
                                   e.getNombre(), e.getFechaVinculacion(), periodo.getYears(), periodo.getMonths(), periodo.getDays());
                           
                           })
                           .reduce("Empleados de la empresa: \n", (acc, s) -> acc + s + "\n");
   }
   
  
   
     
     
}

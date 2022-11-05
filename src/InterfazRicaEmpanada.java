
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 
 */
public class InterfazRicaEmpanada extends JFrame{

    JPanel pIngresar, pBusqueda, pAdd, pDatBuscar, pPalMos, pBoton, pDatos;
    JLabel lNombre, lSalario, lImagen, lCc, lCargo, lAVinc,lmVinc,ldVinc;
    JButton bIngresar;
    JTextField tfNombre, tfCargo,tfBuscarAnho , tfCC, tfAVinc, tfSal,tfmVinc,tfdVinc;
    JTextArea area;
    JScrollPane barras; 
    JComboBox<String> cbBuscar;
    Container contenedor;

    public InterfazRicaEmpanada() {
        
        super("Rica empanada");
        
        pIngresar = new JPanel();
        pDatos = new JPanel();
        pBusqueda = new JPanel();
        pAdd = new JPanel();
        pDatBuscar = new JPanel();
        pPalMos = new JPanel();
        pBoton = new JPanel();
                                             
        bIngresar = new JButton(" Ingresar Trabajador ");
        
        lNombre = new JLabel("Nombre: ");        
        lSalario = new JLabel("Salario: ");
        lCargo = new JLabel("Cargo: ");
        lCc = new JLabel("CC: ");
        lAVinc = new JLabel("Año vinculación: ");
        lmVinc = new JLabel("mes vinculación: ");
        ldVinc = new JLabel("dia vinculación: ");
        lImagen = new JLabel(new ImageIcon(getClass().getResource("imagenes/empan.jpg")));
        
        tfNombre = new JTextField();
        tfCC = new JTextField();
        tfCargo = new JTextField();
        tfSal = new JTextField();
        tfAVinc = new JTextField();
        tfmVinc = new JTextField();
        tfdVinc = new JTextField();
        tfBuscarAnho = new JTextField("Ingrese año a buscar");
        tfBuscarAnho.setForeground(Color.GRAY);
        
        area = new JTextArea();
        barras = new JScrollPane(area);
        
        pBusqueda.setBackground(Color.WHITE);
        pDatBuscar.setBackground(Color.WHITE);
        bIngresar.setBackground(Color.WHITE);
        bIngresar.setIcon(new ImageIcon(getClass().getResource("imagenes/adic.png")));
                
        cbBuscar = new JComboBox<>();
        cbBuscar.addItem("Seleccione una opción");
        cbBuscar.addItem("Listar trabajadores con n años");
        cbBuscar.addItem("Listar antiguedad trabajadores");
        
        pAdd.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE,3),"Datos del Trabajador"));
        pDatBuscar. setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE,2),"Busquedas"));
        pBusqueda. setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE,3),""));
        
        
        pDatos.setLayout(new GridLayout(2,8, 10, 0));
        pDatos.setBackground(Color.WHITE);
        
        pAdd.setBackground(Color.WHITE);
        pBoton.setBackground(Color.WHITE);
        pDatos.add(lNombre);pDatos.add(tfNombre);pDatos.add(lCc);pDatos.add(tfCC);
        pDatos.add(lCargo);pDatos.add(tfCargo);pDatos.add(lSalario);pDatos.add(tfSal);
        pDatos.add(lAVinc);pDatos.add(tfAVinc);pDatos.add(lmVinc);pDatos.add(tfmVinc);pDatos.add(ldVinc);pDatos.add(tfdVinc);
        pDatos.add(new JLabel());pDatos.add(new JLabel());
        pBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
        pBoton.add(bIngresar); pBoton.add(new JLabel());
        pAdd.setLayout(new BorderLayout());
        pAdd.add(pDatos, BorderLayout.NORTH); pAdd.add(pBoton, BorderLayout.SOUTH);
        
       
        pPalMos.setBackground(Color.WHITE);
        pPalMos.setLayout(new BorderLayout());
        
                      
        pPalMos.add(pBusqueda,BorderLayout.CENTER );
        pPalMos.add(lImagen, BorderLayout.WEST);
        
        pIngresar.setLayout(new BorderLayout());
        pIngresar.add(pAdd, BorderLayout.NORTH);
        pIngresar.add(pPalMos, BorderLayout.CENTER);
        
        pDatBuscar.setLayout(new GridLayout(1,2,10,0));     
        pDatBuscar.add(tfBuscarAnho); pDatBuscar.add(cbBuscar);
        
        
        pBusqueda.setLayout(new BorderLayout());
        pBusqueda.add(pDatBuscar, BorderLayout.NORTH);
        pBusqueda.add(barras, BorderLayout.CENTER);
        
        contenedor = getContentPane();
        contenedor.add(pIngresar);
                
        setSize(720, 340);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //eventos
        ManejaEventos eventos = new ManejaEventos();
        bIngresar.addActionListener(eventos);
        cbBuscar.addItemListener(eventos);
        
        
    }
    
    public void limpiarCamposEmpleado() {
        
        tfNombre.setText("");
        tfCargo.setText("");
        tfBuscarAnho.setText(""); 
        tfCC.setText("");
        tfAVinc.setText("");
        tfSal.setText("");
        tfmVinc.setText("");
        tfdVinc.setText("");
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InterfazRicaEmpanada app = new InterfazRicaEmpanada();
    }

class ManejaEventos implements ActionListener, ItemListener{

    Empresa emp;

        public ManejaEventos() {
            emp =  new Empresa();
        }
    
        
    
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getSource() == bIngresar) {
                String nombre = tfNombre.getText();
                String cc = tfCC.getText();
                String cargo = tfCargo.getText();
                
                if(nombre.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Nombre invalido, no puede ser vacio");
                    tfNombre.setText("");
                    return;
                }
                
                if(cc.isBlank()) {
                    JOptionPane.showMessageDialog(null, "CC invalido, no puede ser vacio");
                    tfCC.setText("");
                    return;
                }
                
                if(cargo.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Cargo invalido, no puede ser vacio");
                    tfCargo.setText("");
                    return;
                }
                
                double salario = -1;
                
                try {
                    salario = Double.parseDouble(tfSal.getText());
                    if(salario <= 0) {
                        JOptionPane.showMessageDialog(null, "Salario invalido, debe ser mayor que 0.");
                        tfSal.setText("");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Salario invalido, debe ser un numero.");
                    tfSal.setText("");
                    return;
                }
                
                int anoVinculacion = -1;
                
                try {
                    anoVinculacion = Integer.parseInt(tfAVinc.getText());
    
                    if(anoVinculacion > 2020 || anoVinculacion < 1940){
                        JOptionPane.showMessageDialog(null, "Año de vinculacion invalido, debe ser entre 1940 y 2020");
                        tfAVinc.setText("");
                        return;
                    }
     
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Año de vinculacion invalido, debe ser un numero.");
                    tfAVinc.setText("");
                    return;
                }
                
                int mesVinculacion = -1;
                
                try {
                    mesVinculacion = Integer.parseInt(tfmVinc.getText());
                    if(mesVinculacion <= 0) {
                        JOptionPane.showMessageDialog(null, "Mes de vinculacion invalido, debe ser mayor que 0.");
                        tfmVinc.setText("");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Mes de vinculacion invalido, debe ser un numero.");
                    tfmVinc.setText("");
                    return;
                }
                
                int diaVinculacion = -1;
                
                try {
                    diaVinculacion = Integer.parseInt(tfdVinc.getText());
                    if(diaVinculacion <= 0) {
                        JOptionPane.showMessageDialog(null, "Dia de vinculacion invalido, debe ser mayor que 0.");
                        tfdVinc.setText("");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Dia de vinculacion invalido, debe ser un numero.");
                    tfdVinc.setText("");
                    return;
                }
                
                String msg = emp.ingresarTrabajadores(nombre, cc, cargo, salario, anoVinculacion, mesVinculacion, diaVinculacion);
                area.setText(msg);
                limpiarCamposEmpleado();
                
            }
            
                
        }
            

        @Override
        public void itemStateChanged(ItemEvent ie) {
            
            if(ie.getStateChange() == ItemEvent.SELECTED){
                if(cbBuscar.getSelectedItem().toString().equals("Listar trabajadores con n años")) {
                    int anos = -1;
                    try {
                        anos = Integer.parseInt(tfBuscarAnho.getText());
                        
                        if(anos <= 0) {
                            JOptionPane.showMessageDialog(null, "Año invalido, debe ser mayor a 0.");
                            tfBuscarAnho.setText("");
                            return;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Año invalido.");
                        tfBuscarAnho.setText("");
                        return;
                    }
                    
                    String res = emp.listarTrabajadoresnAnos(anos);
                    area.setText(res);
                    
                }
                
                if(cbBuscar.getSelectedItem().toString().equals("Listar antiguedad trabajadores")) {
                    String res = emp.listarAntiguedadTrabajadores();
                    area.setText(res);
                    
                }
            }
            
           
        }

        
    
}
}

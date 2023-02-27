package proceso_aplicacion;
import javax.swing.JOptionPane;

import conversiones.conversor_temperatura;
import conversiones.conversor_moneda.conversor_moneda;
import javax.swing.ImageIcon;


public class desarrollo {
	
	public   void iniciar()  {
	
	
		
		
		Object [] opciones ={"Conversor de Moneda","Conversor de Temperatura"}; 
		Object opcion_elegir = JOptionPane.showInputDialog(null,"Seleccione un opción de conversión", "Menú",JOptionPane.QUESTION_MESSAGE,new ImageIcon("src/img/icon2.png"),opciones, opciones[0]);
		String opcion_elegida =(String)opcion_elegir;
		
	
		if (opcion_elegida!=null) {
			
			switch (opcion_elegida){
			
			case "Conversor de Moneda" :
				
				conversor_moneda conversorMoneda = new conversor_moneda();
				conversorMoneda.obtener_datos();
				break;
				
				
			
			case  "Conversor de Temperatura":
				
				conversor_temperatura conversorTemperatura = new conversor_temperatura();
				conversorTemperatura.obtener_datos();
				break;
			
			default:
				break;
                               
		    }
			
		}
		
	       
	}
		
		
}


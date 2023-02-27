package conversiones.conversor_moneda;
import proceso_aplicacion.desarrollo;
import proceso_aplicacion.mensaje_final;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class  conversor_moneda {
	
	public void obtener_datos() {
		
	
		
		Object [] opciones_moneda={"De Pesos(MX) a Dolar","De Pesos (COP) a Dólar","De Pesos (COP) a Euro","De pesos (COP) a pesos (MX)","De Dolar a Pesos(COP)"}; 
		Object opciones_elegir_moneda = JOptionPane.showInputDialog(null,"Seleccione un opción de conversión", "Menu",JOptionPane.QUESTION_MESSAGE,new ImageIcon("src/img/icon3.png"),opciones_moneda, opciones_moneda[0]);
		System.out.println(opciones_elegir_moneda);
		String opcionMoneda_elegida= (String)opciones_elegir_moneda;
		
		
		if (opciones_elegir_moneda==null) {
			mensaje_final mensaje_final= new mensaje_final();
			mensaje_final.mensaje_final();
			System.exit(0);
		}
		
	
		try {
                String opcion_cantidad_dinero=JOptionPane.showInputDialog("Ingrese la cantidad de dinero que desea convertir \n Opción escogida: "+ opcionMoneda_elegida);
			
		
			conversor_moneda operacion= new conversor_moneda();
			operacion.resultado_conversion(opcionMoneda_elegida, opcion_cantidad_dinero);
		}
		
		catch(NumberFormatException | NullPointerException exception) {
			JOptionPane.showMessageDialog(null,"Valor no valido","Error",JOptionPane.ERROR_MESSAGE);
			desarrollo intentar_de_nuevo= new desarrollo();
			intentar_de_nuevo.iniciar();

			
			
		}
		
		
		
		
	}
	
	public void resultado_conversion(String tipoConvercion, String cantidaDinero) {
		
		String datos_api[];
		datos_api= new String[4];
		
		String pasar_De="",pasar_a = "";
	
		switch (tipoConvercion) {
			case "De Pesos(MX) a Dolar":
				pasar_De="MXN";
				pasar_a="USD";
				break;
				
			case "De Pesos (COP) a Dólar":
				pasar_De="COP";
				pasar_a="USD";
				break;
				
			case "De Pesos (COP) a Euro":
				pasar_De="COP";
				pasar_a="EUR";
				break;
				
			case "De pesos (COP) a pesos (MX)":
				pasar_De="COP";
				pasar_a="MXN";
				break;
				
			case "De Dolar a Pesos(COP)":
				pasar_De="USD";
				pasar_a="COP";
				break;
				
			case "De Dolar a Euro":
				pasar_De="USD";
				pasar_a="EUR";
				break;
					
			case "De Pesos(MX) a Pesos(COP)":
				pasar_De="MXN";
				pasar_a="COP";
				break;
				
			case "De Euro a Pesos(COP)" : 
				pasar_De="EUR";
				pasar_a="COP";	
				break;
				
			case "Otros valores":
				conversor_moneda operacion= new conversor_moneda();
	
			
			default:
				break;
				
		}
		
		
		
		
		LocalDate actualDate =LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String fecha_formateada = actualDate.format(formatter);
		
		
		
		datos_api[0]= fecha_formateada; 
		datos_api[1]=cantidaDinero;
		datos_api[2]=pasar_De;
		datos_api[3]=pasar_a;
		
		
		API_Conversor respuesta = new API_Conversor();
		double valor_convertido=respuesta.get(datos_api[0],datos_api[1],datos_api[2],datos_api[3]);
		
		
		
		double valor_formateado=0;
		
		valor_formateado=Math.round((valor_convertido*100.0)/100.0);
		
		
		
		JOptionPane.showMessageDialog(null,"El valor de la conversión  "+ tipoConvercion+ " es : $"+ valor_formateado);
		
		
		
		mensaje_final mensaje_final= new mensaje_final();
		mensaje_final.mensaje_final();
		
		
		
	}
	
	
	
	
}



import java.io.PrintStream;
public class Generator{

	//Clase anidada para el control del if/else
	public static class Label{

        	private String trueLabel;
        	private String falseLabel;

        	public Label(String trueL, String falseL){
                	this.trueLabel = trueL;
                	this.falseLabel = falseL;
       		}

        	public String getTLabel(){
                	return this.trueLabel;
        	}

        	public String getFLabel(){
                	return this.falseLabel;
        	}

		public void setTLabel(String tLabel){
			this.trueLabel = tLabel;
		}
	
		public void setFLabel(String fLabel){
			this.falseLabel = fLabel;
		}
	}
	public static final int EQ = 1;
	public static final int NEQ = 2;
	public static final int MAY = 3;
	public static final int MAOI = 4;
	public static final int MEN = 5;
	public static final int MEOI = 6;

	public static PrintStream out = PLC.out;

	private static int tempCont = 0;
	private static int labelCont = 0;


	private static String getTemp(){
		return "temp" + tempCont++;
	}

	public static String getLabel(){
		return "Label" + labelCont++;
	}


	public static void gotos(String label){

		out.println("	goto " + label + ";");
	}
	
	public static String arithmetic(String op){
		String tmp = getTemp();
		out.println("	" + tmp + " = " + op + ";");
		return tmp;
	}

	public static String asig(String id,String exp){
		out.println("	" + id + "=" + exp + ";");
		return id;

	}

	public static void label(String label){
		out.println(label + ":");
	}


	public static Label condicion(int caso,String e1,String e2){
		
		String ifLabel = getLabel();
		String elseLabel = getLabel();
		String condicion = "";
		switch (caso){
		
			case EQ:
				condicion = "	if (" + e1 + " == " + e2 + ") goto " + ifLabel + ";\n	goto " + elseLabel + ";" ;		
				break;
			case NEQ:
				condicion = "	if (" + e1 + " == " + e2 + ") goto " + elseLabel + ";\n	goto " + ifLabel + ";" ;		
				break;
			case MEN:
				condicion = "	if (" + e1 + " < " + e2 + ") goto " + ifLabel + ";\n	goto " + elseLabel + ";";		
				break;
			case MEOI:
				condicion = "	if (" + e2 + " < " + e1 + ") goto " + elseLabel + ";\n	goto " + ifLabel + ";";		
				break;
			case MAY:
				condicion = "	if (" + e1 + " < " + e2 + ") goto " + elseLabel + ";\n	goto " + ifLabel + ";";		
				break;
			case MAOI:
				condicion = "	if (" + e1 + " < " + e2 + ") goto " + elseLabel + ";\n	goto " + ifLabel + ";";		
				break;
			
		};


		out.println(condicion);
		
		return new Label(ifLabel,elseLabel) ;

	}

	public static void print(String e){

		out.println("	print " + e + ";");	
	}
}

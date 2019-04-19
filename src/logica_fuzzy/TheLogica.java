package logica_fuzzy;

public class TheLogica {

	//Declaração das variavéis
	private double pressaoFreioAlta;
	private double pressaoFreioMedia;
	private double pressaoFreioBaixa;
	
	private double velocidadeCarroAlta;
	private double velocidadeCarroMedia;
	private double velocidadeCarroBaixa;
	
	private double velocidadeRodaAlta; 
	private double velocidadeRodaMedia;
	private double velocidadeRodaBaixa;
	
	//Vairaveis auxiliares para aplicar nas regras
	//requeridas na questão
	private double menor = Double.MAX_VALUE;
	private double menor2 = Double.MAX_VALUE;
	
	//Construtor da classe e função principal
	public TheLogica(double pressaoFreio,double velocidadeCarro,double velocidadeRoda) {
		
		//Aplicação da lógica fuzzy para pressão freio
		if (pressaoFreio >= 50) pressaoFreioAlta = (pressaoFreio/50)-1;
		else pressaoFreioAlta = 0;
		
		if(pressaoFreio <= 50) pressaoFreioBaixa = (-pressaoFreio/50)+1;
		else pressaoFreioBaixa = 0;
	
		if(pressaoFreio >=30 && pressaoFreio <=50) pressaoFreioMedia = (pressaoFreio-30)/20;
		else if(pressaoFreio > 50 && pressaoFreio<=70) pressaoFreioMedia = (-pressaoFreio+70)/20;
		else pressaoFreioMedia = 0;
		

		//Aplicação da lógica fuzzy para velocidade do carro 
		if(velocidadeCarro >= 40) velocidadeCarroAlta = (velocidadeCarro-40)/60;
		else velocidadeCarroAlta = 0;
		
		if (velocidadeCarro<=60) velocidadeCarroBaixa = (-velocidadeCarro/60)+1;
		else velocidadeCarroBaixa = 0;
		
		if (velocidadeCarro >=20 && velocidadeCarro <=50) velocidadeCarroMedia = (velocidadeCarro -20)/30;
		else if(velocidadeCarro>50 && velocidadeCarro<=80) velocidadeCarroMedia = (-velocidadeCarro+80)/30;
		else velocidadeCarroMedia = 0;

		//Aplicação da lógica fuzzy para velocidade da roda
		if(velocidadeRoda >= 40) velocidadeRodaAlta = (velocidadeRoda-40)/60;
		else velocidadeRodaAlta = 0;
		
		if (velocidadeRoda<=60) velocidadeRodaBaixa = (-velocidadeRoda/60)+1;
		else velocidadeRodaBaixa = 0;
		
		if (velocidadeRoda >=20 && velocidadeRoda <=50) velocidadeRodaMedia = (velocidadeRoda -20)/30;
		else if(velocidadeRoda>50 && velocidadeRoda<=80) velocidadeRodaMedia = (-velocidadeRoda+80)/30;
		else velocidadeRodaMedia = 0;

		
		//Exibição de todas as pertinências de cada variável
		System.out.println("Fuzzy pressão no freio alta: "+pressaoFreioAlta);
		System.out.println("Fuzzy pressão no freio média: "+pressaoFreioMedia);
		System.out.println("Fuzzy pressão no freio baixa: "+pressaoFreioBaixa);
		
		System.out.println("Fuzzy velocidade do carro alta: "+velocidadeCarroAlta);
		System.out.println("Fuzzy velocidade do carro média: "+velocidadeCarroMedia);
		System.out.println("Fuzzy velocidade do carro baixa: "+velocidadeCarroBaixa);
		
		System.out.println("Fuzzy velocidade da roda alta: "+velocidadeRodaAlta);
		System.out.println("Fuzzy velocidade da roda média: "+velocidadeRodaMedia);
		System.out.println("Fuzzy velocidade da roda baixa: "+velocidadeRodaBaixa);		
		
		//Aplicação da regra 1 e 2
		double[] altos = new double[3];
		altos[0] = pressaoFreioAlta;
		altos[1] = velocidadeCarroAlta;
		altos[2] = velocidadeRodaAlta;
		for(int i = 0; i < altos.length; i++) {
			menor = Math.min(menor, altos[i]);
		}
		double apertarFreio = pressaoFreioMedia + menor;
		System.out.println("Deve apertar "+apertarFreio+" de freio");

		//Aplicação da regra 3 e 4
		double[] baixos = new double[3];
		baixos[0] = pressaoFreioAlta;
		baixos[1] = velocidadeCarroAlta;
		baixos[2] = velocidadeRodaBaixa;
		for(int i = 0; i < baixos.length; i++) {
			menor2 = Math.min(menor2, baixos[i]);
		}
		double soltarFreio = pressaoFreioBaixa + menor2;
		System.out.println("Deve soltar "+soltarFreio+" de freio");
		
		//Ciclo while para enocontrar o centróide
		int i = 5;
		double num = 0;
		double dem = 0;
		while(i<=100) {
			int b = i/100;
			if(b<soltarFreio) {
				num = num+(i*soltarFreio);
				dem = dem + soltarFreio;
			}else if(b>apertarFreio){
				num = num + (i*apertarFreio);
				dem = dem + apertarFreio;
			}else {
				num = num + (i*b);
				dem = dem + b;
			}
			
			i+=5;
		}
		
		double centroide = num/dem;
		System.out.println("Centróide: "+centroide);
		
	}
	
	
	
}

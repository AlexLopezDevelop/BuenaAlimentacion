import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BuenaAlimentacion {
	public static void main(String[] args) {
		try {
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			
			int opcion = 0;
			int muchasCalorias = 0;
			int pocasCalorias = 0;
			double mediaCalorias = 0;
			int mediaFrutaVerdura = 0;
			int minFrutaVerdura = Integer.MAX_VALUE;
			int maxFrutaVerdura = Integer.MIN_VALUE;
			int posmax = 0;
			int posmin = 0;
			int superaSal =0;
			int contar5frutas = 0;
			int calorias3000 = 0;
			int negativo = 0 ;
			
			ArrayList<String> dias = new ArrayList<String>();
			ArrayList<Integer> CantidadFrutaVerdura= new ArrayList<Integer>();
			ArrayList<Double> CaloriasConsumidas= new ArrayList<Double>();
			ArrayList<Double> CucharadasSal= new ArrayList<Double>();
			
			dias.add("Lunes");
			dias.add("Martes");
			dias.add("Miercoles");
			dias.add("Jueves");
			dias.add("Viernes");
			dias.add("Sabado");
			dias.add("Domingo");
			
			
			while(opcion != 8){
				
				if(opcion>8 || opcion<0){
					System.out.println("Opcion no valida");
				}
				
				System.out.println("-------------Menu------------");
				System.out.println("[1]- Proposito comer mas fruta y verdura");
				System.out.println("[2]- Proposito consumir las calorias justas");
				System.out.println("[3]- Proposito de consumir poca sal");
				System.out.println("[4]- Calcular las calorias consumidas");
				System.out.println("[5]- Calcular media calorias semanal");
				System.out.println("[6]- Valorar consumo de fruta y verdura");
				System.out.println("[7]- Valoracion general");
				System.out.println("[8]- Salir");
				opcion = Integer.parseInt(buffer.readLine());

				switch(opcion){

				case 1:
					CantidadFrutaVerdura.clear();
					contar5frutas = 0;
					for(int i = 0; i < dias.size(); i++){
						System.out.println("Cantidad de fruta y verdura consumida el: " + dias.get(i));
						CantidadFrutaVerdura.add(Integer.parseInt(buffer.readLine()));
						
						if(CantidadFrutaVerdura.get(i)>=5){
							contar5frutas++;
						}
						
						mediaFrutaVerdura = mediaFrutaVerdura + CantidadFrutaVerdura.get(i);
						
						if(minFrutaVerdura<CantidadFrutaVerdura.get(i)){
							minFrutaVerdura = minFrutaVerdura + CantidadFrutaVerdura.get(i);
							posmin = i;
						}
						
						if(maxFrutaVerdura>CantidadFrutaVerdura.get(i)){
							maxFrutaVerdura = maxFrutaVerdura + CantidadFrutaVerdura.get(i);
							posmax = i;
						}
						
					}
					
					break;
					
				case 2:
					CaloriasConsumidas.clear();
					calorias3000 = 0;
					for(int i = 0; i < dias.size(); i++){
						System.out.println("Calorias consumidas el: " + dias.get(i));
						CaloriasConsumidas.add(Double.parseDouble(buffer.readLine()));
						if(CaloriasConsumidas.get(i)>3000){
							calorias3000++;
						}
					}
					
					break;
					
				case 3:
					CucharadasSal.clear();
					superaSal = 0;
					for(int i = 0; i < dias.size(); i++){
						System.out.println("Cucharadas de sal el: " + dias.get(i));
						CucharadasSal.add(Double.parseDouble(buffer.readLine()));
						if(CucharadasSal.get(i)<0.88){
							superaSal++;
						}
					}
					
					break;
					
				case 4:
					for(int i = 0; i < dias.size(); i++){
						if(5>(CucharadasSal.get(i)*4.5)){
							CaloriasConsumidas.set(i,CaloriasConsumidas.get(i)+(CaloriasConsumidas.get(i)*0.1));
						}
						
						if(5>=CantidadFrutaVerdura.get(i)){
							CaloriasConsumidas.set(i,CaloriasConsumidas.get(i)-(CaloriasConsumidas.get(i)*0.1));
						}
					}
					
					for(Double mostrar:CaloriasConsumidas){
						System.out.println(mostrar);
					}
					
					break;
					
				case 5:
					for(int i = 0; i < dias.size(); i++){
						mediaCalorias = mediaCalorias + CaloriasConsumidas.get(i);
						if(3000<CaloriasConsumidas.get(i)){
							muchasCalorias++;
						}
						if(1500>CaloriasConsumidas.get(i)){
							pocasCalorias++;
						}
					}
					
					System.out.println("Media de calorias consumidas al dia: "+(mediaCalorias/7));
					
					if(muchasCalorias>=2){
						System.out.println("Debes bajar el consumo de calorias");
					}
					
					if(pocasCalorias>=2){
						System.out.println("Deber aumentar el consumo de calorias");
					}
					break;
					
				case 6: 
					
					System.out.println("Media Fruta y Verdura consumida cada dia: "+ (mediaFrutaVerdura/7));
					System.out.println("EL "+ dias.get(posmax) +" es el dia que mas fruta y verdura has consumido: "+maxFrutaVerdura);
					System.out.println("EL "+ dias.get(posmin) +" es el dia que menos fruta y verdura has consumido: "+minFrutaVerdura);
					
					break;
					
				case 7:
					negativo=0;
					if(superaSal>0){
						System.out.println("Has superado 4 gramos consumidos");
						negativo++;
					}
					
					if(contar5frutas>=6){
						
					}else System.out.println("no has comido como minimo 5 piezas durante 6 dias"); negativo++;
					
					if(calorias3000>1){
						System.out.println("Has consumido mas de 3000 calorias en varios dias") ;
						negativo++;
					}
					
					if(negativo>=2){
						System.out.println("Muy bien has cumplido esta semana") ;
					}else System.out.println("La proxima hay que cumplir los objetivos!!");
					
					
					break;
				}
			}
			
			System.out.println("Hay que cumplir los objetivos");
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
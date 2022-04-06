import java.util.Scanner;

public class App{
  public static void menu(){
    System.out.println("\n\tCadastro dos Habitantes do pais SimCity");
    System.out.println("\t----------------------------------------\n");
    System.out.println("1. Inclui dados do habitante");
    System.out.println("2. Consulta dados do habitante");
    System.out.println("3. Inserir salario");
    System.out.println("4. Mostrar salario");
    System.out.println("5. Consulta os impostos do salario");
    System.out.println("0. Sair");
}

public static String[] inclui(){

    System.out.println("\tVocê entrou no método Cadastro \n");
    Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome do habitante: ");

        String[] dadosDoHabitante = new String[2];
        dadosDoHabitante[0] = leitor.nextLine();

        System.out.println("Digite a sua profissão:");
        dadosDoHabitante[1] = leitor.nextLine();

        return dadosDoHabitante;

}

public static void consulta(String[] dadosDoHabitante){
    System.out.println("\t Você entrou no método Consulta .\n");

    System.out.println("Nome do habitante é: " + dadosDoHabitante[0]);
    System.out.println("Profissão de habitante é: " + dadosDoHabitante[1]+"\n");
}

public static void mostrarSalario(double[] vetorSalario2){
    System.out.println("\t Você entrou no método mostrar salario. \n");

    for (int i = 0; i < vetorSalario2.length; i++) {

        System.out.print("O Salario do mês " +(i+1)+ " é : "+ vetorSalario2[i]+ "\n");
        
    }

}
public static void impostoSalario(double[]vetoresDosImpostos){
    System.out.println("Você entrou no método imposto do salário.\n");

    for (int i = 0; i < vetoresDosImpostos.length; i++) {

        System.out.print(" O salario do mês " + (i+1)+ " vai gerar de imposto:"+ vetoresDosImpostos[i]+"\n");
    }

}

public static double[] calculoDoImposto(double[] salariosDoMes) {

    double[] impostoDesseSalario = new double[salariosDoMes.length];

    for (int i = 0; i < salariosDoMes.length; i++) {

        if ( salariosDoMes[i] >= 0.00 && salariosDoMes[i] <= 2000.00) {
            impostoDesseSalario[i] = 0;
        } else if (salariosDoMes[i] >= 2001.00 && salariosDoMes[i] <= 3000.00) {
            impostoDesseSalario[i] = salariosDoMes[i] * 0.08;
        } else if (salariosDoMes[i] >= 2001.00 && salariosDoMes[i] <= 4500.00) {
            impostoDesseSalario[i] = salariosDoMes[i] * 0.18 ;
        } else {
            impostoDesseSalario[i] = salariosDoMes[i] * 0.28;
        }
    }
    return impostoDesseSalario;
}


public static void main(String[] args) {
    int opcao;
    double vetorSalario1[]= new double[12];
    Scanner entrada = new Scanner(System.in);

            String[] cadastraUsuario = new String[2];
    do{
        menu();
        opcao = entrada.nextInt();
        
        if (opcao == 1){

            cadastraUsuario=inclui();

        }

        else if  (opcao == 2){
            consulta(cadastraUsuario);
            
            
        }

        else if (opcao == 3){
            
            for(int i= 0;i< vetorSalario1.length;i++){

                System.out.print("Informe o "+(i+1)+" Salario do ano : ");
                vetorSalario1[i] = entrada.nextDouble();
                
            }
        }

        else if (opcao == 4){
            mostrarSalario(vetorSalario1);
            
        }

        else if (opcao == 5){

            double[] impostosCalculados = new double[vetorSalario1.length];
            impostosCalculados = calculoDoImposto(vetorSalario1);

            impostoSalario(impostosCalculados);
            
        }

        else {

            System.out.println("------FIM DO PROGRAMA------");

        }


    } while(opcao != 0);
}

      }

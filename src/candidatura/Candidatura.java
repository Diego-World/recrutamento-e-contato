package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Candidatura {

    public static void main(String[] args) {
        // selecaoCandidados();

        String[] candidatos={"Apollo", "Diana", "Pietro", "Diego", "Danielle"};

        for(String candidato:candidatos){
           entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas=1;
        boolean continuaTentando=true;
        boolean atendeu=false;
        do{
            atendeu=atender();
            continuaTentando=!atendeu;
            if(continuaTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Contato realizado");
            }
        }while(continuaTentando && tentativasRealizadas<3);

        if(atendeu) {
            System.out.println("Conseguimos contato com o "+candidato+" na tentativa "+tentativasRealizadas+"!");
        }else{
            System.out.println("Não Conseguimos contato com o "+candidato+" número maximo de tentativas alcançadas!");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void selecaoCandidados(){
        String[] candidatos={"Apollo", "Diana", "Pietro", "Diego", "Danielle", "Gabriel", "Cleiton", "Juliana", "Julia","Galvão"};
        int candidatosSelecionados = 0;
        int candidatosAtual=0;
        double salarioBase=2000.0;
        while(candidatosSelecionados<5 && candidatosAtual<candidatos.length){

            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = salarioPretendido();

            System.out.println("O candidato "+candidato+" Solicitou "+salarioPretendido+" de salário!");
            if(salarioBase>=salarioPretendido){
                System.out.println("O candidato "+candidato+" foi selecionado para a vaga!");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double salarioPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Estruturamento e entendimento da regra de negócio

//    static void analisarSalario(double salarioPretendido){
//        double salarioBase = 2000.00;
//        if(salarioBase>salarioPretendido){
//            System.out.println("LIGAR PARA CANDITADO!");
//        }else if(salarioBase==salarioPretendido){
//            System.out.println("LIGAR COM CONTRA PROPOSTA!");
//        }else{
//            System.out.println("AGUARDAR DEMAIS CANDITADOS!");
//        }
//    }


}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aprogp2;

/**
 *
 * @author Tiago Moura 
 */
import java.util.Scanner;

public class AprogP2 {
    static Scanner ler = new Scanner(System.in);//como está fora do main pode ser usado em todo o lado
    static int  TNC =0, TNC1 =0, TNC2 = 0, TNC3 = 0,TC = 0, TC1 = 0, TC2 = 0,OT = 0, OT1 = 0, OT2 = 0, OT3 = 0,DTNC1 =0, DTNC2 = 0, DTNC3 = 0, DTC1 = 0, DTC2 = 0, DOT1 = 0, DOT2 = 0, DOT3 = 0, DTNC = 0, DTC = 0, DOT = 0, DT = 0, FmFacial = 0, DF = 0, Mcorporal = 0, DM = 0, day, Clientes, M = 0, F = 0;//variaveis globais para conseguir aceder a estas dentro e fora dos metodos
    
    public static int tratamentos (){
           int escolha1;
                   
           System.out.println("Escolha o tratamento a realizar:\n Tratamentos não Cirúrgicos:\n 1-Facial e cuidados com a pele\n 2-Corporal\n 3-Com laser\n Tratamentos Cirúrgicos:\n 4-Facial\n 5-Corporal\n Outros Tratamentos:\n 6-Varizes\n 7-Obesidade\n 8-Dentário");
           escolha1 = ler.nextInt();
           return escolha1;
    }
    
    public static float percentagemATNC(float DTNC, float DT){
        float percentagemAnaoCirurgico;
                
        percentagemAnaoCirurgico =  ((DTNC/DT)*100); // calculo da percentagem de cada tipo de tratamentos
                       
        return percentagemAnaoCirurgico;    
    }
    
    public static float percentagemATC(float DTC, float DT){
        float  percentagemAcirurgico;
                
        percentagemAcirurgico = ((DTC/DT)*100);  // calculo da percentagem de cada tipo de tratamentos 
       
        return percentagemAcirurgico;
    }
    
    public static float percentagemAOT(float DOT, float DT){
        float  percentagemAoutros;
                
        percentagemAoutros = ((DOT/DT)*100); // calculo da percentagem de cada tipo de tratamentos
       
        return percentagemAoutros;
    }
    
    public static float percentagemCfemininoFacial (float FmFacial, float DF){  //alinea c)
        float percentagemFmFacial;
           
        if(FmFacial == 0){ // este "if" evita que o resultado dê infinitos ou "NaN"
            percentagemFmFacial = 0;
        }
        else{
           percentagemFmFacial = ((FmFacial/DF)*100); //calculo da percentagem de quantas mulheres fizeram tratamentos faciais por dia  
        }
           
        return percentagemFmFacial;
    }    
    
    public static float percentagemDmasculinoCorporal (float Mcorporal, float DM){ //alinea d)
        float percentagemMcorporal;
        
        if(Mcorporal == 0){ // este "if" evita que o resultado dê infinitos ou "NaN"
            percentagemMcorporal = 0; 
        }
        else {
             percentagemMcorporal = ((Mcorporal/DM)*100); // calculo da percentagem de quantos homens fizeram tratamentos corporais por dia
        }
               
        return percentagemMcorporal;
    }
    
    public static float percentagemVisitasM (float M, float Clientes){ //calculo da percentagem de visitas (anual) de clientes do sexo masculino
        float percentagemVisitasMasculino;
        
        percentagemVisitasMasculino = ((M/Clientes)*100);
        
        return percentagemVisitasMasculino;
    }
            
    public static void main(String[] args){
      
        int escolha1, escolha2, escolha3, escolha4, escolha5, MTNC = 0, MTC = 0, MOT = 0, FTNC = 0, FTC = 0, FOT = 0, ADSEmax, SEGmax, PARTmax, TNCADSE = 0, TNCSEG = 0, TNCPART = 0, TCADSE = 0, TCSEG = 0, TCPART = 0, OTADSE = 0, OTSEG = 0, OTPART = 0, ADSE = 0, SEG = 0, PART = 0, TADSE = 0, TSEG=0, TPART=0, X = 0, Z = 0, TM = 0, TF = 0, TTNC1 = 0, TTNC2 = 0, TTNC3 = 0, TTC1 = 0, TTC2 = 0, TOT1 = 0, TOT2 = 0, TOT3 = 0, FmaiorQueM = 0, MTNC1 = 0, MTNC2 = 0, MTC1 = 0, MTC2 = 0, FTNC1 = 0, FTNC2 =0, FTC1 = 0, FTC2 = 0;//Variaveis começadas por "D" são diarias
        float percentagemVisitasF;
        
        for (day = 1; day <= 365; day++){
            
        
           do{
             System.out.println("Olá! Seja bem-vindo á UMCE do Hospital da Luz-Arrábida.\n" + " Dia " + day + ".\n Cliente nº" + Clientes + "."); //Inicio de menu "boas vindas + o dia e o numero de cliente"
             
             System.out.println("Como tenciona pagar?\n 1-Convenção-ADSE\n 2-Convenção-Seguro\n 3-Particular"); //Escolha da forma de pagamento
             escolha5 = ler.nextInt();
               switch(escolha5){
                   case 1:
                       TADSE++;
                       break;
                   case 2:    
                       TSEG++;
                       break;
                   case 3:
                       TPART++;
                       break;
               }
             
             System.out.println("Qual é o sexo do paciente?\n 1-Masculino\n 2-Feminino"); //"escolha" do sexo
             escolha3 = ler.nextInt();
               switch(escolha3){
                   case 1:
                       TM++; //para usar na alinea d)
                       DM++;
                       break;
                   case 2:
                       TF++; //para usar na alinea c)
                       DF++;
                       break;
                }
               
             do{
             escolha1 = tratamentos();
                 switch (escolha1) {
                       case 1:
                           if(TM != 0){ //alinea g) (anual)
                              MTNC1++;
                           } 
                           else{
                              FTNC1++;
                           }
                          TTNC1++;
                          DTNC1++;                        
                          break;
                       case 2:
                           if(TM != 0){ //alinea g) (anual)
                              MTNC2++;
                           } 
                           else{
                              FTNC2++;
                           }
                          TTNC2++;
                          DTNC2++;
                          break;
                       case 3:
                          TTNC3++;
                          DTNC3++;
                          break;
                       case 4:
                           if(TM != 0){ //alinea g) (anual)
                              MTC1++;
                           } 
                           else{
                              FTC1++;
                           }
                          TTC1++;
                          DTC1++;
                         break;
                       case 5:
                           if(TM != 0){ //alinea g) (anual)
                              MTC2++;
                           } 
                           else{
                              FTC2++;
                           }
                          TTC2++;
                          DTC2++;
                          break;
                       case 6:
                          TOT1++;
                          DOT1++;
                          break;
                       case 7:
                          TOT2++;
                          DOT2++;
                          break;
                       case 8:
                          TOT3++;
                          DOT3++;
                          break;
                     } 
                 
                    System.out.println("O paciente irá realizar mais tratamentos?\n 1-Sim\n 2-Não");
                    escolha2 = ler.nextInt();
                    switch(escolha2){
                        case 1:
                           X=0;
                           break;
                        case 2:
                           X=1; //valor aleatório so para terminar o loop de tratamentos
                        break;
                    }
            
                }while (X==0);//para sair dos tratamentos deste cliente
            
            X = 0; //para voltar a usar o X no loop temos de fazer reset senão ele fica com valor 1 e vai saltar sempre fora
             
                            
               if((TTNC1 != 0 || TTC1 != 0) && TF !=0){ //alinea c)
                 FmFacial++;  
               }
               
               if((TTNC2 != 0 || TTC2 != 0) && TM != 0 ){ //alinea d)
                 Mcorporal++;                    
               }
             
               System.out.println("Deseja continuar no dia de hoje?\n 1-Sim\n 2-Não");
               escolha4 = ler.nextInt();
                switch(escolha4){
                    case 1:
                        Z=0;
                        break;
                    case 2:
                        Z=1;
                        break;
                }
                //contadores para a alinea h)
                if((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0 ) && TADSE != 0){ 
                    TNCADSE++;
                }
                if((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0 ) && TSEG != 0){
                    TNCSEG++;
                }
                if((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0 ) && TPART != 0){
                    TNCPART++;
                }
                if((TTC1 != 0 || TTC2 != 0) && TADSE != 0){
                    TCADSE++;
                }
                if((TTC1 != 0 || TTC2 != 0) && TSEG != 0){
                    TCSEG++;
                }
                if((TTC1 != 0 || TTC2 != 0) && TPART != 0){
                    TCPART++;
                }
                if((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TADSE != 0){
                    OTADSE++;
                }
                if((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TSEG != 0){
                    OTSEG++;
                }
                if((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TPART != 0){
                    OTPART++;
                }
                
                //contadores para a alinea i) 
                if((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0 ) && TM != 0){
                    MTNC++;
                }
                if((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0 ) && TF != 0){
                    FTNC++;
                }
                if((TTC1 != 0 || TTC2 != 0) && TM != 0){
                    MTC++;
                }
                if((TTC1 != 0 || TTC2 != 0) && TF != 0){
                    FTC++;
                }
                if((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TM != 0){
                    MOT++;
                }
                if((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TF != 0){
                    FOT++;
                }
                
           //passagem de temporarios para anuais (nao ha necessidade da criacao de diarios)
           ADSE = ADSE + TADSE;
           SEG = SEG + TSEG;
           PART = PART + TPART;
                
           //RESETS entre clientes
           TTNC1 = 0;
           TTC1 = 0;
           TF = 0;
           
           TTNC2 = 0;
           TTC2 = 0;
           TM = 0;
           
           TADSE = 0;
           TSEG = 0;
           TPART = 0;
           
           TTNC3 = 0;
           TOT1 = 0;
           TOT2 = 0;
           TOT3 = 0;
                   
           }while(Z==0);//loop dos clientes de cada dia (ou seja, se mais algum cliente fizer tratamentos naquele dia) 
           
           Z = 0;//para puder voltar a usar o loop
           
           if(DF > DM){ //alinea e) (anual)
               FmaiorQueM++;
           }
           
           
            //incrementacao nas variaveis diarias por tipo de tratamento
            DTNC = DTNC1 + DTNC2 + DTNC3;
            DTC = DTC1 + DTC2;
            DOT = DOT1 + DOT2 + DOT3;
            DT = DTNC + DTC + DOT;
            
            //incrementação das diárias para as anuais
            TNC = TNC + DTNC;
            TC = TC + DTC;
            OT = OT + DOT;
            
            TNC1 = TNC1 + DTNC1;
            TNC2 = TNC2 + DTNC2;
            TNC3 = TNC3 + DTNC3;
            
            TC1 = TC1 + DTC1;
            TC2 = TC2 + DTC2;
            
            OT1 = OT1 + DOT1;
            OT2 = OT2 + DOT2;
            OT3 = OT3 + DOT3;
            
            M = M + DM;
            F = F + DF;
            Clientes = M + F;                      
                      
            //OUTPUTS DIARIOS
            System.out.println("A percentagem de tratamentos não cirúrgicos realizados no dia de hoje foi " + percentagemATNC(DTNC,DT) + "%.");
            System.out.println("A percentagem de tratamentos cirúrgicos realizados no dia de hoje foi " + percentagemATC(DTC,DT) + "%.");
            System.out.println("A percentagem de outros tratamentos realizados no dia de hoje foi " + percentagemAOT(DOT,DT) + "%.");          
            System.out.println("O número de clientes do sexo masculino no dia de hoje foi " + DM + ".");
            System.out.println("O número de clientes do sexo feminino no dia de hoje foi " + DF + ".");
            System.out.println("A percentagem de clientes do sexo feminino que realizaram uma consulta facial foi " + percentagemCfemininoFacial(FmFacial,DF)  + "%.");
            System.out.println("A percentagem de clientes do sexo masculino que realizaram uma consulta corporal foi " + percentagemDmasculinoCorporal (Mcorporal,DM) +"%.");
                        
            //RESETS DIARIOS
            DTNC = 0;
            DTNC1 = 0;
            DTNC2 = 0;
            DTNC3 = 0;
            
            DTC = 0;
            DTC1 = 0;
            DTC2 = 0;
            
            DOT = 0;
            DOT1 = 0;
            DOT2 = 0;
            DOT3 = 0;
            
            DM = 0; //diário masculino
            DF = 0; //diário feminino
            
            FmFacial = 0; //alinea c)
            Mcorporal = 0; //alinea d)
                       
                   
        }//fim do for (anual)
        //alinea h) parte ADSE
        ADSEmax = TNCADSE;
        if(ADSEmax < TCADSE){ //verificacao de qual o tipo de tratamento preferido por pagamento h)
            ADSEmax = TCADSE;
            System.out.println("O tipo de tratamento prefeido através do pagamento ADSE foi o cirúrgico.");//tc
        }
        if(ADSEmax < OTADSE){
            ADSEmax = OTADSE;
            System.out.println("Quem realizou outro tipo de tratamentos foi quem mais usou o pagamento do tipo ADSE.");//ot
        }
        if(ADSEmax == TNCADSE){ //caso o tnc seja o mais frequente por adse
            System.out.println("O tipo de tratamento prefeido através do pagamento ADSE foi o não cirúrgico.");//tnc
        }
        //alinea h) parte SEG
        SEGmax = TNCSEG;
        if(SEGmax < TCSEG){ //verificacao de qual o tipo de tratamento preferido por pagamento h)
            SEGmax = TCSEG;
            System.out.println("O tipo de tratamento prefeido através do pagamento com seguro foi o cirúrgico.");//tc
        }
        if(SEGmax < OTSEG){
            SEGmax = OTSEG;
            System.out.println("Quem realizou outro tipo de tratamentos foi quem mais usou o pagamento do tipo 'seguro'.");//ot
        }
        if(SEGmax == TNCSEG){ //caso o tnc seja o mais frequente por SEG
            System.out.println("O tipo de tratamento prefeido através do pagamento com seguro foi o não cirúrgico.");//tnc
        }
        //alinea h) parte PART
        PARTmax = TNCPART;
        if(PARTmax < TCPART){ //verificacao de qual o tipo de tratamento preferido por pagamento h)
            PARTmax = TCPART;
            System.out.println("O tipo de tratamento prefeido através do pagamento particular foi o cirúrgico.");//tc
        }
        if(PARTmax < OTPART){
            PARTmax = OTPART;
            System.out.println("Quem realizou outro tipo de tratamentos foi quem mais usou o pagamento particular.");//ot
        }
        if(PARTmax == TNCPART){ //caso o tnc seja o mais frequente por SEG
            System.out.println("O tipo de tratamento prefeido através do pagamento particualr foi o não cirúrgico.");//tnc
        }
        
        //alinea g) parte masculina
        if(MTNC1 > MTNC2){
            System.out.println("O tratamento não cirúrgico mais vezes realizado pelos clientes do sexo masculino é o facial.");
        }
        else{
            System.out.println("O tratamento não cirúrgico mais vezes realizado pelos clientes do sexo masculino é o corporal."); 
        }
        if(MTC1 > MTC2){
            System.out.println("O tratamento cirúrgico mais vezes realizado pelos clientes do sexo masculino é o facial.");
        }
        else{
            System.out.println("O tratamento cirúrgico mais vezes realizado pelos clientes do sexo masculino é o corporal.");
        }
        
        //alinea g) parte feminina
        if(FTNC1 > FTNC2){
            System.out.println("O tratamento não cirúrgico mais vezes realizado pelos clientes do sexo feminino é o facial.");
        }
        else{
            System.out.println("O tratamento não cirúrgico mais vezes realizado pelos clientes do sexo feminino é o corporal.");
        }
        if(FTC1 > FTC2){
            System.out.println("O tratamento cirúrgico mais vezes realizado pelos clientes do sexo feminino é o facial.");
        }
        else{
            System.out.println("O tratamento cirúrgico mais vezes realizado pelos clientes do sexo feminino é o corporal.");
        }
        
        percentagemVisitasF = (100 - percentagemVisitasM(M,Clientes)); //para evitar a criacao de outro metodo oposto ao do calculo da percentagem de visitas de clientes do sexo masculino cria-se uma variavel "float" que 'e igual a 100 - a percentagem masculina
        
        //OUTPUTS ANUAIS
        System.out.println("No ano de 2015, o numero de dias em que, o numero de clientes do sexo feminino superou o número de clientes do sexo masculino foi "+ FmaiorQueM + ".");
        System.out.println("A percentagem de visitas de clientes do masculino, no ano de 2015 foi  " + percentagemVisitasM(M,Clientes) + "%.");
        System.out.println("A percentagem de visitas de clientes do feminino, no ano de 2015 foi  " + percentagemVisitasF + "%.");
        System.out.println("O total gasto por clientes do sexo masculino em consultas não cirúrgicas foi " + MTNC*80 + "€.");
        System.out.println("O total gasto por clientes do sexo feminino em consultas não cirúrgicas foi " + FTNC*80 + "€.");  
        System.out.println("O total gasto por clientes do sexo maculino em consultas cirúrgicas foi " + MTC*110 + "€.");
        System.out.println("O total gasto por clientes do sexo feminino em consultas cirúrgicas foi " + FTC*110 + "€.");
        System.out.println("O total gasto por clientes do sexo masculino em outro tipo de consultas foi " + MOT*95 + "€.");
        System.out.println("O total gasto por clientes do sexo feminino em outro tipo de consultas foi " + FOT*95 + "€.");
    }
} 
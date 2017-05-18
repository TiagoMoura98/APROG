/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        float TNC1 = 0, TNC2 = 0, TNC3 = 0, TC = 0, TC1 = 0, TC2 = 0,
                OT = 0, OT1 = 0, OT2 = 0, OT3 = 0, PADSE = 0, PSEG = 0, Particular = 0,
                Feminino = 0, Masculino = 0, clientes = 0, TNC, consultas = 0, PTNC = 0,
                PTC = 0, POT = 0, PDTNC = 0, PDTC = 0, PDOT = 0,
                DTNC1 = 0, DTNC2 = 0, DTNC3 = 0, DTC1 = 0, DTC2 = 0, DOT1 = 0, DOT2 = 0,
                DOT3 = 0, DTNC = 0, DTC = 0, DOT = 0, Dconsultas = 0,
                PC = 0, C = 0, D = 0, PD = 0, E = 0, F = 0, F1 = 0, GMTNC1 = 0,
                GMTNC2 = 0, GMTC1 = 0, GMTC2 = 0, GFTNC1 = 0, GFTNC2 = 0, GFTC1 = 0, GFTC2 = 0,
                AMTC1 = 0, AMTC2 = 0, AMTNC1 = 0, AMTNC2 = 0, AFTC1 = 0, AFTC2 = 0,
                TFeminino = 0, TMasculino = 0;
    //Todas as variáveis em float e em int com um "D" antes são variáveis diárias que dão reset no fim do dia , as que têm um "T" antes são temporárias e servem para calculos no final da ficha de cada cliente, por exemplo para fazer a alinea c)
    //Todas as variáveis com um "A" antes são anuais, ou seja, acumulam ao longo do ano inteiro
        int escolha, escolha2, escolha3, escolha4, escolha5, X = 0, day = 0, DFeminino = 0,
                DMasculino = 0, TTNC1 = 0, TTC1 = 0, TTC2 = 0, TTNC2 = 0, year = 365, Y = 0,
                TPADSE = 0, TSEG = 0, TParticular = 0, APADSETNC1 = 0, APADSETNC2 = 0,
                APADSETNC3 = 0, APADSETC1 = 0, APADSETC2 = 0, APADSEOT1 = 0, APADSEOT2 = 0,
                APADSEOT3 = 0, TTNC3 = 0, TOT1 = 0, TOT2 = 0, TOT3 = 0, ASEGTNC1 = 0, ASEGTNC2 = 0,
                ASEGTNC3 = 0, ASEGTC1 = 0, ASEGTC2 = 0, ASEGOT1 = 0, ASEGOT2 = 0, ASEGOT3 = 0,
                AParticularTNC1 = 0, AParticularTNC2 = 0, AParticularTNC3 = 0, AParticularTC1 = 0, AParticularTC2 = 0, 
                AParticularOT1 = 0, AParticularOT2 = 0, AParticularOT3 = 0;
                

        for (day = 1; day <= year; day++) {
            do {
                do{
                    System.out.println("Day = " + day);
                System.out.println("Tipo de tratamento:\n Tratamentos não Cirúrgicos:\n  Facial e Cuidados com a pele =1\n  Corporal =2\n  Tratamentos com laser =3\n Tratamentos Cirúrgicos:\n  Facial =4\n  Corporal =5\n Outras Áreas de Tratamento:\n  Tratamento de Varizes =6\n  Tratamento de Obesidade =7\n  Tratamento Dentário =8");//escolha relacionada com os tratamentos
                escolha = ler.nextInt();
                  switch (escolha) {
                    case 1:
                        TNC1++;
                        DTNC1++;
                        TTNC1++;
                        break;
                    case 2:
                        TNC2++;
                        DTNC2++;
                        TTNC2++;
                        break;
                    case 3:
                        TNC3++;
                        DTNC3++;
                        TTNC3++;
                        break;
                    case 4:
                        TC1++;
                        DTC1++;
                        TTC1++;
                        break;
                    case 5:
                        TC2++;
                        DTC2++;
                        TTC2++;
                        break;
                    case 6:
                        OT1++;
                        DOT1++;
                        TOT1++;
                        break;
                    case 7:
                        OT2++;
                        DOT2++;
                        TOT2++;
                        break;
                    case 8:
                        OT3++;
                        DOT3++;
                        TOT3++;
                        break;
                    } 
                    System.out.println("Este cliente vai realizar mais tratamentos?\n Sim=1\n Não=2");
                          escolha5 =ler.nextInt();
                          if(escolha5==1){
                              Y=1;
                          }
                          else{
                              Y=2;
                          }
                }while(Y==1);                       
               
                System.out.println("Tipo de pagamento:\n ADSE=1\n Seguro=2\n Particular=3");//escolha relacionada com os pagamentos
                escolha2 = ler.nextInt();
                switch (escolha2) {
                    case 1:
                        PADSE++;
                        break;
                    case 2:
                        PSEG++;
                        break;
                    case 3:
                        Particular++;
                        break;
                }
                if(TTNC1==1 && TPADSE==1){
                    APADSETNC1++;
                }
                else {
                    
                }
                if(TTNC2==1 && TPADSE==1){
                    APADSETNC2++;
                }
                else {
                    
                }
                if(TTNC3==1 && TPADSE==1){
                    APADSETNC3++;
                }
                else {
                    
                }
                if(TTC1==1 && TPADSE==1){
                    APADSETC1++;
                }
                else {
                    
                }
                if(TTC2==1 && TPADSE==1){
                    APADSETC2++;
                }
                else {
                    
                }
                if(TOT1==1 && TPADSE==1){
                    APADSEOT1++;
                }
                else {
                    
                }
                if(TOT2==1 && TPADSE==1){
                    APADSEOT2++;
                }
                else {
                    
                }
                if(TOT3==1 && TPADSE==1){
                    APADSEOT3++;
                }
                else {
                    
                }
                if(TTNC1==1 && TSEG==1){
                    ASEGTNC1++;
                }
                else {
                    
                }
                if(TTNC2==1 && TSEG==1){
                    ASEGTNC2++;
                }
                else {
                    
                }
                if(TTNC3==1 && TSEG==1){
                    ASEGTNC3++;
                }
                else {
                    
                }
                if(TTC1==1 && TSEG==1){
                    ASEGTC1++;
                }
                else {
                   
                }
                if(TTC2==1 && TSEG==1){
                    ASEGTC2++;
                }
                else {
                    
                }
                if(TOT1==1 && TSEG==1){
                    ASEGOT1++;
                }
                else {
                   
                }
                if(TOT2==1 && TSEG==1){
                    ASEGOT2++;
                }
                else {
                   
                }
                if(TOT3==1 && TSEG==1){
                    ASEGOT3++;
                }
                else {
                    
                }
                if(TTNC1==1 && TParticular==1){
                    AParticularTNC1++;
                }
                else {
                    
                }
                if(TTNC2==1 && TParticular==1){
                    AParticularTNC2++;
                }
                else {
                    
                }
                if(TTNC3==1 && TParticular==1){
                    AParticularTNC3++;
                }
                else {
                  
                }
                if(TTC1==1 && TParticular==1){
                    AParticularTC1++;
                }
                else {
                  
                }
                if(TTC2==1 && TParticular==1){
                    AParticularTC2++;
                }
                else {
                    
                }
                if(TOT1==1 && TParticular==1){
                    AParticularOT1++;
                }
                else {
                   
                }
                if(TOT2==1 && TParticular==1){
                    AParticularOT2++;
                }
                else {
                    
                }
                if(TOT3==1 && TParticular==1){
                    AParticularOT3++;
                }
                else {
                    
                }                               
                   
                 
                System.out.println("Sexo:\n Feminino=1\n Masculino=2");//escolha relacionada com o tipo de sexo
                escolha3 = ler.nextInt();
                switch (escolha3) {
                    case 1:
                        Feminino++;
                        DFeminino++;
                        TFeminino++;
                        break;
                    case 2:
                        Masculino++;
                        DMasculino++;
                        TMasculino++;
                        break;

                }
                clientes++;
                System.out.println("Deseja continuar:\n Sim=1\n Não=2");//escolha para continuar ou não o programa
                escolha4 = ler.nextInt();

                if ((TTNC1 == 1 || TTC1 == 1) && TFeminino == 1) {//C=Variável para a alinea c)
                    C++;
                }
                if ((TTNC2 == 1 || TTC2 == 1) && TMasculino == 1) {//D=Variável para a alinea d)
                    D++;
                }
                    if(DTC1==1 && TMasculino==1){//alinea g
                        AMTC1++;//diario de tratamentos cirúrgicos 1=faciais por parte dos clientes masculinos
                    }
                    if(DTC2==1 && TMasculino==1){
                        AMTC2++;
                    }
                    if(DTNC1==1 && TMasculino==1){
                        AMTNC1++;
                    }
                    if(DTNC2==1 && TMasculino==1){
                        AMTNC2++;
                    }
                    if(DTC1==1 && TFeminino==1){
                        AFTC1++;
                    }
                    if(DTC2==1 && TFeminino==1){
                        AFTC2++;
                    }
                    if(DTNC1==1 && TFeminino==1){
                        AFTC1++;
                    }
                    if(DTNC2==1 && TFeminino==1){
                        AFTC2++;
                    }
                 if (escolha4 == 1) {
                    X = 0;
                    TTNC1 = 0;//reset da variável temporária de TNC facial
                    TTC1 = 0;//reset da variável temporária de TC facial
                    TFeminino = 0;//reset da variável temporária feminina
                    TMasculino = 0;//reset da variável temporária masculina
                    TTNC2 = 0;//reset da variável temporária de TNC corporal
                    TTC2 = 0;//reset da variável temporária de TC corporal
                }
                 else {
                    X = 1;
                    TNC = TNC1 + TNC2 + TNC3;//calculo do numero total de tratamentos não cirúrgicos 
                    DTNC = DTNC1 + DTNC2 + DTNC3;//calculo do numero total de tratamentos não cirúrgicos diários
                    TC = TC1 + TC2;//calculo do numero total de tratamentos cirúrgicos
                    DTC = DTC1 + DTC2;//calculo do numero total de tratamentos cirúrgicos diários
                    OT = OT1 + OT2 + OT3;//calculo do numero total de outros tratamentos
                    DOT = DOT1 + DOT2 + DOT3;//calculo do numero total de outros tratamentos diários
                    consultas = TNC + TC + OT;//calculo do numero total de consultas
                    Dconsultas = DTNC + DTC + DOT;
                    PTNC = (TNC / consultas) * 100; //calculo da percentagem de tratamentos não cirúrgicos
                    PDTNC = ((DTNC / Dconsultas) * 100);//calculo da percentagem diaria de tratamentos não cirúrgicos
                    PTC = (TC / consultas) * 100; //calculo da percentagem de tratamentos cirúrgicos
                    PDTC = ((DTC / Dconsultas) * 100);//calculo da percentagem diaria de tratamentos cirúrgicos
                    POT = (OT / consultas) * 100; //calculo da percentagem de outros tratamentos
                    PDOT = ((DOT / Dconsultas) * 100);//calculo da percentagem diaria de outros tratamentos
                    System.out.println("A percentagem de tratamentos não cirúrgicos realizados no dia de hoje foi " + PDTNC + "%.");
                    System.out.println("A percentagem de tratamentos cirúrgicos realizados no dia de hoje foi " + PDTC + "%.");
                    System.out.println("A percentagem de outros tratamentos realizados no dia de hoje foi " + PDOT + "%.");
                    System.out.println("O numero de clientes do sexo masculino no dia de hoje foi " + DMasculino + ".");
                    System.out.println("O numero de clientes do sexo feminino no dia de hoje foi " + DFeminino + ".");
                    if (DFeminino == 0) {
                        PC = 0;//calculo da probabilidade pedida na alinea c)(caso o numero diario de clientes do sexo feminino seja 0)
                    }
                    else {
                        PC = ((C / DFeminino) * 100);//calculo da probabilidade pedida na alinea c)
                    }
                    if (DMasculino == 0) {
                        PD = 0;//calculo da probabilidade pedida na alinea d)(caso o numero diario de clientes do sexo masculino seja 0)
                    } 
                    else {
                        PD = ((D / DMasculino) * 100);//calculo da probabilidade pedida na alinea d)  
                    }
                    System.out.println("A percentagem de clientes do sexo feminino no dia de hoje, que fez uma consulta facial, cirúrgica ou não foi " + PC + "%.");
                    System.out.println("A percentagem de clientes do sexo masculino no dia de hoje, que fez uma consulta corporal, cirúrgica ou não foi " + PD + "%.");
                    if (DFeminino > DMasculino) {//Nesta linha de codigo se o numero de visitas diária de clientes femininos for superior ao de clientes Masculino incrementa 1 na variável E, que resolve a alinea e)
                        E++;
                    }
                    //RESETS diários
                    PDTNC = 0;//reset da variável de probabilidade diária
                    PDTC = 0;//reset da variável de probabilidade diária
                    PDOT = 0;//reset da variável de probabilidade diária
                    Dconsultas = 0;//reset da variável diária de consultas
                    DFeminino = 0;//reset da variável de probabilidade diária
                    DMasculino = 0;//reset da variável de probabilidade diária 
                    C = 0;//reset da variável C
                    TTNC1 = 0;//reset da variável temporária de TNC facial
                    TTC1 = 0;//reset da variável temporária de TC facial
                    TFeminino = 0;//reset da variável temporária feminina
                    TMasculino = 0;//reset da variável temporária masculina
                    TTNC2 = 0;//reset da variável temporária de TNC corporal
                    TTC2 = 0;//reset da variável temporária de TC corporal
                    D = 0;//reset da variável D
                    TTNC3 = 0;//reset da variável temporária de TNC de tratamentos com laser
                    TOT1 = 0;//reset da variável temporária de OT de varizes
                    TOT2 = 0;//reset da variável temporária de OT de obesidade
                    TOT3 = 0;//reset da variável temporária de OT dentário
                }

            } while (X == 0);
        }
        if (day == year) {
            System.out.println("O numero de dias em que houve mais consultas para clientes do sexo feminino foi " + E + ".");
        }
        F = (Feminino / clientes);
        F1 = (Masculino / clientes);
        System.out.println("A média de visitas de clientes do sexo Feminino foi " + F + ".");
        System.out.println("A média de visitas de clientes do sexo Masculino foi " + F1 + ".");
                    if(AMTNC1>AMTNC2){
                        System.out.println("O tramento não cirúrgico mais vezes realizado pelos clientes do sexo masculino foi o não cirúrgico facial.");//alinea G
                    }  
                    else if(AMTNC1<AMTNC2){
                      System.out.println("O tramento não cirúrgico mais vezes realizado pelos clientes do sexo masculino foi o não cirúrgico corporal.");  
                    }else{
                        System.out.println("");
                    }
                    if(AMTC1>AMTC2){
                        System.out.println("O tratamento cirúgico mais vezes realizado pelos clientes do sexo masculino foi o cirúrgico facial.");
                    }
                    else if(AMTC1<AMTC2){
                        System.out.println("O tramento cirúrgico mais vezes realizado pelos clientes do sexo masculino foi o cirúrgico corporal.");
                    }else{
                        System.out.println("");
                    }
                    if(AFTC1>AFTC2){
                        System.out.println("O tratamento não cirúgico mais vezes realizado pelos clientes do sexo feminino foi o não cirúrgico facial.");
                    }
                    else if(AFTC1<AFTC2){
                        System.out.println("O tramento não cirúrgico mais vezes realizado pelos clientes do sexo feminino foi o não cirúrgico corporal.");
                    }else{
                        System.out.println("");
                    }
                    if(AFTC1>AFTC2){
                        System.out.println("O tratamento cirúgico mais vezes realizado pelos clientes do sexo feminino foi o cirúrgico facial.");
                    }
                    else if(AFTC1<AFTC2){
                        System.out.println("O tramento cirúrgico mais vezes realizado pelos clientes do sexo feminino foi o cirúrgico corporal.");
                    }else{
                        System.out.println("");
                    }
                    if(APADSETNC1>APADSETNC2){
                        
                    }
    }
}

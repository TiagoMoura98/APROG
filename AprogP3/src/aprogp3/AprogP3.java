/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aprogp3;

/**
 *
 * @author Tiago Moura
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AprogP3 {

    static Scanner ler = new Scanner(System.in);//como está fora do main pode ser usado em todo o lado
    static int TNC = 0, TNC1 = 0, TNC2 = 0, TNC3 = 0, TC = 0, TC1 = 0, TC2 = 0, OT = 0, OT1 = 0, OT2 = 0, OT3 = 0, DTNC1 = 0, DTNC2 = 0, DTNC3 = 0, DTC1 = 0, DTC2 = 0, DOT1 = 0, DOT2 = 0, DOT3 = 0, DTNC = 0, DTC = 0, DOT = 0, DT = 0, FmFacial = 0, DF = 0, Mcorporal = 0, DM = 0, day, Clientes, M = 0, F = 0;//variaveis globais para conseguir aceder a estas dentro e fora dos metodos

    public static int tratamentos() {
        String opcaoTratamento;

        opcaoTratamento = (String) JOptionPane.showInputDialog(
                null,
                "Indique o tratamento a realizar:",
                "Tratamentos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"TNC: Facial e cuidados com a pele", "TNC: Corporal", "TNC: Com laser", "TC: Facial", "TC: Corporal", "OT: Varizes", "OT: Obesidade", "OT: Dentário"},
                "TNC: Facial e cuidados com a pele");

        switch (opcaoTratamento) {
            case "TNC: Facial e cuidados com a pele":
                return 1;
            case "TNC: Corporal":
                return 2;
            case "TNC: Com laser":
                return 3;
            case "TC: Facial":
                return 4;
            case "TC: Corporal":
                return 5;
            case "OT: Varizes":
                return 6;
            case "OT: Obesidade":
                return 7;
            case "OT: Dentário":
                return 8;
            default:
                return 1;
        }

    }

    public static float[] percentagemA(float DTNC, float DTC, float DOT, float DT) {
        float[] array1 = new float[3];

        float percentagemAnaoCirurgico = ((DTNC / DT) * 100); // calculo da percentagem de cada tipo de tratamentos
        float percentagemAcirurgico = ((DTC / DT) * 100);  // calculo da percentagem de cada tipo de tratamentos 
        float percentagemAoutros = ((DOT / DT) * 100); // calculo da percentagem de cada tipo de tratamentos
        array1[0] = percentagemAnaoCirurgico;
        array1[1] = percentagemAcirurgico;
        array1[2] = percentagemAoutros;

        return array1;
    }

    public static float[] percentagemCeD(float FmFacial, float DF, float Mcorporal, float DM) {  //alinea c)
        float percentagemFmFacial, percentagemMcorporal;
        float[] array3 = new float[2];

        if (FmFacial == 0) { // este "if" evita que o resultado dê infinitos ou "NaN"
            percentagemFmFacial = 0;
        } else {
            percentagemFmFacial = ((FmFacial / DF) * 100); //calculo da percentagem de quantas mulheres fizeram tratamentos faciais por dia  
        }
        if (Mcorporal == 0) { // este "if" evita que o resultado dê infinitos ou "NaN"
            percentagemMcorporal = 0;
        } else {
            percentagemMcorporal = ((Mcorporal / DM) * 100); // calculo da percentagem de quantos homens fizeram tratamentos corporais por dia
        }

        array3[0] = percentagemFmFacial;
        array3[1] = percentagemMcorporal;

        return array3;
    }

    public static float[] percentagemVisitas(float M, float F, float Clientes) { //calculo da percentagem de visitas (anual) de clientes do sexo masculino
        float[] array2 = new float[2];

        float percentagemVisitasMasculino = ((M / Clientes) * 100);
        float percentagemVisitasFeminino = ((F / Clientes) * 100);

        if (M == 0 || Clientes == 0) {
            percentagemVisitasMasculino = 0;
        }
        if (F == 0 || Clientes == 0) {
            percentagemVisitasFeminino = 0;
        }

        array2[0] = percentagemVisitasMasculino;
        array2[1] = percentagemVisitasFeminino;
        return array2;
    }

    public static void main(String[] args) {

        int escolha1, escolha2, escolha3, escolha4, escolha5, MTNC = 0, MTC = 0, MOT = 0, FTNC = 0, FTC = 0, FOT = 0, ADSEmax, SEGmax, PARTmax, TNCADSE = 0, TNCSEG = 0, TNCPART = 0, TCADSE = 0, TCSEG = 0, TCPART = 0, OTADSE = 0, OTSEG = 0, OTPART = 0, ADSE = 0, SEG = 0, PART = 0, TADSE = 0, TSEG = 0, TPART = 0, X = 0, Z = 0, TM = 0, TF = 0, TTNC1 = 0, TTNC2 = 0, TTNC3 = 0, TTC1 = 0, TTC2 = 0, TOT1 = 0, TOT2 = 0, TOT3 = 0, FmaiorQueM = 0, MTNC1 = 0, MTNC2 = 0, MTC1 = 0, MTC2 = 0, FTNC1 = 0, FTNC2 = 0, FTC1 = 0, FTC2 = 0;//Variaveis começadas por "D" são diarias
        float percentagemVisitasF;

        for (day = 1; day <= 365; day++) {

            do {
                JOptionPane.showMessageDialog(
                        null,
                        "Olá! Seja bem-vindo á UMCE do Hospital da Luz-Arrábida.\nDia " + day + ".\nCliente nº" + Clientes + ".",
                        "Bem-vindo",
                        JOptionPane.INFORMATION_MESSAGE);

                escolha5 = JOptionPane.showOptionDialog(
                        null,
                        "Como tenciona pagar?",
                        "Pagamento",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Convenção-ADSE", "Convenção-Seguro", "Particular"},
                        "Particular");
                switch (escolha5) {
                    case 0:
                        TADSE++;
                        break;
                    case 1:
                        TSEG++;
                        break;
                    case 2:
                        TPART++;
                        break;
                }

                escolha3 = JOptionPane.showOptionDialog(
                        null,
                        "Qual é o sexo do paciente?",
                        "Sexo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Masculino", "Feminino"},
                        "Feminino");
                switch (escolha3) {
                    case 0:
                        TM++; //para usar na alinea d)
                        break;
                    case 1:
                        TF++; //para usar na alinea c)
                        break;
                }

                do {
                    escolha1 = tratamentos();
                    switch (escolha1) {
                        case 1:
                            if (TM != 0) { //alinea g) (anual)
                                MTNC1++;
                            } else {
                                FTNC1++;
                            }
                            TTNC1++;
                            DTNC1++;
                            break;
                        case 2:
                            if (TM != 0) { //alinea g) (anual)
                                MTNC2++;
                            } else {
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
                            if (TM != 0) { //alinea g) (anual)
                                MTC1++;
                            } else {
                                FTC1++;
                            }
                            TTC1++;
                            DTC1++;
                            break;
                        case 5:
                            if (TM != 0) { //alinea g) (anual)
                                MTC2++;
                            } else {
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

                    escolha2 = JOptionPane.showOptionDialog(
                            null,
                            "O paciente irá realizar mais tratamentos?",
                            "Tratamentos",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"Sim", "Não"},
                            "Sim");
                    switch (escolha2) {
                        case 0:
                            X = 0;
                            break;
                        case 1:
                            X = 1; //valor aleatório so para terminar o loop de tratamentos
                            break;
                    }

                } while (X == 0);//para sair dos tratamentos deste cliente

                X = 0; //para voltar a usar o X no loop temos de fazer reset senão ele fica com valor 1 e vai saltar sempre fora

                if ((TTNC1 != 0 || TTC1 != 0) && TF != 0) { //alinea c)
                    FmFacial++;
                }

                if ((TTNC2 != 0 || TTC2 != 0) && TM != 0) { //alinea d)
                    Mcorporal++;
                }

                escolha4 = JOptionPane.showOptionDialog(
                        null,
                        "Deseja continuar no dia de hoje?",
                        "Adicionar clientes neste dia",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Sim", "Não"},
                        "Sim");
                switch (escolha4) {
                    case 0:
                        Z = 0;
                        break;
                    case 1:
                        Z = 1;
                        break;
                }
                //contadores para a alinea h)
                if ((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0) && TADSE != 0) {
                    TNCADSE++;
                }
                if ((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0) && TSEG != 0) {
                    TNCSEG++;
                }
                if ((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0) && TPART != 0) {
                    TNCPART++;
                }
                if ((TTC1 != 0 || TTC2 != 0) && TADSE != 0) {
                    TCADSE++;
                }
                if ((TTC1 != 0 || TTC2 != 0) && TSEG != 0) {
                    TCSEG++;
                }
                if ((TTC1 != 0 || TTC2 != 0) && TPART != 0) {
                    TCPART++;
                }
                if ((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TADSE != 0) {
                    OTADSE++;
                }
                if ((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TSEG != 0) {
                    OTSEG++;
                }
                if ((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TPART != 0) {
                    OTPART++;
                }

                //contadores para a alinea i) 
                if ((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0) && TM != 0) {
                    MTNC++;
                }
                if ((TTNC1 != 0 || TTNC2 != 0 || TTNC3 != 0) && TF != 0) {
                    FTNC++;
                }
                if ((TTC1 != 0 || TTC2 != 0) && TM != 0) {
                    MTC++;
                }
                if ((TTC1 != 0 || TTC2 != 0) && TF != 0) {
                    FTC++;
                }
                if ((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TM != 0) {
                    MOT++;
                }
                if ((TOT1 != 0 || TOT2 != 0 || TOT3 != 0) && TF != 0) {
                    FOT++;
                }
                DM = DM + TM;
                DF = DF + TF;
                M = M + DM;
                F = F + DF;
                Clientes = M + F; // Para no programa ir aparecendo o numero de cada cliente corretamente      

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

            } while (Z == 0);//loop dos clientes de cada dia (ou seja, se mais algum cliente fizer tratamentos naquele dia) 

            Z = 0;//para puder voltar a usar o loop

            if (DF > DM) { //alinea e) (anual)
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

            //OUTPUTS DIARIOS
            JOptionPane.showMessageDialog(
                    null,
                    "A percentagem de tratamentos não cirúrgicos realizados no dia de hoje foi " + percentagemA(DTNC, DTC, DOT, DT)[0] + "%.\nA percentagem de tratamentos cirúrgicos realizados no dia de hoje foi " + percentagemA(DTNC, DTC, DOT, DT)[1] + "%.\nA percentagem de outros tratamentos realizados no dia de hoje foi " + percentagemA(DTNC, DTC, DOT, DT)[2] + "%.\n",
                    "Percentagens diárias",
                    JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(
                    null,
                    "O número de clientes do sexo masculino no dia de hoje foi " + DM + ".\nO número de clientes do sexo feminino no dia de hoje foi " + DF + ".\n",
                    "Visitas Diárias",
                    JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(
                    null,
                    "A percentagem de clientes do sexo feminino que realizaram uma consulta facial foi " + percentagemCeD(FmFacial, DF, Mcorporal, DM)[0] + "%.\nA percentagem de clientes do sexo masculino que realizaram uma consulta corporal foi " + percentagemCeD(FmFacial, DF, Mcorporal, DM)[1] + "%.\n",
                    "Outras percentagens",
                    JOptionPane.INFORMATION_MESSAGE);
            
        String text = "A percentagem de tratamentos não cirúrgicos realizados no dia de hoje foi " + percentagemA(DTNC, DTC, DOT, DT)[0] + "%.\r\nA percentagem de tratamentos cirúrgicos realizados no dia de hoje foi " + percentagemA(DTNC, DTC, DOT, DT)[1] + "%.\r\nA percentagem de outros tratamentos realizados no dia de hoje foi " + percentagemA(DTNC, DTC, DOT, DT)[2] + "%.\r\nO número de clientes do sexo masculino no dia de hoje foi " + DM + ".\r\nO número de clientes do sexo feminino no dia de hoje foi " + DF + ".\r\nA percentagem de clientes do sexo feminino que realizaram uma consulta facial foi " + percentagemCeD(FmFacial, DF, Mcorporal, DM)[0] + "%.\r\nA percentagem de clientes do sexo masculino que realizaram uma consulta corporal foi " + percentagemCeD(FmFacial, DF, Mcorporal, DM)[1] + "%.\r\n";
        JFileChooser chooser = new JFileChooser(); 
        int retrival = chooser.showSaveDialog(null); 
        
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                try (FileWriter fw = new FileWriter(chooser.getSelectedFile())) {
                    fw.write(text);
                } 
            }
            catch (IOException ex) {
               System.out.println("Erro!");
            }
        }
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
        if (ADSEmax < TCADSE) { //verificacao de qual o tipo de tratamento preferido por pagamento h)
            ADSEmax = TCADSE;
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento ADSE foi o cirúrgico.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//tc
        }
        if (ADSEmax < OTADSE) {
            ADSEmax = OTADSE;
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento ADSE foi o de outros tratamentos.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//ot
        }
        if (ADSEmax == TNCADSE) { //caso o tnc seja o mais frequente por adse
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento ADSE foi o não cirúrgico.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//tnc
        }
        //alinea h) parte SEG
        SEGmax = TNCSEG;
        if (SEGmax < TCSEG) { //verificacao de qual o tipo de tratamento preferido por pagamento h)
            SEGmax = TCSEG;
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento com seguro foi o cirúrgico.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//tc
        }
        if (SEGmax < OTSEG) {
            SEGmax = OTSEG;
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento com seguro foi o de outros tratamentos.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//ot
        }
        if (SEGmax == TNCSEG) { //caso o tnc seja o mais frequente por SEG
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento com seguro foi o não cirúrgico.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//tnc
        }
        //alinea h) parte PART
        PARTmax = TNCPART;
        if (PARTmax < TCPART) { //verificacao de qual o tipo de tratamento preferido por pagamento h)
            PARTmax = TCPART;
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento particular foi o cirúrgico.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//tc
        }
        if (PARTmax < OTPART) {
            PARTmax = OTPART;
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento particular foi o de outros tratamentos.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//ot
        }
        if (PARTmax == TNCPART) { //caso o tnc seja o mais frequente por SEG
            JOptionPane.showMessageDialog(
                    null,
                    "O tipo de consulta mais frequente pelo pagamento particular foi o não cirúrgico.",
                    "Tipo de consulta mais frequente por pagamento (Anual)",
                    JOptionPane.INFORMATION_MESSAGE);//tnc
        }

        //alinea g) parte masculina
        if (MTNC1 > MTNC2) {
            JOptionPane.showMessageDialog(
                    null,
                    "O tratamento não cirúrgico mais vezes realizado pelos clientes do sexo masculino foi o facial.",
                    "Tratamento não cirúrgico preferido pelos Homens",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "O tratamento não cirúrgico mais vezes realizado pelos clientes do sexo masculino foi o corporal.",
                    "Tratamento não cirúrgico preferido pelos Homens",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (MTC1 > MTC2) {
            JOptionPane.showMessageDialog(
                    null,
                    "O tratamento cirúrgico mais vezes realizado pelos clientes do sexo masculino foi o facial.",
                    "Tratamento cirúrgico preferido pelos Homens",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "O tratamento cirúrgico mais vezes realizado pelos clientes do sexo masculino foi o corporal.",
                    "Tratamento cirúrgico preferido pelos Homens",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        //alinea g) parte feminina
        if (FTNC1 > FTNC2) {
             JOptionPane.showMessageDialog(
                null,
                "O tratamento não cirúrgico mais vezes realizado pelos clientes do sexo feminino é o facial.\n",
                "Informações anuais",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "O tratamento não cirúrgico mais vezes realizado pelos clientes do sexo feminino é o corporal.\n",
                "Informações anuais",
                JOptionPane.INFORMATION_MESSAGE);
        }
        if (FTC1 > FTC2) {
            JOptionPane.showMessageDialog(
                null,
                "O tratamento cirúrgico mais vezes realizado pelos clientes do sexo feminino é o facial.\n",
                "Informações anuais",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "O tratamento cirúrgico mais vezes realizado pelos clientes do sexo feminino é o corporal.\n",
                "Informações anuais",
                JOptionPane.INFORMATION_MESSAGE);
        }

        //OUTPUTS ANUAIS
        JOptionPane.showMessageDialog(
                null,
                "A percentagem de visitas de clientes do masculino, no ano de 2015 foi  " + percentagemVisitas(M, F, Clientes)[0] + "%.\nA percentagem de visitas de clientes do feminino, no ano de 2015 foi  " + percentagemVisitas(M, F, Clientes)[1] + "%.\n",
                "Percentagem de visitas anual",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "O total gasto por clientes do sexo masculino em consultas não cirúrgicas foi " + MTNC * 80 + "€.\nO total gasto por clientes do sexo feminino em consultas não cirúrgicas foi " + FTNC * 80 + "€.\n\nO total gasto por clientes do sexo maculino em consultas cirúrgicas foi " + MTC * 110 + "€.\nO total gasto por clientes do sexo feminino em consultas cirúrgicas foi " + FTC * 110 + "€.\n\nO total gasto por clientes do sexo masculino em outros tipos de consultas foi " + MOT * 95 + "€.\nO total gasto por clientes do sexo feminino em outros tipos de consultas foi " + FOT * 95 + "€.\n",
                "Gastos anuais",
                JOptionPane.INFORMATION_MESSAGE);

        String text2 = "O total gasto por clientes do sexo masculino em consultas não cirúrgicas foi " + MTNC * 80 + "€.\r\nO total gasto por clientes do sexo feminino em consultas não cirúrgicas foi " + FTNC * 80 + "€.\r\n\r\nO total gasto por clientes do sexo maculino em consultas cirúrgicas foi " + MTC * 110 + "€.\r\nO total gasto por clientes do sexo feminino em consultas cirúrgicas foi " + FTC * 110 + "€.\r\n\r\nO total gasto por clientes do sexo masculino em outros tipos de consultas foi " + MOT * 95 + "€.\r\nO total gasto por clientes do sexo feminino em outros tipos de consultas foi " + FOT * 95 + "€.\r\n";
        JFileChooser chooser2 = new JFileChooser(); 
        int retrival2 = chooser2.showSaveDialog(null); 
        
        if (retrival2 == JFileChooser.APPROVE_OPTION) {
            try {
                try (FileWriter fw = new FileWriter(chooser2.getSelectedFile())) {
                    fw.write(text2);
                } 
            }
            catch (IOException ex) {
               System.out.println("Erro!");
            }
        }
    }
  }

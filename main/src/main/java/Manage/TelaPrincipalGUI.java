package Manage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import Atendimento.Atendimento;
import Equipamentos.Equipamento;
import Equipamentos.Tipos.Barco;
import Equipamentos.Tipos.CaminhaoTanque;
import Equipamentos.Tipos.Escavadeira;
import Equipe.Equipe;
import Eventos.Evento;
import Eventos.Tipos.Ciclone;
import Eventos.Tipos.Seca;
import Eventos.Tipos.Terremoto;
import ReadWrite.GravacaoDeArquivos;
import ReadWrite.GravacaoDeArquivosJSON;
import ReadWrite.LeituraDeArquivos;
import ReadWrite.LeituraDeArquivosJSON;

public class TelaPrincipalGUI extends JFrame {
           
    private ACMERescue acmeRescue;
    private String listaEventoAtendimento = "";
    
    public TelaPrincipalGUI(ACMERescue acmeRescue) {
        super();
        this.acmeRescue = acmeRescue;
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        runJTexArea();
    }

    private void initComponents() {

        buttonGroup = new ButtonGroup();
        grupoGravacao = new ButtonGroup();
        grupoLeitura = new ButtonGroup();
        grupoThemeMode = new ButtonGroup();
        jPanelTela = new JPanel();
        jlbCabecalhoInicio = new JLabel();
        TelaInicial = new JTabbedPane();
        jpEvento = new JPanel();
        jTabbedPane3 = new JTabbedPane();
        jpCadastraSeca = new JPanel();
        jLabel124 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jtfSecaLongitude = new JTextField();
        jtfSecaLatitude = new JTextField();
        jtfSecaData = new JTextField();
        jtfSecaCodigo = new JTextField();
        jtfSecaEstiagem = new JTextField();
        jbtCadastrarSeca = new JButton();
        jpCadastraTerremoto = new JPanel();
        jLabel123 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel12 = new JLabel();
        jtfTerremotoLongitude = new JTextField();
        jtfTerremotoLatitude = new JTextField();
        jtfTerremotoData = new JTextField();
        jtfTerremotoCodigo = new JTextField();
        jtfTerremotoEscala = new JTextField();
        jbtCadastraTerremoto = new JButton();
        jpCadastraCiclone = new JPanel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jtfCodigoCiclone = new JTextField();
        jtfDataCiclone = new JTextField();
        jtfLatitudeCiclone = new JTextField();
        jtfLongitudeCiclone = new JTextField();
        jtfVelocidadeCiclone = new JTextField();
        jtfPrecipitacaoCIclone = new JTextField();
        jbtCadastraCiclone = new JButton();
        jPanelCadastraEquipe = new JPanel();
        jlbCodinomeEquipe = new JLabel();
        jlbQuantidadeEquipe = new JLabel();
        jlbLatitudeEquipe = new JLabel();
        jlbLongitudeEquipe = new JLabel();
        jtfCodinomeEquipe = new JTextField();
        jtfQuantidadeEquipe = new JTextField();
        jtfLatitudeEquipe = new JTextField();
        jtfLongitudeEquipe = new JTextField();
        jbtCadastrarEquipe = new JButton();
        jpEquipamento = new JPanel();
        jtpCadastraEquipamento = new JTabbedPane();
        jpCadastraBarco = new JPanel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        jtfBarcoNome = new JTextField();
        jtfBarcoCusto = new JTextField();
        jtfBarcoCapacidade = new JTextField();
        jbtCadastraBarco = new JButton();
        jtfBarcoID = new JTextField();
        jtfEquipeBarco = new JTextField();
        jLabel35 = new JLabel();
        jpCaminhaoCarga = new JPanel();
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        jtfCaminhaoID = new JTextField();
        jtfCaminhaoNome = new JTextField();
        jtfCaminhaoCusto = new JTextField();
        jtfCaminhaoCapacidade = new JTextField();
        jbtCadastraCaminhao = new JButton();
        jtfEquipeCaminhaoCarga = new JTextField();
        jLabel34 = new JLabel();
        jpCadastraEscavadeira = new JPanel();
        jtfEscavadeiraCarga = new JTextField();
        jLabel47 = new JLabel();
        jLabel48 = new JLabel();
        jtfEscavadeiraCombustivel = new JTextField();
        jtfEscavadeiraCusto = new JTextField();
        jLabel49 = new JLabel();
        jLabel50 = new JLabel();
        jtfEscavadeiraNome = new JTextField();
        jtfEscavadeiraID = new JTextField();
        jLabel51 = new JLabel();
        jbtCadastraEscavadeira = new JButton();
        jtfEscavadeiraEquipe = new JTextField();
        jLabel24 = new JLabel();
        jPanel3 = new JPanel();
        jScrollPane3 = new JScrollPane();
        jtaListaEquipesDisponiveis = new JTextArea();
        jpAtendimento = new JPanel();
        jTabbedPane4 = new JTabbedPane();
        jpCadastraAtendimento = new JPanel();
        jScrollPane2 = new JScrollPane();
        jtaListaEventoAtendimento = new JTextArea();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jtfAtendimentoEvento = new JTextField();
        jtfAtendimentoCodigo = new JTextField();
        jtfAtendimentoData = new JTextField();
        jtfAtendimentoDuracao = new JTextField();
        jbtCadastraAtendimento = new JButton();
        jpConfigAtendimento = new JPanel();
        jScrollPane5 = new JScrollPane();
        jtaListaAtendimentosDisponiveis = new JTextArea();
        jLabel40 = new JLabel();
        jLabel41 = new JLabel();
        jtfSelecionarAtendimento = new JTextField();
        jbtStatusConfirmar = new JButton();
        jScrollPane6 = new JScrollPane();
        jtaAtendimentoSelcionado = new JTextArea();
        jbtSelecionarAtendimento = new JButton();
        jrbPendente = new JRadioButton();
        jrbExecutando = new JRadioButton();
        jrbFinalizado = new JRadioButton();
        jrbCancelado = new JRadioButton();
        jpOutro = new JPanel();
        jTabbedPane2 = new JTabbedPane();
        jpInfosGerais = new JPanel();
        jbtMostrarRelatorio = new JButton();
        jbtMostrarTodosEventos = new JButton();
        jbtMostrarTodasEquipes = new JButton();
        jbtMostrarTodosEquipamentos = new JButton();
        jbtMostrarTodosAtendimentos = new JButton();
        jbtAlocacaoAutomatica = new JButton();
        jLabel39 = new JLabel();
        jSeparator2 = new JSeparator();
        jPanel2 = new JPanel();
        jLabel37 = new JLabel();
        jtfLeitura = new JTextField();
        jbtLer = new JButton();
        jtfGravacao = new JTextField();
        jbtGravar = new JButton();
        GravarJson = new JRadioButton();
        GravarNormal = new JRadioButton();
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        LerJson = new JRadioButton();
        LerNormal = new JRadioButton();
        jLabel28 = new JLabel();
        jLabel33 = new JLabel();
        jLabel36 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel38 = new JLabel();
        PAINELTEMA = new JPanel();
        jrbThemeDARK = new JRadioButton();
        jrbThemeLIGHT = new JRadioButton();
        jLabel42 = new JLabel();
        jrbThemePURPLE = new JRadioButton();
        jbtChangeTheme = new JButton();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jtaSystemOut = new JTextArea();
        jbtSairTelaPrincipal = new JButton();
        jbtLimpar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho Final - Nicolas Docolas");
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setName("JFrame");

        jPanelTela.setName("jPanelTela");
        jPanelTela.setPreferredSize(new Dimension(500, 240));

        jlbCabecalhoInicio.setFont(new Font("Georgia", 0, 24));
        jlbCabecalhoInicio.setText("ACMERescue");
        jlbCabecalhoInicio.setName("jlbCabecalhoInicio");
        jlbCabecalhoInicio.setPreferredSize(new Dimension(287, 29));

        TelaInicial.setName("TelaInicial");

        jpEvento.setName("jpEvento");

        jTabbedPane3.setName("jTabbedPane3");

        jpCadastraSeca.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpCadastraSeca.setName("jpCadastraSeca");
        jpCadastraSeca.setPreferredSize(new Dimension(520, 220));

        jLabel124.setText("Codigo");
        jLabel124.setName("jLabel124");

        jLabel16.setText("Data");
        jLabel16.setName("jLabel16");

        jLabel17.setText("Latitude");
        jLabel17.setName("jLabel17");

        jLabel18.setText("Longitude");
        jLabel18.setName("jLabel18");

        jLabel19.setText("Estiagem");
        jLabel19.setName("jLabel19");

        jtfSecaLongitude.setName("jtfSecaLongitude");

        jtfSecaLatitude.setName("jtfSecaLatitude");

        jtfSecaData.setName("jtfSecaData");

        jtfSecaCodigo.setName("jtfSecaCodigo");

        jtfSecaEstiagem.setName("jtfSecaEstiagem");

        jbtCadastrarSeca.setText("Cadastrar");
        jbtCadastrarSeca.setAlignmentY(0.0F);
        jbtCadastrarSeca.setMaximumSize(new Dimension(80, 25));
        jbtCadastrarSeca.setMinimumSize(new Dimension(80, 25));
        jbtCadastrarSeca.setName("jbtCadastrarSeca");
        jbtCadastrarSeca.setPreferredSize(new Dimension(80, 25));
        jbtCadastrarSeca.addActionListener(e -> jbtCadastrarSecaActionPerformed());

        GroupLayout jpCadastraSecaLayout = new GroupLayout(jpCadastraSeca);
        jpCadastraSeca.setLayout(jpCadastraSecaLayout);
        jpCadastraSecaLayout.setHorizontalGroup(
            jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraSecaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jpCadastraSecaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtCadastrarSeca, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jpCadastraSecaLayout.createSequentialGroup()
                        .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel19, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel124, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfSecaCodigo, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(jtfSecaData, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(jtfSecaLongitude, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(jtfSecaLatitude, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(jtfSecaEstiagem, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpCadastraSecaLayout.setVerticalGroup(
            jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraSecaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124)
                    .addComponent(jtfSecaCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSecaData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jtfSecaLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jtfSecaLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraSecaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jtfSecaEstiagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCadastrarSeca, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Seca", jpCadastraSeca);

        jpCadastraTerremoto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpCadastraTerremoto.setName("jpCadastraTerremoto");
        jpCadastraTerremoto.setPreferredSize(new Dimension(520, 220));

        jLabel123.setText("Codigo");
        jLabel123.setName("jLabel123");

        jLabel13.setText("Data");
        jLabel13.setName("jLabel13");

        jLabel14.setText("Latitude");
        jLabel14.setName("jLabel14");

        jLabel15.setText("Longitude");
        jLabel15.setName("jLabel15");

        jLabel12.setText("Escala");
        jLabel12.setName("jLabel12");

        jtfTerremotoLongitude.setName("jtfTerremotoLongitude");

        jtfTerremotoLatitude.setName("jtfTerremotoLatitude");

        jtfTerremotoData.setName("jtfTerremotoData");

        jtfTerremotoCodigo.setName("jtfTerremotoCodigo");

        jtfTerremotoEscala.setName("jtfTerremotoEscala");

        jbtCadastraTerremoto.setText("Cadastrar");
        jbtCadastraTerremoto.setAlignmentY(0.0F);
        jbtCadastraTerremoto.setMaximumSize(new Dimension(80, 25));
        jbtCadastraTerremoto.setMinimumSize(new Dimension(80, 25));
        jbtCadastraTerremoto.setName("jbtCadastraTerremoto");
        jbtCadastraTerremoto.setPreferredSize(new Dimension(80, 25));
        jbtCadastraTerremoto.addActionListener(e -> jbtCadastraTerremotoActionPerformed());

        GroupLayout jpCadastraTerremotoLayout = new GroupLayout(jpCadastraTerremoto);
        jpCadastraTerremoto.setLayout(jpCadastraTerremotoLayout);
        jpCadastraTerremotoLayout.setHorizontalGroup(
            jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraTerremotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jpCadastraTerremotoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtCadastraTerremoto, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jpCadastraTerremotoLayout.createSequentialGroup()
                        .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel123, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfTerremotoCodigo, GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTerremotoData, GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTerremotoLongitude, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(jtfTerremotoLatitude, GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTerremotoEscala))))
                .addContainerGap())
        );
        jpCadastraTerremotoLayout.setVerticalGroup(
            jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraTerremotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(jtfTerremotoCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTerremotoData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtfTerremotoLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtfTerremotoLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraTerremotoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtfTerremotoEscala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCadastraTerremoto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Terremoto", jpCadastraTerremoto);

        jpCadastraCiclone.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpCadastraCiclone.setName("jpCadastraCiclone");
        jpCadastraCiclone.setPreferredSize(new Dimension(520, 220));

        jLabel6.setText("Codigo");
        jLabel6.setName("jLabel6");

        jLabel7.setText("Data");
        jLabel7.setName("jLabel7");

        jLabel8.setText("Latitude");
        jLabel8.setName("jLabel8");

        jLabel9.setText("Longitude");
        jLabel9.setName("jLabel9");

        jLabel10.setText("Velocidade");
        jLabel10.setName("jLabel10");

        jLabel11.setText("Precipitacao");
        jLabel11.setName("jLabel11");

        jtfCodigoCiclone.setName("jtfCodigoCiclone");

        jtfDataCiclone.setName("jtfDataCiclone");

        jtfLatitudeCiclone.setName("jtfLatitudeCiclone");

        jtfLongitudeCiclone.setName("jtfLongitudeCiclone");

        jtfVelocidadeCiclone.setName("jtfVelocidadeCiclone");

        jtfPrecipitacaoCIclone.setName("jtfPrecipitacaoCIclone");

        jbtCadastraCiclone.setText("Cadastrar");
        jbtCadastraCiclone.setAlignmentY(0.0F);
        jbtCadastraCiclone.setMaximumSize(new Dimension(80, 25));
        jbtCadastraCiclone.setMinimumSize(new Dimension(80, 25));
        jbtCadastraCiclone.setName("jbtCadastraCiclone");
        jbtCadastraCiclone.setPreferredSize(new Dimension(80, 25));
        jbtCadastraCiclone.addActionListener(e -> jbtCadastraCicloneActionPerformed());

        GroupLayout jpCadastraCicloneLayout = new GroupLayout(jpCadastraCiclone);
        jpCadastraCiclone.setLayout(jpCadastraCicloneLayout);
        jpCadastraCicloneLayout.setHorizontalGroup(
            jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraCicloneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastraCicloneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtCadastraCiclone, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastraCicloneLayout.createSequentialGroup()
                        .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jtfVelocidadeCiclone, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(jtfLongitudeCiclone, GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfLatitudeCiclone)
                            .addComponent(jtfCodigoCiclone)
                            .addComponent(jtfDataCiclone, GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfPrecipitacaoCIclone))))
                .addContainerGap())
        );
        jpCadastraCicloneLayout.setVerticalGroup(
            jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraCicloneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfCodigoCiclone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfDataCiclone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLatitudeCiclone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLongitudeCiclone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfVelocidadeCiclone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraCicloneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPrecipitacaoCIclone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCadastraCiclone, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Ciclone", jpCadastraCiclone);

        GroupLayout jpEventoLayout = new GroupLayout(jpEvento);
        jpEvento.setLayout(jpEventoLayout);
        jpEventoLayout.setHorizontalGroup(
            jpEventoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        jpEventoLayout.setVerticalGroup(
            jpEventoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, GroupLayout.PREFERRED_SIZE, 275, Short.MAX_VALUE)
        );

        TelaInicial.addTab("Evento", jpEvento);

        jPanelCadastraEquipe.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jPanelCadastraEquipe.setName("jPanelCadastraEquipe");

        jlbCodinomeEquipe.setText("Codinome");
        jlbCodinomeEquipe.setName("jlbCodinomeEquipe");

        jlbQuantidadeEquipe.setText("Quantidade");
        jlbQuantidadeEquipe.setName("jlbQuantidadeEquipe");

        jlbLatitudeEquipe.setText("Latitude");
        jlbLatitudeEquipe.setName("jlbLatitudeEquipe");

        jlbLongitudeEquipe.setText("Longitude");
        jlbLongitudeEquipe.setName("jlbLongitudeEquipe");

        jtfCodinomeEquipe.setName("jtfCodinomeEquipe");

        jtfQuantidadeEquipe.setName("jtfQuantidadeEquipe");

        jtfLatitudeEquipe.setName("jtfLatitudeEquipe");

        jtfLongitudeEquipe.setName("jtfLongitudeEquipe");

        jbtCadastrarEquipe.setText("Cadastrar");
        jbtCadastrarEquipe.setName("jbtCadastrarEquipe");
        jbtCadastrarEquipe.addActionListener(e -> jbtCadastrarEquipeActionPerformed());

        GroupLayout jPanelCadastraEquipeLayout = new GroupLayout(jPanelCadastraEquipe);
        jPanelCadastraEquipe.setLayout(jPanelCadastraEquipeLayout);
        jPanelCadastraEquipeLayout.setHorizontalGroup(
            jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastraEquipeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCadastraEquipeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtCadastrarEquipe, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastraEquipeLayout.createSequentialGroup()
                        .addGroup(jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbQuantidadeEquipe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbCodinomeEquipe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbLatitudeEquipe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbLongitudeEquipe, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jtfQuantidadeEquipe, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(jtfLatitudeEquipe)
                            .addComponent(jtfLongitudeEquipe)
                            .addComponent(jtfCodinomeEquipe))))
                .addContainerGap())
        );
        jPanelCadastraEquipeLayout.setVerticalGroup(
            jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastraEquipeLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCodinomeEquipe)
                    .addComponent(jtfCodinomeEquipe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbQuantidadeEquipe)
                    .addComponent(jtfQuantidadeEquipe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLatitudeEquipe)
                    .addComponent(jtfLatitudeEquipe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadastraEquipeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLongitudeEquipe)
                    .addComponent(jtfLongitudeEquipe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jbtCadastrarEquipe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TelaInicial.addTab("Equipe", jPanelCadastraEquipe);

        jpEquipamento.setName("jpEquipamento");
        jpEquipamento.setPreferredSize(new Dimension(520, 220));

        jtpCadastraEquipamento.setName("jtpCadastraEquipamento");

        jpCadastraBarco.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpCadastraBarco.setName("jpCadastraBarco");

        jLabel20.setText("ID");
        jLabel20.setName("jLabel20");

        jLabel21.setText("Nome");
        jLabel21.setName("jLabel21");

        jLabel22.setText("Custo");
        jLabel22.setName("jLabel22");

        jLabel23.setText("Capacidade");
        jLabel23.setName("jLabel23");

        jtfBarcoNome.setName("jtfBarcoNome");

        jtfBarcoCusto.setName("jtfBarcoCusto");

        jtfBarcoCapacidade.setName("jtfBarcoCapacidade");

        jbtCadastraBarco.setText("Cadastrar");
        jbtCadastraBarco.setName("jbtCadastraBarco");
        jbtCadastraBarco.addActionListener(e -> jbtCadastraBarcoActionPerformed());

        jtfBarcoID.setName("jtfBarcoID");

        jtfEquipeBarco.setName("jtfEquipeBarco");

        jLabel35.setText("Equipe");
        jLabel35.setName("jLabel35");

        GroupLayout jpCadastraBarcoLayout = new GroupLayout(jpCadastraBarco);
        jpCadastraBarco.setLayout(jpCadastraBarcoLayout);
        jpCadastraBarcoLayout.setHorizontalGroup(
            jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraBarcoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastraBarcoLayout.createSequentialGroup()
                        .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel23, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(jLabel22, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(jLabel21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel35, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jtfBarcoNome, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(jtfBarcoCusto)
                            .addComponent(jtfBarcoCapacidade)
                            .addComponent(jtfEquipeBarco)
                            .addComponent(jtfBarcoID)))
                    .addGroup(GroupLayout.Alignment.TRAILING, jpCadastraBarcoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtCadastraBarco, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCadastraBarcoLayout.setVerticalGroup(
            jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraBarcoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBarcoID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jtfBarcoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jtfBarcoCusto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jtfBarcoCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraBarcoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEquipeBarco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCadastraBarco, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtpCadastraEquipamento.addTab("Barco", jpCadastraBarco);

        jpCaminhaoCarga.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpCaminhaoCarga.setName("jpCaminhaoCarga");

        jLabel29.setText("ID");
        jLabel29.setName("jLabel29");

        jLabel30.setText("Nome");
        jLabel30.setName("jLabel30");

        jLabel31.setText("Custo");
        jLabel31.setName("jLabel31");

        jLabel32.setText("Capacidade");
        jLabel32.setName("jLabel32");

        jtfCaminhaoID.setName("jtfCaminhaoID");

        jtfCaminhaoNome.setName("jtfCaminhaoNome");

        jtfCaminhaoCusto.setName("jtfCaminhaoCusto");

        jtfCaminhaoCapacidade.setName("jtfCaminhaoCapacidade");

        jbtCadastraCaminhao.setText("Cadastrar");
        jbtCadastraCaminhao.setName("jbtCadastraCaminhao");
        jbtCadastraCaminhao.addActionListener(e -> jbtCadastraCaminhaoActionPerformed());

        jtfEquipeCaminhaoCarga.setName("jtfEquipeCaminhaoCarga");

        jLabel34.setText("Equipe");
        jLabel34.setName("jLabel34");

        GroupLayout jpCaminhaoCargaLayout = new GroupLayout(jpCaminhaoCarga);
        jpCaminhaoCarga.setLayout(jpCaminhaoCargaLayout);
        jpCaminhaoCargaLayout.setHorizontalGroup(
            jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCaminhaoCargaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpCaminhaoCargaLayout.createSequentialGroup()
                        .addGroup(jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jLabel31, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfCaminhaoCapacidade, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(jtfCaminhaoID, GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEquipeCaminhaoCarga, GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCaminhaoNome)
                            .addComponent(jtfCaminhaoCusto)))
                    .addGroup(GroupLayout.Alignment.TRAILING, jpCaminhaoCargaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtCadastraCaminhao, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCaminhaoCargaLayout.setVerticalGroup(
            jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCaminhaoCargaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jtfCaminhaoID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jtfCaminhaoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jtfCaminhaoCusto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jtfCaminhaoCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCaminhaoCargaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEquipeCaminhaoCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCadastraCaminhao, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtpCadastraEquipamento.addTab("Caminhao Carga", jpCaminhaoCarga);

        jpCadastraEscavadeira.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpCadastraEscavadeira.setName("jpCadastraEscavadeira");

        jtfEscavadeiraCarga.setName("jtfEscavadeiraCarga");

        jLabel47.setText("Carga");
        jLabel47.setName("jLabel47");

        jLabel48.setText("Combustivel");
        jLabel48.setName("jLabel48");

        jtfEscavadeiraCombustivel.setName("jtfEscavadeiraCombustivel");

        jtfEscavadeiraCusto.setName("jtfEscavadeiraCusto");

        jLabel49.setText("Custo");
        jLabel49.setName("jLabel49");

        jLabel50.setText("Nome");
        jLabel50.setName("jLabel50");

        jtfEscavadeiraNome.setName("jtfEscavadeiraNome");

        jtfEscavadeiraID.setName("jtfEscavadeiraID");

        jLabel51.setText("ID");
        jLabel51.setName("jLabel51");

        jbtCadastraEscavadeira.setText("Cadastrar");
        jbtCadastraEscavadeira.setName("jbtCadastraEscavadeira");
        jbtCadastraEscavadeira.addActionListener(e -> jbtCadastraEscavadeiraActionPerformed());

        jtfEscavadeiraEquipe.setName("jtfEscavadeiraEquipe");

        jLabel24.setText("Equipe");
        jLabel24.setName("jLabel24");

        GroupLayout jpCadastraEscavadeiraLayout = new GroupLayout(jpCadastraEscavadeira);
        jpCadastraEscavadeira.setLayout(jpCadastraEscavadeiraLayout);
        jpCadastraEscavadeiraLayout.setHorizontalGroup(
            jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraEscavadeiraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jpCadastraEscavadeiraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtCadastraEscavadeira, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastraEscavadeiraLayout.createSequentialGroup()
                        .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel48, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jLabel49, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel50, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel51, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEscavadeiraCombustivel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(jtfEscavadeiraID)
                            .addComponent(jtfEscavadeiraCarga)
                            .addComponent(jtfEscavadeiraNome, GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfEscavadeiraCusto, GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfEscavadeiraEquipe))))
                .addContainerGap())
        );
        jpCadastraEscavadeiraLayout.setVerticalGroup(
            jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraEscavadeiraLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jtfEscavadeiraID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jtfEscavadeiraNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jtfEscavadeiraCusto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jtfEscavadeiraCombustivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEscavadeiraCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraEscavadeiraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEscavadeiraEquipe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCadastraEscavadeira, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtpCadastraEquipamento.addTab("Escavadeira", jpCadastraEscavadeira);

        jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jPanel3.setName("jPanel3");

        jScrollPane3.setName("jScrollPane3");

        jtaListaEquipesDisponiveis.setEditable(false);
        jtaListaEquipesDisponiveis.setColumns(7);
        jtaListaEquipesDisponiveis.setFont(new Font("Georgia", 0, 14));
        jtaListaEquipesDisponiveis.setRows(5);
        jtaListaEquipesDisponiveis.setName("jtaListaEquipesDisponiveis");
        jScrollPane3.setViewportView(jtaListaEquipesDisponiveis);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        GroupLayout jpEquipamentoLayout = new GroupLayout(jpEquipamento);
        jpEquipamento.setLayout(jpEquipamentoLayout);
        jpEquipamentoLayout.setHorizontalGroup(
            jpEquipamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jpEquipamentoLayout.createSequentialGroup()
                .addComponent(jtpCadastraEquipamento)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jpEquipamentoLayout.setVerticalGroup(
            jpEquipamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jtpCadastraEquipamento, GroupLayout.PREFERRED_SIZE, 275, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, jpEquipamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TelaInicial.addTab("Equipamento", jpEquipamento);

        jpAtendimento.setName("jpAtendimento");

        jTabbedPane4.setName("jTabbedPane4");

        jpCadastraAtendimento.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpCadastraAtendimento.setName("jpCadastraAtendimento");

        jScrollPane2.setName("jScrollPane2");

        jtaListaEventoAtendimento.setEditable(false);
        jtaListaEventoAtendimento.setColumns(3);
        jtaListaEventoAtendimento.setFont(new Font("Georgia", 0, 14));
        jtaListaEventoAtendimento.setRows(3);
        jtaListaEventoAtendimento.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jtaListaEventoAtendimento.setDragEnabled(true);
        jtaListaEventoAtendimento.setName("jtaListaEventoAtendimento");
        jScrollPane2.setViewportView(jtaListaEventoAtendimento);

        jLabel1.setText("Eventos Disponiveis:");
        jLabel1.setName("jLabel1");

        jLabel2.setText("Evento");
        jLabel2.setName("jLabel2");

        jLabel3.setText("Codigo");
        jLabel3.setName("jLabel3");

        jLabel4.setText("Data");
        jLabel4.setName("jLabel4");

        jLabel5.setText("Duracao");
        jLabel5.setName("jLabel5");

        jtfAtendimentoEvento.setName("jtfAtendimentoEvento");

        jtfAtendimentoCodigo.setName("jtfAtendimentoCodigo");

        jtfAtendimentoData.setName("jtfAtendimentoData");

        jtfAtendimentoDuracao.setName("jtfAtendimentoDuracao");

        jbtCadastraAtendimento.setText("Cadastrar");
        jbtCadastraAtendimento.setName("jbtCadastraAtendimento");
        jbtCadastraAtendimento.addActionListener(e -> jbtCadastraAtendimentoActionPerformed());

        GroupLayout jpCadastraAtendimentoLayout = new GroupLayout(jpCadastraAtendimento);
        jpCadastraAtendimento.setLayout(jpCadastraAtendimentoLayout);
        jpCadastraAtendimentoLayout.setHorizontalGroup(
            jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraAtendimentoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastraAtendimentoLayout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpCadastraAtendimentoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jbtCadastraAtendimento, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfAtendimentoCodigo, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(jtfAtendimentoData)
                            .addComponent(jtfAtendimentoDuracao)
                            .addComponent(jtfAtendimentoEvento, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpCadastraAtendimentoLayout.setVerticalGroup(
            jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastraAtendimentoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastraAtendimentoLayout.createSequentialGroup()
                        .addGroup(jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jtfAtendimentoEvento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtfAtendimentoCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfAtendimentoData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpCadastraAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfAtendimentoDuracao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jbtCadastraAtendimento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Cadastrar", jpCadastraAtendimento);

        jpConfigAtendimento.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpConfigAtendimento.setName("jpConfigAtendimento");

        jScrollPane5.setName("jScrollPane5");

        jtaListaAtendimentosDisponiveis.setEditable(false);
        jtaListaAtendimentosDisponiveis.setColumns(3);
        jtaListaAtendimentosDisponiveis.setFont(new Font("Georgia", 0, 12));
        jtaListaAtendimentosDisponiveis.setRows(3);
        jtaListaAtendimentosDisponiveis.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jtaListaAtendimentosDisponiveis.setDragEnabled(true);
        jtaListaAtendimentosDisponiveis.setName("jtaListaAtendimentosDisponiveis");
        jScrollPane5.setViewportView(jtaListaAtendimentosDisponiveis);

        jLabel40.setText("Atendimentos:");
        jLabel40.setName("jLabel40");

        jLabel41.setText("Atendimento:");
        jLabel41.setName("jLabel41");

        jtfSelecionarAtendimento.setName("jtfSelecionarAtendimento");

        jbtStatusConfirmar.setText("Confirmar");
        jbtStatusConfirmar.setEnabled(false);
        jbtStatusConfirmar.setName("jbtStatusConfirmar");
        jbtStatusConfirmar.addActionListener(e -> jbtStatusConfirmarActionPerformed());

        jScrollPane6.setName("jScrollPane6");

        jtaAtendimentoSelcionado.setEditable(false);
        jtaAtendimentoSelcionado.setColumns(15);
        jtaAtendimentoSelcionado.setFont(new Font("Georgia", 0, 12));
        jtaAtendimentoSelcionado.setRows(5);
        jtaAtendimentoSelcionado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jtaAtendimentoSelcionado.setEnabled(false);
        jtaAtendimentoSelcionado.setName("jtaAtendimentoSelcionado");
        jScrollPane6.setViewportView(jtaAtendimentoSelcionado);

        jbtSelecionarAtendimento.setText("Selecionar");
        jbtSelecionarAtendimento.setName("jbtSelecionarAtendimento");
        jbtSelecionarAtendimento.addActionListener(e -> jbtSelecionarAtendimentoActionPerformed());

        buttonGroup.add(jrbPendente);
        jrbPendente.setText("PENDENTE");
        jrbPendente.setEnabled(false);
        jrbPendente.setName("jrbPendente");

        buttonGroup.add(jrbExecutando);
        jrbExecutando.setText("EXECUTANDO");
        jrbExecutando.setEnabled(false);
        jrbExecutando.setName("jrbExecutando");

        buttonGroup.add(jrbFinalizado);
        jrbFinalizado.setText("FINALIZADO");
        jrbFinalizado.setEnabled(false);
        jrbFinalizado.setName("jrbFinalizado");

        buttonGroup.add(jrbCancelado);
        jrbCancelado.setText("CANCELADO");
        jrbCancelado.setEnabled(false);
        jrbCancelado.setName("jrbCancelado");

        GroupLayout jpConfigAtendimentoLayout = new GroupLayout(jpConfigAtendimento);
        jpConfigAtendimento.setLayout(jpConfigAtendimentoLayout);
        jpConfigAtendimentoLayout.setHorizontalGroup(
            jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel40)))
                .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel41)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSelecionarAtendimento, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jpConfigAtendimentoLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbtStatusConfirmar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                            .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jbtSelecionarAtendimento, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jrbFinalizado)
                                        .addComponent(jrbCancelado)
                                        .addComponent(jrbExecutando))))
                            .addGap(1, 1, 1)))
                    .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbPendente)))
                .addContainerGap())
        );
        jpConfigAtendimentoLayout.setVerticalGroup(
            jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jtfSelecionarAtendimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jbtSelecionarAtendimento))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpConfigAtendimentoLayout.createSequentialGroup()
                        .addComponent(jrbPendente)
                        .addGap(18, 18, 18)
                        .addComponent(jrbExecutando)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jrbFinalizado)
                        .addGap(24, 24, 24)
                        .addComponent(jrbCancelado)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtStatusConfirmar))
                    .addGroup(jpConfigAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5, GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Configuracoes", jpConfigAtendimento);

        GroupLayout jpAtendimentoLayout = new GroupLayout(jpAtendimento);
        jpAtendimento.setLayout(jpAtendimentoLayout);
        jpAtendimentoLayout.setHorizontalGroup(
            jpAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
            .addGroup(jpAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane4))
        );
        jpAtendimentoLayout.setVerticalGroup(
            jpAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
            .addGroup(jpAtendimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jpAtendimentoLayout.createSequentialGroup()
                    .addComponent(jTabbedPane4, GroupLayout.PREFERRED_SIZE, 262, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        TelaInicial.addTab("Atendimento", jpAtendimento);

        jpOutro.setName("jpOutro");

        jTabbedPane2.setName("jTabbedPane2");

        jpInfosGerais.setName("jpInfosGerais");

        jbtMostrarRelatorio.setText("Relatorio");
        jbtMostrarRelatorio.setName("jbtMostrarRelatorio");
        jbtMostrarRelatorio.addActionListener(e -> jbtMostrarRelatorioActionPerformed());

        jbtMostrarTodosEventos.setText("Eventos");
        jbtMostrarTodosEventos.setName("jbtMostrarTodosEventos");
        jbtMostrarTodosEventos.addActionListener(e -> jbtMostrarTodosEventosActionPerformed());

        jbtMostrarTodasEquipes.setText("Equipes");
        jbtMostrarTodasEquipes.setName("jbtMostrarTodasEquipes");
        jbtMostrarTodasEquipes.addActionListener(e -> jbtMostrarTodasEquipesActionPerformed());

        jbtMostrarTodosEquipamentos.setText("Equipamentos");
        jbtMostrarTodosEquipamentos.setName("jbtMostrarTodosEquipamentos");
        jbtMostrarTodosEquipamentos.addActionListener(e -> jbtMostrarTodosEquipamentosActionPerformed());

        jbtMostrarTodosAtendimentos.setText("Atendimentos");
        jbtMostrarTodosAtendimentos.setName("jbtMostrarTodosAtendimentos");
        jbtMostrarTodosAtendimentos.addActionListener(e -> jbtMostrarTodosAtendimentosActionPerformed());

        jbtAlocacaoAutomatica.setText("Efetuar");
        jbtAlocacaoAutomatica.setName("jbtAlocacaoAutomatica");
        jbtAlocacaoAutomatica.addActionListener(e -> jbtAlocacaoAutomaticaActionPerformed());

        jLabel39.setText("Alocacao Automatica:");
        jLabel39.setName("jLabel39");

        jSeparator2.setName("jSeparator2");

        GroupLayout jpInfosGeraisLayout = new GroupLayout(jpInfosGerais);
        jpInfosGerais.setLayout(jpInfosGeraisLayout);
        jpInfosGeraisLayout.setHorizontalGroup(
            jpInfosGeraisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpInfosGeraisLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(jpInfosGeraisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtMostrarRelatorio, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtMostrarTodosEventos, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtMostrarTodasEquipes, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtMostrarTodosEquipamentos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtMostrarTodosAtendimentos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jpInfosGeraisLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel39, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtAlocacaoAutomatica, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(GroupLayout.Alignment.TRAILING, jpInfosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jpInfosGeraisLayout.setVerticalGroup(
            jpInfosGeraisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpInfosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtMostrarRelatorio)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtMostrarTodosEventos)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtMostrarTodasEquipes)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtMostrarTodosAtendimentos)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtMostrarTodosEquipamentos)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfosGeraisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jbtAlocacaoAutomatica))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Informacoes", jpInfosGerais);

        jPanel2.setName("jPanel2");

        jLabel37.setText("Nome do arquivo:");
        jLabel37.setName("jLabel37");

        jtfLeitura.setForeground(new Color(102, 102, 102));
        jtfLeitura.setName("jtfLeitura");

        jbtLer.setText("Ler");
        jbtLer.setName("jbtLer");
        jbtLer.addActionListener(e -> jbtLerActionPerformed());

        jtfGravacao.setForeground(new Color(102, 102, 102));
        jtfGravacao.setName("jtfGravacao");

        jbtGravar.setText("Gravar");
        jbtGravar.setName("jbtGravar");
        jbtGravar.addActionListener( e-> jbtGravarActionPerformed());

        grupoGravacao.add(GravarJson);
        GravarJson.setText("JSON");
        GravarJson.setName("GravarJson");

        grupoGravacao.add(GravarNormal);
        GravarNormal.setText("Normal");
        GravarNormal.setName("GravarNormal");

        jLabel25.setText("Formato:");
        jLabel25.setName("jLabel25");

        jLabel26.setText("Nome do arquivo:");
        jLabel26.setName("jLabel26");

        jLabel27.setText("Formato:");
        jLabel27.setName("jLabel27");

        grupoLeitura.add(LerJson);
        LerJson.setText("JSON");
        LerJson.setName("LerJson");

        grupoLeitura.add(LerNormal);
        LerNormal.setText("Normal");
        LerNormal.setName("LerNormal");

        jLabel28.setText("Sem extensao (.csv, .txt, etc)");
        jLabel28.setName("jLabel28");

        jLabel33.setText("Sem extensao (.csv, .txt, etc)");
        jLabel33.setName("jLabel33");

        jLabel36.setFont(new Font("Segoe UI", 1, 14));
        jLabel36.setText("Gravacao");
        jLabel36.setName("jLabel36");

        jSeparator1.setName("jSeparator1");

        jLabel38.setFont(new Font("Segoe UI", 1, 14));
        jLabel38.setText("Leitura");
        jLabel38.setName("jLabel38");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel36, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GravarJson)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GravarNormal))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfGravacao, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtGravar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel37, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LerJson)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LerNormal))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfLeitura, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtLer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel38)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jtfLeitura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtLer))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LerJson)
                    .addComponent(LerNormal)
                    .addComponent(jLabel27)
                    .addComponent(jLabel33))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel36)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfGravacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtGravar)
                    .addComponent(jLabel26))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(GravarJson)
                    .addComponent(GravarNormal)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28))
                .addGap(32, 32, 32))
        );

        jTabbedPane2.addTab("Leitura/Gravacao", jPanel2);

        PAINELTEMA.setName("PAINELTEMA");

        grupoThemeMode.add(jrbThemeDARK);
        jrbThemeDARK.setText("Dark");
        jrbThemeDARK.setName("jrbThemeDARK");

        grupoThemeMode.add(jrbThemeLIGHT);
        jrbThemeLIGHT.setText("Light");
        jrbThemeLIGHT.setName("jrbThemeLIGHT");

        jLabel42.setText("Tema");
        jLabel42.setName("jLabel42");

        grupoThemeMode.add(jrbThemePURPLE);
        jrbThemePURPLE.setText("Purple");
        jrbThemePURPLE.setName("jrbThemePURPLE");

        jbtChangeTheme.setText("Selecionar");
        jbtChangeTheme.setName("jbtChangeTheme");
        jbtChangeTheme.addActionListener( e-> jbtChangeThemeActionPerformed());

        GroupLayout PAINELTEMALayout = new GroupLayout(PAINELTEMA);
        PAINELTEMA.setLayout(PAINELTEMALayout);
        PAINELTEMALayout.setHorizontalGroup(
            PAINELTEMALayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PAINELTEMALayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addGroup(PAINELTEMALayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jrbThemePURPLE)
                    .addComponent(jrbThemeDARK)
                    .addComponent(jrbThemeLIGHT))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PAINELTEMALayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jbtChangeTheme, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, PAINELTEMALayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(262, 262, 262))
        );
        PAINELTEMALayout.setVerticalGroup(
            PAINELTEMALayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PAINELTEMALayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel42)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbThemeLIGHT)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbThemeDARK)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbThemePURPLE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtChangeTheme)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Configuracoes", PAINELTEMA);

        GroupLayout jpOutroLayout = new GroupLayout(jpOutro);
        jpOutro.setLayout(jpOutroLayout);
        jpOutroLayout.setHorizontalGroup(
            jpOutroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jpOutroLayout.setVerticalGroup(
            jpOutroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        TelaInicial.addTab("Gerenciar", jpOutro);

        jPanel1.setName("jPanel1");

        jScrollPane1.setName("jScrollPane1");

        jtaSystemOut.setEditable(false);
        jtaSystemOut.setColumns(20);
        jtaSystemOut.setFont(new Font("Georgia", 0, 14));
        jtaSystemOut.setRows(5);
        jtaSystemOut.setName("jtaSystemOut");
        jScrollPane1.setViewportView(jtaSystemOut);

        jbtSairTelaPrincipal.setText("Sair");
        jbtSairTelaPrincipal.setName("jbtSairTelaPrincipal");
        jbtSairTelaPrincipal.addActionListener(e -> jbtSairTelaPrincipalActionPerformed());

        jbtLimpar.setText("Limpar");
        jbtLimpar.setName("jbtLimpar");
        jbtLimpar.addActionListener(e -> jbtLimparActionPerformed());

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbtLimpar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtSairTelaPrincipal, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSairTelaPrincipal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtLimpar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        GroupLayout jPanelTelaLayout = new GroupLayout(jPanelTela);
        jPanelTela.setLayout(jPanelTelaLayout);
        jPanelTelaLayout.setHorizontalGroup(
            jPanelTelaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTelaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(TelaInicial, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelTelaLayout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(jlbCabecalhoInicio, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );
        jPanelTelaLayout.setVerticalGroup(
            jPanelTelaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelTelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbCabecalhoInicio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TelaInicial)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTela, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTela, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        getAccessibleContext().setAccessibleParent(jPanelTela);

        pack();
    }                     

    private void jbtSairTelaPrincipalActionPerformed() {                                                     
       System.exit(0);
    }                                                    

    private void runJTexArea() {
        jtaSystemOut.setText(acmeRescue.mostrarRelatorio());
        jtaListaAtendimentosDisponiveis.setText(acmeRescue.getListaAtendimentos());
        jtaListaEventoAtendimento.setText(listaEventoAtendimento);
        jtaListaEquipesDisponiveis.setText(acmeRescue.mostrarEquipesDisponiveis());
    }
    
    private void jbtCadastraAtendimentoActionPerformed() {                                                       
        if(jtfAtendimentoCodigo.getText().isEmpty() ||
            jtfAtendimentoData.getText().isEmpty() ||
            jtfAtendimentoDuracao.getText().isEmpty() ||
            jtfAtendimentoEvento.getText().isEmpty()) return;
        Atendimento at = null;
        try {
            at = new Atendimento(Integer.parseInt(jtfAtendimentoCodigo.getText()),
                jtfAtendimentoData.getText(),
                Integer.parseInt(jtfAtendimentoDuracao.getText()),
                acmeRescue.pesquisarCodigoEvento(jtfAtendimentoEvento.getText()));
        } catch(NumberFormatException e) {}
        if(acmeRescue.adicionarAtendimento(at)) {
            jtaSystemOut.append("Atendimento adicionado: " + at.getCodinome()+ "\n");
            
            jtaListaAtendimentosDisponiveis.setText(acmeRescue.getListaAtendimentos());
            
            listaEventoAtendimento = listaEventoAtendimento.replace("- " + at.getEvento().getCodigo() + "\n", "");
            jtaListaEventoAtendimento.setText(listaEventoAtendimento);
        }
        else jtaSystemOut.append("\nFalha ao adicionar atendimento\n");
        jtfAtendimentoCodigo.setText("");
        jtfAtendimentoData.setText("");
        jtfAtendimentoDuracao.setText("");
        jtfAtendimentoEvento.setText("");
    }                                                      

    private void jbtCadastraBarcoActionPerformed() {                                                 
        if(jtfBarcoID.getText().isEmpty() ||
            jtfBarcoNome.getText().isEmpty() ||
            jtfBarcoCusto.getText().isEmpty() ||
            jtfBarcoCapacidade.getText().isEmpty() ||
                jtfEquipeBarco.getText().isEmpty()) return;
        Equipamento equipamento = null;
        Equipe e = null;
        try {
            e = acmeRescue.pesquisarCodigoEquipe(jtfEquipeBarco.getText());
        } catch(Exception ex) {}
        if(e == null) {
            jtaSystemOut.append("\nEquipe invalida");
            return;
        }
        try {
            equipamento = new Barco(Integer.parseInt(jtfBarcoID.getText()),
                jtfBarcoNome.getText(),
                Double.parseDouble(jtfBarcoCusto.getText()),
                Integer.parseInt(jtfBarcoCapacidade.getText()),
            e);
        } catch(NumberFormatException e1) {
            jtaSystemOut.append("\nDados invalidos.\n");
            return;
        }
        if(acmeRescue.adicionarEquipamento(equipamento)) {
            jtaSystemOut.append("\nEquipamento adicionado: " + equipamento.getId() + "\n");
        }
        else jtaSystemOut.append("\nFalha ao adicionar equipamento\n");
        jtfBarcoID.setText("");
        jtfBarcoNome.setText("");
        jtfBarcoCusto.setText("");
        jtfBarcoCapacidade.setText("");
        jtfEquipeBarco.setText("");
    }                                                

    private void jbtCadastrarEquipeActionPerformed() {                                                   
        if(jtfCodinomeEquipe.getText().equals("") ||
            jtfQuantidadeEquipe.getText().equals("") ||
            jtfLatitudeEquipe.getText().equals("") ||
            jtfLongitudeEquipe.getText().equals("")) return;
        Equipe equipe = null;
        try{
            equipe = new Equipe(jtfCodinomeEquipe.getText(),
                Integer.parseInt(jtfQuantidadeEquipe.getText()),
                Double.parseDouble(jtfLatitudeEquipe.getText()),
                Double.parseDouble(jtfLongitudeEquipe.getText()));
        } catch (NumberFormatException e) {}
        if(acmeRescue.adicionarEquipe(equipe)) {
            jtaSystemOut.append("\nEquipe adicionada: " + equipe.getCodinome() + "\n");
            jtaListaEquipesDisponiveis.append("- " + equipe.getCodinome() + "\n");
        }
        else jtaSystemOut.append("\nFalha ao adicionar equipe.\n");
        jtfCodinomeEquipe.setText("");
        jtfQuantidadeEquipe.setText("");
        jtfLatitudeEquipe.setText("");
        jtfLongitudeEquipe.setText("");
    }                                                  

    private void jbtCadastraCicloneActionPerformed() {                                                   
        if(jtfCodigoCiclone.getText().equals("") ||
            jtfDataCiclone.getText().equals("")||
            jtfLatitudeCiclone.getText().equals("") ||
            jtfLongitudeCiclone.getText().equals("") ||
            jtfVelocidadeCiclone.getText().equals("") ||
            jtfPrecipitacaoCIclone.getText().equals("")) return;
        Evento evento = null;
        try {
            evento = new Ciclone(jtfCodigoCiclone.getText(),
                jtfDataCiclone.getText(),
                Double.parseDouble(jtfLatitudeCiclone.getText()),
                Double.parseDouble(jtfLongitudeCiclone.getText()),
                Double.parseDouble(jtfVelocidadeCiclone.getText()),
                Double.parseDouble(jtfPrecipitacaoCIclone.getText()));
        } catch(NumberFormatException e) {}
        if(acmeRescue.adicionarEvento(evento)) {
            jtaSystemOut.append("\nEvento adicionado: " + evento.getCodigo() + "\n");
            listaEventoAtendimento += "- " + evento.getCodigo() + "\n";
            jtaListaEventoAtendimento.setText(listaEventoAtendimento);
        }
        else jtaSystemOut.append("\nFalha ao adicionar evento\n");
        jtfCodigoCiclone.setText("");
        jtfDataCiclone.setText("");
        jtfLatitudeCiclone.setText("");
        jtfLongitudeCiclone.setText("");
        jtfVelocidadeCiclone.setText("");
        jtfPrecipitacaoCIclone.setText("");
    }                                                  

    private void jbtCadastraTerremotoActionPerformed() {                                                     
        if(jtfTerremotoCodigo.getText().isEmpty() ||
            jtfTerremotoData.getText().isEmpty() ||
            jtfTerremotoLongitude.getText().isEmpty() ||
            jtfTerremotoLatitude.getText().isEmpty() ||
            jtfTerremotoEscala.getText().isEmpty()) return;
        Evento evento = null;
        try {
            evento = new Terremoto(jtfTerremotoCodigo.getText(),
                jtfTerremotoData.getText(),
                Double.parseDouble(jtfTerremotoLatitude.getText()),
                Double.parseDouble(jtfTerremotoLongitude.getText()),
                Double.parseDouble(jtfTerremotoEscala.getText()));
        } catch(NumberFormatException e) {}
        if(acmeRescue.adicionarEvento(evento)) {
            jtaSystemOut.append("\nEvento adicionado: " + evento.getCodigo() + "\n");
            listaEventoAtendimento += "- " + evento.getCodigo() + "\n";
            jtaListaEventoAtendimento.setText(listaEventoAtendimento);
        }
        else jtaSystemOut.append("\nFalha ao adicionar evento.\n");
        jtfTerremotoCodigo.setText("");
        jtfTerremotoData.setText("");
        jtfTerremotoLatitude.setText("");
        jtfTerremotoLongitude.setText("");
        jtfTerremotoEscala.setText("");

    }                                                    
    
    private void jbtSelecionarAtendimentoActionPerformed() {                                                         
        if(jtfSelecionarAtendimento.getText().isEmpty()) return;
        try{
            atendimento = acmeRescue.pesquisarCodigoAtendimento(Integer.parseInt(jtfSelecionarAtendimento.getText()));
        } catch (NumberFormatException | NullPointerException e) {
            if(!jtaSystemOut.getText().contains("Codigo invalido.\n")) jtaSystemOut.append("Codigo invalido.\n");
            return;
        }         
        if(atendimento == null) {
            jtaSystemOut.append("\nAtendimento invalido.");
            return;
        }   
        switch(atendimento.getStatus().toUpperCase()) {
            case "PENDENTE" -> {jrbPendente.setSelected(true);}
            case "EXECUTANDO" -> {jrbExecutando.setSelected(true);}
            case "FINALIZADO" -> {
                if(!jtaSystemOut.getText().contains("Atendimento finalizado.\n")) jtaSystemOut.append("Atendimento finalizado.\n");
                return;
            }
            case "CANCELADO" -> {
                if (!jtaSystemOut.getText().contains("Atendimento cancelado.\n")) jtaSystemOut.append("Atendimento cancelado.\n");
                return;
            }
            default -> {return;}
        }
        jtaAtendimentoSelcionado.setEnabled(true);
        jtaAtendimentoSelcionado.setText(atendimento.getDescricao());
        jbtStatusConfirmar.setEnabled(true);
        jrbCancelado.setEnabled(true);
        jrbExecutando.setEnabled(true);
        jrbFinalizado.setEnabled(true);
        jrbPendente.setEnabled(true);
        jtfSelecionarAtendimento.setEnabled(false);
        jbtSelecionarAtendimento.setEnabled(false);
    }                                                        
    
    private Atendimento atendimento = null;

    private void jbtStatusConfirmarActionPerformed() {                                                   
        if((!jrbCancelado.isSelected()) &&
                (!jrbExecutando.isSelected()) &&
                (!jrbFinalizado.isSelected()) &&
                (!jrbPendente.isSelected())) return;
        if(atendimento == null) {
            jbtStatusConfirmar.setEnabled(false);
            jrbCancelado.setEnabled(false);
            jrbExecutando.setEnabled(false);
            jrbFinalizado.setEnabled(false);
            jrbPendente.setEnabled(false);
            buttonGroup.clearSelection();
    
            jtaAtendimentoSelcionado.setText("");
            jtfSelecionarAtendimento.setText("");
            jtfSelecionarAtendimento.setEnabled(true);
            jbtSelecionarAtendimento.setEnabled(true);
            jtaSystemOut.append("\nAtendimento invalido.");
            return;
        }
        if (jrbCancelado.isSelected()) {
            atendimento.alterarStatus("CANCELADO");
        } else if (jrbExecutando.isSelected()) {
            if (atendimento.getEquipeAlocada() == null) {
                jtaSystemOut.append("\nAtendimento nao tem equipe alocada para ser executado!");
            } else {
            atendimento.alterarStatus("EXECUTANDO");
            }
        } else if (jrbFinalizado.isSelected()) {
            if(atendimento.getEquipeAlocada() == null) {
                jtaSystemOut.append("\nAtendimento nao tem equipe alocada para ser finalizado!");
            } else {
            atendimento.alterarStatus("FINALIZADO");
            }
        } else if (jrbPendente.isSelected()) {
            atendimento.alterarStatus("PENDENTE");
        }
        jtaAtendimentoSelcionado.setText(atendimento.getDescricao());

        jtaListaAtendimentosDisponiveis.setText(acmeRescue.getListaAtendimentos());

        jbtStatusConfirmar.setEnabled(false);
        jrbCancelado.setEnabled(false);
        jrbExecutando.setEnabled(false);
        jrbFinalizado.setEnabled(false);
        jrbPendente.setEnabled(false);
        buttonGroup.clearSelection();

        jtaAtendimentoSelcionado.setText("");
        jtfSelecionarAtendimento.setText("");
        jtfSelecionarAtendimento.setEnabled(true);
        jbtSelecionarAtendimento.setEnabled(true);
        
    }                                                  

    private void jbtAlocacaoAutomaticaActionPerformed() {                                                      
        acmeRescue.alocacaoAutomatica();
        jtaListaAtendimentosDisponiveis.setText(acmeRescue.getListaAtendimentos());
        jtaSystemOut.append("\nAlocacao efetuada com sucesso!");
    }                                                     

    private void jbtMostrarTodosAtendimentosActionPerformed() {                                                            
        if (!jtaSystemOut.getText().contentEquals(acmeRescue.mostrarTodosAtendimentos())) jtaSystemOut.setText(acmeRescue.mostrarTodosAtendimentos());
    }                                                           

    private void jbtMostrarTodosEquipamentosActionPerformed() {                                                            
        if (!jtaSystemOut.getText().contentEquals(acmeRescue.mostrarTodosEquipamentos())) jtaSystemOut.setText(acmeRescue.mostrarTodosEquipamentos());
    }                                                           

    private void jbtMostrarTodasEquipesActionPerformed() {                                                       
        if (!jtaSystemOut.getText().contentEquals(acmeRescue.mostrarTodasEquipes())) jtaSystemOut.setText(acmeRescue.mostrarTodasEquipes());
    }                                                      

    private void jbtMostrarTodosEventosActionPerformed() {                                                       
        if(!jtaSystemOut.getText().contentEquals(acmeRescue.mostrarTodosEventos())) jtaSystemOut.setText(acmeRescue.mostrarTodosEventos());
    }                                                      

    private void jbtMostrarRelatorioActionPerformed() {                                                    
        if(!jtaSystemOut.getText().contentEquals(acmeRescue.mostrarRelatorio())) jtaSystemOut.setText(acmeRescue.mostrarRelatorio());
    }                                                   

    private void jbtCadastraCaminhaoActionPerformed() {                                                    
        if(jtfCaminhaoID.getText().isEmpty() ||
            jtfCaminhaoNome.getText().isEmpty() ||
            jtfCaminhaoCusto.getText().isEmpty() ||
            jtfCaminhaoCapacidade.getText().isEmpty()||
            jtfEquipeCaminhaoCarga.getText().isEmpty()) return;
        Equipamento equipamento = null;
                Equipe e = null;
        try {
            e = acmeRescue.pesquisarCodigoEquipe(jtfEquipeCaminhaoCarga.getText());
        } catch(Exception ex) {}
        if(e == null) {
            jtaSystemOut.append("\nEquipe invalida");
            return;
        }
        try{
            equipamento = new CaminhaoTanque(Integer.parseInt(jtfCaminhaoID.getText()),
                jtfCaminhaoNome.getText(),
                Double.parseDouble(jtfCaminhaoCusto.getText()),
                Double.parseDouble(jtfCaminhaoCapacidade.getText()),
                e);
        } catch(NumberFormatException e1) {}
        if(acmeRescue.adicionarEquipamento(equipamento)) {
            jtaSystemOut.append("\nEquipamento adicionado: " + equipamento.getId() + "\n");
        }
        else jtaSystemOut.append("\nFalha ao adicionar equipamento\n");
        jtfCaminhaoID.setText("");
        jtfCaminhaoNome.setText("");
        jtfCaminhaoCusto.setText("");
        jtfCaminhaoCapacidade.setText("");
        jtfEquipeCaminhaoCarga.setText("");
    }                                                   

    private void jbtCadastraEscavadeiraActionPerformed() {                                                       
        if (jtfEscavadeiraID.getText().isEmpty()
                || jtfEscavadeiraNome.getText().isEmpty()
                || jtfEscavadeiraCusto.getText().isEmpty()
                || jtfEscavadeiraCombustivel.getText().isEmpty()
                || jtfEscavadeiraCarga.getText().isEmpty()
                || jtfEscavadeiraEquipe.getText().isEmpty()) {
            return;
        }
        Equipamento equipamento = null;
                Equipe e = null;
        try {
            e = acmeRescue.pesquisarCodigoEquipe(jtfEscavadeiraEquipe.getText());
        } catch(Exception ex) {}
        if(e == null) {
            jtaSystemOut.append("\nEquipe invalida");
            return;
        }
        if (jtfEscavadeiraCombustivel.getText().equalsIgnoreCase("GASOLINA")
                || jtfEscavadeiraCombustivel.getText().equalsIgnoreCase("DIESEL")
                || jtfEscavadeiraCombustivel.getText().equalsIgnoreCase("ALCOOL")) {
            try {
                equipamento = new Escavadeira(Integer.parseInt(jtfEscavadeiraID.getText()),
                        jtfEscavadeiraNome.getText(),
                        Double.parseDouble(jtfEscavadeiraCusto.getText()),
                        jtfEscavadeiraCombustivel.getText(),
                        Double.parseDouble(jtfEscavadeiraCarga.getText()),
                        e);
            } catch (NumberFormatException e1) {
            }
            if (acmeRescue.adicionarEquipamento(equipamento)) {
                jtaSystemOut.append("\nEquipamento adicionado: " + equipamento.getId() + "\n");
            } else {
                jtaSystemOut.append("\nFalha ao adicionar equipamento\n");
            }
            jtfEscavadeiraID.setText("");
            jtfEscavadeiraNome.setText("");
            jtfEscavadeiraCusto.setText("");
            jtfEscavadeiraCombustivel.setText("");
            jtfEscavadeiraCarga.setText("");
            jtfEscavadeiraEquipe.setText("");
        } else {
            jtaSystemOut.append("Combustivel invalido. \n");
        }
    }                                                      

    private void jbtCadastrarSecaActionPerformed() {                                                 
        if(jtfSecaCodigo.getText().isEmpty() ||
            jtfSecaData.getText().isEmpty() ||
            jtfSecaLatitude.getText().isEmpty() ||
            jtfSecaLongitude.getText().isEmpty() ||
            jtfSecaEstiagem.getText().isEmpty()) return;
        Evento evento = null;
        try {
            evento = new Seca(jtfSecaCodigo.getText(),
                jtfSecaData.getText(),
                Double.parseDouble(jtfSecaLatitude.getText()),
                Double.parseDouble(jtfSecaLongitude.getText()),
                Integer.parseInt(jtfSecaEstiagem.getText()));
        } catch(NumberFormatException e) {}
        if(acmeRescue.adicionarEvento(evento)) {
            jtaSystemOut.append("\nEvento adicionado: " + evento.getCodigo() + "\n");
            listaEventoAtendimento += "- " + evento.getCodigo() + "\n";
            jtaListaEventoAtendimento.setText(listaEventoAtendimento);
        }
        else jtaSystemOut.append("\nFalha ao adicionar seca\n");
        jtfSecaCodigo.setText("");
        jtfSecaData.setText("");
        jtfSecaLatitude.setText("");
        jtfSecaLongitude.setText("");
        jtfSecaEstiagem.setText("");
    }                                                

    private void jbtLimparActionPerformed() {                                          
        jtaSystemOut.setText("");
    }                                         

    private void jbtGravarActionPerformed() {                                          
        if(!GravarJson.isSelected() && !GravarNormal.isSelected()) return;
        if (jtfGravacao.getText().isEmpty()) {
            jtaSystemOut.append("\nInsira o nome do arquivo a ser lido.\n");
            return;
        }
        if(GravarNormal.isSelected()) {
            new GravacaoDeArquivos(jtfGravacao.getText(), acmeRescue);;
        } else if(GravarJson.isSelected()) {
            new GravacaoDeArquivosJSON(jtfGravacao.getText(), acmeRescue);
        }
        jtaSystemOut.append("\nGravacao efetuada com sucesso!\n");
        jtfGravacao.setText("");
        grupoGravacao.clearSelection();
    }                                         

    private void jbtLerActionPerformed() {                                       
        if (!LerJson.isSelected() && !LerNormal.isSelected()) return;
        if(jtfLeitura.getText().isEmpty()) {
            jtaSystemOut.append("\nInsira o nome do arquivo a ser lido.\n");
            return;
        }
        if (LerNormal.isSelected()) {
            new LeituraDeArquivos(jtfLeitura.getText(), acmeRescue);
        } else if (LerJson.isSelected()) {
            new LeituraDeArquivosJSON(jtfLeitura.getText(), acmeRescue);
        }
        jtaSystemOut.append("\nLeitura efetuada com sucesso!\n");
        grupoLeitura.clearSelection();
        runJTexArea();
        jtfLeitura.setText("");
    }                                      

    private void setColor(Color color) {
        GravarJson.setBackground(color);
        GravarNormal.setBackground(color);
        LerJson.setBackground(color);
        LerNormal.setBackground(color);
        TelaInicial.setBackground(color);
        jLabel1.setBackground(color);
        jLabel10.setBackground(color);
        jLabel11.setBackground(color);
        jLabel12.setBackground(color);
        jLabel123.setBackground(color);
        jLabel124.setBackground(color);
        jLabel13.setBackground(color);
        jLabel14.setBackground(color);
        jLabel15.setBackground(color);
        jLabel16.setBackground(color);
        jLabel17.setBackground(color);
        jLabel18.setBackground(color);
        jLabel19.setBackground(color);
        jLabel2.setBackground(color);
        jLabel20.setBackground(color);
        jLabel21.setBackground(color);
        jLabel22.setBackground(color);
        jLabel23.setBackground(color);
        jLabel24.setBackground(color);
        jLabel25.setBackground(color);
        jLabel26.setBackground(color);
        jLabel27.setBackground(color);
        jLabel28.setBackground(color);
        jLabel29.setBackground(color);
        jLabel3.setBackground(color);
        jLabel30.setBackground(color);
        jLabel31.setBackground(color);
        jLabel32.setBackground(color);
        jLabel33.setBackground(color);
        jLabel34.setBackground(color);
        jLabel35.setBackground(color);
        jLabel36.setBackground(color);
        jLabel37.setBackground(color);
        jLabel38.setBackground(color);
        jLabel39.setBackground(color);
        jLabel4.setBackground(color);
        jLabel40.setBackground(color);
        jLabel41.setBackground(color);
        jLabel42.setBackground(color);
        jLabel47.setBackground(color);
        jLabel48.setBackground(color);
        jLabel49.setBackground(color);
        jLabel5.setBackground(color);
        jLabel50.setBackground(color);
        jLabel51.setBackground(color);
        jLabel6.setBackground(color);
        jLabel7.setBackground(color);
        jLabel8.setBackground(color);
        jLabel9.setBackground(color);
        jPanel1.setBackground(color);
        jPanel2.setBackground(color);
        jPanel3.setBackground(color);
        PAINELTEMA.setBackground(color);
        jPanelCadastraEquipe.setBackground(color);
        jPanelTela.setBackground(color);
        jScrollPane1.setBackground(color);
        jScrollPane2.setBackground(color);
        jScrollPane3.setBackground(color);
        jScrollPane5.setBackground(color);
        jScrollPane6.setBackground(color);
        jSeparator1.setBackground(color);
        jSeparator2.setBackground(color);
        jTabbedPane2.setBackground(color);
        jTabbedPane3.setBackground(color);
        jTabbedPane4.setBackground(color);
        jlbCabecalhoInicio.setBackground(color);
        jlbCodinomeEquipe.setBackground(color);
        jlbLatitudeEquipe.setBackground(color);
        jlbLongitudeEquipe.setBackground(color);
        jlbQuantidadeEquipe.setBackground(color);
        jpAtendimento.setBackground(color);
        jpCadastraAtendimento.setBackground(color);
        jpCadastraBarco.setBackground(color);
        jpCadastraCiclone.setBackground(color);
        jpCadastraEscavadeira.setBackground(color);
        jpCadastraSeca.setBackground(color);
        jpCadastraTerremoto.setBackground(color);
        jpCaminhaoCarga.setBackground(color);
        jpConfigAtendimento.setBackground(color);
        jpEquipamento.setBackground(color);
        jpEvento.setBackground(color);
        jpInfosGerais.setBackground(color);
        jpOutro.setBackground(color);
        jrbCancelado.setBackground(color);
        jrbExecutando.setBackground(color);
        jrbFinalizado.setBackground(color);
        jrbPendente.setBackground(color);
        jrbThemeDARK.setBackground(color);
        jrbThemeLIGHT.setBackground(color);
        jrbThemePURPLE.setBackground(color);
        jtpCadastraEquipamento.setBackground(color);
    }
    
    private void jbtChangeThemeActionPerformed() {                                               
        if(!jrbThemeDARK.isSelected() && !jrbThemeLIGHT.isSelected() && !jrbThemePURPLE.isSelected()) return;
        if(jrbThemeDARK.isSelected()) {
            setColor(new Color(102, 102, 102));
        } else if(jrbThemeLIGHT.isSelected()) {
            setColor(new Color(240, 240, 240));
        } else if(jrbThemePURPLE.isSelected()) {
            setColor(new Color(102, 0, 255));
        }
    }                                              
                        
    private JRadioButton GravarJson;
    private JRadioButton GravarNormal;
    private JRadioButton LerJson;
    private JRadioButton LerNormal;
    private JPanel PAINELTEMA;
    private JTabbedPane TelaInicial;
    private ButtonGroup buttonGroup;
    private ButtonGroup grupoGravacao;
    private ButtonGroup grupoLeitura;
    private ButtonGroup grupoThemeMode;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel123;
    private JLabel jLabel124;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel5;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanelCadastraEquipe;
    private JPanel jPanelTela;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTabbedPane jTabbedPane2;
    private JTabbedPane jTabbedPane3;
    private JTabbedPane jTabbedPane4;
    private JButton jbtAlocacaoAutomatica;
    private JButton jbtCadastraAtendimento;
    private JButton jbtCadastraBarco;
    private JButton jbtCadastraCiclone;
    private JButton jbtCadastraEscavadeira;
    private JButton jbtCadastraTerremoto;
    private JButton jbtCadastrarEquipe;
    private JButton jbtCadastrarSeca;
    private JButton jbtChangeTheme;
    private JButton jbtGravar;
    private JButton jbtLer;
    private JButton jbtLimpar;
    private JButton jbtMostrarRelatorio;
    private JButton jbtMostrarTodasEquipes;
    private JButton jbtMostrarTodosAtendimentos;
    private JButton jbtMostrarTodosEquipamentos;
    private JButton jbtMostrarTodosEventos;
    private JButton jbtSairTelaPrincipal;
    private JButton jbtSelecionarAtendimento;
    private JButton jbtStatusConfirmar;
    private JLabel jlbCabecalhoInicio;
    private JLabel jlbCodinomeEquipe;
    private JLabel jlbLatitudeEquipe;
    private JLabel jlbLongitudeEquipe;
    private JLabel jlbQuantidadeEquipe;
    private JPanel jpAtendimento;
    private JPanel jpCadastraAtendimento;
    private JPanel jpCadastraBarco;
    private JPanel jpCadastraCiclone;
    private JPanel jpCadastraEscavadeira;
    private JPanel jpCadastraSeca;
    private JPanel jpCadastraTerremoto;
    private JPanel jpCaminhaoCarga;
    private JPanel jpConfigAtendimento;
    private JPanel jpEquipamento;
    private JPanel jpEvento;
    private JPanel jpInfosGerais;
    private JPanel jpOutro;
    private JRadioButton jrbCancelado;
    private JRadioButton jrbExecutando;
    private JRadioButton jrbFinalizado;
    private JRadioButton jrbPendente;
    private JRadioButton jrbThemeDARK;
    private JRadioButton jrbThemeLIGHT;
    private JRadioButton jrbThemePURPLE;
    private JTextArea jtaAtendimentoSelcionado;
    private JTextArea jtaListaAtendimentosDisponiveis;
    private JTextArea jtaListaEquipesDisponiveis;
    private JTextArea jtaListaEventoAtendimento;
    private JTextArea jtaSystemOut;
    private JTextField jtfAtendimentoCodigo;
    private JTextField jtfAtendimentoData;
    private JTextField jtfAtendimentoDuracao;
    private JTextField jtfAtendimentoEvento;
    private JTextField jtfBarcoCapacidade;
    private JTextField jtfBarcoCusto;
    private JTextField jtfBarcoID;
    private JTextField jtfBarcoNome;
    private JButton jbtCadastraCaminhao;
    private JTextField jtfCaminhaoCapacidade;
    private JTextField jtfCaminhaoCusto;
    private JTextField jtfCaminhaoID;
    private JTextField jtfCaminhaoNome;
    private JTextField jtfCodigoCiclone;
    private JTextField jtfCodinomeEquipe;
    private JTextField jtfDataCiclone;
    private JTextField jtfEquipeBarco;
    private JTextField jtfEquipeCaminhaoCarga;
    private JTextField jtfEscavadeiraCarga;
    private JTextField jtfEscavadeiraCombustivel;
    private JTextField jtfEscavadeiraCusto;
    private JTextField jtfEscavadeiraEquipe;
    private JTextField jtfEscavadeiraID;
    private JTextField jtfEscavadeiraNome;
    private JTextField jtfGravacao;
    private JTextField jtfLatitudeCiclone;
    private JTextField jtfLatitudeEquipe;
    private JTextField jtfLeitura;
    private JTextField jtfLongitudeCiclone;
    private JTextField jtfLongitudeEquipe;
    private JTextField jtfPrecipitacaoCIclone;
    private JTextField jtfQuantidadeEquipe;
    private JTextField jtfSecaCodigo;
    private JTextField jtfSecaData;
    private JTextField jtfSecaEstiagem;
    private JTextField jtfSecaLatitude;
    private JTextField jtfSecaLongitude;
    private JTextField jtfSelecionarAtendimento;
    private JTextField jtfTerremotoCodigo;
    private JTextField jtfTerremotoData;
    private JTextField jtfTerremotoEscala;
    private JTextField jtfTerremotoLatitude;
    private JTextField jtfTerremotoLongitude;
    private JTextField jtfVelocidadeCiclone;
    private JTabbedPane jtpCadastraEquipamento;
    // End of variables declaration                   
}

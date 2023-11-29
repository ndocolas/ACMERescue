package Manage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import ReadWrite.LeituraDeArquivos;

public class LeituraInicial extends JFrame {

    private ACMERescue acmeRescue;
    
    public LeituraInicial(ACMERescue acmeRescue) {
        super();
        this.acmeRescue = acmeRescue;
        setVisible(true);
        initComponents();
    }
    
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jtfLeitura = new JTextField();
        jLabel1 = new JLabel();
        jbtLer = new JButton();
        jScrollPane1 = new JScrollPane();
        jtaSaida = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName("jPanel1");

        jLabel2.setFont(new Font("Segoe UI", 0, 14));
        jLabel2.setText("Arquivo:");
        jLabel2.setName("jLabel2");

        jtfLeitura.setName("jtfLeitura");

        jLabel1.setFont(new Font("Georgia", 0, 24));
        jLabel1.setText("ACMERescue");
        jLabel1.setName("jLabel1"); 

        jbtLer.setText("Ler");
        jbtLer.setName("jbtLer");
        jbtLer.addActionListener(e -> jbtLerActionPerformed());

        jScrollPane1.setName("jScrollPane1");

        jtaSaida.setEditable(false);
        jtaSaida.setColumns(20);
        jtaSaida.setRows(5);
        jtaSaida.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jtaSaida.setName("jtaSaida");
        jScrollPane1.setViewportView(jtaSaida);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 123, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(110, 110, 110))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtfLeitura))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbtLer, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfLeitura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jbtLer)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jbtLerActionPerformed() {
       if(jtfLeitura.getText().isEmpty()) return;
       new LeituraDeArquivos(jtfLeitura.getText(), acmeRescue);
       if(acmeRescue.mostrarRelatorio().equals("Nenhum dado cadastrado.")) {
           jtaSaida.append("Dados invalidos.\n");
           return;
       }
       new TelaPrincipalGUI(acmeRescue);
       this.setVisible(false);
    }


    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JButton jbtLer;
    private JTextArea jtaSaida;
    private JTextField jtfLeitura;
}

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPostos extends JFrame {
    private JTextArea resultadoArea;
    public JPanel CriarPainelPostos(){
        JPanel painelCadastroPosto = new JPanel();
        painelCadastroPosto.setLayout(new BorderLayout());

        JPanel painelCamposCadastroPosto = new JPanel();
        GroupLayout layout = new GroupLayout(painelCamposCadastroPosto);
        painelCamposCadastroPosto.setLayout(layout);

        JLabel tituloLabel = new JLabel("   Cadastro de Posto");
        tituloLabel.setFont(new Font("Inter", Font.BOLD, 20));

        JLabel nomeLabel = new JLabel("   Nome do Posto:");
        JTextField nomeField = new JTextField();

        JLabel cnpjLabel = new JLabel("   CNPJ:");
        JTextField cnpjField = new JTextField();

        JLabel enderecoLabel = new JLabel("   Endereço:");
        JTextField enderecoField = new JTextField();

        JLabel cepLabel = new JLabel("   CEP:");
        JTextField cepField = new JTextField();

        JLabel cidadeLabel = new JLabel("   Cidade:");
        JTextField cidadeField = new JTextField();

        JLabel estadoLabel = new JLabel("   Estado:");
        JTextField estadoField = new JTextField();

        JLabel buscaLabel = new JLabel(" Digite o CNPJ do posto que está procurando:");
        JTextField buscaCnpjCampo = new JTextField();

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Busca realizada!");
            }
        });

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cadastro de posto realizado!");
                String dadosPosto = String.format("Nome: %s, CNPJ: %s, Endereço: %s, CEP: %s, Cidade: %s, Estado: %s%n",
                        nomeField.getText(), cnpjField.getText(), enderecoField.getText(),
                        cepField.getText(), cidadeField.getText(), estadoField.getText());
                resultadoArea.append(dadosPosto);
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(tituloLabel)
                .addComponent(nomeLabel)
                .addComponent(cnpjLabel)
                .addComponent(enderecoLabel)
                .addComponent(cepLabel)
                .addComponent(cidadeLabel)
                .addComponent(estadoLabel)
                .addComponent(buscaLabel)
                .addComponent(buscaCnpjCampo)
        );

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(nomeField)
                .addComponent(cnpjField)
                .addComponent(enderecoField)
                .addComponent(cepField)
                .addComponent(cidadeField)
                .addComponent(estadoField)
                .addComponent(cadastrarButton)
                .addComponent(buscaLabel)
                .addComponent(buscarButton)
        );

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tituloLabel));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nomeLabel)
                .addComponent(nomeField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cnpjLabel)
                .addComponent(cnpjField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(enderecoLabel)
                .addComponent(enderecoField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cepLabel)
                .addComponent(cepField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cidadeLabel)
                .addComponent(cidadeField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(estadoLabel)
                .addComponent(estadoField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cadastrarButton));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(buscaLabel)
                .addComponent(buscaCnpjCampo)
                .addComponent(buscarButton));

        layout.setVerticalGroup(vGroup);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setBorder(new EmptyBorder(0, 20, 10, 20));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        painelCadastroPosto.add(painelCamposCadastroPosto, BorderLayout.NORTH);
        painelCadastroPosto.add(scrollPane, BorderLayout.CENTER);

        return painelCadastroPosto;
    }
}
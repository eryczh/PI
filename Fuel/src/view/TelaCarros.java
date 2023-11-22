import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaCarros {
    private JTextArea resultadoArea;

    public JPanel CriarPainelCarros() {
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new BorderLayout());

        JPanel painelCamposCadastro = new JPanel();
        GroupLayout layout = new GroupLayout(painelCamposCadastro);
        painelCamposCadastro.setLayout(layout);

        JLabel tituloLabel = new JLabel("   Cadastro de Carros");
        tituloLabel.setFont(new Font("Inter", Font.BOLD, 20));

        JLabel placaLabel = new JLabel("   Placa do Carro:");
        JTextField placaField = new JTextField();

        JLabel modeloLabel = new JLabel("   Modelo:");
        JTextField modeloField = new JTextField();

        JLabel corLabel = new JLabel("   Cor do Carro:");
        JTextField corField = new JTextField();

        JLabel anoLabel = new JLabel("   Ano do Carro:");
        JTextField anoField = new JTextField();

        JLabel combustivelLabel = new JLabel("   Tipo de Combustível:");
        JTextField combustivelField = new JTextField();

        JLabel kmLabel = new JLabel("   Km Percorridos:");
        JTextField kmField = new JTextField();

        JLabel BuscaLabel = new JLabel(" Digite a placa do carro que está procurando:");
        BuscaLabel.setForeground(Color.gray);
        JTextField BuscaPlacaCampo = new JTextField();

        JButton buscarButton = new JButton("Buscar");
        JButton cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cadastro realizado!");
                String dadosCarro = String.format("Placa: %s, Modelo: %s, Cor: %s, Ano: %s, Combustível: %s, Km: %s%n",
                        placaField.getText(), modeloField.getText(), corField.getText(),
                        anoField.getText(), combustivelField.getText(), kmField.getText());
                resultadoArea.append(dadosCarro);
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(tituloLabel)
                .addComponent(placaLabel)
                .addComponent(modeloLabel)
                .addComponent(corLabel)
                .addComponent(anoLabel)
                .addComponent(combustivelLabel)
                .addComponent(kmLabel)
                .addComponent(BuscaLabel)
                .addComponent(BuscaPlacaCampo)
        )
        ;

        hGroup.addGroup(layout.createParallelGroup()
                        .addComponent(placaField)
                        .addComponent(modeloField)
                        .addComponent(corField)
                        .addComponent(anoField)
                        .addComponent(combustivelField)
                        .addComponent(kmField)
                        .addComponent(cadastrarButton))
                .addComponent(buscarButton);

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tituloLabel));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(placaLabel)
                .addComponent(placaField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(modeloLabel)
                .addComponent(modeloField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(corLabel)
                .addComponent(corField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(anoLabel)
                .addComponent(anoField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(combustivelLabel)
                .addComponent(combustivelField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(kmLabel)
                .addComponent(kmField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cadastrarButton));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(BuscaLabel)
                .addComponent(BuscaPlacaCampo)
                .addComponent(buscarButton));

        layout.setVerticalGroup(vGroup);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setBorder(new EmptyBorder(0, 20, 10, 20));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        painelCadastro.add(painelCamposCadastro, BorderLayout.NORTH);
        painelCadastro.add(scrollPane, BorderLayout.CENTER);

        return painelCadastro;
    }
}
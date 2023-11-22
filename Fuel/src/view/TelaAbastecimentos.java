import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAbastecimentos {
    private JTextArea resultadoArea;

    public JPanel CriarPainelAbastecimentos() {
        JPanel painelCadastro = new JPanel(new BorderLayout());

        JPanel painelCamposCadastro = new JPanel();
        GroupLayout layout = new GroupLayout(painelCamposCadastro);
        painelCamposCadastro.setLayout(layout);

        JLabel tituloLabel = new JLabel("Cadastro de Abastecimentos");
        tituloLabel.setFont(new Font("Inter", Font.BOLD, 20));

        JLabel dataLabel = new JLabel("Data:");
        JTextField dataField = new JTextField();

        JLabel valorCombustivelLabel = new JLabel("Valor do Combustível:");
        JTextField valorCombustivelField = new JTextField();

        JLabel qtdCombustivelLabel = new JLabel("Quantidade de Combustível:");
        JTextField qtdCombustivelField = new JTextField();

        JLabel tipoCombustivelLabel = new JLabel("Tipo de Combustível:");
        JTextField tipoCombustivelField = new JTextField();

        JLabel placaCarroLabel = new JLabel("Placa do Carro:");
        JTextField placaCarroField = new JTextField();

        JLabel nomePostoLabel = new JLabel("Nome do Posto:");
        JTextField nomePostoField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dadosAbastecimento = String.format(
                        "Data: %s, Valor do Combustível: %s, Quantidade de Combustível: %s, Tipo de Combustível: %s, Placa do Carro: %s, Nome do Posto: %s%n",
                        dataField.getText(), valorCombustivelField.getText(), qtdCombustivelField.getText(),
                        tipoCombustivelField.getText(), placaCarroField.getText(), nomePostoField.getText());
                resultadoArea.append(dadosAbastecimento);
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(tituloLabel)
                .addComponent(dataLabel)
                .addComponent(valorCombustivelLabel)
                .addComponent(qtdCombustivelLabel)
                .addComponent(tipoCombustivelLabel)
                .addComponent(placaCarroLabel)
                .addComponent(nomePostoLabel)
                .addComponent(cadastrarButton));

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(dataField)
                .addComponent(valorCombustivelField)
                .addComponent(qtdCombustivelField)
                .addComponent(tipoCombustivelField)
                .addComponent(placaCarroField)
                .addComponent(nomePostoField));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tituloLabel));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(dataLabel)
                .addComponent(dataField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(valorCombustivelLabel)
                .addComponent(valorCombustivelField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(qtdCombustivelLabel)
                .addComponent(qtdCombustivelField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tipoCombustivelLabel)
                .addComponent(tipoCombustivelField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(placaCarroLabel)
                .addComponent(placaCarroField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nomePostoLabel)
                .addComponent(nomePostoField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cadastrarButton));

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

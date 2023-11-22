import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {

    private TelaCarros telaCarros = new TelaCarros();
    private TelaPostos telaPostos = new TelaPostos();
    private TelaAbastecimentos telaAbastecimentos = new TelaAbastecimentos();

    private JPanel painelAtual;

    public TelaPrincipal() {
        // Configuração da janela
        setTitle("Fuel");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Impede que a janela seja redimensionada

        // Painel lateral esquerdo
        JPanel painelLateral = criarPainelLateral();

        // Layout principal da tela
        setLayout(new BorderLayout());
        add(painelLateral, BorderLayout.WEST);

        // Adiciona um listener para trocar para a tela de Carros por padrão
        trocarPainel("Carros");
    }

    private JPanel criarPainelLateral() {
        JPanel painelLateral = new JPanel();
        painelLateral.setPreferredSize(new Dimension(250, 700));
        painelLateral.setBackground(Color.decode("#862EAF"));

        JLabel nomeAppLabel = new JLabel("Fuel");
        nomeAppLabel.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 62));
        nomeAppLabel.setForeground(Color.WHITE);
        nomeAppLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel espacamento = new JPanel();
        espacamento.setBackground(Color.decode("#862EAF"));
        espacamento.setPreferredSize(new Dimension(250, 10));

        JPanel painelCarros = criarPainelOpcao("Carros");
        JPanel painelPostos = criarPainelOpcao("Postos");
        JPanel painelAbastecimentos = criarPainelOpcao("Abastecimentos");

        painelLateral.setLayout(new GridLayout(8, 1, 5, 5)); // GridLayout com 8 linhas, 1 coluna e espaçamento vertical e horizontal de 5 pixels
        painelLateral.add(nomeAppLabel);
        painelLateral.add(espacamento);
        painelLateral.add(painelCarros);
        painelLateral.add(painelPostos);
        painelLateral.add(painelAbastecimentos);

        return painelLateral;
    }

    private void trocarPainel(String texto) {
        JPanel novoPainel;

        switch (texto) {
            case "Carros":
                novoPainel = telaCarros.CriarPainelCarros();
                break;
            case "Postos":
                novoPainel = telaPostos.CriarPainelPostos(); // Substitua isso com a lógica para criar o painel de Postos
                break;
            case "Abastecimentos":
                novoPainel = telaAbastecimentos.CriarPainelAbastecimentos(); // Substitua isso com a lógica para criar o painel de Abastecimentos
                break;
            default:
                return;
        }

        if (painelAtual != null) {
            getContentPane().remove(painelAtual);
        }

        add(novoPainel, BorderLayout.CENTER);

        validate();
        repaint();

        painelAtual = novoPainel;
    }

    private JPanel criarPainelOpcao(String texto) {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setPreferredSize(new Dimension(250, 40)); // Reduzi o tamanho para 40 pixels
        painel.setBackground(Color.decode("#862EAF"));

        JLabel label = new JLabel(texto);
        label.setFont(new Font("Cairo", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        painel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                trocarPainel(texto);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                painel.setBackground(Color.decode("#C173FF"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                painel.setBackground(Color.decode("#862EAF"));
            }
        });

        painel.add(label, BorderLayout.CENTER);

        return painel;
    }
}

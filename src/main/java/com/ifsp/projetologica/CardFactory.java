/*
    Essa classe vai gerar um JPanel que representa um card de tarefas
    com base num objeto da classe Tarefa.java.
*/

package com.ifsp.projetologica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public final class CardFactory {
    // Altura dos cards.
    public static final int CARD_TOTAL_HEIGHT = 195;
    // Espessura da borda colorida.
    public static final int BORDER_WIDTH = 20;
    
    //  Calcula a altura utilizável do card
    // (desconta a borda)
    public static int calcHeight() {
        return CARD_TOTAL_HEIGHT - (2 * BORDER_WIDTH);
    }
   
    // Cria um JPanel, que é basicamente um card
    // que será exibido no grid do Frame1.java
    public static JPanel criarCardTarefa(Frame1 frame, int width, Tarefa t, int tarefa_idx) {
        JPanel card = new JPanel(new GridBagLayout());
        
        card.setBackground(Color.WHITE);
        card.setBorder(
            BorderFactory.createLineBorder(
                t.obterCor(),   // Cor da borda (que é a cor referente ao tempo restante da tarefa em questão)
                BORDER_WIDTH,   // Espessura
                false           // Arredondada?
            )
        );
        
        card.setSize(width, calcHeight());
        
        // Cria os componentes que serão exibidos no card.
        JLabel lbl_Materia = new JLabel(t.Materia);
        lbl_Materia.setFont(lbl_Materia.getFont().deriveFont(Font.BOLD));
        JLabel lbl_Descricao = new JLabel(t.Descricao);
        JLabel lbl_Prazo = new JLabel(t.prazoString());
        JLabel lbl_Restante = new JLabel(t.tempoRestanteStr());
        
        JButton btn_Concluir = new JButton();
        btn_Concluir.setText("Marcar como concluída");
        btn_Concluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opcoes = {"Sim", "Não"};
                int dialog = JOptionPane.showOptionDialog(
                    null,
                    "Deseja mesmo marcar a tarefa como concluída?",
                    "Aviso",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    UIManager.getIcon("OptionPane.warningIcon"),
                    opcoes,
                    opcoes[0]
                );
                if(dialog != JOptionPane.YES_OPTION) return;
                
                Frame1.removerTarefa(tarefa_idx);
                frame.updateGrid();
            }
        });
        
        // Aqui configuramos o layout do card para colocar
        // um componente de baixo do outro.
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        
        c.gridy = 0;
        card.add(lbl_Materia, c);
        
        c.gridy = 1;
        card.add(lbl_Descricao, c);
        
        c.gridy = 2;
        card.add(lbl_Prazo, c);
        
        c.gridy = 3;
        card.add(lbl_Restante, c);
        
        c.gridy = 4;
        card.add(btn_Concluir, c);
        
        return card;
    }
}

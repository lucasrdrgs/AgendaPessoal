package com.ifsp.projetologica;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Frame1 extends javax.swing.JFrame {
    public Frame1() {
        initComponents();
    }
    
    private static ArrayList<Tarefa> tarefas;
    private Timer updateTimeLeft;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp_Grid = new javax.swing.JScrollPane();
        pnl_Grid = new javax.swing.JPanel();
        pnl_Form = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        txt_Form_NomeMateria = new javax.swing.JTextField();
        txt_Form_DescTarefa = new javax.swing.JTextField();
        dt_Form_Prazo = new com.github.lgooddatepicker.components.DateTimePicker();
        btn_Form_AddTarefa = new javax.swing.JButton();
        pnl_Legenda = new javax.swing.JPanel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        img_Sabrino = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Pessoal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        sp_Grid.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnl_Grid.setPreferredSize(new java.awt.Dimension(1076, 0));

        javax.swing.GroupLayout pnl_GridLayout = new javax.swing.GroupLayout(pnl_Grid);
        pnl_Grid.setLayout(pnl_GridLayout);
        pnl_GridLayout.setHorizontalGroup(
            pnl_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        pnl_GridLayout.setVerticalGroup(
            pnl_GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        sp_Grid.setViewportView(pnl_Grid);

        pnl_Form.setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar Tarefa"));
        pnl_Form.setPreferredSize(new java.awt.Dimension(380, 163));

        lbl1.setText("Matéria:");

        lbl2.setText("Descrição da Tarefa:");

        lbl3.setText("Prazo:");

        txt_Form_NomeMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Form_KeyPressed(evt);
            }
        });

        txt_Form_DescTarefa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Form_KeyPressed(evt);
            }
        });

        btn_Form_AddTarefa.setText("Adicionar");
        btn_Form_AddTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Form_AddTarefaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_FormLayout = new javax.swing.GroupLayout(pnl_Form);
        pnl_Form.setLayout(pnl_FormLayout);
        pnl_FormLayout.setHorizontalGroup(
            pnl_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_FormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_FormLayout.createSequentialGroup()
                        .addGroup(pnl_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl2)
                            .addComponent(lbl1)
                            .addComponent(lbl3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Form_DescTarefa)
                            .addComponent(txt_Form_NomeMateria)
                            .addComponent(dt_Form_Prazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_Form_AddTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        pnl_FormLayout.setVerticalGroup(
            pnl_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_FormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1)
                    .addComponent(txt_Form_NomeMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2)
                    .addComponent(txt_Form_DescTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl3)
                    .addComponent(dt_Form_Prazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Form_AddTarefa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Legenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Legenda"));

        lbl4.setText("Tarefa atrasada");
        lbl4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl4.setForeground(new java.awt.Color(85, 85, 85));

        lbl5.setText("Entre 0m e 3h restantes");
        lbl5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl5.setForeground(new java.awt.Color(189, 0, 0));

        lbl6.setText("Entre 3h e 6h restantes");
        lbl6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl6.setForeground(new java.awt.Color(234, 81, 81));

        lbl7.setText("Entre 6h e 12h restantes");
        lbl7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl7.setForeground(new java.awt.Color(225, 101, 18));

        lbl8.setText("Entre 12h e 24h restantes");
        lbl8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl8.setForeground(new java.awt.Color(203, 168, 60));

        lbl9.setText("Entre 24h e 48h restantes");
        lbl9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl9.setForeground(new java.awt.Color(133, 210, 58));

        lbl10.setText("Acima de 48h restantes");
        lbl10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl10.setForeground(new java.awt.Color(79, 154, 62));

        javax.swing.GroupLayout pnl_LegendaLayout = new javax.swing.GroupLayout(pnl_Legenda);
        pnl_Legenda.setLayout(pnl_LegendaLayout);
        pnl_LegendaLayout.setHorizontalGroup(
            pnl_LegendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_LegendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_LegendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl4)
                    .addComponent(lbl5)
                    .addComponent(lbl6)
                    .addComponent(lbl7)
                    .addComponent(lbl8)
                    .addComponent(lbl9)
                    .addComponent(lbl10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_LegendaLayout.setVerticalGroup(
            pnl_LegendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_LegendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        img_Sabrino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ifsp/projetologica/sabrino.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sp_Grid, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_Form, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(img_Sabrino)
                        .addGap(9, 9, 9)
                        .addComponent(pnl_Legenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp_Grid, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_Form, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(img_Sabrino)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_Legenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Coloca um ícone para a janela.
        try {
            setIconImage(ImageIO.read(getClass().getResource("/com/ifsp/projetologica/sabrino.png")));
        }
        catch(Exception e) { }

        // Esconde o scrollbar porém não o desabilita. Apenas alteração
        // estética.
        sp_Grid.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        sp_Grid.revalidate();
        sp_Grid.repaint();
        
        // Acelera um pouco o scroll.
        sp_Grid.getVerticalScrollBar().setUnitIncrement(15);
        
        // dt_Form_Prazo é um plugin do NetBeans. É utilizado para
        // escolher intuitiva e graficamente a data e o horário
        // de entrega. O arquivo está em raíz/plugins/LGoodDatePicker-11.1.0.jar
        dt_Form_Prazo.datePicker.setDateToToday();
        
        // Por padrão, define o tempo limite para quase meia noite
        // (horário usado pela maioria dos professores do curso TINFO).
        dt_Form_Prazo.timePicker.setTime(
            LocalTime.parse(
                "23:59",
                DateTimeFormatter.ofPattern(Tarefa.TIME_PATTERN)
            )
        );
        
        updateGrid();
        
        // Atualiza o tempo restante cada MULT_MINUTOS.
        int MULT_MINUTOS = 1;
        updateTimeLeft = new Timer(60000 * MULT_MINUTOS, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Pega todos os cards de tarefa
                    Component[] components = pnl_Grid.getComponents();
                    JPanel[] cards = new JPanel[components.length];
                    for(int i = 0; i < components.length; i++)
                        cards[i] = (JPanel)components[i];

                    // Para cada card...
                    for(int i = 0; i < cards.length; i++) {
                        JPanel c = cards[i];
                        // ...a gente atualiza a cor para representar o tempo
                        // restante e, além disso, atualiza o texto referente ao
                        // tempo que falta para a entrega.
                        Tarefa t = tarefas.get(i);
                        c.setBorder(
                            BorderFactory.createLineBorder(
                                t.obterCor(),               // Cor
                                CardFactory.BORDER_WIDTH,   // Espessura
                                false                       // Arredondada?
                            )
                        );
                        // O terceiro componente do card
                        // é a JLabel do tempo restante.
                        ((JLabel)c.getComponent(3)).setText(t.tempoRestanteStr());
                    }
                }
                catch(Exception e) {
                    System.out.println("Algo de errado aconteceu ao atualizar os horários. Exceção: " + e);
                }
            }
        });
        updateTimeLeft.start();
    }//GEN-LAST:event_formWindowOpened

    // Quando clicar no botão de adicionar tarefa...
    private void btn_Form_AddTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Form_AddTarefaActionPerformed
        String materia = txt_Form_NomeMateria.getText();
        String descricao = txt_Form_DescTarefa.getText();
        
        // ...a gente faz umas verificações para evitar tarefas sem matéria
        // ou sem descrição.
        if(materia.length() == 0) {
            JOptionPane.showMessageDialog(
                null,
                "A matéria não pode ficar em branco!",
                "Oops!", 0, UIManager.getIcon("OptionPane.warningIcon")
            );
            return;
        }
        
        if(descricao.length() == 0) {
            JOptionPane.showMessageDialog(
                null,
                "A descrição não pode ficar em branco!",
                "Oops!", 0, UIManager.getIcon("OptionPane.warningIcon")
            );
            return;
        }
        
        /*
            Perceba que não validamos o formato da data de entrega,
            somente a distância temporal (se for uma tarefa para daqui
            10 anos, ou para 10 anos atrasados, seria ridículo).
            O plugin do picker de data/hora já valida o formato,
            ele não atualiza o valor interno da data nem do
            horário se for inválido.
        */
        LocalDate data_prazo = dt_Form_Prazo.datePicker.getDate();
        
        // Vai que hoje é 31/12 e amanhã é 01/01, então abrimos
        // uma brecha para tarefa para o ano que vem.
        if(data_prazo.getYear() > LocalDate.now().getYear() + 1) {
            JOptionPane.showMessageDialog(
                null,
                "Especifique uma data de entrega válida.",
                "Oops!", 0, UIManager.getIcon("OptionPane.warningIcon")
            );
            return;
        }
        
        // Idem para tarefa do ano passado, vai que era para ser entregue
        // dia 31/12 e hoje é 01/01. Abrimos uma brecha para o ano anterior.
        if(data_prazo.getYear() < LocalDate.now().getYear() - 1) {
            JOptionPane.showMessageDialog(
                null,
                "Especifique uma data de entrega válida.",
                "Oops!", 0, UIManager.getIcon("OptionPane.warningIcon")
            );
            return;
        }
        
        LocalTime hora_prazo = dt_Form_Prazo.timePicker.getTime();
        LocalDateTime dt_prazo = LocalDateTime.of(data_prazo, hora_prazo);
        
        Tarefa t = new Tarefa(materia, descricao, dt_prazo);
        tarefas.add(t);
        
        try {
            /*
                Adicionou? Então tenta salvar.
                Estamos fazendo isso cada vez que uma tarefa é
                adicionada. Daria para executar isso apenas quando o
                programa é fechado, mas se houver uma queda de energia
                não seria salvo.
            */
            Auxiliar.tarefasToJSON(tarefas);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Houve um erro ao salvar as tarefas!\n" + e.toString(),
                "Oops!", 0, UIManager.getIcon("OptionPane.errorIcon")
            );
        }
        
        // Atualiza o grid dos cards de tarefa.
        updateGrid();
    }//GEN-LAST:event_btn_Form_AddTarefaActionPerformed

    // Limita o comprimento dos campos de matéria e descrição da tarefa.
    private void txt_Form_KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Form_KeyPressed
        JTextField caller = (JTextField)evt.getComponent();
        String txt = caller.getText();
        if(txt.length() >= 32)
            caller.setText(txt.substring(0, 31));
    }//GEN-LAST:event_txt_Form_KeyPressed

    public void updateGrid() {
        // Precisa do try por causa da biblioteca de JSON,
        // que obriga a existência de um try/catch durante
        // a leitura/escrita do arquivo. Isso reflete até aqui!
        try {
            // Deleta todas as cards porque serão reordenadas.
            pnl_Grid.removeAll();
            
            /*
                Demoramos para chegar nessa fórmula mas vamos lá, vou explicar.
                O grid tem uma margem X = margem Y (MARGIN). Isso é só para
                deixar bonito. Além disso, queremos espaçar igualmente cada
                card para ficar esteticamente amigável. Tendo o tamanho de cada
                card (nesse caso, 300px que é coincidentemente o tamanho mínimo
                para 32 caracteres de matéria e/ou descrição), conseguimos
                calcular esse espaçamento horizontal (o vertical é constante).
            
                Nós sempre temos (N - 1) espaçamentos, sendo N a quantidade
                de cards por linha do grid (definimos como 3 abaixo).
                Isso faz sentido:
                [CARD] [espaço] [CARD] [espaço] [CARD].
                Mas quanto vale esse espaço? Bom, pegamos o tamanho do
                contêiner dos cards (que nesse caso é sp_Grid, um JScrollPane)
                e subtraímos 4 porque Java Swing é idiota e nos dá o valor
                com 4px extras. Subtraindo duas margens disso, temos o espaço
                utilizável em cada linha do grid (leia contêiner).
                Do espaço utilizável, temos que subtrair o width de cada card
                que ocupar a linha, então subtraimos width * cards_por_linha.
                No fim, teremos um valor que é a soma de cada espaçamento
                horizontal. Lembra do (N - 1) ali em cima? Então, dividimos
                essa soma por N - 1 e temos o tamanho de cada espaçamento
                horizontal por linha do nosso grid.
            */
            final int MARGIN = 10;
            final int GAP_Y = 10;
            final int MAX_CARDS_PER_ROW = 3;
            final int CARD_WIDTH = 300;
            final int PANEL_WIDTH = sp_Grid.getWidth() - 4;
            final int GAP_X = (int)(
                (PANEL_WIDTH - 2 * MARGIN - MAX_CARDS_PER_ROW * CARD_WIDTH)
                / (MAX_CARDS_PER_ROW - 1)
            );
            
            // Lemos o arquivo de tarefas e ordenamos. A classe Tarefa.java
            // implementa um comparador próprio (veja o comentário no
            // começo do arquivo) que nos ajudará na ordenação por prioridade
            // de entrega, do menor tempo restante até o maior tempo restante.
            tarefas = Auxiliar.tarefasFromJSON();
            Collections.sort(tarefas);
            
            // Para cada tarefa, criamos um card.
            for(int i = 0; i < tarefas.size(); i++) {
                Tarefa t = tarefas.get(i);
                // Veja a classe CardFactory.java
                // para entender o que é e como funciona.
                JPanel card = CardFactory.criarCardTarefa(this, CARD_WIDTH, t, i);
                card.setSize(CARD_WIDTH, CardFactory.calcHeight());
                // Posiciona no nosso grid com o espaçamento calculado.
                // i % MAX_CARDS_PER_ROW junto de (int)(i / MAX_CARDS_PER_ROW)
                // transforma o índice 1D "i" em um índice 2D. Isso é usado
                // para achar a linha e a coluna desse card no grid.
                card.setLocation(
                    MARGIN + ((i % MAX_CARDS_PER_ROW) * (CARD_WIDTH + GAP_X)),
                    MARGIN + ((int)(i / MAX_CARDS_PER_ROW) * (CardFactory.calcHeight() + GAP_Y))
                );
                pnl_Grid.add(card);
            }
            
            // Ajusta o tamanho do pnl_Grid para o JScrollPane não cortar,
            // mostrando todos os cards e deixando scrollar até o último.
            Component[] comps = pnl_Grid.getComponents();
            if(comps.length > 0) {
                pnl_Grid.setMinimumSize(
                    new Dimension(
                        pnl_Grid.getMinimumSize().width,
                        comps[comps.length - 1].getY() + comps[comps.length - 1].getHeight() + MARGIN
                    )
                );
                pnl_Grid.setMaximumSize(pnl_Grid.getMinimumSize());
                pnl_Grid.setSize(pnl_Grid.getMinimumSize());
                pnl_Grid.setPreferredSize(pnl_Grid.getMinimumSize());
            }
            
            // Força uma renderização do grid.
            pnl_Grid.revalidate();
            pnl_Grid.repaint();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Oops! Algo deu errado:\n" + e.getMessage());
        }
    }
    
    // Esse idx é o índice da tarefa no nosso ArrayList `tarefas`.
    public static void removerTarefa(int idx) {
        try {
            tarefas.remove(idx);
            Auxiliar.tarefasToJSON(tarefas);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Houve um erro ao deletar tarefa!\n" + e.toString(),
                "Oops!", 0, UIManager.getIcon("OptionPane.errorIcon")
            );
        }
    }

    // Coisa chata (e ao mesmo tempo legal) que o NetBeans gerou :)
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Form_AddTarefa;
    private com.github.lgooddatepicker.components.DateTimePicker dt_Form_Prazo;
    private javax.swing.JLabel img_Sabrino;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JPanel pnl_Form;
    private javax.swing.JPanel pnl_Grid;
    private javax.swing.JPanel pnl_Legenda;
    private javax.swing.JScrollPane sp_Grid;
    private javax.swing.JTextField txt_Form_DescTarefa;
    private javax.swing.JTextField txt_Form_NomeMateria;
    // End of variables declaration//GEN-END:variables
}

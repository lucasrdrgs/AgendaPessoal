package com.ifsp.projetologica;
import java.awt.Color;
import static java.lang.Math.abs;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Classe que define as tarefas.
// Implementa um comparador para ver qual tarefa
// está mais próxima da data de entrega.
// Isso será usado na ordenação de tarefas para
// mostrar qual tem maior prioridade de realização.
public class Tarefa implements Comparable<Tarefa> {
    // Padrões que usamos no Brasil para lidar com datas e horários.
    public static final String TIME_PATTERN = "HH:mm";
    public static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm";
    
    /*
        O Map<> abaixo representa qual cor um card de tarefa terá dependendo
        do tempo restante para entregar a tarefa.
    
        Qualquer valor menor que 0 minutos: cinza, atrasou!
        Qualquer valor entre 0 minutos e 3 horas: vermelho escuro, faz logo!
        Qualquer valor entre 3 e 6 horas: vermelho claro, tá perigoso!
        Qualquer valor entre 12 e 6 horas: laranja, tá ficando perigoso!
        E assim por diante.
    */    
    public static Map<Integer, String> PrazoCor = new TreeMap<Integer, String>() {
        {
            put(0, "#555555");                  // Atrasada: cinza escuro
            put(3 * 60, "#BD0000");             // 3h: Vermelho escuro
            put(6 * 60, "#EA5151");             // 6h: Vermelho mais claro
            put(12 * 60, "#E16512");            // 12h: Laranja
            put(24 * 60, "#F6D15E");            // 24h: Amarelo
            put(48 * 60, "#BEFB83");            // 48h: Verde claro
            put(Integer.MAX_VALUE, "#6CC758");  // Acima de 48h: Verde normal
        }
    };
    
    public String Descricao;
    public String Materia;
    public LocalDateTime Prazo;
    
    public Tarefa(String materia, String desc, LocalDateTime prazo) {
        Descricao = desc;
        Materia = materia;
        Prazo = prazo;
    }
    
    // Construtor alternativo para criar uma tarefa com o prazo
    // dado em String no formato DATETIME_PATTERN
    public Tarefa(String materia, String desc, String prazoStr) {
        Descricao = desc;
        Materia = materia;
        Prazo = LocalDateTime.parse(
            prazoStr,
            DateTimeFormatter.ofPattern(DATETIME_PATTERN)
        );
    }
    
    public String tempoRestanteStr() {
        String r = "";
        int mins = minutosRestantes();
        int dias = (int)(mins / 1440); // 24h em minutos
        int horas = (int)((mins % 1440) / 60);
        int minutos = (mins % 1440) % 60;
        
        dias = abs(dias);
        horas = abs(horas);
        minutos = abs(minutos);
        
        if(dias > 0) {
            r = String.format("%dd %dh %dm", dias, horas, minutos);
        }
        else if(horas > 0) {
            r = String.format("%dh %dm", horas, minutos);
        }
        else {
            r = String.format("%dm", minutos);
        }        
        
        if(mins < 0) {
            r = "Tarefa atrasada em " + r + "!";
        }
        else {
            r += " restantes";
        }
        return r;
    }
    
    // Transforma nosso Prazo de LocalDateTime para uma string no formato
    // DATETIME_PATTERN.
    public String prazoString() {
        return Prazo.format(DateTimeFormatter.ofPattern(DATETIME_PATTERN));
    }
    
    // Calcula a diferença absoluta entre agora e o prazo da tarefa
    // em minutos.
    public int minutosRestantes() {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime tmp_p = Prazo.minusMinutes(1); // Prazo exclusivo: para de aceitar envios em Prazo.
        int minutos = (int)agora.until(tmp_p, ChronoUnit.MINUTES);
        if(minutos == 0);
        return minutos;
    }
    
    // Pega uma cor que se refere ao tempo que falta para a entrega
    // da tarefa.
    public Color obterCor() {
        int mins = minutosRestantes();
        
        /*
            Observe que faz uma varredura sequencial do nosso TreeMap
            (TreeMap justamente para não bagunçar a ordem das chaves).
            Ou seja, o primeiro valor que atender a condição terá
            sua cor retornada.
        */
        for(Map.Entry<Integer, String> par : PrazoCor.entrySet()) {
            if(mins < par.getKey()) {
                return Color.decode(par.getValue());
            }
        }
        return Color.decode("#FFFFFF");
    }
    
    @Override
    public int compareTo(Tarefa t) {
        return ((Integer)minutosRestantes())
                .compareTo((Integer)t.minutosRestantes());
    }
}

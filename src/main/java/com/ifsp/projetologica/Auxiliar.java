/*
    Classe auxiliar que vai lidar com o arquivo de
    escrita/leitura contendo as tarefas salvas.

    AVISO: AINDA NÃO FOI TESTADO EM SISTEMAS UNIX (19/01/2021).
*/

package com.ifsp.projetologica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.json.*;

public final class Auxiliar {
    
    public static String getCfgPath() {
        String fName = "agenda_pessoal.json";
        if(System.getProperty("os.name").toLowerCase().contains("win")) {
            return System.getenv("APPDATA") + "/" + fName;
        }
        else {
            return System.getProperty("user.home") + "/.config/" + fName;
        }
    }

    public static void createCfgIfNotExists(String path) throws Exception {
        File f = new File(path);
        if(!f.exists()) {
            f.createNewFile();
        }
    }
    
    // Lê as tarefas de um arquivo JSON, guarda numa ArrayList
    // e retorna.
    public static ArrayList<Tarefa> tarefasFromJSON() throws Exception {
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        // Garante a existência do arquivo com as tarefas.
        String config_file = getCfgPath();
        createCfgIfNotExists(config_file);
        // Lê o JSON do arquivo.
        String json_content = Files.readString(Path.of(config_file));
        
        // Esse try vai tentar fazer o parse do JSON do arquivo.
        // Se falhar (JSON inválido), o objeto JSON será um parse
        // de {"tarefas": []}, ou seja, nenhuma tarefa.
        JSONObject jo;
        try {
            jo = new JSONObject(json_content);
        }
        catch(Exception e) {
            json_content = "{\"tarefas\":[]}";
            jo = new JSONObject(json_content);
        }
        // Pega o array "tarefas" do arquivo JSON e...
        JSONArray array_tarefas = jo.getJSONArray("tarefas");
        // ...para cada tarefa, criamos um objeto instância da classe
        // Tarefa.java.
        for(int i = 0; i < array_tarefas.length(); i++) {
            JSONObject entry = array_tarefas.getJSONObject(i);
            Tarefa t = new Tarefa(
                entry.getString("subject"),     // Matéria
                entry.getString("description"), // Descrição
                entry.getString("deadline")     // Prazo em string
            );
            tarefas.add(t);
        }
        return tarefas;
    }
    
    // Salva as tarefas no arquivo JSON.
    public static boolean tarefasToJSON(ArrayList<Tarefa> tarefas) throws Exception {
        String config_file = getCfgPath();
        createCfgIfNotExists(config_file);
        
        // Codifica a lista de tarefas para JSON.
        JSONObject json = new JSONObject();
        JSONArray json_array = new JSONArray();
        for(Tarefa t : tarefas) {
            JSONObject tarefa_obj = new JSONObject();
            tarefa_obj.put("subject", t.Materia);
            tarefa_obj.put("description", t.Descricao);
            tarefa_obj.put("deadline", t.prazoString());
            json_array.put(tarefa_obj);
        }
        json.put("tarefas", json_array);
        
        try {
            // Esse try só vai jogar uma exceção se o salvamento
            // fracassar.
            File f = new File(config_file);
            
            // Salva como UTF_8 porque Unicode é incrível
            OutputStreamWriter fw = new OutputStreamWriter(
                new FileOutputStream(f),
                StandardCharsets.UTF_8
            );
            
            fw.write(json.toString());
            fw.flush();
            fw.close();
            
            // Deu certo!
            return true;
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Houve um erro ao salvar as tarefas!\n" + e.toString(),
                "Oops!", 0, UIManager.getIcon("OptionPane.errorIcon")
            );
            
            // Deu errado!
            return false;
        }
    }
}

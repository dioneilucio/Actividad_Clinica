/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

/**
 *
 * @author dioneilucio
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paciente {
    public List<String> pacientes = new ArrayList<>();
    private String archivoTxt = "Pacientes.txt";
    private File archivo = new File(archivoTxt);
    private List<String> id = new ArrayList<>();
    private int c = 0;

    public void guardar(String nombre){
        if (!archivo.exists()){
            crearArchivo();
        }else {
            cargarArchivo();
        }
        c = 1;
        
        pacientes.add(nombre);
        String lista = "";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTxt))){
            for (String aux : pacientes){
                lista = lista.concat(c + ";" + aux + ";\n");
                c++;
            }
            
            writer.write(lista);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
  
    public void crearArchivo(){
        try {
            archivo.createNewFile();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void cargarArchivo(){
        pacientes.clear();
        id.clear();
        String aux, str = "";
        int a = 1;
        
        try (BufferedReader buff = new BufferedReader(new FileReader(archivoTxt))){
            while ((aux = buff.readLine()) != null){
                str = str.concat(aux);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        
        String[] tokens = str.split(";");
        
        for (int i = 0; i < tokens.length; i = i + 2) {
            id.add(tokens[i]);
            pacientes.add(tokens[a]);
            a = a + 2;
        }
    }
}


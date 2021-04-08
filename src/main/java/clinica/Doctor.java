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

public class Doctor {
    public HashMap<String, String> doctores = new HashMap<>();
    private String archivoTxt = "Doctores.txt";
    private File archivo = new File(archivoTxt);
    private List<String> id = new ArrayList<>();
    private int c = 0;

    public void guardar(String nombre, String especialidad){
        if (!archivo.exists()){
            crearArchivo();
        }else {
            cargarArchivo();
        }
        c = 1;
      
        doctores.put(nombre, especialidad);
        String lista = "";
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTxt))){
            for (Map.Entry<String, String> aux : doctores.entrySet()){
                lista = lista.concat(c + ";" + aux.getKey() + ";" + aux.getValue() + ";\n");
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
        doctores.clear();
        id.clear();
        String aux, str = "";
        int a = 1, b = 2;
        
        try (BufferedReader buff = new BufferedReader(new FileReader(archivoTxt))){
            while ((aux = buff.readLine()) != null){
                str = str.concat(aux);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        
        String[] tokens = str.split(";");
        
        for (int i = 0; i < tokens.length; i = i + 3) {
            id.add(tokens[i]);
            doctores.put(tokens[a], tokens[b]);
            a = a + 3;
            b = b + 3;
        }
    }
}

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

public class Cita {
    public HashMap<String, String> citasFecha = new HashMap<>();
    public HashMap<String, String> citasActores = new HashMap<>();
    private String archivoTxt = "Citas.txt";
    private File archivo = new File(archivoTxt);
    private List<String> id = new ArrayList<>();
    private int c = 0;

    public void guardar(String fecha, String motivo, String paciente, String doctor){
        if (!archivo.exists()){
            crearArchivo();
        }else {
            cargarArchivo();
        }
        c = 1;
        int z = 1;
        
        citasActores.put(paciente, doctor);
        citasFecha.put(fecha, motivo);
        List<String> fechas = new ArrayList<>();
        List<String> actores = new ArrayList<>();
        String lista = "";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTxt))){
            for (Map.Entry<String, String> aux : citasFecha.entrySet()){
                fechas.add(aux.getKey());
                fechas.add(aux.getValue());
            }
            for (Map.Entry<String, String> aux2 : citasActores.entrySet()){
                actores.add(aux2.getKey());
                actores.add(aux2.getValue());
            }
            for (int i = 0; i < fechas.size(); i = i + 2){
                lista = lista.concat(c + ";" + fechas.get(i) + ";" + fechas.get(z) + ";" + actores.get(i) + ";" + actores.get(z) + ";\n");
                c++;
                z = z + 2;
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
        String aux, str = "";
        int a = 1, b = 2, d = 3, f = 4;
        
        try (BufferedReader buff = new BufferedReader(new FileReader(archivoTxt))){
            while ((aux = buff.readLine()) != null){
                str = str.concat(aux);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    
        String[] tokens = str.split(";");
        
        for (int i = 0; i < tokens.length; i = i + 5) {
            id.add(tokens[i]);
            citasFecha.put(tokens[a], tokens[b]);
            citasActores.put(tokens[d], tokens[f]);
            a = a + 5;
            b = b + 5;
            d = d + 5;
            f = f + 5;
        }
    }
    public void mostrarCitas(){
        String aux, str = "";
        int x = 0;
        
        try (BufferedReader buff = new BufferedReader(new FileReader(archivoTxt))){
            while ((aux = buff.readLine()) != null){
                str = str.concat(aux);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] tokens = str.split(";");
        for (String string : tokens){
            System.out.print(string + ", ");
            x++;
            if (x == 5){
                System.out.print("\n");
                x = 0;
            }
        }
    }
}


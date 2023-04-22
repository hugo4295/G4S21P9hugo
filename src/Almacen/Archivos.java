/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Informacion.DatosDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GAARA
 */
public class Archivos {
    
    public void Grabar(String nombre, int edad,String Correo){
        try {        
            FileWriter archivo = new FileWriter("archivo.txt",true);
            BufferedWriter contenido= new BufferedWriter(archivo);
            contenido.write(nombre + "," + String.valueOf(edad) + "," + Correo+"\n");
            contenido.close();
            archivo.close();
                    
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    public List<DatosDTO> Leer(){
        String linea;
        List<DatosDTO> lista = new ArrayList<DatosDTO>();
        DatosDTO datosDTO;
        try {
            FileReader archivo = new FileReader("archivo.txt");
            BufferedReader lectura = new BufferedReader(archivo);
            while((linea = lectura.readLine()) != null){
                String[] cadena = linea.split(",");
                datosDTO = new DatosDTO(cadena[0], Integer.parseInt(cadena[1]), cadena[2]);
                lista.add(datosDTO);
            
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
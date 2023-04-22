package Almacen;

import Informacion.DatosDTO;
import com.sun.corba.se.impl.encoding.BufferManagerWrite;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACBaljeet
 */
public class Archivos {
    
    public void Grabar(String nombre, int edad, String correo){
        try {
            FileWriter archivo = new FileWriter("archivo.txt",true);
            BufferedWriter contenido = new BufferedWriter(archivo);
            contenido.write(nombre + "," + String.valueOf(edad) + "," + correo + "\n");
            contenido.close();
            archivo.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public List<DatosDTO>Leer(){
        
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
                JOptionPane.showMessageDialog(null,"contenido nombre: " + cadena[0]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }return lista;
        
    }
    
}
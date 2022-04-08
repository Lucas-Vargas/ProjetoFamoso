/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class BdFamoso {

    public ArrayList<String> ListaFamosos;
    public ArrayList<String> ListaFamososAlfabetica;

    public BdFamoso() {
        ListaFamosos = new ArrayList();
        ListaFamososAlfabetica = new ArrayList();

    }

    public void save(String famoso) {
        ListaFamososAlfabetica.add(famoso.toUpperCase());
        ListaFamosos.add(famoso.toUpperCase());
        JOptionPane.showMessageDialog(null, "o famoso " + famoso
                + " foi salvo com sucesso!");

    }

    public boolean temEspaco(String famoso){
        boolean espaco;
        String[] in = famoso.split(" ");
       if(in.length==1){
           espaco = false;
           
       }else{
           espaco=true;
       }
            return espaco;
    }
    
    public String toString() {
        String result = "lista de Famosos \n";
        if (!ListaFamosos.isEmpty()) {
            for (int i = 0; i < ListaFamosos.size(); i++) {
                result += ListaFamosos.get(i) + "\n";
            }
        } else {
            result = "A base de dados encontra-se vazia!";
        }
        return result;
    }

    public String toStringAlfabetico() {
        String result = "lista de Famosos \n";
        if (!ListaFamososAlfabetica.isEmpty()) {
            Collections.sort(ListaFamososAlfabetica);
            for (int i = 0; i < ListaFamososAlfabetica.size(); i++) {
                result += ListaFamososAlfabetica.get(i) + "\n";
            }
        } else {
            result = "A base de dados encontra-se vazia!";
        }
        return result;
    }

    public void reset() {
        ListaFamosos.clear();
        ListaFamososAlfabetica.clear();

    }

    public int getSize() {
        return ListaFamosos.size();

    }

    public String getFamoso(int i) {
        String r = "";
        if (i >= 0) {
            r = ListaFamosos.get(i);
        } else {

            r = "Famoso não existe!";
        }

        return r;

    }

    public void delete(int i,int iAlfabetico) {
        if (i != -1) {
            ListaFamosos.remove(i);
            ListaFamososAlfabetica.remove(iAlfabetico);
        } else {
            JOptionPane.showMessageDialog(null, "Famoso não existe!");
        }
    }

   
    
    public int search(String famoso) {
        boolean achou = false;
        int i = 0, r = -1;
        while (i < ListaFamosos.size() && !achou) {
            if (ListaFamosos.get(i).equals(famoso)) {
                r = i;
                achou = true;
            }
            i++;
        }
        return r;
    }

    public int searchAlfabetico(String famoso) {
        boolean achou = false;
        int i = 0, r = -1;
        while (i < ListaFamososAlfabetica.size() && !achou) {
            if (ListaFamososAlfabetica.get(i).equals(famoso)) {
                r = i;
                achou = true;
            }
            i++;
        }
        return r;
    }

    
    public void update(int i ,int iAlfabetico, String update) {
        if (i != -1 || update.length() > 0){
            ListaFamosos.set(i, update.toUpperCase());
            ListaFamososAlfabetica.set(iAlfabetico, update.toUpperCase());
            JOptionPane.showMessageDialog(null, "Nome modificado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Famoso não foi modifica\n" +
"            JOptiodo!");
        }
    }
    
  

}

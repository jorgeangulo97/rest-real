/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.models;

import java.util.Objects;

/**
 *
 * @author angulo.jorge
 */
public class Argazkia {
    private String argazkia;

    /**
     *Argazkia klasearen konstruktorea
     */
    public Argazkia() {
        
    }

    /**
     *
     * @param argazkia argazkiaren izena 
     */
    public Argazkia(String argazkia) {
        this.argazkia = argazkia;
    }

    /**
     *
     * @return argazkiaren izena 
     */
    public String getArgazkia() {
        return argazkia;
    }

    /**
     *
     * @param argazkia argazkiaren izena 
     */
    public void setArgazkia(String argazkia) {
        this.argazkia = argazkia;
    }

    /**
     *
     * @return 
     */
    @Override
    public String toString() {
        return "Argazkia{" + "argazkia=" + argazkia + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(argazkia);
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Argazkia arg = (Argazkia) obj;
        return Objects.equals(argazkia, arg.argazkia);
        
    }      
}

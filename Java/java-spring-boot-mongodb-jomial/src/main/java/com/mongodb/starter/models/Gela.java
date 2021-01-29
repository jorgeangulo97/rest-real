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
public class Gela {
    
    private int gela;
    private String tamaina;
    private double kostuGaua;

    /**
     *Gela klasearen konstruktorea
     */
    public Gela() {
    }

    /**
     *
     * @param gela gelaren zenbakia
     * @param tamaina gelaren tamainaren informazioa
     * @param kostuGaua gelaren gau bateko kostua
     */
    public Gela(int gela, String tamaina, double kostuGaua) {
        this.gela = gela;
        this.tamaina = tamaina;
        this.kostuGaua = kostuGaua;
    }

    /**
     *
     * @return gelaren zenbakia
     */
    public int getGela() {
        return gela;
    }

    /**
     *
     * @param gela gelaren zenbakia
     */
    public void setGela(int gela) {
        this.gela = gela;
    }

    /**
     *
     * @return gelaren tamainaren informazioa
     */
    public String getTamaina() {
        return tamaina;
    }

    /**
     *
     * @param tamaina gelaren tamainaren informazioa
     */
    public void setTamaina(String tamaina) {
        this.tamaina = tamaina;
    }

    /**
     *
     * @return gelaren gau bateko kostua
     */
    public double getKostuGaua() {
        return kostuGaua;
    }

    /**
     *
     * @param kostuGaua gelaren gau bateko kostua
     */
    public void setKostuGaua(double kostuGaua) {
        this.kostuGaua = kostuGaua;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Gela{" + "gela=" + gela + ", tamaina=" + tamaina + ", kostuGaua=" + kostuGaua + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(gela, tamaina, kostuGaua);
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gela other = (Gela) obj;
        if (this.gela != other.gela) {
            return false;
        }
        if (Double.doubleToLongBits(this.kostuGaua) != Double.doubleToLongBits(other.kostuGaua)) {
            return false;
        }
        if (!Objects.equals(this.tamaina, other.tamaina)) {
            return false;
        }
        return true;
    }
 
}

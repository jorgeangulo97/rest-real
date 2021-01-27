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

    public Gela() {
    }

    public Gela(int gela, String tamaina, double kostuGaua) {
        this.gela = gela;
        this.tamaina = tamaina;
        this.kostuGaua = kostuGaua;
    }

    public int getGela() {
        return gela;
    }

    public void setGela(int gela) {
        this.gela = gela;
    }

    public String getTamaina() {
        return tamaina;
    }

    public void setTamaina(String tamaina) {
        this.tamaina = tamaina;
    }

    public double getKostuGaua() {
        return kostuGaua;
    }

    public void setKostuGaua(double kostuGaua) {
        this.kostuGaua = kostuGaua;
    }

    @Override
    public String toString() {
        return "Gela{" + "gela=" + gela + ", tamaina=" + tamaina + ", kostuGaua=" + kostuGaua + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(gela, tamaina, kostuGaua);
    }

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

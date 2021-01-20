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
public class Zerbitzua {
    private String zerbitzua;

    public Zerbitzua() {
    }

    public Zerbitzua(String zerbitzua) {
        this.zerbitzua = zerbitzua;
    }

    public String getZerbitzua() {
        return zerbitzua;
    }

    public void setZerbitzua(String zerbitzua) {
        this.zerbitzua = zerbitzua;
    }

    @Override
    public String toString() {
        return "Zerbitzuak{" + "zerbitzua=" + zerbitzua + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(zerbitzua);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Zerbitzua zerbitzu = (Zerbitzua) obj;
        return Objects.equals(zerbitzua, zerbitzu.zerbitzua);
    }
}


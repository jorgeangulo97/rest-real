/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author angulo.jorge
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Erabiltzailea{

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId erabiltzailea_id;
    private String izena;
    private String abizena;
    private String emaila;
    private String erabiltzailea;
    private String pasahitza;

    /**
     *
     */
    public Erabiltzailea() {
    }

    /**
     *
     * @param erabiltzailea_id
     * @param izena
     * @param abizena
     * @param emaila
     * @param erabiltzailea
     * @param pasahitza
     */
    public Erabiltzailea(ObjectId erabiltzailea_id, String izena, String abizena, String emaila, String erabiltzailea, String pasahitza) {
        this.erabiltzailea_id = erabiltzailea_id;
        this.izena = izena;
        this.abizena = abizena;
        this.emaila = emaila;
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
    }

    /**
     *
     * @return
     */
    public ObjectId getErabiltzailea_id() {
        return erabiltzailea_id;
    }

    /**
     *
     * @param erabiltzailea_id
     */
    public void setErabiltzailea_id(ObjectId erabiltzailea_id) {
        this.erabiltzailea_id = erabiltzailea_id;
    }

    /**
     *
     * @return
     */
    public String getIzena() {
        return izena;
    }

    /**
     *
     * @param izena
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     *
     * @return
     */
    public String getAbizena() {
        return abizena;
    }

    /**
     *
     * @param abizena
     */
    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    /**
     *
     * @return
     */
    public String getEmaila() {
        return emaila;
    }

    /**
     *
     * @param emaila
     */
    public void setEmaila(String emaila) {
        this.emaila = emaila;
    }

    /**
     *
     * @return
     */
    public String getErabiltzailea() {
        return erabiltzailea;
    }

    /**
     *
     * @param erabiltzailea
     */
    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    /**
     *
     * @return
     */
    public String getPasahitza() {
        return pasahitza;
    }

    /**
     *
     * @param pasahitza
     */
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Erabiltzailea{" + "erabiltzailea_id=" + erabiltzailea_id + ", izena=" + izena + ", abizena=" + abizena + ", emaila=" + emaila + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + '}';
    }
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(erabiltzailea_id, izena, abizena, emaila, erabiltzailea, pasahitza);
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
        final Erabiltzailea other = (Erabiltzailea) obj;
        if (!Objects.equals(this.izena, other.izena)) {
            return false;
        }
        if (!Objects.equals(this.abizena, other.abizena)) {
            return false;
        }
        if (!Objects.equals(this.emaila, other.emaila)) {
            return false;
        }
        if (!Objects.equals(this.erabiltzailea, other.erabiltzailea)) {
            return false;
        }
        if (!Objects.equals(this.pasahitza, other.pasahitza)) {
            return false;
        }
        if (!Objects.equals(this.erabiltzailea_id, other.erabiltzailea_id)) {
            return false;
        }
        return true;
    }
}

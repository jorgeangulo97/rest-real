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
public class Errenta{

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String hasiera_data;
    private String amaiera_data;
    private String hotel_izena;
    private int gela;
    private double prezio_total;
    private String emaila;
    private int txartel_zenbakia;
    private String txartel_titularra;
    private String txartel_iraunginpena;
    private int txartel_cvv;

    /**
     *Errenta klasearen konstruktorea
     */
    public Errenta() {
    }

    /**
     *
     * @param id errentaren id-a
     * @param hasiera_data noiz hasten den errenta
     * @param amaiera_data noiz amaitzen den errenta
     * @param hotel_izena alokatzen den hotelaren izena
     * @param gela alokatzen den gela zenbakia
     * @param prezio_total errentaren prezio totala
     * @param emaila erretako erabiltzailearen emaila
     * @param txartel_zenbakia erabiltzailearen txartel zenbakia
     * @param txartel_titularra erabiltzailearen txartelaren titularra
     * @param txartel_iraunginpena erabiltzailearen txartelaren iraunginpena
     * @param txartel_cvv erabiltzailearen txartelaren cvv
     */
    public Errenta(ObjectId id, String hasiera_data, String amaiera_data, String hotel_izena, int gela, double prezio_total, String emaila, int txartel_zenbakia, String txartel_titularra, String txartel_iraunginpena, int txartel_cvv) {
        this.id = id;
        this.hasiera_data = hasiera_data;
        this.amaiera_data = amaiera_data;
        this.hotel_izena = hotel_izena;
        this.gela = gela;
        this.prezio_total = prezio_total;
        this.emaila = emaila;
        this.txartel_zenbakia = txartel_zenbakia;
        this.txartel_titularra = txartel_titularra;
        this.txartel_iraunginpena = txartel_iraunginpena;
        this.txartel_cvv = txartel_cvv;
    }

    /**
     *
     * @return errentaren id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     *
     * @param id errentaren id
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     *
     * @return noiz hasten den errenta
     */
    public String getHasiera_data() {
        return hasiera_data;
    }

    /**
     *
     * @param hasiera_data noiz hasten den errenta
     */
    public void setHasiera_data(String hasiera_data) {
        this.hasiera_data = hasiera_data;
    }

    /**
     *
     * @return noiz amaitzen den errenta
     */
    public String getAmaiera_data() {
        return amaiera_data;
    }

    /**
     *
     * @param amaiera_data noiz amaitzen den errenta
     */
    public void setAmaiera_data(String amaiera_data) {
        this.amaiera_data = amaiera_data;
    }

    /**
     *
     * @return alokatzen den hotelaren izena
     */
    public String getHotel_izena() {
        return hotel_izena;
    }

    /**
     *
     * @param hotel_izena alokatzen den hotelaren izena
     */
    public void setHotel_izena(String hotel_izena) {
        this.hotel_izena = hotel_izena;
    }

    /**
     *
     * @return alokatzen den gela zenbakia
     */
    public int getGela() {
        return gela;
    }

    /**
     *
     * @param gela alokatzen den gela zenbakia
     */
    public void setGela(int gela) {
        this.gela = gela;
    }

    /**
     *
     * @return errentaren prezio totala
     */
    public double getPrezio_total() {
        return prezio_total;
    }

    /**
     *
     * @param prezio_total errentaren prezio totala
     */
    public void setPrezio_total(double prezio_total) {
        this.prezio_total = prezio_total;
    }

    /**
     *
     * @return errentaren erabiltzailearen emaila
     */
    public String getEmaila() {
        return emaila;
    }

    /**
     *
     * @param emaila errentaren erabiltzailearen emaila
     */
    public void setEmaila(String emaila) {
        this.emaila = emaila;
    }

    /**
     *
     * @return erabiltzailearen txartel zenbakia
     */
    public int getTxartel_zenbakia() {
        return txartel_zenbakia;
    }

    /**
     *
     * @param txartel_zenbakia erabiltzailearen txartel zenbakia
     */
    public void setTxartel_zenbakia(int txartel_zenbakia) {
        this.txartel_zenbakia = txartel_zenbakia;
    }

    /**
     *
     * @return erabiltzailearen txartelaren titularra
     */
    public String getTxartel_titularra() {
        return txartel_titularra;
    }

    /**
     *
     * @param txartel_titularra erabiltzailearen txartelaren titularra
     */
    public void setTxartel_titularra(String txartel_titularra) {
        this.txartel_titularra = txartel_titularra;
    }

    /**
     *
     * @return erabiltzailearen txartelaren iraunginpena
     */
    public String getTxartel_iraunginpena() {
        return txartel_iraunginpena;
    }

    /**
     *
     * @param txartel_iraunginpena erabiltzailearen txartelaren iraunginpena
     */
    public void setTxartel_iraunginpena(String txartel_iraunginpena) {
        this.txartel_iraunginpena = txartel_iraunginpena;
    }

    /**
     *
     * @return erabiltzailearen txartelaren cvv
     */
    public int getTxartel_cvv() {
        return txartel_cvv;
    }

    /**
     *
     * @param txartel_cvv erabiltzailearen txartelaren cvv
     */
    public void setTxartel_cvv(int txartel_cvv) {
        this.txartel_cvv = txartel_cvv;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Errenta{" + "errenta_id=" + id + ", hasiera_data=" + hasiera_data + ", amaiera_data=" + amaiera_data + ", hotel_izena=" + hotel_izena + ", gela=" + gela + ", prezio_total=" + prezio_total + ", erabiltzailea_emaila=" + emaila + ", txartel_zenbakia=" + txartel_zenbakia + ", txartel_titularra=" + txartel_titularra + ", txartel_iraunginpena=" + txartel_iraunginpena + ", txartel_cvv=" + txartel_cvv + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, hasiera_data, amaiera_data, hotel_izena, gela, prezio_total, emaila, txartel_zenbakia, txartel_titularra, txartel_iraunginpena, txartel_cvv);
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
        final Errenta other = (Errenta) obj;
        if (this.gela != other.gela) {
            return false;
        }
        if (Double.doubleToLongBits(this.prezio_total) != Double.doubleToLongBits(other.prezio_total)) {
            return false;
        }
        if (this.txartel_zenbakia != other.txartel_zenbakia) {
            return false;
        }
        if (this.txartel_cvv != other.txartel_cvv) {
            return false;
        }
        if (!Objects.equals(this.hasiera_data, other.hasiera_data)) {
            return false;
        }
        if (!Objects.equals(this.amaiera_data, other.amaiera_data)) {
            return false;
        }
        if (!Objects.equals(this.hotel_izena, other.hotel_izena)) {
            return false;
        }
        if (!Objects.equals(this.emaila, other.emaila)) {
            return false;
        }
        if (!Objects.equals(this.txartel_titularra, other.txartel_titularra)) {
            return false;
        }
        if (!Objects.equals(this.txartel_iraunginpena, other.txartel_iraunginpena)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
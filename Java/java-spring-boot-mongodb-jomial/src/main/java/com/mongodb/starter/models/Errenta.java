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
    private ObjectId errenta_id;
    private String hasiera_data;
    private String amaiera_data;
    private String hotel_izena;
    private int gela;
    private double prezio_total;
    private String erabiltzailea_emaila;
    private int txartel_zenbakia;
    private String txartel_titularra;
    private String txartel_iraunginpena;
    private int txartel_cvv;

    /**
     *
     */
    public Errenta() {
    }

    /**
     *
     * @param errenta_id
     * @param hasiera_data
     * @param amaiera_data
     * @param hotel_izena
     * @param gela
     * @param prezio_total
     * @param erabiltzailea_emaila
     * @param txartel_zenbakia
     * @param txartel_titularra
     * @param txartel_iraunginpena
     * @param txartel_cvv
     */
    public Errenta(ObjectId errenta_id, String hasiera_data, String amaiera_data, String hotel_izena, int gela, double prezio_total, String erabiltzailea_emaila, int txartel_zenbakia, String txartel_titularra, String txartel_iraunginpena, int txartel_cvv) {
        this.errenta_id = errenta_id;
        this.hasiera_data = hasiera_data;
        this.amaiera_data = amaiera_data;
        this.hotel_izena = hotel_izena;
        this.gela = gela;
        this.prezio_total = prezio_total;
        this.erabiltzailea_emaila = erabiltzailea_emaila;
        this.txartel_zenbakia = txartel_zenbakia;
        this.txartel_titularra = txartel_titularra;
        this.txartel_iraunginpena = txartel_iraunginpena;
        this.txartel_cvv = txartel_cvv;
    }

    /**
     *
     * @return
     */
    public ObjectId getErrenta_id() {
        return errenta_id;
    }

    /**
     *
     * @param errenta_id
     */
    public void setErrenta_id(ObjectId errenta_id) {
        this.errenta_id = errenta_id;
    }

    /**
     *
     * @return
     */
    public String getHasiera_data() {
        return hasiera_data;
    }

    /**
     *
     * @param hasiera_data
     */
    public void setHasiera_data(String hasiera_data) {
        this.hasiera_data = hasiera_data;
    }

    /**
     *
     * @return
     */
    public String getAmaiera_data() {
        return amaiera_data;
    }

    /**
     *
     * @param amaiera_data
     */
    public void setAmaiera_data(String amaiera_data) {
        this.amaiera_data = amaiera_data;
    }

    /**
     *
     * @return
     */
    public String getHotel_izena() {
        return hotel_izena;
    }

    /**
     *
     * @param hotel_izena
     */
    public void setHotel_izena(String hotel_izena) {
        this.hotel_izena = hotel_izena;
    }

    /**
     *
     * @return
     */
    public int getGela() {
        return gela;
    }

    /**
     *
     * @param gela
     */
    public void setGela(int gela) {
        this.gela = gela;
    }

    /**
     *
     * @return
     */
    public double getPrezio_total() {
        return prezio_total;
    }

    /**
     *
     * @param prezio_total
     */
    public void setPrezio_total(double prezio_total) {
        this.prezio_total = prezio_total;
    }

    /**
     *
     * @return
     */
    public String getErabiltzailea_emaila() {
        return erabiltzailea_emaila;
    }

    /**
     *
     * @param erabiltzailea_emaila
     */
    public void setErabiltzailea_emaila(String erabiltzailea_emaila) {
        this.erabiltzailea_emaila = erabiltzailea_emaila;
    }

    /**
     *
     * @return
     */
    public int getTxartel_zenbakia() {
        return txartel_zenbakia;
    }

    /**
     *
     * @param txartel_zenbakia
     */
    public void setTxartel_zenbakia(int txartel_zenbakia) {
        this.txartel_zenbakia = txartel_zenbakia;
    }

    /**
     *
     * @return
     */
    public String getTxartel_titularra() {
        return txartel_titularra;
    }

    /**
     *
     * @param txartel_titularra
     */
    public void setTxartel_titularra(String txartel_titularra) {
        this.txartel_titularra = txartel_titularra;
    }

    /**
     *
     * @return
     */
    public String getTxartel_iraunginpena() {
        return txartel_iraunginpena;
    }

    /**
     *
     * @param txartel_iraunginpena
     */
    public void setTxartel_iraunginpena(String txartel_iraunginpena) {
        this.txartel_iraunginpena = txartel_iraunginpena;
    }

    /**
     *
     * @return
     */
    public int getTxartel_cvv() {
        return txartel_cvv;
    }

    /**
     *
     * @param txartel_cvv
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
        return "Errenta{" + "errenta_id=" + errenta_id + ", hasiera_data=" + hasiera_data + ", amaiera_data=" + amaiera_data + ", hotel_izena=" + hotel_izena + ", gela=" + gela + ", prezio_total=" + prezio_total + ", erabiltzailea_emaila=" + erabiltzailea_emaila + ", txartel_zenbakia=" + txartel_zenbakia + ", txartel_titularra=" + txartel_titularra + ", txartel_iraunginpena=" + txartel_iraunginpena + ", txartel_cvv=" + txartel_cvv + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(errenta_id, hasiera_data, amaiera_data, hotel_izena, gela, prezio_total, erabiltzailea_emaila, txartel_zenbakia, txartel_titularra, txartel_iraunginpena, txartel_cvv);
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
        if (!Objects.equals(this.erabiltzailea_emaila, other.erabiltzailea_emaila)) {
            return false;
        }
        if (!Objects.equals(this.txartel_titularra, other.txartel_titularra)) {
            return false;
        }
        if (!Objects.equals(this.txartel_iraunginpena, other.txartel_iraunginpena)) {
            return false;
        }
        if (!Objects.equals(this.errenta_id, other.errenta_id)) {
            return false;
        }
        return true;
    }

}
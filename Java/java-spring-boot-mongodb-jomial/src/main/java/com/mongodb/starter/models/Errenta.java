/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
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
    private Date hasiera_data;
    private Date amaiera_data;
    private ObjectId hotel_id;
    private ObjectId erabiltzailea_id;
    private int txartel_zenbakia;
    private String txartel_titularra;
    private Date txartel_iraunginpena;
    private int txartel_cvv;

    public Errenta() {
    }

    public Errenta(ObjectId errenta_id, Date hasiera_data, Date amaiera_data, ObjectId hotel_id, ObjectId erabiltzailea_id, int txartel_zenbakia, String txartel_titularra, Date txatel_iraunginpena, int txartel_cvv) {
        this.errenta_id = errenta_id;
        this.hasiera_data = hasiera_data;
        this.amaiera_data = amaiera_data;
        this.hotel_id = hotel_id;
        this.erabiltzailea_id = erabiltzailea_id;
        this.txartel_zenbakia = txartel_zenbakia;
        this.txartel_titularra = txartel_titularra;
        this.txartel_iraunginpena = txatel_iraunginpena;
        this.txartel_cvv = txartel_cvv;
    }

    public ObjectId getErrenta_id() {
        return errenta_id;
    }

    public void setErrenta_id(ObjectId errenta_id) {
        this.errenta_id = errenta_id;
    }

    public Date getHasiera_data() {
        return hasiera_data;
    }

    public void setHasiera_data(Date hasiera_data) {
        this.hasiera_data = hasiera_data;
    }

    public Date getAmaiera_data() {
        return amaiera_data;
    }

    public void setAmaiera_data(Date amaiera_data) {
        this.amaiera_data = amaiera_data;
    }

    public ObjectId getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(ObjectId hotel_id) {
        this.hotel_id = hotel_id;
    }

    public ObjectId getErabiltzailea_id() {
        return erabiltzailea_id;
    }

    public void setErabiltzailea_id(ObjectId erabiltzailea_id) {
        this.erabiltzailea_id = erabiltzailea_id;
    }

    public int getTxartel_zenbakia() {
        return txartel_zenbakia;
    }

    public void setTxartel_zenbakia(int txartel_zenbakia) {
        this.txartel_zenbakia = txartel_zenbakia;
    }

    public String getTxartel_titularra() {
        return txartel_titularra;
    }

    public void setTxartel_titularra(String txartel_titularra) {
        this.txartel_titularra = txartel_titularra;
    }

    public Date getTxatel_iraunginpena() {
        return txartel_iraunginpena;
    }

    public void setTxatel_iraunginpena(Date txatel_iraunginpena) {
        this.txartel_iraunginpena = txatel_iraunginpena;
    }

    public int getTxater_cvv() {
        return txartel_cvv;
    }

    public void setTxater_cvv(int txartel_cvv) {
        this.txartel_cvv = txartel_cvv;
    }

    @Override
    public String toString() {
        return "Errenta{" + "errenta_id=" + errenta_id + ", hasiera_data=" + hasiera_data + ", amaiera_data=" + amaiera_data + ", hotel_id=" + hotel_id + ", erabiltzailea_id=" + erabiltzailea_id + ", txartel_zenbakia=" + txartel_zenbakia + ", txartel_titularra=" + txartel_titularra + ", txatel_iraunginpena=" + txartel_iraunginpena + ", txater_cvv=" + txartel_cvv + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(errenta_id, hasiera_data, amaiera_data, hotel_id, erabiltzailea_id, txartel_zenbakia, txartel_titularra, txartel_iraunginpena, txartel_cvv);
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
        final Errenta other = (Errenta) obj;
        if (this.txartel_zenbakia != other.txartel_zenbakia) {
            return false;
        }
        if (this.txartel_cvv != other.txartel_cvv) {
            return false;
        }
        if (!Objects.equals(this.txartel_titularra, other.txartel_titularra)) {
            return false;
        }
        if (!Objects.equals(this.errenta_id, other.errenta_id)) {
            return false;
        }
        if (!Objects.equals(this.hasiera_data, other.hasiera_data)) {
            return false;
        }
        if (!Objects.equals(this.amaiera_data, other.amaiera_data)) {
            return false;
        }
        if (!Objects.equals(this.hotel_id, other.hotel_id)) {
            return false;
        }
        if (!Objects.equals(this.erabiltzailea_id, other.erabiltzailea_id)) {
            return false;
        }
        if (!Objects.equals(this.txartel_iraunginpena, other.txartel_iraunginpena)) {
            return false;
        }
        return true;
    }
}
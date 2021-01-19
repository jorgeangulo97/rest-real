/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;

@JsonInclude(Include.NON_NULL)
public class Hotel {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId hotel_id;
    private String izena;
    private float distantzia;
    private String kokalekua;
    private String herrialdea;
    private String helbidea;
    private int izarrak;
    private float kalifikazioa;
    private float kostuGaua;
    private String argazkia;
    private String info;
    private List<String> zerbitzuak;

    public ObjectId getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(ObjectId hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public float getDistantzia() {
        return distantzia;
    }

    public void setDistantzia(float distantzia) {
        this.distantzia = distantzia;
    }

    public String getKokalekua() {
        return kokalekua;
    }

    public void setKokalekua(String kokalekua) {
        this.kokalekua = kokalekua;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public String getHelbidea() {
        return helbidea;
    }

    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }

    public int getIzarrak() {
        return izarrak;
    }

    public void setIzarrak(int izarrak) {
        this.izarrak = izarrak;
    }

    public float getKalifikazioa() {
        return kalifikazioa;
    }

    public void setKalifikazioa(float kalifikazioa) {
        this.kalifikazioa = kalifikazioa;
    }

    public float getKostuGaua() {
        return kostuGaua;
    }

    public void setKostuGaua(float kostuGaua) {
        this.kostuGaua = kostuGaua;
    }

    public String getArgazkia() {
        return argazkia;
    }

    public void setArgazkia(String argazkia) {
        this.argazkia = argazkia;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<String> getZerbitzuak() {
        return zerbitzuak;
    }

    public void setZerbitzuak(List<String> zerbitzuak) {
        this.zerbitzuak = zerbitzuak;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotel_id=" + hotel_id + ", izena=" + izena + ", distantzia=" + distantzia + ", kokalekua=" + kokalekua + ", herrialdea=" + herrialdea + ", helbidea=" + helbidea + ", izarrak=" + izarrak + ", kalifikazioa=" + kalifikazioa + ", kostuGaua=" + kostuGaua + ", argazkia=" + argazkia + ", info=" + info + ", zerbitzuak=" + zerbitzuak + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.hotel_id);
        hash = 89 * hash + Objects.hashCode(this.izena);
        hash = 89 * hash + Float.floatToIntBits(this.distantzia);
        hash = 89 * hash + Objects.hashCode(this.kokalekua);
        hash = 89 * hash + Objects.hashCode(this.herrialdea);
        hash = 89 * hash + Objects.hashCode(this.helbidea);
        hash = 89 * hash + this.izarrak;
        hash = 89 * hash + Float.floatToIntBits(this.kalifikazioa);
        hash = 89 * hash + Float.floatToIntBits(this.kostuGaua);
        hash = 89 * hash + Objects.hashCode(this.argazkia);
        hash = 89 * hash + Objects.hashCode(this.info);
        hash = 89 * hash + Objects.hashCode(this.zerbitzuak);
        return hash;
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
        final Hotel other = (Hotel) obj;
        if (Float.floatToIntBits(this.distantzia) != Float.floatToIntBits(other.distantzia)) {
            return false;
        }
        if (this.izarrak != other.izarrak) {
            return false;
        }
        if (Float.floatToIntBits(this.kalifikazioa) != Float.floatToIntBits(other.kalifikazioa)) {
            return false;
        }
        if (Float.floatToIntBits(this.kostuGaua) != Float.floatToIntBits(other.kostuGaua)) {
            return false;
        }
        if (!Objects.equals(this.izena, other.izena)) {
            return false;
        }
        if (!Objects.equals(this.kokalekua, other.kokalekua)) {
            return false;
        }
        if (!Objects.equals(this.herrialdea, other.herrialdea)) {
            return false;
        }
        if (!Objects.equals(this.helbidea, other.helbidea)) {
            return false;
        }
        if (!Objects.equals(this.argazkia, other.argazkia)) {
            return false;
        }
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        if (!Objects.equals(this.hotel_id, other.hotel_id)) {
            return false;
        }
        if (!Objects.equals(this.zerbitzuak, other.zerbitzuak)) {
            return false;
        }
        return true;
    }
    
    
}

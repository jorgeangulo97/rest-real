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
    private int postaKodea;
    private String distantzia;
    private String kokalekua;
    private String herrialdea;
    private String helbidea;
    private int izarrak;
    private double kalifikazioa;
    private double kostuGaua;
    private List<Argazkia> argazkiak;
    private String info;
    private String infoGenerala;
    private List<Zerbitzua> zerbitzuak;

    public Hotel() {
        
    }

    public Hotel(ObjectId hotel_id, String izena, int postaKodea, String distantzia, String kokalekua, String herrialdea, String helbidea, int izarrak, double kalifikazioa, double kostuGaua, List<Argazkia> argazkiak, String info, String infoGenerala, List<Zerbitzua> zerbitzuak) {
        this.hotel_id = hotel_id;
        this.izena = izena;
        this.postaKodea = postaKodea;
        this.distantzia = distantzia;
        this.kokalekua = kokalekua;
        this.herrialdea = herrialdea;
        this.helbidea = helbidea;
        this.izarrak = izarrak;
        this.kalifikazioa = kalifikazioa;
        this.kostuGaua = kostuGaua;
        this.argazkiak = argazkiak;
        this.info = info;
        this.infoGenerala = infoGenerala;
        this.zerbitzuak = zerbitzuak;
    }

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

    public int getPostaKodea() {
        return postaKodea;
    }

    public void setPostaKodea(int postaKodea) {
        this.postaKodea = postaKodea;
    }

    public String getDistantzia() {
        return distantzia;
    }

    public void setDistantzia(String distantzia) {
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

    public double getKalifikazioa() {
        return kalifikazioa;
    }

    public void setKalifikazioa(double kalifikazioa) {
        this.kalifikazioa = kalifikazioa;
    }

    public double getKostuGaua() {
        return kostuGaua;
    }

    public void setKostuGaua(double kostuGaua) {
        this.kostuGaua = kostuGaua;
    }

    public List<Argazkia> getArgazkiak() {
        return argazkiak;
    }

    public void setArgazkiak(List<Argazkia> argazkiak) {
        this.argazkiak = argazkiak;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoGenerala() {
        return infoGenerala;
    }

    public void setInfoGenerala(String infoGenerala) {
        this.infoGenerala = infoGenerala;
    }

    public List<Zerbitzua> getZerbitzuak() {
        return zerbitzuak;
    }

    public void setZerbitzuak(List<Zerbitzua> zerbitzuak) {
        this.zerbitzuak = zerbitzuak;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotel_id=" + hotel_id + ", izena=" + izena + ", postaKodea=" + postaKodea + ", distantzia=" + distantzia + ", kokalekua=" + kokalekua + ", herrialdea=" + herrialdea + ", helbidea=" + helbidea + ", izarrak=" + izarrak + ", kalifikazioa=" + kalifikazioa + ", kostuGaua=" + kostuGaua + ", argazkiak=" + argazkiak + ", info=" + info + ", infoGenerala=" + infoGenerala + ", zerbitzuak=" + zerbitzuak + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel_id, izena, postaKodea, distantzia, kokalekua, herrialdea, helbidea, izarrak, kalifikazioa, kostuGaua, argazkiak, info, infoGenerala, zerbitzuak);
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
        if (this.postaKodea != other.postaKodea) {
            return false;
        }
        if (this.izarrak != other.izarrak) {
            return false;
        }
        if (Double.doubleToLongBits(this.kalifikazioa) != Double.doubleToLongBits(other.kalifikazioa)) {
            return false;
        }
        if (Double.doubleToLongBits(this.kostuGaua) != Double.doubleToLongBits(other.kostuGaua)) {
            return false;
        }
        if (!Objects.equals(this.izena, other.izena)) {
            return false;
        }
        if (!Objects.equals(this.distantzia, other.distantzia)) {
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
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        if (!Objects.equals(this.infoGenerala, other.infoGenerala)) {
            return false;
        }
        if (!Objects.equals(this.hotel_id, other.hotel_id)) {
            return false;
        }
        if (!Objects.equals(this.argazkiak, other.argazkiak)) {
            return false;
        }
        if (!Objects.equals(this.zerbitzuak, other.zerbitzuak)) {
            return false;
        }
        return true;
    }
}
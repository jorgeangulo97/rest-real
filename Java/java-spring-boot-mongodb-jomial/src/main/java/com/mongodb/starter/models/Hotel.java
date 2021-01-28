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

/**
 *
 * @author angulo.jorge
 */
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
    private List<Argazkia> argazkiak;
    private String info;
    private String infoGenerala;
    private List<Gela> gelak;
    private List<String> zerbitzuak;

    /**
     *
     */
    public Hotel() {
        
    }

    /**
     *
     * @param hotel_id
     * @param izena
     * @param postaKodea
     * @param distantzia
     * @param kokalekua
     * @param herrialdea
     * @param helbidea
     * @param izarrak
     * @param kalifikazioa
     * @param argazkiak
     * @param info
     * @param infoGenerala
     * @param gelak
     * @param zerbitzuak
     */
    public Hotel(ObjectId hotel_id, String izena, int postaKodea, String distantzia, String kokalekua, String herrialdea, String helbidea, int izarrak, double kalifikazioa, List<Argazkia> argazkiak, String info, String infoGenerala, List<Gela> gelak, List<String> zerbitzuak) {
        this.hotel_id = hotel_id;
        this.izena = izena;
        this.postaKodea = postaKodea;
        this.distantzia = distantzia;
        this.kokalekua = kokalekua;
        this.herrialdea = herrialdea;
        this.helbidea = helbidea;
        this.izarrak = izarrak;
        this.kalifikazioa = kalifikazioa;
        this.argazkiak = argazkiak;
        this.info = info;
        this.infoGenerala = infoGenerala;
        this.gelak = gelak;
        this.zerbitzuak = zerbitzuak;
    }

    /**
     *
     * @return
     */
    public ObjectId getHotel_id() {
        return hotel_id;
    }

    /**
     *
     * @param hotel_id
     */
    public void setHotel_id(ObjectId hotel_id) {
        this.hotel_id = hotel_id;
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
    public int getPostaKodea() {
        return postaKodea;
    }

    /**
     *
     * @param postaKodea
     */
    public void setPostaKodea(int postaKodea) {
        this.postaKodea = postaKodea;
    }

    /**
     *
     * @return
     */
    public String getDistantzia() {
        return distantzia;
    }

    /**
     *
     * @param distantzia
     */
    public void setDistantzia(String distantzia) {
        this.distantzia = distantzia;
    }

    /**
     *
     * @return
     */
    public String getKokalekua() {
        return kokalekua;
    }

    /**
     *
     * @param kokalekua
     */
    public void setKokalekua(String kokalekua) {
        this.kokalekua = kokalekua;
    }

    /**
     *
     * @return
     */
    public String getHerrialdea() {
        return herrialdea;
    }

    /**
     *
     * @param herrialdea
     */
    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    /**
     *
     * @return
     */
    public String getHelbidea() {
        return helbidea;
    }

    /**
     *
     * @param helbidea
     */
    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }

    /**
     *
     * @return
     */
    public int getIzarrak() {
        return izarrak;
    }

    /**
     *
     * @param izarrak
     */
    public void setIzarrak(int izarrak) {
        this.izarrak = izarrak;
    }

    /**
     *
     * @return
     */
    public double getKalifikazioa() {
        return kalifikazioa;
    }

    /**
     *
     * @param kalifikazioa
     */
    public void setKalifikazioa(double kalifikazioa) {
        this.kalifikazioa = kalifikazioa;
    }

    /**
     *
     * @return
     */
    public List<Argazkia> getArgazkiak() {
        return argazkiak;
    }

    /**
     *
     * @param argazkiak
     */
    public void setArgazkiak(List<Argazkia> argazkiak) {
        this.argazkiak = argazkiak;
    }

    /**
     *
     * @return
     */
    public String getInfo() {
        return info;
    }

    /**
     *
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     *
     * @return
     */
    public String getInfoGenerala() {
        return infoGenerala;
    }

    /**
     *
     * @param infoGenerala
     */
    public void setInfoGenerala(String infoGenerala) {
        this.infoGenerala = infoGenerala;
    }

    /**
     *
     * @return
     */
    public List<Gela> getGelak() {
        return gelak;
    }

    /**
     *
     * @param gelak
     */
    public void setGelak(List<Gela> gelak) {
        this.gelak = gelak;
    }

    /**
     *
     * @return
     */
    public List<String> getZerbitzuak() {
        return zerbitzuak;
    }

    /**
     *
     * @param zerbitzuak
     */
    public void setZerbitzuak(List<String> zerbitzuak) {
        this.zerbitzuak = zerbitzuak;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Hotel{" + "hotel_id=" + hotel_id + ", izena=" + izena + ", postaKodea=" + postaKodea + ", distantzia=" + distantzia + ", kokalekua=" + kokalekua + ", herrialdea=" + herrialdea + ", helbidea=" + helbidea + ", izarrak=" + izarrak + ", kalifikazioa=" + kalifikazioa + ", argazkiak=" + argazkiak + ", info=" + info + ", infoGenerala=" + infoGenerala + ", gelak=" + gelak + ", zerbitzuak=" + zerbitzuak + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(hotel_id, izena, postaKodea, distantzia, kokalekua, herrialdea, helbidea, izarrak, kalifikazioa, argazkiak, info, infoGenerala, gelak, zerbitzuak);
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
        if (!Objects.equals(this.gelak, other.gelak)) {
            return false;
        }
        if (!Objects.equals(this.zerbitzuak, other.zerbitzuak)) {
            return false;
        }
        return true;
    }

}
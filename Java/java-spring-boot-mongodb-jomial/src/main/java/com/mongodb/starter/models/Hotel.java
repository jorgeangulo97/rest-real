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
    private ObjectId id;
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
     *Hotel klasearen konstruktorea
     */
    public Hotel() {
        
    }

    /**
     *
     * @param id
     * @param izena hotelaren izena
     * @param postaKodea hotelaren posta kodea
     * @param distantzia hoteletik hirigunera dagoen distantzia 
     * @param kokalekua hoteleko kokalekua
     * @param herrialdea hoteleko herrialdea
     * @param helbidea hoteleko helbidea
     * @param izarrak hoteleko izar kopurua
     * @param kalifikazioa hoteleko kalifikazioa
     * @param argazkiak hoteleko argazkiak
     * @param info hoteleko informazio garatua
     * @param infoGenerala hoteleko informazio orokorra
     * @param gelak hoteleko gelak
     * @param zerbitzuak hoteleko zebitzuak
     */
    public Hotel(ObjectId id, String izena, int postaKodea, String distantzia, String kokalekua, String herrialdea, String helbidea, int izarrak, double kalifikazioa, List<Argazkia> argazkiak, String info, String infoGenerala, List<Gela> gelak, List<String> zerbitzuak) {
        this.id = id;
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
     * @return hotelaren id 
     */
    public ObjectId getId() {
        return id;
    }

    /**
     *
     * @param id hotelaren id 
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     *
     * @return hotelaren izena 
     */
    public String getIzena() {
        return izena;
    }

    /**
     *
     * @param izena hotelaren izena 
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     *
     * @return hotelaren posta kodea 
     */
    public int getPostaKodea() {
        return postaKodea;
    }

    /**
     *
     * @param postaKodea hotelaren posta kodea 
     */
    public void setPostaKodea(int postaKodea) {
        this.postaKodea = postaKodea;
    }

    /**
     *
     * @return hoteletik hirigunera dagoen distantzia 
     */
    public String getDistantzia() {
        return distantzia;
    }

    /**
     *
     * @param distantzia hoteletik hirigunera dagoen distantzia  
     */
    public void setDistantzia(String distantzia) {
        this.distantzia = distantzia;
    }

    /**
     *
     * @return hoteleko kokalekua 
     */
    public String getKokalekua() {
        return kokalekua;
    }

    /**
     *
     * @param kokalekua hoteleko kokalekua 
     */
    public void setKokalekua(String kokalekua) {
        this.kokalekua = kokalekua;
    }

    /**
     *
     * @return hoteleko herrialdea 
     */
    public String getHerrialdea() {
        return herrialdea;
    }

    /**
     *
     * @param herrialdea hoteleko herrialdea 
     */
    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    /**
     *
     * @return hoteleko helbidea 
     */
    public String getHelbidea() {
        return helbidea;
    }

    /**
     *
     * @param helbidea hoteleko helbidea 
     */
    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }

    /**
     *
     * @return hoteleko izar kopurua 
     */
    public int getIzarrak() {
        return izarrak;
    }

    /**
     *
     * @param izarrak hoteleko izar kopurua 
     */
    public void setIzarrak(int izarrak) {
        this.izarrak = izarrak;
    }

    /**
     *
     * @return hoteleko kalifikazioa 
     */
    public double getKalifikazioa() {
        return kalifikazioa;
    }

    /**
     *
     * @param kalifikazioa hoteleko kalifikazioa 
     */
    public void setKalifikazioa(double kalifikazioa) {
        this.kalifikazioa = kalifikazioa;
    }

    /**
     *
     * @return hoteleko argazkiak 
     */
    public List<Argazkia> getArgazkiak() {
        return argazkiak;
    }

    /**
     *
     * @param argazkiak hoteleko argazkiak 
     */
    public void setArgazkiak(List<Argazkia> argazkiak) {
        this.argazkiak = argazkiak;
    }

    /**
     *
     * @return hoteleko informazio garatua
     */
    public String getInfo() {
        return info;
    }

    /**
     *
     * @param info hoteleko informazio garatua
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     *
     * @return hotelaren informazio orokorra
     */
    public String getInfoGenerala() {
        return infoGenerala;
    }

    /**
     *
     * @param infoGenerala hotelaren informazio orokorra
     */
    public void setInfoGenerala(String infoGenerala) {
        this.infoGenerala = infoGenerala;
    }

    /**
     *
     * @return hoteleko gelak
     */
    public List<Gela> getGelak() {
        return gelak;
    }

    /**
     *
     * @param gelak hoteleko gelak
     */
    public void setGelak(List<Gela> gelak) {
        this.gelak = gelak;
    }

    /**
     *
     * @return hoteleko zerbitzuak
     */
    public List<String> getZerbitzuak() {
        return zerbitzuak;
    }

    /**
     *
     * @param zerbitzuak hoteleko zerbitzuak
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
        return "Hotel{" + "hotel_id=" + id + ", izena=" + izena + ", postaKodea=" + postaKodea + ", distantzia=" + distantzia + ", kokalekua=" + kokalekua + ", herrialdea=" + herrialdea + ", helbidea=" + helbidea + ", izarrak=" + izarrak + ", kalifikazioa=" + kalifikazioa + ", argazkiak=" + argazkiak + ", info=" + info + ", infoGenerala=" + infoGenerala + ", gelak=" + gelak + ", zerbitzuak=" + zerbitzuak + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, izena, postaKodea, distantzia, kokalekua, herrialdea, helbidea, izarrak, kalifikazioa, argazkiak, info, infoGenerala, gelak, zerbitzuak);
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
        if (!Objects.equals(this.id, other.id)) {
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
package com.example.login;

import java.io.Serializable;

public class Lugar implements Serializable {
    String id;
    String nombre,desc,imgurl,departamento, direccion;
    String califica;

    public Lugar(String id, String nombre, String desc, String imgurl, String departamento, String direccion, String califica) {
        this.id = id;
        this.nombre = nombre;
        this.desc = desc;
        this.imgurl = imgurl;
        this.departamento = departamento;
        this.direccion = direccion;
        this.califica = califica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCalifica() {
        return califica;
    }

    public void setCalifica(String califica) {
        this.califica = califica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

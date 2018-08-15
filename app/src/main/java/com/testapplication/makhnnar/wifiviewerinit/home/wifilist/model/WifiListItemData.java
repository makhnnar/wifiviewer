package com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model;

public class WifiListItemData {
    private String nombre;
    private String id;
    private String password;
    private int intensity;

    public WifiListItemData(String nombre, String id, String password, int intensity) {
        this.nombre = nombre;
        this.id = id;
        this.password = password;
        this.intensity = intensity;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "WifiListItemData{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", intensity=" + intensity +
                '}';
    }
}

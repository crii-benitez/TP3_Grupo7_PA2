package com.utn.parkingcontrol;

public class Parking {
    public Parking(int idParking, String patente, String tiempo,String userName)
    {
        this.IdParking = idParking;
        this.Patente = patente;
        this.Tiempo = tiempo;
        this.UserName = userName;
    }

    private int IdParking;
    private String Patente;
    private String Tiempo;
    private String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getIdParking() {
        return IdParking;
    }

    public void setIdParking(int idParking) {
        IdParking = idParking;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }

    public String getTiempo() {
        return Tiempo;
    }

    public void setTiempo(String tiempo) {
        Tiempo = tiempo;
    }
}

//Ferdynand Monroy & Anthony Hetzale marzo 2026
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author ferito
 */
public class Aplicaciones { //toString junto a los métodos
    private int AplCodigo;
    private String AplNombre;
    private String AplEstado;

    public Aplicaciones() {
    }

    public Aplicaciones(String AplNombre, String AplEstado) {
        this.AplNombre = AplNombre;
        this.AplEstado = AplEstado;
    }

    public int getAplCodigo() {
        return AplCodigo;
    }

    public void setAplCodigo(int AplCodigo) {
        this.AplCodigo = AplCodigo;
    }

    public String getAplNombre() {
        return AplNombre;
    }

    public void setAplNombre(String AplNombre) {
        this.AplNombre = AplNombre;
    }

    public String getAplEstado() {
        return AplEstado;
    }

    public void setAplEstado(String AplEstado) {
        this.AplEstado = AplEstado;
    }

    @Override
    public String toString() {
        return "Aplicaciones{" + "AplCodigo=" + AplCodigo + ", AplNombre=" + AplNombre + ", AplEstado=" + AplEstado + '}';
    }
}

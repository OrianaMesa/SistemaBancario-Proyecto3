/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author oriana
 */
public abstract class Cuenta {

    protected String numero;
    protected String nombreDueno;
    protected Fecha fechaApertura;
    protected double saldo;

    public Cuenta(String numero, String nombreDueno,
                  Fecha fechaApertura, double saldo) {

        this.numero = numero;
        this.nombreDueno = nombreDueno;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    public Cuenta(String numero, String nombreDueno,
                  Fecha fechaApertura) {

        this(numero, nombreDueno, fechaApertura, 0);
    }

    public boolean consignar(double valor) {

        if (valor > 0) {
            saldo = saldo + valor;
            return true;
        }

        return false;
    }

    public abstract boolean retirar(double valor);

    public String obtenerInformacion() {

        return "Número: " + numero
                + "\nDueño: " + nombreDueno
                + "\nFecha de apertura: " + fechaApertura
                + "\nSaldo: $" + saldo;
    }

    public String obtenerSaldo() {
        return "Saldo actual: $" + saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public double getSaldo() {
        return saldo;
    }
}

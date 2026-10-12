/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author orian
 */
public class CuentaCorriente extends Cuenta {

    private double cupoSobregiro;

    public CuentaCorriente(String numero, String nombreDueno,
                           Fecha fechaApertura, double saldo,
                           double cupoSobregiro) {

        super(numero, nombreDueno, fechaApertura, saldo);
        this.cupoSobregiro = cupoSobregiro;
    }

    public CuentaCorriente(String numero, String nombreDueno,
                           Fecha fechaApertura, double cupoSobregiro) {

        super(numero, nombreDueno, fechaApertura);
        this.cupoSobregiro = cupoSobregiro;
    }

    @Override
    public boolean retirar(double valor) {

        if (valor > 0 && valor <= saldo + cupoSobregiro) {
            saldo = saldo - valor;
            return true;
        }

        return false;
    }

    @Override
    public String obtenerInformacion() {

        return super.obtenerInformacion()
                + "\nCupo de sobregiro: $" + cupoSobregiro;
    }

    public double getCupoSobregiro() {
        return cupoSobregiro;
    }
}
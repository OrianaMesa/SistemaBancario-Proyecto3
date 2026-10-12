/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.*;
/**
 *
 * @author orian
 */
public class ControladorBanco {
    
    private Cuenta[] cuentas;
    private int cantidadCuentas;

    public ControladorBanco() {
        cuentas = new Cuenta[100];
        cantidadCuentas = 0;
    }

    public boolean crearCuentaAhorros(String numero, String nombre,
                                      Fecha fecha, double saldo) {

        if (buscarCuenta(numero) != null
                || saldo < 0
                || cantidadCuentas >= cuentas.length) {
            return false;
        }

        Cuenta cuenta = new CuentaAhorros(
                numero, nombre, fecha, saldo);

        cuentas[cantidadCuentas] = cuenta;
        cantidadCuentas++;

        return true;
    }

    public boolean crearCuentaCorriente(String numero, String nombre,
                                        Fecha fecha, double saldo,
                                        double cupo) {

        if (buscarCuenta(numero) != null
                || saldo < 0
                || cupo < 0
                || cantidadCuentas >= cuentas.length) {
            return false;
        }

        Cuenta cuenta = new CuentaCorriente(
                numero, nombre, fecha, saldo, cupo);

        cuentas[cantidadCuentas] = cuenta;
        cantidadCuentas++;

        return true;
    }

    public Cuenta buscarCuenta(String numero) {

        for (int i = 0; i < cantidadCuentas; i++) {

            if (cuentas[i].getNumero().equals(numero)) {
                return cuentas[i];
            }
        }

        return null;
    }

    public boolean consignar(String numero, double valor) {

        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta != null) {
            return cuenta.consignar(valor);
        }

        return false;
    }

    public boolean retirar(String numero, double valor) {

        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta != null) {
            return cuenta.retirar(valor);
        }

        return false;
    }

    public String consultarSaldo(String numero) {

        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta != null) {
            return cuenta.obtenerSaldo();
        }

        return "La cuenta no existe.";
    }

    public String consultarInformacion(String numero) {

        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta != null) {
            return cuenta.obtenerInformacion();
        }

        return "La cuenta no existe.";
    }
}

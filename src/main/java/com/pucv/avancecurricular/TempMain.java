 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucv.avancecurricular;

import com.pucv.avancecurricular.vista.AvanceCurricularSwing;

/**
 *
 * @author matias
 */
public class TempMain {
    public static void main(String[] args){
        AvanceCurricularSwing vista = new AvanceCurricularSwing();
        Controlador controlador = new Controlador(vista);
    }
}

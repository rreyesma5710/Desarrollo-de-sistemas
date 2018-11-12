package Controlador;

import Vista.CrudAreas;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrlArea implements ActionListener{

    private Area arModel; //modelo
    private ConsultasAreas arConsult; //consultas
    private CrudAreas frmAr; //vista

    public CtrlArea(Area arModel, ConsultasAreas arConsult, CrudAreas frmAr) {
        this.arModel = arModel;
        this.arConsult = arConsult;
        this.frmAr = frmAr;
        this.frmAr.btn_guardar.addActionListener(this);
        this.frmAr.btn_eliminar.addActionListener(this);
        this.frmAr.btn_buscar.addActionListener(this);
        this.frmAr.btn_modificar.addActionListener(this);
        this.frmAr.btn_limpiar.addActionListener(this);
    }
    
    public void iniciar() {
    
        frmAr.setTitle("Areas");
        frmAr.setLocationRelativeTo(null);
        frmAr.txt_id.setVisible(false);
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    
        //si da click en botón guardar
        if(e.getSource() == frmAr.btn_guardar) {
            arModel.setNombre(frmAr.txt_nombre.getText());
            arModel.setDescripcion(frmAr.txt_descripcion.getText());
            
            if(arConsult.registrar(arModel)) {
            
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        
        //si da click en el botón modificar
        if(e.getSource() == frmAr.btn_modificar) {
            arModel.setId(Integer.parseInt(frmAr.txt_id.getText()));
            arModel.setNombre(frmAr.txt_nombre.getText());
            arModel.setDescripcion(frmAr.txt_descripcion.getText());
            
            if(arConsult.modificar(arModel)) {
                
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }


        //si da click al botón eliminar
        if(e.getSource() == frmAr.btn_eliminar) {
            arModel.setId(Integer.parseInt(frmAr.txt_id.getText()));
            
            if(arConsult.eliminar(arModel)) {
            
                JOptionPane.showMessageDialog(null, "registro eliminado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        
        //si da click al botón buscar
        if(e.getSource() == frmAr.btn_buscar) {
            arModel.setNombre(frmAr.txt_nombre.getText());
            
            try {
                if(arConsult.buscarPorNombre(arModel)) {
                    
                    frmAr.txt_id.setText(String.valueOf(arModel.getId()));
                    frmAr.txt_nombre.setText(arModel.getNombre());
                    frmAr.txt_descripcion.setText(arModel.getDescripcion());
                    
                }else {
                    
                    JOptionPane.showMessageDialog(null, "Error no encontró resutado");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlArea.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if(e.getSource() == frmAr.btn_limpiar) {
            
            limpiar();
        
        }
    
    }
    
    
    public void limpiar() {
    
    
        frmAr.txt_id.setText(null);
        frmAr.txt_nombre.setText(null);
        frmAr.txt_descripcion.setText(null);
    
    }

    
    
    
}

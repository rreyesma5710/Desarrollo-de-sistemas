package Controlador;

import Modelo.*;
import Vista.CrudRoles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrlRol implements ActionListener{

    private Rol rolModel; //modelo
    private ConsultasRoles rolConsult; //consultas
    private CrudRoles frmRol; //vista

    public CtrlRol(Rol rolModel, ConsultasRoles rolConsult, CrudRoles frmRol) {
        this.rolModel = rolModel;
        this.rolConsult = rolConsult;
        this.frmRol = frmRol;
        this.frmRol.btn_guardar.addActionListener(this);
        this.frmRol.btn_eliminar.addActionListener(this);
        this.frmRol.btn_buscar.addActionListener(this);
        this.frmRol.btn_modificar.addActionListener(this);
        this.frmRol.btn_limpiar.addActionListener(this);
    }
    
    public void iniciar() {
    
        frmRol.setTitle("Roles");
        frmRol.setLocationRelativeTo(null);
        frmRol.txt_id.setVisible(false);
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    
        //si da click en botón guardar
        if(e.getSource() == frmRol.btn_guardar) {
            rolModel.setNombre(frmRol.txt_nombre.getText());
            rolModel.setDescripcion(frmRol.txt_descripcion.getText());
            
            if(rolConsult.registrar(rolModel)) {
            
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        
        //si da click en el botón modificar
        if(e.getSource() == frmRol.btn_modificar) {
            rolModel.setId(Integer.parseInt(frmRol.txt_id.getText()));
            rolModel.setNombre(frmRol.txt_nombre.getText());
            rolModel.setDescripcion(frmRol.txt_descripcion.getText());
            
            if(rolConsult.modificar(rolModel)) {
            
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }


        //si da click al botón eliminar
        if(e.getSource() == frmRol.btn_eliminar) {
            rolModel.setId(Integer.parseInt(frmRol.txt_id.getText()));
            
            if(rolConsult.eliminar(rolModel)) {
            
                JOptionPane.showMessageDialog(null, "registro eliminado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        
        //si da click al botón buscar
        if(e.getSource() == frmRol.btn_buscar) {
            
            rolModel.setNombre(frmRol.txt_nombre.getText());
            
            try {
                if(rolConsult.buscarPorNombre(rolModel)) {
                    
                    frmRol.txt_id.setText(String.valueOf(rolModel.getId()));
                    frmRol.txt_nombre.setText(rolModel.getNombre());
                    frmRol.txt_descripcion.setText(rolModel.getDescripcion());
                    
                }else {
                    
                    JOptionPane.showMessageDialog(null, "Error no encontró resutado");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlRol.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if(e.getSource() == frmRol.btn_limpiar) {
            
            limpiar();
        
        }
    
    }
    
    
    public void limpiar() {
    
        frmRol.txt_id.setText(null);
        frmRol.txt_nombre.setText(null);
        frmRol.txt_descripcion.setText(null);
    
    }

    
    
    
}

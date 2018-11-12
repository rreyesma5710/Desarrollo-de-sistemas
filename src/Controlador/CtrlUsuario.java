package Controlador;

import Vista.CrudUsuarios;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrlUsuario implements ActionListener{

    private Usuario userModel; //modelo
    private ConsultasUsuarios userConsult; //consultas
    private CrudUsuarios frmUser; //vista

    public CtrlUsuario(Usuario userModel, ConsultasUsuarios userConsult, CrudUsuarios frmUser) {
        this.userModel = userModel;
        this.userConsult = userConsult;
        this.frmUser = frmUser;
        this.frmUser.btn_guardar.addActionListener(this);
        this.frmUser.btn_eliminar.addActionListener(this);
        this.frmUser.btn_buscar.addActionListener(this);
        this.frmUser.btn_modificar.addActionListener(this);
        this.frmUser.btn_limpiar.addActionListener(this);
    }
    
    public void iniciar() {
    
        frmUser.setTitle("Usuarios");
        frmUser.setLocationRelativeTo(null);
        frmUser.txt_id.setVisible(false);
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    
        //si da click en botón guardar
        if(e.getSource() == frmUser.btn_guardar) {
            userModel.setNombre(frmUser.txt_nombre.getText());
            userModel.setDocumento(frmUser.txt_documento.getText());
            userModel.setEmpresa(frmUser.txt_empresa.getText());
            userModel.setDireccion(frmUser.txt_direccion.getText());
            userModel.setPassword(frmUser.txt_contraseña.getText());
            userModel.setRol(Integer.parseInt(frmUser.txt_rol.getText()));
            userModel.setEspecialidad(Integer.parseInt(frmUser.txt_especialidad.getText()));
            
            if(userConsult.registrar(userModel)) {
            
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        
        //si da click en el botón modificar
        if(e.getSource() == frmUser.btn_modificar) {
            userModel.setId(Integer.parseInt(frmUser.txt_id.getText()));
            userModel.setNombre(frmUser.txt_nombre.getText());
            userModel.setDocumento(frmUser.txt_documento.getText());
            userModel.setEmpresa(frmUser.txt_empresa.getText());
            userModel.setDireccion(frmUser.txt_direccion.getText());
            userModel.setPassword(frmUser.txt_contraseña.getText());
            userModel.setRol(Integer.parseInt(frmUser.txt_rol.getText()));
            userModel.setEspecialidad(Integer.parseInt(frmUser.txt_especialidad.getText()));
            
            if(userConsult.modificar(userModel)) {
            
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }


        //si da click al botón eliminar
        if(e.getSource() == frmUser.btn_eliminar) {
            userModel.setId(Integer.parseInt(frmUser.txt_id.getText()));
            
            if(userConsult.eliminar(userModel)) {
            
                JOptionPane.showMessageDialog(null, "registro eliminado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        
        //si da click al botón buscar
        if(e.getSource() == frmUser.btn_buscar) {
            userModel.setNombre(frmUser.txt_nombre.getText());
            
            try {
                if(userConsult.buscarPorNombre(userModel)) {
                    
                    frmUser.txt_id.setText(String.valueOf(userModel.getId()));
                    frmUser.txt_nombre.setText(userModel.getNombre());
                    frmUser.txt_documento.setText(userModel.getDocumento());
                    frmUser.txt_empresa.setText(userModel.getEmpresa());
                    frmUser.txt_direccion.setText(userModel.getDireccion());
                    frmUser.txt_contraseña.setText(userModel.getPassword());
                    frmUser.txt_rol.setText(String.valueOf(userModel.getRol()));
                    frmUser.txt_especialidad.setText(String.valueOf(userModel.getEspecialidad()));
                    
                }else {
                    
                    JOptionPane.showMessageDialog(null, "Error no encontró resutado");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if(e.getSource() == frmUser.btn_limpiar) {
            
            limpiar();
        
        }
    
    }
    
    
    public void limpiar() {
    
    
        frmUser.txt_id.setText(null);
        frmUser.txt_nombre.setText(null);
        frmUser.txt_documento.setText(null);
        frmUser.txt_empresa.setText(null);
        frmUser.txt_direccion.setText(null);
        frmUser.txt_contraseña.setText(null);
        frmUser.txt_rol.setText(null);
        frmUser.txt_especialidad.setText(null);
    
    }

    
    
    
}

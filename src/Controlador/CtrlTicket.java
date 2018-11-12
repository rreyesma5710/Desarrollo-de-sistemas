package Controlador;

import Vista.CrudUsuarios;
import Modelo.*;
import Vista.CrudTickets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrlTicket implements ActionListener{

    private Ticket tckModel; //modelo
    private ConsultasTickets tckConsult; //consultas
    private CrudTickets frmTck; //vista

    public CtrlTicket(Ticket tckModel, ConsultasTickets tckConsult, CrudTickets frmTck ){
        this.tckModel = tckModel;
        this.tckConsult = tckConsult;
        this.frmTck = frmTck;
        this.frmTck.btn_guardar.addActionListener(this);
        this.frmTck.btn_eliminar.addActionListener(this);
        this.frmTck.btn_buscar.addActionListener(this);
        this.frmTck.btn_modificar.addActionListener(this);
        this.frmTck.btn_limpiar.addActionListener(this);
    }
    
    public void iniciar() {
    
        frmTck.setTitle("Tickets");
        frmTck.setLocationRelativeTo(null);
        frmTck.txt_id.setVisible(false);
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    
        //si da click en botón guardar
        if(e.getSource() == frmTck.btn_guardar) {
            
            tckModel.setCliente(Integer.parseInt(frmTck.txt_cliente.getText()));
            tckModel.setTecnico(Integer.parseInt(frmTck.txt_tecnico.getText()));
            tckModel.setDescripcion(frmTck.txt_descripcion.getText());
            tckModel.setEstado(Integer.parseInt(frmTck.txt_estado.getText()));
            
            if(tckConsult.registrar(tckModel)) {
            
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        
        //si da click en el botón modificar
        if(e.getSource() == frmTck.btn_modificar) {
            tckModel.setId(Integer.parseInt(frmTck.txt_id.getText()));
            
            tckModel.setCliente(Integer.parseInt(frmTck.txt_cliente.getText()));
            tckModel.setTecnico(Integer.parseInt(frmTck.txt_tecnico.getText()));
            tckModel.setDescripcion(frmTck.txt_descripcion.getText());
            tckModel.setEstado(Integer.parseInt(frmTck.txt_estado.getText()));
        
            if(tckConsult.modificar(tckModel)) {
            
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }


        //si da click al botón eliminar
        if(e.getSource() == frmTck.btn_eliminar) {
            tckModel.setId(Integer.parseInt(frmTck.txt_id.getText()));
            
            if(tckConsult.eliminar(tckModel)) {
            
                JOptionPane.showMessageDialog(null, "registro eliminado");
                limpiar();
            
            }else {
            
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        
        //si da click al botón buscar
        if(e.getSource() == frmTck.btn_buscar) {
            tckModel.setDescripcion(frmTck.txt_descripcion.getText());
            
            try {
                if(tckConsult.buscarPorDescripcion(tckModel)) {
                    
                    frmTck.txt_id.setText(String.valueOf(tckModel.getId()));
                    frmTck.txt_cliente.setText(String.valueOf(tckModel.getCliente()));
                    frmTck.txt_tecnico.setText(String.valueOf(tckModel.getTecnico()));
                    frmTck.txt_descripcion.setText(tckModel.getDescripcion());
                    frmTck.txt_estado.setText(String.valueOf(tckModel.getEstado()));
                    
                    
                }else {
                    
                    JOptionPane.showMessageDialog(null, "Error no encontró resutado");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlTicket.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if(e.getSource() == frmTck.btn_limpiar) {
            
            limpiar();
        
        }
    
    }
    
    
    public void limpiar() {
    
    
        frmTck.txt_id.setText(null);
        frmTck.txt_cliente.setText(null);
        frmTck.txt_tecnico.setText(null);
        frmTck.txt_descripcion.setText(null);
        frmTck.txt_estado.setText(null);
    
    }

    
    
    
}

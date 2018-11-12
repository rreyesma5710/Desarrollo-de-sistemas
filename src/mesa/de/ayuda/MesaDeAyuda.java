package mesa.de.ayuda;

import Controlador.CtrlArea;
import Controlador.CtrlRol;
import Controlador.CtrlTicket;
import Controlador.CtrlUsuario;
import Modelo.Area;
import Modelo.ConsultasAreas;
import Modelo.ConsultasRoles;
import Modelo.ConsultasTickets;
import Modelo.ConsultasUsuarios;
import Modelo.Rol;
import Modelo.Ticket;
import Modelo.Usuario;
import Vista.CrudAreas;
import Vista.CrudRoles;
import Vista.CrudTickets;
import Vista.CrudUsuarios;
import Vista.Login;
import Vista.ModuloAdministrativo;

public class MesaDeAyuda {


    public static void main(String[] args) {
        
        //Mostrar pantalla de login
        Login frmLogin = new Login();
        frmLogin.setVisible(true);


    }
    
}

package controladores;

import modelos.Usuario;

public class UsuarioController {

    private Usuario usuario;

    public UsuarioController() {

    }

    public boolean hacerLogin(Usuario usuario){
        if(usuario.getUsuario().equals("admin") && usuario.getPassword().equals("admin"))
            return true;
        else
            return false;
    }

}

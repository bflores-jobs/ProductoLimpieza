package cl.bflores.dao;

import cl.bflores.interfaces.LoginDao;

public class LoginDaoImp implements LoginDao {

	@Override
	public boolean usuarioRegistrado(String usr, String pwd) {
		
		boolean usuarioExiste = false;
		
		//persistencia de datos
		String usrRegistrado = "bflores";
		String pwdRegistrada = "123";		
		
		if(usr.equals(usrRegistrado) && pwd.equals(pwdRegistrada)) {
			usuarioExiste = true;
		}
		
		return usuarioExiste;
	}

}

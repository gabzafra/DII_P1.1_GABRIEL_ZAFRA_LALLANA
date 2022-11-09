Repo en https://github.com/gabzafra/DII_P1.1_GABRIEL_ZAFRA_LALLANA

La actividad esta organizada de la siguiente manera:

Al entrar al usuario se le muestra un formulario para que introduzca su nombre de usuario y su contraseña. 
El usuario debe introducir la misma contraseña en los dos campos habilitados. Y a continuación pulsar el
botón Entrar.

Si ha introducido dos contraseñas diferentes se le avisa y se le permite volver a intentarlo.
Si ha introducido un usuario que no existe de le avisa y se le permite volver a intentarlo.
Si ha introducido dos contraseñás iguales pero está bloqueado en el sistema por haber fallado tres veces
al intentar autenticarse se le informa de que esta bloqueado y debe ponerse en contacto con el
administrador y se le permite volver a intentarlo.
Si no esta bloqueado pero la contraseña es errónea se le informa del problema y de los intentos que le
quedan y se le permite volver a intentarlo.
Si es un usuario normal, no esta bloqueado y la contraseña coincide se le muestra el saludo.
Si es un usuario admin, no esta bloqueado y la contraseña coincide se accede a la zona de administración.

La zona de administración muestra una lista de usuarios que están bloqueados para que se elija cual se quiere desbloquear.
Si no hay usuarios que desbloquear se redirige al formulario de login.

El usuario administrador podrá ir seleccionando de uno en uno a los usuarios bloqueados y desbloqueándoles
con el botón desbloquear o si no quiere desbloquear a nadie puede volver al formulario de login con el
botón volver.

VISTAS

En la carpeta WebContent hay tres archivos jsp con las vistas de la aplicación:
- index.jsp > Contiene el formulario para hacer login.
- admin.jsp > Contiene el formulario para desbloquear usuarios.
- saludo.jsp > Contiene el mensaje que indica a usuario que se ha autenticado con éxito.

También dentro de WebContent\css hay dos hojas con los estilos de la aplicación
- reset.css
- styles.css

SERVLETS

En la carpeta src\dam2\dii\p11 hay dos Servlets que controlan el comportamiento de los formularios
- Users.java resuelve peticiones POST en /users y controla el login de los usuarios
- Admins.java resuelve peticiones POST en /admin y controla el desbloqueo de usuarios

MODELO

En la carpeta src\dam2\dii\p11\model hay dos clases que mantienen el modelo de datos
- Usuario.java que es un bean con los datos del Usuario. En este caso nombre, contraseña e intentos restantes;
- UserDb.java actúa como base de datos. Proporciona métodos CRUD. Es una clase Singleton que usan los dos Servlets para
acceder a los datos de los usuarios. Al crearse la instancia se inicializa la "base de datos" con usuarios de ejemplo:
    	Nombre		Contraseña	Intentos restantes
	"admin"		"admin"		3
    	"betty"		"bbbb"		0
    	"charlie"	"cccc"		1
    	"diane"		"dddd"		3
    	"eddie"		"eeee"		0
    	"felicia"	"ffff"		0


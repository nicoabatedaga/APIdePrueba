import apideprueba.Empresa
import apideprueba.Persona

class BootStrap {

    def init = { servletContext ->
        new Persona("usuario de prueba",12345673,"mail@mail.com")
        Empresa e = new Empresa("Mercado Libre", 1)
        e.agregarEmpleado(new Persona("usuario de prueba 2",22345673,"mail2@mail.com"))
        e.agregarEmpleado(new Persona("Nicolas Abatedaga",36051189,"nicoababio@gmail.com"))
    }
    def destroy = {
    }
}

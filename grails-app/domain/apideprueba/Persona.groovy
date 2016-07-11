package apideprueba

class Persona {

    static belongsTo = Empresa
    String nombre
    int dni
    String email


    static constraints = {
        nombre(size: 3..50)
        dni(range: 1000000..60000000)
        email(email: true)
    }
}

package apideprueba

class Persona {

    static belongsTo = Empresa
    String persona_nombre
    Integer persona_dni
    String persona_email


    static constraints = {
        persona_nombre(size: 3..50)
        persona_dni(range: 1000000..60000000)
        persona_dni unique: true
        persona_email(email: true)
        persona_email unique: true
    }
}

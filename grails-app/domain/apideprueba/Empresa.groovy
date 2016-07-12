package apideprueba

class Empresa {

    static hasMany = [personas:Persona]
    Integer id
    String nombre

    static constraints = {
        id(range: 1..100000)
        nombre(size: 1..50)
    }

}

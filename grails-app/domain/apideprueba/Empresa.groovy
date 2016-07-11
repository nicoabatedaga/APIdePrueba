package apideprueba

class Empresa {

    static hasMany = [personas:Persona]
    String nombre
    int numeroDeEmpresa

    static constraints = {
        nombre(size: 1..50)
        numeroDeEmpresa(range: 1..100000)
    }
}

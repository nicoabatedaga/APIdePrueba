package apideprueba

class Empresa {

    static hasMany = [empleados:Persona]
    Integer empresa_id
    String empresa_nombre

    static constraints = {
        empresa_id(range: 1..100000)
        empresa_id unique: true
        empresa_nombre(size: 1..50)
    }

}

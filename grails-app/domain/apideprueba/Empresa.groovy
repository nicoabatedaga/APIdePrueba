package apideprueba

class Empresa {

    static hasMany = [personas:Persona]
    String nombre
    Integer numeroDeEmpresa

    static constraints = {
        nombre(size: 1..50)
        numeroDeEmpresa(range: 1..100000)
    }

    public Empresa(String nombre, Integer numero){
        this.nombre = nombre
        this.numeroDeEmpresa = numero
    }

    public agregarEmpleado(Persona p){
        hasMany.put(p.dni , p)
    }

    public eliminarEmpleado(Integer dni){
        hasMany.remove(dni)
    }

    public getEmpleado(Integer dni){
        return hasMany.get(dni)
    }

    public tieneComoEmpleado(Integer dni){
        return hasMany.containsValue(dni)
    }
}

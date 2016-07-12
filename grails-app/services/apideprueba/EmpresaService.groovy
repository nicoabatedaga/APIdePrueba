package apideprueba

import grails.transaction.Transactional

@Transactional
class EmpresaService {

    def serviceMethod() {
    }

    def postEmpleado(Persona p){
        //agregar a base de datos una persona p

    }

    def getEmpleado(Integer dni){
        //retornar el empleado con "dni" = dni
        def empleado = Empresa.hasMany.get(dni)
    }

    def deletEmpleado(Integer dni){
        //Eliminar el empleado

    }

    def putEmpleado(Integer dni, Persona p) {
        //Actualizar los datos de la persona con dni, con los datos de la persona p

    }
}

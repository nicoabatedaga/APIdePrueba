package apideprueba

import grails.transaction.Transactional

import java.awt.List

@Transactional
class EmpresaService {

    def serviceMethod() {
    }

    def postEmpresa(Integer empid , String empnom){
        Empresa e = new Empresa()
        e.id = empid
        e.nombre = empnom
        e.save(flush:true)
    }

    def getEmpleado(Integer dni){
        //retornar el empleado con "dni" = dni
        //def empleado = Empresa.hasMany.get(dni)
    }

    def getEmpleados(){
        //retorna una lista de todos los empleados
        //def list = []
        //def it = Empresa.hasMany.iterator()
        //while (it.hasNext())
          //  list.add(it.next())
        //return list
    }

    def deletEmpleado(Integer dni){
        //Eliminar el empleado

    }

    def putEmpleado(Integer dni, Persona p) {
        //Actualizar los datos de la persona con dni, con los datos de la persona p

    }
}

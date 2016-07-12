package apideprueba

import grails.converters.JSON

class EmpresaController {

    //static allowedMethods = [get: "GET", save: "POST", update: "PUT", delete: "DELETE"]

    def index() { }

    def saludar(){
        render "Este es el controlador de empresa"
    }

    def empresaService
    def get() {
        def dni= request.getParameter("dni") as Integer
        println("El dni ingresado ${dni}")
        Persona p = empresaService.getEmpleado(dni)
        println("persona ${p?.properties}")
        if (p != null)
            render([status: 200, response: [nombre: p.nombre , dni: p.dni, email: p.email]] as JSON)
        else
            render([status: 404 , response: [message: "No existe el empleado con dni: ${dni}"]] as JSON)
    }
    def save(){

    }
    //def update(){}
    //def delete(){}
}

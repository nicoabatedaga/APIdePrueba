package apideprueba

import grails.converters.JSON

class EmpresaController {

    //static allowedMethods = [get: "GET", save: "POST", update: "PUT", delete: "DELETE"]
    def empresaService

    def index() { }

    def save(){
        def empresa_id = request.getParameter("id") as Integer
        def empresa_nombre = request.getParameter("nombre") as String
        def result = empresaService.postEmpresa(empresa_id , empresa_nombre)
    }

    def get(){}

    def update(){}


    /*def get() {
        if (request.getParameter("all") != null) {
            println("imprimir todos")
            def list = empresaService.getEmpleados()
            render(list as JSON)
        }else {
            def dni = request.getParameter("dni") as Integer
            println("El dni ingresado ${dni}")
            Persona p = empresaService.getEmpleado(dni)
            println("persona ${p?.properties}")
            if (p != null)
                render([status: 200, response: [nombre: p.nombre, dni: p.dni, email: p.email]] as JSON)
            else
                render([status: 404, response: [message: "No existe el empleado con dni: ${dni}"]] as JSON)
        }
    }
    def save(){
        def nombre = request.getParameter("nombre") as String
        def dni = request.getParameter("dni") as Integer
        def email = request.getParameter("email") as String
        def p = new Persona(nombre,dni,email)
        println("persona creada ${p?.properties}")
        empresaService.postEmpleado(p)
        render([status: 200 , response: [message: "Nuevo empleado agregado"]]as JSON)
    }*/
    //def update(){}
    //def delete(){}
}

package apideprueba

import grails.converters.JSON

class EmpresaController {

    //static allowedMethods = [get: "GET", save: "POST", update: "PUT", delete: "DELETE"]
    def empresaService

    def index() { }

    def save(){
        def empresa_id = request.getParameter("id") as Integer
        def empresa_nombre = request.getParameter("nombre") as String
        def ret = empresaService.postEmpresa(empresa_id , empresa_nombre)
        render (ret as JSON)
    }

    def get(){
        if (request.parameterMap.get("empresa_id") != null){
            //empid
            def empresa_id = request.getParameter("empresa_id") as Integer
            def ret = empresaService.getEmpresa(empresa_id)
            render (ret as JSON)
        }else{
            //all
            def ret = empresaService.getEmpresas()
            render (ret as JSON)
        }
    }

    def update(){
        def empresa_id = request.getParameter("empresa_id") as Integer
        def empresa_nombre = request.getParameter("empresa_nombre") as String
        //def params = request.getParameterMap()
        //println("parametros: ${params}")
       if (empresa_id != null){
            if (empresa_nombre != null) {
                println("antes de el service ${empresa_id} ---- ${empresa_nombre}")
                def ret = empresaService.updateEmpresa_nombre(empresa_id , empresa_nombre)
                render (ret as JSON)
           }else{
                render ([status: 400 , response: [message: "No se especifico el nuevo nombre"]] as JSON)
            }
        }else{
           render ([status: 400 , response: [message: "No se especifico el id de la empresa a actualizar"]] as JSON)
       }
    }

    def delete(){
        def empresa_id = request.getParameter("empresa_id") as Integer
        def ret = empresaService.delete(empresa_id)
        render (ret as JSON)
    }


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

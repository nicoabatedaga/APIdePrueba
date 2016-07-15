package apideprueba

import grails.converters.JSON

class EmpresaController {

    def empresaService

    def index() { }

    def save(){
//        def empresa_id = request.getParameter("id") as Integer
//        def empresa_nombre = request.getParameter("nombre") as String
        def params = request.getJSON()
        def empresa_id = params["empresa_id"] as Integer
        def empresa_nombre = params["empresa_nombre"] as String
        def ret = empresaService.postEmpresa(empresa_id , empresa_nombre)
        render (ret as JSON)
    }

    def get(){
        if (request.getParameter("empresa_id") != null){
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
        def empresa_nombre = request.getJSON()["empresa_nombre"] as String
        //def params = request.getParameterMap()
        //println("parametros: ${params}")
       if (empresa_id != null){
            if (empresa_nombre != null) {
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
}

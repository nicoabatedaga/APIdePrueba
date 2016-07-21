package apideprueba

import grails.converters.JSON

class EmpresaController {

    def empresaService

    def index() { }

    def save(){
        println("Save ")
        def param = request.getJSON()
        def empresa_id = param["empresa_id"] as Integer
        def empresa_nombre = param["empresa_nombre"] as String
        def ret = empresaService.postEmpresa(empresa_id , empresa_nombre)
        println("save empresa successful $ret")
//        return (ret as JSON)
        render(ret as JSON).toString()
    }

    def get(){
        def ret
        if (getParams()["empresa_id"] != null){
            //empid
            def empresa_id = getParams()["empresa_id"] as Integer
            ret = empresaService.getEmpresa(empresa_id)
        }else{
            //all
            ret = empresaService.getEmpresas()
        }
        println("get empresa successful ${ret}")
        render(ret as JSON).toString()
    }

    def update(){
        def empresa_id = getParams()["empresa_id"] as Integer
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
        def empresa_id = getParams()["empresa_id"] as Integer
        def ret = empresaService.delete(empresa_id)
        render (ret as JSON)
    }
}

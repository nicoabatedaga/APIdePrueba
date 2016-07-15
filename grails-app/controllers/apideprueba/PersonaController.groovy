package apideprueba

import grails.converters.JSON

class PersonaController {

    def personaService
    def empresaService

    def save() {
        def ret
        def empresa_id = getParams().get("empresa_id") as Integer
        if (empresaService.existe(empresa_id)) {
            def params = request.getJSON()

            def persona_nombre = params["persona_nombre"] as String
            def persona_dni = params["persona_dni"] as Integer
            def persona_email = params["persona_email"] as String

            ret = personaService.post(persona_nombre, persona_dni, persona_email, empresaService.getEmpresa(empresa_id).response as Empresa)
        }else{
            ret = [status: 400, response: [message: "No existe la empresa con id: ${empresa_id}"]]
        }

        render(ret as JSON)
    }

    def get() {
        def ret
        def empresa_id = getParams().get("empresa_id") as Integer
        def persona_dni = getParams().get("persona_dni") as Integer
        if (empresaService.existe(empresa_id)) {
            def empresa = empresaService.getEmpresa(empresa_id).response as Empresa
            if (persona_dni != null) {
                //persona con dni "persona_dni"
                ret = personaService.getPersona(persona_dni , empresa)
            } else {
                //all
                ret = personaService.getPersonas(empresa)
            }
        }else{
            ret = [status: 400, response: [message: "No existe la empresa con id: ${empresa_id}"]]
        }
        render(ret as JSON)
    }

    def update() {
        def persona_dni = request.getParameter("persona_dni") as Integer
        def persona_nombre = request.getParameter("persona_nombre") as String
        def persona_email = request.getParameter("persona_email") as String
        def nuevosDatos = [:]
        if (persona_dni != null) {
            if (persona_nombre != null)
                nuevosDatos["persona_nombre"] = persona_nombre
            if (persona_email != null)
                nuevosDatos["persona_email"] = persona_email
            if (nuevosDatos.isEmpty())
                render([status: 400, response: [message: "No se especificaron datos para actualizar"]] as JSON)
            else{
                def ret = personaService.update(persona_dni , nuevosDatos)
                render(ret as JSON)
            }
        } else {
            render([status: 400, response: [message: "No se especifico el dni de la persona a actualizar"]] as JSON)
        }
    }

    def delete() {
        def ret
        def empresa_id = getParams().get("empresa_id") as Integer
        def persona_dni = getParams().get("persona_dni") as Integer
        if (empresaService.existe(empresa_id)) {
            def empresa = empresaService.getEmpresa(empresa_id).response as Empresa
            ret = personaService.delete(persona_dni , empresa)
        }else{
            ret = [status: 400, response: [message: "No existe la empresa con id: ${empresa_id}"]]
        }
        render(ret as JSON)
    }
}
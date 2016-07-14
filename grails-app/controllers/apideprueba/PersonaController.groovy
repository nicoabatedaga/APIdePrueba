package apideprueba

import grails.converters.JSON

class PersonaController {

    def index() {
        render "index personaController"
    }

    def personaService

    def save() {
        def nombre = request.getParameter("persona_nombre") as String
        def dni = request.getParameter("persona_dni") as Integer
        def email = request.getParameter("persona_email") as String

        def ret = personaService.post(nombre, dni, email)

        render(ret as JSON)
    }

    def get() {
        if (request.parameterMap.get("persona_dni") != null) {
            //persona con dni "persona_dni"
            def persona_dni = request.getParameter("persona_dni") as Integer
            def ret = personaService.getPersona(persona_dni)
            render(ret as JSON)
        } else {
            //all
            def ret = personaService.getPersonas()
            render(ret as JSON)
        }
    }

    /*
    *
    * VER ESTE CASO DEL UPDATE HAY QUE AGREGAR EL MAIL
    *
    */
    /*def update() {
        def persona_dni = request.getParameter("persona_dni") as Integer
        def persona_nombre = request.getParameter("persona_nombre") as String
        def persona_email = request.getParameter("persona_mail") as String
        if (persona_dni != null) {
            if (empresa_nombre != null) {
                println("antes de el service ${persona_dni} ---- ${empresa_nombre}")
                def ret = personaService.updatePersona_nombre(persona_dni, persona_nombre)
                render(ret as JSON)
            } else {
                render([status: 400, response: [message: "No se especifico el nuevo nombre"]] as JSON)
            }
        } else {
            render([status: 400, response: [message: "No se especifico el dni de la persona a actualizar"]] as JSON)
        }
    }
    */

    def delete() {
        def persona_dni = request.getParameter("persona_dni") as Integer
        def ret = personaService.delete(persona_dni)
        render(ret as JSON)
    }
}
package apideprueba

import grails.transaction.Transactional

@Transactional
class PersonaService {

    def serviceMethod() {

    }

    def post(String nombre, Integer dni, String email){
        if (Persona.find("from Persona as b where b.persona_dni = ${dni}") != null) {
            return [status: 404, response: [message: "dni: ${dni}, ya existente."]]
        }
        else {
            if (Persona.find("from Persona as b where b.persona_email = '${email}'") != null)
                return [status: 404, response: [message: "email: ${email}, ya registrado."]]
            else {
                Persona p = new Persona()
                p.persona_nombre = nombre
                p.persona_dni = dni
                p.persona_email = email
                p.save(flush: true)
                return [status: 201, response: [nombre: p.persona_nombre , dni: p.persona_dni , email: p.persona_email]]
            }
        }
    }

    def getPersona(Integer persona_dni){
        def queryResult = Persona.find("from Persona as b where b.persona_dni = ${persona_dni}")
        if (queryResult == null)
            return ([status: 400 , response: [message: "No se encontro la persona con dni: ${persona_dni}"]])
        else
            return ([status: 200 , response: queryResult?.properties])
    }

    def getPersonas(){
        def queryResult =  (Persona.getAll())
        if (queryResult == [])
            return ([status: 400 , response: [message: "No se encontraron personas registradas"]])
        else {
            def obj = []
            def it = queryResult.iterator()
            while (it.hasNext())
                obj << it.next().properties
            return ([status: 200, response: [obj]])
        }
    }

    def delete(Integer persona_dni){
        def queryResult = Persona.find("from Persona as b where b.persona_dni = ${persona_dni}")
        if (queryResult != null){
            queryResult.delete()
            return ([status: 200 , response: [message: "Persona con dni: ${persona_dni} eliminada correctamente"]])
        }else{
            return ([status: 400 , response: [message: "No se encontro la persona con dni: ${persona_dni}"]])
        }
    }
}

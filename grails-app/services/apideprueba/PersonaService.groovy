package apideprueba

import grails.transaction.Transactional

@Transactional
class PersonaService {

    def serviceMethod() {

    }

    def post(String nombre, Integer dni, String email, Empresa empresa){
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
                empresa.empleados.add(p)
                p.save(flush: true)
                return [status: 201, response: [nombre: p.persona_nombre , dni: p.persona_dni , email: p.persona_email]]
            }
        }
    }

    def getPersona(Integer persona_dni , Empresa empresa){
        def persona = Persona.find("from Persona as p where p.persona_dni = ${persona_dni}")
        if (persona != null){
            if (empresa.empleados.toList().id.contains(persona.id))
                return ([status: 200 , response: persona?.properties])
            else
                return ([status: 400 , response: [message: "No se encontro la persona con dni: ${persona_dni}"]])
        }else{
            return ([status: 400 , response: [message: "No se encuentra registrada la persona con dni: ${persona_dni}"]])
        }
    }

    def getPersonas(Empresa empresa){
        if (empresa.empleados.size() == 0)
            return ([status: 400 , response: [message: "La empresa con id:$empresa.empresa_id no tiene empleados registrados"]])
        else {
            def obj = []
            def it = empresa.empleados.toList().iterator()
            while (it.hasNext())
                obj << it.next().properties
            return ([status: 200, response: [obj]])
        }
    }

    def delete(Integer persona_dni , Empresa empresa){
        def persona = Persona.find("from Persona as p where p.persona_dni = ${persona_dni}")
        if (persona != null){
            if (empresa.empleados.toList().id.contains(persona.id)){
                empresa.empleados.remove(persona)
                persona.delete()
                return ([status: 200 , response: [message: "Persona con dni: ${persona.persona_dni} eliminada correctamente"]])
            }else{
                return ([status: 400 , response: [message: "Se intenta remover una persona con dni $persona.persona_dni de la empresa con id:$empresa.empresa_id de la cual no es empleado"]])
            }
        }else{
            return ([status: 400 , response: [message: "No se encontro la persona con dni: ${persona_dni}"]])
        }
    }

    def update(Integer persona_dni , LinkedHashMap datosAActualizar){
        def queryResult = Persona.find("from Persona as b where b.persona_dni = ${persona_dni}")
        if (queryResult != null){
            if (datosAActualizar.get("persona_nombre") != null)
                queryResult.persona_nombre = datosAActualizar.get("persona_nombre") as String
            if (datosAActualizar.get("persona_email") != null)
                queryResult.persona_email = datosAActualizar.get("persona_email") as String
            queryResult.save()
            return ([status: 200 , response: [message: "Persona con dni: ${persona_dni} actualizada correctamente"]])
        }else{
            return ([status: 400 , response: [message: "No se encontro la persona con dni: ${persona_dni}"]])
        }
    }
}

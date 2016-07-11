package apideprueba

class PersonaController {

    static allowedMethods = [get: "GET", save: "POST", update: "PUT", delete: "DELETE"]

    def index() { }

    def get(Persona personaInstance){
        respond(personaInstance)
    }

    def create(){
        
    }
    //def save(){}
    //def update(){}
    //def delete(){}

}

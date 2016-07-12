package apideprueba

class PersonaController {

    //static allowedMethods = [get: "GET", save: "POST", update: "PUT", delete: "DELETE"]
    static allowedMethods = [save: "POST" , get: "GET"]

    def index() {
        render "index personaController"
    }

    def get(Integer dni){
        render
    }

//    def create(){
//        respond new Persona(params)
//    }
    def save(){
        //String nombre, Integer dni, String email
        respond new Persona(nombre, dni, email)
        render "La persona con nombre: "+nombre+"\ndni: "+dni+"\nemail: "+email
    }
    //def update(){}
    //def delete(){}

}

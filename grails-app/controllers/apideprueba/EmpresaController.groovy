package apideprueba

class EmpresaController {

    static allowedMethods = [get: "GET", save: "POST", update: "PUT", delete: "DELETE"]

    def index() { }

    def saludar(){
        render "Este es el controlador de empresa"
    }

    def get(Integer dni){
        def empresaService
        Persona p = empresaService.getEmpleado(dni)
        render p.getNombre()
    }
    //def save(){}
    //def update(){}
    //def delete(){}
}

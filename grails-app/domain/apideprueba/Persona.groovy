package apideprueba

class Persona {

    static belongsTo = Empresa
    String nombre
    Integer dni
    String email


    static constraints = {
        nombre(size: 3..50)
        dni(range: 1000000..60000000)
        email(email: true)
    }

    public Persona(String nombre, Integer dni, String email){
        this.nombre = nombre
        this.dni = dni
        this.email = email
    }

    public getNombre(){
        return this.nombre
    }
    public getDni(){
        return this.dni
    }
    public getEmail(){
        return this.email
    }
}

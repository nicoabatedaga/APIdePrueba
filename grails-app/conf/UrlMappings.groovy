class UrlMappings {

	static mappings = {
        /*"/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }*/

        "/empresas/$empresa_id/personas/$persona_dni"(controller:"persona", parseRequest:true){
            action = [GET:"get", PUT:"update", DELETE: "delete"]
        }

        "/empresas/$empresa_id/personas"(controller:"persona", parseRequest:true){
            action = [POST:"save" , GET:"get"]
        }

        "/empresas/$empresa_id"(controller:"empresa", parseRequest:true){
            action = [GET:"get", PUT:"update", DELETE: "delete"]
        }

        "/empresas"(controller:"empresa", parseRequest:true){
            action = [POST:"save" , GET:"get"]
        }

        //"/"(view:"/index")
        "500"(view:'/error')
	}
}

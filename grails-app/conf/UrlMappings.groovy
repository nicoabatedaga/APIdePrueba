class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //empresa - POST, GET ALL
        //empresa/$empresa_id - GET ID , PUT, DELETE

        //empresa/$empresa_id/persona - POST PERSONA , GET ALL PERSONA DE EMPRESA
        //empresa/$empresa_id/persona/$persona_id - GET , PUT, DELETE (PERSONA ID de la empresa)

        "/"(view:"/index")
        "500"(view:'/error')
	}
}

package apideprueba

import grails.transaction.Transactional

import java.awt.List

@Transactional
class EmpresaService {

    def serviceMethod() {
    }

    def postEmpresa(Integer empid , String empnom){
        if (Empresa.find("from Empresa as b where b.empresa_id = ${empid}") != null)
            return [status: 404, response: [message: "id: ${empid}, ya existente."]]
        else {
            Empresa e = new Empresa()
            e.empresa_id = empid
            e.empresa_nombre = empnom
            e.save(flush: true)
            return [status: 201, response: [empresa_id: e.empresa_id, empresa_nombre: e.empresa_nombre]]
        }
    }

    def getEmpresa(Integer empid){
        def query = Empresa.find("from Empresa as b where b.empresa_id = ${empid}")
        if (query == null)
            return ([status: 400 , response: [message: "No se encontro la empresa con id: ${empid}"]])
        else
            return ([status: 200 , response: query?.properties])
    }

    def getEmpresas(){
        def query =  (Empresa.getAll())
        if (query == [])
            return ([status: 400 , response: [message: "No se encontraron empresas registradas"]])
        else {
            def obj = []
            def it = query.iterator()
            while (it.hasNext())
                obj << it.next().properties
            return ([status: 200, response: [obj]])
        }
    }

    def delete(Integer empresa_id){
        def queryResult = Empresa.find("from Empresa as b where b.empresa_id = ${empresa_id}")
        if (queryResult != null){
            queryResult.delete()
            return ([status: 200 , response: [message: "Empresa con id: ${empresa_id} eliminada correctamente"]])
        }else{
            return ([status: 400 , response: [message: "No se encontro la empresa con id: ${empid}"]])
        }
    }

    def updateEmpresa_nombre(Integer empresa_id, String empresa_nombre){
        def queryResult = Empresa.find("from Empresa as b where b.empresa_id = ${empresa_id}")
        if (queryResult != null){
            queryResult.empresa_nombre = empresa_nombre
            queryResult.save()
            return ([status: 200 , response: [message: "Empresa con id: ${empresa_id} actualizada correctamente"]])
        }else{
            return ([status: 400 , response: [message: "No se encontro la empresa con id: ${empid}"]])
        }
    }

    def existe(Integer empresa_id){
        def queryResult = Empresa.find("from Empresa as b where b.empresa_id = ${empresa_id}")
        if (queryResult != null)
            true
        else
            false
    }
}

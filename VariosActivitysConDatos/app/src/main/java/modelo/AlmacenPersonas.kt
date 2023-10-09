package modelo

object AlmacenPersonas {

    var personas =ArrayList<Persona>()

    fun anadirPersona(p:Persona){
        personas.add(p)
    }
}
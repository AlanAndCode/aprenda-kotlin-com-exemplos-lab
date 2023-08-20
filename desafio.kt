// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    val nivel: Nivel = gerarNivelAleatorio()
    val alunosMatriculados = mutableListOf<Aluno>()

    fun matricular(aluno: Aluno) {
        alunosMatriculados.add(aluno)
    }

    private fun gerarNivelAleatorio(): Nivel {
        val valoresNiveis = Nivel.values()
        val indiceAleatorio = Random.nextInt(valoresNiveis.size)
        return valoresNiveis[indiceAleatorio]
    }
}

fun main() {
    // Criar alguns objetos de ConteudoEducacional
    val conteudo1 = ConteudoEducacional("Kotlin desenvolvimento de apps")
    val conteudo2 = ConteudoEducacional("programaçao de apps")


    // Criar uma formação e adicionar conteúdos
    val formacao = Formacao("Desenvolvimento Android", listOf(conteudo1, conteudo2))

    // Criar alguns alunos
    val aluno1 = Aluno("Alan")
    val aluno2 = Aluno("Modesto")


    // Matricular os alunos na formação
    formacao.matricular(aluno1)
    formacao.matricular(aluno2)

    // Verificar os alunos matriculados na formação
    println("Alunos matriculados na formação ${formacao.nome} de nível ${formacao.nivel}:")
    for (aluno in formacao.alunosMatriculados) {
        println(aluno.nome)
    }
}

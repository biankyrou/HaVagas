package com.example.havagas

class Form(
    var nome : String,
    var email : String,
    var desejaAtOportunidadeEmail : Boolean,
    var telefone : String,
    var telefoneTipo : String,
    var desejaAdicionarCelular : Boolean,
    var telefoneCelular : String,
    var sexo : String,
    var dataNascimento: String,
    var formacao: String,
    var anoFormaçao : String,
    var anoConclusao: String,
    var instituicao : String,
    var tituloMonografia : String,
    var orientador : String,
    var vagasInteresse: String
){

    override fun toString(): String {
        return "Nome: '$nome\n' Email: '$email\n' Deseja receber e-mails com atualizações de oportunidades? $desejaAtOportunidadeEmail\n " +
                "Telefone: '$telefone\n' Tipo de Telefone: '$telefoneTipo\n' Deseja adicionar telefone celular? '$desejaAdicionarCelular\n' " +
                "Celular: '$telefoneCelular\n' Sexo: '$sexo\n', Data de Nascimento: '$dataNascimento\n' Formação: '$formacao\n' " +
                "Ano de Formação: '$anoFormaçao\n' Ano de Conclusão: '$anoConclusao\n' Instituição: '$instituicao\n' " +
                "Titulo da Monografia: '$tituloMonografia\n' Orientador: '$orientador\n' Vagas de Intresse: '$vagasInteresse\n'"
    }
}
package br.com.rafaeldias.ondeeh.network

import br.com.rafaeldias.ondeeh.model.Endereco
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoAPI {

    @GET("/ws/{cep}/json")
    fun pesquisar(@Path("cep")cep: String) : Observable<Endereco>
}
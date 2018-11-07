package br.com.rafaeldias.ondeeh.ui.pesquisa

import br.com.rafaeldias.ondeeh.base.BaseView
import br.com.rafaeldias.ondeeh.model.Endereco

interface PesquisaView : BaseView {
    fun atualizaEndereco(endereco: Endereco)

    fun showErro(erro: String)

    fun showLoading()

    fun hideLoading()
}
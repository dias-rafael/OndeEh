package br.com.rafaeldias.ondeeh.ui.pesquisa

import br.com.rafaeldias.ondeeh.base.BasePresenter
import br.com.rafaeldias.ondeeh.network.EnderecoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PesquisaPresenter(pesquisaView: PesquisaView): BasePresenter<PesquisaView>(pesquisaView) {

    @Inject
    lateinit var enderecoAPI: EnderecoAPI

    private var subscription: Disposable? = null

    fun pesquisar(cep: String) {
        view.showLoading()
        subscription = enderecoAPI
                .pesquisar(cep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate{view.hideLoading()}
                .subscribe(
                        {endereco -> view.atualizaEndereco(endereco)},
                        {view.showErro("Erro desconhecido")}
                )
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription?.dispose()
    }
}

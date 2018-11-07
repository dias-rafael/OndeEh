package br.com.rafaeldias.ondeeh.base

import br.com.rafaeldias.ondeeh.injection.component.DaggerPresenterInjector
import br.com.rafaeldias.ondeeh.injection.component.PresenterInjector
import br.com.rafaeldias.ondeeh.injection.module.ContextModule
import br.com.rafaeldias.ondeeh.injection.module.NetworkModule
import br.com.rafaeldias.ondeeh.ui.pesquisa.PesquisaPresenter

abstract class BasePresenter <out V: BaseView> (protected val view: V) {
    //classe abstrata nao consegue criar instancia

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated() {

    }

    open fun onViewDestroyed() {

    }

    private fun inject() {
        when(this) {
            is PesquisaPresenter -> injector.inject(this)
        }
    }
}
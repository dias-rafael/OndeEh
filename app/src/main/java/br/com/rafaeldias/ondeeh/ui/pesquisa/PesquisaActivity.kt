package br.com.rafaeldias.ondeeh.ui.pesquisa

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.rafaeldias.ondeeh.R
import br.com.rafaeldias.ondeeh.base.BaseActivity
import br.com.rafaeldias.ondeeh.model.Endereco

class PesquisaActivity : BaseActivity<PesquisaPresenter>(),PesquisaView {
    override fun atualizaEndereco(endereco: Endereco) {
        Toast.makeText(this,endereco.logradouro,Toast.LENGTH_SHORT).show()
    }

    override fun showErro(erro: String) {
        Toast.makeText(this,erro,Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        Toast.makeText(this,"Carregando",Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        Toast.makeText(this,"Fui",Toast.LENGTH_SHORT).show()
    }

    override fun instantiatePresenter(): PesquisaPresenter {
        return PesquisaPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        presenter.pesquisar("11013020")
    }
}

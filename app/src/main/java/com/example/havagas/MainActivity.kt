package com.example.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.example.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        var telefoneTipo = ""
        var sexo = ""

        amb.salvarBt.setOnClickListener {
            telefoneTipo = if (amb.residencialRb.isChecked) {
                "Residencial"
            } else {
                "Comercial"
            }
            sexo = if (amb.femininoRb.isChecked) {
                "Feminino"
            } else {
                "Masculino"
            }

            val formulario = Form(
                amb.inputNameEt.text.toString(),
                amb.inputEmailEt.text.toString(),
                amb.emailCb.isChecked,
                amb.inputTelefoneEt.text.toString(),
                telefoneTipo,
                amb.telefoneCelularCb.isChecked,
                amb.telefoneCelularEt.text.toString(),
                sexo,
                amb.inputDataNascimentoEt.text.toString(),
                amb.formacaoSpinner.selectedItem.toString(),
                amb.anoFormacaoEt.text.toString(),
                amb.anoConclusaoEt.text.toString(),
                amb.instituicaoEt.text.toString(),
                amb.tituloMonografiaEt.text.toString(),
                amb.orientadorEt.text.toString(),
                amb.vagasInteresseEt.text.toString()
            )

            AlertDialog.Builder(this)
                .setTitle("Os dados foram preenchidos com sucesso!")
                .setMessage(formulario.toString())
                .setPositiveButton("Fechar", null)
                .show()
        }

        amb.telefoneCelularCb.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Checkbox 'Telefone Celular' marcado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Checkbox 'Telefone Celular' desmarcado", Toast.LENGTH_SHORT).show()
            }
        }

        amb.formacaoSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0, 1 -> {
                        amb.fundamentalAndMedioLt.visibility = View.VISIBLE
                        amb.graduacaoAndEspecializacaoLt.visibility = View.GONE
                        amb.mestradoAndDoutoradoLt.visibility = View.GONE
                    }
                    2, 3 -> {
                        amb.graduacaoAndEspecializacaoLt.visibility = View.VISIBLE
                        amb.fundamentalAndMedioLt.visibility = View.GONE
                        amb.mestradoAndDoutoradoLt.visibility = View.GONE
                    }
                    4, 5 -> {
                        amb.mestradoAndDoutoradoLt.visibility = View.VISIBLE
                        amb.graduacaoAndEspecializacaoLt.visibility = View.VISIBLE
                        amb.fundamentalAndMedioLt.visibility = View.GONE
                    }
                    else -> {
                        amb.fundamentalAndMedioLt.visibility = View.GONE
                        amb.graduacaoAndEspecializacaoLt.visibility = View.GONE
                        amb.mestradoAndDoutoradoLt.visibility = View.GONE
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                amb.anoFormacaoEt.visibility = View.GONE
                amb.anoConclusaoEt.visibility = View.GONE
                amb.instituicaoEt.visibility = View.GONE
                amb.tituloMonografiaEt.visibility = View.GONE
                amb.orientadorEt.visibility = View.GONE
            }
        }

        amb.limparBt.setOnClickListener {
            amb.inputNameEt.text.clear()
            amb.inputEmailEt.text.clear()
            amb.emailCb.isChecked = false
            amb.inputTelefoneEt.text.clear()
            amb.residencialRb.isChecked = false
            amb.comercialRb.isChecked = false
            amb.telefoneCelularCb.isChecked = false
            amb.telefoneCelularEt.text.clear()
            amb.masculinoRb.isChecked = false
            amb.femininoRb.isChecked = false
            amb.inputDataNascimentoEt.text.clear()
            amb.formacaoSpinner.setSelection(0)
            amb.anoFormacaoEt.text.clear()
            amb.anoConclusaoEt.text.clear()
            amb.instituicaoEt.text.clear()
            amb.tituloMonografiaEt.text.clear()
            amb.orientadorEt.text.clear()
            amb.vagasInteresseEt.text.clear()
        }
    }
}

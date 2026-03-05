package dam_a51706.helloworld

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        println(getString(R.string.activity_oncreate_msg, this@MainActivity.localClassName))

        var night_mode: Boolean //variável que indica se o dark mode está ativo
        //Shared preferences permite guardar preferências do utilizador através de pares chave-valor
        //O seu editor, permite editar estes pares de preferências de modo mais cotrolado.
        var editor: SharedPreferences.Editor
        val sharedPreferences: SharedPreferences= getSharedPreferences("MODE", MODE_PRIVATE)
        night_mode= sharedPreferences.getBoolean("night_mode", false) //Obter a preferência de dark mode. Se não existir ainda, vai ser considerada como falsa.


        val switch= findViewById<Switch>(R.id.switch2)
        //Se a preferência obtida indicar que o utilizador prefere o dark mode, colocar o switch ativo
        //e indicar que queremos a nossa aplicação no dark mode definido em "themes.xml (night)"
        if(night_mode){
            switch.setChecked(true)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        //Se durante a execução da aplicação, o utilizador clicar no switch, temos de ver o estado em
        //que se encontrava o switch antes de ser clicado (night_mode) para indicar se devemos ativar
        //ou desativar o dark mode e temos de guardar a nova preferência do utilizador.
        switch.setOnClickListener {
            if(night_mode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor= sharedPreferences.edit()
                editor.putBoolean("night_mode", false)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor= sharedPreferences.edit()
                editor.putBoolean("night_mode", true)
            }
            editor.apply()
        }
    }
}
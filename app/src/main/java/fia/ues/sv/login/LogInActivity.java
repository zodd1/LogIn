package fia.ues.sv.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);
    EditText usuario;
    EditText pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        usuario = (EditText) findViewById(R.id.textUser);
        pass = (EditText) findViewById(R.id.textPassword);

    }
    @Override
    public void onBackPressed() {
    }

    public void loginClick(View v){



        boolean encontrado=false;

        encontrado = helper.checkUsuario(usuario.getText().toString(),pass.getText().toString());

        Usuario user = helper.consultarUsuario(usuario.getText().toString());


        if(encontrado){

            try{
                Class<?> clase=Class.forName("fia.ues.sv.login.MainMenuActivity");

                Intent inte = new Intent(this,clase);

                inte.putExtra("id",user.getIdUsuario());
                this.startActivity(inte);

            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            Toast.makeText(this,"Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }

    }
    public void llenar(View v){
        String mensaje = null;
        mensaje = helper.llenarDatosPrueba();
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }

}

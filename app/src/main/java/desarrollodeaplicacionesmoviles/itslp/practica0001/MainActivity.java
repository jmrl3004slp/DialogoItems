package desarrollodeaplicacionesmoviles.itslp.practica0001;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaración de variables
        Button botonAbrir = findViewById(R.id.unboton);
        final TextView txtMensaje =  findViewById(R.id.textView);
        Button botonabriractividad = findViewById(R.id.btnAbrirActividad);

        botonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //Establecer características del cuadro de diálogo
                builder.setTitle("Este es un diálogo con botones");
                builder.setMessage("¿Desea salir del sistema");
                builder.setCancelable(false);

                //Programar botones de diálogo
                // Boton ACEPTAR
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                                                              txtMensaje.setText("Botón SÍ Pulsado");
                                                              MainActivity.this.finish();
                                                          }//OnClick
                                                      }
                                              );

                                              //Bot+on Neutral

                                              builder.setNeutralButton ("Botón Neutro Pulsado",
                                                      new DialogInterface.OnClickListener(){
                                                          @Override
                                                          public void onClick(DialogInterface dialog, int which) {
                                                              txtMensaje.setText("Botón Neutro Pulsado");
                                                          }
                                                      });
                                              //Bot+on Negación

                                              builder.setNegativeButton ("No",
                                                      new DialogInterface.OnClickListener(){
                                                          @Override
                                                          public void onClick(DialogInterface dialog, int which) {
                                                              txtMensaje.setText("Botón NO Pulsado");
                                                          }
                                                      });

                                              //MOSTRAR DIÁLOGO
                                              AlertDialog alertDialog =
                                                      builder.create();

                                              alertDialog.show();


                                          }//onClick
                                      }//onClickListener
        );

        botonabriractividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogItems.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }//onCreate
}
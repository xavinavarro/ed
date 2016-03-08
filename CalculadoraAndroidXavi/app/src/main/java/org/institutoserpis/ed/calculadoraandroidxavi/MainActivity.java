package org.institutoserpis.ed.calculadoraandroidxavi;
       import android.app.Activity;
        import android.os.Bundle;
        import android.widget.*;
        import android.view.*;

public class MainActivity extends Activity {

        private double valor_a, valor_b;
        private EditText op_a, op_b;
        private TextView resultado;

                public void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);

                    this.op_a = (EditText) findViewById(R.id.op_a);
                    this.op_b = (EditText) findViewById(R.id.op_b);
                    this.resultado = (TextView) findViewById(R.id.resultado);
                }
            public void cSumar(View view) {
        if(this.op_a.getText().toString().length() > 0 && this.op_b.getText().toString().length() > 0) {
            this.valor_a = Double.parseDouble(this.op_a.getText().toString());
            this.valor_b = Double.parseDouble(this.op_b.getText().toString());
            this.resultado.setText(Double.toString((this.valor_a + this.valor_b)));
            }
        }

        public void cRestar(View view) {
        if(this.op_a.getText().toString().length() > 0 && this.op_b.getText().toString().length() > 0) {
            this.valor_a = Double.parseDouble(this.op_a.getText().toString());
            this.valor_b = Double.parseDouble(this.op_b.getText().toString());
            this.resultado.setText(Double.toString((this.valor_a - this.valor_b)));
            }
        }

            public void cMultiplicar(View view) {
        if(this.op_a.getText().toString().length() > 0 && this.op_b.getText().toString().length() > 0) {
            this.valor_a = Double.parseDouble(this.op_a.getText().toString());
            this.valor_b = Double.parseDouble(this.op_b.getText().toString());
            this.resultado.setText(Double.toString((this.valor_a * this.valor_b)));
        }
        }

        public void cDividir(View view) {
        if(this.op_a.getText().toString().length() > 0 && this.op_b.getText().toString().length() > 0) {
            this.valor_a = Double.parseDouble(this.op_a.getText().toString());
            this.valor_b = Double.parseDouble(this.op_b.getText().toString());
            if(this.valor_b != 0) {
                this.resultado.setText(Double.toString((this.valor_a / this.valor_b)));
               }
            else {
                this.resultado.setText("Infinito");
                }
            }
        }
}
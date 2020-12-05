package br.com.local.listaplanetaapp2h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declarar a variável que irá receber a ListView do XML
    ListView listView;
    //Criar os arrays que serão inseridos na listView

    String nomePlanetas[] = {"1984", "A Coragem De Não Agradar", "A Garota Do Lago",
            "A Rainha Vermelha", "A seleção", "Admiravel Mundo Novo", "As Cronicas De Narnia",
            "Caixa de Passaros", "Harry Potter: O prisioneiro de Azkaban", "Homo", "It: A Coisa",
            "O Conto da Aia", "O Hobbit", "O Labirinto do Fauno", "O Morro Dos Ventos Uivantes",
            "O Poder da Ação", "O Poder Do Agora", "O Poder Do Habito", "Seja o Amor da Sua Vida",
            "Uma Breve Historia do tempo"};

    int imgPlanetas[] = {R.drawable.orwell_1984, R.drawable.a_coragem_de_nao_agradar,
            R.drawable.a_garota_do_lago, R.drawable.a_rainha_vermelha, R.drawable.a_selecao,
            R.drawable.admiravel_mundo_novo, R.drawable.as_cronicas_de_narnia,
            R.drawable.caixa_de_passaros, R.drawable.harry_potter_e_o_prisioneiro_de_azkaban,
            R.drawable.homo_deus, R.drawable.it_a_coisa, R.drawable.o_conto_da_aia, R.drawable.o_hobbit,
            R.drawable.o_labirinto_do_fauno, R.drawable.o_morro_dos_ventos_uivantes,
            R.drawable.o_poder_da_acao, R.drawable.o_poder_do_agora, R.drawable.o_poder_do_habito,
            R.drawable.seja_o_amor_da_sua_vida, R.drawable.uma_breve_historia_do_tempo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //a variavel listview está recebendo a listView XML
        listView = findViewById(R.id.listaPlanetas);

        //Criar o objeto/classe que irá inserir o modelo na listView

        CustomAdapter customAdapter = new CustomAdapter();

        //Carregar o baseAdapter na listView
        listView.setAdapter(customAdapter);

        //Criando evento de click na listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),VisualizaPlaneta_MainActivity.class);
                //Passando valores de uma janela para outra
                intent.putExtra("nomePlaneta",nomePlanetas[i]);
                intent.putExtra("imagemPlaneta",imgPlanetas[i]);

                startActivity(intent);

            }
        });


    }

    //inner class - Classe dentro de outra Classe
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgPlanetas.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Montar o modelo para ser inserido na lista de planetas - ListView
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView txtNomePlaneta;
            ImageView imagemPlaneta;

            //instanciando o modelo com os componentes para inserir na Lista
            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_planetas, null);

            txtNomePlaneta = carregaView.findViewById(R.id.txtListaPlaneta);
            imagemPlaneta = carregaView.findViewById(R.id.imgListaPlaneta);

            //Carregando os valores nos componentes

            txtNomePlaneta.setText(nomePlanetas[i]);
            imagemPlaneta.setImageResource(imgPlanetas[i]);

            return carregaView;
        }
    }
}
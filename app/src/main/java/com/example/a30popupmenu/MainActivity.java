package com.example.a30popupmenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> {
            showPopupMenu(v);
        });
    }

    private PopupMenu.OnMenuItemClickListener mOnMenuItemClickListener = new PopupMenu.OnMenuItemClickListener() {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.menu_reply) {
                Toast.makeText(MainActivity.this, "REPLY", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.menu_reply_all) {
                Toast.makeText(MainActivity.this, "REPLY ALL", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.menu_forward) {
                Toast.makeText(MainActivity.this, "FORWARD", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                return false;
            }
        }
    };

    //Este metodo tiene que saltar cuando clickamos en la imagen del boton
    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.inflate(R.menu.menu_popup);
        popup.setOnMenuItemClickListener(mOnMenuItemClickListener);
        popup.show();
    }
}
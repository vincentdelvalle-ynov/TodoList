package dev.vince.exercices.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView todoListView;
    private Button addView;
    private LinkedList<Todo> todoList;
    private TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoListView = (ListView) findViewById(R.id.todoListView);
        addView = (Button) findViewById(R.id.addView);

        todoList = new LinkedList<>();
        adapter = new TodoAdapter(this, todoList);
        todoListView.setAdapter(adapter);

        addView.setOnClickListener(this);


        todoListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CreateTodoActivity.class);

        startActivityForResult(intent, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == 1234 && data != null){
            Bundle extras = data.getExtras();

            Todo newTodo = new Todo();

            newTodo.name = extras.getString("name");
            newTodo.priorityEnum = Enum.valueOf(PriorityEnum.class, extras.getString("priority"));

            todoList.add(newTodo);
            adapter.notifyDataSetChanged();;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Todo todo = adapter.getItem(position);

        todo.isDone = !todo.isDone;

        adapter.notifyDataSetChanged();
    }
}

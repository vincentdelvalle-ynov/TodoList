package dev.vince.exercices.todolist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<Todo> {
    public TodoAdapter(@NonNull Context context, @NonNull List<Todo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(getContext(), R.layout.item_todo, null);
        }

        TextView nameView = (TextView) convertView.findViewById(R.id.nameView);
        ImageView isDoneView = (ImageView) convertView.findViewById(R.id.isDoneView);

        Todo currentTodo = getItem(position);

        nameView.setText(currentTodo.name);
        int v = currentTodo.isDone ? View.VISIBLE : View.INVISIBLE;
        isDoneView.setVisibility(v);

        Helper helper = Helper.getInstance();
        convertView.setBackgroundResource(helper.getPriorityColorResource(currentTodo.priorityEnum));

        return convertView;
    }
}

package com.android.mobilechat.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.mobilechat.R;
import com.android.mobilechat.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    private static final int MSG_TYPE_SENT = 1;
    private static final int MSG_TYPE_RECEIVED = 2;

    @Getter
    private List<Message> messages;

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);

        switch (message.getMessageType()) {
            case SENT:
                return MSG_TYPE_SENT;
            case RECEIVED:
                return MSG_TYPE_RECEIVED;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;

        switch (viewType) {
            case MSG_TYPE_SENT:
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_message_sent, viewGroup, false);
                return new ViewHolder(view);
            case MSG_TYPE_RECEIVED:
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_message_received, viewGroup, false);
                return new ViewHolder(view);
            default:
                throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Message message = messages.get(position);

        viewHolder.textViewLblFrom.setText(message.getFromName());
        viewHolder.textViewMsgFrom.setText(message.getValue());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewLblFrom;
        TextView textViewMsgFrom;

        ViewHolder(View itemView) {
            super(itemView);
            textViewLblFrom = itemView.findViewById(R.id.labelMsgFrom);
            textViewMsgFrom = itemView.findViewById(R.id.textViewMsg);
        }
    }

}

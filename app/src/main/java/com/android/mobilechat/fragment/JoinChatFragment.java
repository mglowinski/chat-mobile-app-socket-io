package com.android.mobilechat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.android.mobilechat.R;

public class JoinChatFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = JoinChatFragment.class.getName();

    private EditText nameEditText;

    public JoinChatFragment() {
    }

    public static JoinChatFragment newInstance() {
        return new JoinChatFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_join_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configureNameEditText(view);
        configureJoinButton(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void configureNameEditText(View view) {
        nameEditText = view.findViewById(R.id.name);
    }

    private void configureJoinButton(View view) {
        Button joinButton = view.findViewById(R.id.btnJoin);
        joinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnJoin:
                String userName = getValueFromEditText(nameEditText);
                loadChatFragment(addNameToBundle(userName));
                break;
        }
    }

    private String getValueFromEditText(EditText editText) {
        return editText.getText().toString().trim();
    }

    private Bundle addNameToBundle(String userName) {
        Bundle bundle = new Bundle();
        bundle.putString("userName", userName);
        return bundle;
    }

    private void loadChatFragment(Bundle bundle) {
        if (getActivity() != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            ChatFragment chatFragment = ChatFragment.newInstance();
            chatFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, chatFragment, ChatFragment.TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }
}

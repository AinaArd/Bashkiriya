package com.example.simulatorabramskogo.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;
import com.example.simulatorabramskogo.logic.Abramskiy;
import com.example.simulatorabramskogo.logic.Achievement;
import com.example.simulatorabramskogo.logic.AchievementsManager;

import org.w3c.dom.Text;

/**
 * Created by ${Aina} on 16.07.2018.
 */
public class GameOverDialog extends DialogFragment {
    TextView newGame;

    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_game_over, null);

        newGame = view.findViewById(R.id.startAgainText);

        if (Abramskiy.getInstance().getSleep() <= 0) {
            newGame.setText("Похоже, ты проиграл из-за недосыпа:( \n Хотите начать заново?");
        } else if (Abramskiy.getInstance().getMood() <= 0) {
            newGame.setText("Ты проиграл от стресса на работе :( \n Хотите начать заново?");
        } else if (Abramskiy.getInstance().getAuthority()  <= 0) {
            newGame.setText("Коллеги больше не уважают тебя :( \n Хотите начать заново?");
        }

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());

        adb.setTitle("Ты проиграл!").setView(view)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Abramskiy.getInstance().newGame();
                        AchievementsManager.getInstance().newGame();
                    }
                })
                .setNegativeButton("Нет", (dialog, which) -> dismiss());
        return adb.show();
    }

}

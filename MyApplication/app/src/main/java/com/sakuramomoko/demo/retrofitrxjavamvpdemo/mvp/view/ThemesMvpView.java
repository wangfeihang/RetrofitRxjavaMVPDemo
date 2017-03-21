package com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.view;


import com.sakuramomoko.demo.retrofitrxjavamvpdemo.entity.ThemeList;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.MvpView;

import java.util.List;

public interface ThemesMvpView extends MvpView {
    void loadThemes(List<ThemeList.Theme> themes);

    void showGetThemesFailedMsg(String message);
}

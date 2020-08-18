package com.jt.display.base;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * IBaseView
 *
 * @author 姚中平
 */

public interface IBaseView {

    void onSuccess(Object jsonResult, int type);

    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 数据获取失败
     */
    void onError(Throwable throwable);


    <T> AutoDisposeConverter<T> bindAutoDispose();

}

package com.github.dannil.productmanagement.view;

public interface View<T> {

    T toNormalView();

    T toFlatView();

}

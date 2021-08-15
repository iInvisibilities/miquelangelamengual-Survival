package es.hulk.survival.utils.menu.callback;

import java.io.Serializable;

public interface TypeCallback<T> extends Serializable
{
    void callback(final T p0);
}

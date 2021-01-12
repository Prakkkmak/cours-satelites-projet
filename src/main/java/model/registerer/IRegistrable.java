package model.registerer;

public interface IRegistrable<T extends IRegisterer>  {
    void register(T registerer);
}

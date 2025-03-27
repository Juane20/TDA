package Implementaciones.ClasesUtiles;

public class Par<T, U>{
    private T first;
    private U second;
    public Par(T first, U second){
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return first;
    }
    public U getSecond(){
        return second;
    }
}
